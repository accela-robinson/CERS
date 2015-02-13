package com.accela.adapter.model.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.accela.adapter.model.Address.CompactAddress;
import com.accela.adapter.model.Address.DetailAddress;
import com.accela.adapter.model.cap.CAPId;
import com.accela.adapter.model.common.Keys;
import com.accela.adapter.model.common.Type;

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
 *         &lt;element name="globalId" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="ownerHistory" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
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
 *         &lt;element name="contextType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CAPId">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="TrackingNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedLong"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CompactAddress">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="addressLines">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="CityIdentifier">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Keys">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Alias" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DetailAddress">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="houseNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;element name="houseNumberFraction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="streetDirection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="streetName" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="streetSuffix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="streetSuffixDirection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="unitEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="unitType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="CityIdentifier">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Keys">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;element name="XCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="YCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="sourceFlag" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="addressTypeFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="houseNumberEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;element name="houseFractionEnd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="streetPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="secondaryRoad" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="secondaryRoadNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="inspectionDistrictPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="inspectionDistrict" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="neighborhoodPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="neighborhood" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="fullAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="houseNumberAlphaStart" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="houseNumberAlphaEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="levelPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="levelNumberStart" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="levelNumberEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="AuditID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="AuditStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="AuditDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="StateIdentifier">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Keys">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="CountryCodeIdentifier">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Keys">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="isPrimary" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Type">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="InspectionStatus">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="InspectionDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Inspector">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Person">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="familyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="givenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RequestPhoneNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DistanceAndTimes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DistanceAndTime">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="LastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Guidesheets">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Guidesheet">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="globalId" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                             &lt;element name="ownerHistory" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                             &lt;element name="Keys">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="contextType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Type">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Keys">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *                             &lt;element name="Guideitems">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Guideitem" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="globalId" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                                 &lt;element name="ownerHistory" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                                 &lt;element name="Keys">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                 &lt;element name="contextType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="DescriptionEnumeration">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Keys">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                                 &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *                                                 &lt;element name="DataType">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                 &lt;element name="Text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="applicability" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="Status">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Keys">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="EnumerationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="StatusEnumerationListId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="applicabilityEnumerationListId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="violationCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="carryOverFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="AdditionalInformation">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="AdditionalInformationGroup" maxOccurs="unbounded">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Keys">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="addRemoveSubGroups" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                                                                     &lt;element name="AdditionalInformationSubGroup" maxOccurs="unbounded">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="Keys">
 *                                                                                 &lt;complexType>
 *                                                                                   &lt;complexContent>
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                       &lt;sequence>
 *                                                                                         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                       &lt;/sequence>
 *                                                                                     &lt;/restriction>
 *                                                                                   &lt;/complexContent>
 *                                                                                 &lt;/complexType>
 *                                                                               &lt;/element>
 *                                                                               &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="AdditionalItems">
 *                                                                                 &lt;complexType>
 *                                                                                   &lt;complexContent>
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                       &lt;sequence>
 *                                                                                         &lt;element name="AdditionalItem" maxOccurs="unbounded">
 *                                                                                           &lt;complexType>
 *                                                                                             &lt;complexContent>
 *                                                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                 &lt;sequence>
 *                                                                                                   &lt;element name="Keys">
 *                                                                                                     &lt;complexType>
 *                                                                                                       &lt;complexContent>
 *                                                                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                           &lt;sequence>
 *                                                                                                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                           &lt;/sequence>
 *                                                                                                         &lt;/restriction>
 *                                                                                                       &lt;/complexContent>
 *                                                                                                     &lt;/complexType>
 *                                                                                                   &lt;/element>
 *                                                                                                   &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                   &lt;element name="DataType">
 *                                                                                                     &lt;complexType>
 *                                                                                                       &lt;complexContent>
 *                                                                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                           &lt;sequence>
 *                                                                                                             &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                             &lt;element name="enumeration" minOccurs="0">
 *                                                                                                               &lt;complexType>
 *                                                                                                                 &lt;complexContent>
 *                                                                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                     &lt;sequence>
 *                                                                                                                       &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                                                                                     &lt;/sequence>
 *                                                                                                                   &lt;/restriction>
 *                                                                                                                 &lt;/complexContent>
 *                                                                                                               &lt;/complexType>
 *                                                                                                             &lt;/element>
 *                                                                                                             &lt;element name="inputRange">
 *                                                                                                               &lt;complexType>
 *                                                                                                                 &lt;complexContent>
 *                                                                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                     &lt;sequence>
 *                                                                                                                       &lt;element name="minValue" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                                                                                                                       &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                                                                                                                     &lt;/sequence>
 *                                                                                                                   &lt;/restriction>
 *                                                                                                                 &lt;/complexContent>
 *                                                                                                               &lt;/complexType>
 *                                                                                                             &lt;/element>
 *                                                                                                             &lt;element name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                                                                                                             &lt;element name="Enumerations" minOccurs="0">
 *                                                                                                               &lt;complexType>
 *                                                                                                                 &lt;complexContent>
 *                                                                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                     &lt;sequence>
 *                                                                                                                       &lt;element name="Enumeration" maxOccurs="unbounded">
 *                                                                                                                         &lt;complexType>
 *                                                                                                                           &lt;complexContent>
 *                                                                                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                               &lt;sequence>
 *                                                                                                                                 &lt;element name="Keys">
 *                                                                                                                                   &lt;complexType>
 *                                                                                                                                     &lt;complexContent>
 *                                                                                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                                         &lt;sequence>
 *                                                                                                                                           &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                                         &lt;/sequence>
 *                                                                                                                                       &lt;/restriction>
 *                                                                                                                                     &lt;/complexContent>
 *                                                                                                                                   &lt;/complexType>
 *                                                                                                                                 &lt;/element>
 *                                                                                                                                 &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                               &lt;/sequence>
 *                                                                                                                             &lt;/restriction>
 *                                                                                                                           &lt;/complexContent>
 *                                                                                                                         &lt;/complexType>
 *                                                                                                                       &lt;/element>
 *                                                                                                                     &lt;/sequence>
 *                                                                                                                   &lt;/restriction>
 *                                                                                                                 &lt;/complexContent>
 *                                                                                                               &lt;/complexType>
 *                                                                                                             &lt;/element>
 *                                                                                                             &lt;element name="inputRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                                                                             &lt;element name="fieldType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                           &lt;/sequence>
 *                                                                                                         &lt;/restriction>
 *                                                                                                       &lt;/complexContent>
 *                                                                                                     &lt;/complexType>
 *                                                                                                   &lt;/element>
 *                                                                                                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                   &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                   &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                   &lt;element name="drillDown" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                                                                 &lt;/sequence>
 *                                                                                               &lt;/restriction>
 *                                                                                             &lt;/complexContent>
 *                                                                                           &lt;/complexType>
 *                                                                                         &lt;/element>
 *                                                                                       &lt;/sequence>
 *                                                                                     &lt;/restriction>
 *                                                                                   &lt;/complexContent>
 *                                                                                 &lt;/complexType>
 *                                                                               &lt;/element>
 *                                                                               &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                             &lt;/sequence>
 *                                                                             &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                                             &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="critical" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="RecordedBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="EnumerationLists">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="EnumerationList" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="enumeration">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Enumerations">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Enumeration" maxOccurs="unbounded">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Keys">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="EnumerationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="EnumerationLinkData">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="nonCriticalScore" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                                               &lt;element name="majorViolation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="criticalScore" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SpatialDescriptors">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="GPSReference" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RecordedBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="autoAssign" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="GISObjects" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="overTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="inspBillable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="confirmationNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="guideSheetSecurity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InspectionRelations" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="Department">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="agencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="bureauCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="divisionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="sectionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="groupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="subgroupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="subgroupCodeDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Staff">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="StaffPerson">
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
 *                                       &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="auditStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="serviceProviderCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="agencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="bureauCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="divisionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="sectionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="groupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="officeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="isDisplayCommentInACA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UserRolePrivilege">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="allAcaUserAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="capCreatorAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="licenseProfessionalAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="contactAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="ownerAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="inspectionTypeSecurity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="inspectionContactNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lhsTypeScore" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="totalGuideSheetScore" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
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
    "globalId",
    "ownerHistory",
    "keys",
    "identifierDisplay",
    "contextType",
    "capId",
    "compactAddress",
    "detailAddress",
    "type",
    "inspectionStatus",
    "inspectionDate",
    "inspector",
    "requestPhoneNum",
    "distanceAndTimes",
    "guidesheets",
    "spatialDescriptors",
    "recordedBy",
    "autoAssign",
    "gisObjects",
    "overTime",
    "inspBillable",
    "confirmationNumber",
    "guideSheetSecurity",
    "inspectionRelations",
    "department",
    "isDisplayCommentInACA",
    "userRolePrivilege",
    "inspectionTypeSecurity",
    "inspectionContactNumber",
    "lhsTypeScore",
    "totalGuideSheetScore"
})
public class Inspection {

