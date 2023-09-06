package com.nuvizz.facility.dao.facility;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.facility.dto.FacilityDTO;

@Component
public class FacilityDAOImpl 
{
	@Autowired
	SessionFactory factory;
	
	private static final Logger logger = LoggerFactory.getLogger(FacilityDAOImpl.class);
	
	public FacilityDTO saveFacilityDetails(FacilityDTO dto) 
	{
		logger.info("Starting saveFacilityDetails()... ");
		Session s = factory.openSession();
		Transaction t = s.beginTransaction();
		try 
		{
			if (dto != null) 
			{
				s.save(dto);
				t.commit();
			}
		} 
		catch (HibernateException e) 
		{
			t.rollback();
			logger.info("Exception " + e);
			e.printStackTrace();
			
		}
		finally 
		{
			s.close();
		}
		logger.info("Ending saveFacilityDetails()...");
		return dto;
	}

	public List<FacilityDTO> viewFacilityDAO(int c_id) 
	{
		logger.info("Starting viewFacilityDAO()...");
		Session s = null;
		List<FacilityDTO> dtos=null;
		try
		{
			s =factory.openSession();
			//String s1 = "select facility from FacilityDTO facility where facility.c_id="+id;
			String s1 = "Select F from FacilityDTO F where F.companyDto.c_id=:c_id";
			Query q = s.createQuery(s1);
			q.setParameter("c_id", c_id);
			dtos = q.list();
			System.out.println(dtos.size());
	
			return dtos;

		} 
		catch (HibernateException he) 
		{
			System.err.println("Exception " + he.getMessage());
			he.printStackTrace();
		} 
		finally {
			s.close();
		}
		return null;
	}

	public FacilityDTO updateFacilityDetails(FacilityDTO dto) 
	{
		logger.info("Starting updateFacilityDetails()... ");
		System.out.println(dto);
		Session session = null;
		Transaction tx = null;
		int id = dto.getF_id();
		String fname = dto.getF_name();
		
		try 
		{
			if (dto != null) 
			{
				//String syntax = "Update F from FacilityDTO F set " + 
				session = factory.openSession();
				tx = session.beginTransaction();
				session.update(dto);
				tx.commit();
			}
		} 
		catch (HibernateException e) 
		{
			tx.rollback();
			logger.info("Exception " + e);
			e.printStackTrace();
			
		}
		finally 
		{
			session.close();
		}
		logger.info("Ending saveFacilityDetails()...");
		return dto;
		
		
		
	}

	public FacilityDTO getFacilityObjectById(int f_id) 
	{
		FacilityDTO dto = null;
		Session session = factory.openSession();
		//Transaction t = session.beginTransaction();
		try
		{
			if(f_id != 0)
			{
				String syntax = "select F from FacilityDTO F where F.f_id = "+f_id +" ";
				Query query = session.createQuery(syntax);
				dto = (FacilityDTO)query.uniqueResult();
				if(dto != null)
				{
					logger.info("Facility object found(fetchbyid)");
					return dto;
				}
				else
				{
					logger.info("FacilityDTO object not found(fetchbyid)");
				}
		
			}
		}
		catch(Exception e)
		{
			logger.info("Exception " + e);
			e.printStackTrace();
		}

		return null;
	}

	public int getCompanyIdByUname(String uname) 
	{
		int c_id=0;
		Session session = factory.openSession();
		//Transaction t = session.beginTransaction();
		try
		{
			if(uname != null)
			{
				//String syntax = "select U.c_id from UserDTO U where U.u_name=:uname";
				String syntax = "select U.companyDto.c_id from UserDTO U where U.u_name=:uname";
				Query query = session.createQuery(syntax);
				query.setParameter("c_id", c_id);
				query.setParameter("uname", uname);
				c_id = (Integer)query.uniqueResult();
				if(c_id != 0)
				{
					logger.info("Company ID found(fetchbyUname)");
					return c_id;
				}
				else
				{
					logger.info("FacilityDTO object not found(fetchbyid)");
				}
		
			}
		}
		catch(Exception e)
		{
			logger.info("Exception " + e);
			e.printStackTrace();
		}
		return c_id;
	}

}
