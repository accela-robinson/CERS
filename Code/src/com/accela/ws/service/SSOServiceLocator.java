/**
 * SSOServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.accela.ws.service;

import com.accela.util.AVProperties;

public class SSOServiceLocator extends org.apache.axis.client.Service implements com.accela.ws.service.SSOService
{
	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = 72141431148471982L;

	

	public SSOServiceLocator()
	{
	}

	public SSOServiceLocator(org.apache.axis.EngineConfiguration config)
	{
		super(config);
	}

	public SSOServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException
	{
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for SSOService
	private java.lang.String SSOService_address = AVProperties.getBizServerURL()+"/av-biz-ws-0.9/services/SSOService";

	public java.lang.String getSSOServiceAddress()
	{
		return SSOService_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String SSOServiceWSDDServiceName = "SSOService";

	public java.lang.String getSSOServiceWSDDServiceName()
	{
		return SSOServiceWSDDServiceName;
	}

	public void setSSOServiceWSDDServiceName(java.lang.String name)
	{
		SSOServiceWSDDServiceName = name;
	}

	public com.accela.ws.service.SSO getSSOService() throws javax.xml.rpc.ServiceException
	{
		java.net.URL endpoint;
		try
		{
			endpoint = new java.net.URL(SSOService_address);
		}
		catch (java.net.MalformedURLException e)
		{
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getSSOService(endpoint);
	}

	public com.accela.ws.service.SSO getSSOService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException
	{
		try
		{
			com.accela.ws.service.SSOServiceSoapBindingStub _stub = new com.accela.ws.service.SSOServiceSoapBindingStub(
					portAddress, this);
			_stub.setPortName(getSSOServiceWSDDServiceName());
			return _stub;
		}
		catch (org.apache.axis.AxisFault e)
		{
			return null;
		}
	}

	public void setSSOServiceEndpointAddress(java.lang.String address)
	{
		SSOService_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has no port for the given interface, then
	 * ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException
	{
		try
		{
			if (com.accela.ws.service.SSO.class.isAssignableFrom(serviceEndpointInterface))
			{
				com.accela.ws.service.SSOServiceSoapBindingStub _stub = new com.accela.ws.service.SSOServiceSoapBindingStub(
						new java.net.URL(SSOService_address), this);
				_stub.setPortName(getSSOServiceWSDDServiceName());
				return _stub;
			}
		}
		catch (java.lang.Throwable t)
		{
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  "
				+ (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has no port for the given interface, then
	 * ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException
	{
		if (portName == null)
		{
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("SSOService".equals(inputPortName))
		{
			return getSSOService();
		}
		else
		{
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName()
	{
		return new javax.xml.namespace.QName("http://service.ws.accela.com", "SSOService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts()
	{
		if (ports == null)
		{
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://service.ws.accela.com", "SSOService"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName, java.lang.String address)
			throws javax.xml.rpc.ServiceException
	{

		if ("SSOService".equals(portName))
		{
			setSSOServiceEndpointAddress(address);
		}
		else
		{ // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address)
			throws javax.xml.rpc.ServiceException
	{
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
