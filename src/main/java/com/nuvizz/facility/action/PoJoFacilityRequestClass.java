package com.nuvizz.facility.action;

import java.io.Serializable;

public class PoJoFacilityRequestClass implements Serializable
{
	private String actionName;
	private ActionRequest actionReq;
	
	
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public ActionRequest getActionReq() {
		return actionReq;
	}
	public void setActionReq(ActionRequest actionReq) {
		this.actionReq = actionReq;
	}
	@Override
	public String toString() {
		return "PoJoFacilityRequestClass [actionName=" + actionName
				+ ", actionReq=" + actionReq + "]";
	}
	
}
