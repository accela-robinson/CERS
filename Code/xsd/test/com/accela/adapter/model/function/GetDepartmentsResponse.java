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
 * <p>Java class for getDepartmentsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDepartmentsResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{}operationResponse">
 *       &lt;sequence>
 *         &lt;element name="departments" type="{}departments" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDepartmentsResponse", propOrder = {
    "departments"
})
public class GetDepartmentsResponse
    extends OperationResponse
{

    protected Departments departments;

    /**
     * Gets the value of the departments property.
     * 
     * @return
     *     possible object is
     *     {@link Departments }
     *     
     */
    public Departments getDepartments() {
        return departments;
    }

    /**
     * Sets the value of the departments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Departments }
     *     
     */
    public void setDepartments(Departments value) {
        this.departments = value;
    }

}
