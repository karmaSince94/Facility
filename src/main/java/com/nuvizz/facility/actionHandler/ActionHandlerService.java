package com.nuvizz.facility.actionHandler;

import com.nuvizz.facility.action.PoJoFacilityRequestClass;
import com.nuvizz.facility.action.PoJoFacilityResponseClass;


public interface ActionHandlerService 
{
	public PoJoFacilityResponseClass handleAction(PoJoFacilityRequestClass reqClass);
	//public List<PoJoFacility> handleAction(PoJoFacilityRequestClass reqClass);

}
