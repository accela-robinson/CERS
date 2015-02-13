package com.accela.cers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;

import com.accela.adapter.constants.AdapterConstants;
import com.accela.adapter.model.cap.CAP;
import com.accela.adapter.model.cap.CAPs;
import com.accela.adapter.model.common.AdditionalInformationGroup;
import com.accela.adapter.model.common.AdditionalInformationSubGroup;
import com.accela.adapter.model.common.AdditionalItem;
import com.accela.adapter.model.inspection.Inspections;
import com.accela.adapter.util.CapUtil;
import com.accela.adapter.util.InspectionUtil;
import com.accela.cers.inspection.model.CMEHeaderType;
import com.accela.cers.inspection.model.EnforcementType;
import com.accela.cers.inspection.model.EnforcementViolationType;
import com.accela.cers.inspection.model.EnforcementViolationsType;
import com.accela.cers.inspection.model.EnforcementsType;
import com.accela.cers.inspection.model.InspectionsType;
import com.accela.cers.inspection.model.ViolationType;
import com.accela.cers.inspection.model.ViolationsType;
import com.accela.cers.inspection.model.YesNoFlagType;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: CmeConvertHelper.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2011-2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: CmeConvertHelper.java 72642 2009-01-01 20:01:57Z ACHIEVO\winchill.chen $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2011-11-29		winchill.chen		Initial.
 * 
 * </pre>
 */
public class EnforcementConvert
{
	private static Logger logger = Logger.getLogger(EnforcementConvert.class);

	/**
	 * 
	 * Convert Caps to Enforcement types.
	 * 
	 * @param caps the caps.
	 * @return EnforcementsType
	 */
	public static EnforcementsType convertToCME(CAPs caps, ViolationsType violationsType,
			EnforcementViolationsType eViolations)
	{
		EnforcementsType enforcementsType = new EnforcementsType();

		if (caps != null && caps.getCAP().size() > 0)
		{
			// 1.0 Set CME Header.

			// 2.0 Convert CMS Enforcement by cap.
			for (CAP cap : caps.getCAP())
			{
				if (cap.getKeys() != null && cap.getKeys().getKey() != null && cap.getKeys().getKey().size() > 0)
				{
					// 2.1 Get cers Id.
					String cersId = CapUtil.getParentValue(cap.getKeys().getKey());
					// Facility ID

					// 2.2 Convert ASI to enforcement.
					if (cersId != null && cersId != "" && cap.getAdditionalInformation() != null)
					{
						convertASItoEnformancement(enforcementsType, violationsType, eViolations, cap, cersId);
					}
				}
			}
		}

		// 3.0 Return enforcement types.
		return enforcementsType;
	}

