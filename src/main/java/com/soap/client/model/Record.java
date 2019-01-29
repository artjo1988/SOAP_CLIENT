package com.soap.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlType(name = "Record")
@XmlAccessorType(XmlAccessType.FIELD)
public class Record {

	@XmlAttribute(name = "ID")
	private String id;

	@XmlAttribute(name = "DU")
	private String du;

	@XmlElement(name = "ShortName")
	private String shortName;

	@XmlElement(name = "Bic")
	private String bic;

	@Override
	public String toString() {
		return "Record : ID - \"" + id + "\", UD - \"" + du + "\" , ShortName - \"" + shortName + "\", Bic - \"" + bic
				+ "\"";
	}
}
