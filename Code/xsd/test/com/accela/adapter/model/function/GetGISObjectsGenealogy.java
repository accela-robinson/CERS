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
 * <p>Java class for getGISObjectsGenealogy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getGISObjectsGenealogy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GISObjectIds" type="{}gisObjectIds" minOccurs="0"/>
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
@XmlType(name = "getGISObjectsGenealogy", propOrder = {
    "gisObjectIds",
    "system"
})
public class GetGISObjectsGenealogy {

    @XmlElement(name = "GISObjectIds")
    protected GisObjectIds gisObjectIds;
    protected System system;

    /**
     * Gets the value of the gisObjectIds property.
     * 
     * @return
     *     possible object is
     *     {@link GisObjectIds }
     *     
     */
    public GisObjectIds getGISObjectIds() {
        return gisObjectIds;
    }

    /**
     * Sets the value of the gisObjectIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link GisObjectIds }
     *     
     */
    public void setGISObjectIds(GisObjectIds value) {
        this.gisObjectIds = value;
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
