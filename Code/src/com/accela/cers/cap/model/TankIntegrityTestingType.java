//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.21 at 02:38:20 PM GMT+08:00 
//


package com.accela.cers.cap.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TankIntegrityTestingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TankIntegrityTestingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="TankIntegrityTestingFrequency" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="01"/>
 *               &lt;enumeration value="02"/>
 *               &lt;enumeration value="99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TankIntegrityTestingFrequencyOther" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="15"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TankIntegrityTestingType", propOrder = {
    "tankIntegrityTestingFrequencyOrTankIntegrityTestingFrequencyOther"
})
public class TankIntegrityTestingType {

    @XmlElementRefs({
        @XmlElementRef(name = "TankIntegrityTestingFrequency", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TankIntegrityTestingFrequencyOther", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> tankIntegrityTestingFrequencyOrTankIntegrityTestingFrequencyOther;

    /**
     * Gets the value of the tankIntegrityTestingFrequencyOrTankIntegrityTestingFrequencyOther property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tankIntegrityTestingFrequencyOrTankIntegrityTestingFrequencyOther property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTankIntegrityTestingFrequencyOrTankIntegrityTestingFrequencyOther().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getTankIntegrityTestingFrequencyOrTankIntegrityTestingFrequencyOther() {
        if (tankIntegrityTestingFrequencyOrTankIntegrityTestingFrequencyOther == null) {
            tankIntegrityTestingFrequencyOrTankIntegrityTestingFrequencyOther = new ArrayList<JAXBElement<String>>();
        }
        return this.tankIntegrityTestingFrequencyOrTankIntegrityTestingFrequencyOther;
    }

}