package com.onlineexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_fee_detail")

public class StudentFeeDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student studentId;
	
	@Column(name="sequence_student_id")
	private String sequenceStudentId;
	
	
	@Column(name="total_fee")
	private Double totalFee;

	
	@Column(name="concession")
	private Double concession;
	
	@Column(name="paid_by_student")
	private Double paidByStudent;
	
	@Column(name="remaining_fee")
	private Double remainingFee;
	
	@Column(name="paid_fee")
	private Double paidFee;

	@Column(name="duration")
	private String duration;
	
	@Column(name="start_session")
	private String startSession;

	@Column(name="reason_concession")
	private String reasonConcession;
	

	@Column(name="type_concession")
	private String typeConcession;
	
	@Column(name="enable")
	private Boolean enable;
	
	@Column(name="installment_no")
	private Integer installmentNumber;
	

	@Column(name="installment_month")
	private String installmentMonth;
	

	@Column(name="installment_amount")
	private Double installmentAmount;

	@ManyToOne
	@JoinColumn(name="school_id")
	private User schoolId;
	
	@ManyToOne
	@JoinColumn(name="admin_id")
	private User adminId;
	
	
	
	public Integer getInstallmentNumber() {
		return installmentNumber;
	}

	public void setInstallmentNumber(Integer installmentNumber) {
		this.installmentNumber = installmentNumber;
	}
	
	public String getStartSession() {
		return startSession;
	}

	public void setStartSession(String startSession) {
		this.startSession = startSession;
	}

	public String getSequenceStudentId() {
		return sequenceStudentId;
	}

	public void setSequenceStudentId(String sequenceStudentId) {
		this.sequenceStudentId = sequenceStudentId;
	}

	
	public User getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(User schoolId) {
		this.schoolId = schoolId;
	}

	public String getReasonConcession() {
		return reasonConcession;
	}

	public void setReasonConcession(String reasonConcession) {
		this.reasonConcession = reasonConcession;
	}

	public String getTypeConcession() {
		return typeConcession;
	}

	public void setTypeConcession(String typeConcession) {
		this.typeConcession = typeConcession;
	}

	public User getAdminId() {
		return adminId;
	}

	public void setAdminId(User adminId) {
		this.adminId = adminId;
	}

	public Double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	
	public void setPaidByStudent(Double paidByStudent) {
		this.paidByStudent = paidByStudent;
	}

	public void setRemainingFee(Double remainingFee) {
		this.remainingFee = remainingFee;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	

	public Double getPaidByStudent() {
		return paidByStudent;
	}

	public Double getRemainingFee() {
		return remainingFee;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}





	public Double getConcession() {
		return concession;
	}

	public void setConcession(Double concession) {
		this.concession = concession;
	}

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
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

	public Double getPaidFee() {
		return paidFee;
	}

	public void setPaidFee(Double paidFee) {
		this.paidFee = paidFee;
	}


	

	

}
