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
@Table(name="exam_marks")

public class ExamMarks implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name ="student_id")
	private Integer studentId;
	
	@Column(name ="subject")
	private Integer subject;
	
	@Column(name="marks_obtained")
	private String marksObtained;

	@Column(name ="maximum_marks")
	private Integer maximumMarks;
	
	@Column(name ="minimum_marks")
	private Integer minimumMarks;

	@Column(name="term_exam")
	private String termExam;

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

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getSubject() {
		return subject;
	}

	public void setSubject(Integer subject) {
		this.subject = subject;
	}

	public String getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(String marksObtained) {
		this.marksObtained = marksObtained;
	}

	public Integer getMaximumMarks() {
		return maximumMarks;
	}

	public void setMaximumMarks(Integer maximumMarks) {
		this.maximumMarks = maximumMarks;
	}

	public Integer getMinimumMarks() {
		return minimumMarks;
	}

	public void setMinimumMarks(Integer minimumMarks) {
		this.minimumMarks = minimumMarks;
	}

	public String getTermExam() {
		return termExam;
	}

	public void setTermExam(String termExam) {
		this.termExam = termExam;
	}

	

	

}