    @XmlElement(required = true)
    protected Object globalId;
    @XmlElement(required = true)
    protected Object ownerHistory;
    @XmlElement(name = "Keys", required = true)
    protected Keys keys;
    @XmlElement(name = "IdentifierDisplay", required = true)
    protected String identifierDisplay;
    @XmlElement(required = true)
    protected String contextType;
    @XmlElement(name = "CAPId", required = true)
    protected CAPId capId;
    @XmlElement(name = "CompactAddress", required = true)
    protected CompactAddress compactAddress;
    @XmlElement(name = "DetailAddress", required = true)
    protected DetailAddress detailAddress;
    @XmlElement(name = "Type", required = true)
    protected Type type;
    @XmlElement(name = "InspectionStatus", required = true)
    protected InspectionStatus inspectionStatus;
    @XmlElement(name = "InspectionDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar inspectionDate;
    @XmlElement(name = "Inspector", required = true)
    protected Inspector inspector;
    @XmlElement(name = "RequestPhoneNum", required = true)
    protected String requestPhoneNum;
    @XmlElement(name = "DistanceAndTimes", required = true)
    protected DistanceAndTimes distanceAndTimes;
    @XmlElement(name = "Guidesheets", required = true)
    protected Guidesheets guidesheets;
    @XmlElement(name = "SpatialDescriptors", required = true)
    protected SpatialDescriptors spatialDescriptors;
    @XmlElement(name = "RecordedBy", required = true)
    protected String recordedBy;
    protected boolean autoAssign;
    @XmlElement(name = "GISObjects", required = true)
    protected Object gisObjects;
    @XmlElement(required = true)
    protected String overTime;
    @XmlElement(required = true)
    protected String inspBillable;
    @XmlSchemaType(name = "unsignedInt")
    protected long confirmationNumber;
    @XmlElement(required = true)
    protected String guideSheetSecurity;
    @XmlElement(name = "InspectionRelations", required = true)
    protected Object inspectionRelations;
    @XmlElement(name = "Department", required = true)
    protected Department department;
    @XmlElement(required = true)
    protected String isDisplayCommentInACA;
    @XmlElement(name = "UserRolePrivilege", required = true)
    protected UserRolePrivilege userRolePrivilege;
    @XmlElement(required = true)
    protected String inspectionTypeSecurity;
    @XmlElement(required = true)
    protected String inspectionContactNumber;
    @XmlSchemaType(name = "unsignedShort")
    protected int lhsTypeScore;
    @XmlSchemaType(name = "unsignedShort")
    protected int totalGuideSheetScore;

    /**
     * Gets the value of the globalId property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getGlobalId() {
        return globalId;
    }

    /**
     * Sets the value of the globalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setGlobalId(Object value) {
        this.globalId = value;
    }

    /**
     * Gets the value of the ownerHistory property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getOwnerHistory() {
        return ownerHistory;
    }

    /**
     * Sets the value of the ownerHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setOwnerHistory(Object value) {
        this.ownerHistory = value;
    }

    /**
     * Gets the value of the keys property.
     * 
     * @return
     *     possible object is
     *     {@link Inspection.Keys }
     *     
     */
    public Keys getKeys() {
        return keys;
    }

    /**
     * Sets the value of the keys property.
     * 
     * @param value
     *     allowed object is
     *     {@link Inspection.Keys }
     *     
     */
    public void setKeys(Keys value) {
        this.keys = value;
    }

    /**
     * Gets the value of the identifierDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifierDisplay() {
        return identifierDisplay;
    }

    /**
     * Sets the value of the identifierDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifierDisplay(String value) {
        this.identifierDisplay = value;
    }

    /**
     * Gets the value of the contextType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextType() {
        return contextType;
    }

    /**
     * Sets the value of the contextType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextType(String value) {
        this.contextType = value;
    }

    /**
     * Gets the value of the capId property.
     * 
     * @return
     *     possible object is
     *     {@link Inspection.CAPId }
     *     
     */
    public CAPId getCAPId() {
        return capId;
    }

    /**
     * Sets the value of the capId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Inspection.CAPId }
     *     
     */
    public void setCAPId(CAPId value) {
        this.capId = value;
    }

    /**
     * Gets the value of the compactAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Inspection.CompactAddress }
     *     
     */
    public CompactAddress getCompactAddress() {
        return compactAddress;
    }

    /**
     * Sets the value of the compactAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Inspection.CompactAddress }
     *     
     */
    public void setCompactAddress(CompactAddress value) {
        this.compactAddress = value;
    }

    /**
     * Gets the value of the detailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Inspection.DetailAddress }
     *     
     */
    public DetailAddress getDetailAddress() {
        return detailAddress;
    }

    /**
     * Sets the value of the detailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Inspection.DetailAddress }
     *     
     */
    public void setDetailAddress(DetailAddress value) {
        this.detailAddress = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Inspection.Type }
     *     
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Inspection.Type }
     *     
     */
    public void setType(Type value) {
        this.type = value;
    }

