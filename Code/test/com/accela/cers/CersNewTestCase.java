package com.accela.cers;

import java.io.StringWriter;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import junit.framework.TestCase;

import com.accela.adapter.constants.AdapterConstants;
import com.accela.adapter.model.cap.CAPTypeId;
import com.accela.adapter.model.cap.InitiateCAP;
import com.accela.adapter.model.common.Keys;
import com.accela.adapter.model.function.GovXML;
import com.accela.adapter.service.impl.AuthService;
import com.accela.adapter.service.impl.HttpPostService;
import com.accela.adapter.util.CommonUtil;
import com.accela.cers.cap.model.RegulatorFacilitySubmittals;
import com.accela.cers.inspection.model.CMEHeaderType;
import com.accela.cers.inspection.model.CMESubmittalsType;
import com.accela.cers.inspection.model.EnforcementType;
import com.accela.cers.inspection.model.EnforcementsType;
import com.accela.cers.inspection.model.InspectionType;
import com.accela.cers.inspection.model.InspectionsType;
import com.accela.cers.inspection.model.ProgramElementType;
import com.accela.cers.inspection.model.ViolationType;
import com.accela.cers.inspection.model.ViolationsType;
import com.accela.cers.inspection.model.YesNoFlagType;
import com.accela.util.AVProperties;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Cers_New_TestCase.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2012-2013
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Cers_New_TestCase.java 72642 2009-01-01 20:01:57Z ACHIEVO\james.jiang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Nov 27, 2012		james.jiang		Initial.
 * 
 * </pre>
 */
