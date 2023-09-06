package com.nuvizz.facility.service.facility;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.facility.dao.facility.FacilityDAOImpl;
import com.nuvizz.facility.dto.FacilityDTO;

@Component
public class FacilityServiceImpl 
{
	@Autowired
	FacilityDAOImpl facilityDao;
	
	private static final Logger logger = LoggerFactory.getLogger(FacilityServiceImpl.class);
	

	public FacilityDTO saveFacilityService(FacilityDTO dto)
	{
		logger.info("Entering saveFacilityService()...");
		FacilityDTO obdto = null;
		
		try
		{
			if(dto != null)
			{
				logger.info("Facility object found..");
				obdto = facilityDao.saveFacilityDetails(dto);
			}
			else
			{
				System.out.println("Facility object not found");
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception " + e);
			e.printStackTrace();
		}
		logger.info("Entering saveFacilityService()");
		return obdto;
	}


	public List<FacilityDTO> viewFacilityService(int c_id) 
	{
		System.out.println("Starting viewFacilityService()...");
		List<FacilityDTO> dtos;
		try 
		{
			dtos = facilityDao.viewFacilityDAO(c_id);
			return dtos;
		}
		catch (Exception e) 
		{
			logger.info("Exception in mobile service " + e);
			e.printStackTrace();
		}

		logger.info("Ending viewFacilityService()...");
		return null;
	}


	public FacilityDTO updateFacilityService(FacilityDTO dto) 
	{
		logger.info("Entering updateFacilityService()...");
		FacilityDTO obdto = null;
		
		try
		{
			if(dto != null)
			{
				logger.info("Facility object found..");
				obdto = facilityDao.updateFacilityDetails(dto);
			}
			else
			{
				System.out.println("Facility object not found");
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception " + e);
			e.printStackTrace();
		}
		logger.info("Entering updateFacilityService()");
		return obdto;
	}

	//get facility object
	public FacilityDTO getFacilityObject(int f_id) 
	{
		logger.info("Entering getFacilityObject()...");
		FacilityDTO dto = null;
		try
		{
			if(f_id != 0)
			{
				dto = facilityDao.getFacilityObjectById(f_id);
				return dto;
			}
		}
		catch(Exception e)
		{
			logger.info("Exception " + e);
			e.printStackTrace();
		}


		return dto;
	}

	
	//get particular company id by using uname
	public int getCompanyId(String uname) 
	{
		logger.info("Entering getCompanyId()...");
		int c_id=0;
		try
		{
			if(uname != null)
			{
				c_id = facilityDao.getCompanyIdByUname(uname);
				return c_id;
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
