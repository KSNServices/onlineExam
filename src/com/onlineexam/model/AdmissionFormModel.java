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
@Table(name="admission_form")
public class AdmissionFormModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name="registration_no")
	private String registrationNo;	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="father_name")
	private String fatherName;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="father_occupation")
	private String fatherOccupation;
	
	@Column(name="mother_name")
	private String motherName;
	
	@Column(name="mother_occupation")
	private String motherOccupation;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="address")
	private String address;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="class")
	private String className;
	
	@Column(name="aadhar_number")
	private String aadharNumber;
	
	@Column(name="religion")
	private String religion;
	
	@Column(name="previousclass_percentage")
	private double previousclassPercentage;
	
	@Column(name="blood_group")
	private String bloodGroup;
	
	@ManyToOne
	@JoinColumn(name="school_id")
	private User schoolId;
	
	@ManyToOne
	@JoinColumn(name="admin_id")
	private User adminId;
	
	@Column(name="admissionStudent_image")
	private String admissionStudentImage;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_confirm")
	private Boolean isConfirm;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdmissionStudentImage() {
		return admissionStudentImage;
	}

	public void setAdmissionStudentImage(String admissionStudentImage) {
		this.admissionStudentImage = admissionStudentImage;
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



	@Column(name="enable")
	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return firstName;
	}

	public void setName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String LastName) {
		this.lastName = LastName;
	}
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public void setFatherOccupation(String FatherOccupation) {
		this.fatherOccupation = FatherOccupation;
	}
	
	

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String MotherName) {
		this.motherName = MotherName;
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

	public void setAddress(String Address) {
		this.address = Address;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
    }
	
	
	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	
	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	

	public String getEmailId() {
		return emailId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}


	public double getPreviousclassPercentage() {
		return previousclassPercentage;
	}

	public void setPreviousclassPercentage(double previousclassPercentage) {
		this.previousclassPercentage = previousclassPercentage;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Boolean getIsConfirm() {
		return isConfirm;
	}

	public void setIsConfirm(Boolean isConfirm) {
		this.isConfirm = isConfirm;
	}
	
}
