package com.accela.cers;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.accela.adapter.constants.AdapterConstants;
import com.accela.adapter.model.common.AdditionalInformation;
import com.accela.adapter.model.common.AdditionalInformationGroup;
import com.accela.adapter.model.common.AdditionalInformationSubGroup;
import com.accela.adapter.model.common.AdditionalItem;
import com.accela.adapter.model.inspection.Guideitem;
import com.accela.adapter.model.inspection.Guidesheet;
import com.accela.adapter.model.inspection.Inspection;
import com.accela.adapter.model.inspection.Inspections;
import com.accela.adapter.util.InspectionUtil;
import com.accela.cers.inspection.model.CMEHeaderType;
import com.accela.cers.inspection.model.InspectionType;
import com.accela.cers.inspection.model.InspectionsType;
import com.accela.cers.inspection.model.ProgramElementType;
import com.accela.cers.inspection.model.ViolationType;
import com.accela.cers.inspection.model.ViolationsType;

/**
 * <pre>
 *
 *  Accela Automation
 *  File: InspectionCoveter.java
 *
 *  Accela, Inc.
 *  Copyright (C): 2012-2014
 *
 *  Description:
 *  TODO
 *
 *  Notes:
 * 	$Id: InspectionCoveter.java 72642 2009-01-01 20:01:57Z ACHIEVO\winchill.chen $
 *
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2012-11-30		winchill.chen		Initial.
 *
 * </pre>
 */
public class InspectionConvert
{
	private static final Log logger = LogFactory.getLog(InspectionConvert.class);
	/**
	 *
	 * Convert Inspections to CRST Inspection types.
	 *
	 * @param inspections AA inspections
	 * @return InspectionsType
	 */
	public static void convertToInspectionsType(Inspections inspections, InspectionsType inspectionsType,
			ViolationsType violationsType)
	{
		if (inspections != null && inspections.getInspection() != null && inspections.getInspection().size() > 0)
		{
			for (Inspection inspection : inspections.getInspection())
			{
				String inspectionDateString = inspection.getInspectionStatus()==null ? "" : inspection.getInspectionStatus().getDate();
				XMLGregorianCalendar inspectionDate = DateConvertUtil.date2Gregorian(inspectionDateString);
				String inspectionRegulatorKey = DateConvertUtil.getInpsectionKey(inspection);
				String g6_act_num =DateConvertUtil.getInpsectionKey4th(inspection);
				String comment ="Inspector: "+DateConvertUtil.getInspector(inspection)+"Inspection ID:"+g6_act_num;
				String inspType = DateConvertUtil.getInspectionType(inspection);
				String cersId = DateConvertUtil.getCersID(inspection);
				//cersId cannot be null;
				if (cersId != null && cersId != "" && inspection.getGuidesheets() != null
						&& inspection.getGuidesheets().getGuidesheet() != null
						&& inspection.getGuidesheets().getGuidesheet().size() > 0)
				{
					//get the program elements base on ASI/ASIT
					List<String> programElements = getProgramElements(inspection);
					//Calculate violation base on program elements
					if (programElements != null && programElements.size() > 0)
					{
						boolean isApproveStatus = true;
						if(inspection.getInspectionStatus() != null && AdapterConstants.INSPECTION_STATUS_DELETE.equals(inspection.getInspectionStatus().getValue()))
						{
							isApproveStatus = false;
						}
						CMEHeaderType cmeHeaderType = InspectionUtil.getEnforcementHeader(isApproveStatus);
						for (String programElement : programElements)
						{
							ViolationsType subViolationsType = ConvertViolation(inspection,
								inspectionDate, inspectionRegulatorKey, inspType, cersId, programElement);

							InspectionType inspectionType = new InspectionType();
							// Set to Inspection type
							inspectionType.setInspectionHeader(cmeHeaderType);
							inspectionType.setOccurredOn(inspectionDate);
							inspectionType.setInspectionRegulatorKey(inspectionRegulatorKey+programElement);
							inspectionType.setType(DateConvertUtil.getInspectionTypeValue(inspection));
							inspectionType.setProgramElement(ProgramElementType.fromValue(programElement));
							inspectionType.setCERSID(new BigInteger(cersId));
							inspectionType.setComment(comment);
							// Fix that both "RTC date" and "Actual RTC" to populate with the same date.
							XMLGregorianCalendar actualRTC = getActualRTC(subViolationsType, inspectionRegulatorKey
									+ programElement);
							if (actualRTC != null)
							{
								inspectionType.setViolationsRTCOn(actualRTC);
							}

							// CERS EDT removed removed violation summary counts using CDR fields #910 (http://cersapps.calepa.ca.gov/DataRegistry/Dictionary/UPDD2/910), #911 (http://cersapps.calepa.ca.gov/DataRegistry/Dictionary/UPDD2/911), and #912 (http://cersapps.calepa.ca.gov/DataRegistry/Dictionary/UPDD2/912)
							//setViolationCount(subViolationsType, inspectionType);

							if(subViolationsType.getViolation()!=null && subViolationsType.getViolation().size()>0)
							{
								violationsType.getViolation().addAll(subViolationsType.getViolation());
							}
							inspectionsType.getInspection().add(inspectionType);
						}
					}
				}

			}
		}
	}

