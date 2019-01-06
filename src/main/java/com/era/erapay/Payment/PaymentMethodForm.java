package com.era.erapay.Payment;

import java.util.ArrayList;

public class PaymentMethodForm {
	private String srlNo=" ";
	private String userId="";
	private String sessionId="";
	private String terminalId="";
	private String bankAccount="";
	private String bankName="";
	private String branchName="";
	private String accountNo="";
	private String accountTittle="";
	private String amount="";
	private String bankCode= "";
	private String branchCode ="";
	private ArrayList bankSearchList = new ArrayList();
	public String getSrlNo() {
		return srlNo;
	}
	public void setSrlNo(String srlNo) {
		this.srlNo = srlNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public ArrayList getBankSearchList() {
		return bankSearchList;
	}
	public void setBankSearchList(ArrayList bankSearchList) {
		this.bankSearchList = bankSearchList;
	}

	


}
