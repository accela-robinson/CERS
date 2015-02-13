package com.accela.adapter.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.accela.aa.common.ConfigBase;
import com.accela.adapter.model.cap.CAP;
import com.accela.adapter.model.cap.CAPId;
import com.accela.adapter.model.cap.InitiateCAP;
import com.accela.adapter.model.common.AdditionalInformation;
import com.accela.adapter.model.common.AdditionalInformationGroup;
import com.accela.adapter.model.common.AdditionalInformationSubGroup;
import com.accela.adapter.model.common.AdditionalItem;
import com.accela.adapter.model.function.GovXML;
import com.accela.adapter.model.function.UpdateCAP;
import com.accela.adapter.util.CapUtil;
import com.accela.cers.ConvertHelper;
import com.accela.cers.cap.model.FacilitySubmittalType;
import com.accela.cers.cap.model.RegulatorFacilitySubmittals;

/**
 * <pre>
 *
 *  Accela Automation
 *  File: CapServiceA.java
 *
 *  Accela, Inc.
 *  Copyright (C): 2012-2014
 *
 *  Description:
 *
 *
 *  Notes:
 * 	$Id: CapServiceA.java 72642 2009-01-01 20:01:57Z ACHIEVO\zony.rao $
 *
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2012-12-13		zony.rao		Initial.
 *
 * </pre>
 */
public class CapService
{

	public ConfigBase cb = new ConfigBase("dictionary");

	private Log LOGGER = LogFactory.getLog(CapService.class);;

	private CapServiceCommon csc = CapServiceCommon.getInstance();

	private Map<String, String> countrys = null;

	public static void main(String[] args)
	{
		CapService as = new CapService();
		as.doService(args);
	}

	public void doService(String[] args)
	{
		LOGGER.info("start run import cap service");
		LOGGER.info("The current version is " + cb.get(CapServiceCommon.VERSION));
		RegulatorFacilitySubmittals cers = null;
		try
		{
			cers = csc.getData(args);
		}
		catch(Exception e)
		{
			csc.logError(e, "Failed to query from CERS because " + e.toString());
		}
		
		if ( cers != null ) {
			syncFromCers2AA(cers);
		}
		
		LOGGER.info("End run import cap service");
		csc.printSum();
		csc.sendMail();
	}
	
	private void syncFromCers2AA(RegulatorFacilitySubmittals cers) {
		try {
			if (cers.getFacilitySubmittal().isEmpty())
			{
				LOGGER.info("CERS: empty list of facility submital.");
			}
			else
			{
				LOGGER.info("CERS: get " + count(cers) + " facility submital.");
				LOGGER.info("AA: start get ASI template");
				// prepare ASI configuration
				try
				{
					for (int i = 0; i < csc.types.length; i++)
					{
						List<AdditionalInformation> additionInfos = CapUtil.getAdditionalInfoByType(csc.types[i]);
						csc.addtion.put(csc.types[i], additionInfos);
					}
				}
				catch (Exception ex)
				{
					csc.logError(ex, "Failed to get asi templates from AA.");
					throw new Exception("Failed to get asi templates from AA.");
				}
				LOGGER.info("AA: end get ASI template");

				try {
					countrys = CapUtil.getShortCountry();	// prepare configuration
				}catch(Exception ex) {
					csc.logError(ex, ex.toString());
					throw new Exception("Failed to prepare country list from AA.");
				}
				
				runServices(cers);
			}
		}
		catch (Exception e)
		{
			csc.logError(e, "Failed to sync data from CERS to AA.");
		}
	}

	public long count(RegulatorFacilitySubmittals cers)
	{
		long num = 0;
		List<RegulatorFacilitySubmittals.FacilitySubmittal> facilitySubmittalTypes = cers.getFacilitySubmittal();
		int len = facilitySubmittalTypes.size();

		for (int index = 0; index < len; index++)
		{
			FacilitySubmittalType facilitySubmittalType = facilitySubmittalTypes.get(index);
			csc.addFacility(facilitySubmittalType.getCERSID(), facilitySubmittalType.getFacilityRegulatorKey());
			num++;
		}
		return num;
	}

