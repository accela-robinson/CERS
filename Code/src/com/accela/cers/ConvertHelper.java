package com.accela.cers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.accela.adapter.model.cap.CAPId;
import com.accela.adapter.model.cap.CAPs;
import com.accela.adapter.model.cap.InitiateCAP;
import com.accela.adapter.model.common.AdditionalInformation;
import com.accela.adapter.model.common.Keys;
import com.accela.adapter.model.function.UpdateCAP;
import com.accela.adapter.model.inspection.Inspections;
import com.accela.adapter.util.CapUtil;
import com.accela.cers.cap.model.ChemicalType;
import com.accela.cers.cap.model.FacilitySubmittalType;
import com.accela.cers.cap.model.HWUnitType;
import com.accela.cers.cap.model.USTTankType;
import com.accela.cers.inspection.model.CMESubmittalsType;
import com.accela.cers.inspection.model.EnforcementsType;
import com.accela.cers.inspection.model.InspectionsType;
import com.accela.cers.inspection.model.ViolationsType;
import com.accela.cers.inspection.model.EnforcementViolationsType;
import com.accela.cers.inspection.model.EnforcementViolationType;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ConvertHelper.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2012-2014
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ConvertHelper.java 72642 2009-01-01 20:01:57Z ACHIEVO\james.jiang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Nov 28, 2012		james.jiang		Initial.
 * 
 * </pre>
 */
public class ConvertHelper
{
	private static Logger logger = Logger.getLogger(ConvertHelper.class);
	
	public static InitiateCAP convertToCAP(List<AdditionalInformation> additionInfos, Object currObject,String dataSetDate,
			Object... objects)
	{
		ICAPConvert convert = getConvert(currObject);
		return convert.convertToInitCAP(additionInfos, currObject, dataSetDate, objects);

	}

	public static UpdateCAP updateCAPModel(List<AdditionalInformation> additionInfos, Object currObject,String DataSetDate,
			Object... objects)
	{
		ICAPConvert convert = getConvert(currObject);
		
		if (objects.length > 0 && objects[0] instanceof CAPId)
		{
			CAPId capId = (CAPId) objects[0];
			Keys capIdKey = (Keys) capId.getKeys().get(0);
			Map<String, String> asiValueMap = CapUtil.getASIInfosByCapId(capIdKey.getKey().get(0), capIdKey.getKey()
					.get(1), capIdKey.getKey().get(2));
			convert.setAsiValueMap(asiValueMap);
			Map<String, String> asiTValueMap = CapUtil.getASITableInfosByCapId(capIdKey.getKey().get(0), capIdKey
					.getKey().get(1), capIdKey.getKey().get(2));
			convert.setAsiTValueMap(asiTValueMap);
		}
		return convert.convertToUpdateCAP(additionInfos, currObject,DataSetDate,objects);

	}

	private static ICAPConvert getConvert(Object currObject)
	{
		ICAPConvert convert = null;

		if (currObject instanceof FacilitySubmittalType)
		{
			convert = new FacilityConverter();
		}
		else if (currObject instanceof ChemicalType)
		{
			convert = new ChemicalConveter();
		}
		else if (currObject instanceof USTTankType)
		{
			convert = new UndergroundStorageTankConverter();
		}
		else if (currObject instanceof HWUnitType)
		{
			convert = new HazardousWasteConverter();
		}
		return convert;

	}

