package com.onlineexam.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.ExtraActivities;
import com.onlineexam.model.ExtraExpenditure;

@Repository

public class ExtraExpenditureDAOImpl implements ExtraExpenditureDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveExtraExpenditure(ExtraExpenditure extra_expenditure) {
		sessionFactory.getCurrentSession().merge(extra_expenditure);

	}
	
@Override
	public void removeExtraExpenditure(ExtraExpenditure extra_expenditure) {
	ExtraExpenditure id = (ExtraExpenditure) sessionFactory.getCurrentSession().load(ExtraExpenditure.class,
			extra_expenditure);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from  extra_expenditure ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateExtraExpenditure(ExtraExpenditure extra_expenditure) {
		// TODO Auto-generated method stub
		
	}


}



