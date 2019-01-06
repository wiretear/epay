package com.era.erapay.QRCODE;


import java.util.ArrayList;

public class Wallet {

    ArrayList arrayList=new ArrayList();
    String debit_walletid="";
    String name ="";
    String amount="";
    String narration="";
    String mobileno="";
    String walletID="";
    String mobileNO="";
    String customerID="";
    String serialNo = "";

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public ArrayList getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public String getMobileNO() {
        return mobileNO;
    }

    public void setMobileNO(String mobileNO) {
        this.mobileNO = mobileNO;
    }

    public String getWalletID() {
        return walletID;
    }
    public void setWalletID(String walletId) {
        this.walletID = walletId;
    }
    public String getMobileno() {
        return mobileno;
    }
    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getDebit_walletid() {
        return debit_walletid;
    }

    public void setDebit_walletid(String debit_walletid) {
        this.debit_walletid = debit_walletid;
    }

    public String getNarration() {
        return narration;
    }
    public void setNarration(String narration) {
        this.narration = narration;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    String errorMessage="";
    int errorCode;
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
