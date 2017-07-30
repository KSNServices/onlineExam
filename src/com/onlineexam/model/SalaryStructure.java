

package com.onlineexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="salary_structure")

public class SalaryStructure implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name ="teacher_grade")
	private String teacherGrade;
	
	@Column(name="salary_component")
	private String salaryComponent;

	@Column(name="amount")
	private Double amount;
	
	@Column(name="count")
	private int count;
	
	
	@Column(name="enable")
	private boolean enabled;
	
	
	@ManyToOne
	@JoinColumn(name="school_id")
	private User schoolId;
	
	@ManyToOne
	@JoinColumn(name="admin_id")
	private User adminId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeacherGrade() {
		return teacherGrade;
	}

	public void setTeacherGrade(String teacherGrade) {
		this.teacherGrade = teacherGrade;
	}

	public String getSalaryComponent() {
		return salaryComponent;
	}

	public void setSalaryComponent(String salaryComponent) {
		this.salaryComponent = salaryComponent;
	}


	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
	
	
	
	

}
