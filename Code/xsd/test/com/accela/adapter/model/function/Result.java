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
 * <p>Java class for result complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="result">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createdCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorMessages" type="{}errorMessages" minOccurs="0"/>
 *         &lt;element name="failedCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GISLayers" type="{}gisLayers" minOccurs="0"/>
 *         &lt;element name="gisObjectsType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updatedCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "result", propOrder = {
    "createdCount",
    "errorMessages",
    "failedCount",
    "gisLayers",
    "gisObjectsType",
    "updatedCount"
})
public class Result {

    protected String createdCount;
    protected ErrorMessages errorMessages;
    protected String failedCount;
    @XmlElement(name = "GISLayers")
    protected GisLayers gisLayers;
    protected String gisObjectsType;
    protected String updatedCount;

    /**
     * Gets the value of the createdCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedCount() {
        return createdCount;
    }

    /**
     * Sets the value of the createdCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedCount(String value) {
        this.createdCount = value;
    }

    /**
     * Gets the value of the errorMessages property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorMessages }
     *     
     */
    public ErrorMessages getErrorMessages() {
        return errorMessages;
    }

    /**
     * Sets the value of the errorMessages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorMessages }
     *     
     */
    public void setErrorMessages(ErrorMessages value) {
        this.errorMessages = value;
    }

    /**
     * Gets the value of the failedCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailedCount() {
        return failedCount;
    }

    /**
     * Sets the value of the failedCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailedCount(String value) {
        this.failedCount = value;
    }

    /**
     * Gets the value of the gisLayers property.
     * 
     * @return
     *     possible object is
     *     {@link GisLayers }
     *     
     */
    public GisLayers getGISLayers() {
        return gisLayers;
    }

    /**
     * Sets the value of the gisLayers property.
     * 
     * @param value
     *     allowed object is
     *     {@link GisLayers }
     *     
     */
    public void setGISLayers(GisLayers value) {
        this.gisLayers = value;
    }

    /**
     * Gets the value of the gisObjectsType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGisObjectsType() {
        return gisObjectsType;
    }

    /**
     * Sets the value of the gisObjectsType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGisObjectsType(String value) {
        this.gisObjectsType = value;
    }

    /**
     * Gets the value of the updatedCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdatedCount() {
        return updatedCount;
    }

    /**
     * Sets the value of the updatedCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdatedCount(String value) {
        this.updatedCount = value;
    }

}
