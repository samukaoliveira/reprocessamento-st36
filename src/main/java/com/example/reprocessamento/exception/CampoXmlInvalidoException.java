package com.example.reprocessamento.exception;

import lombok.Getter;

@Getter
public class CampoXmlInvalidoException
        extends RuntimeException {

    private final String campo;

    public CampoXmlInvalidoException(
            String campo,
            String mensagem) {

        super(mensagem);
        this.campo = campo;
    }
}