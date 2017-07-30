package com.onlineexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fee_structure")

public class FeeStructure implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name="fee_component")
	private String feeComponent;
	
	@Column(name="amount")
	private Double amount;
	
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}


	@Column(name ="class")
	private String className;
	
	@Column(name="class_section")
	private String classSection;

	
	@Column(name="stream")
	private String stream;
	
	@Column(name="count")
	private int count;
	
	

	@Column(name="enable")
	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


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


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFeeComponent() {
		return feeComponent;
	}


	public void setFeeComponent(String feeComponent) {
		this.feeComponent = feeComponent;
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


	public String getStream() {
		return stream;
	}


	public void setStream(String stream) {
		this.stream = stream;
	}


	public Double getAmount() {
		return amount;
	}
	
	



}
