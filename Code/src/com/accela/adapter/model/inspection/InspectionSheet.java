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
 *         &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Inspections">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Inspection">
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
 *                             &lt;element name="CAPId">
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
 *                                       &lt;element name="TrackingNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedLong"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="CompactAddress">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Keys">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="addressLines">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                       &lt;element name="CityIdentifier">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Keys">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                       &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                       &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Alias" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="DetailAddress">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Keys">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="houseNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                       &lt;element name="houseNumberFraction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="streetDirection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="streetName" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                       &lt;element name="streetSuffix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="streetSuffixDirection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                       &lt;element name="unitEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                       &lt;element name="unitType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                       &lt;element name="CityIdentifier">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Keys">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                       &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                       &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                       &lt;element name="XCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                       &lt;element name="YCoordinate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                       &lt;element name="sourceFlag" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                       &lt;element name="addressTypeFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="houseNumberEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                       &lt;element name="houseFractionEnd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="streetPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                       &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                       &lt;element name="secondaryRoad" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                       &lt;element name="secondaryRoadNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                       &lt;element name="inspectionDistrictPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                       &lt;element name="inspectionDistrict" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                       &lt;element name="neighborhoodPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                       &lt;element name="neighborhood" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                       &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                       &lt;element name="fullAddress" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                       &lt;element name="houseNumberAlphaStart" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                       &lt;element name="houseNumberAlphaEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                       &lt;element name="levelPrefix" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                       &lt;element name="levelNumberStart" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                       &lt;element name="levelNumberEnd" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                       &lt;element name="AuditID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="AuditStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="AuditDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                       &lt;element name="StateIdentifier">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Keys">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="CountryCodeIdentifier">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Keys">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="isPrimary" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
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
 *                             &lt;element name="InspectionStatus">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="InspectionDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="Inspector">
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
 *                                       &lt;element name="Person">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="familyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="givenName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="RequestPhoneNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="DistanceAndTimes">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="DistanceAndTime">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                                 &lt;element name="LastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
 *                             &lt;element name="Guidesheets">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Guidesheet">
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
 *                                                 &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *                                                 &lt;element name="Guideitems">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="Guideitem" maxOccurs="unbounded">
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
 *                                                                     &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                                                                     &lt;element name="contextType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="DescriptionEnumeration">
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
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                                                     &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *                                                                     &lt;element name="DataType">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                                     &lt;element name="Text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="applicability" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="Status">
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
 *                                                                               &lt;element name="EnumerationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="StatusEnumerationListId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="applicabilityEnumerationListId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="violationCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="carryOverFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="AdditionalInformation">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="AdditionalInformationGroup" maxOccurs="unbounded">
 *                                                                                 &lt;complexType>
 *                                                                                   &lt;complexContent>
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                       &lt;sequence>
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
 *                                                                                         &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="addRemoveSubGroups" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                                                                                         &lt;element name="AdditionalInformationSubGroup" maxOccurs="unbounded">
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
 *                                                                                                   &lt;element name="AdditionalItems">
 *                                                                                                     &lt;complexType>
 *                                                                                                       &lt;complexContent>
 *                                                                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                           &lt;sequence>
 *                                                                                                             &lt;element name="AdditionalItem" maxOccurs="unbounded">
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
 *                                                                                                                       &lt;element name="DataType">
 *                                                                                                                         &lt;complexType>
 *                                                                                                                           &lt;complexContent>
 *                                                                                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                               &lt;sequence>
 *                                                                                                                                 &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                                 &lt;element name="enumeration" minOccurs="0">
 *                                                                                                                                   &lt;complexType>
 *                                                                                                                                     &lt;complexContent>
 *                                                                                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                                         &lt;sequence>
 *                                                                                                                                           &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                                                                                                         &lt;/sequence>
 *                                                                                                                                       &lt;/restriction>
 *                                                                                                                                     &lt;/complexContent>
 *                                                                                                                                   &lt;/complexType>
 *                                                                                                                                 &lt;/element>
 *                                                                                                                                 &lt;element name="inputRange">
 *                                                                                                                                   &lt;complexType>
 *                                                                                                                                     &lt;complexContent>
 *                                                                                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                                         &lt;sequence>
 *                                                                                                                                           &lt;element name="minValue" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                                                                                                                                           &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                                                                                                                                         &lt;/sequence>
 *                                                                                                                                       &lt;/restriction>
 *                                                                                                                                     &lt;/complexContent>
 *                                                                                                                                   &lt;/complexType>
 *                                                                                                                                 &lt;/element>
 *                                                                                                                                 &lt;element name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                                                                                                                                 &lt;element name="Enumerations" minOccurs="0">
 *                                                                                                                                   &lt;complexType>
 *                                                                                                                                     &lt;complexContent>
 *                                                                                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                                         &lt;sequence>
 *                                                                                                                                           &lt;element name="Enumeration" maxOccurs="unbounded">
 *                                                                                                                                             &lt;complexType>
 *                                                                                                                                               &lt;complexContent>
 *                                                                                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                                                   &lt;sequence>
 *                                                                                                                                                     &lt;element name="Keys">
 *                                                                                                                                                       &lt;complexType>
 *                                                                                                                                                         &lt;complexContent>
 *                                                                                                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                                                                             &lt;sequence>
 *                                                                                                                                                               &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                                                             &lt;/sequence>
 *                                                                                                                                                           &lt;/restriction>
 *                                                                                                                                                         &lt;/complexContent>
 *                                                                                                                                                       &lt;/complexType>
 *                                                                                                                                                     &lt;/element>
 *                                                                                                                                                     &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                                                   &lt;/sequence>
 *                                                                                                                                                 &lt;/restriction>
 *                                                                                                                                               &lt;/complexContent>
 *                                                                                                                                             &lt;/complexType>
 *                                                                                                                                           &lt;/element>
 *                                                                                                                                         &lt;/sequence>
 *                                                                                                                                       &lt;/restriction>
 *                                                                                                                                     &lt;/complexContent>
 *                                                                                                                                   &lt;/complexType>
 *                                                                                                                                 &lt;/element>
 *                                                                                                                                 &lt;element name="inputRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                                                                                                                 &lt;element name="fieldType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                               &lt;/sequence>
 *                                                                                                                             &lt;/restriction>
 *                                                                                                                           &lt;/complexContent>
 *                                                                                                                         &lt;/complexType>
 *                                                                                                                       &lt;/element>
 *                                                                                                                       &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                       &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                       &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                                       &lt;element name="drillDown" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
 *                                                                                                   &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                 &lt;/sequence>
 *                                                                                                 &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                                                                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                                                               &lt;/restriction>
 *                                                                                             &lt;/complexContent>
 *                                                                                           &lt;/complexType>
 *                                                                                         &lt;/element>
 *                                                                                         &lt;element name="security" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *                                                                     &lt;element name="critical" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *                                                 &lt;element name="RecordedBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="EnumerationLists">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="EnumerationList" maxOccurs="unbounded">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="enumeration">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="String" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                     &lt;element name="Enumerations">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="Enumeration" maxOccurs="unbounded">
 *                                                                                 &lt;complexType>
 *                                                                                   &lt;complexContent>
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                       &lt;sequence>
 *                                                                                         &lt;element name="Keys">
 *                                                                                           &lt;complexType>
 *                                                                                             &lt;complexContent>
 *                                                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                 &lt;sequence>
 *                                                                                                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                 &lt;/sequence>
 *                                                                                               &lt;/restriction>
 *                                                                                             &lt;/complexContent>
 *                                                                                           &lt;/complexType>
 *                                                                                         &lt;/element>
 *                                                                                         &lt;element name="IdentifierDisplay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="EnumerationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                         &lt;element name="EnumerationLinkData">
 *                                                                                           &lt;complexType>
 *                                                                                             &lt;complexContent>
 *                                                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                                 &lt;sequence>
 *                                                                                                   &lt;element name="nonCriticalScore" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                                                                                   &lt;element name="majorViolation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                                                   &lt;element name="criticalScore" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
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
 *                             &lt;element name="SpatialDescriptors">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="GPSReference" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="RecordedBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="autoAssign" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;element name="GISObjects" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                             &lt;element name="overTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="inspBillable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="confirmationNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                             &lt;element name="guideSheetSecurity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="InspectionRelations" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                             &lt;element name="Department">
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
 *                                       &lt;element name="agencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="bureauCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="divisionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="sectionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="groupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="subgroupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="subgroupCodeDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Staff">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="StaffPerson">
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
 *                                                           &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="auditStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="serviceProviderCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="agencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="bureauCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="divisionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="sectionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="groupCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="officeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *                             &lt;element name="isDisplayCommentInACA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="UserRolePrivilege">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="allAcaUserAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                       &lt;element name="capCreatorAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                       &lt;element name="licenseProfessionalAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                       &lt;element name="contactAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                       &lt;element name="ownerAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="inspectionTypeSecurity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="inspectionContactNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="lhsTypeScore" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                             &lt;element name="totalGuideSheetScore" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
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
    "identifierDisplay",
    "inspections"
})
public class InspectionSheet {

    @XmlElement(name = "IdentifierDisplay", required = true)
    protected String identifierDisplay;
    @XmlElement(name = "Inspections", required = true)
    protected Inspections inspections;

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
     * Gets the value of the inspections property.
     * 
     * @return
     *     possible object is
     *     {@link Inspections }
     *     
     */
    public Inspections getInspections() {
        return inspections;
    }

    /**
     * Sets the value of the inspections property.
     * 
     * @param value
     *     allowed object is
     *     {@link Inspections }
     *     
     */
    public void setInspections(Inspections value) {
        this.inspections = value;
    }

}