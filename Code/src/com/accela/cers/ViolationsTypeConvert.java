package com.accela.cers;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.accela.adapter.constants.AdapterConstants;
import com.accela.adapter.model.common.AdditionalInformationGroup;
import com.accela.adapter.model.common.AdditionalInformationSubGroup;
import com.accela.adapter.model.common.AdditionalItem;
import com.accela.adapter.model.inspection.Guideitem;
import com.accela.adapter.model.inspection.Inspection;
import com.accela.adapter.util.InspectionUtil;
import com.accela.cers.inspection.model.ViolationType;
import com.accela.cers.inspection.model.ViolationsType;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ViolationsTypeConvert.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2012-2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ViolationsTypeConvert.java 72642 2009-01-01 20:01:57Z ACHIEVO\winchill.chen $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2012-12-1		winchill.chen		Initial.
 * 
 * </pre>
 */
public class ViolationsTypeConvert
{
	private static final Log logger = LogFactory.getLog(ViolationsTypeConvert.class);

	/**
	 * 
	 * ConvertASI/ASIT to Violation Type.
	 * 
	 * @param inspection the inspection information.
	 * @param inspectionType the inspection type.
	 * @param guideitem the guidesheet item.
	 * @return ViolationType
	 */
	public static void convertAdditionalToViolationType(Inspection inspection, String inspectionType,
			Guideitem guideitem, String inspectionKey, ViolationsType violationsType)
	{ // 1.0 Set violation Type.
		if (guideitem.getStatus() != null && guideitem.getStatus().getKeys() != null
				&& guideitem.getStatus().getKeys().getKey() != null
				&& guideitem.getStatus().getKeys().getKey().size() > 0
				// Update
				&& ("Violation".equalsIgnoreCase(guideitem.getStatus().getKeys().getKey().get(0))
					|| "Delete".equalsIgnoreCase(guideitem.getStatus().getKeys().getKey().get(0))))
		{
			boolean isApproveStatus = true;
			if(inspection.getInspectionStatus() != null && AdapterConstants.INSPECTION_STATUS_DELETE.equals(inspection.getInspectionStatus().getValue()))
			{
				isApproveStatus = false;
			}
			else if("Delete".equalsIgnoreCase(guideitem.getStatus().getKeys().getKey().get(0)))
			{
				isApproveStatus = false;
				logger.info("Violation Status: Delete");
			}

			// 3.0 Set class, scheduled RTC Date, Actual Date, Actual Qualifier.
			for (AdditionalInformationGroup group : guideitem.getAdditionalInformation()
					.getAdditionalInformationGroup())
			{
				String groupkey = DateConvertUtil.getKeyFromKeys(group.getKeys());
				String inspectionDateString = inspection.getInspectionStatus()==null ? "" : inspection.getInspectionStatus().getDate();
				XMLGregorianCalendar inspectionDate = DateConvertUtil.date2Gregorian(inspectionDateString);

				List<AdditionalInformationSubGroup> additionalInformationSubGroup = group
						.getAdditionalInformationSubGroup();
				if (additionalInformationSubGroup != null && additionalInformationSubGroup.size() > 0)
				{
					// 3.1.0 Convert ASIT.
					if (group.isAddRemoveSubGroups())
					{
						// 3.1.0.0 convert the violation which the ASIT gourp is HMD_RVIO_5.
						if ("HMD_RVIO_5".equalsIgnoreCase(groupkey))
						{
							setAdditionalToViolation(additionalInformationSubGroup, "UNDERGROUND STORAGE TANK", true,
								inspectionType, guideitem.getDescription(), inspectionKey, inspectionDate,
								guideitem.getText(), violationsType, groupkey, true, isApproveStatus);
						}
						else if ("HMD_RVIO_6".equalsIgnoreCase(groupkey))
						{// 3.1.0.1 convert the violation which the ASIT gourp is HMD_RVIO_6.
							//Fixed by Eric Liu 01/28/2013
							//setAdditionalToViolation(additionalInformationSubGroup,
							//	"UNDERGROUND TIERED PERMIT TREATMENT SPEC TANK", true, inspectionType, guideitem
							//			.getDescription(), inspectionKey, inspection.getInspectionDate(), guideitem
							//			.getText(), violationsType, groupkey, true);
							setAdditionalToViolation(additionalInformationSubGroup,
									"TIERED PERMIT TREATMENT SPEC", true, inspectionType, guideitem
											.getDescription(), inspectionKey, inspectionDate, guideitem
											.getText(), violationsType, groupkey, true, isApproveStatus);							
						}
						else if ("HMD_RVIO_9".equalsIgnoreCase(groupkey))
						{// 3.1.0.1 convert the violation which the ASIT gourp is HMD_RVIO_6.
							setAdditionalToViolation(additionalInformationSubGroup, "TIERED PERMIT TRTMNT-ALL TIERS",
								true, inspectionType, guideitem.getDescription(), inspectionKey, 
										inspectionDate, guideitem.getText(), violationsType, groupkey, true, isApproveStatus);
						}
					}
					else
					{// 3.1.1 Convert ASI.

						// 3.1.1.0 Convert ASI to violation which group is HMD_RVIO_5.
						// This type ASI need not actual date and actual qualifier
						if ("HMD_RVIO_5".equalsIgnoreCase(groupkey))
						{
							setAdditionalToViolation(additionalInformationSubGroup, "VIOLATIONS", false,
								inspectionType, guideitem.getDescription(), inspectionKey,
										inspectionDate, guideitem.getText(), violationsType, groupkey, false, isApproveStatus);
						}
						else if ("HMD_RVIO".equalsIgnoreCase(groupkey))
						{// 3.1.1.2 Convert ASI to violation which group is HMD_RVIO.
							setAdditionalToViolation(additionalInformationSubGroup, "VIOLATIONS", true, inspectionType,
								guideitem.getDescription(), inspectionKey, inspectionDate, guideitem
										.getText(), violationsType, groupkey, false, isApproveStatus);
						}
					}
				}
			}
		}
	}

