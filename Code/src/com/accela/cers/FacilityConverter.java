package com.accela.cers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.accela.adapter.constants.AdapterConstants;
import com.accela.adapter.model.Address.AddressLines;
import com.accela.adapter.model.Address.Addresses;
import com.accela.adapter.model.Address.DetailAddress;
import com.accela.adapter.model.Address.DetailAddresses;
import com.accela.adapter.model.Address.ElectronicMailAddresses;
import com.accela.adapter.model.Address.PostalAddress;
import com.accela.adapter.model.Address.TelecomAddress;
import com.accela.adapter.model.cap.CAP;
import com.accela.adapter.model.cap.CAPDetail;
import com.accela.adapter.model.cap.CAPId;
import com.accela.adapter.model.cap.InitiateCAP;
import com.accela.adapter.model.common.AdditionalInformation;
import com.accela.adapter.model.common.AdditionalInformationGroup;
import com.accela.adapter.model.common.AdditionalInformationSubGroup;
import com.accela.adapter.model.common.AdditionalItem;
import com.accela.adapter.model.common.AdditionalItems;
import com.accela.adapter.model.common.DataType;
import com.accela.adapter.model.common.FacsimileNumbers;
import com.accela.adapter.model.common.InputRange;
import com.accela.adapter.model.common.Keys;
import com.accela.adapter.model.common.ParcelId;
import com.accela.adapter.model.common.ParcelIds;
import com.accela.adapter.model.contact.ActorRole;
import com.accela.adapter.model.contact.Contact;
import com.accela.adapter.model.contact.Contacts;
import com.accela.adapter.model.contact.License;
import com.accela.adapter.model.contact.Licenses;
import com.accela.adapter.model.contact.Organization;
import com.accela.adapter.model.contact.PersonAndOrganization;
import com.accela.adapter.model.contact.Roles;
import com.accela.adapter.model.contact.TelephoneNumbers;
import com.accela.adapter.model.contact.TheOrganization;
import com.accela.adapter.model.contact.ThePerson;
import com.accela.adapter.model.function.UpdateCAP;
import com.accela.adapter.service.impl.AuthService;
import com.accela.adapter.service.impl.CapServiceCommon;
import com.accela.adapter.util.CapUtil;
import com.accela.cers.cap.model.BusinessActivitiesType;
import com.accela.cers.cap.model.ChemicalType;
import com.accela.cers.cap.model.FacilityInformationType;
import com.accela.cers.cap.model.FacilitySubmittalType;
import com.accela.cers.cap.model.HWCertificationOfFinancialAssuranceType;
import com.accela.cers.cap.model.HWCertificationOfFinancialAssurancesType;
import com.accela.cers.cap.model.HWFacilityType;
import com.accela.cers.cap.model.HazardousMaterialsInventoryType;
import com.accela.cers.cap.model.OwnerOperatorInformationType;
import com.accela.cers.cap.model.RWConsolidationSiteType;
import com.accela.cers.cap.model.RWConsolidationSitesType;
import com.accela.cers.cap.model.SubmittalElementHeaderType;
import com.accela.cers.cap.model.USTCertificationOfInstallationModificationType;
import com.accela.cers.cap.model.USTFacilityInformationType;
import com.accela.cers.cap.model.USTTankType;
import com.accela.cers.cap.model.USTTanksType;
import com.accela.cers.cap.model.UndergroundStorageTanksType;
import com.accela.cers.cap.model.USTFacilityInformationType.FRCodeOther;
import com.ifcXML.ifc2x.Person;

/**
 * <pre>
 *
 *  Accela Automation
 *  File: FacilityConverter.java
 *
 *  Accela, Inc.
 *  Copyright (C): 2012-2014
 *
 *  Description:
 *  TODO
 *
 *  Notes:
 * 	$Id: FacilityConverter.java 72642 2009-01-01 20:01:57Z ACHIEVO\zony.rao $
 *
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2012-11-28		zony.rao		Initial.
 *
 * </pre>
 */
// Existing
public class FacilityConverter extends ICAPConvert
{
	private static final Log LOGGER = LogFactory.getLog(FacilityConverter.class);
	private Map<String, String> countrys = null;
	private static String[] submittalElementType = new String[9];
	static
	{
		submittalElementType[0] = "Facility";
		submittalElementType[1] = "Inventory";
		submittalElementType[2] = "Plans";
		submittalElementType[3] = "UST";
		submittalElementType[4] = "TP";
		submittalElementType[5] = "RMR";
		submittalElementType[6] = "Remote";
		submittalElementType[7] = "Tank";
		submittalElementType[8] = "APSA";
	}

	@SuppressWarnings("unchecked")
	public InitiateCAP convertToInitCAP(List<AdditionalInformation> additionInfos, Object currObject, String strDataSetDateTime,Object... objects)

	{
		FacilitySubmittalType facilitySubmittalType = (FacilitySubmittalType) currObject;
		List<AdditionalInformation> addInfos = additionInfos;

		InitiateCAP initCap = new InitiateCAP();
		initCap.setCAPTypeId(CapUtil.getCapTypeIdByString("Facility"));
		initCap.setSystem(AuthService.getSystem());
		initCap.setFinalizeNow(true);
		countrys = (Map<String, String>) objects[0];
		AdditionalInformation addCopy = addInfos.get(0).clone();
		initCap.setAdditionalInformation(addCopy);

		for (AdditionalInformationGroup ag : addCopy.getAdditionalInformationGroup())
		{
			List<AdditionalInformationSubGroup> ags = ag.getAdditionalInformationSubGroup();
			for (AdditionalInformationSubGroup asg : ags)
			{
				if (ag.isAddRemoveSubGroups())
				{ // asit
					asg.setAction("Add");
				}
				else
				// asi
				{
					for (AdditionalItem ai : asg.getAdditionalItems().getAdditionalItem())
					{
						ai.setAction("Add");
					}
				}

			}

		}
		/**
		 * set information.
		 */
		initCap.setShortNotes(facilitySubmittalType.getCERSID() + "");
		initCap.setStatus(CapUtil.getDefaultStatusByCapType(cb.get("Facility.capType")));
		// facilitySubmittalType.getFacilityInformation().getBusinessActivities().getBusinessName()
		if (facilitySubmittalType.getFacilityInformation() != null
				&& facilitySubmittalType.getFacilityInformation().getBusinessActivities() != null)
		{
			initCap.setName(facilitySubmittalType.getFacilityInformation().getBusinessActivities().getBusinessName());
		}
		
		// set Address
		if ( AdapterConstants.SYNC_ADDRESS )
		{
			DetailAddresses dar = new DetailAddresses();
			initCap.setDetailAddresses(dar);
			setAddress(facilitySubmittalType, dar);
		}
		
		// set name
		// initCap.setName(bas.getBusinessName());
		// set contract something wrong.
		Contacts contacts = new Contacts();
		initCap.setContacts(contacts);
		
		// set parcel
		if ( AdapterConstants.SYNC_PARCEL ) {
			OwnerOperatorInformationType ooi = facilitySubmittalType.getFacilityInformation().getOwnerOperatorInformation();
			if(ooi!=null){
				if ( ooi.getAssessorParcelNumber() != null && ooi.getAssessorParcelNumber().length() > 0 ) {
					ParcelIds pids=new ParcelIds();
					ParcelId pid=new ParcelId();
					Keys keys=new Keys();
					keys.getKey().add(ooi.getAssessorParcelNumber());
					pid.setKeys(keys);
					pid.setValue(ooi.getAssessorParcelNumber());
					pid.setIdentifierDisplay(ooi.getAssessorParcelNumber());
					pids.getParcelId().add(pid);
					initCap.setParcelIds(pids);
				}
			}
		}

		setContact(facilitySubmittalType, contacts, false);
		setContactUnderStorage(facilitySubmittalType, contacts, false);
		// asi deal
		List<AdditionalInformationGroup> addInfoGroup = initCap.getAdditionalInformation()
				.getAdditionalInformationGroup();
		AdditionalInformationSubGroup addSubGroup = (AdditionalInformationSubGroup) getAddInfoSubGroup(addInfoGroup,
			"DEH_HUPF_T27", "CERS COLLECTED INFO")[1];
		setFiciliyAsi(addSubGroup, facilitySubmittalType);

		// Eric fixed to add facility ASIT for "Data Exchange Details"
		setFiciliyAsit(facilitySubmittalType, addInfoGroup, false,strDataSetDateTime, null);

		// asit deal
		setChemicalAsit(facilitySubmittalType, addInfoGroup, false);
		// Remote Waste Consolidation Site Annual Notification asit --Hazardous Waste
		setHazarousWasteAsit(addInfoGroup, facilitySubmittalType, false);
		// #Certification Of Financial Assurance /Onsite Hazardous Waste Treatment Notification - Facility asi
		setHazarousWasteAsi(addInfoGroup, facilitySubmittalType);
		// #UST Operating Permit Application - Facility Information
		setUstAsi(addInfoGroup, facilitySubmittalType);

		// #UST Certification of Installation / Modification asit
		setUstAsit(addInfoGroup, facilitySubmittalType, false);
		List<AdditionalInformationGroup> group = initCap.getAdditionalInformation().getAdditionalInformationGroup();
		String needUpdatedASITName= (String)cb.get("NeedUpdatedASIT4Facility");
		AdditionalInformationGroup ag = null;
		for (int i = group.size() - 1; i >= 0; i--)
		{
			ag = group.get(i);
			String identifierDisplay = ag.getIdentifierDisplay();
			if (!needUpdatedASITName.contains(identifierDisplay))
			{
				group.remove(i);
			}
		}
		return initCap;

	}

	private void setAddress(FacilitySubmittalType facilitySubmittalType, DetailAddresses dar)
	{
		FacilityInformationType faciInfo = facilitySubmittalType.getFacilityInformation();
		BusinessActivitiesType bas = faciInfo.getBusinessActivities();
		// set address info

		DetailAddress ba = new DetailAddress();
		ba.setCity(bas.getCity());
		ba.setPostalCode(bas.getZipCode());
		//Eric 02/01/2013, just only populate to ASI (Site Address (103))
		//ba.setStreetName(bas.getSiteAddress());
		dar.setDetailAddress(ba);
	}

