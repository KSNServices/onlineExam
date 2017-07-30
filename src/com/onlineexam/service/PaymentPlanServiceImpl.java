package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.PaymentPlanDAO;
import com.onlineexam.model.PaymentPlan;

@Service
public class PaymentPlanServiceImpl implements PaymentPlanService{

	@Autowired
	private PaymentPlanDAO paymentPlanServiceDAO;
	
	@Override
	@Transactional
	public void savePaymentPlan(PaymentPlan plan) {
		paymentPlanServiceDAO.savePaymentPlan(plan);
	}

	@Override
	@Transactional
	public List<PaymentPlan> listPaymentPlan() {
		return paymentPlanServiceDAO.listPaymentPlan();
	}

	@Override
	@Transactional
	public void removePaymentPlan(Integer planId) {
		paymentPlanServiceDAO.removePaymentPlan(planId);
	}

	@Override
	@Transactional
	public PaymentPlan getPaymentPlanById(Integer planId) {
		return paymentPlanServiceDAO.getPaymentPlanById(planId);
	}
	
	

}