    /**
     * Gets the value of the inspectionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link InspectionStatus }
     *     
     */
    public InspectionStatus getInspectionStatus() {
        return inspectionStatus;
    }

    /**
     * Sets the value of the inspectionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link InspectionStatus }
     *     
     */
    public void setInspectionStatus(InspectionStatus value) {
        this.inspectionStatus = value;
    }

    /**
     * Gets the value of the inspectionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInspectionDate() {
        return inspectionDate;
    }

    /**
     * Sets the value of the inspectionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInspectionDate(XMLGregorianCalendar value) {
        this.inspectionDate = value;
    }

    /**
     * Gets the value of the inspector property.
     * 
     * @return
     *     possible object is
     *     {@link Inspector }
     *     
     */
    public Inspector getInspector() {
        return inspector;
    }

    /**
     * Sets the value of the inspector property.
     * 
     * @param value
     *     allowed object is
     *     {@link Inspector }
     *     
     */
    public void setInspector(Inspector value) {
        this.inspector = value;
    }

    /**
     * Gets the value of the requestPhoneNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestPhoneNum() {
        return requestPhoneNum;
    }

    /**
     * Sets the value of the requestPhoneNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestPhoneNum(String value) {
        this.requestPhoneNum = value;
    }

    /**
     * Gets the value of the distanceAndTimes property.
     * 
     * @return
     *     possible object is
     *     {@link DistanceAndTimes }
     *     
     */
    public DistanceAndTimes getDistanceAndTimes() {
        return distanceAndTimes;
    }