	/**
	 * Run services.
	 *
	 * @param cers the cers
	 */
	public void runServices(RegulatorFacilitySubmittals cers)
	{
		List<RegulatorFacilitySubmittals.FacilitySubmittal> facilitySubmittalTypes = cers.getFacilitySubmittal();
		int len = facilitySubmittalTypes.size();
		
		String strDataSetDateTime="";
		if (cers.getDataSetDateTime()!= null)
		{
			strDataSetDateTime=cers.getDataSetDateTime().toString();
		}
		for (int index = len-1; index >=0; index--)
		{
			FacilitySubmittalType facilitySubmittalType = facilitySubmittalTypes.get(index);
			// TOFIX facility info vs. inventory are separate submittals independently; facility info not accepted still need to handle inventory, UST...
			if (facilitySubmittalType.getFacilityInformation() != null
					&& facilitySubmittalType.getFacilityInformation().getSubmittalElementHeader() != null)
			{
					doInsertOrUpdate(facilitySubmittalType,strDataSetDateTime);
			}
		}

	}

	/**
	 *
	 * reject child asit from all asit.
	 *
	 * @param laigs
	 */

	public void rejectChildRecordGroup(List<AdditionalInformationGroup> laigs)
	{
		// UST REGL STAT & MONITORING ALT
		AdditionalInformationGroup aigc = csc.getAsitAIG(laigs, "DEH_HUPF_T27", "CERS - CHEMICAL INVENTORY");

		AdditionalInformationGroup aigw = csc.getAsitAIG(laigs, "DEH_HUPF_T27", "CERS - MED/HAZ WASTE");

		AdditionalInformationGroup aigu = csc.getAsitAIG(laigs, "DEH_HUPF_T27", "CERS - UST INFORMATION");
		csc.laig.clear();
		// laigs.remove(aigc);
		csc.laig.put(csc.types[1], aigc);
		// laigs.remove(aigw);
		csc.laig.put(csc.types[3], aigw);
		// laigs.remove(aigu);
		csc.laig.put(csc.types[2], aigu);

	}

	/**
     *
     */