	private Contact createContact(String type, String B1_ADDRESS1, String B1_ZIP, String B1_CITY, String B1_PHONE,
			String B1_PHONE1, String B1_PHONE2, String B1_FAX, String B1_EMAIL, String B1_FULL_NAME,
			String B1_BUSSINESS_NAME, String B1_LIC_NUMBER, String Bi_bus_lic, String b1_state, String b1_country,
			String b1_linces, String title, String comment, boolean isUpdate)
	{
		if (isEmptyValue(B1_ADDRESS1) && isEmptyValue(B1_ZIP) && isEmptyValue(B1_CITY) && isEmptyValue(B1_PHONE)
				&& isEmptyValue(B1_PHONE1) && isEmptyValue(B1_PHONE2) && isEmptyValue(B1_FAX) && isEmptyValue(B1_EMAIL)
				&& isEmptyValue(B1_FULL_NAME) && isEmptyValue(B1_BUSSINESS_NAME) && isEmptyValue(Bi_bus_lic)
				&& isEmptyValue(b1_state) && isEmptyValue(b1_country) && isEmptyValue(title) && isEmptyValue(comment))
		{
			return null;
		}
		Contact contact = new Contact();
		if (isUpdate)
		{
			contact.setAction("Add");

		}
		else
		{
			contact.setAction("Add");
		}
		if ("OWNER".equals(type))
		{
			Keys keys = new Keys();
			keys.getKey().add("OWNER");
			contact.setKeys(keys);
			contact.setIsPrimary(true);
		}
		else
		{
			Keys keys = new Keys();
			if (B1_LIC_NUMBER != null && b1_linces != null)
			{
				keys.getKey().add("License");
			}
			else
			{
				keys.getKey().add("Contact");
			}
			contact.setKeys(keys);
			contact.setIsPrimary(false);
		}

		Person person = new Person();

		Roles roles = new Roles();
		ActorRole actorRole = new ActorRole();
		// userDefinedRole
		actorRole.setUserDefinedRole(type);
		roles.setActorRole(actorRole);
		person.setRoles(roles);
		// postalAddress
		Addresses addresses = new Addresses();
		person.setAddresses(addresses);
		PostalAddress postalAddress = new PostalAddress();

		addresses.setPostalAddress(postalAddress);
		AddressLines addressLines = new AddressLines();

		postalAddress.setAddressLines(addressLines);
		if (title != null)
		{
			person.setOwnerTitle(title);

		}
		if (comment != null)
		{
			person.setComment(comment);
		}
		if (b1_state != null)
		{
			postalAddress.setRegion(b1_state);

		}
		if (B1_ZIP != null)
		{
			postalAddress.setPostalCode(B1_ZIP);
		}
		if (B1_CITY != null)
		{
			postalAddress.setTown(B1_CITY);
		}
		if (b1_country != null)
		{
			postalAddress.setCountry(b1_country.trim());
			person.setCountryCode(countrys.get(b1_country.trim()));
		}
		if (B1_ADDRESS1 != null)
		{
			addressLines.getString().add(B1_ADDRESS1);
		}

		// set TelecomAddress
		TelecomAddress teleAddress = new TelecomAddress();
		addresses.setTelecomAddress(teleAddress);
		TelephoneNumbers tln = new TelephoneNumbers();
		teleAddress.setTelephoneNumbers(tln);
		// model should have three phones.
		if (B1_PHONE != null)
		{
			tln.getString().add(B1_PHONE);
		}
		if (B1_PHONE1 != null)
		{
			tln.getString().add(B1_PHONE1);
		}
		if (B1_PHONE2 != null)
		{
			tln.getString().add(B1_PHONE2);
		}
		// set facsimileNumbers
		FacsimileNumbers fn = new FacsimileNumbers();
		teleAddress.setFacsimileNumbers(fn);
		Long longfax = parseLong(clear(B1_FAX, "-"));
		if (longfax != null)
		{
			fn.setString(longfax);
		}

		//
		ElectronicMailAddresses ema = new ElectronicMailAddresses();
		if (B1_EMAIL != null)
		{
			ema.getString().add(B1_EMAIL);
			teleAddress.setElectronicMailAddresses(ema);
		}

		person.setFullName(B1_FULL_NAME);
		// TheOrganization
		if (B1_BUSSINESS_NAME != null || Bi_bus_lic != null)
		{
			PersonAndOrganization pao = new PersonAndOrganization();
			ThePerson tp = new ThePerson();
			pao.setThePerson(tp);
			contact.setPersonAndOrganization(pao);
			tp.setPerson(person);
			TheOrganization theo = new TheOrganization();
			Organization or = new Organization();
			theo.setOrganization(or);
			or.setName(B1_BUSSINESS_NAME);
			or.setId(Bi_bus_lic);
			pao.setTheOrganization(theo);

			contact.setPersonAndOrganization(pao);
		}
		else
		{
			contact.setPerson(person);
		}
		if (B1_LIC_NUMBER != null && b1_linces != null)
		{
			License license = new License();
			license.setAction("Add");
			license.setLicenseType(b1_linces);
			license.setLicenseNumber(B1_LIC_NUMBER);
			Licenses licenses = new Licenses();
			licenses.setLicense(license);
			contact.setLicenses(licenses);
			Keys keys = new Keys();
			keys.getKey().add(B1_LIC_NUMBER);
		}
		
		if ("DEH Emergency Contact".equals(type) || "DEH Emergency Contact Secondary".equals(type))
		{
			String templateName = "DEH Emergency Contact";
			String fieldName = "HMD Emergency Contact";
			AdditionalInformation additionalInformantion = null;
			if ("DEH Emergency Contact".equals(type))
			{
				additionalInformantion = buildContactTemplate(templateName,fieldName,"Primary Emergency Contact");
			}
			else if ("DEH Emergency Contact Secondary".equals(type))
			{
				additionalInformantion = buildContactTemplate(templateName,fieldName,"Secondary Emergency Contact");
				contact.getPerson().getRoles().getActorRole().setUserDefinedRole("DEH Emergency Contact");
			}
			contact.setAdditionalInformation(additionalInformantion);
		}
		
		if ("DEH Billing Contact".equals(type))
		{
			contact.setIsPrimary(true);
		}
		return contact;

	}

	/**
	 *
	 *
	 * @param facilitySubmittalType
	 * @param initCap
	 */
	private void setContactUnderStorage(FacilitySubmittalType facilitySubmittalType, Contacts contcts, boolean isUpdate)
	{

		List<Contact> contacts = contcts.getContact();
		UndergroundStorageTanksType ust = facilitySubmittalType.getUndergroundStorageTanks();
		if (ust != null && ust.getUSTCertificationOfInstallationModifications() != null)
		{
			List<USTCertificationOfInstallationModificationType> ustUms = ust
					.getUSTCertificationOfInstallationModifications().getUSTCertificationOfInstallationModification();
			if (ustUms != null)
			{
				String strCRelationship="";
				for (USTCertificationOfInstallationModificationType ustUm : ustUms)
				{					
					//Add the field b1_license_nbr,B1_BUS_LIC,B1_BUS_NAME into CONTRA for LP.
					//COSD revisit the mapping once again and decide not to map ICC number to professional any more.
//					Contact contact1 = createContact("", null, null, null, ustUm.getPhoneNumber(),
//						null, null, null, null, ustUm.getCertifierName(),
//						ustUm.getNameContractorInstallation(), ustUm.getCLicenseNumber(), ustUm.getICCCertNumber(), null, null,
//						"Contractor",  ustUm.getCertifierTitle(), null, isUpdate);  
//					contacts.add(contact1);

					//Eric 01/31/2013
					strCRelationship=getDropdownValue(ustUm.getCertifierRelationship()==null ? "" :ustUm.getCertifierRelationship().getValue(),"CertifierRelationship");
					Contact contact = createContact("CERTIFIER", null, null, null, ustUm.getPhoneNumber(), 
						null, null, null, null, ustUm.getCertifierName(), 
						ustUm.getNameCertifierEmployer(), null, null, null, null,
						null, ustUm.getCertifierTitle(), strCRelationship, isUpdate);
					contacts.add(contact);
				}

			}
		}

		if (facilitySubmittalType.getUndergroundStorageTanks() != null)
		{
			USTFacilityInformationType ustt = facilitySubmittalType.getUndergroundStorageTanks()
					.getUSTFacilityInformation();
			if (ustt != null)
			{
				/**
				 * POCountry B3OWNERS B1_MAIL_COUNTRY POState B3OWNERS B1_MAIL_STATE
				 */
				if (AdapterConstants.SYNC_OWNER )
				{
					Contact contact1 = createContact("OWNER", ustt.getPOMailingAddress(), ustt.getPOZipCode(), ustt.getPOCity(), ustt.getPOPhone(), 
						null, null, null, null, ustt.getPOName(), 
						null, null, null, ustt.getPOState(), ustt.getPOCountry(), 
						null, null, null, isUpdate);
					contacts.add(contact1);
				}
				/**
				 * TOwnerState B3CONTACT B1_STATE TOwnerCountry B3CONTACT B1_COUNTRY TOwnerType B3CONTACT B1_COMMENT
				 */
				Contact contact2 = createContact("DEH Tank Owner", ustt.getTOwnerMailingAddress(), ustt.getTOwnerZipCode(),	ustt.getTOwnerCity(),ustt.getTOwnerPhone(),
					null, null, null, null,ustt.getTOwnerName(),
					null, null, null, ustt.getTOwnerState(), ustt.getTOwnerCountry(), 
					null, null,ustt.getTOwnerType(), isUpdate);
				if(contact2 != null)
				{
					String templateName = "DEH TANK OWNER";
					String fieldName = "TANK OWNER TYPE (420)";
					AdditionalInformation additionalInformantion = null;
					additionalInformantion = buildContactTemplate(templateName, fieldName, getDropdownValue(ustt
							.getTOwnerType(), "TankOwnerType420"));
					contact2.setAdditionalInformation(additionalInformantion);
				}
				contacts.add(contact2);
				/*
				 * ApplicantTitle B3CONTACT B1_TITLE TankOperatorState B3CONTACT B1_STATE TankOperatorCountry B3CONTACT
				 * B1_COUNTRY
				 */
				Contact contact3 = createContact("DEH UST Applicant", null, null, null, ustt.getApplicantPhone(), 
					null, null, null, null, ustt.getApplicantName(), 
					null, null, null, null, null, 
					null, ustt.getApplicantTitle(), null, isUpdate);
				if(contact3 != null)
				{
					String templateName = "DEH UST APPLICANT";
					String fieldName = "DATE CERTIFIED (424)";
					AdditionalInformation additionalInformantion = null;
					String dateCertified = toString(ustt.getDateCertified());
					dateCertified = parseDateByPattern(dateCertified,"MM/dd/yyyy");
					additionalInformantion = buildContactTemplate(templateName, fieldName, dateCertified);
					contact3.setAdditionalInformation(additionalInformantion);
				}
				contacts.add(contact3);
				JAXBElement<String> country = ustt.getTankOperatorCountry();
				String value = null;
				if (country != null)
				{
					value = country.getValue();
				}
				Contact contact4 = createContact("DEH Tank Operator", ustt.getTankOperatorMailingAddress(),	ustt.getTankOperatorZipCode(), ustt.getTankOperatorCity(),	ustt.getTankOperatorPhone(), 
					null, null, null, null, ustt.getTankOperatorName(),
					null, null, null, ustt.getTankOperatorState(), value, 
					null, null, null, isUpdate);
				contacts.add(contact4);
			}
		}
	}

	private void setContact(FacilitySubmittalType facilitySubmittalType, Contacts contacts, boolean isUpdate)
	{
		OwnerOperatorInformationType ooi = facilitySubmittalType.getFacilityInformation().getOwnerOperatorInformation();
		List<Contact> licon = new ArrayList<Contact>();
		/**
		 * //main 1 contact type="owner"
		 */
		/**
		 * String type, String addressLines, String postalCode, String town, String telephoneNumbers1,String
		 * telephoneNumbers2, String telephoneNumbers3, String facsimileNumbers, String electronicMailAddresses, String
		 * fullName,String Organization.name, String licenseNumber
		 */
		if ( AdapterConstants.SYNC_OWNER )
		{
			Contact contact1 = createContact("OWNER", ooi.getPropertyOwnerMailingAddress(), ooi.getPropertyOwnerZipCode(), 
				ooi.getPropertyOwnerCity(), ooi.getPropertyOwnerPhone(), 
				null, null, null,null, ooi.getPropertyOwnerName(),
				null, null, null, ooi.getPropertyOwnerState(), ooi.getPropertyOwnerCountry(),
				null, null, null, isUpdate);
			licon.add(contact1);
		}
		
		/**
		 * 2 contact type='DEH Mailing Address'
		 */
		Contact contact2 = createContact("DEH Mailing Address", ooi.getMailingAddress(),
			ooi.getMailingAddressZipCode(), ooi.getMailingAddressCity(), null, 
			null, null, null, null, null, 
			null, null, null, ooi.getMailingAddressState(),null,
			null, null, null, isUpdate);

		licon.add(contact2);
		/**
		 * 3 type= 'DEH Business Owner'
		 */

		Contact contact3 = createContact("DEH Business Owner", ooi.getOwnerMailAddress(), 
			ooi.getOwnerZipCode(), ooi.getOwnerCity(), ooi.getOwnerPhone(), 
			null, null, null, null, ooi.getOwnerName(), 
			null, null, null, ooi.getOwnerState(), ooi.getOwnerCountry(), 
			null, null, null, isUpdate);

		// electronicMailAddresses no.
		licon.add(contact3);

		/**
		 * 4 B1_CONTACT_TYPE = 'DEH Environmental Contact'
		 */
		Contact contact4 = createContact("DEH Environmental Contact", ooi.getEContactMailingAddress(),
			ooi.getEContactZipCode(), ooi.getEContactCity(), ooi.getEContactPhone(), 
			null, null, null, ooi.getEContactEmailAddress(), ooi.getEContactName(),
			null, null, null, ooi.getEContactState(), ooi.getEContactCountry(),
			null, null, null, isUpdate);

		licon.add(contact4);

		/**
		 * 5 B1_CONTACT_TYPE = 'DEH Emergency Contact'
		 */
		Contact contact5 = createContact("DEH Emergency Contact", null, null, null, ooi.getPECBusinessPhone(),
			ooi.getPEC24HrPhone(), null,  ooi.getPECPager(), null, ooi.getPECName(), 
			null, null, null, null, null,
			null, ooi.getPECTitle(), null, isUpdate);

		licon.add(contact5);

		/**
		 * 7 B1_CONTACT_TYPE = 'DEH Emergency Contact Secondary'
		 */
		Contact contact7 = createContact("DEH Emergency Contact Secondary", null, null, null, ooi.getSECBusinessPhone(),
			ooi.getSEC24HrPhone(), null,  ooi.getSECPager(), null, ooi.getSECName(), 
			null, null, null, null, null, 
			null, ooi.getSECTitle(), null, isUpdate);

		licon.add(contact7);

		/**
		 * 6 B1_CONTACT_TYPE = 'DEH Billing Contact'
		 */

		Contact contact6 = createContact("DEH Billing Contact", ooi.getBillingAddress(),
			ooi.getBillingAddressZipCode(), ooi.getBillingAddressCity(), ooi.getBillingContactPhone(),
			null, null, null, ooi.getBillingContactEmail(), ooi.getBillingContactName(), 
			null, null, null, ooi.getBillingAddressState(), ooi.getBillingAddressCountry(),
			null, null, null, isUpdate);

		licon.add(contact6);
		// address is wrong, why?


		/**
		 * 8 B1_CONTACT_TYPE = 'DEH  Business Owner/Operator'
		 */
		Contact contact8 = createContact("DEH Business Owner/Operator", null, null, null, ooi.getPhone(),
			ooi.getOperatorPhone(), null, ooi.getFax(), null, ooi.getOperatorName(), 
			null, null, null, null,null,
			null, null, null, isUpdate);

		licon.add(contact8);
		contacts.getContact().addAll(licon);

	}

