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
@Table(name="applicantion_form")
public class ApplicationForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="institution_choice_id")
	private Institute institutionChoice;
		
	@ManyToOne
	@JoinColumn(name="exam_center_id")
	private Institute examCenter;
	
	@ManyToOne
	@JoinColumn(name="recruitment_master_id")
	private RecruitmentMaster recruitmentMaster;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="father_name")
	private String fatherName;
	
	@Column(name="mother_name")
	private String motherName;
	
	@Column(name="dob")
	private Date dateofBirth;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="emailId")
	private String email;
	
	@Column(name="gender")
	private String gender;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Categories categories;
	
	@Column(name="blood_group")
	private String blood_group;
		
	@Column(name="marital_status")
	private String maritalStatus;
		
	@Column(name="user_image")
	private String userImage;
	
	@Column(name="enrolment_number")
	private String enrolmentNumber;
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

	public Institute getInstitutionChoice() {
		return institutionChoice;
	}

	public void setInstitutionChoice(Institute institutionChoice) {
		this.institutionChoice = institutionChoice;
	}

	public Institute getExamCenter() {
		return examCenter;
	}

	public void setExamCenter(Institute examCenter) {
		this.examCenter = examCenter;
	}

	public RecruitmentMaster getRecruitmentMaster() {
		return recruitmentMaster;
	}

	public void setRecruitmentMaster(RecruitmentMaster recruitmentMaster) {
		this.recruitmentMaster = recruitmentMaster;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getEnrolmentNumber() {
		return enrolmentNumber;
	}

	public void setEnrolmentNumber(String enrolmentNumber) {
		this.enrolmentNumber = enrolmentNumber;
	}
	
	

}
