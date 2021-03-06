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
 *                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EnumerationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EnumerationLinkData">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nonCriticalScore" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="majorViolation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="criticalScore" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
    "enumerationType",
    "enumerationLinkData"
})
public class Enumeration {

    @XmlElement(name = "Keys", required = true)
    protected Keys keys;
    @XmlElement(name = "IdentifierDisplay", required = true)
    protected String identifierDisplay;
    @XmlElement(name = "EnumerationType", required = true)
    protected String enumerationType;
    @XmlElement(name = "EnumerationLinkData", required = true)
    protected EnumerationLinkData enumerationLinkData;

    /**
     * Gets the value of the keys property.
     * 
     * @return
     *     possible object is
     *     {@link Inspection.Guidesheets.Guidesheet.EnumerationLists.EnumerationList.Enumerations.Enumeration.Keys }
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
     *     {@link Inspection.Guidesheets.Guidesheet.EnumerationLists.EnumerationList.Enumerations.Enumeration.Keys }
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
     * Gets the value of the enumerationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnumerationType() {
        return enumerationType;
    }

    /**
     * Sets the value of the enumerationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnumerationType(String value) {
        this.enumerationType = value;
    }

    /**
     * Gets the value of the enumerationLinkData property.
     * 
     * @return
     *     possible object is
     *     {@link EnumerationLinkData }
     *     
     */
    public EnumerationLinkData getEnumerationLinkData() {
        return enumerationLinkData;
    }

    /**
     * Sets the value of the enumerationLinkData property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumerationLinkData }
     *     
     */
    public void setEnumerationLinkData(EnumerationLinkData value) {
        this.enumerationLinkData = value;
    }

}