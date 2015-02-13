package com.accela.adapter.service.impl;

import java.io.File;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.accela.aa.common.ConfigBase;
import com.accela.adapter.model.cap.CAPs;
import com.accela.adapter.model.common.ReturnElements;
import com.accela.adapter.model.function.GetCAPs;
import com.accela.adapter.model.function.GovXML;
import com.accela.adapter.model.inspection.InspectionSheet;
import com.accela.adapter.model.inspection.Inspections;
import com.accela.adapter.util.CapUtil;
import com.accela.adapter.util.InspectionUtil;
import com.accela.cers.ConvertHelper;
import com.accela.cers.inspection.model.CMESubmittalsType;
import com.accela.util.AVProperties;
import com.accela.util.EmailUtil;

/**
 * <pre>
 *
 * Accela IVR
 * Created Date: Sep 1, 2009
 *
 * Accela, Inc.
 * Copyright (C): 2009-2012
 *
 * Description:
 *
 *
 * Notes:
 * $Id: InspectionService.java 184244 2010-11-10 01:39:13Z ACHIEVO\bruin.li $
 *
 * </pre>
 */
public class InspectionService
{

	private static Logger logger = Logger.getLogger(InspectionService.class);

	public static boolean isTesting = false;

	private static final String DEFAULT_DATE_FORMAT2 = "MM-dd-yyyy";

	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	private static final SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

	private static final SimpleDateFormat formatcap = new SimpleDateFormat(DEFAULT_DATE_FORMAT2);

	private static String firstError = null;

	private static ConfigBase cb = new ConfigBase("dictionary");

	/**
	 *
	 * Get Inspections base on record Type(LUEG-DEH/HMD/UPFP/Facility), status(Complete), current schedule date.
	 *
	 * @return Inspections
	 * @throws Exception
	 */
	public static Inspections getInspections(String fromdate, String date) throws Exception
	{
		Inspections inspections = null;

		GovXML response = HttpPostService.doPostGovmxl(InspectionUtil.getInspectionRequest(fromdate, date));

		if (response != null && response.getGetInspectionsResponse().getInspectionSheets() != null
				&& response.getGetInspectionsResponse().getInspectionSheets().getInspectionSheet() != null
				&& response.getGetInspectionsResponse().getInspectionSheets().getInspectionSheet().size()>0)
		{
			inspections = new Inspections();
			for (InspectionSheet inspectionSheet : response.getGetInspectionsResponse().getInspectionSheets().getInspectionSheet())
			{
				if(inspectionSheet!=null && inspectionSheet.getInspections()!=null
						&& inspectionSheet.getInspections().getInspection()!=null
						&& inspectionSheet.getInspections().getInspection().size()>0)
				{
					inspections.getInspection().addAll(inspectionSheet.getInspections().getInspection());
				}

			}
		}

		return inspections;
	}

