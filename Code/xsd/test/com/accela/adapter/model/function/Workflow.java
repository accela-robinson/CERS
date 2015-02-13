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
 * <p>Java class for workflow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="workflow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capId" type="{}capId" minOccurs="0"/>
 *         &lt;element name="processes" type="{}processes" minOccurs="0"/>
 *         &lt;element name="workflowHistory" type="{}taskItems" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workflow", propOrder = {
    "capId",
    "processes",
    "workflowHistory"
})
public class Workflow {

    protected CapId capId;
    protected Processes processes;
    protected TaskItems workflowHistory;

    /**
     * Gets the value of the capId property.
     * 
     * @return
     *     possible object is
     *     {@link CapId }
     *     
     */
    public CapId getCapId() {
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
    public void setCapId(CapId value) {
        this.capId = value;
    }

    /**
     * Gets the value of the processes property.
     * 
     * @return
     *     possible object is
     *     {@link Processes }
     *     
     */
    public Processes getProcesses() {
        return processes;
    }

    /**
     * Sets the value of the processes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Processes }
     *     
     */
    public void setProcesses(Processes value) {
        this.processes = value;
    }

    /**
     * Gets the value of the workflowHistory property.
     * 
     * @return
     *     possible object is
     *     {@link TaskItems }
     *     
     */
    public TaskItems getWorkflowHistory() {
        return workflowHistory;
    }

    /**
     * Sets the value of the workflowHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskItems }
     *     
     */
    public void setWorkflowHistory(TaskItems value) {
        this.workflowHistory = value;
    }

}
