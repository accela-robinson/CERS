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
 * <p>Java class for capWorkflows complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="capWorkflows">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currentSpendDays" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="currentTask" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dispCurrentTask" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dispLastComplete" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastComplete" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalSpendDays" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "capWorkflows", propOrder = {
    "currentSpendDays",
    "currentTask",
    "dispCurrentTask",
    "dispLastComplete",
    "lastComplete",
    "totalSpendDays"
})
public class CapWorkflows {

    protected int currentSpendDays;
    protected String currentTask;
    protected String dispCurrentTask;
    protected String dispLastComplete;
    protected String lastComplete;
    protected int totalSpendDays;

    /**
     * Gets the value of the currentSpendDays property.
     * 
     */
    public int getCurrentSpendDays() {
        return currentSpendDays;
    }

    /**
     * Sets the value of the currentSpendDays property.
     * 
     */
    public void setCurrentSpendDays(int value) {
        this.currentSpendDays = value;
    }

    /**
     * Gets the value of the currentTask property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentTask() {
        return currentTask;
    }

    /**
     * Sets the value of the currentTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentTask(String value) {
        this.currentTask = value;
    }

    /**
     * Gets the value of the dispCurrentTask property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispCurrentTask() {
        return dispCurrentTask;
    }

    /**
     * Sets the value of the dispCurrentTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispCurrentTask(String value) {
        this.dispCurrentTask = value;
    }

    /**
     * Gets the value of the dispLastComplete property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispLastComplete() {
        return dispLastComplete;
    }

    /**
     * Sets the value of the dispLastComplete property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispLastComplete(String value) {
        this.dispLastComplete = value;
    }

    /**
     * Gets the value of the lastComplete property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastComplete() {
        return lastComplete;
    }

    /**
     * Sets the value of the lastComplete property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastComplete(String value) {
        this.lastComplete = value;
    }

    /**
     * Gets the value of the totalSpendDays property.
     * 
     */
    public int getTotalSpendDays() {
        return totalSpendDays;
    }

    /**
     * Sets the value of the totalSpendDays property.
     * 
     */
    public void setTotalSpendDays(int value) {
        this.totalSpendDays = value;
    }

}
