package com.example.reprocessamento.service;

import com.example.reprocessamento.dto.EventoDTO;
import com.example.reprocessamento.model.Evento;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EventoMapperService {

    public Evento converter(EventoDTO dto) {

        Evento evento = new Evento();

        evento.setCountry(
                dto.getDocumentId().getCountry());

        evento.setDocNumber(
                dto.getDocumentId().getDocNumber());

        evento.setKind(
                dto.getDocumentId().getKind());

        evento.setPublicationDate(
                LocalDate.parse(
                        dto.getDocumentId().getDate(),
                        DateTimeFormatter.BASIC_ISO_DATE
                )
        );

        evento.setDataProcessamento(
                LocalDateTime.now());

        return evento;
    }
}