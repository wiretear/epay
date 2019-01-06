package com.era.erapay.KYC;

import java.io.File;
import java.util.ArrayList;

public class KycForm {
	String trnamt1="";
	public String getTrnamt1() {
		return trnamt1;
	}
	public void setTrnamt1(String trnamt1) {
		this.trnamt1 = trnamt1;
	}
	private String mailId="";
	
	public String getPassword() {
		return password;
	}
	String image="";
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	String trandat = "";
	String walletID ="";

	String docType = "";
	public String getTrandat() {
		return trandat;
	}
	public void setTrandat(String trandat) {
		this.trandat = trandat;
	}
	public String getWalletID() {
		return walletID;
	}
	public void setWalletID(String walletID) {
		this.walletID = walletID;
	}

	public int getTrnamt() {
		return trnamt;
	}
	public void setTrnamt(int trnamt) {
		this.trnamt = trnamt;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public ArrayList getTransctionHistoryList() {
		return transctionHistoryList;
	}
	public void setTransctionHistoryList(ArrayList transctionHistoryList) {
		this.transctionHistoryList = transctionHistoryList;
	}
	public String getImageFilePath() {
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	public String getDocumentFilePath() {
		return documentFilePath;
	}
	public void setDocumentFilePath(String documentFilePath) {
		this.documentFilePath = documentFilePath;
	}
	private ArrayList transctionHistoryList = new ArrayList();
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	private String password ="";
	private String email="";
	private String name="";
	private String fatherName="";
	private String motherName="";
	private String contactNo="";
	private String nationalId="";
	private String passport="";

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
	private String imageFilePath="";
	private String documentFilePath="";
	private String outCode="";
	private String gender ="";
	private String dateOfBirth="";
	private String permanentAddress="";

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOutCode() {
		return outCode;
	}
	public void setOutCode(String outCode) {
		this.outCode = outCode;
	}
	private String customerType=null;
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	private int errorCode;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
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
	String fromDate ="";
	String toDate ="";
	String docnum="";

	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getDocnum() {
		return docnum;
	}
	public void setDocnum(String docnum) {
		this.docnum = docnum;
	}
	public String getDoctype() {
		return doctype;
	}
	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}
	public String getWalletid() {
		return walletid;
	}
	public void setWalletid(String walletid) {
		this.walletid = walletid;
	}
	String doctype ="";
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	public String getDrcrcd() {
		return drcrcd;
	}
	public void setDrcrcd(String drcrcd) {
		this.drcrcd = drcrcd;
	}
	public ArrayList getTranapprovalList() {
		return tranapprovalList;
	}
	public void setTranapprovalList(ArrayList tranapprovalList) {
		this.tranapprovalList = tranapprovalList;
	}
	String walletid="";
	String narration ="";
	String drcrcd ="";
	private ArrayList tranapprovalList = new ArrayList();
	int trnamt;
	

}