    /**
     * Sets the value of the distanceAndTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistanceAndTimes }
     *     
     */
    public void setDistanceAndTimes(DistanceAndTimes value) {
        this.distanceAndTimes = value;
    }

    /**
     * Gets the value of the guidesheets property.
     * 
     * @return
     *     possible object is
     *     {@link Guidesheets }
     *     
     */
    public Guidesheets getGuidesheets() {
        return guidesheets;
    }

    /**
     * Sets the value of the guidesheets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Guidesheets }
     *     
     */
    public void setGuidesheets(Guidesheets value) {
        this.guidesheets = value;
    }

    /**
     * Gets the value of the spatialDescriptors property.
     * 
     * @return
     *     possible object is
     *     {@link SpatialDescriptors }
     *     
     */
    public SpatialDescriptors getSpatialDescriptors() {
        return spatialDescriptors;
    }

    /**
     * Sets the value of the spatialDescriptors property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpatialDescriptors }
     *     
     */
    public void setSpatialDescriptors(SpatialDescriptors value) {
        this.spatialDescriptors = value;
    }

    /**
     * Gets the value of the recordedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordedBy() {
        return recordedBy;
    }

    /**
     * Sets the value of the recordedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordedBy(String value) {
        this.recordedBy = value;
    }

    /**
     * Gets the value of the autoAssign property.
     * 
     */
    public boolean isAutoAssign() {
        return autoAssign;
    }

