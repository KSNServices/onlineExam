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
@Table(name="committee")

public class Committee implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name ="committee_name")
	private Integer committeeName;
	
	@Column(name="committee_member_name")
	private String committeeMemberName;

	@Column(name ="work_assigned")
	private Integer workAssigned;
	
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

	public Integer getCommitteeName() {
		return committeeName;
	}

	public void setCommitteeName(Integer committeeName) {
		this.committeeName = committeeName;
	}

	public String getCommitteeMemberName() {
		return committeeMemberName;
	}

	public void setCommitteeMemberName(String committeeMemberName) {
		this.committeeMemberName = committeeMemberName;
	}

	public Integer getWorkAssigned() {
		return workAssigned;
	}

	public void setWorkAssigned(Integer workAssigned) {
		this.workAssigned = workAssigned;
	}

}
