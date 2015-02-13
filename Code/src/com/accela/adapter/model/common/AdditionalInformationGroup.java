package com.accela.adapter.model.common;

import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element name="Keys">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AdditionalInformationSubGroup" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}byte" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *                   &lt;element name="AdditionalItems">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="AdditionalItem" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Keys">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="DataType">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="inputRange">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="minValue" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                           &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                 &lt;element name="inputRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                 &lt;element name="fieldType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="drillDown" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="action" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="addRemoveSubGroups" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"keys", "identifierDisplay", "description", "additionalInformationSubGroup",
		"addRemoveSubGroups", "security"})
public class AdditionalInformationGroup
{

	@XmlElement(name = "Keys", required = true)
	protected Keys keys;

	@XmlElement(name = "IdentifierDisplay", required = true)
	protected String identifierDisplay;

	@XmlElement(name = "Description", required = true)
	protected String description;

	@XmlElement(name = "AdditionalInformationSubGroup", required = true)
	protected List<AdditionalInformationSubGroup> additionalInformationSubGroup;

	protected boolean addRemoveSubGroups;

	@XmlElement(required = true)
	protected String security;

	/**
	 * Gets the value of the keys property.
	 * 
	 * @return possible object is
	 *         {@link GovXML_newCAP.InitiateCAP.AdditionalInformation.AdditionalInformationGroup.Keys }
	 * 
	 */
	public Keys getKeys()
	{
		return keys;
	}

	/**
	 * Sets the value of the keys property.
	 * 
	 * @param value allowed object is
	 *            {@link GovXML_newCAP.InitiateCAP.AdditionalInformation.AdditionalInformationGroup.Keys }
	 * 
	 */
	public void setKeys(Keys value)
	{
		this.keys = value;
	}

	/**
	 * Gets the value of the identifierDisplay property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIdentifierDisplay()
	{
		return identifierDisplay;
	}

	/**
	 * Sets the value of the identifierDisplay property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setIdentifierDisplay(String value)
	{
		this.identifierDisplay = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value)
	{
		this.description = value;
	}

	/**
	 * Gets the value of the additionalInformationSubGroup property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
	 * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
	 * the additionalInformationSubGroup property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAdditionalInformationSubGroup().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link AdditionalInformationSubGroup }
	 * 
	 * 
	 */
	public List<AdditionalInformationSubGroup> getAdditionalInformationSubGroup()
	{
		if (additionalInformationSubGroup == null)
		{
			additionalInformationSubGroup = new ArrayList<AdditionalInformationSubGroup>();
		}
		return this.additionalInformationSubGroup;
	}

	/**
	 * Gets the value of the addRemoveSubGroups property.
	 * 
	 */
	public boolean isAddRemoveSubGroups()
	{
		return addRemoveSubGroups;
	}

	/**
	 * Sets the value of the addRemoveSubGroups property.
	 * 
	 */
	public void setAddRemoveSubGroups(boolean value)
	{
		this.addRemoveSubGroups = value;
	}

	/**
	 * Gets the value of the security property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSecurity()
	{
		return security;
	}

	/**
	 * Sets the value of the security property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setSecurity(String value)
	{
		this.security = value;
	}

	public AdditionalInformationGroup clone()
	{
		AdditionalInformationGroup aig = new AdditionalInformationGroup();
		aig.keys = this.keys;
		aig.identifierDisplay = this.identifierDisplay;
		aig.description = this.description;
		aig.additionalInformationSubGroup = new ArrayList<AdditionalInformationSubGroup>();
		for (AdditionalInformationSubGroup asg : this.additionalInformationSubGroup)
		{
			aig.additionalInformationSubGroup.add(asg.clone());
		}
		aig.addRemoveSubGroups = this.addRemoveSubGroups;
		aig.security = this.security;
		return aig;
	}
}