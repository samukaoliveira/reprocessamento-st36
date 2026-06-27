package com.example.reprocessamento.service;

import com.example.reprocessamento.dto.EventoDTO;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class XmlParserService {

    public EventoDTO ler(Path arquivo) throws Exception {

        JAXBContext context =
                JAXBContext.newInstance(EventoDTO.class);

        Unmarshaller unmarshaller =
                context.createUnmarshaller();

        return (EventoDTO)
                unmarshaller.unmarshal(
                        arquivo.toFile());
    }
}