package com.nuvizz.facility.action;

import java.io.Serializable;
import java.util.List;

public class PoJoFacilityResponseClass implements Serializable
{
	private String actionName;
	private ActionResponse actionResponse;
	
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	
	/*public List<ActionResponse> getActionResponse() {
		return actionResponse;
	}
	public void setActionResponse(List<ActionResponse> actionResponse) {
		this.actionResponse = actionResponse;
	}*/
	
	public ActionResponse getActionResponse() {
		return actionResponse;
	}
	public void setActionResponse(ActionResponse actionResponse) {
		this.actionResponse = actionResponse;
	}
	@Override
	public String toString() {
		return "PoJoFacilityResponseClass [actionName=" + actionName
				+ ", actionResponse=" + actionResponse + "]";
	}

}
