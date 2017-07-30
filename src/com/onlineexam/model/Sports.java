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
@Table(name="sports")
 public class Sports implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name ="sport_name")
	private Integer sportName;
	
	@Column(name="sport_teacher")
	private String sportTeacher;
	
	@Column(name ="sport_student_id")
	private Integer sportStudentId;
	
	@Column(name="sport_student_name")
	private String sportStudentName;

	@Column(name ="sport_head_student")
	private Integer sportHeadStudent;
	
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

	public Integer getSportName() {
		return sportName;
	}

	public void setSportName(Integer sportName) {
		this.sportName = sportName;
	}

	public String getSportTeacher() {
		return sportTeacher;
	}

	public void setSportTeacher(String sportTeacher) {
		this.sportTeacher = sportTeacher;
	}

	public Integer getSportStudentId() {
		return sportStudentId;
	}

	public void setSportStudentId(Integer sportStudentId) {
		this.sportStudentId = sportStudentId;
	}

	public String getSportStudentName() {
		return sportStudentName;
	}

	public void setSportStudentName(String sportStudentName) {
		this.sportStudentName = sportStudentName;
	}

	public Integer getSportHeadStudent() {
		return sportHeadStudent;
	}

	public void setSportHeadStudent(Integer sportHeadStudent) {
		this.sportHeadStudent = sportHeadStudent;
	}
	
	
	
}
