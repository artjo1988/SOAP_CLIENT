
package com.soap.client.generate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
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
 *         &lt;element name="Form101IndicatorsEnumResult" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "form101IndicatorsEnumResult"
})
@XmlRootElement(name = "Form101IndicatorsEnumResponse")
public class Form101IndicatorsEnumResponse {

    @XmlElement(name = "Form101IndicatorsEnumResult")
    protected Form101IndicatorsEnumResponse.Form101IndicatorsEnumResult form101IndicatorsEnumResult;

    /**
     * Gets the value of the form101IndicatorsEnumResult property.
     * 
     * @return
     *     possible object is
     *     {@link Form101IndicatorsEnumResponse.Form101IndicatorsEnumResult }
     *     
     */
    public Form101IndicatorsEnumResponse.Form101IndicatorsEnumResult getForm101IndicatorsEnumResult() {
        return form101IndicatorsEnumResult;
    }

    /**
     * Sets the value of the form101IndicatorsEnumResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Form101IndicatorsEnumResponse.Form101IndicatorsEnumResult }
     *     
     */
    public void setForm101IndicatorsEnumResult(Form101IndicatorsEnumResponse.Form101IndicatorsEnumResult value) {
        this.form101IndicatorsEnumResult = value;
    }


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
     *         &lt;any/>
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
        "any"
    })
    public static class Form101IndicatorsEnumResult {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * Gets the value of the any property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getAny() {
            return any;
        }

        /**
         * Sets the value of the any property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }

}
