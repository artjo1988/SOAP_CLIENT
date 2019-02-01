package com.soap.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credit_organization")
@XmlType(name = "Record")
@XmlAccessorType(XmlAccessType.FIELD)
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "id_got")
	@XmlAttribute(name = "ID")
	private String idGot;

	@XmlAttribute(name = "DU")
	private String du;

    @Column(name = "short_name")
	@XmlElement(name = "ShortName")
	private String shortName;

	@XmlElement(name = "Bic")
	private String bic;

	@OneToMany(mappedBy = "owner")
	private List<Data> times;

	@Override
	public String toString() {
		return "Record : ID - \"" + id + "\", UD - \"" + du + "\" , ShortName - \"" + shortName + "\", Bic - \"" + bic
				+ "\"";
	}
}