	/**
	 * Do insert or update.
	 *
	 * @param facilitySubmittalType the facility submittal type
	 *
	 * @return true, if successful
	 *
	 * @throws Exception the exception
	 */
	private void doInsertOrUpdate(FacilitySubmittalType facilitySubmittalType, String strDataSetDateTime)
	{
		String facilityRegulatorKey = facilitySubmittalType.getFacilityRegulatorKey();
		int cersid = facilitySubmittalType.getCERSID();

		boolean facilityStatusFlag = CapUtil.getStatusFlag(facilitySubmittalType, CapUtil.FACILITY_STATUS);
		boolean chemicalStatusFlag = CapUtil.getStatusFlag(facilitySubmittalType, CapUtil.CHEMICAL_STATUS);
		boolean wasteStatusFlag = CapUtil.getStatusFlag(facilitySubmittalType, CapUtil.WASTE_STATUS);
		boolean ustStatusFlag = CapUtil.getStatusFlag(facilitySubmittalType, CapUtil.UST_STATUS);
		
		// get corresponding parent facility cap from AA
		List<String> capIds = null;
		CAP capBasic = null;
		
		if ( facilityRegulatorKey !=null && facilityRegulatorKey.length() > 0 ) {
			// if facilityRegulatorKey exists, get record by facilityRegulatorKey (AA alt ID of record)
			try
			{
				capBasic = CapUtil.getCapByCapId(facilityRegulatorKey);
				if ( capBasic != null ) {
					capIds = CapUtil.getCapId(capBasic);
				}
				if ( capIds == null ) {
					// AA alt ID of facility record not found
					csc.addCount(csc.types[0] + ".all");
					csc.addFail(csc.types[0] + ".fail", cersid + "");
					csc.logError("Failed to get record by Facility Regulator Key: " + facilityRegulatorKey + ", for CERS " + cersid);
					return;
				}
				
				LOGGER.info("CERS ID [" + cersid + "] == AA Cap ID [" + capIds + "]");
				LOGGER.info("CERS ID [" + cersid + "] == AA Alt ID [" + facilityRegulatorKey+"]");
			}
			catch (Exception e)
			{
				csc.addCount(csc.types[0] + ".all");
				csc.addFail(csc.types[0] + ".fail", cersid + "");
				csc.logError(e, "Failed to get record by Facility Regulator Key: " + facilityRegulatorKey + ", for CERS " + cersid);
				return;
			}
		}
		else {
			try
			{
				// if facilityRegulatorKey not exists, search AA record by CERS ID
				capIds = CapUtil.getCapByCersId("" + cersid);
				LOGGER.info("CERS ID [" + cersid + "] == AA Cap ID [" + capIds + "]");
			}
			catch (Exception e)
			{
				csc.addCount(csc.types[0] + ".all");
				csc.addFail(csc.types[0] + ".fail", cersid + "");
				csc.logError(e, "Failed to get record by CERS ID: " + cersid);
				return;
			}
			
			if ( capIds != null && capIds.size() > 0 ) {
				try {
					capBasic = CapUtil.getCapByCapIds(capIds);
					LOGGER.info("CERS ID [" + cersid + "] == AA Alt ID [" + capBasic.getIdentifierDisplay() +"]");
				} catch (Exception e) {
					csc.addCount(csc.types[0] + ".all");
					csc.addFail(csc.types[0] + ".fail", cersid + "");
					csc.logError(e, "Failed to get record by CERS ID: " + cersid);
					return;
				}
			}
			//When failed to get record by CERS ID, it should create one new record.
//			else {
//				csc.addCount(csc.types[0] + ".all");
//				csc.addFail(csc.types[0] + ".fail", cersid + "");
//				csc.logError("Failed to get record by CERS ID: " + cersid);
//				return;
//			}
		}
		
		try
		{
			if (capBasic!=null)
			{
				csc.setFacilityAltId(cersid, capBasic.getIdentifierDisplay());
				
				// 1) Get child caps (historical)of parent facility cap
				List<String> childCaps4Del = csc.getChildCaps4Deleting(capIds, chemicalStatusFlag, wasteStatusFlag,
					ustStatusFlag);
				
				// 6/4 feedback from COSD: CERS should not be deleting any documents from either AA or Documentum
				// 2) Get documents (historical)of parent facility cap 
				// List<String> docIDsList4Del = csc.getDocumentIDs4Deleting(capIds);
				
				doUpateCap(capBasic, facilitySubmittalType, strDataSetDateTime, childCaps4Del, null);
			}
			else
			{
				// create cap.
				if(facilityStatusFlag)
				{
					doCreateCap(facilitySubmittalType,strDataSetDateTime);
				}
			}
		}
		catch (Exception e)
		{
			csc.addCount(csc.types[0] + ".all");
			csc.addFail(csc.types[0] + ".fail", cersid + "");
			csc.logError(e, "Failed to syn record for cersid [" + cersid + "]");
		}
	}
	
	

