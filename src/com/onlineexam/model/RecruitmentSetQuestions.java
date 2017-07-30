package com.onlineexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="recruitment_set_questions")
public class RecruitmentSetQuestions {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="recruitment_questions_sets_id")
	private RecruitmentQuestionsSets recruitmentQuestionsSets;
	
	@ManyToOne
	@JoinColumn(name="recruitment_questions_id")
	private RecruitmentQuestions recruitmentQuestions;
	
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

	public RecruitmentQuestionsSets getRecruitmentQuestionsSets() {
		return recruitmentQuestionsSets;
	}

	public void setRecruitmentQuestionsSets(RecruitmentQuestionsSets recruitmentQuestionsSets) {
		this.recruitmentQuestionsSets = recruitmentQuestionsSets;
	}

	public RecruitmentQuestions getRecruitmentQuestions() {
		return recruitmentQuestions;
	}

	public void setRecruitmentQuestions(RecruitmentQuestions recruitmentQuestions) {
		this.recruitmentQuestions = recruitmentQuestions;
	}
	
	
	
	
	
	
}
