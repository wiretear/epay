package com.era.erapay.KYC;

import java.io.File;
import java.io.Serializable;

public class KycBO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email="";
	private String name="";
	private String fatherName="";
	private String motherName="";
	private String contactNo="";
	private String nationalId="";
	private String passport="";
	private String permanentAddress="";
	private String permanentCity="";
	private String permanentCountry="";
	private String presentAddressCity="";
	private String presentAddress="";
	private String presentCity="";
	private String presentContrty="";
	private String introducerName="";
	private String introducerAddress="";
	private String introducerMobileNo="";
	private String introducerOccupation="";
	private File   imageFile=null;
	private File   documentFile=null;
	private String outCode="";
	public String getOutCode() {
		return outCode;
	}
	public void setOutCode(String outCode) {
		this.outCode = outCode;
	}
	private int errorCode;
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	private String customerType=null;
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getPermanentCity() {
		return permanentCity;
	}
	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}
	public String getPermanentCountry() {
		return permanentCountry;
	}
	public void setPermanentCountry(String permanentCountry) {
		this.permanentCountry = permanentCountry;
	}
	public String getPresentAddressCity() {
		return presentAddressCity;
	}
	public void setPresentAddressCity(String presentAddressCity) {
		this.presentAddressCity = presentAddressCity;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public String getPresentCity() {
		return presentCity;
	}
	public void setPresentCity(String presentCity) {
		this.presentCity = presentCity;
	}
	public String getPresentContrty() {
		return presentContrty;
	}
	public void setPresentContrty(String presentContrty) {
		this.presentContrty = presentContrty;
	}
	public String getIntroducerName() {
		return introducerName;
	}
	public void setIntroducerName(String introducerName) {
		this.introducerName = introducerName;
	}
	public String getIntroducerAddress() {
		return introducerAddress;
	}
	public void setIntroducerAddress(String introducerAddress) {
		this.introducerAddress = introducerAddress;
	}
	public String getIntroducerMobileNo() {
		return introducerMobileNo;
	}
	public void setIntroducerMobileNo(String introducerMobileNo) {
		this.introducerMobileNo = introducerMobileNo;
	}
	public String getIntroducerOccupation() {
		return introducerOccupation;
	}
	public void setIntroducerOccupation(String introducerOccupation) {
		this.introducerOccupation = introducerOccupation;
	}
	public File getImageFile() {
		return imageFile;
	}
	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}
	public File getDocumentFile() {
		return documentFile;
	}
	public void setDocumentFile(File documentFile) {
		this.documentFile = documentFile;
	}
	


}
