package com.nuvizz.facility.dao.facility;

import java.util.List;

import com.nuvizz.facility.dto.FacilityDTO;

public interface FacilityDAO
{
	public FacilityDTO saveFacilityDetails(FacilityDTO dto);
	public List<FacilityDTO> viewFacilityDAO(int c_id);
	public FacilityDTO updateFacilityDetails(FacilityDTO dto);
	public FacilityDTO getFacilityObjectById(int f_id);
	public int getCompanyIdByUname(String uname);
	

}
