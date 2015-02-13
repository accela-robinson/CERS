/**
 * GenericQueryServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.accela.ws.service;

import com.accela.util.AVProperties;

public class GenericQueryServiceLocator extends org.apache.axis.client.Service implements
		com.accela.ws.service.GenericQueryService
{

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = -8988870023064598960L;

	

	public GenericQueryServiceLocator()
	{
	}

	public GenericQueryServiceLocator(org.apache.axis.EngineConfiguration config)
	{
		super(config);
	}

	public GenericQueryServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException
	{
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for GenericQueryService
	private java.lang.String GenericQueryService_address = AVProperties.getBizServerURL()+"/av-biz-ws-0.9/services/GenericQueryService";

	public java.lang.String getGenericQueryServiceAddress()
	{
		return GenericQueryService_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String GenericQueryServiceWSDDServiceName = "GenericQueryService";

	public java.lang.String getGenericQueryServiceWSDDServiceName()
	{
		return GenericQueryServiceWSDDServiceName;
	}

	public void setGenericQueryServiceWSDDServiceName(java.lang.String name)
	{
		GenericQueryServiceWSDDServiceName = name;
	}

	public com.accela.ws.service.GenericQuery getGenericQueryService() throws javax.xml.rpc.ServiceException
	{
		java.net.URL endpoint;
		try
		{
			endpoint = new java.net.URL(GenericQueryService_address);
		}
		catch (java.net.MalformedURLException e)
		{
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getGenericQueryService(endpoint);
	}

	public com.accela.ws.service.GenericQuery getGenericQueryService(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException
	{
		try
		{
			com.accela.ws.service.GenericQueryServiceSoapBindingStub _stub = new com.accela.ws.service.GenericQueryServiceSoapBindingStub(
					portAddress, this);
			_stub.setPortName(getGenericQueryServiceWSDDServiceName());
			return _stub;
		}
		catch (org.apache.axis.AxisFault e)
		{
			return null;
		}
	}

	public void setGenericQueryServiceEndpointAddress(java.lang.String address)
	{
		GenericQueryService_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has no port for the given interface, then
	 * ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException
	{
		try
		{
			if (com.accela.ws.service.GenericQuery.class.isAssignableFrom(serviceEndpointInterface))
			{
				com.accela.ws.service.GenericQueryServiceSoapBindingStub _stub = new com.accela.ws.service.GenericQueryServiceSoapBindingStub(
						new java.net.URL(GenericQueryService_address), this);
				_stub.setPortName(getGenericQueryServiceWSDDServiceName());
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
		if ("GenericQueryService".equals(inputPortName))
		{
			return getGenericQueryService();
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
		return new javax.xml.namespace.QName("http://service.ws.accela.com", "GenericQueryService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts()
	{
		if (ports == null)
		{
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://service.ws.accela.com", "GenericQueryService"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName, java.lang.String address)
			throws javax.xml.rpc.ServiceException
	{

		if ("GenericQueryService".equals(portName))
		{
			setGenericQueryServiceEndpointAddress(address);
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
