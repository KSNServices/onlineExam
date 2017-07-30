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
@Table(name="recruitment_question_ans_options")
public class RecruitmentQuestionAnsOptions implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name="option_statement")
	private String optionStatement;
	
	@ManyToOne
	@JoinColumn(name="recruitment_question_id")
	private RecruitmentQuestions recruitmentQuestions;
	
	@Column(name="is_correct_ans")
	private Boolean isCorrectAns;
	
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

	public String getOptionStatement() {
		return optionStatement;
	}

	public void setOptionStatement(String optionStatement) {
		this.optionStatement = optionStatement;
	}

	public RecruitmentQuestions getRecruitmentQuestions() {
		return recruitmentQuestions;
	}

	public void setRecruitmentQuestions(RecruitmentQuestions recruitmentQuestions) {
		this.recruitmentQuestions = recruitmentQuestions;
	}

	public Boolean getIsCorrectAns() {
		return isCorrectAns;
	}

	public void setIsCorrectAns(Boolean isCorrectAns) {
		this.isCorrectAns = isCorrectAns;
	}
	
	
	
}

