package com.accela.adapter.model.Address;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.accela.adapter.model.common.Keys;
import com.accela.adapter.model.common.StateIdentifier;

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
 *         &lt;element name="houseNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="houseNumberFraction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="streetDirection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="streetName" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="streetSuffix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="streetSuffixDirection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="unitType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="addressTypeFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="streetPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="houseNumberEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="unitEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="houseFractionEnd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="secondaryRoad" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="secondaryRoadNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="inspectionDistrictPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="inspectionDistrict" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="neighborhoodPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="neighborhood" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="XCoordinate" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="YCoordinate" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="AuditID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sourceFlag" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="fullAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="houseNumberAlphaStart" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="houseNumberAlphaEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="levelPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="levelNumberStart" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="levelNumberEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="ReferenceAddressType" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isPrimary" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"keys", "houseNumber", "houseNumberFraction", "streetDirection", "streetName",
		"streetSuffix", "streetSuffixDirection", "unit", "unitType", "city", "county", "state", "postalCode",
		"addressTypeFlag", "streetPrefix", "houseNumberEnd", "countryCode", "unitEnd", "houseFractionEnd",
		"description", "distance", "secondaryRoad", "secondaryRoadNumber", "inspectionDistrictPrefix",
		"inspectionDistrict", "neighborhoodPrefix", "neighborhood", "xCoordinate", "yCoordinate", "auditID",
		"sourceFlag", "fullAddress", "houseNumberAlphaStart", "houseNumberAlphaEnd", "levelPrefix", "levelNumberStart",
		"levelNumberEnd", "referenceAddressType","auditStatus","auditDate","stateIdentifier","countryCodeIdentifier"})
public class DetailAddress
{
	@XmlElement(name = "Keys", required = true)
	protected Keys keys;

	@XmlSchemaType(name = "unsignedShort")
	protected int houseNumber;

	@XmlElement(required = true)
	protected String houseNumberFraction;

	@XmlElement(required = true)
	protected String streetDirection;
	@XmlElement(name = "streetName")
	@XmlSchemaType(name = "unsignedShort")
	protected String streetName;

	@XmlElement(required = true)
	protected String streetSuffix;

	@XmlElement(required = true)
	protected String streetSuffixDirection;

	@XmlSchemaType(name = "unsignedShort")
	protected int unit;

	@XmlElement(required = true)
	protected String unitType;

	@XmlElement(name = "City")
	@XmlSchemaType(name = "unsignedByte")
	protected String city;

	@XmlElement(name = "County")
	@XmlSchemaType(name = "unsignedShort")
	protected String county;

	@XmlElement(name = "State")
	@XmlSchemaType(name = "unsignedInt")
	protected String state;

	@XmlElement(name = "PostalCode")
	@XmlSchemaType(name = "unsignedShort")
	protected String postalCode;

	@XmlElement(required = true)
	protected String addressTypeFlag;

	@XmlSchemaType(name = "unsignedShort")
	protected int streetPrefix;

	@XmlSchemaType(name = "unsignedShort")
	protected int houseNumberEnd;

	@XmlElement(required = true)
	protected String countryCode;

	@XmlSchemaType(name = "unsignedShort")
	protected int unitEnd;

	@XmlElement(required = true)
	protected String houseFractionEnd;

	@XmlSchemaType(name = "unsignedShort")
	protected String description;

	@XmlSchemaType(name = "unsignedShort")
	protected int distance;

	@XmlSchemaType(name = "unsignedShort")
	protected int secondaryRoad;

	@XmlSchemaType(name = "unsignedShort")
	protected int secondaryRoadNumber;

	@XmlSchemaType(name = "unsignedShort")
	protected int inspectionDistrictPrefix;

	@XmlSchemaType(name = "unsignedByte")
	protected String inspectionDistrict;

	@XmlSchemaType(name = "unsignedShort")
	protected int neighborhoodPrefix;

	@XmlSchemaType(name = "unsignedByte")
	protected String neighborhood;

	@XmlElement(name = "XCoordinate")
	@XmlSchemaType(name = "unsignedByte")
	protected String xCoordinate;

	@XmlElement(name = "YCoordinate")
	@XmlSchemaType(name = "unsignedByte")
	protected String yCoordinate;

	@XmlElement(name = "AuditID", required = true)
	protected String auditID;

	@XmlSchemaType(name = "unsignedByte")
	protected short sourceFlag;

	@XmlSchemaType(name = "unsignedByte")
	protected String fullAddress;

	@XmlSchemaType(name = "unsignedShort")
	protected int houseNumberAlphaStart;

	@XmlSchemaType(name = "unsignedShort")
	protected int houseNumberAlphaEnd;

	@XmlSchemaType(name = "unsignedByte")
	protected short levelPrefix;

	@XmlSchemaType(name = "unsignedByte")
	protected short levelNumberStart;