	/**
	 *
	 * For UT.
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args)
	{
		logger.info("Start run export inspections service");
		logger.info("The current version is "+cb.get(CapServiceCommon.VERSION));
		try
		{
			String submittalActionOnStart = "";
			String submittalActionOnEnd = "";

			if (args != null && args.length >= 1)
			{
				Scanner in = new Scanner(System.in);
				submittalActionOnStart = getActionStart(in);
				submittalActionOnEnd = getActionEnd(in);
			}
			else
			{

				int submittalRange = AVProperties.getIntProperty("cers.facility.submittalRange");
				Date endDate = Calendar.getInstance().getTime();
				Date startDate = endDate;
				if (submittalRange != 0)
				{
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DAY_OF_MONTH, -1 * submittalRange);
					startDate = cal.getTime();
				}
				submittalActionOnStart = format.format(startDate);
				submittalActionOnEnd = format.format(endDate);
			}
			logger.info("Start get Inspections from AA.");
			Inspections inspections = getInspections(submittalActionOnStart, submittalActionOnEnd);
			if (inspections == null || inspections.getInspection() == null || inspections.getInspection().size() == 0)
			{
				logger.info("There is not Inspection from AA.");
			}
			else
			{
				logger.info("Result: There are " + inspections.getInspection().size() + " Inspection from AA.");
			}
			logger.info("End get Inspections from AA.");

			logger.info("Start get Caps(Enforcement) from AA.");
			CAPs caps = getCAPS(submittalActionOnStart, submittalActionOnEnd);


			logger.info("End get Caps(Enforcement) from AA.");

			logger.info("Start Convert AA data to CME Submittals type.");
			List<CMESubmittalsType> cmeSubmittalsType = ConvertHelper.convertToCME(inspections, caps);
			logger.info("End Convert AA data to CME Submittals type.");

			if (cmeSubmittalsType != null && cmeSubmittalsType.size() > 0)
			{
				logger.info("Start upload Submittals type to CME.");
				int count = 0;
				for (CMESubmittalsType type : cmeSubmittalsType)
				{
					int i=0;
					if(type.getEnforcements()!=null){i++;};
					if(type.getInspections()!=null){i++;};
					if(type.getViolations()!=null){i++;};
					if(type.getEnforcementViolations()!=null){i++;};
//					if (type.getInspectionsOrEnforcementsOrViolations() != null
//							&& type.getInspectionsOrEnforcementsOrViolations().size() > 0)
//					{
//						count += type.getInspectionsOrEnforcementsOrViolations().size();
					if(i!=0){
						count+=i;
						String uploadURL = AVProperties.getCersPostURL();
						InspectionUtil.upload(uploadURL, type);
					}
				}
				logger.info("RESULT: There are " + count + " CME Submittals type upload success.");
			}
			else
			{
				logger.info("RESULT: There is not match CME submittals Type to upload.");
			}
			logger.info("End run export inspections service");
		}
		catch (Exception e)
		{
			logger.error("Export inspections service have exception", e);
			logger.info("End run export inspections service");
			firstError = e.getMessage();
			if ( firstError == null ) {
				firstError = e.toString();
			}
			sendMail();
		}

	}

	private static String getActionEnd(Scanner in)
	{
		return getParaFromConsole(in, "inspection resulted end date ");
	}

	/**
	 * Gets the action start.
	 *
	 * @param in the in
	 *
	 * @return the action start
	 */
	private static String getActionStart(Scanner in)
	{
		return getParaFromConsole(in, "inspection resulted start date ");
	}

	private static String getParaFromConsole(Scanner in, String paraName)
	{
		String resValue = "";
		boolean isValid = false;
		System.out.println("Input " + paraName + "(" + DEFAULT_DATE_FORMAT2 + ") :");
		while (!isValid)
		{

			resValue = in.nextLine();
			try
			{
				return format.format(formatcap.parse(resValue));

			}
			catch (Exception e)
			{
				isValid = false;
				System.out.println("InValid " + paraName + ". Input " + paraName + "(" + DEFAULT_DATE_FORMAT2 + ") :");
			}
		}
		return resValue;
	}

	private static void sendMail()
	{
		try
		{
			if (firstError != null)
			{
				File[] logfiles = new File[1];
				Date now = new Date();
				String logpath = "./log/adapter.log";
				logfiles[0] = new File(logpath);
				String message = MessageFormat.format(cb.get("av.mail.message.export"), now, firstError,
					logfiles[0].getCanonicalPath());
				logger.info("Email sent with message:\n\r" + message + "\n\r");
				
				EmailUtil.sendEmail(AVProperties.getProperty("av.mail.from"), AVProperties.getProperty("av.mail.to"),
					"", cb.get("av.mail.subject.export"), message, null);	// do not attach log file which could be huge
				logger.info("Email sent to: " + AVProperties.getProperty("av.mail.to"));
			}

		}
		catch (Exception e)
		{
			logger.error("Send mail failed.", e);
			// e.printStackTrace();
		}
	}

	public static CAPs getCAPS(String start, String end) throws Exception
	{
		GovXML govXML = new GovXML();
		GetCAPs getCapsReq = CapUtil.createQueryCap(start, end);

		ReturnElements returnElements = new ReturnElements();
		// returnElements.getReturnElement().add("AdditionalInformation");
		getCapsReq.setReturnElements(returnElements);
		govXML.setGetCAPs(getCapsReq);
		GovXML response=HttpPostService.doPostGovmxl(govXML);
		CAPs caps=response.getGetCAPsResponse().getCAPs();
		if (caps == null || caps.getCAP() == null || caps.getCAP().size() == 0)
		{
//			CapUtil.logInfo(govXML, response);
			logger.info("There is not Cap from AA.");
		}
		else
		{
			logger.info("There are " + caps.getCAP().size() + " Caps from AA.");
		}
		return caps;

	}
}
