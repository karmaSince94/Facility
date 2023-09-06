package com.nuvizz.facility.dao.user;

import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.facility.dto.UserDTO;
import com.nuvizz.facility.util.TokenGenerator;

@Component
public class UserLoginDAOImpl implements UserLoginDAO
{
	@Autowired
	SessionFactory factory;

	public UserDTO authenticateUserLogin(UserDTO dto) 
	{
		System.out.println("Starting authenticateUserLogin()..");
		Session session = null;
		Transaction tx = null;
		UserDTO fromDB = null;
		String uname = dto.getU_name();
		String upassword = dto.getU_password();
		System.out.println("uname = " + uname + "upassword " + upassword);
		try
		{
			session = factory.openSession();
			if(dto != null)
			{
				String syntax1 = "Select u from UserDTO u where u_name=:uname and u_password=:upassword";
				Query query = session.createQuery(syntax1);
				query.setParameter("uname", uname);
				query.setParameter("upassword", upassword);
				fromDB = (UserDTO)query.uniqueResult();
				System.out.println(fromDB);
				//if(fromDB != null)
				//{
					tx = session.beginTransaction();
					String token = TokenGenerator.createID();		//set generated token
					fromDB.setU_token(token);
					fromDB.setU_status(10);
					System.out.println(fromDB);
					int status = fromDB.getU_status();				//set user status
					String syntax2 = "Update UserDTO u set u.u_token=:token, u.u_status=:status where u.u_name=:uname";
					query = session.createQuery(syntax2);
					query.setParameter("uname", uname);
					query.setParameter("token", token);
					query.setParameter("status", status);
					query.executeUpdate();
					tx.commit();
					
				//}
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception " + e);
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
		System.out.println("Ending authenticateUserLogin()...");
		return fromDB;
	}

}
