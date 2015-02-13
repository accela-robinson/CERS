package com.accela.cers;

import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBElement;

import com.accela.adapter.model.Address.DetailAddress;
import com.accela.adapter.model.Address.DetailAddresses;
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
import com.accela.cers.cap.model.AutomaticTankGaugingType;
import com.accela.cers.cap.model.BusinessActivitiesType;
import com.accela.cers.cap.model.ContinuousElectronicTankMonitoringType;
import com.accela.cers.cap.model.FacilityInformationType;
import com.accela.cers.cap.model.FacilitySubmittalType;
import com.accela.cers.cap.model.PipeContinuousType;
import com.accela.cers.cap.model.PipeElectronicLineLeakType;
import com.accela.cers.cap.model.PipeIntegrityTestingType;
import com.accela.cers.cap.model.PipeMechanicalLineLeakType;
import com.accela.cers.cap.model.PipeMonitoringOther;
import com.accela.cers.cap.model.PipeVisualPipeMonitoringType;
import com.accela.cers.cap.model.SubmittalElementHeaderType;
import com.accela.cers.cap.model.TankIntegrityTestingType;
import com.accela.cers.cap.model.TankMonitoringOtherType;
import com.accela.cers.cap.model.USTMonitoringPlanType;
import com.accela.cers.cap.model.USTTankType;
import com.accela.cers.cap.model.WeeklyManualTankGaugingType;
import com.accela.cers.cap.model.YesNoFlagType;

/**
 * <pre>
 *
 *  Accela Automation
 *  File: WasteTankConvert.java
 *
 *  Accela, Inc.
 *  Copyright (C): 2011-2013
 *
 *  Description:
 *
 *
 *  Notes:
 * 	$Id: WasteTankConvert.java 72642 2009-01-01 20:01:57Z ACHIEVO\zony.rao $
 *
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2011-11-28		zony.rao		Initial.
 *
 * </pre>
 */
public class UndergroundStorageTankConverter extends ICAPConvert
{

	private void setAddress(FacilitySubmittalType facilitySubmittalType, DetailAddresses dar)
	{
		FacilityInformationType faciInfo = facilitySubmittalType.getFacilityInformation();
		BusinessActivitiesType bas = faciInfo.getBusinessActivities();
		// set address info

		DetailAddress ba = new DetailAddress();
		ba.setCity(bas.getCity());
		ba.setPostalCode(bas.getZipCode());
		//Eric 02/01/2013, just only populate to ASI (Site Address (103))
		//ba.setStreetName(bas.getSiteAddress());
		dar.setDetailAddress(ba);
	}

	public InitiateCAP convertToInitCAP(List<AdditionalInformation> additionInfos, Object currObject, String dataSetDate,Object... objects)

	{
		USTTankType utt = (USTTankType) currObject;
		List<AdditionalInformation> addInfos = additionInfos;
		InitiateCAP initCap = new InitiateCAP();
		initCap.setCAPTypeId(CapUtil.getCapTypeIdByString("UST"));
		initCap.setSystem(AuthService.getSystem());
		initCap.setFinalizeNow(true);
		FacilitySubmittalType facilitySubmittalType = null;
		if (objects != null && objects.length > 0)
		{
			if (objects[0] instanceof FacilitySubmittalType)
			{
				facilitySubmittalType = (FacilitySubmittalType) objects[0];
			}
		}
		AdditionalInformation addCopy = addInfos.get(0).clone();
		initCap.setAdditionalInformation(addCopy);
		initCap.setStatus(CapUtil.getDefaultStatusByCapType(cb.get("UST.capType")));

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
		// set Address
		DetailAddresses dar = new DetailAddresses();
		initCap.setDetailAddresses(dar);
		setAddress(facilitySubmittalType, dar);
		setAsi(addInfoGroup, utt, facilitySubmittalType);
		dealUSTOperatingPermitApplication(utt, addInfoGroup);
		USTMonitoringPlanType mp = utt.getMonitoringPlan();
		dealUSTMonitoringPlan(mp, addInfoGroup);
		return initCap;

	}

