
package com.soap.client.generate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="BicToIntCodeResult" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
    "bicToIntCodeResult"
})
@XmlRootElement(name = "BicToIntCodeResponse")
public class BicToIntCodeResponse {

    @XmlElement(name = "BicToIntCodeResult")
    protected double bicToIntCodeResult;

    /**
     * Gets the value of the bicToIntCodeResult property.
     * 
     */
    public double getBicToIntCodeResult() {
        return bicToIntCodeResult;
    }

    /**
     * Sets the value of the bicToIntCodeResult property.
     * 
     */
    public void setBicToIntCodeResult(double value) {
        this.bicToIntCodeResult = value;
    }

}
