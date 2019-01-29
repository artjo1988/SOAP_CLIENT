package com.soap.client.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@Component
@XmlRootElement(name = "BicCode")
@XmlAccessorType(XmlAccessType.FIELD)
public class BicCode {

    @XmlAttribute
    private String name="BIC CODES";

    @XmlElement(name = "Record",
            type = Record.class)
    private List<Record> list;

    @Override
    public String toString() {
        return "BIC CODES : " + list;
    }
}
