package com.accela.cers;

import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBElement;

import com.accela.adapter.model.cap.CAPId;
import com.accela.adapter.model.cap.InitiateCAP;
import com.accela.adapter.model.common.AdditionalInformation;
import com.accela.adapter.model.common.AdditionalInformationGroup;
import com.accela.adapter.model.common.AdditionalInformationSubGroup;
import com.accela.adapter.model.common.AdditionalItem;
import com.accela.adapter.model.common.AdditionalItems;
import com.accela.adapter.model.function.UpdateCAP;
import com.accela.adapter.service.impl.AuthService;
import com.accela.adapter.util.CapUtil;
import com.accela.cers.cap.model.FacilitySubmittalType;
import com.accela.cers.cap.model.HWUnitCAType;
import com.accela.cers.cap.model.HWUnitCELType;
import com.accela.cers.cap.model.HWUnitCESQTType;
import com.accela.cers.cap.model.HWUnitCESWType;
import com.accela.cers.cap.model.HWUnitPBRType;
import com.accela.cers.cap.model.HWUnitType;
import com.accela.cers.cap.model.SubmittalElementHeaderType;

/**
 * <pre>
 *
 *  Accela Automation
 *  File: HazardousWasteConverter.java
 *
 *  Accela, Inc.
 *  Copyright (C): 2012-2013
 *
 *  Description:
 *  TODO
 *
 *  Notes:
 * 	$Id: HazardousWasteConverter.java 72642 2009-01-01 20:01:57Z ACHIEVO\zony.rao $
 *
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2012-11-29		zony.rao		Initial.
 *
 * </pre>
 */
public class HazardousWasteConverter extends ICAPConvert
{

	public InitiateCAP convertToInitCAP(List<AdditionalInformation> additionInfos, Object currObject,String strdatetime, Object... objects)

	{

		HWUnitType hwu = (HWUnitType) currObject;

		List<AdditionalInformation> addInfos = additionInfos;
		InitiateCAP initCap = new InitiateCAP();
		initCap.setCAPTypeId(CapUtil.getCapTypeIdByString("Waste"));
		initCap.setSystem(AuthService.getSystem());
		initCap.setFinalizeNow(true);
		FacilitySubmittalType facilitySubmittalType = null;
		if(objects != null && objects.length > 0 )
		{
			if (objects[0] instanceof FacilitySubmittalType)
			{
				facilitySubmittalType = (FacilitySubmittalType) objects[0];
			}
		}

		AdditionalInformation addCopy = addInfos.get(0).clone();
		initCap.setAdditionalInformation(addCopy);
		initCap.setStatus(CapUtil.getDefaultStatusByCapType(cb.get("Waste.capType")));

		for (AdditionalInformationGroup ag : addCopy.getAdditionalInformationGroup())
		{
			List<AdditionalInformationSubGroup> ags = ag.getAdditionalInformationSubGroup();
			for (AdditionalInformationSubGroup asg : ags)
			{
				if (ag.isAddRemoveSubGroups())
				{ // asit
					asg.setAction("Add");
				}
				else
				// asi
				{
					for (AdditionalItem ai : asg.getAdditionalItems().getAdditionalItem())
					{
						ai.setAction("Add");
					}
				}

			}

		}
		Collection<AdditionalInformationGroup> addInfoGroup = initCap.getAdditionalInformation()
				.getAdditionalInformationGroup();
		setAsi(addInfoGroup, hwu, facilitySubmittalType);
		HWUnitPBRType pbr = hwu.getHWUnitPBR();
		if (pbr != null)
		{
			PermitbyRule(addInfoGroup, pbr);
		}
		HWUnitCAType ca = hwu.getHWUnitCA();
		if (ca != null)
		{
			dealHWUnitCAType(addInfoGroup, ca);
		}
		HWUnitCESWType cesw = hwu.getHWUnitCESW();
		if (cesw != null)
		{
			dealHWUnitCESWType(addInfoGroup, cesw);
		}
		HWUnitCESQTType cesq = hwu.getHWUnitCESQT();
		if (cesq != null)
		{
			dealHWUnitCESQTType(addInfoGroup, cesq);
		}

		HWUnitCELType cel = hwu.getHWUnitCEL();
		if (cel != null)
		{
			dealHWUnitCELType(addInfoGroup, cel);
		}

		OnsiteHWTreatmentNotificationUnit(addInfoGroup, hwu);

		//Remove useless ASIT.
		List<AdditionalInformationGroup> group = addCopy.getAdditionalInformationGroup();
		String needUpdatedASITName= (String)cb.get("NeedUpdatedASIT4Waste");
		AdditionalInformationGroup ag = null;
		for (int i = group.size() - 1; i >= 0; i--)
		{
			ag = group.get(i);
			String identifierDisplay = ag.getIdentifierDisplay();
			if (!needUpdatedASITName.contains(identifierDisplay)
					|| (cesq == null && ("DEH_HUPW_T27/CESQT - WST & TX PROCESS COMBS").equals(identifierDisplay)))
			{
				group.remove(i);
			}
		}
		return initCap;
	}

