package com.accela.adapter.model.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.accela.adapter.model.common.Keys;

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
 *         &lt;element name="Keys">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="agencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bureauCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="divisionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sectionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="groupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subgroupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subgroupCodeDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Staff">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="StaffPerson">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Keys">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="auditStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="serviceProviderCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="agencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="bureauCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="divisionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="sectionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="groupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="officeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "keys",
    "identifierDisplay",
    "agencyCode",
    "bureauCode",
    "divisionCode",
    "sectionCode",
    "groupCode",
    "subgroupCode",
    "subgroupCodeDesc",
    "staff"
})
public class Department {

    @XmlElement(name = "Keys", required = true)
    protected Keys keys;
    @XmlElement(name = "IdentifierDisplay", required = true)
    protected String identifierDisplay;
    @XmlElement(required = true)
    protected String agencyCode;
    @XmlElement(required = true)
    protected String bureauCode;
    @XmlElement(required = true)
    protected String divisionCode;
    @XmlElement(required = true)
    protected String sectionCode;
    @XmlElement(required = true)
    protected String groupCode;
    @XmlElement(required = true)
    protected String subgroupCode;
    @XmlElement(required = true)
    protected String subgroupCodeDesc;
    @XmlElement(name = "Staff", required = true)
    protected Staff staff;

    /**
     * Gets the value of the keys property.
     * 
     * @return
     *     possible object is
     *     {@link Inspection.Department.Keys }
     *     
     */
    public Keys getKeys() {
        return keys;
    }

    /**
     * Sets the value of the keys property.
     * 
     * @param value
     *     allowed object is
     *     {@link Inspection.Department.Keys }
     *     
     */
    public void setKeys(Keys value) {
        this.keys = value;
    }

    /**
     * Gets the value of the identifierDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifierDisplay() {
        return identifierDisplay;
    }

    /**
     * Sets the value of the identifierDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifierDisplay(String value) {
        this.identifierDisplay = value;
    }

    /**
     * Gets the value of the agencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyCode() {
        return agencyCode;
    }

    /**
     * Sets the value of the agencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyCode(String value) {
        this.agencyCode = value;
    }

    /**
     * Gets the value of the bureauCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBureauCode() {
        return bureauCode;
    }

    /**
     * Sets the value of the bureauCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBureauCode(String value) {
        this.bureauCode = value;
    }

    /**
     * Gets the value of the divisionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDivisionCode() {
        return divisionCode;
    }

    /**
     * Sets the value of the divisionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDivisionCode(String value) {
        this.divisionCode = value;
    }

    /**
     * Gets the value of the sectionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSectionCode() {
        return sectionCode;
    }

    /**
     * Sets the value of the sectionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSectionCode(String value) {
        this.sectionCode = value;
    }

    /**
     * Gets the value of the groupCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * Sets the value of the groupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupCode(String value) {
        this.groupCode = value;
    }

    /**
     * Gets the value of the subgroupCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubgroupCode() {
        return subgroupCode;
    }

    /**
     * Sets the value of the subgroupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubgroupCode(String value) {
        this.subgroupCode = value;
    }

    /**
     * Gets the value of the subgroupCodeDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubgroupCodeDesc() {
        return subgroupCodeDesc;
    }

    /**
     * Sets the value of the subgroupCodeDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubgroupCodeDesc(String value) {
        this.subgroupCodeDesc = value;
    }

    /**
     * Gets the value of the staff property.
     * 
     * @return
     *     possible object is
     *     {@link Staff }
     *     
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     * Sets the value of the staff property.
     * 
     * @param value
     *     allowed object is
     *     {@link Staff }
     *     
     */
    public void setStaff(Staff value) {
        this.staff = value;
    }

}