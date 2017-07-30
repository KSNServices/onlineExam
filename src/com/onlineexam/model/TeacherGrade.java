


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
@Table(name="teacher_grade")
public class TeacherGrade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name="teacher_grades")
	private String teacherGradeValue;
	
	@Column(name="grade_pay")
	private Double gradePay;
	
	
	

	@Column(name="salary_range_start")
	private Double salaryRangeStart;
	
	
	@Column(name="salary_range_end")
	private Double salaryRangeEnd;
	
	@Column(name="description")
	private String gradedescription;
	
	
	
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

	public String getTeacherGradeValue() {
		return teacherGradeValue;
	}

	public void setTeacherGradeValue(String teacherGradeValue) {
		this.teacherGradeValue = teacherGradeValue;
	}

	public Double getGradePay() {
		return gradePay;
	}

	public void setGradePay(Double gradePay) {
		this.gradePay = gradePay;
	}

	public Double getSalaryRangeStart() {
		return salaryRangeStart;
	}

	public void setSalaryRangeStart(Double salaryRangeStart) {
		this.salaryRangeStart = salaryRangeStart;
	}

	public Double getSalaryRangeEnd() {
		return salaryRangeEnd;
	}

	public void setSalaryRangeEnd(Double salaryRangeEnd) {
		this.salaryRangeEnd = salaryRangeEnd;
	}

	public String getGradedescription() {
		return gradedescription;
	}

	public void setGradedescription(String gradedescription) {
		this.gradedescription = gradedescription;
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
