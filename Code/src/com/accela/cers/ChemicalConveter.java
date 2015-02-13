package com.accela.cers;

import java.util.Collection;
import java.util.Iterator;
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
import com.accela.cers.cap.model.ChemicalType;
import com.accela.cers.cap.model.FacilitySubmittalType;
import com.accela.cers.cap.model.SubmittalElementHeaderType;
import com.accela.cers.cap.model.YesNoFlagType;

/**
 * <pre>
 *
 *  Accela Automation
 *  File: ChemicalConveter.java
 *
 *  Accela, Inc.
 *  Copyright (C): 2012-2013
 *
 *  Description:
 *
 *
 *  Notes:
 * 	$Id: ChemicalConveter.java 72642 2009-01-01 20:01:57Z ACHIEVO\zony.rao $
 *
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2012-11-28		zony.rao		Initial.
 *
 * </pre>
 */
public class ChemicalConveter extends ICAPConvert
{
	private String type = "Chemical";

	@Override
	public InitiateCAP convertToInitCAP(List<AdditionalInformation> addInfos, Object currObject,String strdatetime, Object... objects)

	{

		ChemicalType chemical = (ChemicalType) currObject;
		CAPId capId = (CAPId) objects[0];
		FacilitySubmittalType facilitySubmittalType = null;
		if (objects != null && objects.length >= 2)
		{
			if (objects[1] instanceof FacilitySubmittalType)
			{
				facilitySubmittalType = (FacilitySubmittalType) objects[1];
			}
		}
		InitiateCAP initCap = new InitiateCAP();
		initCap.setCAPTypeId(CapUtil.getCapTypeIdByString("Chemical"));
		if (chemical.getHMType() != null && chemical.getHMType().getValue() != null
				&& "c".equals(chemical.getHMType().getValue().value()))
		{
			type = "Waste";
			initCap.getCAPTypeId().getKeys().getKey().set(3, type);
		}
		initCap.setSystem(AuthService.getSystem());
		initCap.setFinalizeNow(true);
		AdditionalInformation addCopy = addInfos.get(0).clone();
		initCap.setAdditionalInformation(addCopy);
		initCap.setStatus(CapUtil.getDefaultStatusByCapType(cb.get("Chemical.capType")));

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

		List<AdditionalInformationGroup> addInfoGroup = initCap.getAdditionalInformation()

		.getAdditionalInformationGroup();
		// initCap.setName(chemical.)

		setAsi(addInfoGroup, chemical, false, capId.getIdentifierDisplay(), facilitySubmittalType);
		
		if (chemical.getHMType() != null && chemical.getHMType().getValue() != null
				&& "c".equals(chemical.getHMType().getValue().value()))
		{
			//Remove useless ASIT.
			List<AdditionalInformationGroup> group = addCopy.getAdditionalInformationGroup();
			String needUpdatedASITName= (String)cb.get("NeedUpdatedASIT4WasteFromChemical");
			AdditionalInformationGroup ag = null;
			for (int i = group.size() - 1; i >= 0; i--)
			{
				ag = group.get(i);
				String identifierDisplay = ag.getIdentifierDisplay();
				if (!needUpdatedASITName.contains(identifierDisplay))
				{
					group.remove(i);
				}
			}
		}
		return initCap;

	}

	public Object[] getAddInfoSubGroup(Collection<AdditionalInformationGroup> addInfoGroup, String groupName,
			String subGroupName)
	{

		if ("Waste".equals(type))
		{
			groupName = "DEH_HUPW_T27";
			subGroupName = subGroupName.replace("CHEMICAL", "WASTE");
		}
		for (Iterator<AdditionalInformationGroup> iterGroup = addInfoGroup.iterator(); iterGroup.hasNext();)
		{
			AdditionalInformationGroup addGroup = iterGroup.next();
			if (addGroup.getKeys().getKey().get(0).equals(groupName))
			{
				Collection<AdditionalInformationSubGroup> subGroups = addGroup.getAdditionalInformationSubGroup();
				for (Iterator<AdditionalInformationSubGroup> iterSubGroup = subGroups.iterator(); iterSubGroup
						.hasNext();)
				{
					AdditionalInformationSubGroup subGroup = iterSubGroup.next();
					if (subGroup.getKeys().getKey().get(0).equals(subGroupName))
					{
						return new Object[] {addGroup, subGroup};
					}
				}
			}
		}

		return null;

	}

