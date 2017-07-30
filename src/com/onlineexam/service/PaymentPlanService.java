package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.PaymentPlan;



public interface PaymentPlanService {
	
	public void savePaymentPlan(PaymentPlan plan);
	public List<PaymentPlan> listPaymentPlan();
	public void removePaymentPlan(Integer planId);
	public PaymentPlan getPaymentPlanById(Integer planId);
	
}
