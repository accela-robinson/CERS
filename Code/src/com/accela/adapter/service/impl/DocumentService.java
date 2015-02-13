package com.accela.adapter.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.accela.adapter.constants.AdapterConstants;
import com.accela.adapter.model.common.Keys;
import com.accela.adapter.model.common.System;
import com.accela.adapter.model.common.Type;
import com.accela.adapter.model.document.CreateDocument;
import com.accela.adapter.model.document.CreateDocumentResponse;
import com.accela.adapter.model.document.Document;
import com.accela.adapter.model.document.DocumentLocators;
import com.accela.adapter.model.document.EDMSAdapter;
import com.accela.adapter.model.document.ElectronicFileLocator;
import com.accela.adapter.model.document.ObjectId;
import com.accela.adapter.model.function.GovXML;
import com.accela.adapter.util.CapUtil;
import com.accela.cers.cap.model.DocumentAttachmentType;
import com.accela.cers.cap.model.DocumentType;
import com.accela.cers.cap.model.DocumentType.Attachments;
import com.accela.cers.cap.model.EmergencyResponseContingencyPlanType;
import com.accela.cers.cap.model.EmergencyResponseContingencyPlansType;
import com.accela.cers.cap.model.EmergencyResponseTrainingPlansType;
import com.accela.cers.cap.model.EmployeeTrainingPlanType;
import com.accela.cers.cap.model.EmployeeTrainingPlansType;
import com.accela.cers.cap.model.FacilityInformationType;
import com.accela.cers.cap.model.FacilitySubmittalType;
import com.accela.cers.cap.model.FacilitySubmittalType.HazardousMaterialsInventory;
import com.accela.cers.cap.model.FacilitySubmittalType.OnsiteHazardousWasteTreatmentNotification;
import com.accela.cers.cap.model.FacilitySubmittalType.UndergroundStorageTanks;
import com.accela.cers.cap.model.AbovegroundPetroleumStorageTanksType;
import com.accela.cers.cap.model.HWFacilityType;
import com.accela.cers.cap.model.HWFinancialAssuranceClosureMechanismType;
import com.accela.cers.cap.model.HWFinancialAssuranceClosureMechanismsType;
import com.accela.cers.cap.model.HWPlotPlanType;
import com.accela.cers.cap.model.HWPlotPlansType;
import com.accela.cers.cap.model.HWTankClosureCertificationType;
import com.accela.cers.cap.model.HWTankClosureType;
import com.accela.cers.cap.model.HWTankClosuresType;
import com.accela.cers.cap.model.HWUnitPBRNotificationOfLocalAgenciesType;
import com.accela.cers.cap.model.HWUnitPBRNotificationOfLocalAgencyType;
import com.accela.cers.cap.model.HWUnitPBRNotificationOfPropertyOwnerType;
import com.accela.cers.cap.model.HWUnitPBRNotificationOfPropertyOwnersType;
import com.accela.cers.cap.model.HWUnitPBRTankAndContainerCertificationType;
import com.accela.cers.cap.model.HWUnitPBRTankAndContainerCertificationsType;
import com.accela.cers.cap.model.HWUnitPriorEnforcementHistoriesType;
import com.accela.cers.cap.model.HWUnitPriorEnforcementHistoryType;
import com.accela.cers.cap.model.HWWrittenEstimateOfClosureCostType;
import com.accela.cers.cap.model.HWWrittenEstimateOfClosureCostsType;
import com.accela.cers.cap.model.RecyclableMaterialsReportType;
import com.accela.cers.cap.model.RemoteWasteConsolidationsAnnualNotificationType;
import com.accela.cers.cap.model.SiteMapType;
import com.accela.cers.cap.model.StatementOfDesignatedOperatorUnderstandingOfComplianceDocumentsType;
import com.accela.cers.cap.model.USTCertificationOfFinancialResponsibilityDocumentsType;
import com.accela.cers.cap.model.USTLetterFromCFODocumentsType;
import com.accela.cers.cap.model.USTMonitoringSitePlanDocumentsType;
import com.accela.cers.cap.model.USTResponsePlanDocumentsType;
import com.accela.cers.cap.model.USTWrittenAgreementOwnerOperatorDocumentsType;
import com.accela.util.AVProperties;

