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
@Table(name="users")
public class User implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "user_name")
	@NotEmpty(message = "Username is mandatory")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email_address")
	@NotEmpty(message = "Email address is mandatory")
	@Email(message = "Invlaid email address")
	private String emailAddress;
	
	@Column(name = "first_name")
	@NotEmpty(message = "First name is mandatory")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	@NotEmpty(message = "Last name is mandatory")
	private String lastName;
	
	@Formula("CONCAT(first_name,' ',last_name)")
	private String fullName;
	
	@Column(name = "phone")
	private String phoneNumber;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	
	@Column(name = "fax")
	private Integer fax;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="authority")
	private String authority;
	
	@ManyToOne
	@JoinColumn(name = "admin_user")
	private User adminUser;
	
	@Column(name="user_images")
	private String userImages;
	
	@Column(name="interests")
	private String interests;
	
	@Column(name="about_me")
	private String aboutMe;
	
	@Column(name="user_website")
	private String userWebsite;
	
	@ManyToOne
	@JoinColumn(name = "payment_plan_id")
	private PaymentPlan paymentPlan;
	
	@Column(name="user_number")
	private String userNumber;
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private User parentId;
	
	public User getParentId() {
		return parentId;
	}

	public void setParentId(User parentId) {
		this.parentId = parentId;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public User() {
		super();
	}
	
	public User(User adminUser) {
		super();
		this.adminUser = adminUser;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getFax() {
		return fax;
	}

	public void setFax(Integer fax) {
		this.fax = fax;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public User getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(User adminUser) {
		this.adminUser = adminUser;
	}

	public String getUserImages() {
		return userImages;
	}

	public void setUserImages(String userImages) {
		this.userImages = userImages;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getUserWebsite() {
		return userWebsite;
	}

	public void setUserWebsite(String userWebsite) {
		this.userWebsite = userWebsite;
	}
	
	public PaymentPlan getPaymentPlan() {
		return paymentPlan;
	}

	public void setPaymentPlan(PaymentPlan paymentPlan) {
		this.paymentPlan = paymentPlan;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	
	

}
