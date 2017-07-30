package com.onlineexam.model;

import java.io.Serializable;
import java.util.logging.Level;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="online_exam_subjects")
public class OnlineExamSubjects implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name="subject_name")
	private String subjectName;
	
	
	@ManyToOne
	@JoinColumn(name="level_id")
	private OnlineExamLevels level;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private boolean enabled;
	
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


	public String getSubjectName() {
		return subjectName;
	}


	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public OnlineExamLevels getLevel() {
		return level;
	}


	public void setLevel(OnlineExamLevels level) {
		this.level = level;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
	

}
