package com.nuvizz.facility.dto;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name = "facility")
@JsonIgnoreProperties(value="companyDto")
public class FacilityDTO implements Serializable
{
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "f_id")
	private int f_id;
	@Column(name = "f_name")
	private String f_name;
	@Column(name = "f_addr1")
	private String f_addr1;
	@Column(name = "f_addr2")
	private String f_addr2;
	@Column(name = "f_zip")
	private Long f_zip;
	@Column(name = "f_state")
	private String f_state;
	@Column(name = "f_country")
	private String f_country;
	@Column(name = "f_latitude")
	private Double f_latitude;
	@Column(name = "f_longitude")
	private Double f_longitude;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "c_id", referencedColumnName = "c_id")
	private CompanyDTO companyDto;

	
	
	public FacilityDTO()
	{
		System.out.println("FacilityDTO constructor");
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getF_addr1() {
		return f_addr1;
	}

	public void setF_addr1(String f_addr1) {
		this.f_addr1 = f_addr1;
	}

	public String getF_addr2() {
		return f_addr2;
	}

	public void setF_addr2(String f_addr2) {
		this.f_addr2 = f_addr2;
	}

	public Long getF_zip() {
		return f_zip;
	}

	public void setF_zip(Long f_zip) {
		this.f_zip = f_zip;
	}

	public String getF_state() {
		return f_state;
	}

	public void setF_state(String f_state) {
		this.f_state = f_state;
	}

	public String getF_country() {
		return f_country;
	}

	public void setF_country(String f_country) {
		this.f_country = f_country;
	}

	public Double getF_latitude() {
		return f_latitude;
	}

	public void setF_latitude(Double f_latitude) {
		this.f_latitude = f_latitude;
	}

	public Double getF_longitude() {
		return f_longitude;
	}

	public void setF_logitude(Double f_longitude) {
		this.f_longitude = f_longitude;
	}

	public CompanyDTO getCompanyDto() {
		return companyDto;
	}

	public void setCompanyDto(CompanyDTO companyDto) {
		this.companyDto = companyDto;
	}

	public void setF_longitude(Double f_longitude) {
		this.f_longitude = f_longitude;
	}

	@Override
	public String toString() {
		return "FacilityDTO [f_id=" + f_id + ", f_name=" + f_name
				+ ", f_addr1=" + f_addr1 + ", f_addr2=" + f_addr2 + ", f_zip="
				+ f_zip + ", f_state=" + f_state + ", f_country=" + f_country
				+ ", f_latitude=" + f_latitude + ", f_longitude=" + f_longitude
				+ /*", c_id=" + c_id + */"]";
	}

	

	

}
