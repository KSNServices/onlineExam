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
@Table(name="exam_schedule")

public class ExamSchedule implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name ="exam_date")
	private Integer examDate;
	
	@Column(name="class")
	private String className;

	@Column(name ="section")
	private Integer section;

	@Column(name="exam_time")
	private String examTime;

	@Column(name ="subject")
	private Integer subject;

	@Column(name="teacher_assigned")
	private String teacherAssigned;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExamDate() {
		return examDate;
	}

	public void setExamDate(Integer examDate) {
		this.examDate = examDate;
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

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public Integer getSubject() {
		return subject;
	}

	public void setSubject(Integer subject) {
		this.subject = subject;
	}

	public String getTeacherAssigned() {
		return teacherAssigned;
	}

	public void setTeacherAssigned(String teacherAssigned) {
		this.teacherAssigned = teacherAssigned;
	}
	
	
}