/**
 * <pre>
 *
 *  Accela Automation
 *  File: SubCapService.java
 *
 *  Accela, Inc.
 *  Copyright (C): 2012
 *
 *  Description:
 *
 *
 *  Notes:
 * 	$Id: SubCapService.java 72642 2009-01-01 20:01:57Z ACHIEVO\zony.rao $
 *
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2012-12-5		zony.rao		Initial.
 *
 * </pre>
 */
public class DocumentService
{
	private final Log LOGGER = LogFactory.getLog(DocumentService.class);

	private CapServiceCommon csc = CapServiceCommon.getInstance();

	private String cersid = null;

	/**
	 * @param cersid the cersid to set
	 */
	public void setCersid(String cersid)
	{
		this.cersid = cersid;
	}

	// COSD 7/22: all submittal elements and attached documents should be sent to AA
	// except “Emergency Response/Employee Training and the APSA submittal element(s).
	// COSD 7/23: Miscellaneous State Required Documents & Locally-Required Documentation are being synced to AA for all submittals elements except for Emergency Response/Employee Training and APSA
	public void sendDocument(FacilitySubmittalType facilitySubmittalType, System system, Keys keys)
	{
		// FOR TEST
		if ( Boolean.getBoolean("testing.skipdocument") ) {
			return;
		}

		// Facility Information Locally-Required Document(s)
		FacilityInformationType fit = facilitySubmittalType.getFacilityInformation();
		if (fit != null)
		{
			String status = (fit.getSubmittalElementHeader()==null)? null : fit.getSubmittalElementHeader().getSubmittalStatus();
			if ( CapServiceCommon.SUBMITTAL_STATUS.equals(status) ) {
				DocumentType dt = fit.getFacilityInformationLocallyCollectedDocuments();
				Keys type = new Keys();
				type.getKey().add("DEH-HMD");
				type.getKey().add("DEH-HMD-Inspection");
				sendDocument(system, dt, keys, type);

				dt = fit.getFacilityInformationMiscellaneousStateRequiredDocuments();
				sendDocument(system, dt, keys, type);
			}
		}
		// Hazardous Materials Inventory
		HazardousMaterialsInventory hm = facilitySubmittalType.getHazardousMaterialsInventory();
		if (hm != null && hm.getSiteMaps() != null)
		{
			String status = (hm.getSubmittalElementHeader()==null)? null : hm.getSubmittalElementHeader().getSubmittalStatus();
			if ( CapServiceCommon.SUBMITTAL_STATUS.equals(status) ) {
				//
				Keys type = new Keys();
				type.getKey().add("DEH-HMD");
				type.getKey().add("DEH-HMD-BP-Sitemap-New");
				List<SiteMapType> sitMaps = hm.getSiteMaps().getSiteMap();
				for (SiteMapType sitmap : sitMaps)
				{
					// General Site Map ?
					DocumentType dt = sitmap.getSiteMapDocument();
					sendDocument(system, dt, keys, type);
				}

				// Annotated Site Map not exists.

				type = new Keys();
				type.getKey().add("DEH-HMD");
				type.getKey().add("DEH-HMD-Inspection");
				
				// Locally-Required Document(s)
				DocumentType dt =hm.getHMILocallyCollectedDocuments();
				sendDocument(system, dt, keys, type);

				dt = hm.getHMIMiscellaneousStateRequiredDocuments();
				sendDocument(system, dt, keys, type);
			}
		}

		/**
		// per CERS2 Submittal Document Map to Accela.pdf, does NOT download documents of Emergency Response & Training Plans
		// Emergency Response & Training Plans
		EmergencyResponseTrainingPlansType ertpt = facilitySubmittalType.getEmergencyResponseTrainingPlans();
		if (ertpt != null)
		{
			String status = (ertpt.getSubmittalElementHeader()==null)? null : ertpt.getSubmittalElementHeader().getSubmittalStatus();
			if ( CapServiceCommon.SUBMITTAL_STATUS.equals(status) ) {

				Keys type = new Keys();
				type.getKey().add("DEH-HMD");
				// may be need to repair.
				type.getKey().add("DEH-HMD-BP-Sitemap-New");
				// Emergency Response/Contingency Plan
				EmergencyResponseContingencyPlansType ercp = ertpt.getEmergencyResponseContingencyPlans();
				if (ercp != null)
				{
					List<EmergencyResponseContingencyPlanType> epcpl = ercp.getEmergencyResponseContingencyPlan();
					if (epcpl != null && epcpl.size() != 0)
					{
						for (EmergencyResponseContingencyPlanType ercpt : epcpl)
						{
							DocumentType dt = ercpt.getEmergencyResponseContingencyPlanDocument();
							sendDocument(system, dt, keys, type);
						}
					}
				}
				// Employee Training Plan
				EmployeeTrainingPlansType etpt = ertpt.getEmployeeTrainingPlans();
				if (etpt != null)
				{
					List<EmployeeTrainingPlanType> etptl = etpt.getEmployeeTrainingPlan();
					if (etptl != null && etptl.size() != 0)
					{
						for (EmployeeTrainingPlanType etl : etptl)
						{
							DocumentType dt = etl.getEmployeeTrainingPlanDocument();
							sendDocument(system, dt, keys, type);
						}
					}
				}
				// Locally-Required Document(s)
				DocumentType dt = ertpt.getERTrainingPlanLocallyCollectedDocuments();
				sendDocument(system, dt, keys, type);
			}
		}*/

		UndergroundStorageTanks ustt = facilitySubmittalType.getUndergroundStorageTanks();
		// Underground Storage Tanks
		if (ustt != null)
		{
			String status = (ustt.getSubmittalElementHeader()==null)? null : ustt.getSubmittalElementHeader().getSubmittalStatus();
			if ( CapServiceCommon.SUBMITTAL_STATUS.equals(status) ) {
				Keys type = new Keys();
				type.getKey().add("DEH-HMD");
				type.getKey().add("DEH-HMD-Inspection");
				USTMonitoringSitePlanDocumentsType ustmt = ustt.getUSTMonitoringSitePlanDocuments();
				if (ustmt != null)
				{// UST Monitoring Site Plan
					DocumentType dt = ustmt.getUSTMonitoringSitePlanDocument();
					sendDocument(system, dt, keys, type);

				}
				USTCertificationOfFinancialResponsibilityDocumentsType cfr = ustt
						.getUSTCertificationOfFinancialResponsibilityDocuments();
				if (cfr != null)
				{// UST Certification of Financial Responsibility
					DocumentType dt = cfr.getUSTCertificationOfFinancialResponsibilityDocument();
					sendDocument(system, dt, keys, type);
				}
				USTResponsePlanDocumentsType upd = ustt.getUSTResponsePlanDocuments();
				if (upd != null)
				{// UST Response Plan
					DocumentType dt = upd.getUSTResponsePlanDocument();
					sendDocument(system, dt, keys, type);
				}
				USTWrittenAgreementOwnerOperatorDocumentsType uwaood = ustt.getUSTWrittenAgreementOwnerOperatorDocuments();
				if (uwaood != null)
				{
					// UST Owner and UST Operator: Written Agreement
					DocumentType dt = uwaood.getUSTWrittenAgreementOwnerOperatorDocument();
					sendDocument(system, dt, keys, type);
				}
				USTLetterFromCFODocumentsType ufft = ustt.getUSTLetterFromCFODocuments();
				if (ufft != null)
				{ // UST Letter from the Chief Financial Officer ?
					DocumentType dt = ufft.getUSTLetterFromCFODocument();
					sendDocument(system, dt, keys, type);
				}
				StatementOfDesignatedOperatorUnderstandingOfComplianceDocumentsType udouod = ustt
						.getUSTStatementOfDesignatedOperatorUnderstandingOfComplianceDocuments();
				if (udouod != null)
				{ // Owner Statement of Designated UST Operator Compliance
					DocumentType dt = udouod.getUSTStatementOfDesignatedOperatorUnderstandingOfComplianceDocument();
					sendDocument(system, dt, keys, type);
				}
				// Locally-Required Document(s)
				DocumentType dt = ustt.getUSTLocallyCollectedDocuments();
				sendDocument(system, dt, keys, type);

				dt = ustt.getUSTMiscellaneousStateRequiredDocuments();
				sendDocument(system, dt, keys, type);
			}
		}

		OnsiteHazardousWasteTreatmentNotification ohwtn = facilitySubmittalType
				.getOnsiteHazardousWasteTreatmentNotification();
		if (ohwtn != null)
		{
			String status = (ohwtn.getSubmittalElementHeader()==null)? null : ohwtn.getSubmittalElementHeader().getSubmittalStatus();
			if ( CapServiceCommon.SUBMITTAL_STATUS.equals(status) ) {
				Keys type = new Keys();
				type.getKey().add("DEH-HMD");
				type.getKey().add("DEH-HMD-Waste Treatment");

				// Locally-Required Document(s)
				DocumentType dt = ohwtn.getHWLocallyCollectedDocuments();
				sendDocument(system, dt, keys, type);

				dt = ohwtn.getHWMiscellaneousStateRequiredDocuments();
				sendDocument(system, dt, keys, type);

				HWFacilityType hwf = ohwtn.getHWFacility();
				if (hwf != null)
				{

					HWUnitPriorEnforcementHistoriesType hwpeht = hwf.getHWUnitPriorEnforcementHistories();
					if (hwpeht != null)
					{
						List<HWUnitPriorEnforcementHistoryType> lhpeh = hwpeht.getHWUnitPriorEnforcementHistory();
						if (lhpeh != null && lhpeh.size() != 0)
						{
							for (HWUnitPriorEnforcementHistoryType hpeh : lhpeh)
							{// Tiered Permitting Unit: Prior Enforcement History
								dt = hpeh.getHWPriorEnforcementHistoryDocument();
								sendDocument(system, dt, keys, type);
							}
						}

					}
					HWUnitPBRTankAndContainerCertificationsType hwpacc = hwf.getHWUnitPBRTankAndContainerCertifications();
					if (hwpacc != null)
					{
						List<HWUnitPBRTankAndContainerCertificationType> lhwcc = hwpacc
								.getHWPBRTankAndContainerCertification();
						if (lhwcc != null && lhwcc.size() != 0)
						{
							for (HWUnitPBRTankAndContainerCertificationType hwcc : lhwcc)
							{// Tiered Permitting Unit: Tank and Container Certification
								dt = hwcc.getHWPBRTankAndContainerCertificationDocument();
								sendDocument(system, dt, keys, type);
							}
						}
					}
					HWUnitPBRNotificationOfLocalAgenciesType hwpoat = hwf.getHWUnitPBRNotificationOfLocalAgencies();
					if (hwpoat != null)
					{
						List<HWUnitPBRNotificationOfLocalAgencyType> lhwpoa = hwpoat.getHWPBRNotificationOfLocalAgency();
						if (lhwpoa != null && lhwpoa.size() != 0)
						{
							for (HWUnitPBRNotificationOfLocalAgencyType hwcc : lhwpoa)
							{// Tiered Permitting Unit: Notification of Local Agency or Agencies
								dt = hwcc.getHWPBRNotificationOfLocalAgencyDocument();
								sendDocument(system, dt, keys, type);
							}
						}
					}
					HWUnitPBRNotificationOfPropertyOwnersType hwpoot = hwf.getHWUnitPBRNotificationOfPropertyOwners();
					if (hwpoot != null)
					{
						List<HWUnitPBRNotificationOfPropertyOwnerType> lhwpt = hwpoot.getHWPBRNotificationOfPropertyOwner();
						if (lhwpt != null && lhwpt.size() != 0)
						{
							for (HWUnitPBRNotificationOfPropertyOwnerType hwpt : lhwpt)
							{ // Tiered Permitting Unit: Notification of Property Owner
								dt = hwpt.getHWPBRNotificationOfPropertyOwnerDocument();
								sendDocument(system, dt, keys, type);
							}
						}
					}

					HWWrittenEstimateOfClosureCostsType heoc = hwf.getHWWrittenEstimateOfClosureCosts();
					if (heoc != null)
					{
						List<HWWrittenEstimateOfClosureCostType> lhweoc = heoc.getHWWrittenEstimateOfClosureCost();
						if (lhweoc != null && lhweoc.size() != 0)
						{
							for (HWWrittenEstimateOfClosureCostType hweoc : lhweoc)
							{ // Onsite Hazardous Waste Treatment: Written Estimate of Closure Costs
								dt = hweoc.getHWWrittenEstimateOfClosureCostsDocument();
								sendDocument(system, dt, keys, type);
							}
						}
					}
					HWFinancialAssuranceClosureMechanismsType hwcmt = hwf.getHWFinancialAssuranceClosureMechanisms();
					if (hwcmt != null)
					{
						List<HWFinancialAssuranceClosureMechanismType> lhweoc = hwcmt
								.getHWFinancialAssuranceClosureMechanism();
						if (lhweoc != null && lhweoc.size() != 0)
						{
							for (HWFinancialAssuranceClosureMechanismType hweoc : lhweoc)
							{// Financial Assurance Closure Mechanism
								dt = hweoc.getHWFinancialAssuranceClosureMechanismDocument();
								sendDocument(system, dt, keys, type);
							}
						}
					}
					HWPlotPlansType hwspt = hwf.getHWPlotPlans();
					if (hwspt != null)
					{
						List<HWPlotPlanType> lhwpt = hwspt.getHWPlotPlan();
						if (lhwpt != null && lhwpt.size() != 0)
						{
							for (HWPlotPlanType hwpt : lhwpt)
							{ // Onsite Hazardous Waste Treatment Plot Plan/Map
								dt = hwpt.getHWPlotPlanDocument();
								sendDocument(system, dt, keys, type);
							}
						}
					}
				}
			}
		}
		// Recyclable Materials Report ?
		RecyclableMaterialsReportType fmrt = facilitySubmittalType.getRecyclableMaterialsReport();
		if (fmrt != null)
		{
			String status = (fmrt.getSubmittalElementHeader()==null)? null : fmrt.getSubmittalElementHeader().getSubmittalStatus();
			if ( CapServiceCommon.SUBMITTAL_STATUS.equals(status) ) {
				Keys type = new Keys();
				type.getKey().add("DEH-HMD");
				type.getKey().add("DEH-HMD-Inspection");
				// Recyclable Materials: Documentation of Known Market ?
				DocumentType dt = fmrt.getRMRDocument();
				sendDocument(system, dt, keys, type);
				// Locally-Required Document(s)
				dt = fmrt.getRMRLocallyCollectedDocuments();
				sendDocument(system, dt, keys, type);

				dt = fmrt.getRMRMiscellaneousStateRequiredDocuments();
				sendDocument(system, dt, keys, type);
			}
		}

		// Remote Waste Consolidation Annual Notification ?
		RemoteWasteConsolidationsAnnualNotificationType rwcan = facilitySubmittalType
				.getRemoteWasteConsolidationsAnnualNotification();
		if (rwcan != null)
		{
			String status = (rwcan.getSubmittalElementHeader()==null)? null : rwcan.getSubmittalElementHeader().getSubmittalStatus();
			if ( CapServiceCommon.SUBMITTAL_STATUS.equals(status) ) {
				Keys type = new Keys();
				type.getKey().add("DEH-HMD");
				type.getKey().add("DEH-HMD-Inspection");
				// Locally-Required Document(s)
				DocumentType dt = rwcan.getRWLocallyCollectedDocuments();
				sendDocument(system, dt, keys, type);

				dt = rwcan.getRWMiscellaneousStateRequiredDocuments();
				sendDocument(system, dt, keys, type);
			}

		}

		// Hazardous Waste Tank Closure Certification ?
		HWTankClosureCertificationType hwcct = facilitySubmittalType.getHWTankClosureCertification();
		if (hwcct != null)
		{
			String status = (hwcct.getSubmittalElementHeader()==null)? null : hwcct.getSubmittalElementHeader().getSubmittalStatus();
			if ( CapServiceCommon.SUBMITTAL_STATUS.equals(status) ) {
				Keys type = new Keys();
				type.getKey().add("DEH-HMD");
				type.getKey().add("DEH-HMD-Inspection");
				// Hazardous Waste Tank Closure Certification [implemented as document, not a UPCF] ?
				HWTankClosuresType hwcts = hwcct.getHWTankClosures();
				if (hwcts != null)
				{
					List<HWTankClosureType> hwctl = hwcts.getHWTankClosure();
					for (HWTankClosureType hwct : hwctl)
					{
						DocumentType dt = hwct.getDocument();
						sendDocument(system, dt, keys, type);
					}
				}
				// Locally-Required Document(s)
				DocumentType dt = hwcct.getHWTankClosureLocallyCollectedDocuments();
				sendDocument(system, dt, keys, type);

				dt = hwcct.getHWTankClosureMiscellaneousStateRequiredDocuments();
				sendDocument(system, dt, keys, type);
			}
		}

		// Aboveground Petroleum Storage Tanks ?
		/*// 6/4 feedback from COSD: HMD would prefer to not pull down ANY documents from the APSA submittal element
		AbovegroundPetroleumStorageTanksType apstt = facilitySubmittalType.getAbovegroundPetroleumStorageTanks();
		if (apstt != null)
		{
			String status = (apstt.getSubmittalElementHeader()==null)? null : apstt.getSubmittalElementHeader().getSubmittalStatus();
			if ( CapServiceCommon.SUBMITTAL_STATUS.equals(status) ) {
				Keys type = new Keys();
				type.getKey().add("DEH-HMD");
				type.getKey().add("DEH-HMD-Inspection");
				DocumentType dt = apstt.getAPSALocallyCollectedDocuments();
				sendDocument(system, dt, keys, type);

				dt = apstt.getAPSADocument();
				sendDocument(system, dt, keys, type);

				dt = apstt.getAPSAMiscellaneousStateRequiredDocuments();
				sendDocument(system, dt, keys, type);
			}
		}
		*/
		// California Accidental Release Program ? not exists

	}

