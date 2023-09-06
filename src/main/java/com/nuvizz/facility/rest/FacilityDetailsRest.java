package com.nuvizz.facility.rest;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.nuvizz.facility.PoJoClasses.PoJoFacility;
import com.nuvizz.facility.action.PoJoFacilityRequestClass;
import com.nuvizz.facility.action.PoJoFacilityResponseClass;
import com.nuvizz.facility.actionHandler.ActionHandlerService;
import com.nuvizz.facility.actionHandler.FactoryActionHandle;
import com.nuvizz.facility.service.facility.FacilityServiceImpl;

@Component
@Path("/FacilityDetails")
@RequestMapping("/")
public class FacilityDetailsRest {
	private static final Logger logger = LoggerFactory
			.getLogger(FacilityDetailsRest.class);

	@Autowired
	FacilityServiceImpl facilitySer;
	
	private static final String ACTION_NAME_LOGIN = "login";
	private static final Object ACTION_NAME_FETCH_FACILITY = "fetchFacility";
	private static final String ACTION_NAME_LOGOUT = "logout";


	public FacilityDetailsRest() {
		logger.info("Inside FacilityDetailsRest()...");
	}

	
	
	@POST
	@Path("/list")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFacilityDetails(InputStream in,  @Context HttpServletRequest request) 
	{
		logger.info("Starting getFacilityDetails() taking pojo class...");
		//HttpSession session = request.getSession(true);
		
		try
		{
			PoJoFacilityResponseClass respClass = null;
			PoJoFacility pojoFacility = new PoJoFacility();
			//Get JSON String from inputStream
			String requestFromJson = IOUtils.toString(in);
			
			//convert String into JSON object using GSON
			Gson g = new Gson();
			PoJoFacilityRequestClass reqClass = g.fromJson(requestFromJson, PoJoFacilityRequestClass.class);

			String actionName = reqClass.getActionName();
			//Logic to implement list/login/logout of facility..
			ActionHandlerService refService = FactoryActionHandle.returnActionHandlerObject(actionName);
			respClass = refService.handleAction(reqClass);
			if(respClass != null)
				return Response.status(Status.OK).entity(g.toJson(respClass)).build();
			else
				return Response.status(Status.OK).entity("Fail").build();
			
		}
		catch (Exception e) 
		{
			logger.info("Exception " + e);
			e.printStackTrace();
		}
		return Response.status(Status.OK).entity("Fail").build();

	}

}