	/**
	 * 
	 * TODO.
	 * 
	 * @param inspections
	 * @param addInfor
	 * @param paddInfor
	 * @return
	 */
	public static List<CMESubmittalsType> convertToCME(Inspections inspections, CAPs caps)
	{
		List<CMESubmittalsType> types = new ArrayList<CMESubmittalsType>();
		
		ViolationsType violationsType = new ViolationsType();
		EnforcementViolationsType eViolations = new EnforcementViolationsType();
		EnforcementsType convertToCME = EnforcementConvert.convertToCME(caps, violationsType, eViolations);
		
		if(convertToCME!=null && convertToCME.getEnforcement()!=null && convertToCME.getEnforcement().size()>0)
		{
			String regulatorTransactionKey = getRegulatorTransactionKey();
			CMESubmittalsType cmeCaptype = new CMESubmittalsType();
			cmeCaptype.setRegulatorTransactionKey(regulatorTransactionKey);
			//cmeCaptype.getInspectionsOrEnforcementsOrViolations().add(convertToCME);
			cmeCaptype.setEnforcements(convertToCME);
			if(violationsType.getViolation() != null 
					&& violationsType.getViolation().size() > 0)
			{
				cmeCaptype.setViolations(violationsType);
				cmeCaptype.setEnforcementViolations(eViolations);
			}
			logger.info("There are "+convertToCME.getEnforcement().size()+" Enforcement need be submitted to CME");
			types.add(cmeCaptype);
		}
		
//		InspectionsType convertToInspectionsType = InspectionConvert.convertToInspectionsType(inspections);
		
		InspectionsType convertToInspectionsType = new InspectionsType();
		ViolationsType convertToViolationType = new ViolationsType();
		
		InspectionConvert.convertToInspectionsType(inspections, convertToInspectionsType, convertToViolationType);
			
		if (convertToInspectionsType.getInspection() != null
				&& convertToInspectionsType.getInspection().size() > 0)
		{
			String regulatorTransactionKey = getRegulatorTransactionKey();
			CMESubmittalsType cmeInspectiontype = new CMESubmittalsType();
			cmeInspectiontype.setRegulatorTransactionKey(regulatorTransactionKey);
			//cmeInspectiontype.getInspectionsOrEnforcementsOrViolations().add(convertToInspectionsType);
			cmeInspectiontype.setInspections(convertToInspectionsType);			
			logger.info("There are "+convertToInspectionsType.getInspection().size()+" Inspection need be submitted to CME");
			
			if (convertToViolationType.getViolation() != null
					&& convertToViolationType.getViolation().size() > 0)
			{
				//cmeInspectiontype.getInspectionsOrEnforcementsOrViolations().add(convertToViolationType);
				cmeInspectiontype.setViolations(convertToViolationType);
				logger.info("There are "+convertToInspectionsType.getInspection().size()+" Violation need be submitted to CME");
			}
			types.add(cmeInspectiontype);
		}

		return types;
	}

//	// tets methed
//	public static CMESubmittalsType convertToCME()
//	{
//
//		String regulatorTransactionKey = getRegulatorTransactionKey();
//		CMESubmittalsType cmesubtype = new CMESubmittalsType();
//		cmesubtype.setRegulatorTransactionKey(regulatorTransactionKey);
//    /*
//		cmesubtype.getInspectionsOrEnforcementsOrViolations().add(CersNewTestCase.convertViolationType());
//		cmesubtype.getInspectionsOrEnforcementsOrViolations().add(CersNewTestCase.convertInspectionsType());
//		cmesubtype.getInspectionsOrEnforcementsOrViolations().add(CersNewTestCase.convertEnforcementsType());
//	*/	
//		cmesubtype.setViolations(CersNewTestCase.convertViolationType());
//		cmesubtype.setInspections(CersNewTestCase.convertInspectionsType());
//		cmesubtype.setEnforcements(CersNewTestCase.convertEnforcementsType());
//		return cmesubtype;
//	}

	public static long num = 0;

	public static String getRegulatorTransactionKey()
	{
		num++;
		String lastNum = String.format("%04d", num);
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String dateString = formatter.format(currentTime);
		String[] temp = dateString.split("-");
		String year = temp[0];
		String month = temp[1];
		String day = temp[2];
		String hour = temp[3];
		String minute = temp[4];
		return (new StringBuffer().append(year).append(month).append(day).append("-").append(hour).append(minute)
				.append("-").append("0000").append("-").append("0000").append("-").append("00000000").append(lastNum))
				.toString();
	}

}

/*
 * $Log: av-env.bat,v $
 */
