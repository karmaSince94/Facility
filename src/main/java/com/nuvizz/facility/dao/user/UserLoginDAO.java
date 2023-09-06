package com.nuvizz.facility.dao.user;

import com.nuvizz.facility.dto.UserDTO;

public interface UserLoginDAO 
{
	public UserDTO authenticateUserLogin(UserDTO dto);

}