	private void setFiciliyAsi(AdditionalInformationSubGroup addSubGroup, FacilitySubmittalType facilitySubmittalType)
	{
		OwnerOperatorInformationType ooi = facilitySubmittalType.getFacilityInformation().getOwnerOperatorInformation();
		FacilityInformationType faciInfo = facilitySubmittalType.getFacilityInformation();
		BusinessActivitiesType bas = faciInfo.getBusinessActivities();
		AdditionalItems addItems = addSubGroup.getAdditionalItems();
		setValue(getAddItem(cb.get("CERSID"), addItems), facilitySubmittalType.getCERSID());
		// setValue(getAddItem(cb.get("ShortNote"), addItems), facilitySubmittalType.getCERSID());
		setValue(getAddItem(cb.get("FacilityID"), addItems), facilitySubmittalType.getFacilityID());
		
		boolean facilityStatusFlag = CapUtil.getStatusFlag(facilitySubmittalType, CapUtil.FACILITY_STATUS);
		if(facilityStatusFlag)
		{

			setValue(getAddItem(cb.get("EPAID"), addItems), bas.getEPAID());
			// need to deal yes or no type;
			setValue(getAddItem(cb.get("SiteAddress"), addItems), bas.getSiteAddress());
			setValue(getAddItem(cb.get("HMOnSite"), addItems), bas.getHMOnSite());
			setValue(getAddItem(cb.get("CalARPRegulatedSubstances"), addItems), bas.getCalARPRegulatedSubstances());
			setValue(getAddItem(cb.get("OwnOrOperateUST"), addItems), bas.getOwnOrOperateUST());
			setValue(getAddItem(cb.get("OwnOrOperateAPST"), addItems), bas.getOwnOrOperateAPST());
			setValue(getAddItem(cb.get("HWGenerator"), addItems), bas.getHWGenerator());
			setValue(getAddItem(cb.get("Recycle"), addItems), bas.getRecycle());
			setValue(getAddItem(cb.get("OnsiteHWTreatment_11"), addItems), bas.getOnsiteHWTreatment() == null ? "" : bas.getOnsiteHWTreatment().getValue());
			setValue(getAddItem(cb.get("FinancialAssurance"), addItems), bas.getFinancialAssurance());
			setValue(getAddItem(cb.get("RWConsolidationSite"), addItems), bas.getRWConsolidationSite());
			setValue(getAddItem(cb.get("HWTankClosure"), addItems), bas.getHWTankClosure());
			setValue(getAddItem(cb.get("RCRALargeQuantityGenerator"), addItems), bas.getRCRALargeQuantityGenerator());
			setValue(getAddItem(cb.get("HHWCollection"), addItems), bas.getHHWCollection());
			setValue(getAddItem(cb.get("Comments"), addItems), bas.getComments());

			// USE$$DEH_HUPF_T27$$LUEG-DEH/HMD/UPFP/Facility
			setValue(getAddItem(cb.get("BeginningDate"), addItems), ooi.getBeginningDate());
			setValue(getAddItem(cb.get("EndingDate"), addItems), ooi.getEndingDate());
			// NumberOfEmployees
			setValue(getAddItem(cb.get("NumberOfEmployees"), addItems), ooi.getNumberOfEmployees());
			// 5/9/2013, change request from COSD: expecting to see 37 as the County ID. We would also need to push this
		//setDropdownValue(String.valueOf(bas.getCountyID() == null ? "" : bas.getCountyID()), "CountyID", addItems);
			setValue(getAddItem(cb.get("CountyID"), addItems), bas.getCountyID());

			setValue(getAddItem(cb.get("DunAndBradstreet"), addItems), ooi.getDunAndBradstreet());
			setValue(getAddItem(cb.get("SICCode"), addItems), ooi.getSICCode());
			setValue(getAddItem(cb.get("NAICSCode"), addItems), ooi.getNAICSCode());
			setValue(getAddItem(cb.get("IdentificationSignedDate"), addItems), ooi.getIdentificationSignedDate());
			setValue(getAddItem(cb.get("DocumentPreparerName"), addItems), ooi.getDocumentPreparerName());
			setValue(getAddItem(cb.get("IdentificationSignerName"), addItems), ooi.getIdentificationSignerName());
			setValue(getAddItem(cb.get("IdentificationSignerTitle"), addItems), ooi.getIdentificationSignerTitle());
		}
		else
		{
			aisCodeAndType = "DEH_HUPF_T27|CERS COLLECTED INFO|";
			if (asiValueMap == null || asiValueMap.size() == 0)
			{
				return;
			}
			setValue(getAddItem(cb.get("EPAID"), addItems), asiValueMap.get(aisCodeAndType+cb.get("EPAID")));
			// need to deal yes or no type;
			setValue(getAddItem(cb.get("SiteAddress"), addItems), asiValueMap.get(aisCodeAndType+cb.get("SiteAddress")));
			setValue(getAddItem(cb.get("HMOnSite"), addItems), asiValueMap.get(aisCodeAndType+cb.get("HMOnSite")));
			setValue(getAddItem(cb.get("CalARPRegulatedSubstances"), addItems), asiValueMap.get(aisCodeAndType+cb.get("CalARPRegulatedSubstances")));
			setValue(getAddItem(cb.get("OwnOrOperateUST"), addItems), asiValueMap.get(aisCodeAndType+cb.get("OwnOrOperateUST")));
			setValue(getAddItem(cb.get("OwnOrOperateAPST"), addItems), asiValueMap.get(aisCodeAndType+cb.get("OwnOrOperateAPST")));
			setValue(getAddItem(cb.get("HWGenerator"), addItems), asiValueMap.get(aisCodeAndType+cb.get("HWGenerator")));
			setValue(getAddItem(cb.get("Recycle"), addItems), asiValueMap.get(aisCodeAndType+cb.get("Recycle")));
			setValue(getAddItem(cb.get("OnsiteHWTreatment_11"), addItems), asiValueMap.get(aisCodeAndType+cb.get("OnsiteHWTreatment_11")));
			setValue(getAddItem(cb.get("FinancialAssurance"), addItems), asiValueMap.get(aisCodeAndType+cb.get("FinancialAssurance")));
			setValue(getAddItem(cb.get("RWConsolidationSite"), addItems), asiValueMap.get(aisCodeAndType+cb.get("RWConsolidationSite")));
			setValue(getAddItem(cb.get("HWTankClosure"), addItems), asiValueMap.get(aisCodeAndType+cb.get("HWTankClosure")));
			setValue(getAddItem(cb.get("RCRALargeQuantityGenerator"), addItems), asiValueMap.get(aisCodeAndType+cb.get("RCRALargeQuantityGenerator")));
			setValue(getAddItem(cb.get("HHWCollection"), addItems), asiValueMap.get(aisCodeAndType+cb.get("HHWCollection")));
			setValue(getAddItem(cb.get("Comments"), addItems), asiValueMap.get(aisCodeAndType+cb.get("Comments")));

			// USE$$DEH_HUPF_T27$$LUEG-DEH/HMD/UPFP/Facility
			setValue(getAddItem(cb.get("BeginningDate"), addItems), asiValueMap.get(aisCodeAndType+cb.get("BeginningDate")));
			setValue(getAddItem(cb.get("EndingDate"), addItems), asiValueMap.get(aisCodeAndType+cb.get("EndingDate")));
			// NumberOfEmployees
			setValue(getAddItem(cb.get("NumberOfEmployees"), addItems), asiValueMap.get(aisCodeAndType+cb.get("NumberOfEmployees")));
		// 5/9/2013, change request from COSD: expecting to see 37 as the County ID. We would also need to push this numeric code back with an CME data.
		//setDropdownValue(String.valueOf(bas.getCountyID() == null ? "" : bas.getCountyID()), "CountyID", addItems);
			setValue(getAddItem(cb.get("CountyID"), addItems), asiValueMap.get(aisCodeAndType+cb.get("CountyID")));

			setValue(getAddItem(cb.get("DunAndBradstreet"), addItems), asiValueMap.get(aisCodeAndType+cb.get("DunAndBradstreet")));
			setValue(getAddItem(cb.get("SICCode"), addItems), asiValueMap.get(aisCodeAndType+cb.get("SICCode")));
			setValue(getAddItem(cb.get("NAICSCode"), addItems), asiValueMap.get(aisCodeAndType+cb.get("NAICSCode")));
			setValue(getAddItem(cb.get("IdentificationSignedDate"), addItems), asiValueMap.get(aisCodeAndType+cb.get("IdentificationSignedDate")));
			setValue(getAddItem(cb.get("DocumentPreparerName"), addItems), asiValueMap.get(aisCodeAndType+cb.get("DocumentPreparerName")));
			setValue(getAddItem(cb.get("IdentificationSignerName"), addItems), asiValueMap.get(aisCodeAndType+cb.get("IdentificationSignerName")));
			setValue(getAddItem(cb.get("IdentificationSignerTitle"), addItems), asiValueMap.get(aisCodeAndType+cb.get("IdentificationSignerTitle")));
			
		}
	}

