package com.era.erapay.requestmoney;

import java.util.ArrayList;

public class RequestMoneyForm {
    private ArrayList transctionHistoryList = new ArrayList();

    public ArrayList getTransctionHistoryListTest() {
        return transctionHistoryListTest;
    }

    public void setTransctionHistoryListTest(ArrayList transctionHistoryListTest) {
        this.transctionHistoryListTest = transctionHistoryListTest;
    }

    private ArrayList transctionHistoryListTest = new ArrayList();

    public ArrayList getTransctionHistoryList() {
        return transctionHistoryList;
    }

    public void setTransctionHistoryList(ArrayList transctionHistoryList) {
        this.transctionHistoryList = transctionHistoryList;
    }

    private String name="";
    private String userId="";
    private String sessionId="";
    private String terminalId="";
    private String bankAccount="";
    private String bankName="";
    private String branchName="";
    private String accountNo="";

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    private String accountTittle="";
    private String requestId=" ";
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

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getMobileNO() {
        return mobileNO;
    }

    public void setMobileNO(String mobileNO) {
        this.mobileNO = mobileNO;
    }

    public String getButtonValue() {
        return buttonValue;
    }

    public void setButtonValue(String buttonValue) {
        this.buttonValue = buttonValue;
    }
    private String date="";
    private String amount="";
    private String bankCode= "";
    private String branchCode ="";
    private  String walletId="";
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    private String narration="";
    private String mobileNO="";
    private String buttonValue="";

}
