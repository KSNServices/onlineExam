package com.onlineexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="extra_activities")

public class ExtraActivities implements java.io.Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name ="activity_name")
	private Integer activityName;
	
	@Column(name="date")
	private String date;

	@Column(name ="participants")
	private Integer participants;

	@Column(name="incharge_teacher")
	private String inchargeTeacher;
	
	
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

	public Integer getActivityName() {
		return activityName;
	}

	public void setActivityName(Integer activityName) {
		this.activityName = activityName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getParticipants() {
		return participants;
	}

	public void setParticipants(Integer participants) {
		this.participants = participants;
	}

	public String getInchargeTeacher() {
		return inchargeTeacher;
	}

	public void setInchargeTeacher(String inchargeTeacher) {
		this.inchargeTeacher = inchargeTeacher;
	}
	
	

}
