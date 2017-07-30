package com.onlineexam.model;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher implements java.io.Serializable{

	

	/**
	 * alter table teacher  modify column id int not null auto_increment;
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name ="teacher_id")
	private String teacherId;
	
	@Column(name="teacher_name")
	private String teacherName;
	
	@Column(name ="class_alloted")
	private String classAlloted;
	
	@Column(name="mobile_number")
	private Integer mobileNumber;
	
	@Column(name ="aadhar_no")
	private Integer aadharNumber;
	
	@Column(name="subject_preference")
	private String subjectPreference;
	
	@Column(name ="category")
	private String category;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name ="gender")
	private String gender;
	
	@Column(name="address")
	private String address;
	
	@Column(name ="dob")
	private Date dob;
	
	@Column(name="enable")
	private boolean enabled;
	
	
	@Column(name="teacher_image")
	private String teacherImage;
	
	public String getTeacherImage() {
		return teacherImage;
	}

	public void setTeacherImage(String teacherImage) {
		this.teacherImage = teacherImage;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name="max_qualification")
	private String maximumQualification;
	
	@Column(name ="teaching_experience")
	private String teachingExperience;
	
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



	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassAlloted() {
		return classAlloted;
	}

	public void setClassAlloted(String classAlloted) {
		this.classAlloted = classAlloted;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(Integer aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getSubjectPreference() {
		return subjectPreference;
	}

	public void setSubjectPreference(String subjectPreference) {
		this.subjectPreference = subjectPreference;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMaximumQualification() {
		return maximumQualification;
	}

	public void setMaximumQualification(String maximumQualification) {
		this.maximumQualification = maximumQualification;
	}

	public String getTeachingExperience() {
		return teachingExperience;
	}

	public void setTeachingExperience(String teachingExperience) {
		this.teachingExperience = teachingExperience;
	}

	
	
	
}
