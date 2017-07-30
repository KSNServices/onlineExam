package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.Country;
import com.onlineexam.model.OnlineExamLevels;

@Repository
public class OnlineExamLevelDAOImpl implements OnlineExamLevelDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public OnlineExamLevels getOnlineExamLevelById(Integer oeLevelId) {
		return (OnlineExamLevels) sessionFactory.getCurrentSession().get(OnlineExamLevels.class, oeLevelId);
	}

	@Override
	public List<OnlineExamLevels> listOnlineExamLevels() {
		Query query = sessionFactory.getCurrentSession().createQuery("from OnlineExamLevels");
		List<OnlineExamLevels> oeLevelList = query.list(); 
		return oeLevelList;
	}

	@Override
	public void saveOnlineExamLevel(OnlineExamLevels examLevels) {
		sessionFactory.getCurrentSession().merge(examLevels);
	}
	
	

}
