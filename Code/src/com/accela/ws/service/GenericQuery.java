/**
 * GenericQuery.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.accela.ws.service;

public interface GenericQuery extends java.rmi.Remote {
    public com.accela.aa.wsquery.ReturnInfo query(java.lang.String sessionId, java.lang.String sqlName, com.accela.aa.wsquery.ParameterModel[] paramArray, int startRow, int endRow) throws java.rmi.RemoteException;
}