	/**
	 * 
	 * Convert ASI to enforcement types.
	 * 
	 * @param enforcementsType the enforcements type
	 * @param enforcementHeader the enforcement header.
	 * @param cap the caps
	 * @param cersId the cers id.
	 */
	private static void convertASItoEnformancement(EnforcementsType enforcementsType, ViolationsType violationsType,
			EnforcementViolationsType eViolations, CAP cap, String cersId)
	{
		if (cap.getAdditionalInformation() != null
				&& cap.getAdditionalInformation().getAdditionalInformationGroup().size() > 0)
		{
			EnforcementType enforcementType = new EnforcementType();
			boolean isApproveStatus = true;
			boolean isIngoreRecord = false;
			ViolationType violation = new ViolationType();
			EnforcementViolationType eViolation = new EnforcementViolationType();

			List<String> facilityCapIds = null;
			Inspections inspections = null;
			InspectionsType convertToInspectionsType = new InspectionsType();
			ViolationsType convertToViolationType = new ViolationsType();
			
			for (AdditionalInformationGroup group : cap.getAdditionalInformation().getAdditionalInformationGroup())
			{
				// 1.0 Convert ASI Group to enforcement Type.

				if (group.getKeys() != null && group.getKeys().getKey().size() > 0
						&& AdapterConstants.GROUP_KEY.equalsIgnoreCase(group.getKeys().getKey().get(0))
						&& group.getAdditionalInformationSubGroup() != null
						&& group.getAdditionalInformationSubGroup().size() > 0)
				{
					for (AdditionalInformationSubGroup subgroup : group.getAdditionalInformationSubGroup())
					{
						if ("Structural".equalsIgnoreCase(subgroup.getType()))
						{
							continue;
						}
						if (subgroup.getAdditionalItems() != null
								&& subgroup.getAdditionalItems().getAdditionalItem().size() > 0)
						{
							String subgroupKey = DateConvertUtil.getSubGroupKey(subgroup);
							logger.debug("subgroupKey: " + subgroupKey );
							
							if(AdapterConstants.VIOLATIONS.equals(subgroupKey))
							{
								violation = new ViolationType();
								violation.setViolationHeader(InspectionUtil.getEnforcementHeader(isApproveStatus));
								eViolation = new EnforcementViolationType();
							}

							for (AdditionalItem addItem : subgroup.getAdditionalItems().getAdditionalItem())
							{
								String label = DateConvertUtil.getLabel(addItem);
								// 1.1 Set red tag details.
								if (AdapterConstants.RED_TAG_DETAILS.equalsIgnoreCase(subgroupKey)
										&& group.isAddRemoveSubGroups())
								{
									setRedTagDetails(label, enforcementType, addItem.getValue());
								}
								
								if(AdapterConstants.VIOLATIONS.equals(subgroupKey))
								{
									setEnforcementViolation(label, violation, addItem.getValue(), cap);
								}
								
								// 1.2 Set enforcement details.
								if ((AdapterConstants.ENFORCEMENT_DETAILS.equalsIgnoreCase(subgroupKey) || ("FORMAL ENFORCEMENT SUMMARY"
										.equalsIgnoreCase(subgroupKey))) && !group.isAddRemoveSubGroups())
								{
									setEnforcementDetails(label, enforcementType, addItem.getValue());
									if(AdapterConstants.CERS_CME_TRANSACTION.equals(label) && AdapterConstants.CERS_CME_TRANSACTION_DELETE.equals(addItem.getValue()))
									{
										isApproveStatus = false;
									}
									if (AdapterConstants.FORMAL_TYPE.equalsIgnoreCase(label) && addItem.getValue() != null && addItem.getValue() != "")
									{
										String value = addItem.getValue().trim();
										if ("e Small Claims Case".equalsIgnoreCase(value) || value.startsWith("e"))
										{
											isIngoreRecord = true;
										}
									}
								}
								//  Set enforcement case details.
								if (AdapterConstants.ENFORCEMENT_CASE_DETAILS.equalsIgnoreCase(subgroupKey)  && !group.isAddRemoveSubGroups())
								{
									setEnforcementCaseDetails(label, enforcementType, addItem.getValue());
								}
								// 1.3 Set finalcial summary.
								if (AdapterConstants.FORMAL_ENFORCEMENT_SUMMARY.equalsIgnoreCase(subgroupKey)
										&& !group.isAddRemoveSubGroups())
								{
									setFormalEnforcementAction(label, enforcementType, addItem.getValue());
								}
								
							}
							
							if (violation.getTypeID() != null && violation.getTypeID().length() > 0
									&& violation.getInspectionRegulatorKey() != null && violation.getInspectionRegulatorKey().length() > 0)
							{
								
								try
								{
									if(facilityCapIds == null  && inspections == null)
									{
										facilityCapIds = CapUtil.getCapByCersId(cersId);
										if(facilityCapIds != null)
										{
											inspections = InspectionUtil.getInspectionByCapAltId(facilityCapIds);
											InspectionConvert.convertToInspectionsType(inspections, convertToInspectionsType,
												convertToViolationType);
										}
									}

									
									if (convertToViolationType.getViolation() != null
											&& convertToViolationType.getViolation().size() > 0)
									{
										int size = convertToViolationType.getViolation().size();
										for (int i = 0; i < size; i++)
										{
											ViolationType tempViolation = convertToViolationType.getViolation().get(i);
											String violationKey = tempViolation.getViolationRegulatorKey();
											String[] arrayViolationKeyStr = violationKey.split("-");
											if(arrayViolationKeyStr[3].startsWith(violation.getInspectionRegulatorKey())
													&& violation.getTypeID().equals(arrayViolationKeyStr[4]))
											{
												violation.setInspectionRegulatorKey(tempViolation.getInspectionRegulatorKey());
												violation.setViolationRegulatorKey(tempViolation.getViolationRegulatorKey());

												eViolation.setEnforcementRegulatorKey(setEnforcementRegulatorKey(cap.getKeys().getKey()));
												eViolation.setViolationRegulatorKey(violationKey);
												eViolation.setEnforcementViolationRegulatorKey(setEnforcementRegulatorKey(cap
													.getKeys().getKey()) +  "-"	+ arrayViolationKeyStr[3] + "-" + arrayViolationKeyStr[4]);
											}
										}
									}
								}
								catch (Exception e)
								{
									// TODO Auto-generated catch block
									logger.debug("Failed to set Inspection Regulator Key for Enforcement Violations"  );
								}
								eViolation.setEnforcementViolationHeader(violation.getViolationHeader());

								violationsType.getViolation().add(violation);
								eViolations.getEnforcementViolation().add(eViolation);
							}
						}

					}
				}
			}
			CMEHeaderType enforcementHeader = InspectionUtil.getEnforcementHeader(isApproveStatus);
			if (enforcementType.getType() != null && enforcementType.getType() != "" && !isIngoreRecord)
			{
				enforcementType.setEnforcementHeader(enforcementHeader);
				enforcementType.setEnforcementRegulatorKey(setEnforcementRegulatorKey(cap.getKeys().getKey()));
				if (cersId != null)
				{
					enforcementType.setCERSID(new BigInteger(cersId));
				}

				enforcementsType.getEnforcement().add(enforcementType);
			}
		}
	}
	