	private void sendDocument(System system, DocumentType dt, Keys keys, Keys type)
	{
		if (dt != null)
		{
			Attachments atms = dt.getAttachments();
			if (atms != null)
			{
				List<DocumentAttachmentType> dats = atms.getAttachment();
				if (dats != null && dats.size() != 0)
				{
					for (DocumentAttachmentType dat : dats)
					{
						if (dat != null)
						{
							sendDocument(system, dat, keys, type);
						}
					}
				}
			}
		}

	}

	private boolean sendDocument(System system, DocumentAttachmentType attType, Keys keys, Keys type)
	{

		boolean isok = false;

		int reTry = AVProperties.getIntProperty("cers.facility.reTry");
		csc.addCount("document.all");

		String errorMsg = null;
		String docCont = null;
		for (int i = 0; i < reTry + 1; i++)
		{
			String uniqueKey = attType.getCERSUniqueKey();
			String requestURL = AVProperties.getProperty(AdapterConstants.CERS_SERVER)
					+ "/Regulator/FacilitySubmittal/Query/Document/" + uniqueKey;
			LOGGER.info("CERS: start download url:\r\n" + requestURL);

			try
			{
				docCont = CapUtil.downloadDocument(requestURL);
				break;
			}
			catch (Exception e)
			{
				errorMsg = "Download document fail caused by: " + e.toString();
				continue;
			}
		}
		for (int i = 0; i < reTry + 1&&docCont!=null; i++)
		{
			GovXML govXML = null;
			GovXML response = null;
			CreateDocumentResponse cdr = null;
			try
			{
				LOGGER.info("begin to request document.");
				govXML = createDocument(system, attType, keys, type, docCont);
				response = HttpPostService.doPostGovmxl(govXML,true);
				cdr = response.getCreateDocumentResponse();
				Object[] id = cdr.getDocumentId().getKeys().getKey().toArray();

				csc.addCount("document.success");
				LOGGER.info("Successed to sync docuemnt from CERS to AA. document key:" + attType.getCERSUniqueKey()
						+ " document name: "+attType.getAttachmentFileName()+" document recordId :" + Arrays.toString(id));
				isok = true;
				// CapUtil.logInfo(govXML, response);
				return isok;
			}
			catch (Exception e)
			{
				if (cdr != null && cdr.getSystem() != null && cdr.getSystem().getError() != null){
					errorMsg = cdr.getSystem().getError().getErrorMessage();
				}else{
					errorMsg= e.getCause().toString();
				}
			//	CapUtil.logInfo(null, response);
				continue;
			}
		}

		/*
		// do not send alert email for individual error but altogether at the end
		// LOGGER.info(e+e.getMessage());
		Date now = new Date();
		String message = MessageFormat.format(cb.get("av.mail.message.document"), now, errorMsg);

		try
		{
			EmailUtil.sendEmail(AVProperties.getProperty(CapServiceCommon.AV_MAIL_FROM),
				AVProperties.getProperty(CapServiceCommon.AV_MAIL_TO), "",
				cb.get(CapServiceCommon.AV_MAIL_SUBJECT_IMPORT), message, null);
		}
		catch (Exception e)
		{
			LOGGER.error("Send mail failed.", e);
		}*/

		csc.addFail("document.fail", cersid + "." + attType.getCERSUniqueKey());
		csc.logError("Failed to sync document, key=" + cersid + "." + attType.getCERSUniqueKey() + ", because " + errorMsg);
		LOGGER.info("Failed to sync document from CERS to AA. domuement key:" + attType.getCERSUniqueKey()+ " document name: "+attType.getAttachmentFileName());
		return isok;

	}

