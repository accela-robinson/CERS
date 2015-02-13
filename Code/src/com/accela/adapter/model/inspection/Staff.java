package com.accela.adapter.model.inspection;

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
 *         &lt;element name="StaffPerson">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="auditStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="serviceProviderCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="agencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="bureauCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="divisionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="sectionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="groupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="officeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "staffPerson"
})
public class Staff {

    @XmlElement(name = "StaffPerson", required = true)
    protected StaffPerson staffPerson;

    /**
     * Gets the value of the staffPerson property.
     * 
     * @return
     *     possible object is
     *     {@link StaffPerson }
     *     
     */
    public StaffPerson getStaffPerson() {
        return staffPerson;
    }

    /**
     * Sets the value of the staffPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaffPerson }
     *     
     */
    public void setStaffPerson(StaffPerson value) {
        this.staffPerson = value;
    }

}