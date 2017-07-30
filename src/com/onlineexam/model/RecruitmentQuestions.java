package com.onlineexam.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="recruitment_questions")
public class RecruitmentQuestions implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name="question_statement")
	private String questionStatement;
	
	@ManyToOne
	@JoinColumn(name="online_exam_subjects_id")
	private OnlineExamSubjects subjects;
	
	@Column(name="status")
	private Boolean status;
	
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

	public OnlineExamSubjects getSubjects() {
		return subjects;
	}

	public void setSubjects(OnlineExamSubjects subjects) {
		this.subjects = subjects;
	}

	public String getQuestionStatement() {
		return questionStatement;
	}

	public void setQuestionStatement(String questionStatement) {
		this.questionStatement = questionStatement;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
