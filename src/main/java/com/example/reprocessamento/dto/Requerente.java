package com.example.reprocessamento.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "applicants")
@XmlAccessorType(XmlAccessType.FIELD)
public class Requerente {

    private EnderecoDTO endereco;

    private PartiesDTO.Requerentes.PaisInventor paisInventor;

    @XmlRootElement(name = "residence")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class PaisInventor {

        @XmlElement(name = "country")
        private String pais;
    }

}
