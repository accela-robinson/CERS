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
 * <p>Java class for getGISObjectsGenealogyResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getGISObjectsGenealogyResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gisGenealogicEvents" type="{}gisGenealogicEvents" minOccurs="0"/>
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
@XmlType(name = "getGISObjectsGenealogyResponse", propOrder = {
    "gisGenealogicEvents",
    "system"
})
public class GetGISObjectsGenealogyResponse {

    protected GisGenealogicEvents gisGenealogicEvents;
    protected System system;

    /**
     * Gets the value of the gisGenealogicEvents property.
     * 
     * @return
     *     possible object is
     *     {@link GisGenealogicEvents }
     *     
     */
    public GisGenealogicEvents getGisGenealogicEvents() {
        return gisGenealogicEvents;
    }

    /**
     * Sets the value of the gisGenealogicEvents property.
     * 
     * @param value
     *     allowed object is
     *     {@link GisGenealogicEvents }
     *     
     */
    public void setGisGenealogicEvents(GisGenealogicEvents value) {
        this.gisGenealogicEvents = value;
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