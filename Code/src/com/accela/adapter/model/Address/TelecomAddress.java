package com.accela.adapter.model.Address;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.accela.adapter.model.common.FacsimileNumbers;
import com.accela.adapter.model.contact.TelephoneNumbers;

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
 *         &lt;element name="telephoneNumbers">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="facsimileNumbers">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
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
    "telephoneNumbers",
    "facsimileNumbers",
    "electronicMailAddresses"
})
public class TelecomAddress {

    @XmlElement(required = true)
    protected TelephoneNumbers telephoneNumbers;
    @XmlElement(required = true)
    protected FacsimileNumbers facsimileNumbers;    
    @XmlElement(required = true)
   private ElectronicMailAddresses electronicMailAddresses;

    public ElectronicMailAddresses getElectronicMailAddresses()
	{
		return electronicMailAddresses;
	}

	public void setElectronicMailAddresses(ElectronicMailAddresses electronicMailAddresses)
	{
		this.electronicMailAddresses = electronicMailAddresses;
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

}