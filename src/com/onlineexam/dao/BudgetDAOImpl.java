package com.onlineexam.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.dao.BudgetDAO;
import com.onlineexam.model.Budget;

@Repository

public class BudgetDAOImpl implements BudgetDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveBudget(Budget budget) {
		sessionFactory.getCurrentSession().merge(budget);

	}
	
@Override
	public void removeBudget(Budget budget) {
		Budget id = (Budget) sessionFactory.getCurrentSession().load(Budget.class,
				budget);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from budget ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateBudjet(Budget budget) {
		// TODO Auto-generated method stub
		
	}


}