	/**
	 * Generator Identification TODO. Hazardous Waste Tank Closure Certification asi
	 *
	 * @param initCap
	 * @param pbr
	 * @return
	 */
	// public InitiateCAP hwTankccAsi(InitiateCAP initCap, HWUnitPBRType pbr)
	// {
	// AdditionalInformationSubGroup subGroup = null;
	// AdditionalItems asitAdditems = null;
	// Collection<AdditionalInformationGroup> addInfoGroup = initCap.getAdditionalInformation()
	// .getAdditionalInformationGroup();
	// // PERMIT BY RULE (PBR) COMBOS DEH_HUPW_T27
	// Object[] obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUPW_T27", "ONSITE HAZ WST TX NOTIF - UNIT");
	// if (obs != null)
	// {
	// subGroup = (AdditionalInformationSubGroup) obs[1];
	// asitAdditems = subGroup.getAdditionalItems();
	// }
	// return initCap;
	// }

	/**
	 * Generator Identification TODO.
	 *
	 * @param initCap
	 * @param pbr
	 * @return
	 */
	private void PermitbyRule(Collection<AdditionalInformationGroup> addInfoGroup, HWUnitPBRType pbr)
	{
		AdditionalInformationSubGroup subGroup = null;
		AdditionalItems asitAdditems = null;

		// PERMIT BY RULE (PBR) COMBOS DEH_HUPW_T27
		Object[] obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUPW_T27", "PERMIT BY RULE (PBR)");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			List<JAXBElement<?>> list = pbr
					.getAWHexavalentChromiumReductionOrAWMAdjustmentNeutralizationOrAWMPrecipitationOrCrystallization();
			for (JAXBElement<?> el : list)
			{
				if ("AWHexavalentChromiumReduction".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWHexavalentChromiumReduction"), asitAdditems), el.getValue());
				}
				else if ("AWMAdjustmentNeutralization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWMAdjustmentNeutralization"), asitAdditems), el.getValue());
				}
				else if ("AWMPrecipitationOrCrystallization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWMPrecipitationOrCrystallization"), asitAdditems), el.getValue());
				}
				else if ("AWMSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWMSeparation"), asitAdditems), el.getValue());
				}
				else if ("AWMIonExchange".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWMIonExchange"), asitAdditems), el.getValue());
				}
				else if ("AWMReverseOsmosis".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWMReverseOsmosis"), asitAdditems), el.getValue());
				}
				else if ("AWMMetallicReplacement".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWMMetallicReplacement"), asitAdditems), el.getValue());
				}
				else if ("AWMPlatingOntoElectrode".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWMPlatingOntoElectrode"), asitAdditems), el.getValue());
				}
				else if ("AWMElectrodialysis".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWMElectrodialysis"), asitAdditems), el.getValue());
				}
				else if ("AWMElectrowinningElectrolyticRecovery".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWMElectrowinningElectrolyticRecovery"), asitAdditems), el.getValue());
				}
				else if ("AWMChemicalStabilization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWMChemicalStabilization"), asitAdditems), el.getValue());
				}
				else if ("AWMEvaporation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWMEvaporation"), asitAdditems), el.getValue());
				}
				else if ("AWMAdsorption".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWMAdsorption"), asitAdditems), el.getValue());
				}
				else if ("AWOPhaseSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWOPhaseSeparation"), asitAdditems), el.getValue());
				}
				else if ("AWOAdsorption".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWOAdsorption"), asitAdditems), el.getValue());
				}
				else if ("AWODistillation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWODistillation_1"), asitAdditems), el.getValue());
				}
				else if ("AWOBiologicalUsingMicroOrganisms".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWOBiologicalUsingMicroOrganisms"), asitAdditems), el.getValue());
				}
				else if ("AWOPhotodegradationEnclosedSystem".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWOPhotodegradationEnclosedSystem_1"), asitAdditems), el.getValue());
				}
				else if ("AWOAirStrippingSteamStripping".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWOAirStrippingSteamStripping_1"), asitAdditems), el.getValue());
				}
				else if ("SDSChemicalStabilization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SDSChemicalStabilization_1"), asitAdditems), el.getValue());
				}
				else if ("SDSGrindShredCrushCompact".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SDSGrindShredCrushCompact_1"), asitAdditems), el.getValue());
				}
				else if ("SDSDryingRemoveWater".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SDSDryingRemoveWater_1"), asitAdditems), el.getValue());
				}
				else if ("SDSSeparationBySize".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SDSSeparationBySize"), asitAdditems), el.getValue());
				}
				else if ("AGChemicalStabilization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AGChemicalStabilization_1"), asitAdditems), el.getValue());
				}
				else if ("AGDryingRemoveWater".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AGDryingRemoveWater_1"), asitAdditems), el.getValue());
				}
				else if ("AGPhaseSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AGPhaseSeparation_1"), asitAdditems), el.getValue());
				}
				else if ("SWChemicalStabilization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWChemicalStabilization_1"), asitAdditems), el.getValue());
				}
				else if ("SWDryingRemoveWater".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWDryingRemoveWater_1"), asitAdditems), el.getValue());
				}
				else if ("SWPhaseSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWPhaseSeparation_1"), asitAdditems), el.getValue());
				}
				else if ("SWScreeningBasedSize".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWScreeningBasedSize"), asitAdditems), el.getValue());
				}
				else if ("SWSeparationBySize".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWSeparationBySize"), asitAdditems), el.getValue());
				}
				else if ("WEAChemicalStabilization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("WEAChemicalStabilization_1"), asitAdditems), el.getValue());
				}
				else if ("WEADryingRemoveWater".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("WEADryingRemoveWater_1"), asitAdditems), el.getValue());
				}
				else if ("WEAPhaseSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("WEAPhaseSeparation_1"), asitAdditems), el.getValue());
				}
				else if ("WEAMagneticSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("WEAMagneticSeparation_1"), asitAdditems), el.getValue());
				}
				else if ("InorganicAdjustmentNeutralization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("InorganicAdjustmentNeutralization"), asitAdditems), el.getValue());
				}
				else if ("SWMChemicalStabilization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWMChemicalStabilization_1"), asitAdditems), el.getValue());
				}
				else if ("SWMSeparationBySize".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWMSeparationBySize_1"), asitAdditems), el.getValue());
				}
				else if ("SWMMagneticSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWMMagneticSeparation_1"), asitAdditems), el.getValue());
				}
				else if ("UOSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("UOSeparation_1"), asitAdditems), el.getValue());
				}
				else if ("UODistillation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("UODistillation_1"), asitAdditems), el.getValue());
				}
				else if ("UONeutralization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("UONeutralization_1"), asitAdditems), el.getValue());
				}
				else if ("UOSeparationBySize".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("UOSeparationBySize"), asitAdditems), el.getValue());
				}
				else if ("UOReverseOsmosis".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("UOReverseOsmosis_1"), asitAdditems), el.getValue());
				}
				else if ("UOBiologicalUsingMicroorganisms".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("UOBiologicalUsingMicroorganisms"), asitAdditems), el.getValue());
				}
				else if ("ContainersRinsing".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ContainersRinsing"), asitAdditems), el.getValue());
				}
				else if ("ContainersCrushShredGrind".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ContainersCrushShredGrind_1"), asitAdditems), el.getValue());
				}
				else if ("MultiComponentResin".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("MultiComponentResin"), asitAdditems), el.getValue());
				}
				else if ("WastestreamTechnologyCombination".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("WastestreamTechnologyCombination"), asitAdditems), el.getValue());
				}
				else if ("CRByHypochlorite".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("CRByHypochlorite"), asitAdditems), el.getValue());
				}
				else if ("CRByPeroxide".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("CRByPeroxide"), asitAdditems), el.getValue());
				}
				else if ("CRAlkaline".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("CRAlkaline"), asitAdditems), el.getValue());
				}
				else if ("CRElectrochemical".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("CRElectrochemical"), asitAdditems), el.getValue());
				}
				else if ("CRIonExchange".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("CRIonExchange"), asitAdditems), el.getValue());
				}
				else if ("CRReverseOsmosis".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("CRReverseOsmosis"), asitAdditems), el.getValue());
				}
				else if ("ROByHypochlorite".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ROByHypochlorite"), asitAdditems), el.getValue());
				}
				else if ("ROByPeroxide".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ROByPeroxide"), asitAdditems), el.getValue());
				}
				else if ("ROAlkaline".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ROAlkaline"), asitAdditems), el.getValue());
				}
				else if ("ROElectrochemical".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ROElectrochemical"), asitAdditems), el.getValue());
				}
				else if ("ROIonExchange".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ROIonExchange"), asitAdditems), el.getValue());
				}
				else if ("ROReverseOsmosis".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ROReverseOsmosis"), asitAdditems), el.getValue());
				}
				else if ("TERByHypochlorite".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("TERByHypochlorite"), asitAdditems), el.getValue());
				}
				else if ("TERByPeroxide".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("TERByPeroxide"), asitAdditems), el.getValue());
				}
				else if ("TERAlkaline".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("TERAlkaline"), asitAdditems), el.getValue());
				}
				else if ("TERElectrochemical".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("TERElectrochemical"), asitAdditems), el.getValue());
				}
				else if ("TERIonExchange".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("TERIonExchange"), asitAdditems), el.getValue());
				}
				else if ("TERReverseOsmosis".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("TERReverseOsmosis"), asitAdditems), el.getValue());
				}
				else if ("ABByHypochlorite".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ABByHypochlorite"), asitAdditems), el.getValue());
				}
				else if ("ABByPeroxide".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ABByPeroxide"), asitAdditems), el.getValue());
				}
				else if ("ABAlkaline".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ABAlkaline"), asitAdditems), el.getValue());
				}
				else if ("ABElectrochemical".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ABElectrochemical"), asitAdditems), el.getValue());
				}
				else if ("ABIonExchange".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ABIonExchange"), asitAdditems), el.getValue());
				}
				else if ("ABReverseOsmosis".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ABReverseOsmosis"), asitAdditems), el.getValue());
				}
				else if ("OLByHypochlorite".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("OLByHypochlorite"), asitAdditems), el.getValue());
				}
				else if ("OLByPeroxide".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("OLByPeroxide"), asitAdditems), el.getValue());
				}
				else if ("OLAlkaline".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("OLAlkaline"), asitAdditems), el.getValue());
				}
				else if ("OLElectrochemical".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("OLElectrochemical"), asitAdditems), el.getValue());
				}
				else if ("OLIonExchange".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("OLIonExchange"), asitAdditems), el.getValue());
				}
				else if ("OLReverseOsmosis".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("OLReverseOsmosis"), asitAdditems), el.getValue());
				}
				else if ("Electrowinning".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("Electrowinning"), asitAdditems), el.getValue());
				}
				else if ("PSByHypochlorite".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("PSByHypochlorite"), asitAdditems), el.getValue());
				}
				else if ("PSByPeroxide".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("PSByPeroxide"), asitAdditems), el.getValue());
				}
				else if ("PSAlkaline".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("PSAlkaline"), asitAdditems), el.getValue());
				}
				else if ("PSElectrochemical".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("PSElectrochemical"), asitAdditems), el.getValue());
				}
				else if ("PSIonExchange".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("PSIonExchange"), asitAdditems), el.getValue());
				}
				else if ("PSReverseOsmosis".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("PSReverseOsmosis"), asitAdditems), el.getValue());
				}

			}
		}

	}

	private void dealHWUnitCAType(Collection<AdditionalInformationGroup> addInfoGroup, HWUnitCAType ca)
	{

		AdditionalInformationSubGroup subGroup = null;
		AdditionalItems asitAdditems = null;

		// CA - WASTE & TX PROC COMBOS DEH_HUPW_T27
		Object[] obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUPW_T27", "CA - WASTE & TX PROC COMBOS");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			List<JAXBElement<?>> list = ca
					.getAWInorganicPhaseSeparationOrAWInorganicIonExchangeOrAWInorganicReverseOsmosis();
			for (JAXBElement<?> el : list)
			{
				if ("AWInorganicPhaseSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWInorganicPhaseSeparation"), asitAdditems), el.getValue());
				}
				else if ("AWInorganicIonExchange".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWInorganicIonExchange"), asitAdditems), el.getValue());
				}
				else if ("AWInorganicReverseOsmosis".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWInorganicReverseOsmosis"), asitAdditems), el.getValue());
				}
				else if ("AWInorganicAdsorption".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWInorganicAdsorption"), asitAdditems), el.getValue());
				}
				else if ("AWInorganicpHAdjustment".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWInorganicpHAdjustment"), asitAdditems), el.getValue());
				}
				else if ("AWInorganicElectrowinning".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWInorganicElectrowinning"), asitAdditems), el.getValue());
				}
				else if ("AWInorganicReduction".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWInorganicReduction"), asitAdditems), el.getValue());
				}
				else if ("AWOrganicPhase".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWOrganicPhase"), asitAdditems), el.getValue());
				}
				else if ("AWOrganicAdsorption".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWOrganicAdsorption"), asitAdditems), el.getValue());
				}
				else if ("SludgesPhysicalProcess".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SludgesPhysicalProcess"), asitAdditems), el.getValue());
				}
				else if ("SludgesDrying".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SludgesDrying"), asitAdditems), el.getValue());
				}
				else if ("SludgesSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SludgesSeparation"), asitAdditems), el.getValue());
				}
				else if ("AlumDrying".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AlumDrying"), asitAdditems), el.getValue());
				}
				else if ("AlumPhase".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AlumPhase"), asitAdditems), el.getValue());
				}
				else if ("SWDrying120".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWDrying120"), asitAdditems), el.getValue());
				}
				else if ("SWPhaseSeparation120".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWPhaseSeparation120"), asitAdditems), el.getValue());
				}
				else if ("SWScreening".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWScreening"), asitAdditems), el.getValue());
				}
				else if ("SWSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWSeparation"), asitAdditems), el.getValue());
				}
				else if ("SWDrying124".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWDrying124"), asitAdditems), el.getValue());
				}
				else if ("SPhaseSeparation124".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SPhaseSeparation124"), asitAdditems), el.getValue());
				}
				else if ("SWMagneticSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWMagneticSeparation"), asitAdditems), el.getValue());
				}
				else if ("SMSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SMSeparation"), asitAdditems), el.getValue());
				}
				else if ("SMMagneticSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SMMagneticSeparation"), asitAdditems), el.getValue());
				}
				else if ("OWSPhaseSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("OWSPhaseSeparation"), asitAdditems), el.getValue());
				}
				else if ("OWSSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("OWSSeparation"), asitAdditems), el.getValue());
				}
				else if ("OWSReverseOsmosis".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("OWSReverseOsmosis"), asitAdditems), el.getValue());
				}
				else if ("AWNeutralization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWNeutralization"), asitAdditems), el.getValue());
				}
				else if ("AWNeutralizationByGallons".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWNeutralizationByGallons"), asitAdditems), el.getValue());
				}
				else if ("CertifiedTechnologyNumber".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("CertifiedTechnologyNumber629_12"), asitAdditems), el.getValue());
				}


			}

		}

	}

	private void dealHWUnitCELType(Collection<AdditionalInformationGroup> addInfoGroup, HWUnitCELType cel)
	{

		AdditionalInformationSubGroup subGroup = null;
		AdditionalItems asitAdditems = null;

		// CEL - WASTE & TX PROC COMBOS DEH_HUPW_T27
		Object[] obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUPW_T27", "CEL - WASTE & TX PROC COMBOS");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			List<JAXBElement<?>> list = cel.getCertifiedTechnologyNumberOrGravitySeperationOrCentrifuge();
			for (JAXBElement<?> el : list)
			{
				if ("GravitySeperation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("GravitySeperation"), asitAdditems), el.getValue());
				}
				else if ("Centrifuge".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("Centrifuge"), asitAdditems), el.getValue());
				}
				else if ("MembraneTechnology".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("MembraneTechnology"), asitAdditems), el.getValue());
				}
				else if ("HeatingOfWater".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("HeatingOfWater"), asitAdditems), el.getValue());
				}
				else if ("AdditionOfDemulsifier".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AdditionOfDemulsifier"), asitAdditems), el.getValue());
				}

			}
		}

	}

	private void dealHWUnitCESQTType(Collection<AdditionalInformationGroup> addInfoGroup, HWUnitCESQTType cesq)
	{

		AdditionalInformationSubGroup subGroup = null;
		AdditionalItems asitAdditems = null;

		// CESQT - WST & TX PROCESS COMBS DEH_HUPW_T27
		Object[] obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUPW_T27", "CESQT - WST & TX PROCESS COMBS");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			List<JAXBElement<?>> list = cesq.getAWExavalentChromiumReductionOrAWPHAdjustmentOrNeutralizationOrAWPrecipitationOrCrystallization();
			for (JAXBElement<?> el : list)
			{      //AWExavalentChromiumReduction
				if ("AWExavalentChromiumReduction".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWExavalentChromiumReduction"), asitAdditems), el.getValue());
				}
				else if ("AWPHAdjustmentOrNeutralization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWPHAdjustmentOrNeutralization"), asitAdditems), el.getValue());
				}
				else if ("AWPrecipitationOrCrystallization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWPrecipitationOrCrystallization"), asitAdditems), el.getValue());
				}
				else if ("AWPhaseSeparationFCGS".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWPhaseSeparationFCGS"), asitAdditems), el.getValue());
				}
				else if ("AWIonExchange".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWIonExchange"), asitAdditems), el.getValue());
				}
				else if ("AWReverseOsmosis".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWReverseOsmosis"), asitAdditems), el.getValue());
				}
				else if ("AWMetallicReplacement".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWMetallicReplacement"), asitAdditems), el.getValue());
				}
				else if ("AWPlatingElectrode".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWPlatingElectrode"), asitAdditems), el.getValue());
				}
				else if ("AWElectrodialysis".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWElectrodialysis"), asitAdditems), el.getValue());
				}
				else if ("AWElectrowinningOrElectrolyticRecovery".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWElectrowinningOrElectrolyticRecovery"), asitAdditems), el.getValue());
				}
				else if ("AWChemicalStabilization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWChemicalStabilization"), asitAdditems), el.getValue());
				}
				else if ("AWEvaporation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWEvaporation"), asitAdditems), el.getValue());
				}
				else if ("AWAdsorption".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWAdsorption"), asitAdditems), el.getValue());
				}
				else if ("AWOPhaseSperation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWOPhaseSperation"), asitAdditems), el.getValue());
				}
				else if ("AWOAdsorption".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWOAdsorption"), asitAdditems), el.getValue());
				}
				else if ("AWODistillation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWODistillation"), asitAdditems), el.getValue());
				}
				else if ("AWOBiologicalProcessMicroorganisms".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWOBiologicalProcessMicroorganisms"), asitAdditems), el.getValue());
				}
				else if ("AWOPhotodegradationEnclosedSystem".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWOPhotodegradationEnclosedSystem"), asitAdditems), el.getValue());
				}
				else if ("AWOAirStrippingSteamStripping".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AWOAirStrippingSteamStripping"), asitAdditems), el.getValue());
				}
				else if ("SDSChemicalStabilization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SDSChemicalStabilization"), asitAdditems), el.getValue());
				}
				else if ("SDSGrindShredCrushCompact".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SDSGrindShredCrushCompact"), asitAdditems), el.getValue());
				}
				else if ("SDSDryingRemoveWater".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SDSDryingRemoveWater"), asitAdditems), el.getValue());
				}
				else if ("SDSSeparationSizeMagnetismDensity".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SDSSeparationSizeMagnetismDensity"), asitAdditems), el.getValue());
				}
				else if ("AGChemicalStabilization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AGChemicalStabilization"), asitAdditems), el.getValue());
				}
				else if ("AGDryingRemoveWater".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AGDryingRemoveWater"), asitAdditems), el.getValue());
				}
				else if ("AGPhaseSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("AGPhaseSeparation"), asitAdditems), el.getValue());
				}
				else if ("SWChemicalStabilization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWChemicalStabilization"), asitAdditems), el.getValue());
				}
				else if ("SWDryingRemoveWater".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWDryingRemoveWater"), asitAdditems), el.getValue());
				}
				else if ("SWPhaseSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWPhaseSeparation"), asitAdditems), el.getValue());
				}
				else if ("SWScreeningSize".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWScreeningSize"), asitAdditems), el.getValue());
				}
				else if ("SWSeparationSizeMagnetismDensity".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWSeparationSizeMagnetismDensity"), asitAdditems), el.getValue());
				}
				else if ("WEAChemicalStabilization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("WEAChemicalStabilization"), asitAdditems), el.getValue());
				}
				else if ("WEADryingRemoveWater".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("WEADryingRemoveWater"), asitAdditems), el.getValue());
				}
				else if ("WEAPhaseSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("WEAPhaseSeparation"), asitAdditems), el.getValue());
				}
				else if ("WEAMagneticSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("WEAMagneticSeparation"), asitAdditems), el.getValue());
				}
				else if ("InorganicWasteAdjustmentNeutralization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("InorganicWasteAdjustmentNeutralization"), asitAdditems), el.getValue());
				}
				else if ("SWMChemicalStabilization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWMChemicalStabilization"), asitAdditems), el.getValue());
				}
				else if ("SWMSeparationBySize".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWMSeparationBySize"), asitAdditems), el.getValue());
				}
				else if ("SWMMagneticSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SWMMagneticSeparation"), asitAdditems), el.getValue());
				}
				else if ("UOSeparation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("UOSeparation"), asitAdditems), el.getValue());
				}
				else if ("UODistillation".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("UODistillation"), asitAdditems), el.getValue());
				}
				else if ("UONeutralization".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("UONeutralization"), asitAdditems), el.getValue());
				}
				else if ("UOSeparationSize".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("UOSeparationSize"), asitAdditems), el.getValue());
				}
				else if ("UOReverseOsmosis".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("UOReverseOsmosis"), asitAdditems), el.getValue());
				}
				else if ("UOBiologicalProcessMicroOrganisms".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("UOBiologicalProcessMicroOrganisms"), asitAdditems), el.getValue());
				}
				else if ("ContainersRinsingWithLiquid".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ContainersRinsingWithLiquid"), asitAdditems), el.getValue());
				}
				else if ("ContainersCrushShredGrind".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ContainersCrushShredGrind"), asitAdditems), el.getValue());
				}
				else if ("MultiComponentResins".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("MultiComponentResins"), asitAdditems), el.getValue());
				}
				else if ("CertifiedTechnologyNumber".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("CertifiedTechnologyNumber"), asitAdditems), el.getValue());
				}
			}
		}

	}

	private void dealHWUnitCESWType(Collection<AdditionalInformationGroup> addInfoGroup, HWUnitCESWType cesw)
	{

		AdditionalInformationSubGroup subGroup = null;
		AdditionalItems asitAdditems = null;

		// CESQT - WST & TX PROCESS COMBS DEH_HUPW_T27
		Object[] obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUPW_T27", "CESW - WASTE & TX PROC COMBOS");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			List<JAXBElement<?>> list = cesw
					.getTreatingResinsMixedOrTreatingContainerLessCapacityOrDryingSpecialWastes();

			for (JAXBElement<?> el : list)
			{

				if ("TreatingResinsMixed".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("TreatingResinsMixed"), asitAdditems), el.getValue());
				}
				else if ("TreatingContainerLessCapacity".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("TreatingContainerLessCapacity"), asitAdditems), el.getValue());
				}
				else if ("DryingSpecialWastes".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("DryingSpecialWastes"), asitAdditems), el.getValue());
				}
				else if ("MagneticSeparationOrScreening".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("MagneticSeparationOrScreening"), asitAdditems), el.getValue());
				}
				else if ("SettlingOfSolids".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SettlingOfSolids"), asitAdditems), el.getValue());
				}
				else if ("SeparationOfOilWaterMixtures".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SeparationOfOilWaterMixtures"), asitAdditems), el.getValue());
				}
				else if ("NeutralizingAcidicOrAlkaline".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("NeutralizingAcidicOrAlkaline"), asitAdditems), el.getValue());
				}
				else if ("HazardousWasteTreatmentCarried".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("HazardousWasteTreatmentCarried"), asitAdditems), el.getValue());
				}
				else if ("WastestreamCertifiedTechnologyNumber".equals(toString(el.getName())))//628-11
				{
					setValue(getAddItem(cb.get("WastestreamCertifiedTechnologyNumber"), asitAdditems), el.getValue());
				}
				else if ("FormaldehydeCertifiedTechnologyNumber".equals(toString(el.getName())))//628-12
				{
					setValue(getAddItem(cb.get("FormaldehydeCertifiedTechnologyNumber"), asitAdditems), el.getValue());
				}

			}
		}

	}

	private void OnsiteHWTreatmentNotificationUnit(Collection<AdditionalInformationGroup> addInfoGroup, HWUnitType hwt)
	{
		AdditionalInformationSubGroup subGroup = null;
		AdditionalItems asitAdditems = null;

		// ONSITE HAZ WST TX NOTIF - UNIT DEH_HUPW_T27
		Object[] obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUPW_T27", "ONSITE HAZ WST TX NOTIF - UNIT");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setValue(getAddItem(cb.get("UnitID"), asitAdditems), hwt.getUnitID());
			setDropdownValue(hwt.getUnitType(),"UnitType", asitAdditems);
			setValue(getAddItem(cb.get("NumberOfTanks"), asitAdditems), hwt.getNumberOfTanks());
			setValue(getAddItem(cb.get("NumberOfContainers"), asitAdditems), hwt.getNumberOfContainers());
			setValue(getAddItem(cb.get("UnitName"), asitAdditems), hwt.getUnitName());
			setValue(getAddItem(cb.get("MonthlyTreatmentVolume"), asitAdditems), hwt.getMonthlyTreatmentVolume());
			//setValue(getAddItem(cb.get("UnitOfMeasure"), asitAdditems), hwt.getUnitOfMeasure());
			setDropdownValue(hwt.getUnitOfMeasure(),"UnitOfMeasure", asitAdditems);
			setValue(getAddItem(cb.get("SpecificWasteTypeTreated"), asitAdditems), hwt.getSpecificWasteTypeTreated());
			setValue(getAddItem(cb.get("TreatmentProcessDescription"), asitAdditems),
				hwt.getTreatmentProcessDescription());
			setValue(getAddItem(cb.get("BasisTreatedWastedNotHazardous"), asitAdditems),
				hwt.getBasisTreatedWastedNotHazardous());
			setValue(getAddItem(cb.get("BasisTreatedWasteInWasteWater"), asitAdditems),
				hwt.getBasisTreatedWasteInWasteWater());
			setValue(getAddItem(cb.get("BasisTreatmentInNeutralizationUnit"), asitAdditems),
				hwt.getBasisTreatmentInNeutralizationUnit());
			setValue(getAddItem(cb.get("BasisTreatmentInEnclosedFacility"), asitAdditems),
				hwt.getBasisTreatmentInEnclosedFacility());
			setValue(getAddItem(cb.get("BasisFedSmallQuantityGenerator"), asitAdditems),
				hwt.getBasisFedSmallQuantityGenerator());
			setValue(getAddItem(cb.get("BasisTreatmentInAccumulationTank"), asitAdditems),
				hwt.getBasisTreatmentInAccumulationTank());
			setValue(getAddItem(cb.get("BasisRecyclableMaterialReclaimed"), asitAdditems),
				hwt.getBasisRecyclableMaterialReclaimed());
			setValue(getAddItem(cb.get("BasisEmptyContainerRinsing"), asitAdditems),
				hwt.getBasisEmptyContainerRinsing());
			if ( hwt.getBasisForNotNeededOther() != null && !isEmptyValue(hwt.getBasisForNotNeededOther().getBasisForNotNeededDescriptionOther()) ) {
				setValue(getAddItem(cb.get("BasisForNotNeededOther"), asitAdditems), "Y");
				setValue(getAddItem(cb.get("OtherBasis"),asitAdditems), hwt.getBasisForNotNeededOther().getBasisForNotNeededDescriptionOther());
			}
			else {
				setValue(getAddItem(cb.get("BasisForNotNeededOther"), asitAdditems), "N");
			}
			setValue(getAddItem(cb.get("ResidualPOTW"), asitAdditems), hwt.getResidualPOTW());
			setValue(getAddItem(cb.get("ResidualNPDES"), asitAdditems), hwt.getResidualNPDES());
			setValue(getAddItem(cb.get("ResidualResidueOffsite"), asitAdditems), hwt.getResidualResidueOffsite());
			setValue(getAddItem(cb.get("ResidualOffsiteRecycling"), asitAdditems), hwt.getResidualOffsiteRecycling());
			setValue(getAddItem(cb.get("ResidualThermalTreatment"), asitAdditems), hwt.getResidualThermalTreatment());
			setValue(getAddItem(cb.get("ResidualDisposalToLand"), asitAdditems), hwt.getResidualDisposalToLand());
			setValue(getAddItem(cb.get("ResidualFurtherTreatment"), asitAdditems), hwt.getResidualFurtherTreatment());
			if ( hwt.getResidualManagementOther() != null && !isEmptyValue(hwt.getResidualManagementOther().getResidualManagementDescriptionOther()) ) {
				setValue(getAddItem(cb.get("ResidualMangementDescriptionOther"), asitAdditems), "Y");
				setValue(getAddItem(cb.get("ResidualsManagementOtherMethodofDisposal"),asitAdditems), hwt.getResidualManagementOther().getResidualManagementDescriptionOther());
			}
			else {
				setValue(getAddItem(cb.get("ResidualMangementDescriptionOther"), asitAdditems), "N");
			}
			setValue(getAddItem(cb.get("SecondaryContainmentInstallationDate"), asitAdditems),
				hwt.getSecondaryContainmentInstallationDate());

		}
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUPW_T27", "CESQT - WST & TX PROCESS COMBS");
		HWUnitCESQTType cesq = hwt.getHWUnitCESQT();
		if (obs != null && cesq != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setValue(getAddItem(cb.get("UnitID"), asitAdditems), hwt.getUnitID());
		}

	}

	@Override
	public UpdateCAP convertToUpdateCAP(List<AdditionalInformation> additionInfos, Object currObject, String strDatetime, Object... objects)

	{
		HWUnitType hwu = (HWUnitType) currObject;

		List<AdditionalInformation> addInfos = additionInfos;
		CAPId capId = (CAPId) objects[0];
		UpdateCAP updateCap = new UpdateCAP();
		updateCap.setCAPId(capId);
		// updateCap.setCAPTypeId(CapUtil.getTypeId("OnsiteHazardousWasteTreatmentNotificationType"));
		updateCap.setSystem(AuthService.getSystem());
		// updateCap.setFinalizeNow(true);

		updateCap.setStatus(CapUtil.getDefaultStatusByCapType(cb.get("Waste.capType")));
		FacilitySubmittalType facilitySubmittalType = null;
		if(objects != null && objects.length > 0 )
		{
			if (objects[0] instanceof FacilitySubmittalType)
			{
				facilitySubmittalType = (FacilitySubmittalType) objects[0];
			}
		}

		AdditionalInformation addCopy = addInfos.get(0).clone();
		updateCap.setAdditionalInformation(addCopy);

		for (AdditionalInformationGroup ag : addCopy.getAdditionalInformationGroup())
		{
			List<AdditionalInformationSubGroup> ags = ag.getAdditionalInformationSubGroup();
			for (AdditionalInformationSubGroup asg : ags)
			{
				if (ag.isAddRemoveSubGroups())
				{// asit
					asg.setAction("Add");
				}
				else
				// asi
				{
					for (AdditionalItem ai : asg.getAdditionalItems().getAdditionalItem())
					{
						ai.setAction("Update");
					}
				}

			}

		}

		Collection<AdditionalInformationGroup> addInfoGroup = updateCap.getAdditionalInformation()
				.getAdditionalInformationGroup();
		setAsi(addInfoGroup, hwu, facilitySubmittalType);
		HWUnitPBRType pbr = hwu.getHWUnitPBR();
		if (pbr != null)
		{
			PermitbyRule(addInfoGroup, pbr);
		}
		HWUnitCAType ca = hwu.getHWUnitCA();
		if (ca != null)
		{
			dealHWUnitCAType(addInfoGroup, ca);
		}
		HWUnitCESWType cesw = hwu.getHWUnitCESW();
		if (cesw != null)
		{
			dealHWUnitCESWType(addInfoGroup, cesw);
		}
		HWUnitCESQTType cesq = hwu.getHWUnitCESQT();
		if (cesq != null)
		{
			dealHWUnitCESQTType(addInfoGroup, cesq);
		}

		HWUnitCELType cel = hwu.getHWUnitCEL();
		if (cel != null)
		{
			dealHWUnitCELType(addInfoGroup, cel);
		}

		OnsiteHWTreatmentNotificationUnit(addInfoGroup, hwu);
		List<AdditionalInformationGroup> group = addCopy.getAdditionalInformationGroup();
		AdditionalInformationGroup ag = null;
		for (int i = 0; i < group.size();)
		{
			ag = group.get(i);
			boolean flag = false;
			if (ag.isAddRemoveSubGroups())
			{// asit
				List<AdditionalInformationSubGroup> ags = ag.getAdditionalInformationSubGroup();
				for (AdditionalInformationSubGroup asg : ags)
				{

					if (asg.getKeys().getKey().size() == 1)
					{
						flag = true;
						break;

					}
				}

			}
			if (flag)
			{
				group.remove(i);
			}
			else
			{
				i++;
			}

		}
		return updateCap;
	}

	private void setAsi(Collection<AdditionalInformationGroup> addInfoGroup, HWUnitType hwu, FacilitySubmittalType facilitySubmittalType)
	{

		// part asi key must be exists.
		Object mdeAsiSubGroup[] = getAddInfoSubGroup(addInfoGroup, "DEH_HUPW_T27", "DATA EXCHANGE INFORMATION");
		AdditionalInformationSubGroup asiSubGroup = null;
		if (mdeAsiSubGroup != null)
		{
			asiSubGroup = (AdditionalInformationSubGroup) mdeAsiSubGroup[1];
			AdditionalItems asitAdditems = null;
			asitAdditems = asiSubGroup.getAdditionalItems();
			if (hwu.getCERSUniqueKey() != null)
			{
				setValue(getAddItem("CERS Unique Key", asitAdditems), hwu.getCERSUniqueKey());
			}

			if (facilitySubmittalType != null && facilitySubmittalType.getOnsiteHazardousWasteTreatmentNotification() != null
					&& facilitySubmittalType.getOnsiteHazardousWasteTreatmentNotification().getSubmittalElementHeader() != null)
			{
				SubmittalElementHeaderType seht = facilitySubmittalType.getOnsiteHazardousWasteTreatmentNotification()
						.getSubmittalElementHeader();
				setValue(getAddItem("CERS Submittal ID", asitAdditems), seht.getCERSUniqueKey());
				setValue(getAddItem("CUPA Element Submitted", asitAdditems), "");
				setValue(getAddItem("Submitted On", asitAdditems), seht.getSubmittedOn());
				setValue(getAddItem("Submitted By", asitAdditems), seht.getSubmittedByFirstName() + " " + seht.getSubmittedByLastName());
				setValue(getAddItem("Submittal Status", asitAdditems), "Accepted");
				setValue(getAddItem("Submittal Reviewed By", asitAdditems), seht.getSubmittalActionDetails().getSubmittalActionAgentName());
				setValue(getAddItem("Submittal Status Date", asitAdditems), seht.getSubmittalActionDetails().getSubmittalActionOn());
				setValue(getAddItem("Date Moved to Historical Records", asitAdditems), "");
			}

		}

	}
}

/*
 * $Log: av-env.bat,v $
 */
