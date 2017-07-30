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
@Table(name="class_schedule")

public class ClassSchedule implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name ="period")
	private Integer period;
	
	@Column(name ="time")
	private Integer time;
	
	@Column(name="class")
	private String className;

	@Column(name ="section")
	private Integer section;
	
	@Column(name="monday_subject")
	private String mondaySubject;

	@Column(name ="monday_teacher")
	private Integer mondayTeacher;
	
	@Column(name="tuesday_subject")
	private String tuesdaySubject;

	@Column(name ="tuesday_teacher")
	private Integer tuesdayTeacher;
	
	@Column(name="wednesday_subject")
	private String wednesdaySubject;

	@Column(name ="wednesday_teacher")
	private Integer wednesdayTeacher;
	
	@Column(name="thursday_subject")
	private String thursdaySubject;

	@Column(name ="thursday_teacher")
	private Integer thursdayTeacher;
	
	@Column(name="friday_subject")
	private String fridaySubject;

	@Column(name ="friday_teacher")
	private Integer fridayTeacher;
	
	@Column(name="saturday_subject")
	private String saturdaySubject;

	@Column(name ="saturday_teacher")
	private Integer saturdayTeacher;
	
	@Column(name="sunday_subject")
	private String sundaySubject;

	@Column(name ="sunday_teacher")
	private Integer sundayTeacher;
	
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

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getSection() {
		return section;
	}

	public void setSection(Integer section) {
		this.section = section;
	}

	public String getMondaySubject() {
		return mondaySubject;
	}

	public void setMondaySubject(String mondaySubject) {
		this.mondaySubject = mondaySubject;
	}

	public Integer getMondayTeacher() {
		return mondayTeacher;
	}

	public void setMondayTeacher(Integer mondayTeacher) {
		this.mondayTeacher = mondayTeacher;
	}

	public String getTuesdaySubject() {
		return tuesdaySubject;
	}

	public void setTuesdaySubject(String tuesdaySubject) {
		this.tuesdaySubject = tuesdaySubject;
	}

	public Integer getTuesdayTeacher() {
		return tuesdayTeacher;
	}

	public void setTuesdayTeacher(Integer tuesdayTeacher) {
		this.tuesdayTeacher = tuesdayTeacher;
	}

	public String getWednesdaySubject() {
		return wednesdaySubject;
	}

	public void setWednesdaySubject(String wednesdaySubject) {
		this.wednesdaySubject = wednesdaySubject;
	}

	public Integer getWednesdayTeacher() {
		return wednesdayTeacher;
	}

	public void setWednesdayTeacher(Integer wednesdayTeacher) {
		this.wednesdayTeacher = wednesdayTeacher;
	}

	public String getThursdaySubject() {
		return thursdaySubject;
	}

	public void setThursdaySubject(String thursdaySubject) {
		this.thursdaySubject = thursdaySubject;
	}

	public Integer getThursdayTeacher() {
		return thursdayTeacher;
	}

	public void setThursdayTeacher(Integer thursdayTeacher) {
		this.thursdayTeacher = thursdayTeacher;
	}

	public String getFridaySubject() {
		return fridaySubject;
	}

	public void setFridaySubject(String fridaySubject) {
		this.fridaySubject = fridaySubject;
	}

	public Integer getFridayTeacher() {
		return fridayTeacher;
	}

	public void setFridayTeacher(Integer fridayTeacher) {
		this.fridayTeacher = fridayTeacher;
	}

	public String getSaturdaySubject() {
		return saturdaySubject;
	}

	public void setSaturdaySubject(String saturdaySubject) {
		this.saturdaySubject = saturdaySubject;
	}

	public Integer getSaturdayTeacher() {
		return saturdayTeacher;
	}

	public void setSaturdayTeacher(Integer saturdayTeacher) {
		this.saturdayTeacher = saturdayTeacher;
	}

	public String getSundaySubject() {
		return sundaySubject;
	}

	public void setSundaySubject(String sundaySubject) {
		this.sundaySubject = sundaySubject;
	}

	public Integer getSundayTeacher() {
		return sundayTeacher;
	}

	public void setSundayTeacher(Integer sundayTeacher) {
		this.sundayTeacher = sundayTeacher;
	}
	
	
	
	

}
