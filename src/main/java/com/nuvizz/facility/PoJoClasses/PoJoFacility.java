package com.nuvizz.facility.PoJoClasses;

import java.io.Serializable;

public class PoJoFacility implements Serializable
{
	private int f_id;
	private String f_name;
	private String f_addr1;
	private String f_addr2;
	private Long f_zip;
	private String f_state;
	private String f_country;
	private Double f_latitude;
	private Double f_longitude;
	private int c_id;
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
	public void setF_longitude(Double f_longitude) {
		this.f_longitude = f_longitude;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	@Override
	public String toString() {
		return "PoJoFacility [f_id=" + f_id + ", f_name=" + f_name
				+ ", f_addr1=" + f_addr1 + ", f_addr2=" + f_addr2 + ", f_zip="
				+ f_zip + ", f_state=" + f_state + ", f_country=" + f_country
				+ ", f_latitude=" + f_latitude + ", f_longitude=" + f_longitude
				+ ", c_id=" + c_id + "]";
	}
	

}
