package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.SuperUser;

@Repository
public class SuperUserDAOImpl implements SuperUserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveSuperUser(SuperUser superUser) {
		sessionFactory.getCurrentSession().merge(superUser);
		
	}

	@Override
	public List<SuperUser> listUser() {
		return sessionFactory.getCurrentSession().createQuery("from SuperUser").list();
	}

	@Override
	public void removeSuperUser(Integer userId) {
		SuperUser superUser = (SuperUser) sessionFactory.getCurrentSession().load(SuperUser.class, userId);
		if (null != superUser) {
			sessionFactory.getCurrentSession().delete(superUser);
		}
		
	}

	@Override
	public SuperUser getSuperUserById(Integer userId) {
		return (SuperUser) sessionFactory.getCurrentSession().get(SuperUser.class, userId);
	}

	@Override
	public SuperUser getSuperUserByUserName(String userName) {
		Query query = sessionFactory.getCurrentSession().createQuery("from SuperUser WHERE userName = :UserName");
		query.setString("UserName", userName);
		return (SuperUser) query.uniqueResult();
	}

}