	private void setAsi(List<AdditionalInformationGroup> addInfoGroup, ChemicalType chemical, boolean isUpdate,
			String recordId, FacilitySubmittalType facilitySubmittalType)

	{

		// part asi key must be exists.
		Object mdeAsiSubGroup[] = getAddInfoSubGroup(addInfoGroup, "DEH_HCHEM", "DATA EXCHANGE INFORMATION");
		AdditionalInformationSubGroup asiSubGroup = null;
		if (mdeAsiSubGroup != null)
		{
			asiSubGroup = (AdditionalInformationSubGroup) mdeAsiSubGroup[1];
			AdditionalItems asitAdditems = null;
			asitAdditems = asiSubGroup.getAdditionalItems();

			setValue(getAddItem("CERS Unique Key", asitAdditems), chemical.getCERSUniqueKey());

			if (facilitySubmittalType != null && facilitySubmittalType.getHazardousMaterialsInventory() != null
					&& facilitySubmittalType.getHazardousMaterialsInventory().getSubmittalElementHeader() != null)
			{
				SubmittalElementHeaderType seht = facilitySubmittalType.getHazardousMaterialsInventory()
						.getSubmittalElementHeader();
				setValue(getAddItem("CERS Submittal ID", asitAdditems), seht.getCERSUniqueKey());
				setValue(getAddItem("CUPA Element Submitted", asitAdditems), "");
				setValue(getAddItem("Submitted On", asitAdditems), seht.getSubmittedOn());
				setValue(getAddItem("Submitted By", asitAdditems), seht.getSubmittedByFirstName() + " "
						+ seht.getSubmittedByLastName());
				setValue(getAddItem("Submittal Status", asitAdditems), "Accepted");
				setValue(getAddItem("Submittal Reviewed By", asitAdditems), seht.getSubmittalActionDetails()
						.getSubmittalActionAgentName());
				setValue(getAddItem("Submittal Status Date", asitAdditems), seht.getSubmittalActionDetails()
						.getSubmittalActionOn());
				setValue(getAddItem("Date Moved to Historical Records", asitAdditems), "");
			}
		}


		// part asi.
		mdeAsiSubGroup = getAddInfoSubGroup(addInfoGroup, "DEH_HCHEM", "CHEMICAL SUMMARY");
		asiSubGroup = null;
		if (mdeAsiSubGroup != null)
		{
			asiSubGroup = (AdditionalInformationSubGroup) mdeAsiSubGroup[1];
			AdditionalItems asitAdditems = null;
			asitAdditems = asiSubGroup.getAdditionalItems();
			setValue(getAddItem(cb.get("RecordId"), asitAdditems), recordId);
			setValue(getAddItem(cb.get("ChemicalLocation"), asitAdditems), chemical.getChemicalLocation());
			setValue(getAddItem(cb.get("ChemicalName"), asitAdditems), chemical.getChemicalName());
			setValue(getAddItem(cb.get("CommonName"), asitAdditems), chemical.getCommonName());
			setValue(getAddItem(cb.get("CommonName1"), asitAdditems), chemical.getCommonName());
			setValue(getAddItem(cb.get("EHS"), asitAdditems), chemical.getEHS());
			setValue(getAddItem(cb.get("CASNumber"), asitAdditems), chemical.getCASNumber());
			setValue(getAddItem(cb.get("MaximumDailyAmount"), asitAdditems), chemical.getMaximumDailyAmount());
			setValue(getAddItem(cb.get("AnnualWasteAmount"), asitAdditems), chemical.getAnnualWasteAmount());
			setValue(getAddItem(cb.get("StateWasteCode"), asitAdditems), chemical.getStateWasteCode());
			//setDropdownValue(chemical.getStateWasteCode(),"StateWasteCode", asitAdditems);
			setDropdownValue(getValue(chemical.getUnits()),"Units_1", asitAdditems);
			//setValue(getAddItem(cb.get("Units_1"), asitAdditems), chemical.getUnits());
			setValue(getAddItem(cb.get("ChemicalDescriptionComment"), asitAdditems),
				chemical.getChemicalDescriptionComment());
			setValue(getAddItem(cb.get("CCLID"), asitAdditems), chemical.getCCLID());
			setValue(getAddItem(cb.get("USEPASRSNumber"), asitAdditems), chemical.getUSEPASRSNumber());
		}
		// part asi two
		mdeAsiSubGroup = getAddInfoSubGroup(addInfoGroup, "DEH_HCHEM", "CHEMICAL DETAILS");
		asiSubGroup = null;
		if (mdeAsiSubGroup != null)
		{
			asiSubGroup = (AdditionalInformationSubGroup) mdeAsiSubGroup[1];
			AdditionalItems asitAdditems = null;
			asitAdditems = asiSubGroup.getAdditionalItems();
			setValue(getAddItem(cb.get("CLConfidential"), asitAdditems), chemical.getCLConfidential());
			setValue(getAddItem(cb.get("MapNumber"), asitAdditems), chemical.getMapNumber());
			setValue(getAddItem(cb.get("GridNumber"), asitAdditems), chemical.getGridNumber());
			setValue(getAddItem(cb.get("TradeSecret"), asitAdditems), chemical.getTradeSecret());
			setDropdownValue(getValue(chemical.getPFCodeHazardClass()),"PFCodeHazardClass", asitAdditems);
			setDropdownValue(getValue(chemical.getSFCodeHazardClass()),"SFCodeHazardClass", asitAdditems);
//			setValue(getAddItem(cb.get("PFCodeHazardClass"), asitAdditems), chemical.getPFCodeHazardClass());
//			setValue(getAddItem(cb.get("SFCodeHazardClass"), asitAdditems), chemical.getSFCodeHazardClass());
			setDropdownValue(getValue(chemical.getTFCodeHazardClass()),"TFCodeHazardClass", asitAdditems);
			setDropdownValue(getValue(chemical.getFFCodeHazardClass()),"FFCodeHazardClass", asitAdditems);
			setDropdownValue(getValue(chemical.getFifthFireCodeHazardClass()),"FifthFireCodeHazardClass", asitAdditems);
			setDropdownValue(getValue(chemical.getSixthFireCodeHazardClass()),"SixthFireCodeHazardClass", asitAdditems);
			setDropdownValue(getValue(chemical.getSeventhFireCodeHazardClass()),"SeventhFireCodeHazardClass", asitAdditems);
			setDropdownValue(getValue(chemical.getEighthFireCodeHazardClass()),"EighthFireCodeHazardClass", asitAdditems);

//			setValue(getAddItem(cb.get("TFCodeHazardClass"), asitAdditems), chemical.getTFCodeHazardClass());
//			setValue(getAddItem(cb.get("FFCodeHazardClass"), asitAdditems), chemical.getFFCodeHazardClass());
//			setValue(getAddItem(cb.get("FifthFireCodeHazardClass"), asitAdditems),
//				chemical.getFifthFireCodeHazardClass());
//			setValue(getAddItem(cb.get("SixthFireCodeHazardClass"), asitAdditems),
//				chemical.getSixthFireCodeHazardClass());
//			setValue(getAddItem(cb.get("SeventhFireCodeHazardClass"), asitAdditems),
//				chemical.getSeventhFireCodeHazardClass());
//			setValue(getAddItem(cb.get("EighthFireCodeHazardClass"), asitAdditems),
//				chemical.getEighthFireCodeHazardClass());

			setDropdownValue(getValue(chemical.getHMType()),"HMType", asitAdditems);
			//setValue(getAddItem(cb.get("HMType"), asitAdditems), chemical.getHMType());

			setValue(getAddItem(cb.get("RadioActive"), asitAdditems), chemical.getRadioActive());
			setValue(getAddItem(cb.get("Curies"), asitAdditems), chemical.getCuries());

			setDropdownValue(getValue(chemical.getPhysicalState()),"PhysicalState", asitAdditems);
			//setValue(getAddItem(cb.get("PhysicalState"), asitAdditems), chemical.getPhysicalState());
			setValue(getAddItem(cb.get("LargestContainer"), asitAdditems), chemical.getLargestContainer());
			List<JAXBElement<YesNoFlagType>> ynt = chemical.getFHCFireOrFHCReactiveOrFHCPressureRelease();
			if (ynt != null)
			{

				for (JAXBElement<YesNoFlagType> ynj : ynt)
				{
					if ("FHCFire".equals(toString(ynj.getName())))
					{
						setValue(getAddItem(cb.get("FHCFire"), asitAdditems), ynj);
					}
					else if ("FHCReactive".equals(toString(ynj.getName())))
					{
						setValue(getAddItem(cb.get("FHCReactive"), asitAdditems), ynj);
					}
					else if ("FHCPressureRelease".equals(toString(ynj.getName())))
					{
						setValue(getAddItem(cb.get("FHCPressureRelease"), asitAdditems), ynj);
					}
					else if ("FHCAcuteHealth".equals(toString(ynj.getName())))
					{
						setValue(getAddItem(cb.get("FHCAcuteHealth"), asitAdditems), ynj);
					}
					else if ("FHCChronicHealth".equals(toString(ynj.getName())))
					{
						setValue(getAddItem(cb.get("FHCChronicHealth"), asitAdditems), ynj);
					}
				}
			}
			setValue(getAddItem(cb.get("AverageDailyAmount"), asitAdditems), chemical.getAverageDailyAmount());
			setValue(getAddItem(cb.get("DaysOnSite"), asitAdditems), chemical.getDaysOnSite());

			setDropdownValue(getValue(chemical.getStoragePressure()),"StoragePressure", asitAdditems);
			//setValue(getAddItem(cb.get("StoragePressure"), asitAdditems), chemical.getStoragePressure());

			setDropdownValue(getValue(chemical.getStorageTemperature()),"StorageTemperature", asitAdditems);
			//setValue(getAddItem(cb.get("StorageTemperature"), asitAdditems), chemical.getStorageTemperature());

			setDropdownValue(chemical.getDOTHazardClassificationID(),"DOTHazardClassificationID", asitAdditems);
//			setValue(getAddItem(cb.get("DOTHazardClassificationID"), asitAdditems),
//				chemical.getDOTHazardClassificationID());
		}

		// part asi
		mdeAsiSubGroup = getAddInfoSubGroup(addInfoGroup, "DEH_HCHEM", "CONTAINERS");
		asiSubGroup = null;
		if (mdeAsiSubGroup != null)
		{
			long index = 0;
			asiSubGroup = (AdditionalInformationSubGroup) mdeAsiSubGroup[1];
			AdditionalInformationGroup aig = (AdditionalInformationGroup) mdeAsiSubGroup[0];
			index--;
			if (isUpdate)
				asiSubGroup.getKeys().getKey().add("" + index);
			JAXBElement<YesNoFlagType> value2 = null;
			List<JAXBElement<?>> jaxs = chemical.getSCAboveGroundTankOrSCUnderGroundTankOrSCTankInsideBuilding();
			boolean removeall = true;
			if (jaxs != null)
			{

				for (JAXBElement<?> jax : jaxs)
				{
					if ("SCAboveGroundTank".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223a Aboveground Tank", aig, value2);
					}
					else if ("SCUnderGroundTank".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223b Underground Tank", aig, value2);

					}
					else if ("SCTankInsideBuilding".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						//
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223c Tank Inside Building", aig, value2);

					}
					else if ("SCSteelDrum".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223d Steel Drum", aig, value2);

					}
					else if ("SCPlasticNonMetallicDrum".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223e Plastic/Non-Metallic Drum", aig, value2);

					}
					else if ("SCCan".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223f Can", aig, value2);
					}
					else if ("SCCarboy".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223g Carboy", aig, value2);
					}
					else if ("SCSilo".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223h Silo", aig, value2);

					}
					else if ("SCFiberDrum".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223i Fiber Drum", aig, value2);

					}
					else if ("SCBag".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223j Bag", aig, value2);
					}
					else if ("SCBox".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223k Box", aig, value2);
					}
					else if ("SCCylinder".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223l Cylinder", aig, value2);
					}
					else if ("SCGlassBottle".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223m Glass Bottle", aig, value2);
					}
					else if ("SCPlasticBottle".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223n Plastic Bottle", aig, value2);
					}
					else if ("SCToteBin".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223o Tote Bin", aig, value2);
					}
					else if ("SCTankTruckTankWagon".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223p Tank Truck, Tank Wagon", aig, value2);

					}
					else if ("SCTankCarRailCar".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						setGroup(asiSubGroup, index, isUpdate, "223q Tank Car, Rail Car", aig, value2);

					}
					else if ("SCOther".equals(toString(jax.getName())) && "Y".equals(getValue(jax)))
					{
						index--;
						removeall = false;
						Object value = null;
						for (JAXBElement<?> jaxt : jaxs)
						{
							if ("OtherStorageContainer".equals(toString(jaxt.getName())))
							{
								value = jaxt.getValue();
							}
						}
						setGroup(asiSubGroup, index, isUpdate, "223r Other", aig, value);
					}
				}
			}
			aig.getAdditionalInformationSubGroup().remove(asiSubGroup);
			if (removeall)
			{
				addInfoGroup.remove(aig);
			}
		}

		// part asit
		mdeAsiSubGroup = getAddInfoSubGroup(addInfoGroup, "DEH_HCHEM", "COMPONENTS");
		asiSubGroup = null;
		if (mdeAsiSubGroup != null)
		{
			long index = 0;
			boolean needGroup = false;
			boolean isWasteType = false;
			if (chemical.getHMType() != null && chemical.getHMType().getValue() != null
					&& "c".equalsIgnoreCase(chemical.getHMType().getValue().value()))
			{
				isWasteType = true;
			}
			// 1
			AdditionalInformationGroup aig = (AdditionalInformationGroup) mdeAsiSubGroup[0];
			asiSubGroup = (AdditionalInformationSubGroup) mdeAsiSubGroup[1];
			AdditionalItems asitAdditems = null;
			AdditionalInformationSubGroup asiSubGroupClone = null;
			if (!(chemical.getHC1PercentByWeight() == null && chemical.getHC1Name() == null
					&& chemical.getHC1EHS() == null && chemical.getHC1CAS() == null && chemical
						.getAdditionalMixtureComponents() == null))
			{
				needGroup = true;
				index--;
				if (isUpdate)
					asiSubGroup.getKeys().getKey().add("" + index);
				asitAdditems = asiSubGroup.getAdditionalItems();
				setValue(getAddItem(cb.get("HC1PercentByWeight"), asitAdditems), chemical.getHC1PercentByWeight());
				setValue(getAddItem(isWasteType ? cb.get("HC1Name4Waste") : cb.get("HC1Name"), asitAdditems), chemical.getHC1Name());
				setValue(getAddItem(cb.get("HC1EHS"), asitAdditems), chemical.getHC1EHS());
				setValue(getAddItem(isWasteType ? cb.get("HC1CAS4Waste") : cb.get("HC1CAS"), asitAdditems), chemical.getHC1CAS());
				setValue(getAddItem(cb.get("AdditionalMixtureComponents"), asitAdditems),
					chemical.getAdditionalMixtureComponents());
			}
			else
			{
				aig.getAdditionalInformationSubGroup().remove(asiSubGroup);
			}
			// 2

			if (!(chemical.getHC2PercentByWeight() == null && chemical.getHC2Name() == null
					&& chemical.getHC2EHS() == null && chemical.getHC2CAS() == null))
			{
				needGroup = true;
				asiSubGroupClone = asiSubGroup.clone();
				index--;
				if (isUpdate)
					asiSubGroupClone.getKeys().getKey().set(1, index + "");
				asitAdditems = asiSubGroupClone.getAdditionalItems();
				setValue(getAddItem(cb.get("HC1PercentByWeight"), asitAdditems), chemical.getHC2PercentByWeight());
				setValue(getAddItem(isWasteType ? cb.get("HC1Name4Waste") : cb.get("HC1Name"), asitAdditems), chemical.getHC2Name());
				setValue(getAddItem(cb.get("HC1EHS"), asitAdditems), chemical.getHC2EHS());
				setValue(getAddItem(isWasteType ? cb.get("HC1CAS4Waste") : cb.get("HC1CAS"), asitAdditems), chemical.getHC2CAS());
				setValue(getAddItem(cb.get("AdditionalMixtureComponents"), asitAdditems),
					chemical.getAdditionalMixtureComponents());

				aig.getAdditionalInformationSubGroup().add(asiSubGroupClone);
			}

			// 3
			if (!(chemical.getHC3PercentByWeight() == null && chemical.getHC3Name() == null
					&& chemical.getHC3EHS() == null && chemical.getHC3CAS() == null))
			{
				needGroup = true;
				asiSubGroupClone = asiSubGroup.clone();
				index--;
				if (isUpdate)
					asiSubGroupClone.getKeys().getKey().set(1, index + "");
				asitAdditems = asiSubGroupClone.getAdditionalItems();
				setValue(getAddItem(cb.get("HC1PercentByWeight"), asitAdditems), chemical.getHC3PercentByWeight());
				setValue(getAddItem(isWasteType ? cb.get("HC1Name4Waste") : cb.get("HC1Name"), asitAdditems), chemical.getHC3Name());
				setValue(getAddItem(cb.get("HC1EHS"), asitAdditems), chemical.getHC3EHS());
				setValue(getAddItem(isWasteType ? cb.get("HC1CAS4Waste") : cb.get("HC1CAS"), asitAdditems), chemical.getHC3CAS());
				setValue(getAddItem(cb.get("AdditionalMixtureComponents"), asitAdditems),
					chemical.getAdditionalMixtureComponents());
				aig = (AdditionalInformationGroup) mdeAsiSubGroup[0];
				aig.getAdditionalInformationSubGroup().add(asiSubGroupClone);
			}
			if (!(chemical.getHC4PercentByWeight() == null && chemical.getHC4Name() == null
					&& chemical.getHC4EHS() == null && chemical.getHC4CAS() == null))
			{
				// 4
				needGroup = true;
				asiSubGroupClone = asiSubGroup.clone();
				index--;
				if (isUpdate)
					asiSubGroupClone.getKeys().getKey().set(1, index + "");
				asitAdditems = asiSubGroupClone.getAdditionalItems();
				setValue(getAddItem(cb.get("HC1PercentByWeight"), asitAdditems), chemical.getHC4PercentByWeight());
				setValue(getAddItem(isWasteType ? cb.get("HC1Name4Waste") : cb.get("HC1Name"), asitAdditems), chemical.getHC4Name());
				setValue(getAddItem(cb.get("HC1EHS"), asitAdditems), chemical.getHC4EHS());
				setValue(getAddItem(isWasteType ? cb.get("HC1CAS4Waste") : cb.get("HC1CAS"), asitAdditems), chemical.getHC4CAS());
				setValue(getAddItem(cb.get("AdditionalMixtureComponents"), asitAdditems),
					chemical.getAdditionalMixtureComponents());
				aig = (AdditionalInformationGroup) mdeAsiSubGroup[0];
				aig.getAdditionalInformationSubGroup().add(asiSubGroupClone);
			}
			if (!(chemical.getHC5PercentByWeight() == null && chemical.getHC5Name() == null
					&& chemical.getHC5EHS() == null && chemical.getHC5CAS() == null))
			{
				// 5
				needGroup = true;
				asiSubGroupClone = asiSubGroup.clone();
				index--;
				if (isUpdate)
					asiSubGroupClone.getKeys().getKey().set(1, index + "");
				asitAdditems = asiSubGroupClone.getAdditionalItems();
				setValue(getAddItem(cb.get("HC1PercentByWeight"), asitAdditems), chemical.getHC5PercentByWeight());
				setValue(getAddItem(isWasteType ? cb.get("HC1Name4Waste") : cb.get("HC1Name"), asitAdditems), chemical.getHC5Name());
				setValue(getAddItem(cb.get("HC1EHS"), asitAdditems), chemical.getHC5EHS());
				setValue(getAddItem(isWasteType ? cb.get("HC1CAS4Waste") : cb.get("HC1CAS"), asitAdditems), chemical.getHC5CAS());
				setValue(getAddItem(cb.get("AdditionalMixtureComponents"), asitAdditems),
					chemical.getAdditionalMixtureComponents());
				aig = (AdditionalInformationGroup) mdeAsiSubGroup[0];
				aig.getAdditionalInformationSubGroup().add(asiSubGroupClone);
			}
			if (!needGroup)
			{
				addInfoGroup.remove(aig);
			}
		}

	}