	/**
	 * Do update cap.
	 *
	 * @param capIds the cap ids
	 * @param facilitySubmittalType the facility submittal type
	 *
	 * @return true, if successful
	 * @throws Exception 
	 *
	 * @throws Exception the exception
	 */
	private void doUpateCap(CAP capBasic, FacilitySubmittalType facilitySubmittalType,
			String strDataSetDateTime, List<String> childCaps4Del, List<String> docIDsList4Del) throws Exception
	{
		
		List<String> capIds = CapUtil.getCapId(capBasic);
		CAPId capId = csc.getCapId(capIds);
		
		// 2) update parent facility cap with detail, contact, address
		UpdateCAP updateCAP = ConvertHelper.updateCAPModel(csc.addtion.get(csc.types[0]), facilitySubmittalType,
			strDataSetDateTime,capId, countrys, capBasic);
		
		LOGGER.info("start update record : " + capId);
		capId.setIdentifierDisplay(capBasic.getIdentifierDisplay());
		//3)	Create child caps (new) then 4)	Update parent facility cap with detail.
		sendChildCapRela(capId, facilitySubmittalType, updateCAP, false);
		LOGGER.info("end update record " + capId);
		
		try {
			//5)	Delete child caps (historical)
			csc.deleteChildCap(childCaps4Del);
		}catch(Exception e) {
			// alert on error, but not let it break the syncing process
			csc.logError(e, "Failed to delete historical child records of " + capBasic.getIdentifierDisplay());
		}
		
		/*// 6/4 feedback from COSD: CERS should not be deleting any documents from either AA or Documentum
		try {
			//6)	Delete documents (historical)
			csc.deleteDocuments(capIds.get(0) + "-" + capIds.get(1) + "-" + capIds.get(2), docIDsList4Del);
		}catch(Exception e) {
			// alert on error, but not let it break the syncing process
			csc.logError(e, "Failed to delete historical documents of " + capBasic.getIdentifierDisplay());
		}*/
		
		//7)	Create documents (new)
		createDocuments(capId, facilitySubmittalType, updateCAP);
	}

