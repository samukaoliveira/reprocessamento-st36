package com.example.reprocessamento.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "parties")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartiesDTO {

    private List<Requerente> requerentes;

    private List<Inventor> inventores;
}
