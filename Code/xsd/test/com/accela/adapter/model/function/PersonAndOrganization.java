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
 * <p>Java class for personAndOrganization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personAndOrganization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="roles" type="{}roles" minOccurs="0"/>
 *         &lt;element name="theOrganization" type="{}theOrganization" minOccurs="0"/>
 *         &lt;element name="thePerson" type="{}thePerson" minOccurs="0"/>
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
@XmlType(name = "personAndOrganization", propOrder = {
    "roles",
    "theOrganization",
    "thePerson",
    "xmlns"
})
public class PersonAndOrganization {

    protected Roles roles;
    protected TheOrganization theOrganization;
    protected ThePerson thePerson;
    protected String xmlns;

    /**
     * Gets the value of the roles property.
     * 
     * @return
     *     possible object is
     *     {@link Roles }
     *     
     */
    public Roles getRoles() {
        return roles;
    }

    /**
     * Sets the value of the roles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Roles }
     *     
     */
    public void setRoles(Roles value) {
        this.roles = value;
    }

    /**
     * Gets the value of the theOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link TheOrganization }
     *     
     */
    public TheOrganization getTheOrganization() {
        return theOrganization;
    }

    /**
     * Sets the value of the theOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link TheOrganization }
     *     
     */
    public void setTheOrganization(TheOrganization value) {
        this.theOrganization = value;
    }

    /**
     * Gets the value of the thePerson property.
     * 
     * @return
     *     possible object is
     *     {@link ThePerson }
     *     
     */
    public ThePerson getThePerson() {
        return thePerson;
    }

    /**
     * Sets the value of the thePerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThePerson }
     *     
     */
    public void setThePerson(ThePerson value) {
        this.thePerson = value;
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
