
package com.soap.client.generate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CredorgNumbers" type="{http://web.cbr.ru/}ArrayOfAnyType" minOccurs="0"/>
 *         &lt;element name="IndID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DateTo" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "credorgNumbers",
    "indID",
    "dateFrom",
    "dateTo"
})
@XmlRootElement(name = "Data101FormEx")
public class Data101FormEx {

    @XmlElement(name = "CredorgNumbers")
    protected ArrayOfAnyType credorgNumbers;
    @XmlElement(name = "IndID")
    protected int indID;
    @XmlElement(name = "DateFrom", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateFrom;
    @XmlElement(name = "DateTo", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTo;

    /**
     * Gets the value of the credorgNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAnyType }
     *     
     */
    public ArrayOfAnyType getCredorgNumbers() {
        return credorgNumbers;
    }

    /**
     * Sets the value of the credorgNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAnyType }
     *     
     */
    public void setCredorgNumbers(ArrayOfAnyType value) {
        this.credorgNumbers = value;
    }

    /**
     * Gets the value of the indID property.
     * 
     */
    public int getIndID() {
        return indID;
    }

    /**
     * Sets the value of the indID property.
     * 
     */
    public void setIndID(int value) {
        this.indID = value;
    }

    /**
     * Gets the value of the dateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFrom() {
        return dateFrom;
    }

    /**
     * Sets the value of the dateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFrom(XMLGregorianCalendar value) {
        this.dateFrom = value;
    }

    /**
     * Gets the value of the dateTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTo() {
        return dateTo;
    }

    /**
     * Sets the value of the dateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTo(XMLGregorianCalendar value) {
        this.dateTo = value;
    }

}
