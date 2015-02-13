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
 * <p>Java class for getContacts complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getContacts">
 *   &lt;complexContent>
 *     &lt;extension base="{}operationRequest">
 *       &lt;sequence>
 *         &lt;element name="CAPId" type="{}capId" minOccurs="0"/>
 *         &lt;element name="contact" type="{}contact" minOccurs="0"/>
 *         &lt;element name="returnElements" type="{}returnElements" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getContacts", propOrder = {
    "capId",
    "contact",
    "returnElements"
})
public class GetContacts
    extends OperationRequest
{

    @XmlElement(name = "CAPId")
    protected CapId capId;
    protected Contact contact;
    protected ReturnElements returnElements;

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
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setContact(Contact value) {
        this.contact = value;
    }

    /**
     * Gets the value of the returnElements property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnElements }
     *     
     */
    public ReturnElements getReturnElements() {
        return returnElements;
    }

    /**
     * Sets the value of the returnElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnElements }
     *     
     */
    public void setReturnElements(ReturnElements value) {
        this.returnElements = value;
    }

}