	private static ViolationsType ConvertViolation(Inspection inspection,
			XMLGregorianCalendar inspectionDate, String inspectionRegulatorKey, String inspType, String cersId,
			String programElement)
	{
		ViolationsType violationsType = new ViolationsType();
		inspectionRegulatorKey = inspectionRegulatorKey+programElement;

		for (Guidesheet guidesheet : inspection.getGuidesheets().getGuidesheet())
		{
			String guidesheetKey = DateConvertUtil.getGuidesheetKey(guidesheet);
			//Ignore the Guidesheet start with "HMD" and "MW".
			if (!guidesheetKey.startsWith("MW")
					&& guidesheet.getGuideitems() != null
					&& guidesheet.getGuideitems().getGuideitem() != null
					&& guidesheet.getGuideitems().getGuideitem().size() > 0)
			{
				for (Guideitem guideitem : guidesheet.getGuideitems().getGuideitem())
				{
					if(guideitem.getDescription().startsWith("HMD"))
					{
						continue;
					}
					// get programElement
					String guideItemStatus = DateConvertUtil.getGuideItemStatus(guideitem.getStatus());

					//Check if this item need be evaluated.
					if (needEvaluate(programElement, guidesheetKey, guideitem.getDescription(),guideItemStatus)
							&& guideitem.getAdditionalInformation() != null
							&& guideitem.getAdditionalInformation().getAdditionalInformationGroup() != null
							&& guideitem.getAdditionalInformation().getAdditionalInformationGroup().size() > 0)
					{

						logger.info("======Item:IdentifierDisplay:" + guideitem.getIdentifierDisplay()+ "====Description:" + guideitem.getDescription());
						//Convert ASI/ASIT to Violation Type.
						ViolationsTypeConvert.convertAdditionalToViolationType(inspection, inspType,
							guideitem,inspectionRegulatorKey,violationsType);
					}

				}
			}
		}

		return violationsType;
	}

	private static XMLGregorianCalendar getActualRTC(ViolationsType violationsType, String inspectionRegulatorKey)
	{
		if (violationsType.getViolation() != null && violationsType.getViolation().size() > 0
				&& inspectionRegulatorKey != null && !"".equals(inspectionRegulatorKey))
		{
			for (ViolationType type : violationsType.getViolation())
			{
				if (type != null && inspectionRegulatorKey.equals(type.getInspectionRegulatorKey())
						&& type.getActualRTCOn() != null)
				{
					return type.getActualRTCOn();
				}
			}
		}
		return null;
	}

