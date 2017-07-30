package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.Country;
import com.onlineexam.model.PaymentPlan;

@Repository
public class PaymentPlanDAOImpl implements PaymentPlanDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savePaymentPlan(PaymentPlan plan) {
		sessionFactory.getCurrentSession().merge(plan);
	}

	@Override
	public List<PaymentPlan> listPaymentPlan() {
		Query query = sessionFactory.getCurrentSession().createQuery("from PaymentPlan");
		List<PaymentPlan> paymentPlanList = query.list(); 
		return paymentPlanList;
	}

	@Override
	public void removePaymentPlan(Integer planId) {
		PaymentPlan paymentPlan = (PaymentPlan) sessionFactory.getCurrentSession().load(PaymentPlan.class, planId);
		if (null != paymentPlan) {
			sessionFactory.getCurrentSession().delete(paymentPlan);
		}
	}

	@Override
	public PaymentPlan getPaymentPlanById(Integer planId) {
		return (PaymentPlan) sessionFactory.getCurrentSession().get(PaymentPlan.class, planId);
	}

	
}
