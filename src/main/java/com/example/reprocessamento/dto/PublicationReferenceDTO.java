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
public class PublicationReferenceDTO {

    private DocumentId documentId;

    @XmlRootElement(name = "document-id")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class DocumentId {

        @XmlElement(name = "country")
        private String country;

        @XmlElement(name = "doc-number")
        private String docNumber;

        @XmlElement(name = "kind")
        private String kind;

        @XmlElement(name = "date")
        private String date;
    }
}
