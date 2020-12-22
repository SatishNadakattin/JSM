package com.app.request;

import javax.validation.constraints.NotBlank;

public class Login {
	
	@NotBlank(message = "Please provide userName")
	private String userName;
	
	@NotBlank(message = "Please provide a password")
	private String password;

	@NotBlank(message = "Please provide a loginType")
	private String loginType;
	
	private String token;
	
	String oldpassword ;
	
    String newpassword;
    
	String type;   
	
	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + ", loginType=" + loginType + ", token="
				+ token + ", oldpassword=" + oldpassword + ", newpassword=" + newpassword + ", type=" + type + "]";
	}

	

	
}
