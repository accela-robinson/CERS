package com.accela.adapter.model.inspection;

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
 *         &lt;element name="DistanceAndTime">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="LastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
    "distanceAndTime"
})
public class DistanceAndTimes {

    @XmlElement(name = "DistanceAndTime", required = true)
    protected DistanceAndTime distanceAndTime;

    /**
     * Gets the value of the distanceAndTime property.
     * 
     * @return
     *     possible object is
     *     {@link DistanceAndTime }
     *     
     */
    public DistanceAndTime getDistanceAndTime() {
        return distanceAndTime;
    }

    /**
     * Sets the value of the distanceAndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistanceAndTime }
     *     
     */
    public void setDistanceAndTime(DistanceAndTime value) {
        this.distanceAndTime = value;
    }

}