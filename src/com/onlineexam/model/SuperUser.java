package com.onlineexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class SuperUser implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "company_name")
	@NotEmpty(message = "Username is mandatory")
	private String companyName;
	
	@Column(name = "user_name")
	@NotEmpty(message = "Username is mandatory")
	private String userName;
	
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
	
	@Column(name = "phone")
	private String phoneNumber;
	
	@Column(name = "fax")
	private Integer fax;
	
	@Column(name = "team_size")
	@NotNull(message = "Team Size is mandatory")
	private Integer teamSize;
	
	@Column(name = "reference_from")
	private String referenceFrom;
	
	@Column(name = "logo_path")
	private String logoPath;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="authority")
	private String authority;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public Integer getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}
	public String getReferenceFrom() {
		return referenceFrom;
	}
	public void setReferenceFrom(String referenceFrom) {
		this.referenceFrom = referenceFrom;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
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
}
