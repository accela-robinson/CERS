//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.04 at 06:33:27 PM CST 
//


package com.accela.adapter.model.function;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getByCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getByCode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CAPId" type="{}capId" minOccurs="0"/>
 *         &lt;element name="ivrNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getByCode", propOrder = {
    "capId",
    "ivrNumber"
})
public class GetByCode {

    @XmlElement(name = "CAPId")
    protected CapId capId;
    protected String ivrNumber;

    /**
     * Gets the value of the capId property.
     * 
     * @return
     *     possible object is
     *     {@link CapId }
     *     
     */
    public CapId getCAPId() {
        return capId;
    }

    /**
     * Sets the value of the capId property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapId }
     *     
     */
    public void setCAPId(CapId value) {
        this.capId = value;
    }

    /**
     * Gets the value of the ivrNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIvrNumber() {
        return ivrNumber;
    }

    /**
     * Sets the value of the ivrNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIvrNumber(String value) {
        this.ivrNumber = value;
    }

}
