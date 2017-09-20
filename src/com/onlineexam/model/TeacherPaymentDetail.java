
package com.onlineexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="teacher_payment_detail")

public class TeacherPaymentDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="teacher_id")
	private Teacher teacherId;
	
	@Column(name="sequence_teacher_id")
	private String sequenceTeacherId;
	
	@Column(name="total_salary")
	private Double totalSalary;
	
	@Column(name="remaining_salary")
	private Double remainingSalary;
	
	@Column(name="paid_salary")
	private Double paidSalary;

	@Column(name="duration")
	private String duration;
	
	@Column(name="start_session")
	private String startSession;
	
	
	@Column(name="teacher_grade")
	private String teacherGrade;
	
	
	@Column(name="salary_month")
	private String salaryMonth;
	
	@Column(name="enable")
	private Boolean enable;
	
	@Column(name="installment_no")
	private Integer installmentNumber;
	

	@Column(name="installment_month")
	private String installmentMonth;
	

	@Column(name="installment_amount")
	private Double installmentAmount;
	
	@Column(name="additional_amount")
	private Double additionalAmount;
	
	@Column(name="Total_amount_month")
	private Double TotalAmountMonth;


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

	public Teacher getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Teacher teacherId) {
		this.teacherId = teacherId;
	}

	public String getSequenceTeacherId() {
		return sequenceTeacherId;
	}

	public void setSequenceTeacherId(String sequenceTeacherId) {
		this.sequenceTeacherId = sequenceTeacherId;
	}

	public Double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(Double totalSalary) {
		this.totalSalary = totalSalary;
	}

	public Double getRemainingSalary() {
		return remainingSalary;
	}

	public void setRemainingSalary(Double remainingSalary) {
		this.remainingSalary = remainingSalary;
	}

	public Double getPaidSalary() {
		return paidSalary;
	}

	public void setPaidSalary(Double paidSalary) {
		this.paidSalary = paidSalary;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStartSession() {
		return startSession;
	}

	public void setStartSession(String startSession) {
		this.startSession = startSession;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Integer getInstallmentNumber() {
		return installmentNumber;
	}

	public void setInstallmentNumber(Integer installmentNumber) {
		this.installmentNumber = installmentNumber;
	}

	public String getInstallmentMonth() {
		return installmentMonth;
	}

	public void setInstallmentMonth(String installmentMonth) {
		this.installmentMonth = installmentMonth;
	}

	public Double getInstallmentAmount() {
		return installmentAmount;
	}

	public void setInstallmentAmount(Double installmentAmount) {
		this.installmentAmount = installmentAmount;
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

	public String getTeacherGrade() {
		return teacherGrade;
	}

	public void setTeacherGrade(String teacherGrade) {
		this.teacherGrade = teacherGrade;
	}

	public String getSalaryMonth() {
		return salaryMonth;
	}

	public void setSalaryMonth(String salaryMonth) {
		this.salaryMonth = salaryMonth;
	}

	public Double getAdditionalAmount() {
		return additionalAmount;
	}

	public void setAdditionalAmount(Double additionalAmount) {
		this.additionalAmount = additionalAmount;
	}
	
	public Double getTotalAmountMonth() {
		return TotalAmountMonth;
	}

	public void setTotalAmountMonth(Double totalAmountMonth) {
		TotalAmountMonth = totalAmountMonth;
	}
	

}