	private void dealUSTOperatingPermitApplication(USTTankType ttt, Collection<AdditionalInformationGroup> addInfoGroup)
	{
		AdditionalInformationSubGroup subGroup = null;
		AdditionalItems asitAdditems = null;

		Object[] obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "APPLICANT SIGNATURE");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setValue(getAddItem(cb.get("CertifiedDate_4"), asitAdditems), toString(ttt.getCertifiedDate()));
			setValue(getAddItem(cb.get("ApplicantName_4"), asitAdditems), ttt.getApplicantName());
			setValue(getAddItem(cb.get("ApplicantTitle_4"), asitAdditems), ttt.getApplicantTitle());
		}
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "FILL COMPONENTS INSTALLED");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			List<JAXBElement<YesNoFlagType>> list = ttt
					.getSpillBucketInstalledOrStrikerPlateProtectorInstalledOrContainmentSump();
			for (JAXBElement<YesNoFlagType> el : list)
			{
				if ("SpillBucketInstalled".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("SpillBucketInstalled"), asitAdditems), el.getValue());
				}
				else if ("StrikerPlateProtectorInstalled".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("StrikerPlateProtectorInstalled"), asitAdditems), el.getValue());
				}
				else if ("ContainmentSump".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("ContainmentSump"), asitAdditems), el.getValue());
				}
			}

		}
		//
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "PRODUCT/WASTE PIPING CONST");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();

			setDropdownValue(ttt.getPipingSystemType(),"PipingSystemType", asitAdditems);
			//setValue(getAddItem(cb.get("PipingSystemType"), asitAdditems), ttt.getPipingSystemType());
			setDropdownValue(ttt.getPipingConstruction(),"PipingConstruction", asitAdditems);

			setDropdownValue(getValue(ttt.getPWPipingPCConstruction()),"PWPipingPCConstruction", asitAdditems);
			//setValue(getAddItem(cb.get("PWPipingPCConstruction"), asitAdditems), ttt.getPWPipingPCConstruction());
			setValue(getAddItem(cb.get("OtherPipingPCConstruction"), asitAdditems), ttt.getOtherPipingPCConstruction());

			setDropdownValue(getValue(ttt.getPWPipingSCConstruction()),"PWPipingSCConstruction", asitAdditems);
			//setValue(getAddItem(cb.get("PWPipingSCConstruction"), asitAdditems), ttt.getPWPipingSCConstruction());
			setValue(getAddItem(cb.get("OtherPipingSCConstruction"), asitAdditems), ttt.getOtherPipingSCConstruction());

			setDropdownValue(getValue(ttt.getPTContainmentSump()),"PTContainmentSump", asitAdditems);
			//setValue(getAddItem(cb.get("PTContainmentSump"), asitAdditems), ttt.getPTContainmentSump());

		}

		// RISER CONSTRUCTION
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "RISER CONSTRUCTION");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setDropdownValue(getValue(ttt.getRPPCConstruction()),"RPPCConstruction", asitAdditems);
			//setValue(getAddItem(cb.get("RPPCConstruction"), asitAdditems), ttt.getRPPCConstruction());
			setValue(getAddItem(cb.get("OtherRPPCConstruction"), asitAdditems), ttt.getOtherRPPCConstruction());

			setDropdownValue(getValue(ttt.getRPSCConstruction()),"RPSCConstruction", asitAdditems);
			//setValue(getAddItem(cb.get("RPSCConstruction"), asitAdditems), ttt.getRPSCConstruction());
			setValue(getAddItem(cb.get("OtherRPSCConstruction"), asitAdditems), ttt.getOtherRPSCConstruction());
		}
		// TANK CONSTRUCTION
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "TANK CONSTRUCTION");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setDropdownValue(ttt.getTypeOfTank(),"TypeOfTank", asitAdditems);
			//setValue(getAddItem(cb.get("TypeOfTank"), asitAdditems), ttt.getTypeOfTank());
			setDropdownValue(ttt.getTankPCConstruction(),"TankPCConstruction", asitAdditems);
			//setValue(getAddItem(cb.get("TankPCConstruction"), asitAdditems), ttt.getTankPCConstruction());

			setValue(getAddItem(cb.get("OtherPCConstruction"), asitAdditems), ttt.getOtherPCConstruction());
			setDropdownValue(ttt.getTankSCConstruction(),"TankSCConstruction", asitAdditems);
			//setValue(getAddItem(cb.get("TankSCConstruction"), asitAdditems), ttt.getTankSCConstruction());
			setValue(getAddItem(cb.get("OtherSCConstruction"), asitAdditems), ttt.getOtherSCConstruction());
			List<JAXBElement<YesNoFlagType>> list = ttt.getCPSacrificialAnodeOrCPImpressedCurrentOrCPIsolation();
			obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "CORROSION PROTECTION");
			if (obs != null)
			{
				subGroup = (AdditionalInformationSubGroup) obs[1];
				asitAdditems = subGroup.getAdditionalItems();
				for (JAXBElement<YesNoFlagType> el : list)
				{
					if ("CPSacrificialAnode".equals(toString(el.getName())))
					{
						setValue(getAddItem(cb.get("CPSacrificialAnode"), asitAdditems), el.getValue());
					}
					else if ("CPImpressedCurrent".equals(toString(el.getName())))
					{
						setValue(getAddItem(cb.get("CPImpressedCurrent"), asitAdditems), el.getValue());
					}
					else if ("CPIsolation".equals(toString(el.getName())))
					{
						setValue(getAddItem(cb.get("CPIsolation"), asitAdditems), el.getValue());
					}
				}
			}

		}

		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "TANK DESCRIPTION");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setValue(getAddItem(cb.get("USTPermanentlyClosedDate"), asitAdditems), ttt.getUSTPermanentlyClosedDate());
			setValue(getAddItem(cb.get("ExistingUSTDiscoveredDate"), asitAdditems), ttt.getExistingUSTDiscoveredDate());
			setValue(getAddItem(cb.get("TankManufacturer"), asitAdditems), ttt.getTankManufacturer());
			//TankConfiguration
			//setValue(getAddItem(cb.get("TankConfiguration"), asitAdditems), ttt.getTankConfiguration());
			setDropdownValue(ttt.getTankConfiguration(),"TankConfiguration", asitAdditems);
			setValue(getAddItem(cb.get("USTSystemInstalledDate"), asitAdditems), toString(ttt.getUSTSystemInstalledDate()));
			setValue(getAddItem(cb.get("NumberOfCompartments"), asitAdditems), ttt.getNumberOfCompartments());
			setValue(getAddItem(cb.get("AdditionalDescription"), asitAdditems), ttt.getAdditionalDescription());
		}

		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "TANK OVERFILL PREVENTION");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			List<JAXBElement<YesNoFlagType>> list = ttt.getOPAVAlarmsOrOPBallFloatOrOPFillTubeShutOffValve();
			for (JAXBElement<YesNoFlagType> el : list)
			{
				if ("OPAVAlarms".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("OPAVAlarms"), asitAdditems), el.getValue());
				}
				else if ("OPBallFloat".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("OPBallFloat"), asitAdditems), el.getValue());
				}
				else if ("OPFillTubeShutOffValve".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("OPFillTubeShutOffValve"), asitAdditems), el.getValue());
				}
				else if ("OPExempt".equals(toString(el.getName())))
				{
					setValue(getAddItem(cb.get("OPExempt"), asitAdditems), el.getValue());
				}

			}

		}

		// TANK USE AND CONTENTS
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "TANK USE AND CONTENTS");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setDropdownValue(ttt.getTankUse(),"TankUse", asitAdditems);
			//setValue(getAddItem(cb.get("TankUse"), asitAdditems), ttt.getTankUse());
			setValue(getAddItem(cb.get("OtherTankUse"), asitAdditems), ttt.getOtherTankUse());
		}

		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "UNDER DISPENSER CONTAINMENT");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setDropdownValue(ttt.getUDCConstructionType(),"UDCConstructionType", asitAdditems);

			//setValue(getAddItem(cb.get("UDCConstructionType"), asitAdditems), ttt.getUDCConstructionType());
			setDropdownValue(getValue(ttt.getUDCConstructionMaterial()),"UDCConstructionMaterial", asitAdditems);

			//setValue(getAddItem(cb.get("UDCConstructionMaterial"), asitAdditems), ttt.getUDCConstructionMaterial());

			setValue(getAddItem(cb.get("OtherUDCConstructionMaterial"), asitAdditems),
				ttt.getOtherUDCConstructionMaterial());
		}
		// UST SUMMARY
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "UST SUMMARY");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setDropdownValue(ttt.getTypeOfAction(),"TypeOfAction", asitAdditems);
			//setValue(getAddItem(cb.get("TypeOfAction"), asitAdditems), ttt.getTypeOfAction());
			setValue(getAddItem(cb.get("TankIDNumber"), asitAdditems), ttt.getTankIDNumber());
			setValue(getAddItem(cb.get("TankCapacityInGallons"), asitAdditems), ttt.getTankCapacityInGallons());

