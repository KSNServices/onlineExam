package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.Country;
import com.onlineexam.model.RecruitmentMaster;

@Repository
public class RecruitmentMasterDAOImpl implements RecruitmentMasterDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RecruitmentMaster> listRecruitmentMaster() {
		Query query = sessionFactory.getCurrentSession().createQuery("from RecruitmentMaster");
		List<RecruitmentMaster> rmList = query.list(); 
		return rmList;
	}

	@Override
	public void saveRecruitmentMaster(RecruitmentMaster recruitmentMaster) {
		sessionFactory.getCurrentSession().merge(recruitmentMaster);
	}

	@Override
	public RecruitmentMaster getRecruitmentMasterById(Integer rmId) {
		return (RecruitmentMaster) sessionFactory.getCurrentSession().get(RecruitmentMaster.class, rmId);
	}
	
	

}
