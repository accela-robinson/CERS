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
 * <p>Java class for postMileage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="postMileage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="distanceAndTimes" type="{}distanceAndTimes" minOccurs="0"/>
 *         &lt;element name="inspectorId" type="{}inspectorId" minOccurs="0"/>
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
@XmlType(name = "postMileage", propOrder = {
    "distanceAndTimes",
    "inspectorId",
    "system"
})
public class PostMileage {

    protected DistanceAndTimes distanceAndTimes;
    protected InspectorId inspectorId;
    protected System system;

    /**
     * Gets the value of the distanceAndTimes property.
     * 
     * @return
     *     possible object is
     *     {@link DistanceAndTimes }
     *     
     */
    public DistanceAndTimes getDistanceAndTimes() {
        return distanceAndTimes;
    }

    /**
     * Sets the value of the distanceAndTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistanceAndTimes }
     *     
     */
    public void setDistanceAndTimes(DistanceAndTimes value) {
        this.distanceAndTimes = value;
    }

    /**
     * Gets the value of the inspectorId property.
     * 
     * @return
     *     possible object is
     *     {@link InspectorId }
     *     
     */
    public InspectorId getInspectorId() {
        return inspectorId;
    }

    /**
     * Sets the value of the inspectorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link InspectorId }
     *     
     */
    public void setInspectorId(InspectorId value) {
        this.inspectorId = value;
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
