package com.accela.adapter.model.contact;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="contactBusinessName" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"name","id", "contactBusinessName"})
public class Organization
{

	/**
	 * @return the id
	 */
	
	public String getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	@XmlSchemaType(name = "unsignedByte")
	protected String name;
	@XmlSchemaType(name = "unsignedByte")
	protected String id;
	@XmlSchemaType(name = "unsignedByte")
	protected String contactBusinessName;

	/**
	 * Gets the value of the name property.
	 * 
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 */
	public void setName(String value)
	{
		this.name = value;
	}

	/**
	 * Gets the value of the contactBusinessName property.
	 * 
	 */
	public String getContactBusinessName()
	{
		return contactBusinessName;
	}

	/**
	 * Sets the value of the contactBusinessName property.
	 * 
	 */
	public void setContactBusinessName(String value)
	{
		this.contactBusinessName = value;
	}

}