package com.nuvizz.facility.actionHandler;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.nuvizz.facility.PoJoClasses.PoJoFacility;
import com.nuvizz.facility.action.ActionResponse;
import com.nuvizz.facility.action.PoJoFacilityRequestClass;
import com.nuvizz.facility.action.PoJoFacilityResponseClass;
import com.nuvizz.facility.dao.facility.FacilityDAOImpl;
import com.nuvizz.facility.dto.FacilityDTO;
import com.nuvizz.facility.dto.UserDTO;


@Configurable
public class FetchFacilityActionHandler implements ActionHandlerService
{
	
	private SessionFactory sessionFactory;
	
	public FetchFacilityActionHandler(){
		 WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		 sessionFactory = (SessionFactory)context.getBean("sessionFactory");
	}
	
	
	private static final Logger logger = LoggerFactory.getLogger(FacilityDAOImpl.class);
		
	public PoJoFacilityResponseClass handleAction(PoJoFacilityRequestClass reqClass)
	{
		logger.info("Starting handleAction() For Facility...");
		PoJoFacilityResponseClass respClass = new PoJoFacilityResponseClass();
		ActionResponse actionResponse = new ActionResponse();
		String token = reqClass.getActionReq().getU_token();
		int c_id=0;
		UserDTO userDto = null;
		Session session = null;
		List<FacilityDTO> listFromDB = null;
		List<PoJoFacility> pojofacility = new ArrayList<PoJoFacility>();
		
		try
		{
			session = sessionFactory.openSession();
			String selectQuery1 = "select user from UserDTO user where user.u_token = '"+token+"'";
			Query q = session.createQuery(selectQuery1);
			//q.setParameter("c_id", c_id);
			//dtos = q.list();
			userDto = (UserDTO)q.uniqueResult();
			c_id = userDto.getCompanyDto().getC_id();
			
			//get facility using c_id
			String selectQuery2 = "select facility from FacilityDTO facility where facility.companyDto.c_id="+c_id;
			q = session.createQuery(selectQuery2);
			listFromDB = (List<FacilityDTO>) q.list();
			
			//copy dtos list into pojoFacility list
			for(FacilityDTO facilityDTO : listFromDB)
			{

				PoJoFacility samplePoJo = new PoJoFacility();
				samplePoJo.setF_id(facilityDTO.getF_id());
				samplePoJo.setF_name(facilityDTO.getF_name());
				samplePoJo.setF_addr1(facilityDTO.getF_addr1());
				samplePoJo.setF_addr2(facilityDTO.getF_addr2());
				samplePoJo.setF_zip(facilityDTO.getF_zip());
				samplePoJo.setF_state(facilityDTO.getF_state());
				samplePoJo.setF_country(facilityDTO.getF_country());
				samplePoJo.setF_latitude(facilityDTO.getF_latitude());
				samplePoJo.setF_longitude(facilityDTO.getF_longitude());
				samplePoJo.setC_id(facilityDTO.getCompanyDto().getC_id());
				pojofacility.add(samplePoJo);
				
			}
			actionResponse.setPojoFacility(pojofacility);
			actionResponse.setStatus(userDto.getU_status());
			respClass.setActionName(reqClass.getActionName());	//set action name
			respClass.setActionResponse(actionResponse);	//set action response
		
			return respClass;
			
		} 
		catch (HibernateException he) 
		{
			System.err.println("Exception " + he.getMessage());
			he.printStackTrace();
		} 
		finally {
			session.close();
		}
		
		return null;
	}

}
