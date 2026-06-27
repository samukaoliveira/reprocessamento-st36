package com.example.reprocessamento.service;

import com.example.reprocessamento.dto.EventoDTO;
import com.example.reprocessamento.exception.CampoXmlInvalidoException;
import org.springframework.stereotype.Service;

@Service
public class XmlValidationService {

    public void validar(EventoDTO dto) {

        if (dto.getDocumentId() == null) {
            throw new CampoXmlInvalidoException(
                    "document-id",
                    "Tag obrigatória");
        }

        if (dto.getDocumentId().getCountry() == null
                || dto.getDocumentId().getCountry().isBlank()) {

            throw new CampoXmlInvalidoException(
                    "country",
                    "Campo obrigatório");
        }

        if (dto.getDocumentId().getDocNumber() == null
                || dto.getDocumentId().getDocNumber().isBlank()) {

            throw new CampoXmlInvalidoException(
                    "doc-number",
                    "Campo obrigatório");
        }

        if (dto.getDocumentId().getDate() == null
                || dto.getDocumentId().getDate().isBlank()) {

            throw new CampoXmlInvalidoException(
                    "date",
                    "Campo obrigatório");
        }
    }
}