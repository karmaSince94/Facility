package com.nuvizz.facility.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nuvizz.facility.dto.FacilityDTO;
import com.nuvizz.facility.dto.RoleDTO;
import com.nuvizz.facility.dto.UserDTO;
import com.nuvizz.facility.service.facility.FacilityServiceImpl;
import com.nuvizz.facility.service.user.UserLoginServiceImpl;

@Component
@RequestMapping("/")
public class FacilityController 
{
	@Autowired
	UserLoginServiceImpl ser;
	
	@Autowired
	FacilityServiceImpl faciltiySer;
	
	private static final Logger logger = LoggerFactory.getLogger(FacilityController.class);
	
	public FacilityController()
	{
		System.out.println("FacilityController Constructor");
	}
	
	@RequestMapping("welcome.do")
	public String welcome(HttpServletRequest req)
	{
		logger.info("Inside Welcome()...");
		return "Login";
	}
	
	@RequestMapping("login.do")
	public String login(UserDTO dto, HttpServletRequest req)
	{ 
		try
		{
		String rName = "";
		logger.info("Inside Login()...");
		System.out.println("dto=" + dto);
		
		UserDTO userDto = ser.userLoginService(dto);
		
		List<RoleDTO> dtos=(List<RoleDTO>) userDto.getRoleDTOs();
		for (RoleDTO roleDTO2 : dtos) 
		{
			rName = roleDTO2.getR_name();
		}
		System.out.println(userDto);
		System.out.println(rName);
		if (userDto != null) 
		{
			HttpSession session = req.getSession(true);
			session.setAttribute("rName", rName);
			session.setAttribute("obj1", userDto);
			session.setAttribute("user", userDto.getU_name());
			session.setAttribute("token", userDto.getU_token());
			return "redirect:/view.do";
		}
		}
		catch(Exception e)
		{
			logger.info("Exception " + e);
		}
		return "Error";
		
	}
	
	@RequestMapping("registerFacilityNavigate.do")
	public String registerFacilityNavigate(HttpServletRequest req)
	{
		logger.info("Inside registerFacilityNavigate()...");
		return "RegisterFacility";
	} 
	
	@RequestMapping("registerFacility.do")
	public String registerFacility(FacilityDTO dto, HttpServletRequest req)
	{
		logger.info("Inside registerFacility()...");
		System.out.println(dto);
		HttpSession session = req.getSession(false);
				
		/*UserDTO userDto = (UserDTO) session.getAttribute("obj1");
		int c_id = userDto.getCompanyDto().getC_id();*/
		//HttpSession session = req.getSession(false);
		FacilityDTO facilityDto = faciltiySer.saveFacilityService(dto);
		try
		{
			if(facilityDto != null)
			{
//				logger.info("In controller..facilityDto object found");
//				List<FacilityDTO> dtos = faciltiySer.viewFacilityService();
//				for (FacilityDTO facilityDTO : dtos) {
//					System.out.println(facilityDTO);
//				}
//				 
//				session.setAttribute("view", dtos);
				return "redirect:/view.do";
			}
		}
		catch(Exception e)
		{
			logger.info("Exception "+ e);
			e.printStackTrace();
		}
		
		return "Error";
	}
	
	@RequestMapping("/view.do")
	public String viewFacility(HttpServletRequest req)
	{
		logger.info("in viewFacility()################################..");
		String uname="";
		HttpSession session = req.getSession(false);
		
		//get particular username from session
		// = (String) session.getAttribute("user");
		
		//get particular company id by using uname
		//int c_id = faciltiySer.getCompanyId(uname);
		try
		{
		UserDTO userDto = (UserDTO) session.getAttribute("obj1");
		int c_id = userDto.getCompanyDto().getC_id();
		
		List<FacilityDTO> dtos = faciltiySer.viewFacilityService(c_id);
		 
		session.setAttribute("view", dtos);
		if (dtos != null) 
		{
			for (FacilityDTO facilityDTO : dtos) 
			{
				System.out.println(facilityDTO);
			}
			return "View";

		}
		}
		catch(Exception e)
		{
			logger.info("Exception " + e);
			e.printStackTrace();
		}
		return "Error";
	}
	
	
	@RequestMapping("/updateFacilityNavigate.do")
	public String updateFacilityNavigate(HttpServletRequest req,  Model uiModel)
	{
		FacilityDTO dtoFromDB;
		try
		{
		HttpSession session = req.getSession(false);
		logger.info("Inside updateFacilityNavigate()...");
		int f_id = Integer.parseInt(req.getParameter("id"));
		System.out.println(f_id);
		
		//get the dto object using id
		dtoFromDB = faciltiySer.getFacilityObject(f_id);
		uiModel.addAttribute("dto", dtoFromDB);
		return "UpdateFacility";
		}
		catch(Exception e)
		{
			logger.info("Exception " + e);
			e.printStackTrace();
		}
		return null;
	} 
	
	@RequestMapping(value = "/updateFacility.do", method = RequestMethod.POST)
	public String updateFacility(FacilityDTO dto, HttpServletRequest req)
	{
		logger.info("Inside updateFacility()&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&...");
		System.out.println(dto);
		//HttpSession session = req.getSession(false);
		//FacilityDTO dto1;
		/*
		dto1 = (FacilityDTO)session.getAttribute("view");
		dto.setF_id(dto1.getF_id());
		*/
		FacilityDTO facilityDto = faciltiySer.updateFacilityService(dto);
		try
		{
			if(facilityDto != null)
			{
				//session.setAttribute("view", dto);
				return "redirect:/view.do";
			}
		}
		catch(Exception e)
		{
			logger.info("Exception "+ e);
			e.printStackTrace();
		}
		
		return "Error";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req) 
	{
	   HttpSession session=req.getSession(false);
	   session.removeAttribute("obj1");
	   session.invalidate();
	   return "redirect:/welcome.do";
	 }
	
	
	
}