	private GovXML createDocument(System system, DocumentAttachmentType attType, Keys keys, Keys type, String doc)
	{
		String uniqueKey = attType.getCERSUniqueKey();
		if (uniqueKey != null && !"".equals(uniqueKey))
		{

			Document dc = new Document();
			dc.setContent(doc);
			dc.setContextType("text/plain");
			dc.setAutodownload("True");
			Type ty = new Type();
			ty.setKeys(type);
			dc.setType(ty);
			dc.setDescription("");
			DocumentLocators dl = new DocumentLocators();
			dc.setDocumentLocators(dl);
			ElectronicFileLocator efl = new ElectronicFileLocator();
			dl.setElectronicFileLocator(efl);
			efl.setFileName(attType.getAttachmentFileName());
			CreateDocument cd = new CreateDocument();
			cd.setDocument(dc);
			cd.setSystem(system);
			ObjectId objId = new ObjectId();
			objId.setKeys(keys);
			objId.setContextType("CAP");
			cd.setObjectId(objId);
			if (attType.getAttachmentFileName() != null)
			{
				String[] fileNames = attType.getAttachmentFileName().split("\\\\");
				if (fileNames != null && fileNames.length > 0)
				{
					efl.setFileName(fileNames[fileNames.length - 1]);
				}
			}
			if ("true".equals(AVProperties.getProperty("aa.edmsset")))
			{
				EDMSAdapter edmsa = new EDMSAdapter();
				String edmsname = AVProperties.getProperty("aa.edmsname");
				if ( edmsname != null ) {	// if not set, not add empty Keys which cause NullPointerException in GovXML
					Keys kys = new Keys();
					kys.getKey().add(edmsname);
					edmsa.setKeys(kys);
					edmsa.setIdentifierDisplay(edmsname);
				}
				String username = AVProperties.getProperty("aa.edmsusername");
				String password = AVProperties.getProperty("aa.edmspassword");
				if (username == null || "".equals(username.trim()) || password == null || "".equals(password.trim()))
				{
					edmsa.setRequiresPassword(false);
				}
				else
				{
					edmsa.setUsername(username);
					edmsa.setPassword(password);
					edmsa.setRequiresPassword(true);
				}
				edmsa.setDefault(true);
				cd.setEDMSAdapter(edmsa);
			}
			GovXML govXML = new GovXML();
			govXML.setCreateDocument(cd);
			return govXML;
		}
		return null;
	}

}

/*
 * $Log: av-env.bat,v $
 */