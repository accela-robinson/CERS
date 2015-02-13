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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContinuousElectronicTankMonitoringType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContinuousElectronicTankMonitoringType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="TankSecondaryContainmentSystem" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="01"/>
 *               &lt;enumeration value="02"/>
 *               &lt;enumeration value="03"/>
 *               &lt;enumeration value="04"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EMPManufacturer" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="25"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EMPModelNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="35"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LeakSensorManufacturer" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LeakSensorModelNum" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="35"/>
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
@XmlType(name = "ContinuousElectronicTankMonitoringType", propOrder = {
    "tankSecondaryContainmentSystemOrEMPManufacturerOrEMPModelNumber"
})
@XmlSeeAlso({
    com.accela.cers.cap.model.USTMonitoringPlanType.ContinuousElectronicTankMonitoring.class
})
public class ContinuousElectronicTankMonitoringType {

    @XmlElementRefs({
        @XmlElementRef(name = "EMPManufacturer", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TankSecondaryContainmentSystem", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EMPModelNumber", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LeakSensorModelNum", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LeakSensorManufacturer", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> tankSecondaryContainmentSystemOrEMPManufacturerOrEMPModelNumber;

    /**
     * Gets the value of the tankSecondaryContainmentSystemOrEMPManufacturerOrEMPModelNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tankSecondaryContainmentSystemOrEMPManufacturerOrEMPModelNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTankSecondaryContainmentSystemOrEMPManufacturerOrEMPModelNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getTankSecondaryContainmentSystemOrEMPManufacturerOrEMPModelNumber() {
        if (tankSecondaryContainmentSystemOrEMPManufacturerOrEMPModelNumber == null) {
            tankSecondaryContainmentSystemOrEMPManufacturerOrEMPModelNumber = new ArrayList<JAXBElement<String>>();
        }
        return this.tankSecondaryContainmentSystemOrEMPManufacturerOrEMPModelNumber;
    }

}
