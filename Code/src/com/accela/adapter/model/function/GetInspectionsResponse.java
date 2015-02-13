package com.accela.adapter.model.function;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.accela.adapter.model.cap.CAPs;
import com.accela.adapter.model.inspection.InspectionSheets;

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
 *         &lt;element name="System">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="XMLVersion" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="ServiceProviderCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="MaxRows" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="StartRow" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="EndRow" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="TotalRows" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="ApplicationState" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="Context" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Error">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="LanguageID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="InspectionSheets">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="InspectionSheet">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Inspections">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Inspection">
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
 *                                                 &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="contextType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="CAPId">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Keys">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="TrackingNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedLong"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="CompactAddress">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Keys">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="addressLines">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                           &lt;element name="CityIdentifier">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Keys">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                           &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                           &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="Alias" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="DetailAddress">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Keys">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="houseNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                                           &lt;element name="houseNumberFraction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="streetDirection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="streetName" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                           &lt;element name="streetSuffix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="streetSuffixDirection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                           &lt;element name="unitEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                           &lt;element name="unitType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                           &lt;element name="CityIdentifier">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Keys">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                           &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                           &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                                           &lt;element name="XCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                           &lt;element name="YCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                           &lt;element name="sourceFlag" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                           &lt;element name="addressTypeFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="houseNumberEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                                           &lt;element name="houseFractionEnd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="streetPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                           &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                           &lt;element name="secondaryRoad" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                           &lt;element name="secondaryRoadNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                           &lt;element name="inspectionDistrictPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                           &lt;element name="inspectionDistrict" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                           &lt;element name="neighborhoodPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                           &lt;element name="neighborhood" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                           &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                           &lt;element name="fullAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                           &lt;element name="houseNumberAlphaStart" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                           &lt;element name="houseNumberAlphaEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                           &lt;element name="levelPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                           &lt;element name="levelNumberStart" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                           &lt;element name="levelNumberEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                           &lt;element name="AuditID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="AuditStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="AuditDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                                           &lt;element name="StateIdentifier">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Keys">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="CountryCodeIdentifier">
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
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                         &lt;/sequence>
 *                                                         &lt;attribute name="isPrimary" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="Type">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Keys">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
 *                                                 &lt;element name="InspectionStatus">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="Keys">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
 *                                                 &lt;element name="InspectionDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                                 &lt;element name="Inspector">
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
 *                                                           &lt;element name="Person">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="familyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="givenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="RequestPhoneNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="DistanceAndTimes">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="DistanceAndTime">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                                                     &lt;element name="LastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
 *                                                 &lt;element name="Guidesheets">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Guidesheet">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="globalId" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                                                     &lt;element name="ownerHistory" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
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
 *                                                                     &lt;element name="contextType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="Type">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="Keys">
 *                                                                                 &lt;complexType>
 *                                                                                   &lt;complexContent>
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                       &lt;sequence>
 *                                                                                         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                                                       &lt;/sequence>
 *                                                                                     &lt;/restriction>
 *                                                                                   &lt;/complexContent>
 *                                                                                 &lt;/complexType>
 *                                                                               &lt;/element>
 *                                                                               &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *                                                                     &lt;element name="Guideitems">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="Guideitem" maxOccurs="unbounded">
 *                                                                                 &lt;complexType>
 *                                                                                   &lt;complexContent>
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                       &lt;sequence>
 *                                                                                         &lt;element name="globalId" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                                                                         &lt;element name="ownerHistory" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                                                                         &lt;element name="Keys">
 *                                                                                           &lt;complexType>
 *                                                                                             &lt;complexContent>
 *                                                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                 &lt;sequence>
 *                                                                                                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                                                                 &lt;/sequence>
 *                                                                                               &lt;/restriction>
 *                                                                                             &lt;/complexContent>
 *                                                                                           &lt;/complexType>
 *                                                                                         &lt;/element>
 *                                                                                         &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                                                         &lt;element name="contextType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="DescriptionEnumeration">
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
 *                                                                                                 &lt;/sequence>
 *                                                                                               &lt;/restriction>
 *                                                                                             &lt;/complexContent>
 *                                                                                           &lt;/complexType>
 *                                                                                         &lt;/element>
 *                                                                                         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                                                                         &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *                                                                                         &lt;element name="DataType">
 *                                                                                           &lt;complexType>
 *                                                                                             &lt;complexContent>
 *                                                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                 &lt;sequence>
 *                                                                                                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                 &lt;/sequence>
 *                                                                                               &lt;/restriction>
 *                                                                                             &lt;/complexContent>
 *                                                                                           &lt;/complexType>
 *                                                                                         &lt;/element>
 *                                                                                         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                                                         &lt;element name="Text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="applicability" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="Status">
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
 *                                                                                                   &lt;element name="EnumerationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                 &lt;/sequence>
 *                                                                                               &lt;/restriction>
 *                                                                                             &lt;/complexContent>
 *                                                                                           &lt;/complexType>
 *                                                                                         &lt;/element>
 *                                                                                         &lt;element name="StatusEnumerationListId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="applicabilityEnumerationListId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="violationCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="carryOverFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="AdditionalInformation">
 *                                                                                           &lt;complexType>
 *                                                                                             &lt;complexContent>
 *                                                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                 &lt;sequence>
 *                                                                                                   &lt;element name="AdditionalInformationGroup" maxOccurs="unbounded">
 *                                                                                                     &lt;complexType>
 *                                                                                                       &lt;complexContent>
 *                                                                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                           &lt;sequence>
 *                                                                                                             &lt;element name="Keys">
 *                                                                                                               &lt;complexType>
 *                                                                                                                 &lt;complexContent>
 *                                                                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                     &lt;sequence>
 *                                                                                                                       &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                                                                                     &lt;/sequence>
 *                                                                                                                   &lt;/restriction>
 *                                                                                                                 &lt;/complexContent>
 *                                                                                                               &lt;/complexType>
 *                                                                                                             &lt;/element>
 *                                                                                                             &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                             &lt;element name="addRemoveSubGroups" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                                                                                                             &lt;element name="AdditionalInformationSubGroup" maxOccurs="unbounded">
 *                                                                                                               &lt;complexType>
 *                                                                                                                 &lt;complexContent>
 *                                                                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                     &lt;sequence>
 *                                                                                                                       &lt;element name="Keys">
 *                                                                                                                         &lt;complexType>
 *                                                                                                                           &lt;complexContent>
 *                                                                                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                               &lt;sequence>
 *                                                                                                                                 &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                               &lt;/sequence>
 *                                                                                                                             &lt;/restriction>
 *                                                                                                                           &lt;/complexContent>
 *                                                                                                                         &lt;/complexType>
 *                                                                                                                       &lt;/element>
 *                                                                                                                       &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                       &lt;element name="AdditionalItems">
 *                                                                                                                         &lt;complexType>
 *                                                                                                                           &lt;complexContent>
 *                                                                                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                               &lt;sequence>
 *                                                                                                                                 &lt;element name="AdditionalItem" maxOccurs="unbounded">
 *                                                                                                                                   &lt;complexType>
 *                                                                                                                                     &lt;complexContent>
 *                                                                                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                                         &lt;sequence>
 *                                                                                                                                           &lt;element name="Keys">
 *                                                                                                                                             &lt;complexType>
 *                                                                                                                                               &lt;complexContent>
 *                                                                                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                                                   &lt;sequence>
 *                                                                                                                                                     &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                                                   &lt;/sequence>
 *                                                                                                                                                 &lt;/restriction>
 *                                                                                                                                               &lt;/complexContent>
 *                                                                                                                                             &lt;/complexType>
 *                                                                                                                                           &lt;/element>
 *                                                                                                                                           &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                                           &lt;element name="DataType">
 *                                                                                                                                             &lt;complexType>
 *                                                                                                                                               &lt;complexContent>
 *                                                                                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                                                   &lt;sequence>
 *                                                                                                                                                     &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                                                     &lt;element name="enumeration" minOccurs="0">
 *                                                                                                                                                       &lt;complexType>
 *                                                                                                                                                         &lt;complexContent>
 *                                                                                                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                                                             &lt;sequence>
 *                                                                                                                                                               &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                                                                                                                             &lt;/sequence>
 *                                                                                                                                                           &lt;/restriction>
 *                                                                                                                                                         &lt;/complexContent>
 *                                                                                                                                                       &lt;/complexType>
 *                                                                                                                                                     &lt;/element>
 *                                                                                                                                                     &lt;element name="inputRange">
 *                                                                                                                                                       &lt;complexType>
 *                                                                                                                                                         &lt;complexContent>
 *                                                                                                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                                                             &lt;sequence>
 *                                                                                                                                                               &lt;element name="minValue" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                                                                                                                                                               &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                                                                                                                                                             &lt;/sequence>
 *                                                                                                                                                           &lt;/restriction>
 *                                                                                                                                                         &lt;/complexContent>
 *                                                                                                                                                       &lt;/complexType>
 *                                                                                                                                                     &lt;/element>
 *                                                                                                                                                     &lt;element name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                                                                                                                                                     &lt;element name="Enumerations" minOccurs="0">
 *                                                                                                                                                       &lt;complexType>
 *                                                                                                                                                         &lt;complexContent>
 *                                                                                                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                                                             &lt;sequence>
 *                                                                                                                                                               &lt;element name="Enumeration" maxOccurs="unbounded">
 *                                                                                                                                                                 &lt;complexType>
 *                                                                                                                                                                   &lt;complexContent>
 *                                                                                                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                                                                       &lt;sequence>
 *                                                                                                                                                                         &lt;element name="Keys">
 *                                                                                                                                                                           &lt;complexType>
 *                                                                                                                                                                             &lt;complexContent>
 *                                                                                                                                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                                                                                 &lt;sequence>
 *                                                                                                                                                                                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                                                                                 &lt;/sequence>
 *                                                                                                                                                                               &lt;/restriction>
 *                                                                                                                                                                             &lt;/complexContent>
 *                                                                                                                                                                           &lt;/complexType>
 *                                                                                                                                                                         &lt;/element>
 *                                                                                                                                                                         &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                                                                       &lt;/sequence>
 *                                                                                                                                                                     &lt;/restriction>
 *                                                                                                                                                                   &lt;/complexContent>
 *                                                                                                                                                                 &lt;/complexType>
 *                                                                                                                                                               &lt;/element>
 *                                                                                                                                                             &lt;/sequence>
 *                                                                                                                                                           &lt;/restriction>
 *                                                                                                                                                         &lt;/complexContent>
 *                                                                                                                                                       &lt;/complexType>
 *                                                                                                                                                     &lt;/element>
 *                                                                                                                                                     &lt;element name="inputRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                                                                                                                     &lt;element name="fieldType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                                                   &lt;/sequence>
 *                                                                                                                                                 &lt;/restriction>
 *                                                                                                                                               &lt;/complexContent>
 *                                                                                                                                             &lt;/complexType>
 *                                                                                                                                           &lt;/element>
 *                                                                                                                                           &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                                           &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                                           &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                                           &lt;element name="drillDown" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                                                                                                         &lt;/sequence>
 *                                                                                                                                       &lt;/restriction>
 *                                                                                                                                     &lt;/complexContent>
 *                                                                                                                                   &lt;/complexType>
 *                                                                                                                                 &lt;/element>
 *                                                                                                                               &lt;/sequence>
 *                                                                                                                             &lt;/restriction>
 *                                                                                                                           &lt;/complexContent>
 *                                                                                                                         &lt;/complexType>
 *                                                                                                                       &lt;/element>
 *                                                                                                                       &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                     &lt;/sequence>
 *                                                                                                                     &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                                                                                     &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                                                                                   &lt;/restriction>
 *                                                                                                                 &lt;/complexContent>
 *                                                                                                               &lt;/complexType>
 *                                                                                                             &lt;/element>
 *                                                                                                             &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                           &lt;/sequence>
 *                                                                                                         &lt;/restriction>
 *                                                                                                       &lt;/complexContent>
 *                                                                                                     &lt;/complexType>
 *                                                                                                   &lt;/element>
 *                                                                                                 &lt;/sequence>
 *                                                                                               &lt;/restriction>
 *                                                                                             &lt;/complexContent>
 *                                                                                           &lt;/complexType>
 *                                                                                         &lt;/element>
 *                                                                                         &lt;element name="critical" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                       &lt;/sequence>
 *                                                                                     &lt;/restriction>
 *                                                                                   &lt;/complexContent>
 *                                                                                 &lt;/complexType>
 *                                                                               &lt;/element>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="RecordedBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="EnumerationLists">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="EnumerationList" maxOccurs="unbounded">
 *                                                                                 &lt;complexType>
 *                                                                                   &lt;complexContent>
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                       &lt;sequence>
 *                                                                                         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="enumeration">
 *                                                                                           &lt;complexType>
 *                                                                                             &lt;complexContent>
 *                                                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                 &lt;sequence>
 *                                                                                                   &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                                                                 &lt;/sequence>
 *                                                                                               &lt;/restriction>
 *                                                                                             &lt;/complexContent>
 *                                                                                           &lt;/complexType>
 *                                                                                         &lt;/element>
 *                                                                                         &lt;element name="Enumerations">
 *                                                                                           &lt;complexType>
 *                                                                                             &lt;complexContent>
 *                                                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                 &lt;sequence>
 *                                                                                                   &lt;element name="Enumeration" maxOccurs="unbounded">
 *                                                                                                     &lt;complexType>
 *                                                                                                       &lt;complexContent>
 *                                                                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                           &lt;sequence>
 *                                                                                                             &lt;element name="Keys">
 *                                                                                                               &lt;complexType>
 *                                                                                                                 &lt;complexContent>
 *                                                                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                     &lt;sequence>
 *                                                                                                                       &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                     &lt;/sequence>
 *                                                                                                                   &lt;/restriction>
 *                                                                                                                 &lt;/complexContent>
 *                                                                                                               &lt;/complexType>
 *                                                                                                             &lt;/element>
 *                                                                                                             &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                             &lt;element name="EnumerationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                             &lt;element name="EnumerationLinkData">
 *                                                                                                               &lt;complexType>
 *                                                                                                                 &lt;complexContent>
 *                                                                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                     &lt;sequence>
 *                                                                                                                       &lt;element name="nonCriticalScore" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                                                                                       &lt;element name="majorViolation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                       &lt;element name="criticalScore" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                                                                                     &lt;/sequence>
 *                                                                                                                   &lt;/restriction>
 *                                                                                                                 &lt;/complexContent>
 *                                                                                                               &lt;/complexType>
 *                                                                                                             &lt;/element>
 *                                                                                                           &lt;/sequence>
 *                                                                                                         &lt;/restriction>
 *                                                                                                       &lt;/complexContent>
 *                                                                                                     &lt;/complexType>
 *                                                                                                   &lt;/element>
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
 *                                                 &lt;element name="SpatialDescriptors">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="GPSReference" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="RecordedBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="autoAssign" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                 &lt;element name="GISObjects" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                                 &lt;element name="overTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="inspBillable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="confirmationNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                                 &lt;element name="guideSheetSecurity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="InspectionRelations" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                                 &lt;element name="Department">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Keys">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="agencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="bureauCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="divisionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="sectionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="groupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="subgroupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="subgroupCodeDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="Staff">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="StaffPerson">
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
 *                                                                               &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="auditStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="serviceProviderCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="agencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="bureauCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="divisionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="sectionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="groupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="officeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *                                                 &lt;element name="isDisplayCommentInACA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="UserRolePrivilege">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="allAcaUserAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                           &lt;element name="capCreatorAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                           &lt;element name="licenseProfessionalAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                           &lt;element name="contactAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                           &lt;element name="ownerAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="inspectionTypeSecurity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="inspectionContactNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="lhsTypeScore" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                 &lt;element name="totalGuideSheetScore" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
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
 *         &lt;element name="CAPs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CAP">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
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
    "system",
    "inspectionSheets",
    "caPs"
})
public class GetInspectionsResponse {