	private static String getRTCQualifierToViolation(String value)
	{
		String violationType = null;
		if (value == null)
		{
			return violationType;
		}
		if ("1 = Documented".equalsIgnoreCase(value) || value.startsWith("1"))
		{
			violationType = "1";
		}
		if ("2 = Observed".equalsIgnoreCase(value) || value.startsWith("2"))
		{
			violationType = "2";
		}
		if ("3 = Not Resolvable".equalsIgnoreCase(value) || value.startsWith("3"))
		{
			violationType = "3";
		}
		if ("4 = Unobserved".equalsIgnoreCase(value) || "4  = Observable".equalsIgnoreCase(value)
				|| value.startsWith("4"))
		{
			violationType = "4";
		}
		return violationType;
	}
	
	private static void setEnforcementViolation(String label, ViolationType violation, String value, CAP cap)
	{
		try
		{
			if("Inspection Sequence ID".equalsIgnoreCase(label)&& value != null && value.length() > 0)
			{
				violation.setInspectionRegulatorKey(value);
			}
		    else if (AdapterConstants.ENFORCEMENT_VIOLATION_TYPE_ID.equalsIgnoreCase(label) && value != null && value.length() > 0)
			{
				if(value.length() > 7 )
				{
					value = value.substring(0, 7);
				}
				if(DateConvertUtil.isNumeric(value)) 
				{
					violation.setTypeID(value);
				}
			}
			else if (AdapterConstants.ENFORCEMENT_VIOLATION_CLASS.equalsIgnoreCase(label) && value != null && value.length() > 0)
			{
				setClassToViolation(violation, value);
			}
			else if (AdapterConstants.ENFORCEMENT_VIOLATION_DATE.equalsIgnoreCase(label) && value != null && value.length() > 0)
			{
				violation.setOccurredOn(DateConvertUtil.date2Gregorian(value));
			}
			else if (AdapterConstants.CERS_CME_TRANSACTION.equalsIgnoreCase(label) 
					&& AdapterConstants.ENFORCEMENT_VIOLATION_TRANSACTION_DELETE.equals(value))
			{
				violation.getViolationHeader().setCMEDataStatus(AdapterConstants.CME_DATA_STATUS_TYPE_DELETE);
			}
			else if (AdapterConstants.ENFORCEMENT_VIOLATION_COMPLIANCE.equalsIgnoreCase(label) && value != null && value.length() > 0)
			{
				violation.setActualRTCOn(DateConvertUtil.date2Gregorian(value));
			}
			else if ("RTC Qualifier".equals(label) && value != null && value.length() > 0)
			{
				violation.setActualRTCQualifier(getRTCQualifierToViolation(value));
			}
			else if ("Scheduled RTC Date".equals(label) && value != null && value.length() > 0)
			{
				violation.setScheduledRTCOn(DateConvertUtil.date2Gregorian(value));
			}
		}
		catch (Exception e)
		{
			logger.info("Set Enforcement Violation Error on " + label + ". And the value is " + value);
		}
	}
	
