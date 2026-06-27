package com.example.reprocessamento.service;

import com.example.reprocessamento.dto.EventoDTO;
import com.example.reprocessamento.model.Evento;
import com.example.reprocessamento.model.ProcessamentoLog;
import com.example.reprocessamento.repository.EventoRepository;
import com.example.reprocessamento.repository.ProcessamentoLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Slf4j
@Service
@RequiredArgsConstructor
public class XmlBatchService {

    private final XmlParserService xmlParserService;
    private final XmlValidationService xmlValidationService;
    private final EventoMapperService eventoMapperService;

    private final EventoRepository eventoRepository;
    private final ProcessamentoLogRepository logRepository;

    public void processarArquivo(Path arquivo) {

        try {

            System.out.println("Lendo arquivo...");
            EventoDTO dto = xmlParserService.ler(arquivo);

            System.out.println("Validando o XML...");
            xmlValidationService.validar(dto);

            System.out.println("Convertendo o XML...");
            Evento evento = eventoMapperService.converter(dto);

            System.out.println("Sanvando no banco...");
            eventoRepository.save(evento);

            ProcessamentoLog logSucesso =
                    ProcessamentoLog.sucesso(
                            arquivo.getFileName().toString());

            System.out.println("Criando o log...");
            logRepository.save(logSucesso);

            log.info("Arquivo {} processado com sucesso",
                    arquivo.getFileName());

        } catch (Exception e) {

            ProcessamentoLog logErro =
                    ProcessamentoLog.erro(
                            arquivo.getFileName().toString(),
                            "GERAL",
                            e.getMessage());

            logRepository.save(logErro);

            log.error("Erro ao processar arquivo {}",
                    arquivo.getFileName(), e);
        }
    }
}