//			setDropdownValue(ttt.getTankContents(),"TankContents", asitAdditems);
			setValue(getAddItem("Tank Contents (440)", asitAdditems), getDropdownValue(ttt.getTankContents(),
				"TankContents"));
			setValue(getAddItem(cb.get("OtherPetroleum"), asitAdditems), ttt.getOtherPetroleum());
			setValue(getAddItem(cb.get("OtherNonPetroleum"), asitAdditems), ttt.getOtherNonPetroleum());
		}
		// VAPOR RECOVERY (VR) CONST
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "VAPOR RECOVERY (VR) CONST");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();

			setDropdownValue(getValue(ttt.getVRPipingPCConstruction()),"VRPipingPCConstruction", asitAdditems);
			//setValue(getAddItem(cb.get("VRPipingPCConstruction"), asitAdditems), ttt.getVRPipingPCConstruction());
			setValue(getAddItem(cb.get("OtherVRPCConstruction"), asitAdditems), ttt.getOtherVRPCConstruction());

			setDropdownValue(getValue(ttt.getVRPipingSCConstruction()),"VRPipingSCConstruction", asitAdditems);
			//setValue(getAddItem(cb.get("VRPipingSCConstruction"), asitAdditems), ttt.getVRPipingSCConstruction());
			setValue(getAddItem(cb.get("OtherVRSCConstruction"), asitAdditems), ttt.getOtherVRSCConstruction());
		}
		// VENT CONSTRUCTION
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "VENT CONSTRUCTION");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setDropdownValue(getValue(ttt.getVPPCConstruction()),"VPPCConstruction", asitAdditems);
			//setValue(getAddItem(cb.get("VPPCConstruction"), asitAdditems), ttt.getVPPCConstruction());
			setValue(getAddItem(cb.get("OtherVPCConstruction"), asitAdditems), ttt.getOtherVPCConstruction());
			setDropdownValue(getValue(ttt.getVPSCConstruction()),"VPSCConstruction", asitAdditems);