	private static void setClassToViolation(ViolationType violationType, String value)
	{ 
		if (value.equals("1 - Class 1") || value.startsWith("1"))
		{
			violationType.setClazz("1");
		}
		else if (value.equals("2 - Class 2") || value.startsWith("2"))
		{
			violationType.setClazz("2");
		}
		else if (value.equals("9 - Minor ") || value.startsWith("9"))
		{
			violationType.setClazz("9");
		}
	}

	/**
	 * 
	 * Set Finacial Summary.
	 * 
	 * @param label the field label name.
	 * @param enforcementType the enforcement Type.
	 * @param value the asi item value.
	 */
	private static void setFormalEnforcementAction(String label, EnforcementType enforcementType, String value)
	{
		try
		{
			// 1.0 Set FineAssessedAmount
			if (AdapterConstants.FINE_ASSESSED_AMOUNT.equalsIgnoreCase(label) && value != null && value.length() > 0)
			{
				enforcementType.setFineAssessedAmount(new BigDecimal(value).setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger());
			}
			// 1.1 SEPAmount
			if (AdapterConstants.SEP_AMOUNT.equalsIgnoreCase(label) && value != null && value.length() > 0)
			{
				enforcementType.setSEPAmount(new BigDecimal(value).setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger());
			}
		}
		catch (Exception e)
		{
			logger.info("BigInteger Convert Error on " + label + ". And the value is " + value);
		}
	}

	/**
	 * 
	 * Set enforcement details
	 * 
	 * @param label the asi label.
	 * @param enforcementType the enforcement type.
	 * @param value the asi item value.
	 */
	private static void setEnforcementDetails(String label, EnforcementType enforcementType, String value)
	{
		if (AdapterConstants.TYPE.equalsIgnoreCase(label) && value != null && value != "")
		{
			String type = null;
			// Type
			if ("a Notice of Violation (NOV) Only".equalsIgnoreCase(value))
			{
				type = "a";
			}
			if ("b AEO - Local Ordinance".equalsIgnoreCase(value))
			{
				type = "b";
			}
			if ("c AEO - UP".equalsIgnoreCase(value))
			{
				type = "c";
			}
			if ("d Referral to State Attorney General".equalsIgnoreCase(value))
			{
				type = "d";
			}
			if ("e Referral to District Attorney".equalsIgnoreCase(value))
			{
				type = "e";
			}
			//It supports to value is that 'f Referral to County Council or City Attorney’ or ‘f Referral to County Counsel or City Attorney’
			if (value.startsWith("f Referral to County"))
			{
				type = "f";
			}
			if ("g Referral to US Attorney".equalsIgnoreCase(value))
			{
				type = "g";
			}
			if ("h Referral to State Agency".equalsIgnoreCase(value))
			{
				type = "h";
			}
			if ("i Referral to Federal Agency".equalsIgnoreCase(value))
			{
				type = "i";
			}
			if ("j Referral to Other".equalsIgnoreCase(value))
			{
				type = "j";
			}
			enforcementType.setType(type);
		}

		// OccurredOn
		if (AdapterConstants.OCCURRED_ON.equalsIgnoreCase(label) && value != null && value != "")
		{
			// String convert to yyyy-MM-DD
			enforcementType.setOccurredOn(DateConvertUtil.dateTime(DateConvertUtil.str2Date(value)));
		}
		// FormalType
		if (AdapterConstants.FORMAL_TYPE.equalsIgnoreCase(label) && value != null && value != "")
		{
			String formalType = null;
			value = value.trim();
			if ("a Administrative".equalsIgnoreCase(value) || value.startsWith("a"))
			{
				formalType = "a";
			}
			else if ("b Civil Case".equalsIgnoreCase(value)|| value.startsWith("b"))
			{
				formalType = "b";
			}
			else if ("c Criminal Case".equalsIgnoreCase(value)|| value.startsWith("c"))
			{
				formalType = "c";
			}
			else if ("d Civil/Criminal Case".equalsIgnoreCase(value)|| value.startsWith("d"))
			{
				formalType = "d";
			}
			enforcementType.setFormalType(formalType);
		}
		// DocketNumber
		if (AdapterConstants.DOCKET_NUMBER.equalsIgnoreCase(label) && value != null && value != "")
		{
			// DocketNumber
			if(value.length() > 20)
			{
				value = value.substring(0, 20);
			}
			enforcementType.setDocketNumber(value);
		}
	}

