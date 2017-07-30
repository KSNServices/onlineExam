package com.onlineexam.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_plan_details")
public class PaymentPlan implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name="payment_plan_name")
	private String paymentPlanName;
	
	@Column(name="payment_plan_mode")
	private String paymentPlanMode;
	
	@Column(name="validity")
	private Integer validity;
	
	@Column(name="plan_description")
	private String planDescription;
	
	@Column(name="plan_status")
	private boolean enabled;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaymentPlanName() {
		return paymentPlanName;
	}

	public void setPaymentPlanName(String paymentPlanName) {
		this.paymentPlanName = paymentPlanName;
	}

	public String getPaymentPlanMode() {
		return paymentPlanMode;
	}

	public void setPaymentPlanMode(String paymentPlanMode) {
		this.paymentPlanMode = paymentPlanMode;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getValidity() {
		return validity;
	}

	public void setValidity(Integer validity) {
		this.validity = validity;
	}
	
	
	
}
