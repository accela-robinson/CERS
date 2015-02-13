package com.accela.ws.service;

public class SSOProxy implements com.accela.ws.service.SSO {
  private String _endpoint = null;
  private com.accela.ws.service.SSO sSO = null;
  
  public SSOProxy() {
    _initSSOProxy();
  }
  
  public SSOProxy(String endpoint) {
    _endpoint = endpoint;
    _initSSOProxy();
  }
  
  private void _initSSOProxy() {
    try {
      sSO = (new com.accela.ws.service.SSOServiceLocator()).getSSOService();
      if (sSO != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sSO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sSO)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sSO != null)
      ((javax.xml.rpc.Stub)sSO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.accela.ws.service.SSO getSSO() {
    if (sSO == null)
      _initSSOProxy();
    return sSO;
  }
  
  public com.accela.ws.model.UserSessionImpl4WS signon4WS(java.lang.String systemID, java.lang.String domain, java.lang.String agencyID, java.lang.String userID, java.lang.String password) throws java.rmi.RemoteException{
    if (sSO == null)
      _initSSOProxy();
    return sSO.signon4WS(systemID, domain, agencyID, userID, password);
  }
  
  public java.lang.String signon(java.lang.String agencyID, java.lang.String userId, java.lang.String password) throws java.rmi.RemoteException{
    if (sSO == null)
      _initSSOProxy();
    return sSO.signon(agencyID, userId, password);
  }
  
  public java.lang.String authenticate(java.lang.String userId, java.lang.String ssoSessionId) throws java.rmi.RemoteException{
    if (sSO == null)
      _initSSOProxy();
    return sSO.authenticate(userId, ssoSessionId);
  }
  
  
}