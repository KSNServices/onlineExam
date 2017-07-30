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
@Table(name="library")
public class Library implements java.io.Serializable{
	
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
	
	@Column(name="student_name")
	private String studentName;

	@Column(name ="class")
	private Integer className;

	@Column(name="section")
	private String section;

	@Column(name ="issued_book_id")
	private Integer issuedBookId;
	
	@Column(name ="issued_book_name")
	private Integer issuedBookName;

	@Column(name="issued_date")
	private String issuedDate;

	@Column(name ="submit_date")
	private Integer submitDate;
	
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

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getClassName() {
		return className;
	}

	public void setClassName(Integer className) {
		this.className = className;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Integer getIssuedBookId() {
		return issuedBookId;
	}

	public void setIssuedBookId(Integer issuedBookId) {
		this.issuedBookId = issuedBookId;
	}

	public Integer getIssuedBookName() {
		return issuedBookName;
	}

	public void setIssuedBookName(Integer issuedBookName) {
		this.issuedBookName = issuedBookName;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Integer getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Integer submitDate) {
		this.submitDate = submitDate;
	}

}
