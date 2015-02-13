package com.accela.adapter.service.impl;

import java.util.List;
import java.util.Map;

import com.accela.adapter.model.cap.CAPId;
import com.accela.adapter.model.cap.CAPRelation;
import com.accela.adapter.model.cap.CAPRelations;
import com.accela.adapter.model.cap.InitiateCAP;
import com.accela.adapter.model.cap.InitiateCAPResponse;
import com.accela.adapter.model.common.AdditionalInformation;
import com.accela.adapter.model.common.AdditionalInformationGroup;
import com.accela.adapter.model.function.GovXML;
import com.accela.cers.ConvertHelper;
import com.accela.cers.cap.model.ChemicalType;
import com.accela.cers.cap.model.FacilitySubmittalType;
import com.accela.cers.cap.model.HWUnitType;
import com.accela.cers.cap.model.HWUnitsType;
import com.accela.cers.cap.model.HazardousMaterialsInventoryType;
import com.accela.cers.cap.model.OnsiteHazardousWasteTreatmentNotificationType;
import com.accela.cers.cap.model.USTTankType;
import com.accela.cers.cap.model.USTTanksType;
import com.accela.cers.cap.model.UndergroundStorageTanksType;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: SubCapService.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2012-2013
 * 
 *  Description:
 *  
 * 
 *  Notes:
 * 	$Id: SubCapService.java 72642 2009-01-01 20:01:57Z ACHIEVO\zony.rao $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2012-12-13		zony.rao		Initial.
 * 
 * </pre>
 */
public class SubCapService
{
	private CapServiceCommon csc = CapServiceCommon.getInstance();

	//private Log LOGGER = LogFactory.getLog(SubCapService.class);

	public void doFacilityOther(CAPId parentCapId, FacilitySubmittalType facilitySubmittalType)

	{

		if (parentCapId != null && parentCapId.getKeys() != null && parentCapId.getKeys().get(0) != null
				&& parentCapId.getKeys().get(0).getKey() != null && parentCapId.getKeys().get(0).getKey().size() > 1)
		{

//			ParentCAPIds pcis = new ParentCAPIds();
//			CAPId pci = new CAPId();
//			pci.getKeys().add(parentCapId.getKeys().get(0));
//			pcis.setCapId(pci);
			
			createOrUpateCapByChemicals(facilitySubmittalType, parentCapId);
			// do create cap
			createOrUpdateCapByUnderStorge(facilitySubmittalType);
			// perentObject.getOnsiteHazardousWasteTreatmentNotification().getHWFacility().getHWUnits().getHWUnit();
			// perentObject.getHWTankClosureCertification();
			createOrUpdateCapByWaster(facilitySubmittalType);
		}
	}

	/**
	 * Creates the cap by chemicals.
	 * 
	 * @param relationCap the relation cap
	 * @param hmater the hmater
	 * 
	 * @throws Exception the exception
	 */
	private void createOrUpateCapByChemicals(FacilitySubmittalType facilitySubmittalType,CAPId parentCapId)
	{
		HazardousMaterialsInventoryType hmater = facilitySubmittalType.getHazardousMaterialsInventory();
		if (hmater != null)
		{
			String status = (hmater.getSubmittalElementHeader()==null)? null : hmater.getSubmittalElementHeader().getSubmittalStatus();
			if ( !CapServiceCommon.SUBMITTAL_STATUS.equals(status) ) {
				return;	// only sync submittals in Accepted status
			}
			
			HazardousMaterialsInventoryType.Chemicals chemicals = hmater.getChemicals();
			if (chemicals != null)
			{
				List<AdditionalInformation> additionChemicalInfos = csc.addtion.get(csc.types[1]);
				List<ChemicalType> chemicalls = chemicals.getChemical();
				for (ChemicalType chemicalType : chemicalls)
				{
					if (chemicalType != null)
					{

						if (chemicalType.getHMType() != null && chemicalType.getHMType().getValue() != null
								&& "c".equals(chemicalType.getHMType().getValue().value()))
						{
							sendSubCap( chemicalType, chemicalType.getCERSUniqueKey(),
								csc.addtion.get(csc.types[3]), csc.types[3], facilitySubmittalType.getCERSID() + "",parentCapId, facilitySubmittalType);
						}
						else
						{
							sendSubCap( chemicalType, chemicalType.getCERSUniqueKey(),
								additionChemicalInfos, csc.types[1], facilitySubmittalType.getCERSID() + "",parentCapId, facilitySubmittalType);
						}

					}

				}
			}
		}
	}

