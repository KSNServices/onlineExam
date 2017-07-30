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
@Table(name="recruitment_questions_sets")
public class RecruitmentQuestionsSets implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name="recruitment_questions_sets_name")
	private String recruitmentQuestionsSetName;
	
	@Column(name="total_questions")
	private Integer totalQuestions;
	
	@ManyToOne
	@JoinColumn(name="recruitment_question_set_details_id")
	private RecruitmentQuestionSetDetails questionSetDetails;
	
	@Column(name="status")
	private boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRecruitmentQuestionsSetName() {
		return recruitmentQuestionsSetName;
	}

	public void setRecruitmentQuestionsSetName(String recruitmentQuestionsSetName) {
		this.recruitmentQuestionsSetName = recruitmentQuestionsSetName;
	}

	public Integer getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(Integer totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public RecruitmentQuestionSetDetails getQuestionSetDetails() {
		return questionSetDetails;
	}

	public void setQuestionSetDetails(RecruitmentQuestionSetDetails questionSetDetails) {
		this.questionSetDetails = questionSetDetails;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
	

}
