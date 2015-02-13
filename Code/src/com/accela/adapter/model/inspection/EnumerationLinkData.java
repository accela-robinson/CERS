package com.accela.adapter.model.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="nonCriticalScore" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="majorViolation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="criticalScore" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
    "nonCriticalScore",
    "majorViolation",
    "criticalScore"
})
public class EnumerationLinkData {

    @XmlSchemaType(name = "unsignedByte")
    protected short nonCriticalScore;
    @XmlElement(required = true)
    protected String majorViolation;
    @XmlSchemaType(name = "unsignedByte")
    protected short criticalScore;

    /**
     * Gets the value of the nonCriticalScore property.
     * 
     */
    public short getNonCriticalScore() {
        return nonCriticalScore;
    }

    /**
     * Sets the value of the nonCriticalScore property.
     * 
     */
    public void setNonCriticalScore(short value) {
        this.nonCriticalScore = value;
    }

    /**
     * Gets the value of the majorViolation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMajorViolation() {
        return majorViolation;
    }

    /**
     * Sets the value of the majorViolation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMajorViolation(String value) {
        this.majorViolation = value;
    }

    /**
     * Gets the value of the criticalScore property.
     * 
     */
    public short getCriticalScore() {
        return criticalScore;
    }

    /**
     * Sets the value of the criticalScore property.
     * 
     */
    public void setCriticalScore(short value) {
        this.criticalScore = value;
    }

}