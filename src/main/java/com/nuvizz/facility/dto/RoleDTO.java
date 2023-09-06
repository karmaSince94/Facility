package com.nuvizz.facility.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name = "role")
public class RoleDTO implements Serializable
{
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "r_id")
	private int r_id;
	@Column(name = "r_name")
	private String r_name;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "roleDTOs")
	private Collection<UserDTO> userDto;
	
	public Collection<UserDTO> getUserDto() {
		return userDto;
	}

	public void setUserDto(Collection<UserDTO> userDto) {
		this.userDto = userDto;
	}

	public RoleDTO() 
	{
		System.out.println("RoleDTO contructor");
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	@Override
	public String toString() {
		return "RoleDTO [r_id=" + r_id + ", r_name=" + r_name + "]";
	}
	
	

}