	private void setGroup(AdditionalInformationSubGroup asiSubGroup, long index, boolean isUpdate, String value,
			AdditionalInformationGroup aig, Object value2)
	{
		AdditionalInformationSubGroup asiSubGroupClone = asiSubGroup.clone();
		if (isUpdate)
			asiSubGroupClone.getKeys().getKey().set(1, index + "");
		AdditionalItems asitAdditems = asiSubGroupClone.getAdditionalItems();
		setValue(getAddItem("Container (223)", asitAdditems), value);
		if (value2 != null)
		{
			setValue(getAddItem("Container - Other (223r-1)", asitAdditems), value2);
		}
		aig.getAdditionalInformationSubGroup().add(asiSubGroupClone);
	}

	@Override
	public UpdateCAP convertToUpdateCAP(List<AdditionalInformation> addInfos, Object currObject,String strdatetime, Object... objects)
	{
		ChemicalType chemical = (ChemicalType) currObject;
		CAPId capId = (CAPId) objects[0];
		FacilitySubmittalType facilitySubmittalType = null;
		if (objects != null && objects.length >= 2)
		{
			if (objects[1] instanceof FacilitySubmittalType)
			{
				facilitySubmittalType = (FacilitySubmittalType) objects[1];
			}
		}
		UpdateCAP updateCap = new UpdateCAP();

		updateCap.setSystem(AuthService.getSystem());
		updateCap.setCAPId(capId);
		// updateCap.setFinalizeNow(true);
		updateCap.setStatus(CapUtil.getDefaultStatusByCapType(cb.get("Chemical.capType")));
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

		List<AdditionalInformationGroup> addInfoGroup = updateCap.getAdditionalInformation()
				.getAdditionalInformationGroup();
		setAsi(addInfoGroup, chemical, true, "", facilitySubmittalType);
		List<AdditionalInformationGroup> group = addInfoGroup;
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
}

/*
 * $Log: av-env.bat,v $
 */