	/**
	 * Creates the cap by under storge.
	 * 
	 * @param relationCap the relation cap
	 * @param facilitySubmittalType the facility submittal type
	 * 
	 * @throws Exception the exception
	 */
	private void createOrUpdateCapByUnderStorge(FacilitySubmittalType facilitySubmittalType)
	{
		UndergroundStorageTanksType ustt = facilitySubmittalType.getUndergroundStorageTanks();
		if (ustt != null)
		{
			String status = (ustt.getSubmittalElementHeader()==null)? null : ustt.getSubmittalElementHeader().getSubmittalStatus();
			if ( !CapServiceCommon.SUBMITTAL_STATUS.equals(status) ) {
				return;	// only sync submittals in Accepted status
			}
			
			USTTanksType ustanks = ustt.getUSTTanks();
			if (ustanks != null)
			{
				List<USTTankType> uTankList = ustanks.getUSTTank();
				if (uTankList != null && uTankList.size() > 0)
				{
					List<AdditionalInformation> additionuTankInfos = csc.addtion.get(csc.types[2]);
					for (USTTankType ust : uTankList)
					{
						if (ust != null)
						{
							sendSubCap(ust, ust.getCERSUniqueKey(), additionuTankInfos, csc.types[2],
								facilitySubmittalType.getCERSID() + "",facilitySubmittalType);
						}
					}
				}
			}
		}
	}

	private void sendSubCap(Object ob, String key,
			List<AdditionalInformation> additionuTankInfos, String sourceName, String cersid, Object... objs)
	{
		// List<String> capIds = null;
		// try
		// {
		// capIds = CapUtil.getCapByCersId(key);
		// }
		// catch (Exception e)
		// {
		// csc.addFail(sourceName + ".fail", cersid + "." + key);
		// csc.addCount(sourceName + ".all");
		// LOGGER.warn("fail to query key:" + key + " from AA.");
		//
		// }
		// if (capIds != null && !capIds.isEmpty())
		// {
		// // update
		// CAPId capId = csc.getCapId(capIds);
		// UpdateCAP updateCap = ConvertHelper.updateCAPModel(additionuTankInfos, ob, capId);
		// csc.callGovXMLUpdateCapWithRetry(updateCap, sourceName, key, cersid, true);
		//
		// }
		// else
		// {
		InitiateCAP subcap = ConvertHelper.convertToCAP(additionuTankInfos, ob, "",objs);
		GovXML insertXml = csc.callGovXMLCreateCapWithRetry(subcap, sourceName, key, cersid);
		setAddtionInformation(csc.laig,sourceName,key,insertXml);
	    setAllChildRelation(csc.cAPRelations,insertXml,sourceName,key,cersid);
	//	updateRelation(relationCap, insertXml, sourceName, key, cersid);
		// }

	}

	/**
	 * 
	 * need to put record to AddtionInformation
	 * 
	 * @param ucap
	 * @param subcap
	 * @param sourceName
	 * @param sourceKey
	 * @param cersId
	 */

	public void setAddtionInformation(Map<String, AdditionalInformationGroup> ais, String type, String key,
			GovXML insertXml)
	{
		if ( insertXml != null ) {
			List<InitiateCAPResponse> icp = insertXml.getInitiateCAPResponse();
			String value = null;
			if (icp != null && icp.get(0) != null && icp.get(0).getCAPId() != null)
			{
				CAPId id = insertXml.getInitiateCAPResponse().get(0).getCAPId().get(0);
	//			List<String> keys = id.getKeys().get(0).getKey();
	//			StringBuilder sb = new StringBuilder();
	//			sb.append(keys.get(0)).append("-");
	//			sb.append(keys.get(1)).append("-");
	//			sb.append(keys.get(2));
				value = id.getIdentifierDisplay();
			}
			csc.setGroupChildId(ais.get(type), key, value);
		}
	}

