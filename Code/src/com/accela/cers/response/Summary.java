package com.accela.cers.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="DataProcessedOn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="ErrorSummary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="RequiredSummary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="WarningSummary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="AdvisorySummary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
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
    "dataProcessedOn",
    "errorSummary",
    "requiredSummary",
    "warningSummary",
    "advisorySummary"
})
public class Summary {

    @XmlElement(name = "DataProcessedOn")
    protected String dataProcessedOn;
    @XmlElement(name = "ErrorSummary")
    protected String errorSummary;
    @XmlElement(name = "RequiredSummary")
    protected String requiredSummary;
    @XmlElement(name = "WarningSummary")
    protected String warningSummary;
    @XmlElement(name = "AdvisorySummary")
    protected String advisorySummary;

    /**
     * Gets the value of the dataProcessedOn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataProcessedOn() {
        return dataProcessedOn;
    }

    /**
     * Sets the value of the dataProcessedOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataProcessedOn(String value) {
        this.dataProcessedOn = value;
    }

    /**
     * Gets the value of the errorSummary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorSummary() {
        return errorSummary;
    }

    /**
     * Sets the value of the errorSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorSummary(String value) {
        this.errorSummary = value;
    }

    /**
     * Gets the value of the requiredSummary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequiredSummary() {
        return requiredSummary;
    }

    /**
     * Sets the value of the requiredSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequiredSummary(String value) {
        this.requiredSummary = value;
    }

    /**
     * Gets the value of the warningSummary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarningSummary() {
        return warningSummary;
    }

    /**
     * Sets the value of the warningSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarningSummary(String value) {
        this.warningSummary = value;
    }

    /**
     * Gets the value of the advisorySummary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvisorySummary() {
        return advisorySummary;
    }

    /**
     * Sets the value of the advisorySummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvisorySummary(String value) {
        this.advisorySummary = value;
    }

}