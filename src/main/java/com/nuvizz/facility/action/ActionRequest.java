package com.nuvizz.facility.action;

import java.io.Serializable;

public class ActionRequest implements Serializable 
{		
	private String u_name;
	private String u_password;
	private String u_token;
	
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_token() {
		return u_token;
	}
	public void setU_token(String u_token) {
		this.u_token = u_token;
	}
	@Override
	public String toString() {
		return "ActionDTO [u_name=" + u_name + ", u_password=" + u_password
				+ ", u_token=" + u_token + "]";
	}
	
	
	
}