//			setValue(getAddItem(cb.get("VPSCConstruction"), asitAdditems), ttt.getVPSCConstruction());
			setValue(getAddItem(cb.get("OtherVSCConstruction"), asitAdditems), ttt.getOtherVSCConstruction());

			setDropdownValue(getValue(ttt.getVPTransitionSumps()),"VPTransitionSumps", asitAdditems);
			//setValue(getAddItem(cb.get("VPTransitionSumps"), asitAdditems), ttt.getVPTransitionSumps());
		}

	}

	/**
	 *
	 * TODO. USTMonitoringPlan is asi content
	 *
	 * @param mp
	 * @param initCap
	 * @return
	 */
	private void dealUSTMonitoringPlan(USTMonitoringPlanType mp, Collection<AdditionalInformationGroup> addInfoGroup)
	{

		// type EQUIP TEST & PREVENTIVE MAINT DEH_HUST
		AdditionalInformationSubGroup subGroup = null;
		AdditionalItems asitAdditems = null;
		Object[] obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "EQUIP TEST & PREVENTIVE MAINT");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setDropdownValue(mp.getMonitoringEquipmentServiced(), "MonitoringEquipmentServiced", asitAdditems);
			setValue(getAddItem(cb.get("MonitoringEquipmentServicedOther"), asitAdditems),
				mp.getMonitoringEquipmentServicedOther());
		}
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "MONITORING LOCATIONS");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setDropdownValue(mp.getSitePlotPlanSubmitted(), "SitePlotPlanSubmitted", asitAdditems);
		}
		// that is a group
		//setValue(getAddItem(cb.get("ContinuousElectronicTankMonitoring"),asitAdditems),mp.getContinuousElectronicTankMonitoring());
		ContinuousElectronicTankMonitoringType cetmt = null;
		AutomaticTankGaugingType aty = null;
		YesNoFlagType msir = null;
		TankMonitoringOtherType ymot = null;
		TankIntegrityTestingType titt = null;
		WeeklyManualTankGaugingType wmtgt = null;

		List<Object> cons = mp
				.getContinuousElectronicTankMonitoringOrAutomaticTankGaugingOrMonthlyStatisticalInventoryReconciliation();
		for (Object ob : cons)
		{
			if (ob instanceof ContinuousElectronicTankMonitoringType)
			{
				cetmt = (ContinuousElectronicTankMonitoringType) ob;

			}
			else if (ob instanceof AutomaticTankGaugingType)
			{
				aty = (AutomaticTankGaugingType) ob;
			}
			else if (ob instanceof YesNoFlagType)
			{
				msir = (YesNoFlagType) ob;
			}
			else if (ob instanceof TankMonitoringOtherType)
			{
				ymot = (TankMonitoringOtherType) ob;
			}
			else if (ob instanceof TankIntegrityTestingType)
			{
				titt = (TankIntegrityTestingType) ob;
			}
			else if (ob instanceof WeeklyManualTankGaugingType)
			{
				wmtgt = (WeeklyManualTankGaugingType) ob;
			}
		}
		String ContinuousElectronicTankMonitoringFlag = "N";
		if (cetmt != null)
		{
			List<JAXBElement<String>> listEl = cetmt
					.getTankSecondaryContainmentSystemOrEMPManufacturerOrEMPModelNumber();

			obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "TANK MONITORING METHODS");
			if (obs != null)
			{
				subGroup = (AdditionalInformationSubGroup) obs[1];
				asitAdditems = subGroup.getAdditionalItems();
				
				if (listEl != null && listEl.size() > 0)
				{
					
					for (JAXBElement<String> ob : listEl)
					{
						if ("TankSecondaryContainmentSystem".equals(toString(ob.getName())))
						{
							setDropdownValue(ob.getValue(),"TankSecondaryContainmentSystem", asitAdditems);
						}
						else if ("EMPManufacturer".equals(toString(ob.getName())))
						{
							setValue(getAddItem(cb.get("EMPManufacturer"), asitAdditems), ob.getValue());
						}
						else if ("EMPModelNumber".equals(toString(ob.getName())))
						{
							setValue(getAddItem(cb.get("EMPModelNumber"), asitAdditems), ob.getValue());
						}
						else if ("LeakSensorManufacturer".equals(toString(ob.getName())))
						{
							setValue(getAddItem(cb.get("LeakSensorManufacturer"), asitAdditems), ob.getValue());
						}
						else if ("LeakSensorModelNum".equals(toString(ob.getName())))
						{
							setValue(getAddItem(cb.get("LeakSensorModelNum"), asitAdditems), ob.getValue());
						}
						if (!isEmptyValue(ob.getValue()))
						{
							ContinuousElectronicTankMonitoringFlag = "Y";
						}
					}
				}
			}
		}
		Object[] obs4CETM = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "MONITORING LOCATIONS");
		if (obs4CETM != null)
		{
			AdditionalItems asitAdditems4CETM = ((AdditionalInformationSubGroup) obs4CETM[1])
					.getAdditionalItems();
			setValue(getAddItem(cb.get("ContinuousElectronicTankMonitoring"), asitAdditems4CETM), ContinuousElectronicTankMonitoringFlag);
		}
		
		String automaticTankGaugingFlag = "N";
		if (aty != null)
		{
			List<JAXBElement<String>> listEl = aty.getATGPanelManufacturerOrATGModelNumOrInTankProbManufacturer();

			obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "AUTO TANK GAUGING (ATG) SYSTEM");
			if (obs != null)
			{
				subGroup = (AdditionalInformationSubGroup) obs[1];
				asitAdditems = subGroup.getAdditionalItems();
				if (listEl != null && listEl.size() > 0)
				{
					for (JAXBElement<String> ob : listEl)
					{
						if ("ProgrammedTankTestOther".equals(toString(ob.getName())))
						{
							setValue(getAddItem(cb.get("ProgrammedTankTestOther"), asitAdditems), ob.getValue());
						}
						else if ("InTankProbManufacturer".equals(toString(ob.getName())))
						{
							setValue(getAddItem(cb.get("InTankProbManufacturer"), asitAdditems), ob.getValue());
						}
						else if ("TankLeakTestFrequency".equals(toString(ob.getName())))
						{
							setDropdownValue(ob.getValue(),"TankLeakTestFrequency", asitAdditems);
						}
						else if ("ATGPanelManufacturer".equals(toString(ob.getName())))
						{
							setValue(getAddItem(cb.get("ATGPanelManufacturer"), asitAdditems), ob.getValue());
						}
						else if ("TankLeakTestFrequencyOther".equals(toString(ob.getName())))
						{
							setValue(getAddItem(cb.get("TankLeakTestFrequencyOther"), asitAdditems), ob.getValue());
						}

						else if ("ProgrammedTankTest".equals(toString(ob.getName())))
						{
							setDropdownValue(ob.getValue(),"ProgrammedTankTest", asitAdditems);
						}
						else if ("InTankProbeModelNum".equals(toString(ob.getName())))
						{
							setValue(getAddItem(cb.get("InTankProbeModelNum"), asitAdditems), ob.getValue());
						}
						else if ("ATGModelNum".equals(toString(ob.getName())))
						{
							setValue(getAddItem(cb.get("ATGModelNum"), asitAdditems), ob.getValue());
						}
						if (!isEmptyValue(ob.getValue()))
						{
							automaticTankGaugingFlag = "Y";
						}
					}
				}
			}
		}
		if (getAddItem(cb.get("AutomaticTankGauging"), asitAdditems) == null)
		{
			obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "AUTO TANK GAUGING (ATG) SYSTEM");
			if (obs != null)
			{
				subGroup = (AdditionalInformationSubGroup) obs[1];
				asitAdditems = subGroup.getAdditionalItems();
			}
		}
		setValue(getAddItem(cb.get("AutomaticTankGauging"), asitAdditems), automaticTankGaugingFlag);
		if (msir != null)
		{
			obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "AUTO TANK GAUGING (ATG) SYSTEM");
			if (obs != null)
			{
				subGroup = (AdditionalInformationSubGroup) obs[1];
				asitAdditems = subGroup.getAdditionalItems();
				setValue(getAddItem(cb.get("MonthlyStatisticalInventoryReconciliation"), asitAdditems), msir.value());
			}
		}
		String WeeklyManualTankGaugeFlag = "N";
		if (wmtgt != null)
		{
//			setValue(getAddItem(cb.get("WeeklyManualTankGauge"),asitAdditems),mp.getWeeklyManualTankGauge());
			obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "AUTO TANK GAUGING (ATG) SYSTEM");
			if (obs != null)
			{
				subGroup = (AdditionalInformationSubGroup) obs[1];
				asitAdditems = subGroup.getAdditionalItems();
				if(!isEmptyValue(wmtgt.getTankGaugingTestPeriod()))
				{
					WeeklyManualTankGaugeFlag = "Y";
					
				}
				// setValue(getAddItem(cb.get("TankGaugingTestPeriod"),asitAdditems),mp.getTankGaugingTestPeriod());
//				   setValue(getAddItem(cb.get("TankGaugingTestPeriod"), asitAdditems), wmtgt.getTankGaugingTestPeriod());
				setDropdownValue(getValue(wmtgt.getTankGaugingTestPeriod()),
					"TankGaugingTestPeriod", asitAdditems);
			}

		}
		setValue(getAddItem(cb.get("WeeklyManualTankGauge"), asitAdditems), WeeklyManualTankGaugeFlag);
		
		String TankIntegrityTestingFlag = "N";
		if (titt != null)
		{
			// setValue(getAddItem(cb.get("TankIntegrityTesting"),asitAdditems),mp.getTankIntegrityTesting());
			obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "AUTO TANK GAUGING (ATG) SYSTEM");
			if (obs != null)
			{
				subGroup = (AdditionalInformationSubGroup) obs[1];
				asitAdditems = subGroup.getAdditionalItems();

				List<JAXBElement<String>> listEl = titt
						.getTankIntegrityTestingFrequencyOrTankIntegrityTestingFrequencyOther();
				if (listEl != null && listEl.size() > 0)
				{
					for (JAXBElement<String> ob : listEl)
					{
						/**
						 * @XmlElementRefs({
						 * @XmlElementRef(name = "TankIntegrityTestingFrequency", type = JAXBElement.class),
						 * @XmlElementRef(name = "TankIntegrityTestingFrequencyOther", type = JAXBElement.class) })
						 */

						if ("TankIntegrityTestingFrequency".equals(toString(ob.getName())))
						{
							setDropdownValue(ob.getValue(),"TankIntegrityTestingFrequency", asitAdditems);
						}
						else if ("TankIntegrityTestingFrequencyOther".equals(toString(ob.getName())))
						{
							setValue(getAddItem(cb.get("TankIntegrityTestingFrequencyOther"), asitAdditems), ob
									.getValue());
						}
						if(!isEmptyValue(ob.getValue()))
						{
							TankIntegrityTestingFlag = "Y";
						}
					}
				}
			}
		}
		
		setValue(getAddItem(cb.get("TankIntegrityTesting"), asitAdditems), TankIntegrityTestingFlag);
		
		String isOtherMonitoringFlag = "N";
		if (ymot != null)
		{
			obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "AUTO TANK GAUGING (ATG) SYSTEM");
			if (obs != null)
			{
				subGroup = (AdditionalInformationSubGroup) obs[1];
				asitAdditems = subGroup.getAdditionalItems();
				if (isEmptyValue(ymot.getOtherMonitoring()))
				{
					isOtherMonitoringFlag = "Y";

				}
				getAddItem(cb.get("OtherMonitoring"), asitAdditems).setValue(ymot.getOtherMonitoring());
			}
		}
		setValue(getAddItem(cb.get("IsOtherMonitoring"), asitAdditems), isOtherMonitoringFlag);

		List<JAXBElement<?>> pips = mp
				.getPipeContinuousMonitoringOrMechanicalLineLeakDetectorOrElectronicLineLeakDetector();
		
		String PipeContinuousMonitoringFlag = "N";
		String MechanicalLineLeakDetectorFlag = "N";
		String ElectronicLineLeakDetectorFlag = "N";
		String PipeIntegrityTestingFlag = "N";
		String PipeVisualPipeMonitoringFlag = "N";
		String PipeMonitoringOtherFlag = "N";
		
		if (pips != null)
		{ // PIPE MONITORING METHODS DEH_HUST
			obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "PIPE MONITORING METHODS");
			if (obs != null)
			{
				subGroup = (AdditionalInformationSubGroup) obs[1];
				asitAdditems = subGroup.getAdditionalItems();

				for (JAXBElement<?> ob : pips)
				{
					if ("PipeContinuousMonitoring".equals(toString(ob.getName())))
					{
						PipeContinuousType ppt = (PipeContinuousType) ob.getValue();
						List<JAXBElement<?>> ppts = ppt
								.getPipingSecondaryContainmentOrPanelManufacturerOrPanelModelNum();
						for (JAXBElement<?> ob1 : ppts)
						{
							if ("PipingSecondaryContainment".equals(toString(ob1.getName())))
							{
								setDropdownValue(getValue(ob1),"PipingSecondaryContainment", asitAdditems);
							}
							else if ("PanelManufacturer".equals(toString(ob1.getName())))
							{
								setValue(getAddItem(cb.get("PanelManufacturer"), asitAdditems), ob1);
							}
							else if ("PanelModelNum".equals(toString(ob1.getName())))
							{
								setValue(getAddItem(cb.get("PanelModelNum"), asitAdditems), ob1);
							}
							else if ("PipeLeakSensorManufacturer".equals(toString(ob1.getName())))
							{
								setValue(getAddItem(cb.get("PipeLeakSensorManufacturer"), asitAdditems), ob1);
							}
							else if ("PipeLeakSensorModel".equals(toString(ob1.getName())))
							{
								setValue(getAddItem(cb.get("PipeLeakSensorModel"), asitAdditems), ob1);
							}
							else if ("LeakAlarmTriggPumpShutdown".equals(toString(ob1.getName())))
							{
								setValue(getAddItem(cb.get("LeakAlarmTriggPumpShutdown"), asitAdditems), ob1);
							}
							else if ("FailureTriggPumpShutdown".equals(toString(ob1.getName())))
							{
								setValue(getAddItem(cb.get("FailureTriggPumpShutdown"), asitAdditems), ob1);
							}
							if(!isEmptyValue(ob1))
							{
								PipeContinuousMonitoringFlag = "Y";
							}
						}
					}
					else if ("MechanicalLineLeakDetector".equals(toString(ob.getName())))
					{
						PipeMechanicalLineLeakType ppt = (PipeMechanicalLineLeakType) ob.getValue();
						List<JAXBElement<String>> ppts = ppt.getMLLDManufacturerOrMLLDModel();
						for (JAXBElement<String> ob1 : ppts)
						{
							if ("MLLDManufacturer".equals(toString(ob1.getName())))
							{
								setValue(getAddItem(cb.get("MLLDManufacturer"), asitAdditems), ob1.getValue());
							}
							else if ("MLLDModel".equals(toString(ob1.getName())))
							{
								setValue(getAddItem(cb.get("MLLDModel"), asitAdditems), ob1.getValue());
							}
							if(!isEmptyValue(ob1.getValue()))
							{
								MechanicalLineLeakDetectorFlag = "Y";
							}
						}

					}
					else if ("ElectronicLineLeakDetector".equals(toString(ob.getName())))
					{
						PipeElectronicLineLeakType pellt = (PipeElectronicLineLeakType) ob.getValue();
						List<JAXBElement<?>> ppts = pellt.getELLDManufacturerOrELLDModelOrELLDProgrammedInLineTesting();
						for (JAXBElement<?> ob1 : ppts)
						{
							if ("ELLDManufacturer".equals(toString(ob1.getName())))
							{
								setValue(getAddItem(cb.get("ELLDManufacturer"), asitAdditems), ob1);
							}
							else if ("ELLDModel".equals(toString(ob1.getName())))
							{
								setValue(getAddItem(cb.get("ELLDModel"), asitAdditems), ob1);
							}
							else if ("ELLDProgrammedInLineTesting".equals(toString(ob1.getName())))
							{
								setDropdownValue(getValue(ob1),"ELLDProgrammedInLineTesting", asitAdditems);
							}
							else if ("ELLDTriggersPumpShutdown".equals(toString(ob1.getName())))
							{
								setValue(getAddItem(cb.get("ELLDTriggersPumpShutdown"), asitAdditems), ob1);
							}
							else if ("ELLDFailureTriggShutdown".equals(toString(ob1.getName())))
							{
								setValue(getAddItem(cb.get("ELLDFailureTriggShutdown"), asitAdditems), ob1);
							}
							if(!isEmptyValue(ob1))
							{
								ElectronicLineLeakDetectorFlag = "Y";
							}
						}
					}
					else if ("PipeIntegrityTesting".equals(toString(ob.getName())))
					{
						PipeIntegrityTestingType pellt = (PipeIntegrityTestingType) ob.getValue();
						if (pellt != null)
						{
							setDropdownValue(getValue(pellt.getPipelineIntegrityTestingFrequency()),
								"PipelineIntegrityTestingFrequency", asitAdditems);
							setValue(getAddItem(cb.get("PipelineIntegrityTestingFrequencyOther"), asitAdditems),
								pellt.getPipelineIntegrityTestingFrequencyOther());
							if (!isEmptyValue(pellt.getPipelineIntegrityTestingFrequencyOther()))
							{
								PipeIntegrityTestingFlag = "Y";
							}
						}

					}
					else if ("PipeVisualPipeMonitoring".equals(toString(ob.getName())))
					{
						PipeVisualPipeMonitoringType pellt = (PipeVisualPipeMonitoringType) ob.getValue();
						if (pellt != null)
						{
//							setValue(getAddItem(cb.get("VisualPipelineMonitoringFrequency"), asitAdditems),
//								pellt.getVisualPipelineMonitoringFrequency());
							setDropdownValue(getValue(pellt.getVisualPipelineMonitoringFrequency()),
								"VisualPipelineMonitoringFrequency", asitAdditems);
							if (!isEmptyValue(pellt.getVisualPipelineMonitoringFrequency()))
							{
								PipeVisualPipeMonitoringFlag = "Y";
							}
						}

					}
					else if ("SuctionPipingExemptionCriteria".equals(toString(ob.getName())))
					{

						setValue(getAddItem(cb.get("SuctionPipingExemptionCriteria"), asitAdditems), ob.getValue());
					}
					else if ("NoRegulatedPipingPerHealthSafetyCode".equals(toString(ob.getName())))
					{
						setValue(getAddItem(cb.get("NoRegulatedPipingPerHealthSafetyCode"), asitAdditems),
							ob.getValue());
					}
					else if ("PipeMonitoringOther".equals(toString(ob.getName())))
					{
						PipeMonitoringOther pmt = (PipeMonitoringOther) ob.getValue();
						if (!isEmptyValue(pmt.getOtherPipelineMonitoring()))
						{
							PipeMonitoringOtherFlag = "Y";
						}
						setValue(getAddItem(cb.get("OtherPipelineMonitoring"), asitAdditems),
							pmt.getOtherPipelineMonitoring());
					}

				}
				
				
			}
		}
		
		if (getAddItem(cb.get("ContinuousPipeSecondaryContainment"), asitAdditems) == null)
		{
			obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "PIPE MONITORING METHODS");
			if (obs != null)
			{
				subGroup = (AdditionalInformationSubGroup) obs[1];
				asitAdditems = subGroup.getAdditionalItems();
			}
		}
		setValue(getAddItem(cb.get("ContinuousPipeSecondaryContainment"), asitAdditems), PipeContinuousMonitoringFlag);
		setValue(getAddItem(cb.get("MechanicalLineLeakDetector"), asitAdditems), MechanicalLineLeakDetectorFlag);
		setValue(getAddItem(cb.get("ElectronicLeakDetector"), asitAdditems), ElectronicLineLeakDetectorFlag);
		setValue(getAddItem(cb.get("PiplineIntegrityTesting"), asitAdditems), PipeIntegrityTestingFlag);
		setValue(getAddItem(cb.get("VisualPipelineMonitoring"), asitAdditems), PipeVisualPipeMonitoringFlag);
		setValue(getAddItem(cb.get("OtherPipeline"), asitAdditems), PipeMonitoringOtherFlag);

		// unfinded getAddItem(cb.get("OtherPipeline"),asitAdditems).setValue(mp.getOtherPipeline());
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "UDC MONITORING");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setDropdownValue(mp.getUDCMonitoring(),"UDCMonitoring", asitAdditems);
			setValue(getAddItem(cb.get("UDCMonitoringOther"), asitAdditems), mp.getUDCMonitoringOther());
			setValue(getAddItem(cb.get("UnderDispenserPanelManufacturer"), asitAdditems),
				mp.getUnderDispenserPanelManufacturer());
			setValue(getAddItem(cb.get("UnderDispenserModelPanelModelNum"), asitAdditems),
				mp.getUnderDispenserModelPanelModelNum());
			setValue(getAddItem(cb.get("UnderDispenserLeakSensorManufacturer"), asitAdditems),
				mp.getUnderDispenserLeakSensorManufacturer());
			setValue(getAddItem(cb.get("UnderDispenserModelOfLeakSensor"), asitAdditems),
				mp.getUnderDispenserModelOfLeakSensor());
			setValue(getAddItem(cb.get("UDCDetectionOfLeak"), asitAdditems), mp.getUDCDetectionOfLeak());
			setValue(getAddItem(cb.get("UDCLeakAlarmTriggShutdown"), asitAdditems), mp.getUDCLeakAlarmTriggShutdown());
			setValue(getAddItem(cb.get("UDCFailureTriggShutdown"), asitAdditems), mp.getUDCFailureTriggShutdown());
			setValue(getAddItem(cb.get("UDCMonitoringStopFlow"), asitAdditems), mp.getUDCMonitoringStopFlow());
			setDropdownValue(getValue(mp.getUDCConstruction()),"UDCConstruction", asitAdditems);
			setDropdownValue(getValue(mp.getUDCSecondaryContainmentMonitoring()),"UDCSecondaryContainmentMonitoring", asitAdditems);
			
			setValue(getAddItem(cb.get("LeakWithinSecondaryContainmentOfUDC"), asitAdditems),
				mp.getLeakWithinSecondaryContainmentOfUDC());
		}
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "PERIODIC SYSTEM TESTING");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setValue(getAddItem(cb.get("ELDTesting"), asitAdditems), mp.getELDTesting());
			setValue(getAddItem(cb.get("SecondaryContainmentTesting"), asitAdditems),
				mp.getSecondaryContainmentTesting());
			setValue(getAddItem(cb.get("SpillBucketTesting"), asitAdditems), mp.getSpillBucketTesting());
		}
		/*
		 * @XmlElementRefs({
		 *
		 * @XmlElementRef(name = "SIRTestingResults", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "VisualInspectionRecords", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "ATGTestingResults", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "AlarmLogs", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "CorrosionProtectionLogs", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "TankGaugingResults", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "TankIntegrityTestingResults", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "EquipmentMaintenanceCalibrationRecords", type = JAXBElement.class) })
		 */
		List<JAXBElement<YesNoFlagType>> alarmlogs = mp
				.getAlarmLogsOrVisualInspectionRecordsOrTankIntegrityTestingResults();
		if (alarmlogs != null)
		{
			obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "RECORDKEEPING");
			if (obs != null)
			{
				subGroup = (AdditionalInformationSubGroup) obs[1];
				asitAdditems = subGroup.getAdditionalItems();

				for (JAXBElement<?> ob1 : alarmlogs)
				{
					if ("AlarmLogs".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("AlarmLogs"), asitAdditems), ob1.getValue());
					}
					else if ("VisualInspectionRecords".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("VisualInspectionRecords"), asitAdditems), ob1.getValue());
					}
					else if ("TankIntegrityTestingResults".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("TankIntegrityTestingResults"), asitAdditems), ob1.getValue());
					}
					else if ("SIRTestingResults".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("SIRTestingResults"), asitAdditems), ob1.getValue());
					}
					else if ("TankGaugingResults".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("TankGaugingResults"), asitAdditems), ob1.getValue());
					}
					else if ("ATGTestingResults".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("ATGTestingResults"), asitAdditems), ob1.getValue());
					}
					else if ("CorrosionProtectionLogs".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("CorrosionProtectionLogs"), asitAdditems), ob1.getValue());
					}
					else if ("EquipmentMaintenanceCalibrationRecords".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("EquipmentMaintenanceCalibrationRecords"), asitAdditems),
							ob1.getValue());
					}
				}
			}
		}

		/*
		 * @XmlElementRefs({
		 *
		 * @XmlElementRef(name = "CAUSTLaw", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "OperatingManuals", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "SWRCBPublicationAutomaticTankGauging", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "USTMonitoringPlan", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "SWRCBHandbook", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "USTPersonnelFamiliarTraining", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "SpecifyTrainingOther", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "CAUSTRegulations", type = JAXBElement.class),
		 *
		 * @XmlElementRef(name = "TrainingOther", type = JAXBElement.class) })
		 */
		List<JAXBElement<?>> falim = mp.getUSTPersonnelFamiliarTrainingOrUSTMonitoringPlanOrOperatingManuals();
		if (falim != null)
		{
			for (JAXBElement<?> ob1 : falim)
			{ // TRAINING
				obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "TRAINING");
				if (obs != null)
				{
					subGroup = (AdditionalInformationSubGroup) obs[1];
					asitAdditems = subGroup.getAdditionalItems();

					if ("USTPersonnelFamiliarTraining".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("USTPersonnelFamiliarTraining"), asitAdditems), ob1.getValue());
					}
					else if ("USTMonitoringPlan".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("USTMonitoringPlan"), asitAdditems), ob1.getValue());
					}
					else if ("OperatingManuals".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("OperatingManuals"), asitAdditems), ob1.getValue());
					}
					else if ("CAUSTRegulations".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("CAUSTRegulations"), asitAdditems), ob1.getValue());
					}
					else if ("CAUSTLaw".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("CAUSTLaw"), asitAdditems), ob1.getValue());
					}
					else if ("SWRCBHandbook".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("SWRCBHandbook"), asitAdditems), ob1.getValue());
					}
					else if ("SWRCBPublicationAutomaticTankGauging".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("SWRCBPublicationAutomaticTankGauging"), asitAdditems),
							ob1.getValue());
					}
					else if ("TrainingOther".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("TrainingOther"), asitAdditems), ob1.getValue());
					}
					else if ("SpecifyTrainingOther".equals(toString(ob1.getName())))
					{
						setValue(getAddItem(cb.get("SpecifyTrainingOther"), asitAdditems), ob1.getValue());
					}
				}
			}
		}
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "TRAINING");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();

			setValue(getAddItem(cb.get("DesignatedOperatorTraining"), asitAdditems), mp.getDesignatedOperatorTraining());
			setValue(getAddItem(cb.get("CommentsAdditionalInformation"), asitAdditems),
				mp.getCommentsAdditionalInformation());
		}
		// PERSONNEL RESPONSIBILITIES
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "PERSONNEL RESPONSIBILITIES");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();

			setValue(getAddItem(cb.get("FirstNameResponsibility"), asitAdditems), mp.getFirstNameResponsibility());
			setValue(getAddItem(cb.get("FirstTitleResponsibility"), asitAdditems), mp.getFirstTitleResponsibility());
			setValue(getAddItem(cb.get("SecondNameResponsibility"), asitAdditems), mp.getSecondNameResponsibility());
			setValue(getAddItem(cb.get("SecondTitleResponsibility"), asitAdditems), mp.getSecondTitleResponsibility());

		}
		// OWNER/OPERATOR SIGNATURE
		obs = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "OWNER/OPERATOR SIGNATURE");
		if (obs != null)
		{
			subGroup = (AdditionalInformationSubGroup) obs[1];
			asitAdditems = subGroup.getAdditionalItems();
			setDropdownValue(getValue(mp.getSignatureRepresentation()),"SignatureRepresentation", asitAdditems);
			
			setValue(getAddItem(cb.get("SignatureDate"), asitAdditems), mp.getSignatureDate());
			setValue(getAddItem(cb.get("ApplicantName"), asitAdditems), mp.getApplicantName());
			setValue(getAddItem(cb.get("ApplicantTitle"), asitAdditems), mp.getApplicantTitle());
		}

	}

	@Override
	public UpdateCAP convertToUpdateCAP(List<AdditionalInformation> additionInfos, Object currObject,String strdataset, Object... objects)
	{
		System.out.println("convertToUpdateCAP");
		USTTankType utt = (USTTankType) currObject;
		List<AdditionalInformation> addInfos = additionInfos;
		UpdateCAP updateCap = new UpdateCAP();
		CAPId capId = (CAPId) objects[0];
		updateCap.setCAPId(capId);
		updateCap.setSystem(AuthService.getSystem());
		updateCap.setStatus(CapUtil.getDefaultStatusByCapType(cb.get("UST.capType")));
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
		FacilitySubmittalType facilitySubmittalType = null;
		if (objects != null && objects.length > 0)
		{
			if (objects[0] instanceof FacilitySubmittalType)
			{
				facilitySubmittalType = (FacilitySubmittalType) objects[0];
			}
		}
		
		setAsi(addInfoGroup, utt, facilitySubmittalType);
		dealUSTOperatingPermitApplication(utt, addInfoGroup);
		USTMonitoringPlanType mp = utt.getMonitoringPlan();
		dealUSTMonitoringPlan(mp, addInfoGroup);
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

	private void setAsi(Collection<AdditionalInformationGroup> addInfoGroup, USTTankType utt, FacilitySubmittalType facilitySubmittalType)
	{

		// part asi key must be exists.
		Object mdeAsiSubGroup[] = getAddInfoSubGroup(addInfoGroup, "DEH_HUST", "DATA EXCHANGE INFORMATION");
		AdditionalInformationSubGroup asiSubGroup = null;
		if (mdeAsiSubGroup != null)
		{
			asiSubGroup = (AdditionalInformationSubGroup) mdeAsiSubGroup[1];
			AdditionalItems asitAdditems = null;
			asitAdditems = asiSubGroup.getAdditionalItems();
			setValue(getAddItem("CERS Unique Key", asitAdditems), utt.getCERSUniqueKey());
			
			if (facilitySubmittalType != null && facilitySubmittalType.getUndergroundStorageTanks() != null
					&& facilitySubmittalType.getUndergroundStorageTanks().getSubmittalElementHeader() != null)
			{
				SubmittalElementHeaderType seht = facilitySubmittalType.getUndergroundStorageTanks()
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
