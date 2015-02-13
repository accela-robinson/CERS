package com.accela.adapter.model.Address;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="addressLines">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="CityIdentifier">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Alias" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
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
    "addressLines",
    "city",
    "cityIdentifier",
    "state",
    "postalCode",
    "country",
    "alias"
})
public class CompactAddress {

    @XmlElement(name = "Keys", required = true)
    protected Keys keys;
    @XmlElement(required = true)
    protected AddressLines addressLines;
    @XmlElement(name = "City")
    @XmlSchemaType(name = "unsignedShort")
    protected int city;
    @XmlElement(name = "CityIdentifier", required = true)
    protected CityIdentifier cityIdentifier;
    @XmlElement(name = "State")
    @XmlSchemaType(name = "unsignedByte")
    protected short state;
    @XmlElement(name = "PostalCode")
    @XmlSchemaType(name = "unsignedShort")
    protected int postalCode;
    @XmlElement(name = "Country", required = true)
    protected String country;
    @XmlElement(name = "Alias")
    @XmlSchemaType(name = "unsignedShort")
    protected int alias;

    /**
     * Gets the value of the keys property.
     * 
     * @return
     *     possible object is
     *     {@link CAPQuery_Response.GetCAPsResponse.CAPs.CAP.Addresses.CompactAddress.Keys }
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
     *     {@link CAPQuery_Response.GetCAPsResponse.CAPs.CAP.Addresses.CompactAddress.Keys }
     *     
     */
    public void setKeys(Keys value) {
        this.keys = value;
    }

    /**
     * Gets the value of the addressLines property.
     * 
     * @return
     *     possible object is
     *     {@link CAPQuery_Response.GetCAPsResponse.CAPs.CAP.Addresses.CompactAddress.AddressLines }
     *     
     */
    public AddressLines getAddressLines() {
        return addressLines;
    }

    /**
     * Sets the value of the addressLines property.
     * 
     * @param value
     *     allowed object is
     *     {@link CAPQuery_Response.GetCAPsResponse.CAPs.CAP.Addresses.CompactAddress.AddressLines }
     *     
     */
    public void setAddressLines(AddressLines value) {
        this.addressLines = value;
    }

    /**
     * Gets the value of the city property.
     * 
     */
    public int getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     */
    public void setCity(int value) {
        this.city = value;
    }

    /**
     * Gets the value of the cityIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link CityIdentifier }
     *     
     */
    public CityIdentifier getCityIdentifier() {
        return cityIdentifier;
    }

    /**
     * Sets the value of the cityIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link CityIdentifier }
     *     
     */
    public void setCityIdentifier(CityIdentifier value) {
        this.cityIdentifier = value;
    }

    /**
     * Gets the value of the state property.
     * 
     */
    public short getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     */
    public void setState(short value) {
        this.state = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     */
    public void setPostalCode(int value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the alias property.
     * 
     */
    public int getAlias() {
        return alias;
    }

    /**
     * Sets the value of the alias property.
     * 
     */
    public void setAlias(int value) {
        this.alias = value;
    }

}