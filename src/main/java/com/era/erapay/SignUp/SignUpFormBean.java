package com.era.erapay.SignUp;

public class SignUpFormBean {
    private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private String sEmail;
	private String sPassword;
	private String sPhone;
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	private String confirmPassword;
	
	public String getEmail() {
		return sEmail;
	}
	public void setEmail(String email) {
		sEmail = email;
	}
	public String getPassword() {
		return sPassword;
	}
	public void setPassword(String password) {
		sPassword = password;
	}
	public String getPhone() {
		return sPhone;
	}
	public void setPhone(String phone) {
		sPhone = phone;
	}
	private String ErrorCode="";
	private String ErrorMessage="";

	public String getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

}
