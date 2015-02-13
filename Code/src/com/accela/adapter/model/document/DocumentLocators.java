package com.accela.adapter.model.document;

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
 *         &lt;element name="ElectronicFileLocator">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="fileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fileSize" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
    "electronicFileLocator"
})
public class DocumentLocators {

    @XmlElement(name = "ElectronicFileLocator", required = true)
    protected ElectronicFileLocator electronicFileLocator;

    /**
     * Gets the value of the electronicFileLocator property.
     * 
     * @return
     *     possible object is
     *     {@link ElectronicFileLocator }
     *     
     */
    public ElectronicFileLocator getElectronicFileLocator() {
        return electronicFileLocator;
    }

    /**
     * Sets the value of the electronicFileLocator property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectronicFileLocator }
     *     
     */
    public void setElectronicFileLocator(ElectronicFileLocator value) {
        this.electronicFileLocator = value;
    }

}