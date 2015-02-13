/**
 * UserSessionImpl4WS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.accela.ws.model;

public class UserSessionImpl4WS  implements java.io.Serializable {
    private com.accela.security.SessionImpl session;

    private java.util.Calendar sessionCreateTime;

    private java.util.Calendar sessionExpireTime;

    private boolean sessionExpired;

    private java.lang.String sessionId;

    private java.util.Calendar sessionLastAccessTime;

    private com.accela.security.UserImpl user;

    private java.lang.String userCommonName;

    private java.lang.String userDistinguishedName;

    private java.lang.String userDomain;

    private java.lang.String userId;

    private java.lang.String userOrganizationId;

    public UserSessionImpl4WS() {
    }

    public UserSessionImpl4WS(
           com.accela.security.SessionImpl session,
           java.util.Calendar sessionCreateTime,
           java.util.Calendar sessionExpireTime,
           boolean sessionExpired,
           java.lang.String sessionId,
           java.util.Calendar sessionLastAccessTime,
           com.accela.security.UserImpl user,
           java.lang.String userCommonName,
           java.lang.String userDistinguishedName,
           java.lang.String userDomain,
           java.lang.String userId,
           java.lang.String userOrganizationId) {
           this.session = session;
           this.sessionCreateTime = sessionCreateTime;
           this.sessionExpireTime = sessionExpireTime;
           this.sessionExpired = sessionExpired;
           this.sessionId = sessionId;
           this.sessionLastAccessTime = sessionLastAccessTime;
           this.user = user;
           this.userCommonName = userCommonName;
           this.userDistinguishedName = userDistinguishedName;
           this.userDomain = userDomain;
           this.userId = userId;
           this.userOrganizationId = userOrganizationId;
    }


    /**
     * Gets the session value for this UserSessionImpl4WS.
     * 
     * @return session
     */
    public com.accela.security.SessionImpl getSession() {
        return session;
    }


    /**
     * Sets the session value for this UserSessionImpl4WS.
     * 
     * @param session
     */
    public void setSession(com.accela.security.SessionImpl session) {
        this.session = session;
    }


    /**
     * Gets the sessionCreateTime value for this UserSessionImpl4WS.
     * 
     * @return sessionCreateTime
     */
    public java.util.Calendar getSessionCreateTime() {
        return sessionCreateTime;
    }


    /**
     * Sets the sessionCreateTime value for this UserSessionImpl4WS.
     * 
     * @param sessionCreateTime
     */
    public void setSessionCreateTime(java.util.Calendar sessionCreateTime) {
        this.sessionCreateTime = sessionCreateTime;
    }


    /**
     * Gets the sessionExpireTime value for this UserSessionImpl4WS.
     * 
     * @return sessionExpireTime
     */
    public java.util.Calendar getSessionExpireTime() {
        return sessionExpireTime;
    }


    /**
     * Sets the sessionExpireTime value for this UserSessionImpl4WS.
     * 
     * @param sessionExpireTime
     */
    public void setSessionExpireTime(java.util.Calendar sessionExpireTime) {
        this.sessionExpireTime = sessionExpireTime;
    }


    /**
     * Gets the sessionExpired value for this UserSessionImpl4WS.
     * 
     * @return sessionExpired
     */
    public boolean isSessionExpired() {
        return sessionExpired;
    }


    /**
     * Sets the sessionExpired value for this UserSessionImpl4WS.
     * 
     * @param sessionExpired
     */
    public void setSessionExpired(boolean sessionExpired) {
        this.sessionExpired = sessionExpired;
    }


    /**
     * Gets the sessionId value for this UserSessionImpl4WS.
     * 
     * @return sessionId
     */
    public java.lang.String getSessionId() {
        return sessionId;
    }


    /**
     * Sets the sessionId value for this UserSessionImpl4WS.
     * 
     * @param sessionId
     */
    public void setSessionId(java.lang.String sessionId) {
        this.sessionId = sessionId;
    }


    /**
     * Gets the sessionLastAccessTime value for this UserSessionImpl4WS.
     * 
     * @return sessionLastAccessTime
     */
    public java.util.Calendar getSessionLastAccessTime() {
        return sessionLastAccessTime;
    }


    /**
     * Sets the sessionLastAccessTime value for this UserSessionImpl4WS.
     * 
     * @param sessionLastAccessTime
     */
    public void setSessionLastAccessTime(java.util.Calendar sessionLastAccessTime) {
        this.sessionLastAccessTime = sessionLastAccessTime;
    }


    /**
     * Gets the user value for this UserSessionImpl4WS.
     * 
     * @return user
     */
    public com.accela.security.UserImpl getUser() {
        return user;
    }


    /**
     * Sets the user value for this UserSessionImpl4WS.
     * 
     * @param user
     */
    public void setUser(com.accela.security.UserImpl user) {
        this.user = user;
    }


    /**
     * Gets the userCommonName value for this UserSessionImpl4WS.
     * 
     * @return userCommonName
     */
    public java.lang.String getUserCommonName() {
        return userCommonName;
    }


    /**
     * Sets the userCommonName value for this UserSessionImpl4WS.
     * 
     * @param userCommonName
     */
    public void setUserCommonName(java.lang.String userCommonName) {
        this.userCommonName = userCommonName;
    }


    /**
     * Gets the userDistinguishedName value for this UserSessionImpl4WS.
     * 
     * @return userDistinguishedName
     */
    public java.lang.String getUserDistinguishedName() {
        return userDistinguishedName;
    }


    /**
     * Sets the userDistinguishedName value for this UserSessionImpl4WS.
     * 
     * @param userDistinguishedName
     */
    public void setUserDistinguishedName(java.lang.String userDistinguishedName) {
        this.userDistinguishedName = userDistinguishedName;
    }


    /**
     * Gets the userDomain value for this UserSessionImpl4WS.
     * 
     * @return userDomain
     */
    public java.lang.String getUserDomain() {
        return userDomain;
    }


    /**
     * Sets the userDomain value for this UserSessionImpl4WS.
     * 
     * @param userDomain
     */
    public void setUserDomain(java.lang.String userDomain) {
        this.userDomain = userDomain;
    }


    /**
     * Gets the userId value for this UserSessionImpl4WS.
     * 
     * @return userId
     */
    public java.lang.String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this UserSessionImpl4WS.
     * 
     * @param userId
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }


    /**
     * Gets the userOrganizationId value for this UserSessionImpl4WS.
     * 
     * @return userOrganizationId
     */
    public java.lang.String getUserOrganizationId() {
        return userOrganizationId;
    }


    /**
     * Sets the userOrganizationId value for this UserSessionImpl4WS.
     * 
     * @param userOrganizationId
     */
    public void setUserOrganizationId(java.lang.String userOrganizationId) {
        this.userOrganizationId = userOrganizationId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserSessionImpl4WS)) return false;
        UserSessionImpl4WS other = (UserSessionImpl4WS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.session==null && other.getSession()==null) || 
             (this.session!=null &&
              this.session.equals(other.getSession()))) &&
            ((this.sessionCreateTime==null && other.getSessionCreateTime()==null) || 
             (this.sessionCreateTime!=null &&
              this.sessionCreateTime.equals(other.getSessionCreateTime()))) &&
            ((this.sessionExpireTime==null && other.getSessionExpireTime()==null) || 
             (this.sessionExpireTime!=null &&
              this.sessionExpireTime.equals(other.getSessionExpireTime()))) &&
            this.sessionExpired == other.isSessionExpired() &&
            ((this.sessionId==null && other.getSessionId()==null) || 
             (this.sessionId!=null &&
              this.sessionId.equals(other.getSessionId()))) &&
            ((this.sessionLastAccessTime==null && other.getSessionLastAccessTime()==null) || 
             (this.sessionLastAccessTime!=null &&
              this.sessionLastAccessTime.equals(other.getSessionLastAccessTime()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.userCommonName==null && other.getUserCommonName()==null) || 
             (this.userCommonName!=null &&
              this.userCommonName.equals(other.getUserCommonName()))) &&
            ((this.userDistinguishedName==null && other.getUserDistinguishedName()==null) || 
             (this.userDistinguishedName!=null &&
              this.userDistinguishedName.equals(other.getUserDistinguishedName()))) &&
            ((this.userDomain==null && other.getUserDomain()==null) || 
             (this.userDomain!=null &&
              this.userDomain.equals(other.getUserDomain()))) &&
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId()))) &&
            ((this.userOrganizationId==null && other.getUserOrganizationId()==null) || 
             (this.userOrganizationId!=null &&
              this.userOrganizationId.equals(other.getUserOrganizationId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getSession() != null) {
            _hashCode += getSession().hashCode();
        }
        if (getSessionCreateTime() != null) {
            _hashCode += getSessionCreateTime().hashCode();
        }
        if (getSessionExpireTime() != null) {
            _hashCode += getSessionExpireTime().hashCode();
        }
        _hashCode += (isSessionExpired() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSessionId() != null) {
            _hashCode += getSessionId().hashCode();
        }
        if (getSessionLastAccessTime() != null) {
            _hashCode += getSessionLastAccessTime().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getUserCommonName() != null) {
            _hashCode += getUserCommonName().hashCode();
        }
        if (getUserDistinguishedName() != null) {
            _hashCode += getUserDistinguishedName().hashCode();
        }
        if (getUserDomain() != null) {
            _hashCode += getUserDomain().hashCode();
        }
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        if (getUserOrganizationId() != null) {
            _hashCode += getUserOrganizationId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserSessionImpl4WS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.ws.accela.com", "UserSessionImpl4WS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("session");
        elemField.setXmlName(new javax.xml.namespace.QName("", "session"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://security.accela.com", "SessionImpl"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionCreateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sessionCreateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionExpireTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sessionExpireTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionExpired");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sessionExpired"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sessionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionLastAccessTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sessionLastAccessTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://security.accela.com", "UserImpl"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userCommonName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userCommonName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userDistinguishedName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userDistinguishedName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userDomain");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userDomain"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userOrganizationId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userOrganizationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