	@XmlSchemaType(name = "unsignedShort")
	protected int levelNumberEnd;

	@XmlElement(name = "ReferenceAddressType", required = true)
	protected Object referenceAddressType;

	@XmlAttribute(required = true)
	protected String action;

	@XmlAttribute(required = true)
	protected boolean isPrimary;

	@XmlElement(name = "AuditStatus", required = true)
	protected String auditStatus;

	@XmlElement(name = "AuditDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar auditDate;

	@XmlElement(name = "StateIdentifier", required = true)
	protected StateIdentifier stateIdentifier;

	@XmlElement(name = "CountryCodeIdentifier", required = true)
	protected CountryCodeIdentifier countryCodeIdentifier;


	/**
	 * Gets the value of the keys property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link CAPQuery_Response.GetCAPsResponse.CAPs.CAP.Addresses.DetailAddress.Keys }
	 *     
	 */
	public Keys getKeys()
	{
		return keys;
	}

	/**
	 * Sets the value of the keys property.
	 * 
	 * @param value allowed object is {@link CAPQuery_Response.GetCAPsResponse.CAPs.CAP.Addresses.DetailAddress.Keys }
	 * 
	 */
	public void setKeys(Keys value)
	{
		this.keys = value;
	}

	/**
	 * Gets the value of the houseNumber property.
	 * 
	 */
	public int getHouseNumber()
	{
		return houseNumber;
	}

	/**
	 * Sets the value of the houseNumber property.
	 * 
	 */
	public void setHouseNumber(int value)
	{
		this.houseNumber = value;
	}

	/**
	 * Gets the value of the houseNumberFraction property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHouseNumberFraction()
	{
		return houseNumberFraction;
	}

	/**
	 * Sets the value of the houseNumberFraction property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setHouseNumberFraction(String value)
	{
		this.houseNumberFraction = value;
	}

	/**
	 * Gets the value of the streetDirection property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStreetDirection()
	{
		return streetDirection;
	}

	/**
	 * Sets the value of the streetDirection property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStreetDirection(String value)
	{
		this.streetDirection = value;
	}

	/**
	 * Gets the value of the streetName property.
	 * 
	 */
	public String getStreetName()
	{
		return streetName;
	}

	/**
	 * Sets the value of the streetName property.
	 * 
	 */
	public void setStreetName(String value)
	{
		this.streetName = value;
	}

	/**
	 * Gets the value of the streetSuffix property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStreetSuffix()
	{
		return streetSuffix;
	}

	/**
	 * Sets the value of the streetSuffix property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStreetSuffix(String value)
	{
		this.streetSuffix = value;
	}

	/**
	 * Gets the value of the streetSuffixDirection property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStreetSuffixDirection()
	{
		return streetSuffixDirection;
	}

	/**
	 * Sets the value of the streetSuffixDirection property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStreetSuffixDirection(String value)
	{
		this.streetSuffixDirection = value;
	}

	/**
	 * Gets the value of the unit property.
	 * 
	 */
	public int getUnit()
	{
		return unit;
	}

	/**
	 * Sets the value of the unit property.
	 * 
	 */
	public void setUnit(int value)
	{
		this.unit = value;
	}

	/**
	 * Gets the value of the unitType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUnitType()
	{
		return unitType;
	}

	/**
	 * Sets the value of the unitType property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setUnitType(String value)
	{
		this.unitType = value;
	}

	/**
	 * Gets the value of the city property.
	 * 
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * Sets the value of the city property.
	 * 
	 */
	public void setCity(String value)
	{
		this.city = value;
	}

	/**
	 * Gets the value of the county property.
	 * 
	 */
	public String getCounty()
	{
		return county;
	}

	/**
	 * Sets the value of the county property.
	 * 
	 */
	public void setCounty(String value)
	{
		this.county = value;
	}

	/**
	 * Gets the value of the state property.
	 * 
	 */
	public String getState()
	{
		return state;
	}

	/**
	 * Sets the value of the state property.
	 * 
	 */
	public void setState(String value)
	{
		this.state = value;
	}

	/**
	 * Gets the value of the postalCode property.
	 * 
	 */
	public String getPostalCode()
	{
		return postalCode;
	}

	/**
	 * Sets the value of the postalCode property.
	 * 
	 */
	public void setPostalCode(String value)
	{
		this.postalCode = value;
	}

	/**
	 * Gets the value of the addressTypeFlag property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddressTypeFlag()
	{
		return addressTypeFlag;
	}

	/**
	 * Sets the value of the addressTypeFlag property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAddressTypeFlag(String value)
	{
		this.addressTypeFlag = value;
	}

	/**
	 * Gets the value of the streetPrefix property.
	 * 
	 */
	public int getStreetPrefix()
	{
		return streetPrefix;
	}

	/**
	 * Sets the value of the streetPrefix property.
	 * 
	 */
	public void setStreetPrefix(int value)
	{
		this.streetPrefix = value;
	}

	/**
	 * Gets the value of the houseNumberEnd property.
	 * 
	 */
	public int getHouseNumberEnd()
	{
		return houseNumberEnd;
	}

	/**
	 * Sets the value of the houseNumberEnd property.
	 * 
	 */
	public void setHouseNumberEnd(int value)
	{
		this.houseNumberEnd = value;
	}

	/**
	 * Gets the value of the countryCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCountryCode()
	{
		return countryCode;
	}

	/**
	 * Sets the value of the countryCode property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setCountryCode(String value)
	{
		this.countryCode = value;
	}

	/**
	 * Gets the value of the unitEnd property.
	 * 
	 */
	public int getUnitEnd()
	{
		return unitEnd;
	}

	/**
	 * Sets the value of the unitEnd property.
	 * 
	 */
	public void setUnitEnd(int value)
	{
		this.unitEnd = value;
	}

	/**
	 * Gets the value of the houseFractionEnd property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHouseFractionEnd()
	{
		return houseFractionEnd;
	}

	/**
	 * Sets the value of the houseFractionEnd property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setHouseFractionEnd(String value)
	{
		this.houseFractionEnd = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 */
	public void setDescription(String value)
	{
		this.description = value;
	}

	/**
	 * Gets the value of the distance property.
	 * 
	 */
	public int getDistance()
	{
		return distance;
	}

	/**
	 * Sets the value of the distance property.
	 * 
	 */
	public void setDistance(int value)
	{
		this.distance = value;
	}

	/**
	 * Gets the value of the secondaryRoad property.
	 * 
	 */
	public int getSecondaryRoad()
	{
		return secondaryRoad;
	}

	/**
	 * Sets the value of the secondaryRoad property.
	 * 
	 */
	public void setSecondaryRoad(int value)
	{
		this.secondaryRoad = value;
	}

	/**
	 * Gets the value of the secondaryRoadNumber property.
	 * 
	 */
	public int getSecondaryRoadNumber()
	{
		return secondaryRoadNumber;
	}

	/**
	 * Sets the value of the secondaryRoadNumber property.
	 * 
	 */
	public void setSecondaryRoadNumber(int value)
	{
		this.secondaryRoadNumber = value;
	}

	/**
	 * Gets the value of the inspectionDistrictPrefix property.
	 * 
	 */
	public int getInspectionDistrictPrefix()
	{
		return inspectionDistrictPrefix;
	}

	/**
	 * Sets the value of the inspectionDistrictPrefix property.
	 * 
	 */
	public void setInspectionDistrictPrefix(int value)
	{
		this.inspectionDistrictPrefix = value;
	}

	/**
	 * Gets the value of the inspectionDistrict property.
	 * 
	 */
	public String getInspectionDistrict()
	{
		return inspectionDistrict;
	}

	/**
	 * Sets the value of the inspectionDistrict property.
	 * 
	 */
	public void setInspectionDistrict(String value)
	{
		this.inspectionDistrict = value;
	}

	/**
	 * Gets the value of the neighborhoodPrefix property.
	 * 
	 */
	public int getNeighborhoodPrefix()
	{
		return neighborhoodPrefix;
	}

	/**
	 * Sets the value of the neighborhoodPrefix property.
	 * 
	 */
	public void setNeighborhoodPrefix(int value)
	{
		this.neighborhoodPrefix = value;
	}

	/**
	 * Gets the value of the neighborhood property.
	 * 
	 */
	public String getNeighborhood()
	{
		return neighborhood;
	}

	/**
	 * Sets the value of the neighborhood property.
	 * 
	 */
	public void setNeighborhood(String value)
	{
		this.neighborhood = value;
	}

	/**
	 * Gets the value of the xCoordinate property.
	 * 
	 */
	public String getXCoordinate()
	{
		return xCoordinate;
	}

	/**
	 * Sets the value of the xCoordinate property.
	 * 
	 */
	public void setXCoordinate(String value)
	{
		this.xCoordinate = value;
	}

	/**
	 * Gets the value of the yCoordinate property.
	 * 
	 */
	public String getYCoordinate()
	{
		return yCoordinate;
	}

	/**
	 * Sets the value of the yCoordinate property.
	 * 
	 */
	public void setYCoordinate(String value)
	{
		this.yCoordinate = value;
	}

	/**
	 * Gets the value of the auditID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAuditID()
	{
		return auditID;
	}

	/**
	 * Sets the value of the auditID property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAuditID(String value)
	{
		this.auditID = value;
	}

	/**
	 * Gets the value of the sourceFlag property.
	 * 
	 */
	public short getSourceFlag()
	{
		return sourceFlag;
	}

	/**
	 * Sets the value of the sourceFlag property.
	 * 
	 */
	public void setSourceFlag(short value)
	{
		this.sourceFlag = value;
	}

	/**
	 * Gets the value of the fullAddress property.
	 * 
	 */
	public String getFullAddress()
	{
		return fullAddress;
	}

	/**
	 * Sets the value of the fullAddress property.
	 * 
	 */
	public void setFullAddress(String value)
	{
		this.fullAddress = value;
	}

	/**
	 * Gets the value of the houseNumberAlphaStart property.
	 * 
	 */
	public int getHouseNumberAlphaStart()
	{
		return houseNumberAlphaStart;
	}

	/**
	 * Sets the value of the houseNumberAlphaStart property.
	 * 
	 */
	public void setHouseNumberAlphaStart(int value)
	{
		this.houseNumberAlphaStart = value;
	}

	/**
	 * Gets the value of the houseNumberAlphaEnd property.
	 * 
	 */
	public int getHouseNumberAlphaEnd()
	{
		return houseNumberAlphaEnd;
	}

	/**
	 * Sets the value of the houseNumberAlphaEnd property.
	 * 
	 */
	public void setHouseNumberAlphaEnd(int value)
	{
		this.houseNumberAlphaEnd = value;
	}

	/**
	 * Gets the value of the levelPrefix property.
	 * 
	 */
	public short getLevelPrefix()
	{
		return levelPrefix;
	}

	/**
	 * Sets the value of the levelPrefix property.
	 * 
	 */
	public void setLevelPrefix(short value)
	{
		this.levelPrefix = value;
	}

	/**
	 * Gets the value of the levelNumberStart property.
	 * 
	 */
	public short getLevelNumberStart()
	{
		return levelNumberStart;
	}

	/**
	 * Sets the value of the levelNumberStart property.
	 * 
	 */
	public void setLevelNumberStart(short value)
	{
		this.levelNumberStart = value;
	}

	/**
	 * Gets the value of the levelNumberEnd property.
	 * 
	 */
	public int getLevelNumberEnd()
	{
		return levelNumberEnd;
	}

	/**
	 * Sets the value of the levelNumberEnd property.
	 * 
	 */
	public void setLevelNumberEnd(int value)
	{
		this.levelNumberEnd = value;
	}

	/**
	 * Gets the value of the referenceAddressType property.
	 * 
	 * @return possible object is {@link Object }
	 * 
	 */
	public Object getReferenceAddressType()
	{
		return referenceAddressType;
	}

	/**
	 * Sets the value of the referenceAddressType property.
	 * 
	 * @param value allowed object is {@link Object }
	 * 
	 */
	public void setReferenceAddressType(Object value)
	{
		this.referenceAddressType = value;
	}

	/**
	 * Gets the value of the action property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAction()
	{
		return action;
	}

	/**
	 * Sets the value of the action property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAction(String value)
	{
		this.action = value;
	}

	/**
	 * Gets the value of the auditStatus property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAuditStatus()
	{
		return auditStatus;
	}

	/**
	 * Sets the value of the auditStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAuditStatus(String value)
	{
		this.auditStatus = value;
	}

	/**
	 * Gets the value of the auditDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getAuditDate()
	{
		return auditDate;
	}

	/**
	 * Sets the value of the auditDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setAuditDate(XMLGregorianCalendar value)
	{
		this.auditDate = value;
	}

	/**
	 * Gets the value of the stateIdentifier property.
	 * 
	 * @return possible object is {@link StateIdentifier }
	 * 
	 */
	public StateIdentifier getStateIdentifier()
	{
		return stateIdentifier;
	}

	/**
	 * Sets the value of the stateIdentifier property.
	 * 
	 * @param value allowed object is {@link StateIdentifier }
	 * 
	 */
	public void setStateIdentifier(StateIdentifier value)
	{
		this.stateIdentifier = value;
	}

	/**
	 * Gets the value of the countryCodeIdentifier property.
	 * 
	 * @return possible object is {@link CountryCodeIdentifier }
	 * 
	 */
	public CountryCodeIdentifier getCountryCodeIdentifier()
	{
		return countryCodeIdentifier;
	}

	/**
	 * Sets the value of the countryCodeIdentifier property.
	 * 
	 * @param value allowed object is {@link CountryCodeIdentifier }
	 * 
	 */
	public void setCountryCodeIdentifier(CountryCodeIdentifier value)
	{
		this.countryCodeIdentifier = value;
	}

	/**
	 * Gets the value of the isPrimary property.
	 * 
	 */
	public boolean isIsPrimary()
	{
		return isPrimary;
	}

	/**
	 * Sets the value of the isPrimary property.
	 * 
	 */
	public void setIsPrimary(boolean value)
	{
		this.isPrimary = value;
	}

}