	/*
	private static void setViolationCount(ViolationsType violationsType, InspectionType inspectionType)
	{
		int classIViolationCount = 0;
		int classIIViolationCount = 0;
		int minorViolationCount = 0;
		if(violationsType.getViolation()!=null && violationsType.getViolation().size()>0)
		{
			for(ViolationType type : violationsType.getViolation())
			{
				if("1".equalsIgnoreCase(type.getClazz()))
				{
					classIViolationCount++;
				}
				else if("2".equalsIgnoreCase(type.getClazz()))
				{
					classIIViolationCount++;
				}
				else if("9".equalsIgnoreCase(type.getClazz()))
				{
					minorViolationCount++;
				}
			}
		}
		inspectionType.setClassIViolationCount(new BigInteger(String.valueOf(classIViolationCount)));
		inspectionType.setClassIIViolationCount(new BigInteger(String.valueOf(classIIViolationCount)));
		inspectionType.setMinorViolationCount(new BigInteger(String.valueOf(minorViolationCount)));
	}*/

	private static List<String> getProgramElements(Inspection inspection)
	{
		List<String> programElements = new ArrayList<String>();
		for (Guidesheet guidesheet : inspection.getGuidesheets().getGuidesheet())
		{
			if (guidesheet != null && guidesheet.getGuideitems() != null
					&& guidesheet.getGuideitems().getGuideitem() != null
					&& guidesheet.getGuideitems().getGuideitem().size() > 0)
			{
				for (Guideitem guideitem : guidesheet.getGuideitems().getGuideitem())
				{
					String guideItemStatus = DateConvertUtil.getGuideItemStatus(guideitem.getStatus());
					programElements.addAll(getProgramElement(guideitem.getAdditionalInformation(),
						guideItemStatus, guideitem.getDescription()));
				}
			}
		}
		return programElements;
	}

