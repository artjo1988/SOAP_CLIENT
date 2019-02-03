package com.soap.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Record implements Comparable<Record> {

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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != (this.getClass()))
            return false;
        Record other = (Record) obj;
        if (!this.idGot.equals(other.idGot)) {
            return false;
        }
        if (!this.du.equals(other.du)) {
            return false;
        }
        if (!this.shortName.equals(other.shortName)) {
            return false;
        }
        return this.bic.equals(other.bic);
    }

    @Override
    public int compareTo(Record o) {
        if (this.idGot.compareTo(o.idGot) != 0) {
            return this.idGot.compareTo(o.idGot);
        }
        if (this.du.compareTo(o.du) != 0) {
            return this.du.compareTo(o.du);
        }
        if (this.shortName.compareTo(o.shortName) != 0) {
            return this.shortName.compareTo(o.shortName);
        }
        if (this.bic.compareTo(o.bic) != 0) {
            return this.bic.compareTo(o.bic);
        }
        if (this.times.size() != o.times.size()) {
            return this.times.size() - o.times.size();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Record : ID - \"" + idGot + "\", UD - \"" + du + "\" , ShortName - \"" + shortName + "\", Bic - \"" + bic
            + "\"";
    }
}