public class CersNewTestCase extends TestCase
{
	public void testJAXB()
	{
		try
		{

			RegulatorFacilitySubmittals param = CommonUtil.unMarshalCERS(CersNewTestCase.class.getResourceAsStream("mini.xml"));
			assertTrue(param.getFacilitySubmittal().get(1).getCERSID() != 0);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testGovxmlCreateCap()
	{
		GovXML govxml = new GovXML();
		InitiateCAP initCap = new InitiateCAP();
		initCap.setSystem(AuthService.getSystem());
		govxml.setInitiateCAP(initCap);

		CAPTypeId capTypeId = new CAPTypeId();
		Keys capTypeKeys = new Keys();
		capTypeKeys.getKey().add("LUEG-DEH");
		capTypeKeys.getKey().add("HMD");
		capTypeKeys.getKey().add("UPFP");
		capTypeKeys.getKey().add("Facility");
		capTypeId.setKeys(capTypeKeys);
		initCap.setCAPTypeId(capTypeId);

		try
		{
			String xml = CommonUtil.marshalGovXML(govxml);
			java.lang.System.out.println("request=\r\n" + xml);
			String response = HttpPostService.getHttpPostResponseStr(AVProperties.getGovxmlURL(), xml, "UTF-8");
			GovXML rep = CommonUtil.unMarshalGovXML(response);
			assertNotNull(rep);
			assertNotNull(rep.getInitiateCAPResponse().get(0).getCAPId().get(0).getIdentifierDisplay());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			this.fail(e.getMessage());
		}

	}

	public void testCreateCap()
	{
		try
		{
			CMESubmittalsType submittalsType = new CMESubmittalsType();

			// add EnfocementInfo
			//submittalsType.getInspectionsOrEnforcementsOrViolations().add(convertEnforcementsType());
			// add InspecitnInfo
			//submittalsType.getInspectionsOrEnforcementsOrViolations().add(convertInspectionsType());

			JAXBContext context = JAXBContext.newInstance(CMESubmittalsType.class);
			Marshaller marshaller = context.createMarshaller();
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(submittalsType, stringWriter);
			java.lang.System.out.println("request=\r\n" + stringWriter.toString());
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static EnforcementsType convertEnforcementsType()
	{

		CMEHeaderType enforcementHeader = new CMEHeaderType();
		enforcementHeader.setCMEDataStatus("2");
		enforcementHeader.setRegulatorActionDateTime(dateTime(new Date()));
		enforcementHeader.setRegulatorCode(AdapterConstants.REGULATOR_CODE);

		EnforcementType enforcementType = new EnforcementType();
		enforcementType.setEnforcementHeader(enforcementHeader);
		enforcementType.setCERSID(new BigInteger("10175963"));
		enforcementType.setSEPAmount(new BigInteger("20000"));
		enforcementType.setFineAssessedAmount(new BigInteger("10000"));
		enforcementType.setEnforcementRegulatorKey("12CAP-00000-00123");// EnforcementRegulatorKey
		enforcementType.setViolationsCausingRedTag("1");
		enforcementType.setRedTagNumber("");
		enforcementType.setDocketNumber("");
		enforcementType.setRedTagIssued(YesNoFlagType.fromValue("Y"));
		enforcementType.setFormalType("a");
		enforcementType.setOccurredOn(date2Gregorian("2012-11-20"));
		enforcementType.setRedTagRemovedOn(date2Gregorian("2012-11-20"));
		enforcementType.setRedTagAffixedOn(date2Gregorian("2012-11-20"));
		enforcementType.setType("a");

		EnforcementsType enforcementsType = new EnforcementsType();
		enforcementsType.getEnforcement().add(enforcementType);

		return enforcementsType;

	}

	public static InspectionsType convertInspectionsType()
	{
		// set Inspections
		InspectionsType inspectionsType = new InspectionsType();
		InspectionType inspectionType = new InspectionType();

		CMEHeaderType inspectionHeader = new CMEHeaderType();
		inspectionHeader.setCMEDataStatus("2");
		inspectionHeader.setRegulatorActionDateTime(dateTime(new Date()));
		inspectionHeader.setRegulatorCode(AdapterConstants.REGULATOR_CODE);

		inspectionType.setInspectionHeader(inspectionHeader);
		inspectionType.setInspectionRegulatorKey("12CAP-00000-00069-2561436");
		inspectionType.setCERSID(new BigInteger("10152813"));
		inspectionType.setProgramElement(ProgramElementType.fromValue("f"));
		inspectionType.setOccurredOn(date2Gregorian("2012-11-28"));
		inspectionType.setType("a");
		//inspectionType.setClassIIViolationCount(new BigInteger("10"));
		//inspectionType.setClassIViolationCount(new BigInteger("20"));
		//inspectionType.setMinorViolationCount(new BigInteger("30"));
		inspectionType.setSOCDetermination("a");
		
		inspectionType.setViolationsRTCOn(date2Gregorian("2012-11-28"));
		inspectionType.setComment("10");
		inspectionsType.getInspection().add(inspectionType);

		return inspectionsType;
	}
	
	public static ViolationsType convertViolationType()
	{
		// set Inspections
		ViolationsType vsType = new ViolationsType();
		ViolationType vType = new ViolationType();
		CMEHeaderType violationHeader = new CMEHeaderType();
		
		violationHeader.setCMEDataStatus("2");
		violationHeader.setRegulatorActionDateTime(dateTime(new Date()));
		violationHeader.setRegulatorCode(AdapterConstants.REGULATOR_CODE);
		
		vType.setActualRTCOn(date2Gregorian("2012-11-28"));
		vType.setActualRTCQualifier("1");
		vType.setClazz("1");
		vType.setComment("10");
		vType.setInspectionRegulatorKey("7d97199a-1f4c-4b46-8241-0b86e3f3c2e6");
		vType.setOccurredOn(date2Gregorian("2012-11-28"));
		vType.setScheduledRTCOn(date2Gregorian("2012-11-28"));
		vType.setTypeID("5020006");
		vType.setViolationHeader(violationHeader);
		vType.setViolationRegulatorKey("7d97199a-1f4c-4b46-8241-0b86e3f3c2e6");
		
		vsType.getViolation().add(vType);
		

		return vsType;
	}

	public static Date str2Date(String str)
	{
		// String str ="2012-11-20";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try
		{
			date = format.parse(str); // Thu Jan 18 00:00:00 CST 2007
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}

	public static XMLGregorianCalendar date2Gregorian(String str)
	{
		DatatypeFactory dataTypeFactory;
		Date date = str2Date(str);
		try
		{
			dataTypeFactory = DatatypeFactory.newInstance();
		}
		catch (DatatypeConfigurationException e)
		{
			throw new RuntimeException(e);
		}
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(date.getTime());
		return dataTypeFactory.newXMLGregorianCalendar(gc);
	}

	public static XMLGregorianCalendar dateTime(Date date)
	{
		DatatypeFactory dataTypeFactory;
		try
		{
			dataTypeFactory = DatatypeFactory.newInstance();
		}
		catch (DatatypeConfigurationException e)
		{
			throw new RuntimeException(e);
		}
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(date.getTime());
		return dataTypeFactory.newXMLGregorianCalendar(gc);
	}
}

/*
 * $Log: av-env.bat,v $
 */
