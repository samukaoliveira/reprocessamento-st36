package com.example.reprocessamento.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "publication-reference")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventoDTO {

    @XmlElement(name = "publication-reference")
    private PublicationReferenceDTO publicationReferenceDTO;

    @XmlElement(name = "parties")
    private PartiesDTO partiesDTO;

    @XmlElement(name = "invention-title")
    private String titulo;

    @XmlElement(name = "abstract ")
    private String descricao;

}