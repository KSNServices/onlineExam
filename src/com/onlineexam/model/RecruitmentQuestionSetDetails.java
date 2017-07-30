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
@Table(name="recruitment_question_set_details")
public class RecruitmentQuestionSetDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name="total_questions")
	private Integer totalQuestions;
	
	@Column(name="total_sets")
	private Integer totalSets;
	
	@ManyToOne
	@JoinColumn(name="online_exam_level_id")
	private OnlineExamLevels onlineExamLevels;
	
	@ManyToOne
	@JoinColumn(name="academic_year_id")
	private AcademicYear academicYear;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(Integer totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public Integer getTotalSets() {
		return totalSets;
	}

	public void setTotalSets(Integer totalSets) {
		this.totalSets = totalSets;
	}

	public OnlineExamLevels getOnlineExamLevels() {
		return onlineExamLevels;
	}

	public void setOnlineExamLevels(OnlineExamLevels onlineExamLevels) {
		this.onlineExamLevels = onlineExamLevels;
	}

	public AcademicYear getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}
	
	

}
