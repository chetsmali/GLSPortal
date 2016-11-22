package com.gls.portal.bean;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.json.simple.JSONObject;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="users")
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int userid;
	
	String username;
	
	String password;

	String status;	
	
	String emailId;
	
	String mobileNo;	

	@ManyToMany(fetch=FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinTable(name="user_roles", joinColumns={@JoinColumn(name="userid",nullable = false, updatable = true)}
	, inverseJoinColumns={@JoinColumn(name="roleid",nullable = false, updatable = true)})
	private List<Role> roles;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = javax.persistence.CascadeType.ALL)
	@JsonManagedReference
	private AdminUsersDetail adminUsersDetails; 
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public AdminUsersDetail getAdminUsersDetails() {
		return adminUsersDetails;
	}
	public void setAdminUsersDetails(AdminUsersDetail adminUsersDetails) {
		this.adminUsersDetails = adminUsersDetails;
	}
	
	@Transient
	Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Role> roles) {
		for(Role role:roles){
			authorities.add(new GrantedAuthorityImpl(role.getRole()));
		}
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return getStatus().equals("Active");
	}
	@Override
	public boolean isAccountNonLocked() {
		return getStatus().equals("Active");
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return getStatus().equals("Active");
	}
	@Override
	public boolean isEnabled() {
		return getStatus().equals("Active");
	}
	public String toJSONString() {
		JSONObject userJonObj = new JSONObject();
		userJonObj.put("username", username);
		userJonObj.put("password", password);
		userJonObj.put("status", status);
		userJonObj.put("emailId", emailId);
		userJonObj.put("mobileNo", mobileNo);
		
		userJonObj.put("firstname", adminUsersDetails.getFirstname());
		userJonObj.put("lastname", adminUsersDetails.getLastname());
		userJonObj.put("dateOfBirth", formatDateToString(adminUsersDetails.getDateOfBirth()));
		userJonObj.put("dateOfJoining", formatDateToString(adminUsersDetails.getDateOfJoining()));
		userJonObj.put("designation", adminUsersDetails.getDesignation());
		userJonObj.put("project", adminUsersDetails.getProject());
		userJonObj.put("manager", adminUsersDetails.getManager());
		//userJonObj.put("emailId", adminUsersDetails.getEmailId());
		//userJonObj.put("password", adminUsersDetails.getPassword());
		//userJonObj.put("mobileNo", adminUsersDetails.getMobileNo());
		userJonObj.put("maritalStatus", adminUsersDetails.getMaritalStatus());
		//userJonObj.put("dateOfMarriage",  formatDateToString(adminUsersDetails.getDateOfMarriage()));
		userJonObj.put("parentName", adminUsersDetails.getParentName());
		userJonObj.put("parentContact", adminUsersDetails.getParentContact());
		userJonObj.put("bloodGroup", adminUsersDetails.getBloodGroup());
		userJonObj.put("totalYearOfExperience", String.valueOf(adminUsersDetails.getTotalYearOfExperience()));
		userJonObj.put("address", adminUsersDetails.getAddress());
		userJonObj.put("photoPath", adminUsersDetails.getPhotoPath());
		
		return userJonObj.toJSONString();
	}
	
	public String formatDateToString(Date date){
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		String s = formatter.format(date);
		return s;
	} 
}
