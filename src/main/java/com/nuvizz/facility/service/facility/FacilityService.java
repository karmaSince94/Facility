package com.nuvizz.facility.service.facility;

import java.util.List;

import com.nuvizz.facility.dto.FacilityDTO;

public interface FacilityService 
{
	public FacilityDTO saveFacilityService(FacilityDTO dto);
	public List<FacilityDTO> viewFacilityService(int c_id);
	public FacilityDTO updateFacilityService(FacilityDTO dto);
	public FacilityDTO getFacilityObject(int f_id);
	public int getCompanyId(String uname);
	

}
