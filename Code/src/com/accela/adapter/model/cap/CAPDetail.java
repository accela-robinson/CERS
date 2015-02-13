package com.accela.adapter.model.cap;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TotalJobCost" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"totalJobCost", "shortNotes"})
public class CAPDetail
{

	/**
	 * @return the shortNotes
	 */

	public String getShortNotes()
	{
		return shortNotes;
	}

	/**
	 * @param shortNotes the shortNotes to set
	 */
	public void setShortNotes(String shortNotes)
	{
		this.shortNotes = shortNotes;
	}

	@XmlElement(name = "shortNotes")
	protected String shortNotes;

	@XmlElement(name = "TotalJobCost", required = true)
	protected BigDecimal totalJobCost;

	/**
	 * Gets the value of the totalJobCost property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getTotalJobCost()
	{
		return totalJobCost;
	}

	/**
	 * Sets the value of the totalJobCost property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 * 
	 */
	public void setTotalJobCost(BigDecimal value)
	{
		this.totalJobCost = value;
	}

}