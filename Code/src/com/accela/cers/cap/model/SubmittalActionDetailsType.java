//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.21 at 02:38:20 PM GMT+08:00 
//


package com.accela.cers.cap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubmittalActionDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubmittalActionDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubmittalActionOn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubmittalActionAgentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubmittalActionAgentEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubmittalActionComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmittalActionDetailsType", propOrder = {
    "submittalActionOn",
    "submittalActionAgentName",
    "submittalActionAgentEmail",
    "submittalActionComments"
})
public class SubmittalActionDetailsType {

    @XmlElement(name = "SubmittalActionOn")
    protected String submittalActionOn;
    @XmlElement(name = "SubmittalActionAgentName")
    protected String submittalActionAgentName;
    @XmlElement(name = "SubmittalActionAgentEmail")
    protected String submittalActionAgentEmail;
    @XmlElement(name = "SubmittalActionComments")
    protected String submittalActionComments;

    /**
     * Gets the value of the submittalActionOn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmittalActionOn() {
        return submittalActionOn;
    }

    /**
     * Sets the value of the submittalActionOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmittalActionOn(String value) {
        this.submittalActionOn = value;
    }

    /**
     * Gets the value of the submittalActionAgentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmittalActionAgentName() {
        return submittalActionAgentName;
    }

    /**
     * Sets the value of the submittalActionAgentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmittalActionAgentName(String value) {
        this.submittalActionAgentName = value;
    }

    /**
     * Gets the value of the submittalActionAgentEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmittalActionAgentEmail() {
        return submittalActionAgentEmail;
    }

    /**
     * Sets the value of the submittalActionAgentEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmittalActionAgentEmail(String value) {
        this.submittalActionAgentEmail = value;
    }

    /**
     * Gets the value of the submittalActionComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmittalActionComments() {
        return submittalActionComments;
    }

    /**
     * Sets the value of the submittalActionComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmittalActionComments(String value) {
        this.submittalActionComments = value;
    }

}
