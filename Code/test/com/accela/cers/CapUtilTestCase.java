package com.accela.cers;

import java.util.List;

import junit.framework.TestCase;

import com.accela.adapter.model.cap.CAP;
import com.accela.adapter.model.common.AdditionalInformation;
import com.accela.adapter.util.CapUtil;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: CapUtilTestCase.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2012
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: CapUtilTestCase.java 72642 2009-01-01 20:01:57Z ACHIEVO\james.jiang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Nov 29, 2012		james.jiang		Initial.
 *  
 * </pre>
 */
public class CapUtilTestCase extends TestCase
{
	public void testGetCapByCersId()
	{
		try
		{
			List<String> capIds= CapUtil.getCapByCersId("04");
			assertNotNull(capIds);
			assertFalse(capIds.isEmpty());
			CAP cap= CapUtil.getCapByCapIds(capIds);
			assertNotNull(cap);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			this.fail(e.getMessage());
		}
		
		
	}

	
	public void testGetAdditionalInfoByType()
	{
		try
		{
			List<AdditionalInformation> govxml= CapUtil.getAdditionalInfoByType("FacilitySubmittalType");
			this.assertNotNull(govxml);
			this.assertFalse(govxml.isEmpty());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			this.fail(e.getMessage());
		}
		
		
	}
}

/*
*$Log: av-env.bat,v $
*/