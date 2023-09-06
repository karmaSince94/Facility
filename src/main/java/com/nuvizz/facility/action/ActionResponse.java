package com.nuvizz.facility.action;

import java.util.List;

import com.nuvizz.facility.PoJoClasses.PoJoFacility;

public class ActionResponse 
{
	private String token;
	private List<PoJoFacility> pojoFacility;
	private int status;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<PoJoFacility> getPojoFacility() {
		return pojoFacility;
	}
	public void setPojoFacility(List<PoJoFacility> pojoFacility) {
		this.pojoFacility = pojoFacility;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ActionResponse [token=" + token + ", pojoFacility="
				+ pojoFacility + ", status=" + status + "]";
	}
	
	
	

}
