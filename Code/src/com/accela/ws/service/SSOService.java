/**
 * SSOService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.accela.ws.service;

public interface SSOService extends javax.xml.rpc.Service {
    public java.lang.String getSSOServiceAddress();

    public com.accela.ws.service.SSO getSSOService() throws javax.xml.rpc.ServiceException;

    public com.accela.ws.service.SSO getSSOService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
