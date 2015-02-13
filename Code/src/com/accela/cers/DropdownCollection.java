package com.accela.cers;

import java.util.HashMap;
import java.util.Map;

public class DropdownCollection
{

	private static Map<String, Map<String, String>> abcDesc =null;

	public static Map<String, Map<String, String>> getABCDesc()
	{
		if(abcDesc==null || abcDesc.size()==0)
		{
			//Units (221)--Units_1
			abcDesc= new HashMap<String, Map<String, String>>();
			Map<String, String> unitMap = new HashMap<String, String>();
			unitMap.put("a", "gallons");
			unitMap.put("b", "cubic feet");
			unitMap.put("c", "pounds");
			unitMap.put("d", "tons");
			abcDesc.put("Units_1", unitMap);
			//Hazardous Material Type (211)--HMType
			Map<String, String> HMTypeMap = new HashMap<String, String>();
			HMTypeMap.put("a", "Pure");
			HMTypeMap.put("b", "Mixture");
			HMTypeMap.put("c", "Waste");
			abcDesc.put("HMType", HMTypeMap);
			//Physical State (214)-PhysicalState
			Map<String, String> PhysicalStateMap = new HashMap<String, String>();
			PhysicalStateMap.put("a", "Solid");
			PhysicalStateMap.put("b", "Liquid");
			PhysicalStateMap.put("c", "Gas");
			abcDesc.put("PhysicalState", PhysicalStateMap);
			//Storage Pressure (224)-StoragePressure
			Map<String, String> StoragePressureMap = new HashMap<String, String>();
			StoragePressureMap.put("a", "Ambient");
			StoragePressureMap.put("b", "Above Ambient");
			StoragePressureMap.put("c", "Below Ambient");
			abcDesc.put("StoragePressure", StoragePressureMap);

			//Storage Temperature (225)-StorageTemperature
			Map<String, String> StorageTemperatureMap = new HashMap<String, String>();
			StorageTemperatureMap.put("a", "Ambient");
			StorageTemperatureMap.put("b", "Above Ambient");
			StorageTemperatureMap.put("c", "Below Ambient");
			StorageTemperatureMap.put("d", "Cryogenic");
			abcDesc.put("StorageTemperature", StorageTemperatureMap);

			//DOT Hazard Classification Identifier (252)-DOTHazardClassificationID
			Map<String, String> DOTHazardClassificationIDMap = new HashMap<String, String>();
			DOTHazardClassificationIDMap.put("1.1", "1.1 - Mass Explosive Hazard");
			DOTHazardClassificationIDMap.put("1.2", "1.2 - Projection Hazard");
			DOTHazardClassificationIDMap.put("1.3", "1.3 - Fire and/or Minor Blast/Projection Hazard");
			DOTHazardClassificationIDMap.put("1.4", "1.4 - Fire and/or Minor Blast/Projection Hazard");
			DOTHazardClassificationIDMap.put("1.5", "1.5 - Very Insensitive with Mass Explosion Hazard");
			DOTHazardClassificationIDMap.put("1.6", "1.6 - Extremely Insensitive; No Mass Explosion Hazard");
			DOTHazardClassificationIDMap.put("2.1", "2.1 - Flammable Gases");
			DOTHazardClassificationIDMap.put("2.2", "2.2 - Nonflammable Gases");
			DOTHazardClassificationIDMap.put("2.3", "2.3 - Toxic Gases");
			DOTHazardClassificationIDMap.put("3", "3 - Flammable and Combustible Liquids");
			DOTHazardClassificationIDMap.put("4.1", "4.1 - Flammable Solids");
			DOTHazardClassificationIDMap.put("4.2", "4.2 - Spontaneously Combustible");

			DOTHazardClassificationIDMap.put("4.3", "4.3 - Dangerous When Wet");
			DOTHazardClassificationIDMap.put("5.1", "5.1 - Oxidizing Substances");
			DOTHazardClassificationIDMap.put("5.2", "5.2 - Organic Peroxides");
			DOTHazardClassificationIDMap.put("6.1", "6.1 - Toxic Substances");
			DOTHazardClassificationIDMap.put("6.2", "6.2 - Infectious Substances");
			DOTHazardClassificationIDMap.put("7", "7 - Radioactive Material");
			DOTHazardClassificationIDMap.put("8", "8 - Corrosives (Liquids and Solids)");
			DOTHazardClassificationIDMap.put("9", "9 - Misc. Hazardous Materials");
			abcDesc.put("DOTHazardClassificationID", DOTHazardClassificationIDMap);

			//Tank Contents (440)-TankContents
			Map<String, String> TankContentsMap = new HashMap<String, String>();
			TankContentsMap.put("1a", "Regular Unleaded");
			TankContentsMap.put("1b", "Premium Unleaded");
			TankContentsMap.put("1c", "Midgrade Unleaded");
			TankContentsMap.put("03", "Diesel");
			TankContentsMap.put("05", "Jet Fuel");
			TankContentsMap.put("06", "Aviation  Gas");
			TankContentsMap.put("07", "Used Oil");
			TankContentsMap.put("08", "Petroleum Blend Fuel");
			TankContentsMap.put("09", "Other Petroleum");
			TankContentsMap.put("10", "Ethanol");
			TankContentsMap.put("11", "Other Non-petroleum");
			abcDesc.put("TankContents", TankContentsMap);

			//Type of Action (430)-TypeOfAction
			Map<String, String> TypeOfActionMap = new HashMap<String, String>();
			TypeOfActionMap.put("5", "Confirmed/Updated Information");
			TypeOfActionMap.put("1", "New Permit");
			TypeOfActionMap.put("3", "Renewal Permit");
			TypeOfActionMap.put("6", "Temporary UST Closure");
			TypeOfActionMap.put("7", "UST Permanent Closure on Site");
			TypeOfActionMap.put("8", "UST Removal");
			abcDesc.put("TypeOfAction", TypeOfActionMap);

			//01/31/2013

			//TankConfiguration=Tank Configuration (434)
			Map<String, String> TankConfigurationMap = new HashMap<String, String>();
			TankConfigurationMap.put("1", "A Stand-alone Tank");
			TankConfigurationMap.put("2", "One in a Compartmented Unit");
			abcDesc.put("TankConfiguration", TankConfigurationMap);

			//TankUse=Tank Use (439)
			Map<String, String> TankUseMap = new HashMap<String, String>();
			TankUseMap.put("1a", "Motor Vehicle Fueling");
			TankUseMap.put("1b", "Marina Fueling");
			TankUseMap.put("1c", "Aviation Fueling");
			TankUseMap.put("03", "Chemical Product Storage");
			TankUseMap.put("04", "Hazardous Waste (includes used oil)");
			TankUseMap.put("05", "Emergency Generator Fuel");
			TankUseMap.put("06", "Other Generator Fuel");
			TankUseMap.put("95", "Unknown");
			TankUseMap.put("99", "Other");
			abcDesc.put("TankUse", TankUseMap);

			//TypeOfTank=Type of Tank (443)
			Map<String, String> TypeOfTankMap = new HashMap<String, String>();
			TypeOfTankMap.put("01", "Single Wall");
			TypeOfTankMap.put("02", "Double Wall");
			TypeOfTankMap.put("95", "Unknown");
			abcDesc.put("TypeOfTank", TypeOfTankMap);
			//TankPCConstruction=Tank Primary Containment Construction  (444)
			Map<String, String> TankPCConstructionMap = new HashMap<String, String>();
			TankPCConstructionMap.put("01", "Steel");
			TankPCConstructionMap.put("03", "Fiberglass");
			TankPCConstructionMap.put("06", "Internal Bladder");
			TankPCConstructionMap.put("07", "Steel + Internal Lining");
			TankPCConstructionMap.put("95", "Unknown");
			TankPCConstructionMap.put("99", "Other");
			abcDesc.put("TankPCConstruction", TankPCConstructionMap);

			//TankSCConstruction=Tank Secondary Containment Construction (445)
			Map<String, String> TankSCConstructionMap = new HashMap<String, String>();
			TankSCConstructionMap.put("01", "Steel");
			TankSCConstructionMap.put("03", "Fiberglass");
			TankSCConstructionMap.put("06", "Exterior Membrane Liner");
			TankSCConstructionMap.put("07", "Jacketed");
			TankSCConstructionMap.put("90", "None");
			TankSCConstructionMap.put("95", "Unknown");
			TankSCConstructionMap.put("99", "Other");
			abcDesc.put("TankSCConstruction", TankSCConstructionMap);

			//PipingSystemType=Piping System Type (458)
			Map<String, String> PipingSystemTypeMap = new HashMap<String, String>();
			PipingSystemTypeMap.put("01", "Pressure");
			PipingSystemTypeMap.put("02", "Gravity");
			PipingSystemTypeMap.put("03", "Conventional Suction");
			PipingSystemTypeMap.put("04", "23 CCR §2636(a)(3) Suction");
			abcDesc.put("PipingSystemType", PipingSystemTypeMap);

			//PWPipingPCConstruction=Product/Waste Piping Primary Containment Construction (464)
			Map<String, String> PWPipingPCConstructionMap = new HashMap<String, String>();
			PWPipingPCConstructionMap.put("01", "Steel");
			PWPipingPCConstructionMap.put("04", "Fiberglass");
			PWPipingPCConstructionMap.put("08", "Flexible");
			PWPipingPCConstructionMap.put("10", "Rigid Plastic");
			PWPipingPCConstructionMap.put("90", "None");
			PWPipingPCConstructionMap.put("95", "Unknown");
			PWPipingPCConstructionMap.put("99", "Other");
			abcDesc.put("PWPipingPCConstruction", PWPipingPCConstructionMap);

			//PWPipingSCConstruction=Product/Waste Piping Secondary Containment Construction (464b)
			Map<String, String> PWPipingSCConstructionMap = new HashMap<String, String>();
			PWPipingSCConstructionMap.put("01", "Steel");
			PWPipingSCConstructionMap.put("04", "Fiberglass");
			PWPipingSCConstructionMap.put("08", "Flexible");
			PWPipingSCConstructionMap.put("10", "Rigid Plastic");
			PWPipingSCConstructionMap.put("90", "None");
			PWPipingSCConstructionMap.put("95", "Unknown");
			PWPipingSCConstructionMap.put("99", "Other");
			abcDesc.put("PWPipingSCConstruction", PWPipingSCConstructionMap);

			//PTContainmentSump=Piping/Turbine Containment Sump Type (464d)
			Map<String, String> PTContainmentSumpMap = new HashMap<String, String>();
			PTContainmentSumpMap.put("01", "Single-walled");
			PTContainmentSumpMap.put("02", "Double-walled");
			PTContainmentSumpMap.put("90", "None");
			abcDesc.put("PTContainmentSump", PTContainmentSumpMap);

			//VPPCConstruction=Vent Piping Primary Containment Construction (464e)
			Map<String, String> VPPCConstructionMap = new HashMap<String, String>();
			VPPCConstructionMap.put("01", "Steel");
			VPPCConstructionMap.put("04", "Fiberglass");
			VPPCConstructionMap.put("10", "Rigid Plastic");
			VPPCConstructionMap.put("90", "None");
			VPPCConstructionMap.put("99", "Other");
			abcDesc.put("VPPCConstruction", VPPCConstructionMap);

			//VPSCConstruction=Vent Piping Secondary Containment Construction (464f)
			Map<String, String> VPSCConstructionMap = new HashMap<String, String>();
			VPSCConstructionMap.put("01", "Steel");
			VPSCConstructionMap.put("04", "Fiberglass");
			VPSCConstructionMap.put("10", "Rigid Plastic");
			VPSCConstructionMap.put("90", "None");
			VPSCConstructionMap.put("99", "Other");
			abcDesc.put("VPSCConstruction", VPSCConstructionMap);

			//VPTransitionSumps=Vent Piping Transition Sump Type (464i)
			Map<String, String> VPTransitionSumpsMap = new HashMap<String, String>();
			VPTransitionSumpsMap.put("01", "Single-walled");
			VPTransitionSumpsMap.put("02", "Double-walled");
			VPTransitionSumpsMap.put("90", "None");
			abcDesc.put("VPTransitionSumps", VPTransitionSumpsMap);

			//VRPipingPCConstruction=Vapor Recovery Piping Primary Containment Construction (464g)
			Map<String, String> VRPipingPCConstructionMap = new HashMap<String, String>();
			VRPipingPCConstructionMap.put("01", "Steel");
			VRPipingPCConstructionMap.put("04", "Fiberglass");
			VRPipingPCConstructionMap.put("10", "Rigid Plastic");
			VRPipingPCConstructionMap.put("90", "None");
			VRPipingPCConstructionMap.put("99", "Other");
			abcDesc.put("VRPipingPCConstruction", VRPipingPCConstructionMap);

			//VRPipingSCConstruction=Vapor Recovery Piping Secondary Containment Construction (464h)
			Map<String, String> VRPipingSCConstructionMap = new HashMap<String, String>();
			VRPipingSCConstructionMap.put("01", "Steel");
			VRPipingSCConstructionMap.put("04", "Fiberglass");
			VRPipingSCConstructionMap.put("10", "Rigid Plastic");
			VRPipingSCConstructionMap.put("90", "None");
			VRPipingSCConstructionMap.put("99", "Other");
			abcDesc.put("VRPipingSCConstruction", VRPipingSCConstructionMap);

			//RPPCConstruction=Riser Pipe Primary Containment Construction (464j)
			Map<String, String> RPPCConstructionMap = new HashMap<String, String>();
			RPPCConstructionMap.put("01", "Steel");
			RPPCConstructionMap.put("04", "Fiberglass");
			RPPCConstructionMap.put("10", "Rigid Plastic");
			RPPCConstructionMap.put("90", "None");
			RPPCConstructionMap.put("99", "Other");
			abcDesc.put("RPPCConstruction", RPPCConstructionMap);

			//RPSCConstruction=Riser Pipe Secondary Containment Construction (464k)
			Map<String, String> RPSCConstructionMap = new HashMap<String, String>();
			RPSCConstructionMap.put("01", "Steel");
			RPSCConstructionMap.put("04", "Fiberglass");
			RPSCConstructionMap.put("10", "Rigid Plastic");
			RPSCConstructionMap.put("90", "None");
			RPSCConstructionMap.put("99", "Other");
			abcDesc.put("RPSCConstruction", RPSCConstructionMap);

			//UDCConstructionType=Under Dispenser Containment Construction Type (469a)
			Map<String, String> UDCConstructionTypeMap = new HashMap<String, String>();
			UDCConstructionTypeMap.put("01", "Single-walled");
			UDCConstructionTypeMap.put("02", "Double-walled");
			UDCConstructionTypeMap.put("03", "No Dispensers");
			abcDesc.put("UDCConstructionType", UDCConstructionTypeMap);

			//UDCConstructionMaterial=Under Dispenser Containment Construction Material (469b)
			Map<String, String> UDCConstructionMaterialMap = new HashMap<String, String>();
			UDCConstructionMaterialMap.put("01", "Steel");
			UDCConstructionMaterialMap.put("04", "Fiberglass");
			UDCConstructionMaterialMap.put("10", "Rigid Plastic");
			UDCConstructionMaterialMap.put("15", "Concrete");
			UDCConstructionMaterialMap.put("90", "None");
			UDCConstructionMaterialMap.put("99", "Other");
			abcDesc.put("UDCConstructionMaterial", UDCConstructionMaterialMap);

//			PFCodeHazardClass=Primary Fire Code Hazard Class (210a)
			Map<String, String> PFCodeHazardClassMap = new HashMap<String, String>();
			PFCodeHazardClassMap.put("1", "Carcinogen");
			PFCodeHazardClassMap.put("2", "Combustible Liquid, Class II");
			PFCodeHazardClassMap.put("3", "Combustible Liquid, Class III-A");
			PFCodeHazardClassMap.put("4", "Combustible Liquid, Class III-B");
			PFCodeHazardClassMap.put("5", "Corrosive");

			PFCodeHazardClassMap.put("6", "Cryogen");
			PFCodeHazardClassMap.put("7", "Explosive");
			PFCodeHazardClassMap.put("8", "Flammable Gas");
			PFCodeHazardClassMap.put("9", "Flammable Liquid, Class I-A");
			PFCodeHazardClassMap.put("10", "Flammable Liquid, Class I-B");

			PFCodeHazardClassMap.put("11", "Flammable Liquid, Class I-C");
			PFCodeHazardClassMap.put("12", "Flammable Solid");
			PFCodeHazardClassMap.put("13", "Highly Toxic");
			PFCodeHazardClassMap.put("14", "Irritant");
			PFCodeHazardClassMap.put("15", "Liquified Petroleum Gas");

			PFCodeHazardClassMap.put("16", "Magnesium");
			PFCodeHazardClassMap.put("17", "Oxidizing, Class 1");
			PFCodeHazardClassMap.put("18", "Oxidizing, Class 2");
			PFCodeHazardClassMap.put("19", "Oxidizing, Class 3");
			PFCodeHazardClassMap.put("20", "Oxidizing, Class 4");

			PFCodeHazardClassMap.put("21", "Oxidizing Gas, Gaseous");
			PFCodeHazardClassMap.put("22", "Oxidizing Gas, Liquified");
			PFCodeHazardClassMap.put("23", "Organic Peroxide, Class I");
			PFCodeHazardClassMap.put("24", "Organic Peroxide, Class II");
			PFCodeHazardClassMap.put("25", "Organic Peroxide, Class III");


			PFCodeHazardClassMap.put("26", "Organic Peroxide, Class IV");
			PFCodeHazardClassMap.put("27", "Other Health Hazard");
			PFCodeHazardClassMap.put("28", "Pyrophoric");
			PFCodeHazardClassMap.put("29", "Radioactive");
			PFCodeHazardClassMap.put("30", "Sensitizer");

			PFCodeHazardClassMap.put("31", "Toxic");
			PFCodeHazardClassMap.put("32", "Unstable (Reactive), Class 1");
			PFCodeHazardClassMap.put("33", "Unstable (Reactive), Class 2");
			PFCodeHazardClassMap.put("34", "Unstable (Reactive), Class 3");
			PFCodeHazardClassMap.put("35", "Unstable (Reactive), Class 4");

			PFCodeHazardClassMap.put("36", "Water Reactive, Class 1");
			PFCodeHazardClassMap.put("37", "Water Reactive, Class 2");
			PFCodeHazardClassMap.put("38", "Water Reactive, Class 3");
			PFCodeHazardClassMap.put("39", "Other");

			abcDesc.put("PFCodeHazardClass", PFCodeHazardClassMap);

			//SFCodeHazardClass=Secondary Fire Code Hazard Class (210b)
			Map<String, String> SFCodeHazardClassMap = new HashMap<String, String>();
			SFCodeHazardClassMap.put("1", "Carcinogen");
			SFCodeHazardClassMap.put("2", "Combustible Liquid, Class II");
			SFCodeHazardClassMap.put("3", "Combustible Liquid, Class III-A");
			SFCodeHazardClassMap.put("4", "Combustible Liquid, Class III-B");
			SFCodeHazardClassMap.put("5", "Corrosive");

			SFCodeHazardClassMap.put("6", "Cryogen");
			SFCodeHazardClassMap.put("7", "Explosive");
			SFCodeHazardClassMap.put("8", "Flammable Gas");
			SFCodeHazardClassMap.put("9", "Flammable Liquid, Class I-A");
			SFCodeHazardClassMap.put("10", "Flammable Liquid, Class I-B");

			SFCodeHazardClassMap.put("11", "Flammable Liquid, Class I-C");
			SFCodeHazardClassMap.put("12", "Flammable Solid");
			SFCodeHazardClassMap.put("13", "Highly Toxic");
			SFCodeHazardClassMap.put("14", "Irritant");
			SFCodeHazardClassMap.put("15", "Liquified Petroleum Gas");

			SFCodeHazardClassMap.put("16", "Magnesium");
			SFCodeHazardClassMap.put("17", "Oxidizing, Class 1");
			SFCodeHazardClassMap.put("18", "Oxidizing, Class 2");
			SFCodeHazardClassMap.put("19", "Oxidizing, Class 3");
			SFCodeHazardClassMap.put("20", "Oxidizing, Class 4");

			SFCodeHazardClassMap.put("21", "Oxidizing Gas, Gaseous");
			SFCodeHazardClassMap.put("22", "Oxidizing Gas, Liquified");
			SFCodeHazardClassMap.put("23", "Organic Peroxide, Class I");
			SFCodeHazardClassMap.put("24", "Organic Peroxide, Class II");
			SFCodeHazardClassMap.put("25", "Organic Peroxide, Class III");


			SFCodeHazardClassMap.put("26", "Organic Peroxide, Class IV");
			SFCodeHazardClassMap.put("27", "Other Health Hazard");
			SFCodeHazardClassMap.put("28", "Pyrophoric");
			SFCodeHazardClassMap.put("29", "Radioactive");
			SFCodeHazardClassMap.put("30", "Sensitizer");

			SFCodeHazardClassMap.put("31", "Toxic");
			SFCodeHazardClassMap.put("32", "Unstable (Reactive), Class 1");
			SFCodeHazardClassMap.put("33", "Unstable (Reactive), Class 2");
			SFCodeHazardClassMap.put("34", "Unstable (Reactive), Class 3");
			SFCodeHazardClassMap.put("35", "Unstable (Reactive), Class 4");

			SFCodeHazardClassMap.put("36", "Water Reactive, Class 1");
			SFCodeHazardClassMap.put("37", "Water Reactive, Class 2");
			SFCodeHazardClassMap.put("38", "Water Reactive, Class 3");
			SFCodeHazardClassMap.put("39", "Other");
			abcDesc.put("SFCodeHazardClass", SFCodeHazardClassMap);

			//TypeOfOperation=Type of Operation (Hazardous Waste Financial Assurance) (701)
			Map<String, String> TypeOfOperationMap = new HashMap<String, String>();
			TypeOfOperationMap.put("a", "PBR-FTU");
			TypeOfOperationMap.put("b", "CA");
			abcDesc.put("TypeOfOperation", TypeOfOperationMap);

			//ExemptFromFA=Exemption From Financial Assurance (Cost Estimate <$10,000) (703)
			Map<String, String> ExemptFromFAMap = new HashMap<String, String>();
			ExemptFromFAMap.put("Y", "Yes");
			ExemptFromFAMap.put("N", "No");
			abcDesc.put("ExemptFromFA", ExemptFromFAMap);

			//ExemptFromFAOther=Exemption From Financial Assurance (Other) (704)
			Map<String, String> ExemptFromFAOtherMap = new HashMap<String, String>();
			ExemptFromFAOtherMap.put("Y", "Yes");
			ExemptFromFAOtherMap.put("N", "No");
			ExemptFromFAOtherMap.put("Narrative", "Narrative");
			abcDesc.put("ExemptFromFAOther", ExemptFromFAOtherMap);

			//ExemptFromFAPBR=Exemption From Financial Assurance (TTU) (705)
			Map<String, String> ExemptFromFAPBRMap = new HashMap<String, String>();
			ExemptFromFAPBRMap.put("Y", "Yes");
			ExemptFromFAPBRMap.put("N", "No");
			abcDesc.put("ExemptFromFAPBR", ExemptFromFAPBRMap);

			//ClosureAssuranceMechanism=Closure Assurance Mechanism (709)
			Map<String, String> ClosureAssuranceMechanismMap = new HashMap<String, String>();
			ClosureAssuranceMechanismMap.put("a", "Closure Trust Fund");
			ClosureAssuranceMechanismMap.put("b", "Surety Bond");
			ClosureAssuranceMechanismMap.put("c", "Closure Letter of Credit");
			ClosureAssuranceMechanismMap.put("d", "Closure Insurance");
			ClosureAssuranceMechanismMap.put("e", "Financial Test and Corporate Guarantee");
			ClosureAssuranceMechanismMap.put("f", "Alternative Mechanism");
			ClosureAssuranceMechanismMap.put("g", "Multiple Financial Mechanisms");
			ClosureAssuranceMechanismMap.put("h", "Certificate of Deposit");
			ClosureAssuranceMechanismMap.put("i", "Savings Account");
			abcDesc.put("ClosureAssuranceMechanism", ClosureAssuranceMechanismMap);

			//SignerOfCertification=Signer of Certification (715)
			Map<String, String> SignerOfCertificationMap = new HashMap<String, String>();
			SignerOfCertificationMap.put("a", "Owner");
			SignerOfCertificationMap.put("b", "Operator");
			abcDesc.put("SignerOfCertification", SignerOfCertificationMap);

			//CertifierRelationship=B3CONTACT_B1_COMMENT
			Map<String, String> CertifierRelationshipMap = new HashMap<String, String>();
			CertifierRelationshipMap.put("01", "Tank Owner");
			CertifierRelationshipMap.put("02", "Tank Operator");
			CertifierRelationshipMap.put("03", "Contractor");
			CertifierRelationshipMap.put("04", "Property Owner");
			CertifierRelationshipMap.put("05", "Other Authorized Agent of Tank Owner");
			abcDesc.put("CertifierRelationship", CertifierRelationshipMap);

			//OnsiteHWTreatment=Onsite Hazardous Waste Treatment (726)
			Map<String, String> OnsiteHWTreatmentMap = new HashMap<String, String>();
			OnsiteHWTreatmentMap.put("Y", "Yes");
			OnsiteHWTreatmentMap.put("N", "No");
			abcDesc.put("OnsiteHWTreatment", OnsiteHWTreatmentMap);

			//NonRCRAHW=Basis For No Fed Permit (Rem Consol) = Non-RCRA HW (729a)
			Map<String, String> NonRCRAHWMap = new HashMap<String, String>();
			NonRCRAHWMap.put("Y", "Yes");
			NonRCRAHWMap.put("N", "No");
			abcDesc.put("NonRCRAHW", NonRCRAHWMap);

			//TFCodeHazardClass=Third Fire Code Hazard Class (210c)
			Map<String, String> TFCodeHazardClassMap = new HashMap<String, String>();
			TFCodeHazardClassMap.put("1", "Carcinogen");
			TFCodeHazardClassMap.put("2", "Combustible Liquid, Class II");
			TFCodeHazardClassMap.put("3", "Combustible Liquid, Class III-A");
			TFCodeHazardClassMap.put("4", "Combustible Liquid, Class III-B");
			TFCodeHazardClassMap.put("5", "Corrosive");

			TFCodeHazardClassMap.put("6", "Cryogen");
			TFCodeHazardClassMap.put("7", "Explosive");
			TFCodeHazardClassMap.put("8", "Flammable Gas");
			TFCodeHazardClassMap.put("9", "Flammable Liquid, Class I-A");
			TFCodeHazardClassMap.put("10", "Flammable Liquid, Class I-B");

			TFCodeHazardClassMap.put("11", "Flammable Liquid, Class I-C");
			TFCodeHazardClassMap.put("12", "Flammable Solid");
			TFCodeHazardClassMap.put("13", "Highly Toxic");
			TFCodeHazardClassMap.put("14", "Irritant");
			TFCodeHazardClassMap.put("15", "Liquified Petroleum Gas");

			TFCodeHazardClassMap.put("16", "Magnesium");
			TFCodeHazardClassMap.put("17", "Oxidizing, Class 1");
			TFCodeHazardClassMap.put("18", "Oxidizing, Class 2");
			TFCodeHazardClassMap.put("19", "Oxidizing, Class 3");
			TFCodeHazardClassMap.put("20", "Oxidizing, Class 4");

			TFCodeHazardClassMap.put("21", "Oxidizing Gas, Gaseous");
			TFCodeHazardClassMap.put("22", "Oxidizing Gas, Liquified");
			TFCodeHazardClassMap.put("23", "Organic Peroxide, Class I");
			TFCodeHazardClassMap.put("24", "Organic Peroxide, Class II");
			TFCodeHazardClassMap.put("25", "Organic Peroxide, Class III");


			TFCodeHazardClassMap.put("26", "Organic Peroxide, Class IV");
			TFCodeHazardClassMap.put("27", "Other Health Hazard");
			TFCodeHazardClassMap.put("28", "Pyrophoric");
			TFCodeHazardClassMap.put("29", "Radioactive");
			TFCodeHazardClassMap.put("30", "Sensitizer");

			TFCodeHazardClassMap.put("31", "Toxic");
			TFCodeHazardClassMap.put("32", "Unstable (Reactive), Class 1");
			TFCodeHazardClassMap.put("33", "Unstable (Reactive), Class 2");
			TFCodeHazardClassMap.put("34", "Unstable (Reactive), Class 3");
			TFCodeHazardClassMap.put("35", "Unstable (Reactive), Class 4");

			TFCodeHazardClassMap.put("36", "Water Reactive, Class 1");
			TFCodeHazardClassMap.put("37", "Water Reactive, Class 2");
			TFCodeHazardClassMap.put("38", "Water Reactive, Class 3");
			TFCodeHazardClassMap.put("39", "Other");
			abcDesc.put("TFCodeHazardClass", TFCodeHazardClassMap);

			//FFCodeHazardClass=Fourth Fire Code Hazard Class (210d)
			Map<String, String> FFCodeHazardClassMap = new HashMap<String, String>();
			FFCodeHazardClassMap.put("1", "Carcinogen");
			FFCodeHazardClassMap.put("2", "Combustible Liquid, Class II");
			FFCodeHazardClassMap.put("3", "Combustible Liquid, Class III-A");
			FFCodeHazardClassMap.put("4", "Combustible Liquid, Class III-B");
			FFCodeHazardClassMap.put("5", "Corrosive");

			FFCodeHazardClassMap.put("6", "Cryogen");
			FFCodeHazardClassMap.put("7", "Explosive");
			FFCodeHazardClassMap.put("8", "Flammable Gas");
			FFCodeHazardClassMap.put("9", "Flammable Liquid, Class I-A");
			FFCodeHazardClassMap.put("10", "Flammable Liquid, Class I-B");

			FFCodeHazardClassMap.put("11", "Flammable Liquid, Class I-C");
			FFCodeHazardClassMap.put("12", "Flammable Solid");
			FFCodeHazardClassMap.put("13", "Highly Toxic");
			FFCodeHazardClassMap.put("14", "Irritant");
			FFCodeHazardClassMap.put("15", "Liquified Petroleum Gas");

			FFCodeHazardClassMap.put("16", "Magnesium");
			FFCodeHazardClassMap.put("17", "Oxidizing, Class 1");
			FFCodeHazardClassMap.put("18", "Oxidizing, Class 2");
			FFCodeHazardClassMap.put("19", "Oxidizing, Class 3");
			FFCodeHazardClassMap.put("20", "Oxidizing, Class 4");

			FFCodeHazardClassMap.put("21", "Oxidizing Gas, Gaseous");
			FFCodeHazardClassMap.put("22", "Oxidizing Gas, Liquified");
			FFCodeHazardClassMap.put("23", "Organic Peroxide, Class I");
			FFCodeHazardClassMap.put("24", "Organic Peroxide, Class II");
			FFCodeHazardClassMap.put("25", "Organic Peroxide, Class III");


			FFCodeHazardClassMap.put("26", "Organic Peroxide, Class IV");
			FFCodeHazardClassMap.put("27", "Other Health Hazard");
			FFCodeHazardClassMap.put("28", "Pyrophoric");
			FFCodeHazardClassMap.put("29", "Radioactive");
			FFCodeHazardClassMap.put("30", "Sensitizer");

			FFCodeHazardClassMap.put("31", "Toxic");
			FFCodeHazardClassMap.put("32", "Unstable (Reactive), Class 1");
			FFCodeHazardClassMap.put("33", "Unstable (Reactive), Class 2");
			FFCodeHazardClassMap.put("34", "Unstable (Reactive), Class 3");
			FFCodeHazardClassMap.put("35", "Unstable (Reactive), Class 4");

			FFCodeHazardClassMap.put("36", "Water Reactive, Class 1");
			FFCodeHazardClassMap.put("37", "Water Reactive, Class 2");
			FFCodeHazardClassMap.put("38", "Water Reactive, Class 3");
			FFCodeHazardClassMap.put("39", "Other");
			abcDesc.put("FFCodeHazardClass", FFCodeHazardClassMap);

			//FifthFireCodeHazardClass=Fifth Fire Code Hazard Class (210e)
			Map<String, String> FifthFireCodeHazardClassMap = new HashMap<String, String>();
			FifthFireCodeHazardClassMap.put("1", "Carcinogen");
			FifthFireCodeHazardClassMap.put("2", "Combustible Liquid, Class II");
			FifthFireCodeHazardClassMap.put("3", "Combustible Liquid, Class III-A");
			FifthFireCodeHazardClassMap.put("4", "Combustible Liquid, Class III-B");
			FifthFireCodeHazardClassMap.put("5", "Corrosive");

			FifthFireCodeHazardClassMap.put("6", "Cryogen");
			FifthFireCodeHazardClassMap.put("7", "Explosive");
			FifthFireCodeHazardClassMap.put("8", "Flammable Gas");
			FifthFireCodeHazardClassMap.put("9", "Flammable Liquid, Class I-A");
			FifthFireCodeHazardClassMap.put("10", "Flammable Liquid, Class I-B");

			FifthFireCodeHazardClassMap.put("11", "Flammable Liquid, Class I-C");
			FifthFireCodeHazardClassMap.put("12", "Flammable Solid");
			FifthFireCodeHazardClassMap.put("13", "Highly Toxic");
			FifthFireCodeHazardClassMap.put("14", "Irritant");
			FifthFireCodeHazardClassMap.put("15", "Liquified Petroleum Gas");

			FifthFireCodeHazardClassMap.put("16", "Magnesium");
			FifthFireCodeHazardClassMap.put("17", "Oxidizing, Class 1");
			FifthFireCodeHazardClassMap.put("18", "Oxidizing, Class 2");
			FifthFireCodeHazardClassMap.put("19", "Oxidizing, Class 3");
			FifthFireCodeHazardClassMap.put("20", "Oxidizing, Class 4");

			FifthFireCodeHazardClassMap.put("21", "Oxidizing Gas, Gaseous");
			FifthFireCodeHazardClassMap.put("22", "Oxidizing Gas, Liquified");
			FifthFireCodeHazardClassMap.put("23", "Organic Peroxide, Class I");
			FifthFireCodeHazardClassMap.put("24", "Organic Peroxide, Class II");
			FifthFireCodeHazardClassMap.put("25", "Organic Peroxide, Class III");


			FifthFireCodeHazardClassMap.put("26", "Organic Peroxide, Class IV");
			FifthFireCodeHazardClassMap.put("27", "Other Health Hazard");
			FifthFireCodeHazardClassMap.put("28", "Pyrophoric");
			FifthFireCodeHazardClassMap.put("29", "Radioactive");
			FifthFireCodeHazardClassMap.put("30", "Sensitizer");

			FifthFireCodeHazardClassMap.put("31", "Toxic");
			FifthFireCodeHazardClassMap.put("32", "Unstable (Reactive), Class 1");
			FifthFireCodeHazardClassMap.put("33", "Unstable (Reactive), Class 2");
			FifthFireCodeHazardClassMap.put("34", "Unstable (Reactive), Class 3");
			FifthFireCodeHazardClassMap.put("35", "Unstable (Reactive), Class 4");

			FifthFireCodeHazardClassMap.put("36", "Water Reactive, Class 1");
			FifthFireCodeHazardClassMap.put("37", "Water Reactive, Class 2");
			FifthFireCodeHazardClassMap.put("38", "Water Reactive, Class 3");
			FifthFireCodeHazardClassMap.put("39", "Other");
			abcDesc.put("FifthFireCodeHazardClass", FifthFireCodeHazardClassMap);

			//SixthFireCodeHazardClass=Sixth Fire Code Hazard Class (210f)
			Map<String, String> SixthFireCodeHazardClassMap = new HashMap<String, String>();
			SixthFireCodeHazardClassMap.put("1", "Carcinogen");
			SixthFireCodeHazardClassMap.put("2", "Combustible Liquid, Class II");
			SixthFireCodeHazardClassMap.put("3", "Combustible Liquid, Class III-A");
			SixthFireCodeHazardClassMap.put("4", "Combustible Liquid, Class III-B");
			SixthFireCodeHazardClassMap.put("5", "Corrosive");

			SixthFireCodeHazardClassMap.put("6", "Cryogen");
			SixthFireCodeHazardClassMap.put("7", "Explosive");
			SixthFireCodeHazardClassMap.put("8", "Flammable Gas");
			SixthFireCodeHazardClassMap.put("9", "Flammable Liquid, Class I-A");
			SixthFireCodeHazardClassMap.put("10", "Flammable Liquid, Class I-B");

			SixthFireCodeHazardClassMap.put("11", "Flammable Liquid, Class I-C");
			SixthFireCodeHazardClassMap.put("12", "Flammable Solid");
			SixthFireCodeHazardClassMap.put("13", "Highly Toxic");
			SixthFireCodeHazardClassMap.put("14", "Irritant");
			SixthFireCodeHazardClassMap.put("15", "Liquified Petroleum Gas");

			SixthFireCodeHazardClassMap.put("16", "Magnesium");
			SixthFireCodeHazardClassMap.put("17", "Oxidizing, Class 1");
			SixthFireCodeHazardClassMap.put("18", "Oxidizing, Class 2");
			SixthFireCodeHazardClassMap.put("19", "Oxidizing, Class 3");
			SixthFireCodeHazardClassMap.put("20", "Oxidizing, Class 4");

			SixthFireCodeHazardClassMap.put("21", "Oxidizing Gas, Gaseous");
			SixthFireCodeHazardClassMap.put("22", "Oxidizing Gas, Liquified");
			SixthFireCodeHazardClassMap.put("23", "Organic Peroxide, Class I");
			SixthFireCodeHazardClassMap.put("24", "Organic Peroxide, Class II");
			SixthFireCodeHazardClassMap.put("25", "Organic Peroxide, Class III");


			SixthFireCodeHazardClassMap.put("26", "Organic Peroxide, Class IV");
			SixthFireCodeHazardClassMap.put("27", "Other Health Hazard");
			SixthFireCodeHazardClassMap.put("28", "Pyrophoric");
			SixthFireCodeHazardClassMap.put("29", "Radioactive");
			SixthFireCodeHazardClassMap.put("30", "Sensitizer");

			SixthFireCodeHazardClassMap.put("31", "Toxic");
			SixthFireCodeHazardClassMap.put("32", "Unstable (Reactive), Class 1");
			SixthFireCodeHazardClassMap.put("33", "Unstable (Reactive), Class 2");
			SixthFireCodeHazardClassMap.put("34", "Unstable (Reactive), Class 3");
			SixthFireCodeHazardClassMap.put("35", "Unstable (Reactive), Class 4");

			SixthFireCodeHazardClassMap.put("36", "Water Reactive, Class 1");
			SixthFireCodeHazardClassMap.put("37", "Water Reactive, Class 2");
			SixthFireCodeHazardClassMap.put("38", "Water Reactive, Class 3");
			SixthFireCodeHazardClassMap.put("39", "Other");
			abcDesc.put("SixthFireCodeHazardClass", SixthFireCodeHazardClassMap);

			//SeventhFireCodeHazardClass=Seventh Fire Code Hazard Class (210g)
			Map<String, String> SeventhFireCodeHazardClassMap = new HashMap<String, String>();
			SeventhFireCodeHazardClassMap.put("1", "Carcinogen");
			SeventhFireCodeHazardClassMap.put("2", "Combustible Liquid, Class II");
			SeventhFireCodeHazardClassMap.put("3", "Combustible Liquid, Class III-A");
			SeventhFireCodeHazardClassMap.put("4", "Combustible Liquid, Class III-B");
			SeventhFireCodeHazardClassMap.put("5", "Corrosive");

			SeventhFireCodeHazardClassMap.put("6", "Cryogen");
			SeventhFireCodeHazardClassMap.put("7", "Explosive");
			SeventhFireCodeHazardClassMap.put("8", "Flammable Gas");
			SeventhFireCodeHazardClassMap.put("9", "Flammable Liquid, Class I-A");
			SeventhFireCodeHazardClassMap.put("10", "Flammable Liquid, Class I-B");

			SeventhFireCodeHazardClassMap.put("11", "Flammable Liquid, Class I-C");
			SeventhFireCodeHazardClassMap.put("12", "Flammable Solid");
			SeventhFireCodeHazardClassMap.put("13", "Highly Toxic");
			SeventhFireCodeHazardClassMap.put("14", "Irritant");
			SeventhFireCodeHazardClassMap.put("15", "Liquified Petroleum Gas");

			SeventhFireCodeHazardClassMap.put("16", "Magnesium");
			SeventhFireCodeHazardClassMap.put("17", "Oxidizing, Class 1");
			SeventhFireCodeHazardClassMap.put("18", "Oxidizing, Class 2");
			SeventhFireCodeHazardClassMap.put("19", "Oxidizing, Class 3");
			SeventhFireCodeHazardClassMap.put("20", "Oxidizing, Class 4");

			SeventhFireCodeHazardClassMap.put("21", "Oxidizing Gas, Gaseous");
			SeventhFireCodeHazardClassMap.put("22", "Oxidizing Gas, Liquified");
			SeventhFireCodeHazardClassMap.put("23", "Organic Peroxide, Class I");
			SeventhFireCodeHazardClassMap.put("24", "Organic Peroxide, Class II");
			SeventhFireCodeHazardClassMap.put("25", "Organic Peroxide, Class III");


			SeventhFireCodeHazardClassMap.put("26", "Organic Peroxide, Class IV");
			SeventhFireCodeHazardClassMap.put("27", "Other Health Hazard");
			SeventhFireCodeHazardClassMap.put("28", "Pyrophoric");
			SeventhFireCodeHazardClassMap.put("29", "Radioactive");
			SeventhFireCodeHazardClassMap.put("30", "Sensitizer");

			SeventhFireCodeHazardClassMap.put("31", "Toxic");
			SeventhFireCodeHazardClassMap.put("32", "Unstable (Reactive), Class 1");
			SeventhFireCodeHazardClassMap.put("33", "Unstable (Reactive), Class 2");
			SeventhFireCodeHazardClassMap.put("34", "Unstable (Reactive), Class 3");
			SeventhFireCodeHazardClassMap.put("35", "Unstable (Reactive), Class 4");

			SeventhFireCodeHazardClassMap.put("36", "Water Reactive, Class 1");
			SeventhFireCodeHazardClassMap.put("37", "Water Reactive, Class 2");
			SeventhFireCodeHazardClassMap.put("38", "Water Reactive, Class 3");
			SeventhFireCodeHazardClassMap.put("39", "Other");
			abcDesc.put("SeventhFireCodeHazardClass", SeventhFireCodeHazardClassMap);

			//EighthFireCodeHazardClass=Eighth Fire Code Hazard Class (210h)
			Map<String, String> EighthFireCodeHazardClassMap = new HashMap<String, String>();
			EighthFireCodeHazardClassMap.put("1", "Carcinogen");
			EighthFireCodeHazardClassMap.put("2", "Combustible Liquid, Class II");
			EighthFireCodeHazardClassMap.put("3", "Combustible Liquid, Class III-A");
			EighthFireCodeHazardClassMap.put("4", "Combustible Liquid, Class III-B");
			EighthFireCodeHazardClassMap.put("5", "Corrosive");

			EighthFireCodeHazardClassMap.put("6", "Cryogen");
			EighthFireCodeHazardClassMap.put("7", "Explosive");
			EighthFireCodeHazardClassMap.put("8", "Flammable Gas");
			EighthFireCodeHazardClassMap.put("9", "Flammable Liquid, Class I-A");
			EighthFireCodeHazardClassMap.put("10", "Flammable Liquid, Class I-B");

			EighthFireCodeHazardClassMap.put("11", "Flammable Liquid, Class I-C");
			EighthFireCodeHazardClassMap.put("12", "Flammable Solid");
			EighthFireCodeHazardClassMap.put("13", "Highly Toxic");
			EighthFireCodeHazardClassMap.put("14", "Irritant");
			EighthFireCodeHazardClassMap.put("15", "Liquified Petroleum Gas");

			EighthFireCodeHazardClassMap.put("16", "Magnesium");
			EighthFireCodeHazardClassMap.put("17", "Oxidizing, Class 1");
			EighthFireCodeHazardClassMap.put("18", "Oxidizing, Class 2");
			EighthFireCodeHazardClassMap.put("19", "Oxidizing, Class 3");
			EighthFireCodeHazardClassMap.put("20", "Oxidizing, Class 4");

			EighthFireCodeHazardClassMap.put("21", "Oxidizing Gas, Gaseous");
			EighthFireCodeHazardClassMap.put("22", "Oxidizing Gas, Liquified");
			EighthFireCodeHazardClassMap.put("23", "Organic Peroxide, Class I");
			EighthFireCodeHazardClassMap.put("24", "Organic Peroxide, Class II");
			EighthFireCodeHazardClassMap.put("25", "Organic Peroxide, Class III");


			EighthFireCodeHazardClassMap.put("26", "Organic Peroxide, Class IV");
			EighthFireCodeHazardClassMap.put("27", "Other Health Hazard");
			EighthFireCodeHazardClassMap.put("28", "Pyrophoric");
			EighthFireCodeHazardClassMap.put("29", "Radioactive");
			EighthFireCodeHazardClassMap.put("30", "Sensitizer");

			EighthFireCodeHazardClassMap.put("31", "Toxic");
			EighthFireCodeHazardClassMap.put("32", "Unstable (Reactive), Class 1");
			EighthFireCodeHazardClassMap.put("33", "Unstable (Reactive), Class 2");
			EighthFireCodeHazardClassMap.put("34", "Unstable (Reactive), Class 3");
			EighthFireCodeHazardClassMap.put("35", "Unstable (Reactive), Class 4");

			EighthFireCodeHazardClassMap.put("36", "Water Reactive, Class 1");
			EighthFireCodeHazardClassMap.put("37", "Water Reactive, Class 2");
			EighthFireCodeHazardClassMap.put("38", "Water Reactive, Class 3");
			EighthFireCodeHazardClassMap.put("39", "Other");
			abcDesc.put("EighthFireCodeHazardClass", EighthFireCodeHazardClassMap);


			//TypeOfAction_400=Type of Action (400)
			Map<String, String> TypeOfAction_400_Map = new HashMap<String, String>();
			TypeOfAction_400_Map.put("5", "Confirmed/Updated Information");
			TypeOfAction_400_Map.put("1", "New Permit");
			TypeOfAction_400_Map.put("3", "Renewal Permit");
			TypeOfAction_400_Map.put("6", "Temporary Facility Closure");
			TypeOfAction_400_Map.put("7", "Permanent Facility Closure");
			TypeOfAction_400_Map.put("9", "Transfer Permit");
			abcDesc.put("TypeOfAction_400", TypeOfAction_400_Map);

			//FacilityType=Facility Type (UST Facility) (403)
			Map<String, String> FacilityTypeMap = new HashMap<String, String>();
			FacilityTypeMap.put("1", "Motor Vehicle Fueling");
			FacilityTypeMap.put("2", "Fuel Distribution");
			FacilityTypeMap.put("3", "Farm");
			FacilityTypeMap.put("4", "Processor");
			FacilityTypeMap.put("6", "Other");
			abcDesc.put("FacilityType", FacilityTypeMap);

			//PermitHolderInfo=Permit Holder Notification Information (423)
			Map<String, String> PermitHolderInfoMap = new HashMap<String, String>();
			PermitHolderInfoMap.put("1", "Facility Owner");
			PermitHolderInfoMap.put("5", "Facility Operator");
			PermitHolderInfoMap.put("3", "Tank Owner");
			PermitHolderInfoMap.put("4", "Tank Operator");
			abcDesc.put("PermitHolderInfo", PermitHolderInfoMap);

			//SignatureRepresentation=Applicant Signature Representation (490-76)
			Map<String, String> SignatureRepresentationMap = new HashMap<String, String>();
			SignatureRepresentationMap.put("01", "Tank Owner/Operator");
			SignatureRepresentationMap.put("02", "Facility Owner/Operator");
			SignatureRepresentationMap.put("03", "Authorized Representative of Owner");
			abcDesc.put("SignatureRepresentation", SignatureRepresentationMap);


			//MonitoringEquipmentServiced=Monitoring Equipment Serviced (490-3a)
			Map<String, String> MonitoringEquipmentServicedMap = new HashMap<String, String>();
			MonitoringEquipmentServicedMap.put("01", "Annually");
			MonitoringEquipmentServicedMap.put("99", "Other");
			abcDesc.put("MonitoringEquipmentServiced", MonitoringEquipmentServicedMap);

			//SitePlotPlanSubmitted=Site Plot Plan Submitted (490-4)
			Map<String, String> SitePlotPlanSubmittedMap = new HashMap<String, String>();
			SitePlotPlanSubmittedMap.put("1", "New Plan Submitted");
			SitePlotPlanSubmittedMap.put("2", "Site Plan Previously Submitted");
			abcDesc.put("SitePlotPlanSubmitted", SitePlotPlanSubmittedMap);

			//TankSecondaryContainmentSystem=Tank Secondary Containment System (490-6)
			Map<String, String> TankSecondaryContainmentSystemMap = new HashMap<String, String>();
			TankSecondaryContainmentSystemMap.put("01", "Dry");
			TankSecondaryContainmentSystemMap.put("02", "Liquid-Filled");
			TankSecondaryContainmentSystemMap.put("03", "Pressurized");
			TankSecondaryContainmentSystemMap.put("04", "Under Vacuum");
			abcDesc.put("TankSecondaryContainmentSystem", TankSecondaryContainmentSystemMap);

			//TankLeakTestFrequency=Tank Leak Test Frequency (490-16)
			Map<String, String> TankLeakTestFrequencyMap = new HashMap<String, String>();
			TankLeakTestFrequencyMap.put("01", "Continuous");
			TankLeakTestFrequencyMap.put("02", "Daily/Nightly");
			TankLeakTestFrequencyMap.put("03", "Weekly");
			TankLeakTestFrequencyMap.put("04", "Monthly");
			TankLeakTestFrequencyMap.put("99", "Other");
			abcDesc.put("TankLeakTestFrequency", TankLeakTestFrequencyMap);

			//ProgrammedTankTest=Programmed Tank Tests (490-18)
			Map<String, String> ProgrammedTankTestMap = new HashMap<String, String>();
			ProgrammedTankTestMap.put("01", "0.1 GPH");
			ProgrammedTankTestMap.put("02", "0.2 GPH");
			ProgrammedTankTestMap.put("99", "Other");
			abcDesc.put("ProgrammedTankTest", ProgrammedTankTestMap);

			//TankGaugingTestPeriod=Weekly Gauging Test Period (490-22)
			Map<String, String> TankGaugingTestPeriodMap = new HashMap<String, String>();
			TankGaugingTestPeriodMap.put("01", "36 Hours");
			TankGaugingTestPeriodMap.put("02", "60 Hours");
			abcDesc.put("TankGaugingTestPeriod", TankGaugingTestPeriodMap);

			//TankIntegrityTestingFrequency=Tank Integrity Testing Frequency (490-24)
			Map<String, String> TankIntegrityTestingFrequencyMap = new HashMap<String, String>();
			TankIntegrityTestingFrequencyMap.put("01", "Annually");
			TankIntegrityTestingFrequencyMap.put("02", "Biennially");
			TankIntegrityTestingFrequencyMap.put("99", "Other");
			abcDesc.put("TankIntegrityTestingFrequency", TankIntegrityTestingFrequencyMap);

			//PipingSecondaryContainment=Piping Secondary Containment (490-29)
			Map<String, String> PipingSecondaryContainmentMap = new HashMap<String, String>();
			PipingSecondaryContainmentMap.put("01", "Dry");
			PipingSecondaryContainmentMap.put("02", "Liquid");
			PipingSecondaryContainmentMap.put("03", "Pressurized");
			PipingSecondaryContainmentMap.put("04", "Under Vacuum");
			abcDesc.put("PipingSecondaryContainment", PipingSecondaryContainmentMap);

			//ELLDProgrammedInLineTesting=ELLD Programmed In-Line Testing (490-42)
			Map<String, String> ELLDProgrammedInLineTestingMap = new HashMap<String, String>();
			ELLDProgrammedInLineTestingMap.put("01", "0.2 GPH");
			ELLDProgrammedInLineTestingMap.put("02", "0.1 GPH");
			abcDesc.put("ELLDProgrammedInLineTesting", ELLDProgrammedInLineTestingMap);


			//PipelineIntegrityTestingFrequency=Pipe Integrity Testing Frequency (490-46)
			Map<String, String> PipelineIntegrityTestingFrequencyMap = new HashMap<String, String>();
			PipelineIntegrityTestingFrequencyMap.put("01", "Annually");
			PipelineIntegrityTestingFrequencyMap.put("02", "Every 3 Years");
			PipelineIntegrityTestingFrequencyMap.put("03", "Other");
			abcDesc.put("PipelineIntegrityTestingFrequency", PipelineIntegrityTestingFrequencyMap);

			//VisualPipelineMonitoringFrequency=Visual Pipeline Monitoring Frequency (490-49)
			Map<String, String> VisualPipelineMonitoringFrequencyMap = new HashMap<String, String>();
			VisualPipelineMonitoringFrequencyMap.put("01", "Daily");
			VisualPipelineMonitoringFrequencyMap.put("02", "Weekly");
			VisualPipelineMonitoringFrequencyMap.put("03", "Minimum Monthly");
			abcDesc.put("VisualPipelineMonitoringFrequency", VisualPipelineMonitoringFrequencyMap);

			//UDCMonitoring=UDC Monitoring (490-54a)
			Map<String, String> UDCMonitoringMap = new HashMap<String, String>();
			UDCMonitoringMap.put("1", "Continuous");
			UDCMonitoringMap.put("2", "Float and Chain Assembly");
			UDCMonitoringMap.put("3", "Electronic Stand-alone");
			UDCMonitoringMap.put("4", "No Dispensers");
			UDCMonitoringMap.put("99", "Other");
			abcDesc.put("UDCMonitoring", UDCMonitoringMap);


			//UDCConstruction=UDC Construction (490-63)
			Map<String, String> UDCConstructionMap = new HashMap<String, String>();
			UDCConstructionMap.put("1", "Single-walled");
			UDCConstructionMap.put("2", "Double-walled");
			abcDesc.put("UDCConstruction", UDCConstructionMap);

			//UDCSecondaryContainmentMonitoring=UDC Secondary Containment Monitoring (490-64a)
			Map<String, String> UDCSecondaryContainmentMonitoringMap = new HashMap<String, String>();
			UDCSecondaryContainmentMonitoringMap.put("01", "Liquid");
			UDCSecondaryContainmentMonitoringMap.put("02", "Pressure");
			UDCSecondaryContainmentMonitoringMap.put("03", "Vacuum");
			abcDesc.put("UDCSecondaryContainmentMonitoring", UDCSecondaryContainmentMonitoringMap);


			//Units=Units (Remote Consolidation) (728)
			Map<String, String> UnitsMap = new HashMap<String, String>();
			UnitsMap.put("a", "Pounds");
			UnitsMap.put("b", "Gallons");
			abcDesc.put("Units", UnitsMap);

			//========================new=====================
			//UnitType=Unit ID Type/Tier (Onsite Hazardous Waste Facility) (607)
			Map<String, String> UnitTypeMap = new HashMap<String, String>();
			UnitTypeMap.put("a", "CESQT");
			UnitTypeMap.put("b", "CESW");
			UnitTypeMap.put("c", "CA");
			UnitTypeMap.put("d", "PBR");
			UnitTypeMap.put("e", "CEL");
			abcDesc.put("UnitType", UnitTypeMap);
			
			//UnitType=Unit ID Type/Tier (Onsite Hazardous Waste Facility) (607)
			Map<String, String> UnitOfMeasureMap = new HashMap<String, String>();
			UnitOfMeasureMap.put("a", "Pounds");
			UnitOfMeasureMap.put("b", "Gallons");
			abcDesc.put("UnitOfMeasure", UnitOfMeasureMap);
			
			
			/**
			//CountyID=County ID (105a)
			Map<String, String> CountyIDMap = new HashMap<String, String>();
			CountyIDMap.put("1", "Alameda");
			CountyIDMap.put("2", "Alpine");
			CountyIDMap.put("3", "Amador");
			CountyIDMap.put("4", "Butte");
			CountyIDMap.put("5", "Calaveras");
			CountyIDMap.put("6", "Colusa");
			CountyIDMap.put("7", "Contra Costa");
			CountyIDMap.put("8", "Del Norte");
			CountyIDMap.put("9", "El Dorado");
			CountyIDMap.put("10", "Fresno");
			CountyIDMap.put("11", "Glenn");
			CountyIDMap.put("12", "Humboldt");
			CountyIDMap.put("13", "Imperial");
			CountyIDMap.put("14", "Inyo");
			CountyIDMap.put("15", "Kern");
			CountyIDMap.put("16", "Kings");
			CountyIDMap.put("17", "Lake");
			CountyIDMap.put("18", "Lassen");
			CountyIDMap.put("19", "Los Angeles");
			CountyIDMap.put("20", "Madera");
			CountyIDMap.put("21", "Marin");
			CountyIDMap.put("22", "Mariposa");
			CountyIDMap.put("23", "Mendocino");
			CountyIDMap.put("24", "Merced");
			CountyIDMap.put("25", "Modoc");
			CountyIDMap.put("26", "Mono");
			CountyIDMap.put("27", "Monterey");
			CountyIDMap.put("28", "Napa");
			CountyIDMap.put("29", "Nevada");
			CountyIDMap.put("30", "Orange");
			CountyIDMap.put("31", "Placer");
			CountyIDMap.put("32", "Plumas");
			CountyIDMap.put("33", "Riverside");
			CountyIDMap.put("34", "Sacramento");
			CountyIDMap.put("35", "San Benito");
			CountyIDMap.put("36", "San Bernardino");
			CountyIDMap.put("37", "San Diego");
			CountyIDMap.put("38", "San Francisco");
			CountyIDMap.put("39", "San Joaquin");
			CountyIDMap.put("40", "San Luis Obispo");
			CountyIDMap.put("41", "San Mateo");
			CountyIDMap.put("42", "Santa Barbara");
			CountyIDMap.put("43", "Santa Clara");
			CountyIDMap.put("44", "Santa Cruz");
			CountyIDMap.put("45", "Shasta");
			CountyIDMap.put("46", "Sierra");
			CountyIDMap.put("47", "Siskiyou");
			CountyIDMap.put("48", "Solano");
			CountyIDMap.put("49", "Sonoma");
			CountyIDMap.put("50", "Stanislaus");
			CountyIDMap.put("51", "Sutter");
			CountyIDMap.put("52", "Tehema");
			CountyIDMap.put("53", "Trinity");
			CountyIDMap.put("54", "Tulare");
			CountyIDMap.put("55", "Tuolumne");
			CountyIDMap.put("56", "Ventura");
			CountyIDMap.put("57", "Yolo");
			CountyIDMap.put("58", "Yuba");
			abcDesc.put("CountyID", CountyIDMap);
			**/


			//StateWasteCode=State Waste Code (220)
			/*Map<String, String> StateWasteCodeMap = new HashMap<String, String>();
			StateWasteCodeMap.put("121", "Alkaline solution (pH >12.5) with metals (antimony, arsenic, barium, beryllium, cadmium, chromium, cobalt, copper, lead, mercury, molybdenum, nickel, selenium, silver, thallium, vanadium, and zinc)");
			StateWasteCodeMap.put("122", "Alkaline solution without metals (pH > 12.5)");
			StateWasteCodeMap.put("123", "Unspecified alkaline solution");
			StateWasteCodeMap.put("131", "Aqueous solution (2 < pH < 12.5) containing reactive anions (azide, bromate, chlorate, cyanide, fluoride, hypochlorite, nitrite, perchlorate, and sulfide anions)");
			StateWasteCodeMap.put("132", "Aqueous solution w/metals (< restricted levels and see waste code 121 for a list of metals)");
			StateWasteCodeMap.put("133", "Aqueous solution with 10% or more total organic residues");
			StateWasteCodeMap.put("134", "Aqueous solution with <10% total organic residues");
			StateWasteCodeMap.put("135", "Unspecified aqueous solution");
			StateWasteCodeMap.put("141", "Off-specification, aged, or surplus inorganics");
			StateWasteCodeMap.put("151", "Asbestos-containing waste");
			StateWasteCodeMap.put("161", "Fluid-cracking catalyst (FCC) waste");
			StateWasteCodeMap.put("162", "Other spent catalyst");
			StateWasteCodeMap.put("171", "Metal sludge (see 121)");
			StateWasteCodeMap.put("172", "Metal dust (see 121) and machining waste");
			StateWasteCodeMap.put("181", "Other inorganic solid waste");
			StateWasteCodeMap.put("211", "Halogenated solvents (chloroform, methyl chloride, perchloroethylene, etc.)");
			StateWasteCodeMap.put("212", "Oxygenated solvents (acetone, butanol, ethyl acetate, etc.)");
			StateWasteCodeMap.put("213", "Hydrocarbon solvents (benzene, hexane, Stoddard, etc.)");
			StateWasteCodeMap.put("214", "Unspecified solvent mixture");
			StateWasteCodeMap.put("221", "Waste oil and mixed oil");
			StateWasteCodeMap.put("222", "Oil/water separation sludge");
			StateWasteCodeMap.put("223", "Unspecified oil-containing waste");
			StateWasteCodeMap.put("231", "Pesticide rinse water");
			StateWasteCodeMap.put("232", "Pesticides and other waste associated with pesticide production");
			StateWasteCodeMap.put("241", "Tank bottom waste");
			StateWasteCodeMap.put("251", "Still bottoms with halogenated organics");
			StateWasteCodeMap.put("252", "Other still bottom waste");
			StateWasteCodeMap.put("261", "Polychlorinated biphenyls and material containing PCB's");
			StateWasteCodeMap.put("271", "Organic monomer waste (includes unreacted resins)");
			StateWasteCodeMap.put("272", "Polymeric resin waste");
			StateWasteCodeMap.put("281", "Adhesives");
			StateWasteCodeMap.put("291", "Latex waste");
			StateWasteCodeMap.put("311", "Pharmaceutical waste");
			StateWasteCodeMap.put("321", "Sewage sludge");
			StateWasteCodeMap.put("322", "Biological waste other than sewage sludge");
			StateWasteCodeMap.put("331", "Off-specification, aged, or surplus organics");
			StateWasteCodeMap.put("341", "Organic liquids (nonsolvents) with halogens");
			StateWasteCodeMap.put("342", "Organic liquids with metals (see 121)");
			StateWasteCodeMap.put("343", "Unspecified organic liquid mixture");
			StateWasteCodeMap.put("351", "Organic solids with halogens");
			StateWasteCodeMap.put("352", "Other organic solids");
			StateWasteCodeMap.put("411", "Alum and gypsum sludge");
			StateWasteCodeMap.put("421", "Lime sludge");
			StateWasteCodeMap.put("431", "Phosphate sludge");
			StateWasteCodeMap.put("441", "Sulphur sludge");
			StateWasteCodeMap.put("451", "Degreasing sludge");
			StateWasteCodeMap.put("461", "Paint sludge");
			StateWasteCodeMap.put("471", "Paper sludge/pulp");
			StateWasteCodeMap.put("481", "Tetraethyl lead sludge");
			StateWasteCodeMap.put("491", "Unspecified sludge waste");
			StateWasteCodeMap.put("511", "Empty pesticide containers 30 gallons or more");
			StateWasteCodeMap.put("512", "Other empty containers 30 gallons or more");
			StateWasteCodeMap.put("513", "Empty containers less than 30 gallons");
			StateWasteCodeMap.put("521", "Drilling mud");
			StateWasteCodeMap.put("531", "Chemical toilet waste");
			StateWasteCodeMap.put("541", "Photochemicals / photo processing waste");
			StateWasteCodeMap.put("551", "Laboratory waste chemicals");
			StateWasteCodeMap.put("561", "Detergent and soap");
			StateWasteCodeMap.put("571", "Fly ash, bottom ash, and retort ash");
			StateWasteCodeMap.put("581", "Gas scrubber waste");
			StateWasteCodeMap.put("591", "Baghouse waste");
			StateWasteCodeMap.put("611", "Contaminated soil from site clean-ups");
			StateWasteCodeMap.put("612", "Household waste");
			StateWasteCodeMap.put("613", "Auto shredder waste");
			StateWasteCodeMap.put("614", "Treated wood waste");
			StateWasteCodeMap.put("711", "Liquids with cyanides > 1000 mg/l");
			StateWasteCodeMap.put("721", "Liquids with arsenic > 500 mg/l");
			StateWasteCodeMap.put("722", "Liquids with cadmium > 100 mg/l");
			StateWasteCodeMap.put("723", "Liquids with chromium (VI) > 500 mg/l");
			StateWasteCodeMap.put("724", "Liquids with lead > 500 mg/l");
			StateWasteCodeMap.put("725", "Liquids with mercury > 20 mg/l");
			StateWasteCodeMap.put("726", "Liquids with nickel > 134 mg/l");
			StateWasteCodeMap.put("727", "Liquids with selenium > 100 mg/l");
			StateWasteCodeMap.put("728", "Liquids with thallium > 130 mg/l");
			StateWasteCodeMap.put("731", "Liquids with polychlorinated biphenyls > 50 mg/l");
			StateWasteCodeMap.put("741", "Liquids with halogenated organic compounds > 1000 mg/l");
			StateWasteCodeMap.put("751", "Solids or sludge with halogenated organic comp. > 1000 mg/kg");
			StateWasteCodeMap.put("791", "Liquids with pH < 2");
			StateWasteCodeMap.put("792", "Liquids with pH < 2 with metals");
			StateWasteCodeMap.put("801", "Waste potentially containing dioxins California 3-digit hazardous code");
			abcDesc.put("StateWasteCode", StateWasteCodeMap);*/

			//PipingConstruction=Piping Construction (460)
			Map<String, String> PipingConstructionMap = new HashMap<String, String>();
			PipingConstructionMap.put("1", "Single-walled");
			PipingConstructionMap.put("2", "Double-walled");
			PipingConstructionMap.put("99", "Other");
			abcDesc.put("PipingConstruction", PipingConstructionMap);
			
			//TANK OWNER TYPE (420)
			Map<String, String> TankOwnerType420 = new HashMap<String, String>();
			TankOwnerType420.put("4", "Local Agency/District");
			TankOwnerType420.put("5", "County Agency");
			TankOwnerType420.put("6", "State Agency");
			TankOwnerType420.put("7", "Federal Agency");
			TankOwnerType420.put("8", "Non-Government");
			abcDesc.put("TankOwnerType420", TankOwnerType420);
			
			
		}
		return abcDesc;
	}

}
