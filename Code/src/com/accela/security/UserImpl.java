/**
 * UserImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.accela.security;

public class UserImpl  implements java.io.Serializable {
    private boolean active;

    private java.lang.String commonName;

    private java.lang.String distinguishedName;

    private java.lang.String distinguishedName4Display;

    private java.lang.String distinguishedName4Search;

    private java.lang.String domain;

    private java.lang.String employeeId;

    private java.lang.String firstName;

    private java.lang.String integratedFlag;

    private java.lang.String lastName;

    private java.lang.String mail;

    private java.lang.String middleName;

    private java.lang.String organizationId;

    private java.lang.String title;

    private java.lang.String userId;

    public UserImpl() {
    }

    public UserImpl(
           boolean active,
           java.lang.String commonName,
           java.lang.String distinguishedName,
           java.lang.String distinguishedName4Display,
           java.lang.String distinguishedName4Search,
           java.lang.String domain,
           java.lang.String employeeId,
           java.lang.String firstName,
           java.lang.String integratedFlag,
           java.lang.String lastName,
           java.lang.String mail,
           java.lang.String middleName,
           java.lang.String organizationId,
           java.lang.String title,
           java.lang.String userId) {
           this.active = active;
           this.commonName = commonName;
           this.distinguishedName = distinguishedName;
           this.distinguishedName4Display = distinguishedName4Display;
           this.distinguishedName4Search = distinguishedName4Search;
           this.domain = domain;
           this.employeeId = employeeId;
           this.firstName = firstName;
           this.integratedFlag = integratedFlag;
           this.lastName = lastName;
           this.mail = mail;
           this.middleName = middleName;
           this.organizationId = organizationId;
           this.title = title;
           this.userId = userId;
    }


    /**
     * Gets the active value for this UserImpl.
     * 
     * @return active
     */
    public boolean isActive() {
        return active;
    }


    /**
     * Sets the active value for this UserImpl.
     * 
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }


    /**
     * Gets the commonName value for this UserImpl.
     * 
     * @return commonName
     */
    public java.lang.String getCommonName() {
        return commonName;
    }


    /**
     * Sets the commonName value for this UserImpl.
     * 
     * @param commonName
     */
    public void setCommonName(java.lang.String commonName) {
        this.commonName = commonName;
    }


    /**
     * Gets the distinguishedName value for this UserImpl.
     * 
     * @return distinguishedName
     */
    public java.lang.String getDistinguishedName() {
        return distinguishedName;
    }


    /**
     * Sets the distinguishedName value for this UserImpl.
     * 
     * @param distinguishedName
     */
    public void setDistinguishedName(java.lang.String distinguishedName) {
        this.distinguishedName = distinguishedName;
    }


    /**
     * Gets the distinguishedName4Display value for this UserImpl.
     * 
     * @return distinguishedName4Display
     */
    public java.lang.String getDistinguishedName4Display() {
        return distinguishedName4Display;
    }


    /**
     * Sets the distinguishedName4Display value for this UserImpl.
     * 
     * @param distinguishedName4Display
     */
    public void setDistinguishedName4Display(java.lang.String distinguishedName4Display) {
        this.distinguishedName4Display = distinguishedName4Display;
    }


    /**
     * Gets the distinguishedName4Search value for this UserImpl.
     * 
     * @return distinguishedName4Search
     */
    public java.lang.String getDistinguishedName4Search() {
        return distinguishedName4Search;
    }


    /**
     * Sets the distinguishedName4Search value for this UserImpl.
     * 
     * @param distinguishedName4Search
     */
    public void setDistinguishedName4Search(java.lang.String distinguishedName4Search) {
        this.distinguishedName4Search = distinguishedName4Search;
    }


    /**
     * Gets the domain value for this UserImpl.
     * 
     * @return domain
     */
    public java.lang.String getDomain() {
        return domain;
    }


    /**
     * Sets the domain value for this UserImpl.
     * 
     * @param domain
     */
    public void setDomain(java.lang.String domain) {
        this.domain = domain;
    }


    /**
     * Gets the employeeId value for this UserImpl.
     * 
     * @return employeeId
     */
    public java.lang.String getEmployeeId() {
        return employeeId;
    }


    /**
     * Sets the employeeId value for this UserImpl.
     * 
     * @param employeeId
     */
    public void setEmployeeId(java.lang.String employeeId) {
        this.employeeId = employeeId;
    }


    /**
     * Gets the firstName value for this UserImpl.
     * 
     * @return firstName
     */
    public java.lang.String getFirstName() {
        return firstName;
    }


    /**
     * Sets the firstName value for this UserImpl.
     * 
     * @param firstName
     */
    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }


    /**
     * Gets the integratedFlag value for this UserImpl.
     * 
     * @return integratedFlag
     */
    public java.lang.String getIntegratedFlag() {
        return integratedFlag;
    }


    /**
     * Sets the integratedFlag value for this UserImpl.
     * 
     * @param integratedFlag
     */
    public void setIntegratedFlag(java.lang.String integratedFlag) {
        this.integratedFlag = integratedFlag;
    }


    /**
     * Gets the lastName value for this UserImpl.
     * 
     * @return lastName
     */
    public java.lang.String getLastName() {
        return lastName;
    }


    /**
     * Sets the lastName value for this UserImpl.
     * 
     * @param lastName
     */
    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }


    /**
     * Gets the mail value for this UserImpl.
     * 
     * @return mail
     */
    public java.lang.String getMail() {
        return mail;
    }


    /**
     * Sets the mail value for this UserImpl.
     * 
     * @param mail
     */
    public void setMail(java.lang.String mail) {
        this.mail = mail;
    }


    /**
     * Gets the middleName value for this UserImpl.
     * 
     * @return middleName
     */
    public java.lang.String getMiddleName() {
        return middleName;
    }


    /**
     * Sets the middleName value for this UserImpl.
     * 
     * @param middleName
     */
    public void setMiddleName(java.lang.String middleName) {
        this.middleName = middleName;
    }


    /**
     * Gets the organizationId value for this UserImpl.
     * 
     * @return organizationId
     */
    public java.lang.String getOrganizationId() {
        return organizationId;
    }


    /**
     * Sets the organizationId value for this UserImpl.
     * 
     * @param organizationId
     */
    public void setOrganizationId(java.lang.String organizationId) {
        this.organizationId = organizationId;
    }


    /**
     * Gets the title value for this UserImpl.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this UserImpl.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the userId value for this UserImpl.
     * 
     * @return userId
     */
    public java.lang.String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this UserImpl.
     * 
     * @param userId
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserImpl)) return false;
        UserImpl other = (UserImpl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.active == other.isActive() &&
            ((this.commonName==null && other.getCommonName()==null) || 
             (this.commonName!=null &&
              this.commonName.equals(other.getCommonName()))) &&
            ((this.distinguishedName==null && other.getDistinguishedName()==null) || 
             (this.distinguishedName!=null &&
              this.distinguishedName.equals(other.getDistinguishedName()))) &&
            ((this.distinguishedName4Display==null && other.getDistinguishedName4Display()==null) || 
             (this.distinguishedName4Display!=null &&
              this.distinguishedName4Display.equals(other.getDistinguishedName4Display()))) &&
            ((this.distinguishedName4Search==null && other.getDistinguishedName4Search()==null) || 
             (this.distinguishedName4Search!=null &&
              this.distinguishedName4Search.equals(other.getDistinguishedName4Search()))) &&
            ((this.domain==null && other.getDomain()==null) || 
             (this.domain!=null &&
              this.domain.equals(other.getDomain()))) &&
            ((this.employeeId==null && other.getEmployeeId()==null) || 
             (this.employeeId!=null &&
              this.employeeId.equals(other.getEmployeeId()))) &&
            ((this.firstName==null && other.getFirstName()==null) || 
             (this.firstName!=null &&
              this.firstName.equals(other.getFirstName()))) &&
            ((this.integratedFlag==null && other.getIntegratedFlag()==null) || 
             (this.integratedFlag!=null &&
              this.integratedFlag.equals(other.getIntegratedFlag()))) &&
            ((this.lastName==null && other.getLastName()==null) || 
             (this.lastName!=null &&
              this.lastName.equals(other.getLastName()))) &&
            ((this.mail==null && other.getMail()==null) || 
             (this.mail!=null &&
              this.mail.equals(other.getMail()))) &&
            ((this.middleName==null && other.getMiddleName()==null) || 
             (this.middleName!=null &&
              this.middleName.equals(other.getMiddleName()))) &&
            ((this.organizationId==null && other.getOrganizationId()==null) || 
             (this.organizationId!=null &&
              this.organizationId.equals(other.getOrganizationId()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId())));
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
        _hashCode += (isActive() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCommonName() != null) {
            _hashCode += getCommonName().hashCode();
        }
        if (getDistinguishedName() != null) {
            _hashCode += getDistinguishedName().hashCode();
        }
        if (getDistinguishedName4Display() != null) {
            _hashCode += getDistinguishedName4Display().hashCode();
        }
        if (getDistinguishedName4Search() != null) {
            _hashCode += getDistinguishedName4Search().hashCode();
        }
        if (getDomain() != null) {
            _hashCode += getDomain().hashCode();
        }
        if (getEmployeeId() != null) {
            _hashCode += getEmployeeId().hashCode();
        }
        if (getFirstName() != null) {
            _hashCode += getFirstName().hashCode();
        }
        if (getIntegratedFlag() != null) {
            _hashCode += getIntegratedFlag().hashCode();
        }
        if (getLastName() != null) {
            _hashCode += getLastName().hashCode();
        }
        if (getMail() != null) {
            _hashCode += getMail().hashCode();
        }
        if (getMiddleName() != null) {
            _hashCode += getMiddleName().hashCode();
        }
        if (getOrganizationId() != null) {
            _hashCode += getOrganizationId().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserImpl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://security.accela.com", "UserImpl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("active");
        elemField.setXmlName(new javax.xml.namespace.QName("", "active"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commonName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "commonName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distinguishedName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "distinguishedName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distinguishedName4Display");
        elemField.setXmlName(new javax.xml.namespace.QName("", "distinguishedName4Display"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distinguishedName4Search");
        elemField.setXmlName(new javax.xml.namespace.QName("", "distinguishedName4Search"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("domain");
        elemField.setXmlName(new javax.xml.namespace.QName("", "domain"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "employeeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firstName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("integratedFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "integratedFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("middleName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "middleName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("organizationId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "organizationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
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
