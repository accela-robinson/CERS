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
 * <p>Java class for ownerHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ownerHistory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="changeAction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creationDate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="lastModifiedDate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="lastModifyingApplication" type="{}application" minOccurs="0"/>
 *         &lt;element name="lastModifyingUser" type="{}personAndOrganization" minOccurs="0"/>
 *         &lt;element name="owningApplication" type="{}application" minOccurs="0"/>
 *         &lt;element name="owningUser" type="{}personAndOrganization" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xmlns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ownerHistory", propOrder = {
    "changeAction",
    "creationDate",
    "lastModifiedDate",
    "lastModifyingApplication",
    "lastModifyingUser",
    "owningApplication",
    "owningUser",
    "state",
    "xmlns"
})
public class OwnerHistory {

    protected String changeAction;
    protected Long creationDate;
    protected Long lastModifiedDate;
    protected Application lastModifyingApplication;
    protected PersonAndOrganization lastModifyingUser;
    protected Application owningApplication;
    protected PersonAndOrganization owningUser;
    protected String state;
    protected String xmlns;

    /**
     * Gets the value of the changeAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeAction() {
        return changeAction;
    }

    /**
     * Sets the value of the changeAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeAction(String value) {
        this.changeAction = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCreationDate(Long value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the lastModifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * Sets the value of the lastModifiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLastModifiedDate(Long value) {
        this.lastModifiedDate = value;
    }

    /**
     * Gets the value of the lastModifyingApplication property.
     * 
     * @return
     *     possible object is
     *     {@link Application }
     *     
     */
    public Application getLastModifyingApplication() {
        return lastModifyingApplication;
    }

    /**
     * Sets the value of the lastModifyingApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link Application }
     *     
     */
    public void setLastModifyingApplication(Application value) {
        this.lastModifyingApplication = value;
    }

    /**
     * Gets the value of the lastModifyingUser property.
     * 
     * @return
     *     possible object is
     *     {@link PersonAndOrganization }
     *     
     */
    public PersonAndOrganization getLastModifyingUser() {
        return lastModifyingUser;
    }

    /**
     * Sets the value of the lastModifyingUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonAndOrganization }
     *     
     */
    public void setLastModifyingUser(PersonAndOrganization value) {
        this.lastModifyingUser = value;
    }

    /**
     * Gets the value of the owningApplication property.
     * 
     * @return
     *     possible object is
     *     {@link Application }
     *     
     */
    public Application getOwningApplication() {
        return owningApplication;
    }

    /**
     * Sets the value of the owningApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link Application }
     *     
     */
    public void setOwningApplication(Application value) {
        this.owningApplication = value;
    }

    /**
     * Gets the value of the owningUser property.
     * 
     * @return
     *     possible object is
     *     {@link PersonAndOrganization }
     *     
     */
    public PersonAndOrganization getOwningUser() {
        return owningUser;
    }

    /**
     * Sets the value of the owningUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonAndOrganization }
     *     
     */
    public void setOwningUser(PersonAndOrganization value) {
        this.owningUser = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the xmlns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlns() {
        return xmlns;
    }

    /**
     * Sets the value of the xmlns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlns(String value) {
        this.xmlns = value;
    }

}