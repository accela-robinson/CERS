package com.accela.adapter.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.accela.adapter.model.auth.AuthenticateUser;
import com.accela.adapter.model.function.GovXML;
import com.accela.adapter.util.CommonUtil;
import com.accela.util.AVProperties;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: AuthService.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2012
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: AuthService.java 72642 2009-01-01 20:01:57Z ACHIEVO\james.jiang $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Nov 28, 2012		james.jiang		Initial.
 * 
 * </pre>
 */
public class AuthService
{

	private static final Log LOGGER = LogFactory.getLog(AuthService.class);
	
	static com.accela.adapter.model.common.System system;

	static{
		login();
	}
	public static com.accela.adapter.model.common.System getSystem()
	{
		if (system == null)
		{
			login();
		}
		return system;
	}

	private static void  login()
	{
		GovXML govxml = initAuthInfo();
		try
		{
			String xml = CommonUtil.marshalGovXML(govxml);
			GovXML response = HttpPostService.getGovXMLResponse(xml);
			system = response.getAuthenticateUserResponse().getSystem();
			if (system.getXMLVersion() == 0)
			{
				system.setXMLVersion(720);
			}
			if (system.getUsername() == null)
			{
				system.setUsername(AVProperties.getAAUser());
			}
			if (system.getServiceProviderCode() == null)
			{
				system.setServiceProviderCode(AVProperties.getAAAgency());
			}
			LOGGER.debug("auth user applicationState:" + system.getApplicationState());

		}
		catch (Exception e)
		{
			e.printStackTrace();
			LOGGER.fatal("Unable to login system.", e);
		}

	}

	private static GovXML initAuthInfo()
	{
		GovXML govxml = new GovXML();
		com.accela.adapter.model.common.System authInfo = new com.accela.adapter.model.common.System();
		authInfo.setServiceProviderCode(AVProperties.getAAAgency());
		authInfo.setContext("AccelaMobileOffice");
		authInfo.setLanguageID("en-US");
		AuthenticateUser authUser = new AuthenticateUser();
		authUser.setSystem(authInfo);
		authUser.setUsername(AVProperties.getAAUser());
		authUser.setPassword(AVProperties.getAAPassword());
		govxml.setAuthenticateUser(authUser);
		return govxml;
	}	

}

/*
 * $Log: av-env.bat,v $
 */