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
 * <p>Java class for getSmartChoicesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSmartChoicesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="smartChoiceGroups" type="{}smartChoiceGroups" minOccurs="0"/>
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
@XmlType(name = "getSmartChoicesResponse", propOrder = {
    "smartChoiceGroups",
    "system"
})
public class GetSmartChoicesResponse {

    protected SmartChoiceGroups smartChoiceGroups;
    protected System system;

    /**
     * Gets the value of the smartChoiceGroups property.
     * 
     * @return
     *     possible object is
     *     {@link SmartChoiceGroups }
     *     
     */
    public SmartChoiceGroups getSmartChoiceGroups() {
        return smartChoiceGroups;
    }

    /**
     * Sets the value of the smartChoiceGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link SmartChoiceGroups }
     *     
     */
    public void setSmartChoiceGroups(SmartChoiceGroups value) {
        this.smartChoiceGroups = value;
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