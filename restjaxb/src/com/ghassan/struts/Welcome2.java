package com.ghassan.struts;

import com.opensymphony.xwork2.ActionSupport;

public class Welcome2 extends ActionSupport {
	
	private String username;
	private String password;
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	//business logic
	public String execute() {
 
		return "SUCCESS";
 
	}
 
        //simple validation
	public void validate(){
		if("gl".equals(getUsername())){
			addActionMessage("You are valid user!");
		}else{
			addActionError("I don't know you, dont try to hack me!");
		}
	}
}
