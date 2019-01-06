package com.era.erapay.wallet;

public class WalletToMerchantPaymentForm {
  
	String email="";
	String name="";
	String walletId="";
	String balance="";
	String orderNo="";
	String amount="";
	String charge="";
	String description= "";
	String otp="";
	String bdtCurCode="";

    public String getBdtCurCode() {
        return bdtCurCode;
    }

    public void setBdtCurCode(String bdtCurCode) {
        this.bdtCurCode = bdtCurCode;
    }

    String password ="";
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return email;
	}
	public void setEmailId(String email) {
		this.email= email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWalletId() {
		return walletId;
	}
	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
}