	private void sendChildCapRela(CAPId capId, FacilitySubmittalType facilitySubmittalType, UpdateCAP updateCap,
			boolean isRelation)
	{ //
		// TODO REJECT ASIT INCLUDE RECORD ID
		try
		{
			rejectChildRecordGroup(updateCap.getAdditionalInformation().getAdditionalInformationGroup());
			// do child send
			SubCapService scs = new SubCapService();
			csc.cAPRelations.getCAPRelation().clear();
			scs.doFacilityOther(capId, facilitySubmittalType);

			if (csc.cAPRelations.getCAPRelation().size() != 0)
			{
				updateCap.setCAPRelations(csc.cAPRelations);
			}
			//Eric for if have attachment, then Yes, else then blank
			Long all = CapServiceCommon.count.get("document.all") == null ? 0L : CapServiceCommon.count.get("document.all");
			if (all>0 && updateCap.getAdditionalInformation()!=null)
			{

				if (updateCap.getAdditionalInformation().getAdditionalInformationGroup() != null
						&& updateCap.getAdditionalInformation().getAdditionalInformationGroup().size() > 0)
				{
					for (AdditionalInformationGroup asiGroup : updateCap.getAdditionalInformation()
							.getAdditionalInformationGroup())
					{

						if (asiGroup != null
								&& asiGroup.isAddRemoveSubGroups()
								&& asiGroup.getAdditionalInformationSubGroup() != null
								&& asiGroup.getAdditionalInformationSubGroup().size() > 0
								&& asiGroup.getKeys() != null && asiGroup.getKeys().getKey() != null
								&& asiGroup.getKeys().getKey().size()>1
								&& "DEH_HUPF_T27".equals(asiGroup.getKeys().getKey().get(0))
								&& "DATA EXCHANGE DETAILS".equals(asiGroup.getKeys().getKey().get(1)))
						{
							for (AdditionalInformationSubGroup subGroup : asiGroup.getAdditionalInformationSubGroup())
							{
								if (subGroup != null && subGroup.getAdditionalItems() != null
										&& subGroup.getAdditionalItems().getAdditionalItem() != null
										&& subGroup.getAdditionalItems().getAdditionalItem().size() > 0)
								{
									for (AdditionalItem asitItem : subGroup.getAdditionalItems().getAdditionalItem())
									{
										if (asitItem != null && asitItem.getKeys() != null
												&& asitItem.getKeys().getKey() != null
												&& asitItem.getKeys().getKey().size() > 0
												&& "Attachment".equals(asitItem.getKeys().getKey().get(0)))
										{
											asitItem.setValue("Yes");
											break;
										}
									}
								}
							}
						}
					}
				}
			}
			LOGGER.info("start to update parent record " + updateCap.getCAPId() + "'s relation and child Record id :"
					+ csc.cAPRelations);
			if (!CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType.getFacilityInformation()
					.getSubmittalElementHeader().getSubmittalStatus()))
			{
				updateCap.setContacts(null);
				//Update the ASIT regardless the Facility's status.
				//updateCap.setAdditionalInformation(null);
				updateCap.setcAPDetail(null);
				updateCap.setParcelIds(null);
			}
			csc.callGovXMLUpdateCapWithRetry(updateCap, csc.types[0], facilitySubmittalType.getCERSID() + "", null,
				!isRelation);
			// LOGGER.info("end to update relation and childRelation ");
		}
		catch (Exception ex)
		{
			if (isRelation)
			{
				LOGGER.info("fail to update child relation and insert child record :" + capId + " cersid:"
						+ facilitySubmittalType.getCERSID(), ex);
			}
			else
			{
				csc.addCount(csc.types[0] + ".all");
				csc.addFail(csc.types[0] + ".fail", facilitySubmittalType.getCERSID() + "");
				LOGGER.info("fail to update  record :" + capId + " cersid:" + facilitySubmittalType.getCERSID(), ex);
			}
		}
	}

	
	private void createDocuments(CAPId capId, FacilitySubmittalType facilitySubmittalType, UpdateCAP updateCAP)
	{
		try
		{
			// do document send
			DocumentService ds = new DocumentService();
			ds.setCersid(facilitySubmittalType.getCERSID() + "");
			ds.sendDocument(facilitySubmittalType, updateCAP.getSystem(), capId.getKeys().get(0));
		}
		catch (Exception ex)
		{
			LOGGER.info("fail to create documents :" + capId + " cersid:" + facilitySubmittalType.getCERSID(), ex);
		}
	}
	
	
	/**
	 * Do create cap.
	 *
	 * @param facilitySubmittalType the facility submittal type
	 *
	 * @return true, if successful
	 *
	 * @throws Exception the exception
	 */
	private void doCreateCap(FacilitySubmittalType facilitySubmittalType,String strDataSetDateTime)
	{
		LOGGER.info("AA: start create cap ");
		List<AdditionalInformation> additionInfos = csc.addtion.get(csc.types[0]);
		InitiateCAP cap = ConvertHelper.convertToCAP(additionInfos, facilitySubmittalType, strDataSetDateTime,countrys);
		GovXML response = csc.callGovXMLCreateCapWithRetry(cap, csc.types[0], facilitySubmittalType.getCERSID() + "", facilitySubmittalType.getCERSID() + "");
		if (response != null)
		{
			CAPId capIds = response.getInitiateCAPResponse().get(0).getCAPId().get(0);
			LOGGER.info("end to get cap by goxml with capIds" + capIds);
			
			csc.setFacilityAltId(facilitySubmittalType.getCERSID(), capIds.getIdentifierDisplay());
			
			UpdateCAP updateCAP = ConvertHelper.updateCAPModel(csc.addtion.get(csc.types[0]), facilitySubmittalType,
				strDataSetDateTime,capIds ,countrys);
			//Clean the CAP detail in order to the event ApplicationDetailUpdateBefore is not triggered.
			updateCAP.setcAPDetail(null); 

			try
			{
				//Set status between InitializeCAP and UpateCAP when new facility parent record created.
				CAP capBasic = CapUtil.getCapByCapId4Status(capIds);
				if(capBasic != null)
				{
					updateCAP.setStatus(capBasic.getStatus());
				}
			}
			catch (Exception e)
			{
				LOGGER.info("Fail to get CAP status when new facility parent record created " + capIds);
			}
			LOGGER.info("start update cap " + capIds);
			sendChildCapRela(capIds, facilitySubmittalType, updateCAP, true);
			createDocuments(capIds, facilitySubmittalType, updateCAP);
			LOGGER.info("end update cap " + capIds);

		}
		else
		{
			LOGGER.warn("AA: no resopnse when create cap ");
		}
		LOGGER.info("AA: end create cap ");
	}
}

/*
 * $Log: av-env.bat,v $
 */
