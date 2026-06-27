package com.example.reprocessamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProcessamentoLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String arquivo;

    private String status;

    private String campo;

    private String mensagem;

    private LocalDateTime dataProcessamento;

    public static ProcessamentoLog sucesso(
            String arquivo) {

        ProcessamentoLog log =
                new ProcessamentoLog();

        log.setArquivo(arquivo);
        log.setStatus("SUCESSO");
        log.setDataProcessamento(
                LocalDateTime.now());

        return log;
    }

    public static ProcessamentoLog erro(
            String arquivo,
            String campo,
            String mensagem) {

        ProcessamentoLog log =
                new ProcessamentoLog();

        log.setArquivo(arquivo);
        log.setStatus("ERRO");
        log.setCampo(campo);
        log.setMensagem(mensagem);
        log.setDataProcessamento(
                LocalDateTime.now());

        return log;
    }
}