package com.nuvizz.facility.actionHandler;

public class FactoryActionHandle 
{
	public static ActionHandlerService returnActionHandlerObject(String actionName)
	{
		if(actionName.equals("login"))
			return new LoginActionHandlerService();
		else
		{
			if(actionName.equals("fetchFacility"))
				return new FetchFacilityActionHandler();
			else
			{
				if(actionName.equals("logout"))
					return new LogoutActionHandlerService();
				else 
					return null;
			}
		}
	}

}
