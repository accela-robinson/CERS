//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.04 at 06:33:27 PM CST 
//


package com.accela.adapter.model.function;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStandardChoicesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStandardChoicesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="standardChoiceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="standardChoices" type="{}enumerations" minOccurs="0"/>
 *         &lt;element name="system" type="{}system" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStandardChoicesResponse", propOrder = {
    "standardChoiceType",
    "standardChoices",
    "system"
})
public class GetStandardChoicesResponse {

    protected String standardChoiceType;
    protected Enumerations standardChoices;
    protected System system;

    /**
     * Gets the value of the standardChoiceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandardChoiceType() {
        return standardChoiceType;
    }

    /**
     * Sets the value of the standardChoiceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandardChoiceType(String value) {
        this.standardChoiceType = value;
    }

    /**
     * Gets the value of the standardChoices property.
     * 
     * @return
     *     possible object is
     *     {@link Enumerations }
     *     
     */
    public Enumerations getStandardChoices() {
        return standardChoices;
    }

    /**
     * Sets the value of the standardChoices property.
     * 
     * @param value
     *     allowed object is
     *     {@link Enumerations }
     *     
     */
    public void setStandardChoices(Enumerations value) {
        this.standardChoices = value;
    }

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link System }
     *     
     */
    public System getSystem() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link System }
     *     
     */
    public void setSystem(System value) {
        this.system = value;
    }

}