	private void setChemicalAsit(FacilitySubmittalType facilitySubmittalType,
			List<AdditionalInformationGroup> addInfoGroup, boolean isUpdate)
	{
		Object cmlAsitSubGroup[] = getAddInfoSubGroup(addInfoGroup, "DEH_HUPF_T27", "CERS - CHEMICAL INVENTORY");
		Object mdeAsitSubGroup[] = getAddInfoSubGroup(addInfoGroup, "DEH_HUPF_T27", "CERS - MED/HAZ WASTE");
		HazardousMaterialsInventoryType hmi = facilitySubmittalType.getHazardousMaterialsInventory();
		long cml = 0;
		long mde = 0;
		boolean chemicalStatusFlag = CapUtil.getStatusFlag(facilitySubmittalType, CapUtil.CHEMICAL_STATUS);
		if (hmi != null && hmi.getChemicals() != null && chemicalStatusFlag)
		{
			List<ChemicalType> cheType = hmi.getChemicals().getChemical();
			for (ChemicalType chemical : cheType)
			{

				AdditionalItems asitAdditems = null;
				String type = "";
				if (chemical.getHMType() != null && chemical.getHMType().getValue() != null
						&& chemical.getHMType().getValue().value() != null)
				{
					type = chemical.getHMType().getValue().value();
				}
				long index = 0;
				AdditionalInformationSubGroup asitSubGroup = null;
				AdditionalInformationGroup parent = null;
				if (!"c".equals(type))
				{
					index = cml--;
					index = cml;
					parent = (AdditionalInformationGroup) cmlAsitSubGroup[0];
					asitSubGroup = (AdditionalInformationSubGroup) cmlAsitSubGroup[1];
				}
				else
				{
					mde--;
					index = mde;
					parent = (AdditionalInformationGroup) mdeAsitSubGroup[0];
					asitSubGroup = (AdditionalInformationSubGroup) mdeAsitSubGroup[1];

				}
				asitSubGroup = asitSubGroup.clone();
				if (isUpdate)
				{
					asitSubGroup.getKeys().getKey().add(index + "");
					asitSubGroup.setAction("Update");
				}

				asitAdditems = asitSubGroup.getAdditionalItems();
				if (isUpdate)
				{
					setValue(getAddItem("Child Record ID", asitAdditems), chemical.getCERSUniqueKey());
				}
				setValue(getAddItem(cb.get("ChemicalLocation"), asitAdditems), chemical.getChemicalLocation());
				setValue(getAddItem(cb.get("ChemicalName"), asitAdditems), chemical.getChemicalName());

				setValue(getAddItem(cb.get("CommonName"), asitAdditems), chemical.getCommonName());
				setValue(getAddItem(cb.get("CommonName1"), asitAdditems), chemical.getCommonName());
				setValue(getAddItem(cb.get("EHS"), asitAdditems), chemical.getEHS());
				setValue(getAddItem(cb.get("CASNumber"), asitAdditems), chemical.getCASNumber());
				setValue(getAddItem(cb.get("MaximumDailyAmount"), asitAdditems), chemical.getMaximumDailyAmount());

				setValue(getAddItem(cb.get("AnnualWasteAmount"), asitAdditems), chemical.getAnnualWasteAmount());
				setValue(getAddItem(cb.get("StateWasteCode"), asitAdditems), chemical.getStateWasteCode());
				setDropdownValue(getValue(chemical.getUnits()), "Units_1", asitAdditems);
				// setValue(getAddItem(cb.get("Units_1"), asitAdditems), chemical.getUnits());
				setValue(getAddItem(cb.get("ChemicalDescriptionComment"), asitAdditems), chemical
						.getChemicalDescriptionComment());
				setValue(getAddItem(cb.get("CCLID"), asitAdditems), chemical.getCCLID());
				setValue(getAddItem(cb.get("USEPASRSNumber"), asitAdditems), chemical.getUSEPASRSNumber());
				parent.getAdditionalInformationSubGroup().add(asitSubGroup);
			}
			AdditionalInformationGroup par = (AdditionalInformationGroup) cmlAsitSubGroup[0];
			par.getAdditionalInformationSubGroup().remove((AdditionalInformationSubGroup) cmlAsitSubGroup[1]);
			if (cml == 0)
			{
				if(isUpdate)
				{
					for (int i = 0; i < addInfoGroup.size(); i++)
					{
						AdditionalInformationGroup asitGroup = addInfoGroup.get(i);
						if (asitGroup != null && asitGroup.isAddRemoveSubGroups() && asitGroup.getKeys().getKey().size() >= 2
								&& ("DEH_HUPF_T27").equals(asitGroup.getKeys().getKey().get(0))
								&& ("CERS - CHEMICAL INVENTORY").equals(asitGroup.getKeys().getKey().get(1)))
						{
							AdditionalInformationGroup parent = (AdditionalInformationGroup) cmlAsitSubGroup[0];
							AdditionalInformationSubGroup asitSubGroup = (AdditionalInformationSubGroup) cmlAsitSubGroup[1];
							asitSubGroup = asitSubGroup.clone();
							asitSubGroup.setAction("Delete");
							parent.getAdditionalInformationSubGroup().add(asitSubGroup);
							break;
						}
					}
				}
				else
				{
					addInfoGroup.remove(par);
				}
			}
			par = ((AdditionalInformationGroup) mdeAsitSubGroup[0]);
			par.getAdditionalInformationSubGroup().remove((AdditionalInformationSubGroup) mdeAsitSubGroup[1]);
			if (mde == 0)
			{
				if(isUpdate)
				{
					for (int i = 0; i < addInfoGroup.size(); i++)
					{
						AdditionalInformationGroup asitGroup = addInfoGroup.get(i);
						if (asitGroup != null && asitGroup.isAddRemoveSubGroups() && asitGroup.getKeys().getKey().size() >= 2
								&& ("DEH_HUPF_T27").equals(asitGroup.getKeys().getKey().get(0))
								&& ("CERS - MED/HAZ WASTE").equals(asitGroup.getKeys().getKey().get(1)))
						{
							AdditionalInformationGroup parent = (AdditionalInformationGroup) mdeAsitSubGroup[0];
							AdditionalInformationSubGroup asitSubGroup = (AdditionalInformationSubGroup) mdeAsitSubGroup[1];
							asitSubGroup = asitSubGroup.clone();
							asitSubGroup.setAction("Delete");
							parent.getAdditionalInformationSubGroup().add(asitSubGroup);
							break;
						}
					}
				}
				else
				{
					addInfoGroup.remove(par);
				}
			}
		}
		else
		{
			if (asiTValueMap == null || asiTValueMap.size() == 0)
			{
				return;
			}

			String[] tableCodeAndNameArray = {"DEH_HUPF_T27|CERS - CHEMICAL INVENTORY", "DEH_HUPF_T27|CERS - MED/HAZ WASTE"};

			for (int k = 0; k < tableCodeAndNameArray.length; k++)
			{
				aisCodeAndType = tableCodeAndNameArray[k] + "|";
				if(asiTValueMap.get(aisCodeAndType) == null || asiTValueMap.get(aisCodeAndType).length() == 0)
				{
					continue;
				}
				int countNum = Integer.valueOf(asiTValueMap.get(aisCodeAndType)).intValue();
				for (int i = 0; i <= countNum; i++)
				{

					AdditionalItems asitAdditems = null;
					int rowIndex = Integer.valueOf(asiTValueMap.get(aisCodeAndType + "Index" + i)).intValue();

					long index = 0;
					AdditionalInformationSubGroup asitSubGroup = null;
					AdditionalInformationGroup parent = null;
					if ("DEH_HUPF_T27|CERS - CHEMICAL INVENTORY".equals(tableCodeAndNameArray[k]))
					{
						index = cml--;
						index = cml;
						parent = (AdditionalInformationGroup) cmlAsitSubGroup[0];
						asitSubGroup = (AdditionalInformationSubGroup) cmlAsitSubGroup[1];
					}
					else if ("DEH_HUPF_T27|CERS - MED/HAZ WASTE".equals(tableCodeAndNameArray[k]))
					{
						mde--;
						index = mde;
						parent = (AdditionalInformationGroup) mdeAsitSubGroup[0];
						asitSubGroup = (AdditionalInformationSubGroup) mdeAsitSubGroup[1];

					}
					else
					{
						continue;
					}
					asitSubGroup = asitSubGroup.clone();
					if (isUpdate)
					{
						asitSubGroup.getKeys().getKey().add(index + "");
						asitSubGroup.setAction("Update");
					}

					asitAdditems = asitSubGroup.getAdditionalItems();
					if (isUpdate)
					{
						setValue(getAddItem("Child Record ID", asitAdditems), asiTValueMap.get(aisCodeAndType
								+ "Child Record ID|" + rowIndex));
					}
					setValue(getAddItem(cb.get("ChemicalLocation"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("ChemicalLocation") + "|" + rowIndex));
					setValue(getAddItem(cb.get("ChemicalName"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("ChemicalName") + "|" + rowIndex));

					setValue(getAddItem(cb.get("CommonName"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("CommonName") + "|" + rowIndex));
					setValue(getAddItem(cb.get("CommonName1"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("CommonName1") + "|" + rowIndex));
					setValue(getAddItem(cb.get("EHS"), asitAdditems), asiTValueMap.get(aisCodeAndType + cb.get("EHS")
							+ "|" + rowIndex));
					setValue(getAddItem(cb.get("CASNumber"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("CASNumber") + "|" + rowIndex));
					setValue(getAddItem(cb.get("MaximumDailyAmount"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("MaximumDailyAmount") + "|" + rowIndex));
					setValue(getAddItem(cb.get("AnnualWasteAmount"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("AnnualWasteAmount") + "|" + rowIndex));
					setValue(getAddItem(cb.get("StateWasteCode"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("StateWasteCode") + "|" + rowIndex));
					setDropdownValue(asiTValueMap.get(aisCodeAndType + cb.get("Units_1") + "|" + rowIndex), "Units_1",
						asitAdditems);
					setValue(getAddItem(cb.get("ChemicalDescriptionComment"), asitAdditems), asiTValueMap
							.get(aisCodeAndType + cb.get("ChemicalDescriptionComment") + "|" + rowIndex));
					setValue(getAddItem(cb.get("CCLID"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("CCLID") + "|" + rowIndex));
					setValue(getAddItem(cb.get("USEPASRSNumber"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("USEPASRSNumber") + "|" + rowIndex));
					parent.getAdditionalInformationSubGroup().add(asitSubGroup);

				}
			}
			AdditionalInformationGroup par = (AdditionalInformationGroup) cmlAsitSubGroup[0];
			par.getAdditionalInformationSubGroup().remove((AdditionalInformationSubGroup) cmlAsitSubGroup[1]);
			if (cml == 0)
			{
				addInfoGroup.remove(par);
			}
			par = ((AdditionalInformationGroup) mdeAsitSubGroup[0]);
			par.getAdditionalInformationSubGroup().remove((AdditionalInformationSubGroup) mdeAsitSubGroup[1]);
			if (mde == 0)
			{
				addInfoGroup.remove(par);
			}
		}
	}

	// Remote Waste Consolidation Site Annual Notification asit --Hazardous Waste
	private void setHazarousWasteAsit(List<AdditionalInformationGroup> addInfoGroup,
			FacilitySubmittalType facilitySubmittalType, boolean isUpdate)
	{
		boolean remoteWasterStatusFlag = false;
		if (facilitySubmittalType.getRemoteWasteConsolidationsAnnualNotification() != null
				&& facilitySubmittalType.getRemoteWasteConsolidationsAnnualNotification().getSubmittalElementHeader() != null
				&& CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType.getRemoteWasteConsolidationsAnnualNotification()
						.getSubmittalElementHeader().getSubmittalStatus()))
		{
			remoteWasterStatusFlag = true;
		}
		if (facilitySubmittalType.getRemoteWasteConsolidationsAnnualNotification() != null && remoteWasterStatusFlag)
		{
			RWConsolidationSitesType rwstt = facilitySubmittalType.getRemoteWasteConsolidationsAnnualNotification()
					.getRWConsolidationSites();
			if (rwstt != null)
			{
				Object asitGroups[] = getAddInfoSubGroup(addInfoGroup, "DEH_HUPF_T27", "CERS - REM WST CONSOL NOTIF");
				AdditionalInformationSubGroup asitSubGroup = (AdditionalInformationSubGroup) asitGroups[1];
				AdditionalInformationGroup parent = (AdditionalInformationGroup) asitGroups[0];
				List<RWConsolidationSiteType> rwsts = rwstt.getRWConsolidationSite();
				long index = 0;
				if (rwsts != null)
				{

					for (RWConsolidationSiteType rwst : rwsts)
					{
						index--;
						AdditionalInformationSubGroup subGroup = asitSubGroup.clone();
						if (isUpdate)
							subGroup.getKeys().getKey().add("" + index);
						AdditionalItems asitAdditems = subGroup.getAdditionalItems();
						setValue(getAddItem(cb.get("Address"), asitAdditems), rwst.getAddress());
						setValue(getAddItem(cb.get("City"), asitAdditems), rwst.getCity());
						setValue(getAddItem(cb.get("ZIP"), asitAdditems), rwst.getZIP());
						setValue(getAddItem(cb.get("DescriptionOfRemoteConsolidation"), asitAdditems),
							rwst.getDescriptionOfRemoteConsolidation());
						setValue(getAddItem(cb.get("DescriptionOfWaste"), asitAdditems), rwst.getDescriptionOfWaste());
						setDropdownValue(getValue(rwst.getOnsiteHWTreatment()), "OnsiteHWTreatment", asitAdditems);
						//setValue(getAddItem(cb.get("OnsiteHWTreatment"), asitAdditems), rwst.getOnsiteHWTreatment().getValue());
						setValue(getAddItem(cb.get("EstimatedMonthlyVolumeConsolidated"), asitAdditems), rwst
								.getEstimatedMonthlyVolumeConsolidated());
						setDropdownValue(rwst.getUnits(),"Units", asitAdditems);

						//setValue(getAddItem(cb.get("Units_1"), asitAdditems), rwst.getUnits());
						setDropdownValue(getValue(rwst.getNonRCRAHW()), "NonRCRAHW", asitAdditems);
						//setValue(getAddItem(cb.get("NonRCRAHW"), asitAdditems), rwst.getNonRCRAHW().getValue());
						setValue(getAddItem(cb.get("NonRCRAOther"), asitAdditems), rwst.getNonRCRAOther());
						setValue(getAddItem(cb.get("CertificationDate_7"), asitAdditems), toString(rwst.getCertificationDate()));
						setValue(getAddItem(cb.get("OOName_7"), asitAdditems), rwst.getOOName());
						setValue(getAddItem(cb.get("OOTitle_7"), asitAdditems), rwst.getOOTitle());
						parent.getAdditionalInformationSubGroup().add(subGroup);
					}
				}
				if (index == 0)
				{
					addInfoGroup.remove(parent);
				}
				else
				{
					parent.getAdditionalInformationSubGroup().remove(asitSubGroup);
				}
			}

		}
		else
		{

			
			aisCodeAndType = "DEH_HUPF_T27|CERS - REM WST CONSOL NOTIF|";
			if (asiTValueMap == null || asiTValueMap.size() == 0 || asiTValueMap.get(aisCodeAndType) == null || asiTValueMap.get(aisCodeAndType).length() == 0)
			{
				return;
			}

			Object asitGroups[] = getAddInfoSubGroup(addInfoGroup, "DEH_HUPF_T27", "CERS - REM WST CONSOL NOTIF");
			AdditionalInformationSubGroup asitSubGroup = (AdditionalInformationSubGroup) asitGroups[1];
			AdditionalInformationGroup parent = (AdditionalInformationGroup) asitGroups[0];
			long index = 0;
			int countNum = Integer.valueOf(asiTValueMap.get(aisCodeAndType)).intValue();
			for (int i = 0; i <= countNum; i++)
			{
				index--;
				int rowIndex = Integer.valueOf(asiTValueMap.get(aisCodeAndType + "Index" + i)).intValue();

				AdditionalInformationSubGroup subGroup = asitSubGroup.clone();
				if (isUpdate)
					subGroup.getKeys().getKey().add("" + index);
				AdditionalItems asitAdditems = subGroup.getAdditionalItems();
				setValue(getAddItem(cb.get("Address"), asitAdditems), asiTValueMap.get(aisCodeAndType+ cb.get("Address") + "|" + rowIndex));
				setValue(getAddItem(cb.get("City"), asitAdditems), asiTValueMap.get(aisCodeAndType+ cb.get("City") + "|" + rowIndex));
				setValue(getAddItem(cb.get("ZIP"), asitAdditems), asiTValueMap.get(aisCodeAndType+ cb.get("ZIP") + "|" + rowIndex));
				setValue(getAddItem(cb.get("DescriptionOfRemoteConsolidation"), asitAdditems), asiTValueMap.get(aisCodeAndType+ cb.get("DescriptionOfRemoteConsolidation") + "|" + rowIndex));
				setValue(getAddItem(cb.get("DescriptionOfWaste"), asitAdditems), asiTValueMap.get(aisCodeAndType+ cb.get("DescriptionOfWaste") + "|" + rowIndex));
				setDropdownValue(asiTValueMap.get(aisCodeAndType+ cb.get("OnsiteHWTreatment") + "|" + rowIndex), "OnsiteHWTreatment", asitAdditems);
				setValue(getAddItem(cb.get("EstimatedMonthlyVolumeConsolidated"), asitAdditems), asiTValueMap.get(aisCodeAndType+ cb.get("EstimatedMonthlyVolumeConsolidated") + "|" + rowIndex));
				setDropdownValue(asiTValueMap.get(aisCodeAndType+ cb.get("Units") + "|" + rowIndex), "Units", asitAdditems);

				setDropdownValue(asiTValueMap.get(aisCodeAndType+ cb.get("NonRCRAHW") + "|" + rowIndex), "NonRCRAHW", asitAdditems);
				setValue(getAddItem(cb.get("NonRCRAOther"), asitAdditems), asiTValueMap.get(aisCodeAndType+ cb.get("NonRCRAOther") + "|" + rowIndex));
				setValue(getAddItem(cb.get("CertificationDate_7"), asitAdditems), asiTValueMap.get(aisCodeAndType+ cb.get("CertificationDate_7") + "|" + rowIndex));
				setValue(getAddItem(cb.get("OOName_7"), asitAdditems), asiTValueMap.get(aisCodeAndType+ cb.get("OOName_7") + "|" + rowIndex));
				setValue(getAddItem(cb.get("OOTitle_7"), asitAdditems), asiTValueMap.get(aisCodeAndType+ cb.get("OOTitle_7") + "|" + rowIndex));
				parent.getAdditionalInformationSubGroup().add(subGroup);
			}
			if (index == 0)
			{
				addInfoGroup.remove(parent);
			}
			else
			{
				parent.getAdditionalInformationSubGroup().remove(asitSubGroup);
			}

		}
	}

	// #Certification Of Financial Assurance /Onsite Hazardous Waste Treatment Notification - Facility asi
	private void setHazarousWasteAsi(List<AdditionalInformationGroup> addInfoGroup,
			FacilitySubmittalType facilitySubmittalType)
	{
		boolean wasteStatusFlag = CapUtil.getStatusFlag(facilitySubmittalType, CapUtil.WASTE_STATUS);
		if (facilitySubmittalType.getOnsiteHazardousWasteTreatmentNotification() != null && wasteStatusFlag)
		{
			HWFacilityType hwf = facilitySubmittalType.getOnsiteHazardousWasteTreatmentNotification().getHWFacility();
			if (hwf != null)
			{
				Object asiGroups[] = getAddInfoSubGroup(addInfoGroup, "DEH_HUPF_T27", "CERS COLLECTED INFO");
				AdditionalInformationSubGroup asiSubGroup = (AdditionalInformationSubGroup) asiGroups[1];
				AdditionalItems asitAdditems = asiSubGroup.getAdditionalItems();
				HWCertificationOfFinancialAssurancesType hwc = hwf.getHWCertificationOfFinancialAssurances();
				if (hwc != null)
				{
					// setValue(getAddItem(cb.get("TypeOfOperation"), asitAdditems), );
					List<HWCertificationOfFinancialAssuranceType> hwts = hwc.getHWCertificationOfFinancialAssurance();
					if (hwts != null)
					{
						for (HWCertificationOfFinancialAssuranceType hwt : hwts)
						{ // That is a big problem.
							setDropdownValue(hwt.getTypeOfOperation(),"TypeOfOperation", asitAdditems);
							//setValue(getAddItem(cb.get("TypeOfOperation"), asitAdditems), hwt.getTypeOfOperation());
							setValue(getAddItem(cb.get("EstimatedClosureCost"), asitAdditems),
								hwt.getEstimatedClosureCost());

							List<JAXBElement<?>> exeFroms = hwt.getExemptFromFAOrExemptFromFAOtherOrExemptFromFAPBR();
							if (exeFroms != null)
							{
								for (JAXBElement<?> exeFrom : exeFroms)
								{
									if ("ExemptFromFA".equals(exeFrom.getName().toString()))
									{
										setDropdownValue(getValue(exeFrom),"ExemptFromFA", asitAdditems);
										//setValue(getAddItem(cb.get("ExemptFromFA"), asitAdditems), exeFrom.getValue());
									}
									if ("ExemptFromFAOther".equals(exeFrom.getName().toString()))
									{
										HWCertificationOfFinancialAssuranceType.ExemptFromFAOther exemptFromFAOther =  (HWCertificationOfFinancialAssuranceType.ExemptFromFAOther)exeFrom.getValue();
										setDropdownValue(exemptFromFAOther == null ? "" : exemptFromFAOther.getExemptFromFADescriptionOther() ,"ExemptFromFAOther", asitAdditems);
										//setValue(getAddItem(cb.get("ExemptFromFAOther"), asitAdditems), exeFrom
												//.getValue());
									}
									if ("ExemptFromFAPBR".equals(exeFrom.getName().toString()))
									{
										setDropdownValue(getValue(exeFrom),"ExemptFromFAPBR", asitAdditems);
										//setValue(getAddItem(cb.get("ExemptFromFAPBR"), asitAdditems), exeFrom
												//.getValue());
									}
								}
							}
							setValue(getAddItem(cb.get("DateOfClosureAssuranceMechanism"), asitAdditems),
								hwt.getDateOfClosureAssuranceMechanism());
							setValue(getAddItem(cb.get("MechanismIDNumber"), asitAdditems), hwt.getMechanismIDNumber());
							setDropdownValue(hwt.getClosureAssuranceMechanism(),"ClosureAssuranceMechanism", asitAdditems);
//							setValue(getAddItem(cb.get("ClosureAssuranceMechanism"), asitAdditems), hwt
//									.getClosureAssuranceMechanism());
							setValue(getAddItem(cb.get("FinancialInstitutionName"), asitAdditems),
								hwt.getFinancialInstitutionName());
							setValue(getAddItem(cb.get("FinancialInstitutionAddress"), asitAdditems),
								hwt.getFinancialInstitutionAddress());
							setValue(getAddItem(cb.get("FinancialInstitutionCity"), asitAdditems),
								hwt.getFinancialInstitutionCity());
							setValue(getAddItem(cb.get("FinancialInstitutionState"), asitAdditems),
								hwt.getFinancialInstitutionState());
							setValue(getAddItem(cb.get("FinancialInstitutionZip"), asitAdditems),
								hwt.getFinancialInstitutionZip());
							setValue(getAddItem(cb.get("FinancialInstitutionCountry"), asitAdditems),
								hwt.getFinancialInstitutionCountry());
							setDropdownValue(getValue(hwt.getSignerOfCertification()),"SignerOfCertification", asitAdditems);
//							setValue(getAddItem(cb.get("SignerOfCertification"), asitAdditems), hwt
//									.getSignerOfCertification());

							setValue(getAddItem(cb.get("DateCertified_716"), asitAdditems), toString(hwt.getDateCertified()));
							setValue(getAddItem(cb.get("OOName"), asitAdditems), hwt.getOOName());
							setValue(getAddItem(cb.get("OOTitle"), asitAdditems), hwt.getOOTitle());
						}
					}

				}
				setValue(getAddItem(cb.get("PMFacilityPermit"), asitAdditems), toString(hwf.getPMFacilityPermit()));
				setValue(getAddItem(cb.get("PMInterimStatus"), asitAdditems), toString(hwf.getPMInterimStatus()));
				setValue(getAddItem(cb.get("PMStandardizedPermit"), asitAdditems), toString(hwf.getPMStandardizedPermit()));
				setValue(getAddItem(cb.get("PMVariance"), asitAdditems), toString(hwf.getPMVariance()));
				setValue(getAddItem(cb.get("PMConsentAgreement"), asitAdditems), toString(hwf.getPMConsentAgreement()));
				setValue(getAddItem(cb.get("ShortenedReviewPeriod"), asitAdditems), toString(hwf.getShortenedReviewPeriod()));
				setValue(getAddItem(cb.get("ReviewPeriodReasonForRequest"), asitAdditems), hwf
						.getReviewPeriodReasonForRequest());
				setValue(getAddItem(cb.get("NumberOfUnitsCECL"), asitAdditems), toString(hwf.getNumberOfUnitsCECL()));
				setValue(getAddItem(cb.get("DateCertified_6"), asitAdditems), toString(hwf.getDateCertified()));
				setValue(getAddItem(cb.get("OOName_6"), asitAdditems), hwf.getOOName());
				setValue(getAddItem(cb.get("OOTitle_6"), asitAdditems), hwf.getOOTitle());
			}

		}
		else
		{
			aisCodeAndType = "DEH_HUPF_T27|CERS COLLECTED INFO|";
			if (asiValueMap == null || asiValueMap.size() == 0)
			{
				return;
			}
			Object asiGroups[] = getAddInfoSubGroup(addInfoGroup, "DEH_HUPF_T27", "CERS COLLECTED INFO");
			AdditionalInformationSubGroup asiSubGroup = (AdditionalInformationSubGroup) asiGroups[1];
			AdditionalItems asitAdditems = asiSubGroup.getAdditionalItems();
			setDropdownValue(asiValueMap, "TypeOfOperation", asitAdditems);
			setValue(getAddItem(cb.get("EstimatedClosureCost"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("EstimatedClosureCost")));

			setDropdownValue(asiValueMap, "ExemptFromFA", asitAdditems);
			setDropdownValue(asiValueMap, "ExemptFromFAOther", asitAdditems);
			setDropdownValue(asiValueMap, "ExemptFromFAPBR", asitAdditems);

			setValue(getAddItem(cb.get("DateOfClosureAssuranceMechanism"), asitAdditems), asiValueMap
					.get(aisCodeAndType + cb.get("DateOfClosureAssuranceMechanism")));
			setValue(getAddItem(cb.get("MechanismIDNumber"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("MechanismIDNumber")));
			setDropdownValue(asiValueMap, "ClosureAssuranceMechanism", asitAdditems);
			setValue(getAddItem(cb.get("FinancialInstitutionName"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FinancialInstitutionName")));
			setValue(getAddItem(cb.get("FinancialInstitutionAddress"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FinancialInstitutionAddress")));
			setValue(getAddItem(cb.get("FinancialInstitutionCity"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FinancialInstitutionCity")));
			setValue(getAddItem(cb.get("FinancialInstitutionState"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FinancialInstitutionState")));
			setValue(getAddItem(cb.get("FinancialInstitutionZip"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FinancialInstitutionZip")));
			setValue(getAddItem(cb.get("FinancialInstitutionCountry"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FinancialInstitutionCountry")));
			setDropdownValue(asiValueMap, "SignerOfCertification", asitAdditems);

			setValue(getAddItem(cb.get("DateCertified_716"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("DateCertified_716")));
			setValue(getAddItem(cb.get("OOName"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("OOName")));
			setValue(getAddItem(cb.get("OOTitle"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("OOTitle")));
			
			
			setValue(getAddItem(cb.get("PMFacilityPermit"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("PMFacilityPermit")));
			setValue(getAddItem(cb.get("PMInterimStatus"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("PMInterimStatus")));
			setValue(getAddItem(cb.get("PMStandardizedPermit"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("PMStandardizedPermit")));
			setValue(getAddItem(cb.get("PMVariance"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("PMVariance")));
			setValue(getAddItem(cb.get("PMConsentAgreement"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FRCodeGuarantee")));
			setValue(getAddItem(cb.get("ShortenedReviewPeriod"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("ShortenedReviewPeriod")));
			setValue(getAddItem(cb.get("ReviewPeriodReasonForRequest"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("ReviewPeriodReasonForRequest")));
			setValue(getAddItem(cb.get("NumberOfUnitsCECL"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("NumberOfUnitsCECL")));
			setValue(getAddItem(cb.get("DateCertified_6"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("DateCertified_6")));
			setValue(getAddItem(cb.get("OOName_6"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("OOName_6")));
			setValue(getAddItem(cb.get("OOTitle_6"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("OOTitle_6")));

		}
	}

	// #UST Operating Permit Application - Facility Information
	private void setUstAsi(List<AdditionalInformationGroup> addInfoGroup, FacilitySubmittalType facilitySubmittalType)
	{
		// CERS COLLECTED INFO DEH_HUPF_T27
 		boolean ustStatusFlag = CapUtil.getStatusFlag(facilitySubmittalType, CapUtil.UST_STATUS);
		if (facilitySubmittalType.getUndergroundStorageTanks() != null && ustStatusFlag)
		{
			USTFacilityInformationType ustt = facilitySubmittalType.getUndergroundStorageTanks()
					.getUSTFacilityInformation();
			if (ustt != null)
			{
				Object asiGroups[] = getAddInfoSubGroup(addInfoGroup, "DEH_HUPF_T27", "CERS COLLECTED INFO");
				AdditionalInformationSubGroup asiSubGroup = (AdditionalInformationSubGroup) asiGroups[1];
				AdditionalItems asitAdditems = asiSubGroup.getAdditionalItems();
				setDropdownValue(ustt.getTypeOfAction(),"TypeOfAction_400", asitAdditems);
				setDropdownValue(ustt.getFacilityType(),"FacilityType", asitAdditems);
				setValue(getAddItem(cb.get("TotalUSTAtFacility"), asitAdditems), ustt.getTotalUSTAtFacility());
				setValue(getAddItem(cb.get("IndianOrTrustLand"), asitAdditems), ustt.getIndianOrTrustLand());
				setValue(getAddItem(cb.get("SDSOffice"), asitAdditems), ustt.getSDSOffice());
				
				
				setValue(getAddItem(cb.get("BOENumber"), asitAdditems), ustt.getBOENumber());
				setValue(getAddItem(cb.get("FRCodeSelfInsured"), asitAdditems), ustt.getFRCodeSelfInsured());
				setValue(getAddItem(cb.get("FRCodeGuarantee"), asitAdditems), ustt.getFRCodeGuarantee());
				setValue(getAddItem(cb.get("FRCodeInsurance"), asitAdditems), ustt.getFRCodeInsurance());
				setValue(getAddItem(cb.get("FRCodeSuretyBond"), asitAdditems), ustt.getFRCodeSuretyBond());
				setValue(getAddItem(cb.get("FRCodeCreditLetter"), asitAdditems), ustt.getFRCodeCreditLetter());
				setValue(getAddItem(cb.get("FRCodeExemption"), asitAdditems), ustt.getFRCodeExemption());
				setValue(getAddItem(cb.get("FRCodeStateFundCFOLetter"), asitAdditems), ustt
						.getFRCodeStateFundCFOLetter());
				setValue(getAddItem(cb.get("FRCodeStateFundCD"), asitAdditems), ustt.getFRCodeStateFundCD());
				setValue(getAddItem(cb.get("FRCodeLGMechanism"), asitAdditems), ustt.getFRCodeLGMechanism());
				JAXBElement<USTFacilityInformationType.FRCodeOther> fRCodeOtherElement = ustt.getFRCodeOther();
				String fRCodeOtherFlag = "N";
				String fRCodeOtherValue = "";
				if (fRCodeOtherElement != null)
				{
					FRCodeOther fRCodeOther = fRCodeOtherElement.getValue();
					if (fRCodeOther != null && fRCodeOther.getFRCodeDescriptionOther() != null)
					{
						fRCodeOtherFlag = "Y";
						fRCodeOtherValue = fRCodeOther.getFRCodeDescriptionOther();
					}
				}
				setValue(getAddItem(cb.get("FRCodeOther"), asitAdditems), fRCodeOtherFlag);
				setValue(getAddItem(cb.get("fRCodeOtherValue"), asitAdditems), fRCodeOtherValue);
				setDropdownValue(ustt.getPermitHolderInfo(),"PermitHolderInfo", asitAdditems);
				setValue(getAddItem(cb.get("DateCertified"), asitAdditems), ustt.getDateCertified());
			}
		}
		else
		{
			aisCodeAndType = "DEH_HUPF_T27" + "|" + "CERS COLLECTED INFO" + "|";
			if (asiValueMap == null || asiValueMap.size() == 0)
			{
				return;
			}
			
			Object asiGroups[] = getAddInfoSubGroup(addInfoGroup, "DEH_HUPF_T27", "CERS COLLECTED INFO");
			AdditionalInformationSubGroup asiSubGroup = (AdditionalInformationSubGroup) asiGroups[1];
			AdditionalItems asitAdditems = asiSubGroup.getAdditionalItems();
			setDropdownValue(asiValueMap, "TypeOfAction_400", asitAdditems);
			setDropdownValue(asiValueMap, "FacilityType", asitAdditems);
			setValue(getAddItem(cb.get("TotalUSTAtFacility"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("TotalUSTAtFacility")));
			setValue(getAddItem(cb.get("IndianOrTrustLand"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("IndianOrTrustLand")));
			setValue(getAddItem(cb.get("SDSOffice"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("SDSOffice")));
			
			
			setValue(getAddItem(cb.get("BOENumber"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("BOENumber")));
			setValue(getAddItem(cb.get("FRCodeSelfInsured"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FRCodeSelfInsured")));
			setValue(getAddItem(cb.get("FRCodeGuarantee"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FRCodeGuarantee")));
			setValue(getAddItem(cb.get("FRCodeInsurance"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FRCodeInsurance")));
			setValue(getAddItem(cb.get("FRCodeSuretyBond"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FRCodeSuretyBond")));
			setValue(getAddItem(cb.get("FRCodeCreditLetter"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FRCodeCreditLetter")));
			setValue(getAddItem(cb.get("FRCodeExemption"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FRCodeExemption")));
			setValue(getAddItem(cb.get("FRCodeStateFundCFOLetter"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FRCodeStateFundCFOLetter")));
			setValue(getAddItem(cb.get("FRCodeStateFundCD"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FRCodeStateFundCD")));
			setValue(getAddItem(cb.get("FRCodeLGMechanism"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FRCodeLGMechanism")));
			setValue(getAddItem(cb.get("FRCodeOther"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("FRCodeOther")));
			setDropdownValue(asiValueMap, "PermitHolderInfo", asitAdditems);
			setValue(getAddItem(cb.get("DateCertified"), asitAdditems), asiValueMap.get(aisCodeAndType
					+ cb.get("DateCertified")));
		}
		
//		OwnerOperatorInformationType ooi = facilitySubmittalType.getFacilityInformation().getOwnerOperatorInformation();
		
		if (facilitySubmittalType.getUndergroundStorageTanks() != null
				&& facilitySubmittalType.getUndergroundStorageTanks().getUSTFacilityInformation() != null)
		{
			USTFacilityInformationType ustt = facilitySubmittalType.getUndergroundStorageTanks()
					.getUSTFacilityInformation();
			Object asiGroups[] = getAddInfoSubGroup(addInfoGroup, "DEH_HUPF_T27", "CERS COLLECTED INFO"); 
			AdditionalInformationSubGroup asiSubGroup = (AdditionalInformationSubGroup) asiGroups[1];
			AdditionalItems asitAdditems = asiSubGroup.getAdditionalItems();
			setValue(getAddItem(cb.get("PropertyOwnerName"), asitAdditems), ustt.getPOName());
			setValue(getAddItem(cb.get("PropertyOwnerPhone"), asitAdditems), ustt.getPOPhone());
			setValue(getAddItem(cb.get("PropertyOwnerMailingAddress"), asitAdditems), ustt.getPOMailingAddress());
			setValue(getAddItem(cb.get("PropertyOwnerCity"), asitAdditems), ustt.getPOCity());
			setValue(getAddItem(cb.get("PropertyOwnerState"), asitAdditems), ustt.getPOState());
			setValue(getAddItem(cb.get("PropertyOwnerZipCode"), asitAdditems), ustt.getPOZipCode());
			setValue(getAddItem(cb.get("PropertyOwnerCountry"), asitAdditems), ustt.getPOCountry());
			
		}
		else
		{
			aisCodeAndType = "DEH_HUPF_T27" + "|" + "CERS COLLECTED INFO" + "|";
			if (asiValueMap == null || asiValueMap.size() == 0)
			{
				return;
			}
			Object asiGroups[] = getAddInfoSubGroup(addInfoGroup, "DEH_HUPF_T27", "CERS COLLECTED INFO");
			AdditionalInformationSubGroup asiSubGroup = (AdditionalInformationSubGroup) asiGroups[1];
			AdditionalItems asitAdditems = asiSubGroup.getAdditionalItems();
			setValue(getAddItem(cb.get("PropertyOwnerName"), asitAdditems), asiValueMap.get(aisCodeAndType
				+ cb.get("PropertyOwnerName")));
			setValue(getAddItem(cb.get("PropertyOwnerMailingAddress"), asitAdditems), asiValueMap.get(aisCodeAndType
				+ cb.get("PropertyOwnerMailingAddress")));
			setValue(getAddItem(cb.get("PropertyOwnerCity"), asitAdditems), asiValueMap.get(aisCodeAndType
				+ cb.get("PropertyOwnerCity")));
			setValue(getAddItem(cb.get("PropertyOwnerState"), asitAdditems), asiValueMap.get(aisCodeAndType
				+ cb.get("PropertyOwnerState")));
			setValue(getAddItem(cb.get("PropertyOwnerZipCode"), asitAdditems), asiValueMap.get(aisCodeAndType
				+ cb.get("PropertyOwnerZipCode")));
			setValue(getAddItem(cb.get("PropertyOwnerCountry"), asitAdditems), asiValueMap.get(aisCodeAndType
				+ cb.get("PropertyOwnerCountry")));
		}
		
	}

	// #UST Certification of Installation / Modification asit
	private void setUstAsit(List<AdditionalInformationGroup> addInfoGroup, FacilitySubmittalType facilitySubmittalType,
			boolean isUpdate)
	{
		Object asitGroups[] = getAddInfoSubGroup(addInfoGroup, "DEH_HUPF_T27", "CERS - UST CERT OF INSTALL/MOD");
		UndergroundStorageTanksType ust = facilitySubmittalType.getUndergroundStorageTanks();
		boolean ustStatusFlag = CapUtil.getStatusFlag(facilitySubmittalType, CapUtil.UST_STATUS);
		if (asitGroups != null && ust != null && ust.getUSTCertificationOfInstallationModifications() != null && ustStatusFlag)
		{
			List<USTCertificationOfInstallationModificationType> ustUms = ust
					.getUSTCertificationOfInstallationModifications().getUSTCertificationOfInstallationModification();
			if (ustUms != null)
			{
				long index = 0;
				AdditionalInformationSubGroup asitSubGroup = (AdditionalInformationSubGroup) asitGroups[1];
				AdditionalInformationGroup parent = (AdditionalInformationGroup) asitGroups[0];
				for (USTCertificationOfInstallationModificationType ustUm : ustUms)
				{

					index--;
					AdditionalInformationSubGroup subGroup = asitSubGroup.clone();
					if (isUpdate)
						subGroup.getKeys().getKey().add("" + index);
					AdditionalItems asitAdditems = subGroup.getAdditionalItems();
					setValue(getAddItem(cb.get("ProjectTypeTank"), asitAdditems), ustUm.getProjectTypeTank());
					setValue(getAddItem(cb.get("ProjectTypePiping"), asitAdditems), ustUm.getProjectTypePiping());
					setValue(getAddItem(cb.get("ProjectTypeSump"), asitAdditems), ustUm.getProjectTypeSump());
					setValue(getAddItem(cb.get("ProjectTypeUnderDispenser"), asitAdditems),
						ustUm.getProjectTypeUnderDispenser());
					setValue(getAddItem(cb.get("ProjectTypeOther"), asitAdditems), ustUm.getProjectTypeOther());
					setValue(getAddItem(cb.get("WorkAuthorizedUnderPermit"), asitAdditems),
						ustUm.getWorkAuthorizedUnderPermit());
					setValue(getAddItem(cb.get("DescriptionOfWork"), asitAdditems), ustUm.getDescriptionOfWork());
					setValue(getAddItem(cb.get("CertificationDate"), asitAdditems), toString(ustUm.getCertificationDate()));

					parent.getAdditionalInformationSubGroup().add(subGroup);
				}
				if (index == 0)
				{
					addInfoGroup.remove(parent);
				}
				else
				{
					parent.getAdditionalInformationSubGroup().remove(asitSubGroup);
				}
			}

		}
		else
		{
			aisCodeAndType = "DEH_HUPF_T27|CERS - UST CERT OF INSTALL/MOD|";
			if (asiTValueMap != null && asiTValueMap.size() > 0 && asiTValueMap.get(aisCodeAndType) != null
					&& asiTValueMap.get(aisCodeAndType).length() > 0)
			{
				long index = 0;
				AdditionalInformationSubGroup asitSubGroup = (AdditionalInformationSubGroup) asitGroups[1];
				AdditionalInformationGroup parent = (AdditionalInformationGroup) asitGroups[0];
				int countNum = Integer.valueOf(asiTValueMap.get(aisCodeAndType)).intValue();
				for (int i = 0; i <= countNum; i++)
				{
					index--;
					int rowIndex = Integer.valueOf(asiTValueMap.get(aisCodeAndType + "Index" + i)).intValue();
					AdditionalInformationSubGroup subGroup = asitSubGroup.clone();
					if (isUpdate)
						subGroup.getKeys().getKey().add("" + index);
					AdditionalItems asitAdditems = subGroup.getAdditionalItems();
					setValue(getAddItem(cb.get("ProjectTypeTank"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("ProjectTypeTank") + "|" + rowIndex));
					setValue(getAddItem(cb.get("ProjectTypePiping"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("ProjectTypePiping") + "|" + rowIndex));
					setValue(getAddItem(cb.get("ProjectTypeSump"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("ProjectTypeSump") + "|" + rowIndex));
					setValue(getAddItem(cb.get("ProjectTypeUnderDispenser"), asitAdditems), asiTValueMap
							.get(aisCodeAndType + cb.get("ProjectTypeUnderDispenser") + "|" + rowIndex));
					setValue(getAddItem(cb.get("ProjectTypeOther"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("ProjectTypeOther") + "|" + rowIndex));
					setValue(getAddItem(cb.get("WorkAuthorizedUnderPermit"), asitAdditems), asiTValueMap
							.get(aisCodeAndType + cb.get("WorkAuthorizedUnderPermit") + "|" + rowIndex));
					setValue(getAddItem(cb.get("DescriptionOfWork"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("DescriptionOfWork") + "|" + rowIndex));
					setValue(getAddItem(cb.get("CertificationDate"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("CertificationDate") + "|" + rowIndex));

					parent.getAdditionalInformationSubGroup().add(subGroup);
				}
				if (index == 0)
				{
					addInfoGroup.remove(parent);
				}
				else
				{
					parent.getAdditionalInformationSubGroup().remove(asitSubGroup);
				}
			}

		}

		asitGroups = getAddInfoSubGroup(addInfoGroup, "DEH_HUPF_T27", "CERS - UST INFORMATION");
		UndergroundStorageTanksType ustt = facilitySubmittalType.getUndergroundStorageTanks();
		if (ustt != null && ustStatusFlag)
		{
			USTTanksType ustanks = ustt.getUSTTanks();
			if (asitGroups != null && ustanks != null)
			{
				List<USTTankType> uTankList = ustanks.getUSTTank();
				if (uTankList != null && uTankList.size() > 0)
				{
					long index = 0;
					AdditionalInformationSubGroup asitSubGroup = (AdditionalInformationSubGroup) asitGroups[1];
					AdditionalInformationGroup parent = (AdditionalInformationGroup) asitGroups[0];

					for (USTTankType ttt : uTankList)
					{
						if (ttt != null)
						{

							index--;
							AdditionalInformationSubGroup subGroup = asitSubGroup.clone();
							if (isUpdate)
								subGroup.getKeys().getKey().add("" + index);

							AdditionalItems asitAdditems = subGroup.getAdditionalItems();
							if (isUpdate)
							{
								setValue(getAddItem("Child Record ID", asitAdditems),
									ttt.getCERSUniqueKey());
							}
							setDropdownValue(ttt.getTypeOfAction(),"TypeOfAction", asitAdditems);
							//setValue(getAddItem(cb.get("TypeOfAction"), asitAdditems), ttt.getTypeOfAction());
							setValue(getAddItem(cb.get("TankIDNumber"), asitAdditems), ttt.getTankIDNumber());
							setValue(getAddItem(cb.get("TankCapacityInGallons"), asitAdditems),
								ttt.getTankCapacityInGallons());

							//setValue(getAddItem("Tank Contents Type (440)", asitAdditems), ttt.getTankContents());
							setDropdownValue(ttt.getTankContents(),"TankContents", asitAdditems);

							setValue(getAddItem(cb.get("OtherPetroleum"), asitAdditems), ttt.getOtherPetroleum());
							setValue(getAddItem(cb.get("OtherNonPetroleum"), asitAdditems), ttt.getOtherNonPetroleum());

							parent.getAdditionalInformationSubGroup().add(subGroup);
						}

					}
					if (index == 0)
					{
						addInfoGroup.remove(parent);
					}
					else
					{
						parent.getAdditionalInformationSubGroup().remove(asitSubGroup);
					}
				}
			}

		}
		else
		{
			aisCodeAndType = "DEH_HUPF_T27|CERS - UST INFORMATION|";
			if (asiTValueMap != null && asiTValueMap.size() > 0 && asiTValueMap.get(aisCodeAndType) != null
					&& asiTValueMap.get(aisCodeAndType).length() > 0)
			{
				long index = 0;
				AdditionalInformationSubGroup asitSubGroup = (AdditionalInformationSubGroup) asitGroups[1];
				AdditionalInformationGroup parent = (AdditionalInformationGroup) asitGroups[0];

				int countNum = Integer.valueOf(asiTValueMap.get(aisCodeAndType)).intValue();
				for (int i = 0; i <= countNum; i++)
				{

					index--;
					int rowIndex = Integer.valueOf(asiTValueMap.get(aisCodeAndType + "Index" + i)).intValue();
					AdditionalInformationSubGroup subGroup = asitSubGroup.clone();
					if (isUpdate)
						subGroup.getKeys().getKey().add("" + index);

					AdditionalItems asitAdditems = subGroup.getAdditionalItems();
					if (isUpdate)
					{
						setValue(getAddItem("Child Record ID", asitAdditems), asiTValueMap.get(aisCodeAndType
								+ "Child Record ID" + "|" + rowIndex));
					}
					setDropdownValue(asiTValueMap.get(aisCodeAndType + cb.get("TypeOfAction") + "|" + rowIndex),
						"TypeOfAction", asitAdditems);
					setValue(getAddItem(cb.get("TankIDNumber"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("TankIDNumber") + "|" + rowIndex));
					setValue(getAddItem(cb.get("TankCapacityInGallons"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("TankCapacityInGallons") + "|" + rowIndex));

					setDropdownValue(asiTValueMap.get(aisCodeAndType + cb.get("TankContents") + "|" + rowIndex),
						"TankContents", asitAdditems);

					setValue(getAddItem(cb.get("OtherPetroleum"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("OtherPetroleum") + "|" + rowIndex));
					setValue(getAddItem(cb.get("OtherNonPetroleum"), asitAdditems), asiTValueMap.get(aisCodeAndType
							+ cb.get("OtherNonPetroleum") + "|" + rowIndex));

					parent.getAdditionalInformationSubGroup().add(subGroup);
				}
				if (index == 0)
				{
					addInfoGroup.remove(parent);
				}
				else
				{
					parent.getAdditionalInformationSubGroup().remove(asitSubGroup);
				}

			}
		}

	}

	private Long parseLong(String str)
	{
		try
		{
			if (str == null)
				return null;
			else
				return Long.parseLong(str);
		}
		catch (NumberFormatException ex)
		{
			return null;
		}
	}

	private String clear(String str, String fix)
	{
		if (str == null)
			return str;
		else
		{
			return str.replaceAll(fix, "");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public UpdateCAP convertToUpdateCAP(List<AdditionalInformation> additionInfos, Object currObject, String strDataSetDateTime,Object... objects)

	{
		FacilitySubmittalType facilitySubmittalType = (FacilitySubmittalType) currObject;
		List<AdditionalInformation> addInfos = additionInfos;
		CAPId capId = (CAPId) objects[0];
		countrys = (Map<String, String>) objects[1];
		UpdateCAP updateCap = new UpdateCAP();
		updateCap.setCAPId(capId);
		updateCap.setSystem(AuthService.getSystem());
		

		AdditionalInformation addCopy = addInfos.get(0).clone();
		CAP capBasic = null;
		if (objects.length > 2)
		{
			capBasic = (CAP) objects[2];
		}
		
		if(capBasic != null)
		{
			List<AdditionalInformationGroup> groupFromDB = capBasic.getAdditionalInformation().getAdditionalInformationGroup();
			compareASIData(groupFromDB, addCopy.getAdditionalInformationGroup());
		}
		//Set original ASI value to AdditionalInformation.
		updateCap.setAdditionalInformation(addCopy);

		for (AdditionalInformationGroup ag : addCopy.getAdditionalInformationGroup())
		{
			List<AdditionalInformationSubGroup> ags = ag.getAdditionalInformationSubGroup();
			for (AdditionalInformationSubGroup asg : ags)
			{
				if (ag.isAddRemoveSubGroups())
				{// asit
					asg.setAction("Add");
				}
				else
				// asi
				{
					for (AdditionalItem ai : asg.getAdditionalItems().getAdditionalItem())
					{
						ai.setAction("Update");
					}
				}

			}

		}
		CAPDetail cpd = new CAPDetail();
		updateCap.setcAPDetail(cpd);

		cpd.setShortNotes(facilitySubmittalType.getCERSID() + "");
		
		if (facilitySubmittalType.getFacilityInformation() != null
				&& facilitySubmittalType.getFacilityInformation().getBusinessActivities() != null
				&& !isEmptyValue(facilitySubmittalType.getFacilityInformation().getBusinessActivities().getBusinessName()) )
		{
			updateCap.setName(facilitySubmittalType.getFacilityInformation().getBusinessActivities().getBusinessName());
		}

		// DetailAddresses dar = new DetailAddresses();
		// updateCap.setAddresses(dar);
		// setAddress(facilitySubmittalType, dar);
		// // setContact

		
		if(capBasic != null)
		{
			updateCap.setStatus(capBasic.getStatus());
		}
		Contacts contacts = new Contacts();
		updateCap.setContacts(contacts);
		setContact(facilitySubmittalType, contacts, false);
		setContactUnderStorage(facilitySubmittalType, contacts, true);
		if (capBasic != null && capBasic.getContacts() != null && capBasic.getContacts().getContact() != null)
		{			
			List<Contact> lcon = capBasic.getContacts().getContact();
			for (Contact con : lcon)
			{
				String type = "";
				if (con.getKeys() != null && con.getKeys().getKey() != null && con.getKeys().getKey().size() >= 2)
				{
					type = con.getKeys().getKey().get(1);
				}
				
				if (!"OWNER".equalsIgnoreCase(type) || ("OWNER".equalsIgnoreCase(type) && AdapterConstants.SYNC_OWNER))
				{
					con.setAction("Delete");
					// First to delete the contact then add it.
					contacts.getContact().add(0, con);
				}
			}

		}

		if (capBasic != null && capBasic.getCAPDetail() != null)
		{
			capBasic.getCAPDetail().setShortNotes(cpd.getShortNotes());
			updateCap.setcAPDetail(capBasic.getCAPDetail());

		}

		// asi deal
		List<AdditionalInformationGroup> addInfoGroup = updateCap.getAdditionalInformation()
				.getAdditionalInformationGroup();
		AdditionalInformationSubGroup addSubGroup = (AdditionalInformationSubGroup) getAddInfoSubGroup(addInfoGroup,
			"DEH_HUPF_T27", "CERS COLLECTED INFO")[1];
		setFiciliyAsi(addSubGroup, facilitySubmittalType);
//		ParcelIds pids=new ParcelIds();
//		OwnerOperatorInformationType ooi = facilitySubmittalType.getFacilityInformation().getOwnerOperatorInformation();
//		if(ooi!=null){
//			ParcelId pid=new ParcelId();
//			pid.setValue(ooi.getAssessorParcelNumber());
//			pid.setIdentifierDisplay(ooi.getAssessorParcelNumber());
//			pids.getParcelId().add(pid);
//			updateCap.setParcelIds(pids);
//		}

		// Eric fixed to add facility ASIT for "Data Exchange Details"
		setFiciliyAsit(facilitySubmittalType, addInfoGroup, true,strDataSetDateTime, capBasic);
		// asit deal
		setChemicalAsit(facilitySubmittalType, addInfoGroup, true); //Sync 
		// Remote Waste Consolidation Site Annual Notification asit --Hazardous Waste
		setHazarousWasteAsit(addInfoGroup, facilitySubmittalType, true);
		// #Certification Of Financial Assurance /Onsite Hazardous Waste Treatment Notification - Facility asi
		setHazarousWasteAsi(addInfoGroup, facilitySubmittalType);
		// #UST Operating Permit Application - Facility Information
		setUstAsi(addInfoGroup, facilitySubmittalType); // Sync

		// #UST Certification of Installation / Modification asit
		setUstAsit(addInfoGroup, facilitySubmittalType, true);
		List<AdditionalInformationGroup> group = addCopy.getAdditionalInformationGroup();
		AdditionalInformationGroup ag = null;
		String needUpdatedASITName= (String)cb.get("NeedUpdatedASIT4Facility");
		
		for (int i = 0; i < group.size();i++)
		{
			ag = group.get(i);
			//boolean flag = false;
			if (ag.isAddRemoveSubGroups())
			{// asit
				List<AdditionalInformationSubGroup> ags = ag.getAdditionalInformationSubGroup();
				for (AdditionalInformationSubGroup asg : ags)
				{
					if (asg.getKeys().getKey().size() == 1)
					{
						asg.getKeys().getKey().add("-1");
					//	flag = true;
						break;
					}
				}
			}
		
		}
		
		
		for (int i = group.size() - 1; i >= 0; i--)
		{
			ag = group.get(i);
			String identifierDisplay = ag.getIdentifierDisplay();
			if (!needUpdatedASITName.contains(identifierDisplay))
			{
				group.remove(i);
			}
		}
		return updateCap;
	}
	
	
	/**
	 * 
	 * Compare the ASI structure from existing ASI item with configured ASI itme.
	 *
	 * @param groupFromDB this is existing ASI item. 
	 * @param group this is configured ASI item.
	 */
	private void compareASIData(List<AdditionalInformationGroup> groupFromDB, List<AdditionalInformationGroup> group)
	{
		for (AdditionalInformationGroup agDB : groupFromDB)
		{
			if(agDB.isAddRemoveSubGroups() == false)
			{
				String groupCodeFromDB = agDB.getKeys().getKey().get(0);
				int groupIndex = getGroupIndex4ASI(group, groupCodeFromDB);
				if(groupIndex == -1)
				{
					group.add(agDB);
					LOGGER.debug("compareASIData=>groupCodeFromDB:" + groupCodeFromDB);
				}
				else
				{
					List<AdditionalInformationSubGroup> subGroupList = agDB.getAdditionalInformationSubGroup();
					for (AdditionalInformationSubGroup asgDB : subGroupList)
					{
						String subGroupNameFromDB = asgDB.getKeys().getKey().get(0);
						int subGroupIndex = getSubGroupIndex4ASI(group, groupIndex, subGroupNameFromDB);
						if(subGroupIndex == -1)
						{
							group.get(groupIndex).getAdditionalInformationSubGroup().add(asgDB);
							LOGGER.debug("compareASIData=>subGroupNameFromDB:" + subGroupNameFromDB);
						}
						else
						{
							List<AdditionalItem> itemList = asgDB.getAdditionalItems().getAdditionalItem();
							AdditionalItems asitAdditems = group.get(groupIndex).getAdditionalInformationSubGroup().get(subGroupIndex).getAdditionalItems();
							for (AdditionalItem item : itemList)
							{
								String itemNameFromDB = item.getKeys().getKey().get(0);
								int itemIndex = getItemIndex4ASI(group, groupIndex, subGroupIndex, itemNameFromDB);
								if (itemIndex == -1)
								{
									asitAdditems.getAdditionalItem().add(item);
									LOGGER.debug("compareASIData=>itemNameFrom:" + itemNameFromDB);
								}
								else
								{// Set the default value for ASI.
									setValue(getAddItem(itemNameFromDB, asitAdditems), item.getValue());
								}
							}
						}
					}
				}
			}
		}
	}
	
	private int getGroupIndex4ASI(List<AdditionalInformationGroup> groupList, String groupCode)
	{
		
		String tempStr = "";
		int iIndex = -1;
		int i = 0;
		for (AdditionalInformationGroup ag : groupList)
		{
			tempStr = ag.getKeys().getKey().get(0);
			if(groupCode.equals(tempStr) && ag.isAddRemoveSubGroups() == false)
			{
				iIndex = i++;
				break;
			}
			i++;
		}
		return iIndex;
	}
	
	private int getSubGroupIndex4ASI(List<AdditionalInformationGroup> groupList, int groupIndex, String subGroup)
	{
		String tempStr = "";
		int iIndex = -1;
		int i = 0;
		List<AdditionalInformationSubGroup> subGroupList = groupList.get(groupIndex).getAdditionalInformationSubGroup();
		for (AdditionalInformationSubGroup asg : subGroupList)
		{
			tempStr = asg.getKeys().getKey().get(0);
			if (subGroup.equals(tempStr))
			{
				iIndex = i;
				break;
			}
			i++;
		}

		return iIndex;
	}
	
	private int getItemIndex4ASI(List<AdditionalInformationGroup> groupList, int groupIndex, int subGroupIndex, String itemName)
	{

		String tempStr = "";
		int iIndex = -1;
		int i = 0;

		List<AdditionalItem> itemList = groupList.get(groupIndex).getAdditionalInformationSubGroup().get(subGroupIndex)
				.getAdditionalItems().getAdditionalItem();
		for (AdditionalItem item : itemList)
		{
			tempStr = item.getKeys().getKey().get(0);
			if (itemName.equals(tempStr))
			{
				iIndex = i;
				break;
			}
			i++;
		}
		return iIndex;
	}
	
	
	// Eric fixed to add facility ASIT for "Data Exchange Details"
	private void setFiciliyAsit(FacilitySubmittalType facilitySubmittalType,
			List<AdditionalInformationGroup> addInfoGroup, boolean isUpdate,String strDataSetDateTime,CAP capBasic)
	{
		
		Object FaclAsitSubGroup[] = getAddInfoSubGroup(addInfoGroup, "DEH_HUPF_T27", "DATA EXCHANGE DETAILS");
		AdditionalInformationSubGroup asitSubGroup = (AdditionalInformationSubGroup) FaclAsitSubGroup[1];
		AdditionalInformationGroup parent = (AdditionalInformationGroup) FaclAsitSubGroup[0];
		
		
		
		int index = -1;
		for (int i = 0; i < 9; i++)
		{
			SubmittalElementHeaderType seht = null;
			if (i == 0 && facilitySubmittalType.getFacilityInformation() != null
					&& facilitySubmittalType.getFacilityInformation().getSubmittalElementHeader() != null
					&& CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType.getFacilityInformation().getSubmittalElementHeader().getSubmittalStatus()))
			{
				seht = facilitySubmittalType.getFacilityInformation().getSubmittalElementHeader();
			}
			else if (i == 1 && facilitySubmittalType.getHazardousMaterialsInventory() != null
					&& facilitySubmittalType.getHazardousMaterialsInventory().getSubmittalElementHeader() != null
					&& CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType.getHazardousMaterialsInventory().getSubmittalElementHeader().getSubmittalStatus()))
			{
				seht = facilitySubmittalType.getHazardousMaterialsInventory().getSubmittalElementHeader();
			}
			else if (i == 2 && facilitySubmittalType.getEmergencyResponseTrainingPlans() != null
					&& facilitySubmittalType.getEmergencyResponseTrainingPlans().getSubmittalElementHeader() != null
					&& CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType.getEmergencyResponseTrainingPlans().getSubmittalElementHeader().getSubmittalStatus()))
			{
				seht = facilitySubmittalType.getEmergencyResponseTrainingPlans().getSubmittalElementHeader();
			}
			else if (i == 3 && facilitySubmittalType.getUndergroundStorageTanks() != null
					&& facilitySubmittalType.getUndergroundStorageTanks().getSubmittalElementHeader() != null
					&& CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType.getUndergroundStorageTanks().getSubmittalElementHeader().getSubmittalStatus()))
			{
				seht = facilitySubmittalType.getUndergroundStorageTanks().getSubmittalElementHeader();
			}
			else if (i == 4
					&& facilitySubmittalType.getOnsiteHazardousWasteTreatmentNotification() != null
					&& facilitySubmittalType.getOnsiteHazardousWasteTreatmentNotification().getSubmittalElementHeader() != null
					&& CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType.getOnsiteHazardousWasteTreatmentNotification().getSubmittalElementHeader().getSubmittalStatus()))
			{
				seht = facilitySubmittalType.getOnsiteHazardousWasteTreatmentNotification().getSubmittalElementHeader();
			}
			else if (i == 5 && facilitySubmittalType.getRecyclableMaterialsReport() != null
					&& facilitySubmittalType.getRecyclableMaterialsReport().getSubmittalElementHeader() != null
					&& CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType.getRecyclableMaterialsReport().getSubmittalElementHeader().getSubmittalStatus()))
			{
				seht = facilitySubmittalType.getRecyclableMaterialsReport().getSubmittalElementHeader();
			}
			else if (i == 6
					&& facilitySubmittalType.getRemoteWasteConsolidationsAnnualNotification() != null
					&& facilitySubmittalType.getRemoteWasteConsolidationsAnnualNotification().getSubmittalElementHeader() != null
					&& CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType.getRemoteWasteConsolidationsAnnualNotification().getSubmittalElementHeader().getSubmittalStatus()))
			{
				seht = facilitySubmittalType.getRemoteWasteConsolidationsAnnualNotification()
						.getSubmittalElementHeader();
			}
			else if (i == 7
					&& facilitySubmittalType.getHWTankClosureCertification() != null
					&& facilitySubmittalType.getHWTankClosureCertification().getSubmittalElementHeader() != null
					&& CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType.getHWTankClosureCertification().getSubmittalElementHeader().getSubmittalStatus()))
			{
				seht = facilitySubmittalType.getHWTankClosureCertification().getSubmittalElementHeader();
			}
			else if (i == 8
					&& facilitySubmittalType.getAbovegroundPetroleumStorageTanks() != null
					&& facilitySubmittalType.getAbovegroundPetroleumStorageTanks().getSubmittalElementHeader() != null
					&& CapServiceCommon.SUBMITTAL_STATUS.equals(facilitySubmittalType.getAbovegroundPetroleumStorageTanks().getSubmittalElementHeader().getSubmittalStatus()))
			{
				seht = facilitySubmittalType.getAbovegroundPetroleumStorageTanks().getSubmittalElementHeader();
			}

			if(seht == null)
			{
				continue;
			}
			AdditionalInformationSubGroup subGroup = asitSubGroup.clone();
			if (isUpdate)
			{
				subGroup.getKeys().getKey().add(index-- + "");
				subGroup.setAction("Add");
			}
			AdditionalItems asitAdditems = subGroup.getAdditionalItems();

			setValue(getAddItem("CUPA Element Submitted", asitAdditems), submittalElementType[i]);
			setValue(getAddItem(cb.get("CERSUniqueKey"), asitAdditems), seht.getCERSUniqueKey());
			setValue(getAddItem(cb.get("DataSetDate"), asitAdditems), strDataSetDateTime);
			setValue(getAddItem(cb.get("SubmittedOn"), asitAdditems), seht.getSubmittedOn());

			setValue(getAddItem(cb.get("SubmittedByName"), asitAdditems), seht.getSubmittedByFirstName() + " "
					+ seht.getSubmittedByLastName());
			if (CapServiceCommon.SUBMITTAL_STATUS.equals(seht.getSubmittalStatus()))
			{
				setValue(getAddItem(cb.get("SubmittalStatus"), asitAdditems), "Accepted");
			}
			else
			{
				setValue(getAddItem(cb.get("SubmittalStatus"), asitAdditems), "Not Accepted");
			}
			

			setValue(getAddItem(cb.get("SubmittalActionAgentName"), asitAdditems), seht.getSubmittalActionDetails()
					.getSubmittalActionAgentName());
			setValue(getAddItem(cb.get("SubmittalActionOn"), asitAdditems), seht.getSubmittalActionDetails()
					.getSubmittalActionOn());
			if (seht.getSubmittalActionDetails().getSubmittalActionComments() != null)
			{
				setValue(getAddItem(cb.get("SubmittalActionComments"), asitAdditems), seht.getSubmittalActionDetails()
						.getSubmittalActionComments());
			}

			Long all = CapServiceCommon.count.get("document.all") == null ? 0L : CapServiceCommon.count
					.get("document.all");
			String isExistsAttachment = "No";
			if (all > 0)
			{
				isExistsAttachment = "Yes";
			}
			setValue(getAddItem(cb.get("Attachment_ASIT"), asitAdditems), isExistsAttachment);
			parent.getAdditionalInformationSubGroup().add(subGroup);
		}
		parent.getAdditionalInformationSubGroup().remove(asitSubGroup);
		if (capBasic != null && capBasic.getAdditionalInformation() != null
				&& capBasic.getAdditionalInformation().getAdditionalInformationGroup() != null)
		{
			List<AdditionalInformationGroup> addInfoGroup4Existed = capBasic.getAdditionalInformation().getAdditionalInformationGroup();
			Collection<AdditionalInformationSubGroup> subGroup4Existed = getAddInfoSubGroup4Existed(addInfoGroup4Existed, "DEH_HUPF_T27", "DATA EXCHANGE DETAILS");
			int indexI = 0;
			for (Iterator<AdditionalInformationSubGroup> iterSubGroup = subGroup4Existed.iterator(); iterSubGroup
					.hasNext();)
			{
				if(indexI >0 )
				{
					AdditionalInformationSubGroup subGroup = iterSubGroup.next();
					Keys keys=new Keys();
					keys.getKey().add(subGroup.getKeys().getKey().get(0));
					keys.getKey().add(index--+"");
					subGroup.setKeys(keys);
					parent.getAdditionalInformationSubGroup().add(subGroup);
				}
				indexI++;
			}
		}
		
	}
	
	private AdditionalInformation buildContactTemplate(String templateName, String fieldName, String value)
	{
		
		AdditionalInformation additionalInformation = new AdditionalInformation();
		AdditionalInformationGroup additionalInformationGroup = new AdditionalInformationGroup();
		Keys groupKeys = new Keys();
		groupKeys.getKey().add(templateName);
		additionalInformationGroup.setKeys(groupKeys);
		additionalInformationGroup.setIdentifierDisplay(templateName);
		additionalInformationGroup.setSecurity("F");
		
		AdditionalInformationSubGroup additionalInformationSubGroup = new AdditionalInformationSubGroup();
		Keys subKeys = new Keys();
		subKeys.getKey().add(templateName);
		additionalInformationSubGroup.setKeys(subKeys);
		additionalInformationSubGroup.setSecurity("F");
		additionalInformationSubGroup.setAction("Existing");
		
		
		AdditionalItem additionItem = new AdditionalItem();
		Keys itemKeys = new Keys();
		itemKeys.getKey().add(fieldName);
		additionItem.setKeys(itemKeys);
		additionItem.setAction("Add");
		additionItem.setIdentifierDisplay(fieldName);
		additionItem.setName(fieldName);
		additionItem.setValue(value);
		additionItem.setSecurity("F");
		additionItem.setDrillDown(false);
		DataType dataType = new DataType();
		dataType.setType("String");
		dataType.setFieldType("Text");
		dataType.setReadOnly(false);
		InputRange inputRange = new InputRange();
		inputRange.setMaxValue(30d);
		dataType.setInputRange(inputRange);
		additionItem.setDataType(dataType);
		
		if (additionalInformationSubGroup.getAdditionalItems() == null)
		{
			additionalInformationSubGroup.setAdditionalItems(new AdditionalItems());
		}
		additionalInformationSubGroup.getAdditionalItems().getAdditionalItem().add(additionItem);
		additionalInformationSubGroup.setKeys(subKeys);
		additionalInformationGroup.getAdditionalInformationSubGroup().add(additionalInformationSubGroup);
		additionalInformation.getAdditionalInformationGroup().add(additionalInformationGroup);
		return additionalInformation;
	}

}

/*
 * $Log: av-env.bat,v $
 */
