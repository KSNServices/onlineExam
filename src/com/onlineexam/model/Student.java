package com.onlineexam.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="student")
public class Student implements java.io.Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@NotNull
	@Column(name="student_id")
	private String studentId;	

	@Size(max=100)
	@NotNull
	@Column(name="first_name")
	private String firstName;

	@Size(max=100)
	@Column(name="middle_name")
	private String middleName;
	
	@Size(max=100)
	@NotNull
	@Column(name="last_name")
	private String lastName;

	@NotNull
	@Column(name="class")
	private String className;

	@Column(name="class_section")
	private String classSection;
		
	@Column(name="dob")
	private Date dob;

	@Column(name="gender")
	private String gender;
	
	@Column(name="mobile_no")
	private String mobileNumber;

	@Column(name="father_name")
	private String fatherName;

	@Column(name="father_occupation")
	private String fatherOccupation;


	@Column(name="mother_name")
	private String motherName;


	@Column(name="mother_occupation")
	private String motherOccupation;
	

	@Column(name="address")
	private String address;
	

	@Column(name="aadhar_no")
	private String aadharNumber;


	@Column(name="religion")
	private String religion;


	@Column(name="category")
	private String category;

	@Email
	@NotNull
	@Column(name="email_id")
	private String emailId;


	@Column(name="previousclass_percentage")
	private double previousClassPercentage;
	
	@Column(name="enable")
	private boolean enabled;
	
	@Column(name="blood_group")
	private String bloodGroup;
	
	@ManyToOne
	@JoinColumn(name="school_id")
	private User schoolId;
	
	@ManyToOne
	@JoinColumn(name="admin_id")
	private User adminId;
	
	@Column(name="student_image")
	private String studentImage;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name="admission_id")
	private AdmissionFormModel admissionId;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStudentImage() {
		return studentImage;
	}
	public void setStudentImage(String studentImage) {
		this.studentImage = studentImage;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

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
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassSection() {
		return classSection;
	}

	public void setClassSection(String classSection) {
		this.classSection = classSection;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherOccupation() {
		return fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherOccupation() {
		return motherOccupation;
	}

	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
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

	


	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public double getPreviousClassPercentage() {
		return previousClassPercentage;
	}
	public void setPreviousClassPercentage(double previousClassPercentage) {
		this.previousClassPercentage = previousClassPercentage;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public AdmissionFormModel getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(AdmissionFormModel admissionId) {
		this.admissionId = admissionId;
	}



	

	




	
	
}
