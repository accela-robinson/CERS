package com.accela.ws.service;

public class GenericQueryProxy implements com.accela.ws.service.GenericQuery {
  private String _endpoint = null;
  private com.accela.ws.service.GenericQuery genericQuery = null;
  
  public GenericQueryProxy() {
    _initGenericQueryProxy();
  }
  
  public GenericQueryProxy(String endpoint) {
    _endpoint = endpoint;
    _initGenericQueryProxy();
  }
  
  private void _initGenericQueryProxy() {
    try {
      genericQuery = (new com.accela.ws.service.GenericQueryServiceLocator()).getGenericQueryService();
      if (genericQuery != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)genericQuery)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)genericQuery)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (genericQuery != null)
      ((javax.xml.rpc.Stub)genericQuery)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.accela.ws.service.GenericQuery getGenericQuery() {
    if (genericQuery == null)
      _initGenericQueryProxy();
    return genericQuery;
  }
  
  public com.accela.aa.wsquery.ReturnInfo query(java.lang.String sessionId, java.lang.String sqlName, com.accela.aa.wsquery.ParameterModel[] paramArray, int startRow, int endRow) throws java.rmi.RemoteException{
    if (genericQuery == null)
      _initGenericQueryProxy();
    return genericQuery.query(sessionId, sqlName, paramArray, startRow, endRow);
  }
  
  
}