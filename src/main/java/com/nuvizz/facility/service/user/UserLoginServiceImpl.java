package com.nuvizz.facility.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.facility.dao.user.UserLoginDAOImpl;
import com.nuvizz.facility.dto.UserDTO;

@Component
public class UserLoginServiceImpl implements UserLoginService
{
	private static final Logger logger = LoggerFactory.getLogger(UserLoginServiceImpl.class);

	@Autowired
	UserLoginDAOImpl dao;
	
	public UserDTO userLoginService(UserDTO dto)
	{
		logger.info("Starting userLoginService()...");
		UserDTO obdto = null;
		
		try
		{
			if(dto.getU_name() != null && dto.getU_password() != null)
			{
				logger.info("Username and password found..");
				obdto = dao.authenticateUserLogin(dto);
			}
			else
			{
				logger.info("username and password not found");
			}
		}
		catch(Exception e)
		{
			logger.info("Exception " + e);
			e.printStackTrace();
		}
		logger.info("Ending userLoginService()");
		return obdto;
	}
	
	public int hello()
	{ 
		return 1;
		
	}

}
