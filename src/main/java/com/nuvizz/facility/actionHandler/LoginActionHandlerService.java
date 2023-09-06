package com.nuvizz.facility.actionHandler;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.nuvizz.facility.action.ActionResponse;
import com.nuvizz.facility.action.PoJoFacilityRequestClass;
import com.nuvizz.facility.action.PoJoFacilityResponseClass;
import com.nuvizz.facility.dao.facility.FacilityDAOImpl;
import com.nuvizz.facility.dto.UserDTO;

@Configurable
public class LoginActionHandlerService implements ActionHandlerService
{
	private SessionFactory sessionFactory;
	
	public LoginActionHandlerService()
	{
		 WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		 sessionFactory = (SessionFactory)context.getBean("sessionFactory");
	}
	
	private static final Logger logger = LoggerFactory.getLogger(FacilityDAOImpl.class);
	
	public PoJoFacilityResponseClass handleAction(PoJoFacilityRequestClass reqClass)
	{
		logger.info("Starting handleAction() For Login...");
		PoJoFacilityResponseClass respClass = new PoJoFacilityResponseClass();
		ActionResponse actionResponse = new ActionResponse();
		String token = reqClass.getActionReq().getU_token();
		
		String u_name = reqClass.getActionReq().getU_name();
		String u_password = reqClass.getActionReq().getU_password();
		
		int status=0;
		UserDTO userDto = null;
		Session session = null;
		
		try
		{
			session = sessionFactory.openSession();
			String selectQuery1 = "select user from UserDTO user where user.u_token = '"+token+"'";
			Query query = session.createQuery(selectQuery1);
			userDto = (UserDTO)query.uniqueResult();
			if( userDto.getU_name().equals(u_name) && userDto.getU_password().equals(u_password) )
			{
				logger.info("User Authenticated..!!");
				status = userDto.getU_status();
				actionResponse.setToken(token);
				actionResponse.setStatus(status);
				respClass.setActionResponse(actionResponse);
				respClass.setActionName(reqClass.getActionName());
				return respClass;
			}
			else
				logger.info("User Authentication failed!!");
		} 
		catch (HibernateException he) 
		{
			System.err.println("Exception " + he.getMessage());
			he.printStackTrace();
		} 
		finally
		{
			session.close();
		}
		
		return null;
	}
	
}
