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
 * <p>Java class for fRescheduleInspectionOut complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fRescheduleInspectionOut">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inspection" type="{}inspection" minOccurs="0"/>
 *         &lt;element name="inspectionId" type="{}inspectionId" minOccurs="0"/>
 *         &lt;element name="rowStatus" type="{}rowStatus" minOccurs="0"/>
 *         &lt;element name="system" type="{}system" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fRescheduleInspectionOut", propOrder = {
    "inspection",
    "inspectionId",
    "rowStatus",
    "system"
})
public class FRescheduleInspectionOut {

    protected Inspection inspection;
    protected InspectionId inspectionId;
    protected RowStatus rowStatus;
    protected System system;

    /**
     * Gets the value of the inspection property.
     * 
     * @return
     *     possible object is
     *     {@link Inspection }
     *     
     */
    public Inspection getInspection() {
        return inspection;
    }

    /**
     * Sets the value of the inspection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Inspection }
     *     
     */
    public void setInspection(Inspection value) {
        this.inspection = value;
    }

    /**
     * Gets the value of the inspectionId property.
     * 
     * @return
     *     possible object is
     *     {@link InspectionId }
     *     
     */
    public InspectionId getInspectionId() {
        return inspectionId;
    }

    /**
     * Sets the value of the inspectionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link InspectionId }
     *     
     */
    public void setInspectionId(InspectionId value) {
        this.inspectionId = value;
    }

    /**
     * Gets the value of the rowStatus property.
     * 
     * @return
     *     possible object is
     *     {@link RowStatus }
     *     
     */
    public RowStatus getRowStatus() {
        return rowStatus;
    }

    /**
     * Sets the value of the rowStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RowStatus }
     *     
     */
    public void setRowStatus(RowStatus value) {
        this.rowStatus = value;
    }

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link System }
     *     
     */
    public System getSystem() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link System }
     *     
     */
    public void setSystem(System value) {
        this.system = value;
    }

}