	/**
	 * 
	 * Set Red tag details.
	 * 
	 * @param label the ASI label.
	 * @param enforcementType the enforcement type.
	 * @param value the asi item value.
	 */
	private static void setRedTagDetails(String label, EnforcementType enforcementType, String value)
	{
		// setRedTagIssued
		if (AdapterConstants.RED_TAG_ISSUED.equalsIgnoreCase(label) && value != null && value != "")
		{
			if ("Yes".equalsIgnoreCase(value))
			{
				enforcementType.setRedTagIssued(YesNoFlagType.Y);
			}
			else
			{
				enforcementType.setRedTagIssued(YesNoFlagType.N);
			}
		}
		// setRedTagNumber
		if (AdapterConstants.RED_TAG_NUMBER.equalsIgnoreCase(label))
		{
			if (value != null && value.length() < 4)
			{
				try
				{
					enforcementType.setRedTagNumber(String.format("%04d", Integer.valueOf(value)));
				}
				catch (Exception e)
				{
					enforcementType.setRedTagNumber(value);
				}
			}
			else if (value != null && value.length() > 5)
			{
				enforcementType.setRedTagNumber(value.substring(0, 5));
			}
			else
			{
				enforcementType.setRedTagNumber(value);
			}

		}
		// setViolationsCausingRedTag
		if (AdapterConstants.VIOLATIONS_CAUSING_RED_TAG.equalsIgnoreCase(label) && value != null && value != "")
		{
			if ("Violation threatening".equalsIgnoreCase(value) || "causing liquid release".equalsIgnoreCase(value)
					|| "Violation threatening/causing liquid release".equalsIgnoreCase(value))
			{

				enforcementType.setViolationsCausingRedTag("1");
			}
			else if ("Violation impairing ability of UST system to detect a leak".equalsIgnoreCase(value))
			{

				enforcementType.setViolationsCausingRedTag("2");
			}
			else if ("Chronic violation".equalsIgnoreCase(value)
					|| "committed by recalcitrant violator".equalsIgnoreCase(value))
			{

				enforcementType.setViolationsCausingRedTag("3");
			}
		}
		// setRedTagAffixedOn
		if (AdapterConstants.RED_TAGAFF_IXED_ON.equalsIgnoreCase(label) && value != null && value != "")
		{
			// String convert to yyyy-MM-DD
			enforcementType.setRedTagAffixedOn(DateConvertUtil.dateTime(DateConvertUtil.str2Date(value)));
		}
		// setRedTagRemovedOn
		if (AdapterConstants.RED_TAG_REMOVED_ON.equalsIgnoreCase(label) && value != null && value != "")
		{
			// String convert to yyyy-MM-DD
			enforcementType.setRedTagRemovedOn(DateConvertUtil.dateTime(DateConvertUtil.str2Date(value)));
		}
	}

	/**
	 * 
	 * Get Enforcement Regulator Key.
	 * 
	 * @param capKeys The cap keys.
	 * @return String
	 */
	private static String setEnforcementRegulatorKey(List<String> capKeys)
	{
		String enforcementRegulatorKey = null;
		if (capKeys != null && capKeys.size() > 0)
		{
			StringBuilder tempKey = new StringBuilder();
			for (String capId : capKeys)
			{
				tempKey.append(capId).append("-");
			}
			enforcementRegulatorKey = tempKey.toString().substring(0, tempKey.length() - 1);
		}
		return enforcementRegulatorKey;
	}
	
	private static void setEnforcementCaseDetails(String label, EnforcementType enforcementType, String value)
	{
		//Date Referred Case Settled/Dropped (917a)
		if (AdapterConstants.CASE_SETTLED_DROPPED_ON.equalsIgnoreCase(label) && value != null && value != "")
		{
			// String convert to yyyy-MM-DD
			enforcementType.setCaseSettledDroppedOn(DateConvertUtil.dateTime(DateConvertUtil.str2Date(value)));
		}
	}
}

/*
 * $Log: av-env.bat,v $
 */
