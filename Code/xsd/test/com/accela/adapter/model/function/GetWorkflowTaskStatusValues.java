//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.04 at 06:33:27 PM CST 
//


package com.accela.adapter.model.function;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getWorkflowTaskStatusValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getWorkflowTaskStatusValues">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CAPId" type="{}capId" minOccurs="0"/>
 *         &lt;element name="processCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="system" type="{}system" minOccurs="0"/>
 *         &lt;element name="taskDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWorkflowTaskStatusValues", propOrder = {
    "capId",
    "processCode",
    "system",
    "taskDescription"
})
public class GetWorkflowTaskStatusValues {

    @XmlElement(name = "CAPId")
    protected CapId capId;
    protected String processCode;
    protected System system;
    protected String taskDescription;

    /**
     * Gets the value of the capId property.
     * 
     * @return
     *     possible object is
     *     {@link CapId }
     *     
     */
    public CapId getCAPId() {
        return capId;
    }

    /**
     * Sets the value of the capId property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapId }
     *     
     */
    public void setCAPId(CapId value) {
        this.capId = value;
    }

    /**
     * Gets the value of the processCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessCode() {
        return processCode;
    }

    /**
     * Sets the value of the processCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessCode(String value) {
        this.processCode = value;
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

    /**
     * Gets the value of the taskDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskDescription() {
        return taskDescription;
    }

    /**
     * Sets the value of the taskDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskDescription(String value) {
        this.taskDescription = value;
    }

}