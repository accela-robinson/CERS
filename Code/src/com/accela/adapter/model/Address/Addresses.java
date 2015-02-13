package com.accela.adapter.model.Address;

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
 *         &lt;element name="PostalAddress">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="addressLines">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="postalCode" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="town" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TelecomAddress">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="telephoneNumbers">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="facsimileNumbers">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
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
    "postalAddress",
    "telecomAddress",
    "compactAddress",
    "detailAddress"
})
public class Addresses {

    @XmlElement(name = "PostalAddress", required = true)
    protected PostalAddress postalAddress;
    @XmlElement(name = "TelecomAddress", required = true)
    protected TelecomAddress telecomAddress;

    @XmlElement(name = "CompactAddress", required = true)
    protected CompactAddress compactAddress;
    @XmlElement(name = "DetailAddress", required = true)
    protected DetailAddress detailAddress;

    /**
     * Gets the value of the compactAddress property.
     * 
     * @return
     *     possible object is
     *     {@link CompactAddress }
     *     
     */
    public CompactAddress getCompactAddress() {
        return compactAddress;
    }

    /**
     * Sets the value of the compactAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompactAddress }
     *     
     */
    public void setCompactAddress(CompactAddress value) {
        this.compactAddress = value;
    }

    /**
     * Gets the value of the detailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link CAPQuery_Response.GetCAPsResponse.CAPs.CAP.Addresses.DetailAddress }
     *     
     */
    public DetailAddress getDetailAddress() {
        return detailAddress;
    }

    /**
     * Sets the value of the detailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link CAPQuery_Response.GetCAPsResponse.CAPs.CAP.Addresses.DetailAddress }
     *     
     */
    public void setDetailAddress(DetailAddress value) {
        this.detailAddress = value;
    }
    
    /**
     * Gets the value of the postalAddress property.
     * 
     * @return
     *     possible object is
     *     {@link PostalAddress }
     *     
     */
    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    /**
     * Sets the value of the postalAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostalAddress }
     *     
     */
    public void setPostalAddress(PostalAddress value) {
        this.postalAddress = value;
    }

    /**
     * Gets the value of the telecomAddress property.
     * 
     * @return
     *     possible object is
     *     {@link TelecomAddress }
     *     
     */
    public TelecomAddress getTelecomAddress() {
        return telecomAddress;
    }

    /**
     * Sets the value of the telecomAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link TelecomAddress }
     *     
     */
    public void setTelecomAddress(TelecomAddress value) {
        this.telecomAddress = value;
    }

}