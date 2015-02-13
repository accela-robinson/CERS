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
 *         &lt;element name="DetailAddress">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="houseNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="houseNumberFraction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="streetDirection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="streetName" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="streetSuffix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="streetSuffixDirection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="unitType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="addressTypeFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="streetPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="houseNumberEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="unitEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="houseFractionEnd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="secondaryRoad" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="secondaryRoadNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="inspectionDistrictPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="inspectionDistrict" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="neighborhoodPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="neighborhood" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="XCoordinate" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="YCoordinate" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="AuditID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="sourceFlag" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="fullAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="houseNumberAlphaStart" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="houseNumberAlphaEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="levelPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="levelNumberStart" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="levelNumberEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="ReferenceAddressType" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="isPrimary" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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
    "detailAddress"
})
public class DetailAddresses {

    @XmlElement(name = "DetailAddress", required = true)
    protected DetailAddress detailAddress;

    /**
     * Gets the value of the detailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link DetailAddress }
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
     *     {@link DetailAddress }
     *     
     */
    public void setDetailAddress(DetailAddress value) {
        this.detailAddress = value;
    }

}