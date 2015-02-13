package com.accela.adapter.util;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <pre>
 *
 *  Accela Automation
 *  File: LogPrint.java
 *
 *  Accela, Inc.
 *  Copyright (C): 2012
 *
 *  Description:
 *  TODO
 *
 *  Notes:
 * 	$Id: LogPrint.java 72642 2009-01-01 20:01:57Z ACHIEVO\zony.rao $
 *
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2012-12-6		zony.rao		Initial.
 *
 * </pre>
 */
public class LogPrintUitl
{
	public static String getSummaryResult(Map<String, Long> count, Map<String, List<String>> failString)
	{
		return getSummaryResult(count, failString, "\n\r");
	}
	
	public static String getSummaryResult(Map<String, Long> count, Map<String, List<String>> failString, String seperator)
	{
		StringBuilder summaryResult = new StringBuilder();
		long childSuccess = 0L;
		long childAll = 0L;
		StringBuilder childSb = new StringBuilder();
		for (String key : count.keySet())
		{
			if (key.endsWith(".all"))
			{
				if (key.startsWith("Facility"))
				{
					String names[] = key.split("\\.");
					Long success = count.get(names[0] + ".success");
					if (success == null)
					{
						success = 0L;
					}
					Long all = count.get(names[0] + ".all");
					if (all == null)
					{
						all = 0L;
					}
					StringBuilder sb = new StringBuilder();
					sb.append("There are " + all + " facilities need to sync, succeeded: " + success);
					String failureList = getFailureListString(failString, "Facility.fail");
					if (failureList != null) {
						sb.append(", failed: " + (all - success)).append(" ({").append(failureList).append("}).");
					}
					//LOGGER.info(sb.toString());
					summaryResult.append(sb.toString()).append(seperator);
				}
				else if (key.startsWith("document"))
				{
					Long success = count.get("document.success") == null ? 0L : count.get("document.success");
					Long all = count.get("document.all") == null ? 0L : count.get("document.all");
					StringBuilder sb = new StringBuilder();
					sb.append("There are " + all + " documents need to sync, succeeded: " + success);
					String failureList = getFailureListString(failString, "document.fail");
					if (failureList != null) {
						sb.append(", failed: " + (all - success)).append(" ({").append(failureList).append("}).");
					}
					//LOGGER.info(sb.toString());
					summaryResult.append(sb.toString()).append(seperator);
				}
				else
				{
					String names[] = key.split("\\.");
					Long success = count.get(names[0] + ".success");
					if (success == null)
					{
						success = 0L;
					}
					childSuccess += success;
					Long all = count.get(names[0] + ".all");
					if (all == null)
					{
						all = 0L;
					}
					childAll += all;
					List<String> fails = failString.get(names[0] + ".fail");

					if (fails != null && fails.size() > 0)
					{
						for (int i = 0; i < fails.size(); i++)
						{

							String fail = fails.get(i);
							childSb.append(fail).append(",");

						}
					}
				}

			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("There are " + childAll + " child records need to sync, succeeded: " + childSuccess);
		if (!"".equals(childSb.toString()))
		{
			sb.append(", failed: " + (childAll - childSuccess) + " ({");
			sb.append(childSb.substring(0, childSb.length() - 1));
			sb.append("}).");
		}
		//LOGGER.info(sb.toString());
		summaryResult.append(sb.toString()).append(seperator);
		
		return summaryResult.toString();
	}
	

	private static String getFailureListString(Map<String, List<String>> failString, String failureCategory) {
		if (failString.get(failureCategory) != null && failString.get(failureCategory).size() > 0)
		{
			List<String> fails = failString.get(failureCategory);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < fails.size(); i++)
			{
				String fail = fails.get(i);
				if (i == 0)
				{
					sb.append(fail);
				}
				else
				{
					sb.append(",").append(fail);
				}
			}
			return sb.toString();
		}
		return null;
	}
}

/*
 * $Log: av-env.bat,v $
 */