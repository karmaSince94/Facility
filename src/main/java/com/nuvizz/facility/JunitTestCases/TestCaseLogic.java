package com.nuvizz.facility.JunitTestCases;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nuvizz.facility.dto.UserDTO;
import com.nuvizz.facility.service.user.UserLoginServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)

public class TestCaseLogic 
{
	@Autowired
	static UserLoginServiceImpl ser;
	
	@Test
	public static UserDTO testUserObject(UserDTO dto)
	{
		UserDTO userDto = ser.userLoginService(dto);
		Assert.assertEquals(userDto, dto);
		return userDto;
	}
	

}
