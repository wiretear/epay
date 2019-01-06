package com.era.erapay.wallet;

import java.util.ArrayList;

public class WalletToWalletForm {

		String srlNo=" ";
		public String getSrlNo() {
			return srlNo;
		}
		public void setSrlNo(String srlNo) {
			this.srlNo = srlNo;
		}
		String userId="";
		String sessionId="";
		String terminalId="";
		String bankAccount="";
		String bankName="";
		String branchName="";
		String accountNo="";

	public String getButtonValue() {
		return buttonValue;
	}
	public void setButtonValue(String buttonValue) {
		this.buttonValue = buttonValue;
	}

	String accountTittle="";
		String amount="";
		String bankCode= "";
		String branchCode ="";
		String name ="";
		String walletId="";
		String narration="";
		String mobileNO="";
		String buttonValue="";
		private ArrayList walletSearchList = new ArrayList();
	private ArrayList nameSearchList = new ArrayList();

	public ArrayList getMobileNoSearchList() {
		return mobileNoSearchList;
	}

	public void setMobileNoSearchList(ArrayList mobileNoSearchList) {
		this.mobileNoSearchList = mobileNoSearchList;
	}

	private ArrayList mobileNoSearchList = new ArrayList();

		public ArrayList getWalletSearchList() {
			return walletSearchList;
		}

	public ArrayList getNameSearchList() {
		return nameSearchList;
	}

	public void setNameSearchList(ArrayList nameSearchList) {
		this.nameSearchList = nameSearchList;
	}

	public void setWalletSearchList(ArrayList walletSearchList) {
			this.walletSearchList = walletSearchList;
		}
		public String getNarration() {
			return narration;
		}
		public String getMobileNO() {
			return mobileNO;
		}
		public void setMobileNO(String mobileNO) {
			this.mobileNO = mobileNO;
		}
		public void setNarration(String narration) {
			this.narration = narration;
		}
		public String getWalletId() {
			return walletId;
		}
		public void setWalletId(String walletId) {
			this.walletId = walletId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
		String chargeAmount="";
		String otp="";
		String errorMessage="";
		private ArrayList bankSearchList = new ArrayList();
	    public ArrayList getBankSearchList() {
			return bankSearchList;
		}
		public void setBankSearchList(ArrayList bankSearchList) {
			this.bankSearchList = bankSearchList;
		}
		int errorCode;
		public int getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}
		public String getChargeAmount() {
			return chargeAmount;
		}
		public void setChargeAmount(String chargeAmount) {
			this.chargeAmount = chargeAmount;
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
		public String getOtp() {
			return otp;
		}
		public void setOtp(String otp) {
			this.otp = otp;
		}
		public String getErrorMessage() {
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}


}
