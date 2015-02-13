//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.21 at 02:38:20 PM GMT+08:00 
//


package com.accela.cers.cap.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HWUnitPBRType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HWUnitPBRType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="AWHexavalentChromiumReduction" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWMAdjustmentNeutralization" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWMPrecipitationOrCrystallization" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWMSeparation" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWMIonExchange" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWMReverseOsmosis" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWMMetallicReplacement" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWMPlatingOntoElectrode" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWMElectrodialysis" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWMElectrowinningElectrolyticRecovery" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWMChemicalStabilization" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWMEvaporation" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWMAdsorption" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWOPhaseSeparation" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWOAdsorption" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWODistillation" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWOBiologicalUsingMicroOrganisms" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWOPhotodegradationEnclosedSystem" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AWOAirStrippingSteamStripping" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="SDSChemicalStabilization" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="SDSGrindShredCrushCompact" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="SDSDryingRemoveWater" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="SDSSeparationBySize" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AGChemicalStabilization" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AGDryingRemoveWater" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="AGPhaseSeparation" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="SWChemicalStabilization" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="SWDryingRemoveWater" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="SWPhaseSeparation" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="SWScreeningBasedSize" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="SWSeparationBySize" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="WEAChemicalStabilization" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="WEADryingRemoveWater" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="WEAPhaseSeparation" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="WEAMagneticSeparation" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="InorganicAdjustmentNeutralization" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="SWMChemicalStabilization" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="SWMSeparationBySize" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="SWMMagneticSeparation" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="UOSeparation" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="UODistillation" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="UONeutralization" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="UOSeparationBySize" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="UOReverseOsmosis" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="UOBiologicalUsingMicroorganisms" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="ContainersRinsing" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="ContainersCrushShredGrind" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="MultiComponentResin" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="WastestreamTechnologyCombination" minOccurs="0">
 *             &lt;simpleType>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                 &lt;maxLength value="10"/>
 *                 &lt;minLength value="0"/>
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *           &lt;/element>
 *           &lt;element name="CRByHypochlorite" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="CRByPeroxide" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="CRAlkaline" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="CRElectrochemical" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="CRIonExchange" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="CRReverseOsmosis" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="ROByHypochlorite" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="ROByPeroxide" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="ROAlkaline" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="ROElectrochemical" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="ROIonExchange" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="ROReverseOsmosis" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="TERByHypochlorite" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="TERByPeroxide" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="TERAlkaline" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="TERElectrochemical" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="TERIonExchange" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="TERReverseOsmosis" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="ABByHypochlorite" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="ABByPeroxide" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="ABAlkaline" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="ABElectrochemical" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="ABIonExchange" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="ABReverseOsmosis" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="OLByHypochlorite" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="OLByPeroxide" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="OLAlkaline" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="OLElectrochemical" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="OLIonExchange" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="OLReverseOsmosis" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="Electrowinning" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="PSByHypochlorite" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="PSByPeroxide" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="PSAlkaline" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="PSElectrochemical" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="PSIonExchange" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *           &lt;element name="PSReverseOsmosis" type="{http://cersservices.calepa.ca.gov/Schemas/RegulatorFacilitySubmittalQuery/1/05/}YesNoFlagType" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HWUnitPBRType", propOrder = {
    "awHexavalentChromiumReductionOrAWMAdjustmentNeutralizationOrAWMPrecipitationOrCrystallization"
})
public class HWUnitPBRType {

    @XmlElementRefs({
        @XmlElementRef(name = "Electrowinning", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PSByPeroxide", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ABIonExchange", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWMElectrowinningElectrolyticRecovery", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWOAirStrippingSteamStripping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWMEvaporation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SWSeparationBySize", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ABByHypochlorite", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CRByPeroxide", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWOBiologicalUsingMicroOrganisms", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SWScreeningBasedSize", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWMAdsorption", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SWMChemicalStabilization", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TERIonExchange", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WEAChemicalStabilization", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWMIonExchange", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SWPhaseSeparation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PSReverseOsmosis", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWMSeparation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OLByHypochlorite", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CRAlkaline", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CRElectrochemical", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AGPhaseSeparation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWOPhotodegradationEnclosedSystem", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SWMSeparationBySize", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OLAlkaline", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWODistillation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CRIonExchange", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AGDryingRemoveWater", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WEAPhaseSeparation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OLByPeroxide", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ROIonExchange", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWMReverseOsmosis", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PSIonExchange", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TERByHypochlorite", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TERByPeroxide", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AGChemicalStabilization", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OLElectrochemical", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ROReverseOsmosis", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ABElectrochemical", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ROAlkaline", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWOPhaseSeparation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWMMetallicReplacement", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CRReverseOsmosis", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ABByPeroxide", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WEADryingRemoveWater", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CRByHypochlorite", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OLIonExchange", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SWDryingRemoveWater", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PSElectrochemical", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWMPrecipitationOrCrystallization", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWMElectrodialysis", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PSByHypochlorite", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TERReverseOsmosis", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SDSDryingRemoveWater", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWHexavalentChromiumReduction", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "InorganicAdjustmentNeutralization", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UODistillation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UOSeparationBySize", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WEAMagneticSeparation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ROElectrochemical", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ABReverseOsmosis", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SDSSeparationBySize", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SWChemicalStabilization", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TERElectrochemical", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UOBiologicalUsingMicroorganisms", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OLReverseOsmosis", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SDSGrindShredCrushCompact", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWOAdsorption", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWMAdjustmentNeutralization", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UOReverseOsmosis", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WastestreamTechnologyCombination", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TERAlkaline", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SWMMagneticSeparation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ROByPeroxide", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UOSeparation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UONeutralization", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MultiComponentResin", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ROByHypochlorite", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PSAlkaline", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWMChemicalStabilization", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AWMPlatingOntoElectrode", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ContainersRinsing", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SDSChemicalStabilization", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ContainersCrushShredGrind", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ABAlkaline", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> awHexavalentChromiumReductionOrAWMAdjustmentNeutralizationOrAWMPrecipitationOrCrystallization;

    /**
     * Gets the value of the awHexavalentChromiumReductionOrAWMAdjustmentNeutralizationOrAWMPrecipitationOrCrystallization property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the awHexavalentChromiumReductionOrAWMAdjustmentNeutralizationOrAWMPrecipitationOrCrystallization property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAWHexavalentChromiumReductionOrAWMAdjustmentNeutralizationOrAWMPrecipitationOrCrystallization().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * {@link JAXBElement }{@code <}{@link YesNoFlagType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getAWHexavalentChromiumReductionOrAWMAdjustmentNeutralizationOrAWMPrecipitationOrCrystallization() {
        if (awHexavalentChromiumReductionOrAWMAdjustmentNeutralizationOrAWMPrecipitationOrCrystallization == null) {
            awHexavalentChromiumReductionOrAWMAdjustmentNeutralizationOrAWMPrecipitationOrCrystallization = new ArrayList<JAXBElement<?>>();
        }
        return this.awHexavalentChromiumReductionOrAWMAdjustmentNeutralizationOrAWMPrecipitationOrCrystallization;
    }

}
