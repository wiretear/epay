package com.era.erapay.bank;

import java.util.ArrayList;
import java.util.Map;
public class AddBankAccountForm {
private String email="";
private String name="";
private String bankName="";
private String branch="";
private String accountNo="";
private String accountTittle="";
private String mobileNo="";
private String otp="";
private String outCode="";
private String bankCode="";
private String branchCode="";
private String branchName="";
Map<String,String> mapValue;
Map<String,String> mainMapValue;
Map<String,String> bankMapValue;

public Map<String, String> getBankMapValue() {
	return bankMapValue;
}
public void setBankMapValue(Map<String, String> bankMapValue) {
	this.bankMapValue = bankMapValue;
}
public Map<String, String> getMapValue() {
	return mapValue;
}
public void setMapValue(Map<String, String> mapValue) {
	this.mapValue = mapValue;
}
public Map<String, String> getMainMapValue() {
	return mainMapValue;
}
public void setMainMapValue(Map<String, String> mainMapValue) {
	this.mainMapValue = mainMapValue;
}    
public String getBranchCode() {
	return branchCode;
}
public void setBranchCode(String branchCode) {
	this.branchCode = branchCode;
}
public String getBranchName() {
	return branchName;
}
public void setBranchName(String branchName) {
	this.branchName = branchName;
}
public String getBankCode() {
	return bankCode;
}
public void setBankCode(String bankCode) {
	this.bankCode = bankCode;
}
private ArrayList AddBankBranchSearchList;
public ArrayList getAddBankBranchSearchList() {
	return AddBankBranchSearchList;
}
public void setAddBankBranchSearchList(ArrayList addBankBranchSearchList) {
	AddBankBranchSearchList = addBankBranchSearchList;
}
private ArrayList AddBankSearchList;
public ArrayList getAddBankSearchList() {
	return AddBankSearchList;
}
public void setAddBankSearchList(ArrayList addBankSearchList) {
	AddBankSearchList = addBankSearchList;
}
public String getOutCode() {
	return outCode;
}
public void setOutCode(String outCode) {
	this.outCode = outCode;
}
private int  errorCode;
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

public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getAccountNo() {
	return accountNo;
}
public void setAccountNo(String accountNo) {
	this.accountNo = accountNo;
}
public String getAccountTittle() {
	return accountTittle;
}
public void setAccountTittle(String accountTittle) {
	this.accountTittle = accountTittle;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getOtp() {
	return otp;
}
public void setOtp(String otp) {
	this.otp = otp;
}
public int getErrorCode() {
	return errorCode;
}
public void setErrorCode(int errorCode) {
	this.errorCode = errorCode;
}



}