    /**
     * Sets the value of the autoAssign property.
     * 
     */
    public void setAutoAssign(boolean value) {
        this.autoAssign = value;
    }

    /**
     * Gets the value of the gisObjects property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getGISObjects() {
        return gisObjects;
    }

    /**
     * Sets the value of the gisObjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setGISObjects(Object value) {
        this.gisObjects = value;
    }

    /**
     * Gets the value of the overTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverTime() {
        return overTime;
    }

    /**
     * Sets the value of the overTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverTime(String value) {
        this.overTime = value;
    }

    /**
     * Gets the value of the inspBillable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInspBillable() {
        return inspBillable;
    }

    /**
     * Sets the value of the inspBillable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInspBillable(String value) {
        this.inspBillable = value;
    }

    /**
     * Gets the value of the confirmationNumber property.
     * 
     */
    public long getConfirmationNumber() {
        return confirmationNumber;
    }

    /**
     * Sets the value of the confirmationNumber property.
     * 
     */
    public void setConfirmationNumber(long value) {
        this.confirmationNumber = value;
    }

    /**
     * Gets the value of the guideSheetSecurity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuideSheetSecurity() {
        return guideSheetSecurity;
    }

    /**
     * Sets the value of the guideSheetSecurity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuideSheetSecurity(String value) {
        this.guideSheetSecurity = value;
    }

    /**
     * Gets the value of the inspectionRelations property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getInspectionRelations() {
        return inspectionRelations;
    }

    /**
     * Sets the value of the inspectionRelations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setInspectionRelations(Object value) {
        this.inspectionRelations = value;
    }

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link Department }
     *     
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link Department }
     *     
     */
    public void setDepartment(Department value) {
        this.department = value;
    }

    /**
     * Gets the value of the isDisplayCommentInACA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsDisplayCommentInACA() {
        return isDisplayCommentInACA;
    }

    /**
     * Sets the value of the isDisplayCommentInACA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsDisplayCommentInACA(String value) {
        this.isDisplayCommentInACA = value;
    }

    /**
     * Gets the value of the userRolePrivilege property.
     * 
     * @return
     *     possible object is
     *     {@link UserRolePrivilege }
     *     
     */
    public UserRolePrivilege getUserRolePrivilege() {
        return userRolePrivilege;
    }

    /**
     * Sets the value of the userRolePrivilege property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserRolePrivilege }
     *     
     */
    public void setUserRolePrivilege(UserRolePrivilege value) {
        this.userRolePrivilege = value;
    }

    /**
     * Gets the value of the inspectionTypeSecurity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInspectionTypeSecurity() {
        return inspectionTypeSecurity;
    }

    /**
     * Sets the value of the inspectionTypeSecurity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInspectionTypeSecurity(String value) {
        this.inspectionTypeSecurity = value;
    }

    /**
     * Gets the value of the inspectionContactNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInspectionContactNumber() {
        return inspectionContactNumber;
    }

    /**
     * Sets the value of the inspectionContactNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInspectionContactNumber(String value) {
        this.inspectionContactNumber = value;
    }

    /**
     * Gets the value of the lhsTypeScore property.
     * 
     */
    public int getLhsTypeScore() {
        return lhsTypeScore;
    }

    /**
     * Sets the value of the lhsTypeScore property.
     * 
     */
    public void setLhsTypeScore(int value) {
        this.lhsTypeScore = value;
    }

    /**
     * Gets the value of the totalGuideSheetScore property.
     * 
     */
    public int getTotalGuideSheetScore() {
        return totalGuideSheetScore;
    }

    /**
     * Sets the value of the totalGuideSheetScore property.
     * 
     */
    public void setTotalGuideSheetScore(int value) {
        this.totalGuideSheetScore = value;
    }

}