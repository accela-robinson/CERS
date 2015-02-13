package com.accela.adapter.model.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="allAcaUserAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="capCreatorAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="licenseProfessionalAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="contactAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ownerAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "allAcaUserAllowed",
    "capCreatorAllowed",
    "licenseProfessionalAllowed",
    "contactAllowed",
    "ownerAllowed"
})
public class UserRolePrivilege {

    protected boolean allAcaUserAllowed;
    protected boolean capCreatorAllowed;
    protected boolean licenseProfessionalAllowed;
    protected boolean contactAllowed;
    protected boolean ownerAllowed;

    /**
     * Gets the value of the allAcaUserAllowed property.
     * 
     */
    public boolean isAllAcaUserAllowed() {
        return allAcaUserAllowed;
    }

    /**
     * Sets the value of the allAcaUserAllowed property.
     * 
     */
    public void setAllAcaUserAllowed(boolean value) {
        this.allAcaUserAllowed = value;
    }

    /**
     * Gets the value of the capCreatorAllowed property.
     * 
     */
    public boolean isCapCreatorAllowed() {
        return capCreatorAllowed;
    }

    /**
     * Sets the value of the capCreatorAllowed property.
     * 
     */
    public void setCapCreatorAllowed(boolean value) {
        this.capCreatorAllowed = value;
    }

    /**
     * Gets the value of the licenseProfessionalAllowed property.
     * 
     */
    public boolean isLicenseProfessionalAllowed() {
        return licenseProfessionalAllowed;
    }

    /**
     * Sets the value of the licenseProfessionalAllowed property.
     * 
     */
    public void setLicenseProfessionalAllowed(boolean value) {
        this.licenseProfessionalAllowed = value;
    }

    /**
     * Gets the value of the contactAllowed property.
     * 
     */
    public boolean isContactAllowed() {
        return contactAllowed;
    }

    /**
     * Sets the value of the contactAllowed property.
     * 
     */
    public void setContactAllowed(boolean value) {
        this.contactAllowed = value;
    }

    /**
     * Gets the value of the ownerAllowed property.
     * 
     */
    public boolean isOwnerAllowed() {
        return ownerAllowed;
    }

    /**
     * Sets the value of the ownerAllowed property.
     * 
     */
    public void setOwnerAllowed(boolean value) {
        this.ownerAllowed = value;
    }

}