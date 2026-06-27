package com.example.reprocessamento.scheduler;

import com.example.reprocessamento.service.XmlBatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Component
@RequiredArgsConstructor
public class XmlScheduler {

    private final XmlBatchService xmlBatchService;

    @Value("${xml.path}")
    private String xmlPath;

    @Scheduled(cron = "*/20 * * * * *")
    public void executar() {
        System.out.println("Iniciando o Reprocessamento...");
        Path pasta =
                Paths.get(xmlPath);

        try {
            System.out.println("Lendo arquivos na pasta...");
            Files.list(pasta)
                    .filter(f -> f.toString().endsWith(".xml"))
                    .forEach(xmlBatchService::processarArquivo);

        } catch (Exception e) {

            log.error("Erro ao ler diretório", e);
        }
    }
}