	/**
	 * 
	 * set relation all child in a relations
	 * 
	 * @param ucap
	 * @param subcap
	 * @param sourceName
	 * @param sourceKey
	 * @param cersId
	 */
	public void setAllChildRelation(CAPRelations cAPRelations, GovXML subcap, String sourceName, String sourceKey,
			String cersId)
	{
		if ( subcap != null ) {
			List<InitiateCAPResponse> icp = subcap.getInitiateCAPResponse();
			if (icp != null && icp.get(0) != null && icp.get(0).getCAPId() != null)
			{
				
				CAPId id = subcap.getInitiateCAPResponse().get(0).getCAPId().get(0);
				if (id != null)
				{
					id.setIdentifierDisplay(null);
					id.setTrackingNumber(null);
					CAPRelation capr = new CAPRelation();
					capr.setAction("Add");
					capr.setContextType("Child");
					capr.setCAPId(id);
					cAPRelations.getCAPRelation().add(capr);
				}
			}
		}
	}

//	private void updateRelation(UpdateCAP ucap, GovXML subcap, String sourceName, String sourceKey, String cersId)
//	{
//		List<InitiateCAPResponse> icp = subcap.getInitiateCAPResponse();
//		if (icp != null && icp.get(0) != null && icp.get(0).getCAPId() != null)
//		{
//			CAPId id = subcap.getInitiateCAPResponse().get(0).getCAPId().get(0);
//			if (ucap != null && id != null)
//			{
//				id.setIdentifierDisplay(null);
//				id.setTrackingNumber(null);
//				CAPRelations cAPRelations = new CAPRelations();
//				CAPRelation capr = new CAPRelation();
//				capr.setAction("Add");
//				capr.setContextType("Child");
//				capr.setCAPId(id);
//				cAPRelations.getCAPRelation().add(capr);
//				ucap.setCAPRelations(cAPRelations);
//				csc.callGovXMLUpdateCapWithRetry(ucap, sourceName, sourceKey, cersId, false);
//			}
//		}
//	}

	/**
	 * Creates the cap by waster.
	 * 
	 * @param relationCap the relation cap
	 * @param facilitySubmittalType the facility submittal type
	 * @param pcis the pcis
	 * 
	 * @throws Exception the exception
	 */
	private void createOrUpdateCapByWaster(FacilitySubmittalType facilitySubmittalType)

	{
		OnsiteHazardousWasteTreatmentNotificationType ohwtnt = facilitySubmittalType
				.getOnsiteHazardousWasteTreatmentNotification();
		if (ohwtnt != null && ohwtnt.getHWFacility() != null)
		{
			String status = (ohwtnt.getSubmittalElementHeader()==null)? null : ohwtnt.getSubmittalElementHeader().getSubmittalStatus();
			if ( !CapServiceCommon.SUBMITTAL_STATUS.equals(status) ) {
				return;	// only sync submittals in Accepted status
			}
			
			HWUnitsType hwus = ohwtnt.getHWFacility().getHWUnits();
			if (hwus != null && hwus.getHWUnit() != null)
			{
				List<HWUnitType> hwl = hwus.getHWUnit();
				List<AdditionalInformation> additionHWfos = csc.addtion.get(csc.types[3]);
				for (HWUnitType hw : hwl)
				{
					sendSubCap(hw, ohwtnt.getHWFacility().getCERSUniqueKey(), additionHWfos, csc.types[3],
							facilitySubmittalType.getCERSID() + "", facilitySubmittalType);
				}
			}
		}
	}

}

/*
 * $Log: av-env.bat,v $
 */
