package com.nuvizz.facility.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class UserDTO implements Serializable {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "u_id")
	private int u_id;
	@Column(name = "u_name")
	private String u_name;
	@Column(name = "u_password")
	private String u_password;
	@Column(name = "u_token")
	private String u_token;
	@Column(name = "u_status")
	private int u_status;
	// 10 - loggedIn
	// 20 - loggedOut
	// 30 - disabled
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "u_id", updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "r_id", updatable = false) })
	private Collection<RoleDTO> roleDTOs;
	
	@ManyToOne
	@JoinColumn(name = "c_id")
	private CompanyDTO companyDto;

	public Collection<RoleDTO> getRoleDTOs() {
		return roleDTOs;
	}

	public void setRoleDTOs(Collection<RoleDTO> roleDTOs) {
		this.roleDTOs = roleDTOs;
	}

	public CompanyDTO getCompanyDto() {
		return companyDto;
	}

	public void setCompanyDto(CompanyDTO companyDto) {
		this.companyDto = companyDto;
	}

	public UserDTO() {
		System.out.println("UserDTO constructor");
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_token() {
		return u_token;
	}

	public void setU_token(String u_token) {
		this.u_token = u_token;
	}

	public int getU_status() {
		return u_status;
	}

	public void setU_status(int u_status) {
		this.u_status = u_status;
	}

	@Override
	public String toString() {
		return "UserDTO [u_id=" + u_id + ", u_name=" + u_name + ", u_password="
				+ u_password + ", u_token=" + u_token + ", u_status="
				+ u_status + "]";
	}

}
