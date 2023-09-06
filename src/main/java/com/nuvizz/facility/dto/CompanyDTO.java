package com.nuvizz.facility.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "company")
public class CompanyDTO implements Serializable
{
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "c_id")
	private int c_id;
	@Column(name = "c_name")
	private String c_name;
	
	@OneToMany(fetch=FetchType.EAGER)//(mappedBy = "companyDto")
	@JoinColumn(name = "c_id")
	private List<UserDTO> userDto;
	
	@OneToMany(fetch=FetchType.EAGER)//(mappedBy = "companyDto")
	@JoinColumn(name = "c_id")
	private List<FacilityDTO> facilityDto;
	
	
	public CompanyDTO() 
	{
		System.out.println("CompanyDTO constructor");
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public List<UserDTO> getUserDto() {
		return userDto;
	}

	public void setUserDto(List<UserDTO> userDto) {
		this.userDto = userDto;
	}

	public List<FacilityDTO> getFacilityDto() {
		return facilityDto;
	}

	public void setFacilityDto(List<FacilityDTO> facilityDto) {
		this.facilityDto = facilityDto;
	}

	@Override
	public String toString() {
		return "CompanyDTO [c_id=" + c_id + ", c_name=" + c_name + "]";
	}
	
}