	private static void setAdditionalToViolation(List<AdditionalInformationSubGroup> subGroups, String subGroupKey,
			boolean hasActual, String inspectionType, String guideSheetDescription, String inspectionKey,
			XMLGregorianCalendar inspectionDate, String guideSheetText, ViolationsType ViolationTypes, String groupKey,
			boolean isAsit, boolean isApproveStatus)
	{

		for (AdditionalInformationSubGroup subGroup : subGroups)
		{
			if ("Structural".equalsIgnoreCase(subGroup.getType()))
			{
				continue;
			}

			ViolationType violationType = new ViolationType();
			violationType.setViolationHeader(InspectionUtil.getEnforcementHeader(isApproveStatus));
			violationType.setTypeID(guideSheetDescription.substring(0, 7));
			// 2.0 Set occurred on.
			violationType.setOccurredOn(inspectionDate);
			violationType.setInspectionRegulatorKey(inspectionKey);
			violationType.setViolationRegulatorKey(violationType.getInspectionRegulatorKey() + "-"
					+ violationType.getTypeID());

			if (subGroupKey.equalsIgnoreCase(DateConvertUtil.getKeyFromKeys(subGroup.getKeys()))
					&& subGroup.getAdditionalItems() != null
					&& subGroup.getAdditionalItems().getAdditionalItem() != null
					&& subGroup.getAdditionalItems().getAdditionalItem().size() > 0)
			{
				for (AdditionalItem item : subGroup.getAdditionalItems().getAdditionalItem())
				{
					String fieldlabel = DateConvertUtil.getKeyFromKeys(item.getKeys());
					String value = item.getValue();

					if ("Violation Classification".equalsIgnoreCase(fieldlabel))
					{
						setClassToViolation(violationType, value);
					}
					else if ("RTC Due Date".equals(fieldlabel))
					{
						violationType.setScheduledRTCOn(DateConvertUtil.date2Gregorian(value));
					}
					//Eric fixed base on Change request,
					//ALL inspection types to populate the Return to compliance and actual RTC dates
					else if (hasActual && "Returned to Compliance Qualifier".equals(fieldlabel))
					{
						violationType.setActualRTCQualifier(getRTCQualifierToViolation(value));
					}
					else if (hasActual && "Returned to Compliance Date".equals(fieldlabel))
					{
						violationType.setActualRTCOn(DateConvertUtil.date2Gregorian(value));
					}
//					else if (hasActual && "Return To Compliance (RTC)".equalsIgnoreCase(inspectionType)
//							&& "Returned to Compliance Qualifier".equals(fieldlabel))
//					{
//						violationType.setActualRTCQualifier(getRTCQualifierToViolation(value));
//					}
//					else if (hasActual && "Return To Compliance (RTC)".equalsIgnoreCase(inspectionType)
//							&& "Returned to Compliance Date".equals(fieldlabel))
//					{
//						violationType.setActualRTCOn(DateConvertUtil.date2Gregorian(value));
//					}
				}
			}
			// Set to the vilation list.
			if (!isApproveStatus || (violationType != null && violationType.getClazz() != null && violationType.getClazz() != ""
					&& (violationType.getActualRTCOn() != null || violationType.getScheduledRTCOn() != null)))
			{
				// 4.0 Set comment to vioaltion Type.
				setCommentToViolation(violationType, guideSheetText, groupKey, isAsit);
				ViolationTypes.getViolation().add(violationType);
			}
			else
			{
				logger.info("===Violations Clazz:" + violationType.getClazz() + "/ActualRTCOn:" + violationType.getActualRTCOn() + "/ScheduledRTCOn:" + violationType.getScheduledRTCOn());
			}
		}
	}

	private static String getRTCQualifierToViolation(String value)
	{
		String violationType = null;
		if ("1 = Documented".equalsIgnoreCase(value))
		{
			violationType = "1";
		}
		if ("2 = Observed".equalsIgnoreCase(value))
		{
			violationType = "2";
		}
		if ("3 = Not Resolvable".equalsIgnoreCase(value))
		{
			violationType = "3";
		}
		//Eric Liu fixed
		if ("4 = Unobserved".equalsIgnoreCase(value) || "4  = Observable".equalsIgnoreCase(value))
		{
			violationType = "4";
		}
		return violationType;
	}

	private static void setClassToViolation(ViolationType violationType, String value)
	{
		if (value.equals("Class I"))
		{
			violationType.setClazz("1");
		}
		else if (value.equals("Class II"))
		{
			violationType.setClazz("2");
		}
		else if (value.equals("Minor"))
		{
			violationType.setClazz("9");
		}
	}

	private static void setCommentToViolation(ViolationType violationType, String guideSheetComments, String groupKey,
			boolean isAsit)
	{
		if (!isAsit && "HMD_RVIO_5".equalsIgnoreCase(groupKey))
		{
			violationType.setComment("Tank#");
		}
		else if (isAsit && "HMD_RVIO_6".equalsIgnoreCase(groupKey))
		{
			violationType.setComment("Container");
		}
		else if (isAsit && "HMD_RVIO_9".equalsIgnoreCase(groupKey))
		{
			violationType.setComment("Tank ID");
		}
		else
		{
			violationType.setComment(guideSheetComments);
		}
	}

}

/*
 * $Log: av-env.bat,v $
 */
