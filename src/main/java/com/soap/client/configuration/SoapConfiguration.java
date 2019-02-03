package com.soap.client.configuration;

import com.soap.client.connector.SoapConnector;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Configuration
public class SoapConfiguration {

    @Bean
    public JAXBContext getConext() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance("com.soap.client.generate:com.soap.client.model.xmlmodel");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return jaxbContext;
    }

    @Bean
    @Qualifier("generate")
    public Jaxb2Marshaller marshallerGenerate() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.soap.client.generate");
        return marshaller;
    }

    @Bean
    @Qualifier("model")
    public Jaxb2Marshaller marshallerModel() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.soap.client.model.xmlmodel");
        return marshaller;
    }

    @Bean
    public SoapConnector soapConnectorGenerate(@Qualifier("generate") Jaxb2Marshaller marshaller) {
        SoapConnector client = new SoapConnector();
        client.setDefaultUri("http://www.cbr.ru/CreditInfoWebServ/CreditOrgInfo.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public SoapConnector soapConnectorModel(@Qualifier("model") Jaxb2Marshaller marshaller) {
        SoapConnector client = new SoapConnector();
        client.setDefaultUri("http://www.cbr.ru/CreditInfoWebServ/CreditOrgInfo.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