    @XmlElement(name = "System", required = true)
    protected GetInspectionsResponse.System system;
    @XmlElement(name = "InspectionSheets", required = true)
    protected InspectionSheets inspectionSheets;
    @XmlElement(name = "CAPs", required = true)
    protected CAPs caPs;

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link GetInspectionsResponse.System }
     *     
     */
    public GetInspectionsResponse.System getSystem() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetInspectionsResponse.System }
     *     
     */
    public void setSystem(GetInspectionsResponse.System value) {
        this.system = value;
    }

    /**
     * Gets the value of the inspectionSheets property.
     * 
     * @return
     *     possible object is
     *     {@link InspectionSheets }
     *     
     */
    public InspectionSheets getInspectionSheets() {
        return inspectionSheets;
    }

    /**
     * Sets the value of the inspectionSheets property.
     * 
     * @param value
     *     allowed object is
     *     {@link InspectionSheets }
     *     
     */
    public void setInspectionSheets(InspectionSheets value) {
        this.inspectionSheets = value;
    }

    /**
     * Gets the value of the caPs property.
     * 
     * @return
     *     possible object is
     *     {@link GetInspectionsResponse.CAPs }
     *     
     */
    public CAPs getCAPs() {
        return caPs;
    }

    /**
     * Sets the value of the caPs property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetInspectionsResponse.CAPs }
     *     
     */
    public void setCAPs(CAPs value) {
        this.caPs = value;
    }


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
     *         &lt;element name="XMLVersion" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *         &lt;element name="ServiceProviderCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Username" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="MaxRows" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="StartRow" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="EndRow" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="TotalRows" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="ApplicationState" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="Context" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Error">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="LanguageID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "xmlVersion",
        "serviceProviderCode",
        "username",
        "maxRows",
        "startRow",
        "endRow",
        "totalRows",
        "applicationState",
        "context",
        "error",
        "languageID"
    })
    public static class System {

        @XmlElement(name = "XMLVersion")
        @XmlSchemaType(name = "unsignedShort")
        protected int xmlVersion;
        @XmlElement(name = "ServiceProviderCode", required = true)
        protected String serviceProviderCode;
        @XmlElement(name = "Username", required = true)
        protected String username;
        @XmlElement(name = "MaxRows")
        @XmlSchemaType(name = "unsignedByte")
        protected short maxRows;
        @XmlElement(name = "StartRow")
        @XmlSchemaType(name = "unsignedByte")
        protected short startRow;
        @XmlElement(name = "EndRow")
        @XmlSchemaType(name = "unsignedByte")
        protected short endRow;
        @XmlElement(name = "TotalRows")
        @XmlSchemaType(name = "unsignedByte")
        protected short totalRows;
        @XmlElement(name = "ApplicationState", required = true)
        protected BigInteger applicationState;
        @XmlElement(name = "Context", required = true)
        protected String context;
        @XmlElement(name = "Error", required = true)
        protected GetInspectionsResponse.System.Error error;
        @XmlElement(name = "LanguageID", required = true)
        protected String languageID;

        /**
         * Gets the value of the xmlVersion property.
         * 
         */
        public int getXMLVersion() {
            return xmlVersion;
        }

        /**
         * Sets the value of the xmlVersion property.
         * 
         */
        public void setXMLVersion(int value) {
            this.xmlVersion = value;
        }

        /**
         * Gets the value of the serviceProviderCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceProviderCode() {
            return serviceProviderCode;
        }

        /**
         * Sets the value of the serviceProviderCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceProviderCode(String value) {
            this.serviceProviderCode = value;
        }

        /**
         * Gets the value of the username property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUsername() {
            return username;
        }

        /**
         * Sets the value of the username property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUsername(String value) {
            this.username = value;
        }

        /**
         * Gets the value of the maxRows property.
         * 
         */
        public short getMaxRows() {
            return maxRows;
        }

        /**
         * Sets the value of the maxRows property.
         * 
         */
        public void setMaxRows(short value) {
            this.maxRows = value;
        }

        /**
         * Gets the value of the startRow property.
         * 
         */
        public short getStartRow() {
            return startRow;
        }

        /**
         * Sets the value of the startRow property.
         * 
         */
        public void setStartRow(short value) {
            this.startRow = value;
        }

        /**
         * Gets the value of the endRow property.
         * 
         */
        public short getEndRow() {
            return endRow;
        }

        /**
         * Sets the value of the endRow property.
         * 
         */
        public void setEndRow(short value) {
            this.endRow = value;
        }

        /**
         * Gets the value of the totalRows property.
         * 
         */
        public short getTotalRows() {
            return totalRows;
        }

        /**
         * Sets the value of the totalRows property.
         * 
         */
        public void setTotalRows(short value) {
            this.totalRows = value;
        }

        /**
         * Gets the value of the applicationState property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getApplicationState() {
            return applicationState;
        }

        /**
         * Sets the value of the applicationState property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setApplicationState(BigInteger value) {
            this.applicationState = value;
        }

        /**
         * Gets the value of the context property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContext() {
            return context;
        }

        /**
         * Sets the value of the context property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContext(String value) {
            this.context = value;
        }

        /**
         * Gets the value of the error property.
         * 
         * @return
         *     possible object is
         *     {@link GetInspectionsResponse.System.Error }
         *     
         */
        public GetInspectionsResponse.System.Error getError() {
            return error;
        }

        /**
         * Sets the value of the error property.
         * 
         * @param value
         *     allowed object is
         *     {@link GetInspectionsResponse.System.Error }
         *     
         */
        public void setError(GetInspectionsResponse.System.Error value) {
            this.error = value;
        }

        /**
         * Gets the value of the languageID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLanguageID() {
            return languageID;
        }

        /**
         * Sets the value of the languageID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLanguageID(String value) {
            this.languageID = value;
        }


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
         *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
            "errorCode"
        })
        public static class Error {

            @XmlElement(name = "ErrorCode")
            @XmlSchemaType(name = "unsignedByte")
            protected short errorCode;

            /**
             * Gets the value of the errorCode property.
             * 
             */
            public short getErrorCode() {
                return errorCode;
            }

            /**
             * Sets the value of the errorCode property.
             * 
             */
            public void setErrorCode(short value) {
                this.errorCode = value;
            }

        }

    }

}