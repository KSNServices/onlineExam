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
@Table(name="recruitment_questions_set_subject_details")
public class RecruitmentQuestionsSetSubjectDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name="online_exam_subject_id")
	private OnlineExamSubjects onlineExamSubjects;
	
	@ManyToOne
	@JoinColumn(name="recruitment_questions_set_id")
	private RecruitmentQuestionsSets recruitmentQuestionsSets;
	
	@Column(name="total_questions")
	private Integer totalQuestions;
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

	public OnlineExamSubjects getOnlineExamSubjects() {
		return onlineExamSubjects;
	}

	public void setOnlineExamSubjects(OnlineExamSubjects onlineExamSubjects) {
		this.onlineExamSubjects = onlineExamSubjects;
	}

	public RecruitmentQuestionsSets getRecruitmentQuestionsSets() {
		return recruitmentQuestionsSets;
	}

	public void setRecruitmentQuestionsSets(RecruitmentQuestionsSets recruitmentQuestionsSets) {
		this.recruitmentQuestionsSets = recruitmentQuestionsSets;
	}

	public Integer getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(Integer totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	
	

}
