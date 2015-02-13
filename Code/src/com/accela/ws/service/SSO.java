/**
 * SSO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.accela.ws.service;

public interface SSO extends java.rmi.Remote {
    public com.accela.ws.model.UserSessionImpl4WS signon4WS(java.lang.String systemID, java.lang.String domain, java.lang.String agencyID, java.lang.String userID, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String signon(java.lang.String agencyID, java.lang.String userId, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String authenticate(java.lang.String userId, java.lang.String ssoSessionId) throws java.rmi.RemoteException;
}