	private static boolean needEvaluate(String programElement, String guideSheetKey, String itemDescription,
			String guideItemStatus)
	{
		boolean needEvaluate = false;
		String tempDescription = null;
		if(itemDescription.length()>7)
		{
			tempDescription = itemDescription.substring(8,itemDescription.length()-1);
		}

		if ("Violation".equalsIgnoreCase(guideItemStatus) || "Delete".equalsIgnoreCase(guideItemStatus))
		{
			// Guide Item 11 - ASI Group = INSPECTION SCOPE and ASI Label = 'Hazardous Material' - Any
			// value except 'Not Applicable' 905 Program Element = a
			if ("a".equals(programElement) && "HM - General Requirements".equalsIgnoreCase(guideSheetKey))
			{
				needEvaluate = true;
			}

			// Guide Item 11 - ASI Group = INSPECTION SCOPE and ASI Label = 'CalARP' - Any value except
			// 'Not Applicable' 905 Program Element = b
			if ("b".equals(programElement) && ("CalARP - Admin/Docs".equalsIgnoreCase(guideSheetKey)
					|| "CalARP - Level 2 Training".equalsIgnoreCase(guideSheetKey)
					|| "CalARP - Level 2 Maint-Insp".equalsIgnoreCase(guideSheetKey)
					|| "CalARP - Level 3 Mech Intgrity".equalsIgnoreCase(guideSheetKey)
					|| "CalARP - Level 3 Training".equalsIgnoreCase(guideSheetKey)))
			{
				needEvaluate = true;
			}

			// Guide Item 11 - ASI Group = INSPECTION SCOPE and ASI Label = Underground Storage Tank -
			// Any value except 'Not Applicable' 905 Program Element = c
			if ("c".equals(programElement)
					&& ("UST System - File Records".equalsIgnoreCase(guideSheetKey)
							|| "UST System - Cathodic Protect".equalsIgnoreCase(guideSheetKey)
							|| "UST System - Closure".equalsIgnoreCase(guideSheetKey)
							|| "UST Tank (DW/SW) - Requirement".equalsIgnoreCase(guideSheetKey)
							|| "UST Tank (SW) - Monitor Opt 1".equalsIgnoreCase(guideSheetKey)
							|| "UST Tank (SW) - Monitor Opt 2".equalsIgnoreCase(guideSheetKey)
							|| "UST Tank (SW) - Monitor Opt 3".equalsIgnoreCase(guideSheetKey)
							|| "UST Tank (SW) - Monitor Opt 4".equalsIgnoreCase(guideSheetKey)
							|| "UST Piping (DW) - Press Gen".equalsIgnoreCase(guideSheetKey)
							|| "UST Piping (DW) - Press Opt 1".equalsIgnoreCase(guideSheetKey)
							|| "UST Piping (DW) - Press Opt 2".equalsIgnoreCase(guideSheetKey)
							|| "UST Piping (DW) - Press Opt 3".equalsIgnoreCase(guideSheetKey)
							|| "UST Piping (DW) - Press Opt 4".equalsIgnoreCase(guideSheetKey)
							|| "UST Piping (DW) - Suction Sys".equalsIgnoreCase(guideSheetKey)
							|| "UST Piping (SW) - Conv Suction".equalsIgnoreCase(guideSheetKey)
							|| "UST Piping (SW) - Gravity Sys".equalsIgnoreCase(guideSheetKey)
							|| "UST Piping (SW) - Press Gen".equalsIgnoreCase(guideSheetKey)
							|| "UST Piping (SW) - Press Opt 1".equalsIgnoreCase(guideSheetKey)
							|| "UST Piping (SW) - Press Opt 2".equalsIgnoreCase(guideSheetKey)
							|| "UST Piping (SW) - Press Opt 3".equalsIgnoreCase(guideSheetKey)
							|| "UST Piping (SW) - Press Opt 4".equalsIgnoreCase(guideSheetKey) || "UST Piping (SW) - Safe Suction"
							.equalsIgnoreCase(guideSheetKey)))
			{
				needEvaluate = true;
			}

			// Guide Item 11 - ASI Group = INSPECTION SCOPE and ASI Label = 'Above Ground Petroleum
			// Storage Act' = 'Yes' 905 Program Element = d
			if ("d".equals(programElement)
					&& ("APSA - Facility Inspection".equalsIgnoreCase(guideSheetKey)
							|| "APSA - General SPCC Req".equalsIgnoreCase(guideSheetKey)
							|| "APSA - Records Review".equalsIgnoreCase(guideSheetKey) || "APSA - SPCC Plan Elements"
							.equalsIgnoreCase(guideSheetKey)))
			{
				needEvaluate = true;
			}

			// Guide Item 11 - ASI Group = INSPECTION SCOPE and ASI Label = 'Hazardous Waste' - Any value
			// except 'Not Applicable' 905 Program Element = e
			if ("e".equals(programElement)
					&& (tempDescription == null || !tempDescription.startsWith("RCRA"))
					&& ("HW (LQG) - Recordkeeping".equalsIgnoreCase(guideSheetKey)
							|| "HW (LQG) - Storage/Handling".equalsIgnoreCase(guideSheetKey)
							|| "HW (LQG) - Tank System".equalsIgnoreCase(guideSheetKey)
							|| "HW (LQG) - Train/Contg/ER Plan".equalsIgnoreCase(guideSheetKey)
							|| "HW (LQG/SQG) - Dispose/Transpt".equalsIgnoreCase(guideSheetKey)
							|| "HW (LQG/SQG) - Recordkeeping".equalsIgnoreCase(guideSheetKey)
							|| "HW (LQG/SQG) - Store/Handle".equalsIgnoreCase(guideSheetKey)
							|| "HW (LQG/SQG) - Tank Systems".equalsIgnoreCase(guideSheetKey)
							|| "HW (SQG) - Storage/Handling".equalsIgnoreCase(guideSheetKey)
							|| "Photographic Waste".equalsIgnoreCase(guideSheetKey)
							|| "Universal Waste".equalsIgnoreCase(guideSheetKey)))
			{
				needEvaluate = true;
			}

			// Guide Item 12 - Status of 'RCRA LQG'
			// 905 Program Element = f
			if ("f".equals(programElement)
					&& tempDescription!=null && tempDescription.startsWith("RCRA")
					&& ("HW (LQG) - Recordkeeping".equalsIgnoreCase(guideSheetKey)
							|| "HW (LQG) - Storage/Handling".equalsIgnoreCase(guideSheetKey)
							|| "HW (LQG) - Tank System".equalsIgnoreCase(guideSheetKey)
							|| "HW (LQG) - Train/Contg/ER Plan".equalsIgnoreCase(guideSheetKey)
							|| "HW (LQG/SQG) - Dispose/Transpt".equalsIgnoreCase(guideSheetKey)
							|| "HW (LQG/SQG) - Recordkeeping".equalsIgnoreCase(guideSheetKey)
							|| "HW (LQG/SQG) - Store/Handle".equalsIgnoreCase(guideSheetKey)
							|| "HW (LQG/SQG) - Tank Systems".equalsIgnoreCase(guideSheetKey)
							|| "HW (SQG) - Storage/Handling".equalsIgnoreCase(guideSheetKey)
							|| "Photographic Waste".equalsIgnoreCase(guideSheetKey)
							|| "Universal Waste".equalsIgnoreCase(guideSheetKey)))
			{
				needEvaluate = true;
			}

			// Guide Item 11 - ASI Group = INSPECTION SCOPE and ASI Label = 'Tiered Permitting' = Permit By
			// Rule Inspection 905 Program Element = h

			if ("h".equals(programElement) && ("HW Treatment - PBR".equalsIgnoreCase(guideSheetKey)
					|| "HW Treatment - All Tiers".equalsIgnoreCase(guideSheetKey)))
			{
				needEvaluate = true;
			}

			// Guide Item 11 - ASI Group = INSPECTION SCOPE and ASI Label = 'Tiered Permitting' =
			// Conditionally Authorized Inspection 905 Program Element = i
			if ("i".equals(programElement) && ("HW Treatment - CA".equalsIgnoreCase(guideSheetKey)
					|| "HW Treatment - All Tiers".equalsIgnoreCase(guideSheetKey)))
			{
				needEvaluate = true;
			}

			// Guide Item 11 ASI Group = INSPECTION SCOPE and ASI Label = 'Tiered Permitting' =
			// Conditionally Authorized Inspection 905 Program Element = j
			if ("j".equals(programElement) && ("HW Treatment - CE".equalsIgnoreCase(guideSheetKey)
					|| "HW Treatment - All Tiers".equalsIgnoreCase(guideSheetKey)))
			{
				needEvaluate = true;
			}

			// Guide Item 11 - ASI Group = INSPECTION SCOPE and ASI Label = 'Tiered Permitting' =
			// Household Hazardous Waste Inspection 905 Program Element = k
			if ("k".equals(programElement)
					&& ("HHW - General Recordkeeping".equalsIgnoreCase(guideSheetKey)
							|| "HHW - Operation Plan/Req/Docs".equalsIgnoreCase(guideSheetKey)
							|| "HHW - Waste Handling Procedure".equalsIgnoreCase(guideSheetKey) || "HHW - CESQG Waste Requirements"
							.equalsIgnoreCase(guideSheetKey)))
			{
				needEvaluate = true;
			}
		}

		return needEvaluate;
	}
	/**
	 *
	 * Get Program Elements.
	 *
	 * @param additionalInfo the ASI/ASIT
	 * @param guideItemStatus the guidesheet item status.
	 * @param itemKey the item keys.
	 * @return
	 */
	private static List<String> getProgramElement(AdditionalInformation additionalInfo,String guideItemStatus, String itemKey)
	{
		List<String> programElements = new ArrayList<String>();
		if (itemKey.startsWith("11"))
		{
			if (additionalInfo != null && additionalInfo.getAdditionalInformationGroup() != null
					&& additionalInfo.getAdditionalInformationGroup().size() > 0)
			{
				for (AdditionalInformationGroup group : additionalInfo.getAdditionalInformationGroup())
				{
					if(!group.isAddRemoveSubGroups())
					{
						if (group.getAdditionalInformationSubGroup() != null
								&& group.getAdditionalInformationSubGroup().size() > 0)
						{
							for (AdditionalInformationSubGroup subGroup : group.getAdditionalInformationSubGroup())
							{
								String subGroupKey = DateConvertUtil.getSubGroupKey(subGroup);

								if ("INSPECTION SCOPE".equalsIgnoreCase(subGroupKey)
										&& subGroup.getAdditionalItems() != null
										&& subGroup.getAdditionalItems().getAdditionalItem() != null
										&& subGroup.getAdditionalItems().getAdditionalItem().size() > 0)
								{
									for (AdditionalItem item : subGroup.getAdditionalItems().getAdditionalItem())
									{
										String label = DateConvertUtil.getKeyFromKeys(item.getKeys());
										String value = item.getValue();
										String programElement = getProgramElementValue(label, value);
										if(programElement!=null && programElement!="")
										{
											programElements.add(programElement);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		else if (itemKey.startsWith("12") && "RCRA LQG".equalsIgnoreCase(guideItemStatus))
		{
			programElements.add("f");
		}

		return programElements;
	}

	private static String getProgramElementValue(String label, String value)

    {

       String programElement = null;

       if (("Hazardous Material".equalsIgnoreCase(label) || "Hazardous Materials".equalsIgnoreCase(label))

              && null != value &&!"".equals(value) && !"Not Applicable".equalsIgnoreCase(value) && !"_".equalsIgnoreCase(value))

       {

           programElement = "a";

       }

       if ("CalARP".equalsIgnoreCase(label) && null != value &&!"".equals(value) && !"Not Applicable".equalsIgnoreCase(value) && !"_".equalsIgnoreCase(value))

       {

           programElement = "b";

       }

       if ("Underground Storage Tank".equalsIgnoreCase(label)

              && null != value && !"".equals(value) && !"Not Applicable".equalsIgnoreCase(value) && !"_".equalsIgnoreCase(value))

       {

           programElement = "c";

       }
       //Eric Liu fixed, changed Yes and Y
       if ("Aboveground Petroleum Storage Act".equalsIgnoreCase(label)

              && null != value &&!"".equals(value)&& ("Y".equalsIgnoreCase(value) || "Yes".equalsIgnoreCase(value)))

       {

           programElement = "d";

       }

       if ("Hazardous Waste".equalsIgnoreCase(label)

              && null != value &&!"".equals(value) && !"Not Applicable".equalsIgnoreCase(value) && !"_".equalsIgnoreCase(value))

       {

           programElement = "e";

       }

       if ("Tiered Permitting".equalsIgnoreCase(label)

              && null != value &&!"".equals(value) && "Permit By Rule Inspection".equalsIgnoreCase(value) && !"_".equalsIgnoreCase(value))

       {

           programElement = "h";

       }

       if ("Tiered Permitting".equalsIgnoreCase(label)

              && null != value &&!"".equals(value) && "Conditionally Authorized Inspection".equalsIgnoreCase(value) && !"_".equalsIgnoreCase(value))

       {

           programElement = "i";

       }

       if ("Tiered Permitting".equalsIgnoreCase(label)

              && null != value &&!"".equals(value)&& "Conditionally Exempt Inspection".equalsIgnoreCase(value) && !"_".equalsIgnoreCase(value))

       {

           programElement = "j";

       }

       if ("Tiered Permitting".equalsIgnoreCase(label)

              && null != value &&!"".equals(value) && "Household Hazardous Waste Inspection".equalsIgnoreCase(value) && !"_".equalsIgnoreCase(value))

       {

           programElement = "k";

       }

       return programElement;

    }

}

/*
*$Log: av-env.bat,v $
*/
