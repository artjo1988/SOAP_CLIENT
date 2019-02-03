package com.soap.client.model.xmlmodel;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
public class CreditInfoByIntCodeXMLResponse {

    @NoArgsConstructor
    @XmlType
    public static class CreditInfoByIntCodeXMLResult{

        @NoArgsConstructor
        @AllArgsConstructor
        @XmlType
        public static class CreditOrgInfo{

            @XmlElement(name = "RegNumber")
            private String regNumber;
        }
    }
}
