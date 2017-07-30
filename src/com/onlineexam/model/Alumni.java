package com.onlineexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="alumni")

public class Alumni implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	
	
	@Column(name ="name")
	private Integer name;
	
	@Column(name="pass_class")
	private String passClass;
	
	@Column(name ="pass_year")
	private Integer passYear;
	
	@Column(name="qualification")
	private String qualification;

	@Column(name ="work_place")
	private Integer workPlace;
	
	@Column(name="about_me")
	private String aboutMe;
	
	@ManyToOne
	@JoinColumn(name="school_id")
	private User schoolId;
	
	@ManyToOne
	@JoinColumn(name="admin_id")
	private User adminId;
	
	public User getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(User schoolId) {
		this.schoolId = schoolId;
	}

	public User getAdminId() {
		return adminId;
	}

	public void setAdminId(User adminId) {
		this.adminId = adminId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getName() {
		return name;
	}

	public void setName(Integer name) {
		this.name = name;
	}

	public String getPassClass() {
		return passClass;
	}

	public void setPassClass(String passClass) {
		this.passClass = passClass;
	}

	public Integer getPassYear() {
		return passYear;
	}

	public void setPassYear(Integer passYear) {
		this.passYear = passYear;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Integer getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(Integer workPlace) {
		this.workPlace = workPlace;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	
}
