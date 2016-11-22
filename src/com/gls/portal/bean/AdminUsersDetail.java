package com.gls.portal.bean;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;


@Entity
@Table(name="admin_users_details")
public class AdminUsersDetail implements Serializable{
	
	//private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	@Temporal( TemporalType.TIMESTAMP)	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	@Column(name="date_of_joining")
	private Date dateOfJoining;
	private String designation;
	private String project;
	private String manager;
	/*@Column(name="email_id")
	private String emailId;
	private String password;
	@Column(name="mobile_no")
	private String mobileNo;*/
	@Column(name="marital_status")
	private String maritalStatus;
	@Column(name="date_of_marriage")
	private Date dateOfMarriage;
	@Column(name="parent_name")
	private String parentName;
	@Column(name="parent_contact")
	private String parentContact;
	@Column(name="blood_group")
	private String bloodGroup;
	@Column(name="total_exp")
	private int totalYearOfExperience;
	private String address;
	@Column(name="photo_path")
	private String photoPath;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="userid")
	@JsonBackReference
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@JsonSerialize(using=DateSerializer.class)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	/*public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}*/
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Date getDateOfMarriage() {
		return dateOfMarriage;
	}
	public void setDateOfMarriage(Date dateOfMarriage) {
		this.dateOfMarriage = dateOfMarriage;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getParentContact() {
		return parentContact;
	}
	public void setParentContact(String parentContact) {
		this.parentContact = parentContact;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public int getTotalYearOfExperience() {
		return totalYearOfExperience;
	}
	public void setTotalYearOfExperience(int totalYearOfExperience) {
		this.totalYearOfExperience = totalYearOfExperience;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	/*public String toJSONString() {
		JSONObject userJonObj = new JSONObject();
		userJonObj.put("firstname", firstname);
		userJonObj.put("lastname", lastname);
		userJonObj.put("dateOfBirth", formatDateToString(dateOfBirth));
		userJonObj.put("dateOfJoining", formatDateToString(dateOfJoining));
		userJonObj.put("designation", designation);
		userJonObj.put("project", project);
		userJonObj.put("manager", manager);
		userJonObj.put("emailId", emailId);
		userJonObj.put("password", password);
		userJonObj.put("mobileNo", mobileNo);
		userJonObj.put("maritalStatus", maritalStatus);
		userJonObj.put("dateOfMarriage",  formatDateToString(dateOfMarriage));
		userJonObj.put("parentName", parentName);
		userJonObj.put("parentContact", parentContact);
		userJonObj.put("bloodGroup", bloodGroup);
		userJonObj.put("Address", address);
		userJonObj.put("totalYearOfExperience", String.valueOf(totalYearOfExperience));
		userJonObj.put("address", address);
		userJonObj.put("photoPath", photoPath);
		return userJonObj.toJSONString();
	}
	
	public String formatDateToString(Date date){
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		String s = formatter.format(date);
		return s;
	} */

}
