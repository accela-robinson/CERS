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
 * <p>Java class for getInspectionsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getInspectionsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CAPs" type="{}caPs" minOccurs="0"/>
 *         &lt;element name="inspectionSheets" type="{}inspectionSheets" minOccurs="0"/>
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
@XmlType(name = "getInspectionsResponse", propOrder = {
    "caPs",
    "inspectionSheets",
    "system"
})
public class GetInspectionsResponse {

    @XmlElement(name = "CAPs")
    protected CaPs caPs;
    protected InspectionSheets inspectionSheets;
    protected System system;

    /**
     * Gets the value of the caPs property.
     * 
     * @return
     *     possible object is
     *     {@link CaPs }
     *     
     */
    public CaPs getCAPs() {
        return caPs;
    }

    /**
     * Sets the value of the caPs property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaPs }
     *     
     */
    public void setCAPs(CaPs value) {
        this.caPs = value;
    }

    /**
     * Gets the value of the inspectionSheets property.
     * 
     * @return
     *     possible object is
     *     {@link InspectionSheets }
     *     
     */
    public InspectionSheets getInspectionSheets() {
        return inspectionSheets;
    }

    /**
     * Sets the value of the inspectionSheets property.
     * 
     * @param value
     *     allowed object is
     *     {@link InspectionSheets }
     *     
     */
    public void setInspectionSheets(InspectionSheets value) {
        this.inspectionSheets = value;
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
