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
 * <p>Java class for userRolePrivilege complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userRolePrivilege">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allAcaUserAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="capCreatorAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="contactAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="licenseProfessionalAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ownerAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userRolePrivilege", propOrder = {
    "allAcaUserAllowed",
    "capCreatorAllowed",
    "contactAllowed",
    "licenseProfessionalAllowed",
    "ownerAllowed"
})
public class UserRolePrivilege {

    protected Boolean allAcaUserAllowed;
    protected Boolean capCreatorAllowed;
    protected Boolean contactAllowed;
    protected Boolean licenseProfessionalAllowed;
    protected Boolean ownerAllowed;

    /**
     * Gets the value of the allAcaUserAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllAcaUserAllowed() {
        return allAcaUserAllowed;
    }

    /**
     * Sets the value of the allAcaUserAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllAcaUserAllowed(Boolean value) {
        this.allAcaUserAllowed = value;
    }

    /**
     * Gets the value of the capCreatorAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCapCreatorAllowed() {
        return capCreatorAllowed;
    }

    /**
     * Sets the value of the capCreatorAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCapCreatorAllowed(Boolean value) {
        this.capCreatorAllowed = value;
    }

    /**
     * Gets the value of the contactAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isContactAllowed() {
        return contactAllowed;
    }

    /**
     * Sets the value of the contactAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContactAllowed(Boolean value) {
        this.contactAllowed = value;
    }

    /**
     * Gets the value of the licenseProfessionalAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLicenseProfessionalAllowed() {
        return licenseProfessionalAllowed;
    }

    /**
     * Sets the value of the licenseProfessionalAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLicenseProfessionalAllowed(Boolean value) {
        this.licenseProfessionalAllowed = value;
    }

    /**
     * Gets the value of the ownerAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOwnerAllowed() {
        return ownerAllowed;
    }

    /**
     * Sets the value of the ownerAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOwnerAllowed(Boolean value) {
        this.ownerAllowed = value;
    }

}
