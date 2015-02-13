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
 * <p>Java class for getLicensedProfessionals complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getLicensedProfessionals">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="license" type="{}license" minOccurs="0"/>
 *         &lt;element name="organization" type="{}organization" minOccurs="0"/>
 *         &lt;element name="person" type="{}person" minOccurs="0"/>
 *         &lt;element name="personAndOrganization" type="{}personAndOrganization" minOccurs="0"/>
 *         &lt;element name="returnElements" type="{}returnElements" minOccurs="0"/>
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
@XmlType(name = "getLicensedProfessionals", propOrder = {
    "license",
    "organization",
    "person",
    "personAndOrganization",
    "returnElements",
    "system"
})
public class GetLicensedProfessionals {

    protected License license;
    protected Organization organization;
    protected Person person;
    protected PersonAndOrganization personAndOrganization;
    protected ReturnElements returnElements;
    protected System system;

    /**
     * Gets the value of the license property.
     * 
     * @return
     *     possible object is
     *     {@link License }
     *     
     */
    public License getLicense() {
        return license;
    }

    /**
     * Sets the value of the license property.
     * 
     * @param value
     *     allowed object is
     *     {@link License }
     *     
     */
    public void setLicense(License value) {
        this.license = value;
    }

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link Organization }
     *     
     */
    public Organization getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Organization }
     *     
     */
    public void setOrganization(Organization value) {
        this.organization = value;
    }

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setPerson(Person value) {
        this.person = value;
    }

    /**
     * Gets the value of the personAndOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link PersonAndOrganization }
     *     
     */
    public PersonAndOrganization getPersonAndOrganization() {
        return personAndOrganization;
    }

    /**
     * Sets the value of the personAndOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonAndOrganization }
     *     
     */
    public void setPersonAndOrganization(PersonAndOrganization value) {
        this.personAndOrganization = value;
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