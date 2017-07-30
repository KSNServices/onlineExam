
package com.onlineexam.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="class_name")
public class ClassName implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name="class_present")
	private String classPresent;
	
	@Column(name="class_name")
	private String classNameValue;
	
	
	

	@Column(name="strength")
	private Integer strength;
	
	@Column(name="description")
	private String Classdescription;
	
	
	
	@Column(name="status")
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name="school_id")
	private User schoolId;
	
	@ManyToOne
	@JoinColumn(name="admin_id")
	private User adminId;
	

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassPresent() {
		return classPresent;
	}

	public void setClassPresent(String classPresent) {
		this.classPresent = classPresent;
	}


	public String getClassNameValue() {
		return classNameValue;
	}

	public void setClassNameValue(String classNameValue) {
		this.classNameValue = classNameValue;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	

	public String getClassdescription() {
		return Classdescription;
	}

	public void setClassdescription(String classdescription) {
		Classdescription = classdescription;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

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

	

}
