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
 * <p>Java class for telecomAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="telecomAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="electronicMailAddresses" type="{}electronicMailAddresses" minOccurs="0"/>
 *         &lt;element name="facsimileNumbers" type="{}facsimileNumbers" minOccurs="0"/>
 *         &lt;element name="pagerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telephoneNumbers" type="{}telephoneNumbers" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "telecomAddress", propOrder = {
    "electronicMailAddresses",
    "facsimileNumbers",
    "pagerNumber",
    "telephoneNumbers"
})
public class TelecomAddress {

    protected ElectronicMailAddresses electronicMailAddresses;
    protected FacsimileNumbers facsimileNumbers;
    protected String pagerNumber;
    protected TelephoneNumbers telephoneNumbers;

    /**
     * Gets the value of the electronicMailAddresses property.
     * 
     * @return
     *     possible object is
     *     {@link ElectronicMailAddresses }
     *     
     */
    public ElectronicMailAddresses getElectronicMailAddresses() {
        return electronicMailAddresses;
    }

    /**
     * Sets the value of the electronicMailAddresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectronicMailAddresses }
     *     
     */
    public void setElectronicMailAddresses(ElectronicMailAddresses value) {
        this.electronicMailAddresses = value;
    }

    /**
     * Gets the value of the facsimileNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link FacsimileNumbers }
     *     
     */
    public FacsimileNumbers getFacsimileNumbers() {
        return facsimileNumbers;
    }

    /**
     * Sets the value of the facsimileNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacsimileNumbers }
     *     
     */
    public void setFacsimileNumbers(FacsimileNumbers value) {
        this.facsimileNumbers = value;
    }

    /**
     * Gets the value of the pagerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagerNumber() {
        return pagerNumber;
    }

    /**
     * Sets the value of the pagerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagerNumber(String value) {
        this.pagerNumber = value;
    }

    /**
     * Gets the value of the telephoneNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link TelephoneNumbers }
     *     
     */
    public TelephoneNumbers getTelephoneNumbers() {
        return telephoneNumbers;
    }

    /**
     * Sets the value of the telephoneNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link TelephoneNumbers }
     *     
     */
    public void setTelephoneNumbers(TelephoneNumbers value) {
        this.telephoneNumbers = value;
    }

}
