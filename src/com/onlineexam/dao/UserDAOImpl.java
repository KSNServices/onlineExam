package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.User;

@Repository
public class UserDAOImpl extends CommonDAOSupport implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User User) {
		sessionFactory.getCurrentSession().merge(User);
	}

	@Override
	public List<User> listUser() {
		User user=getUser();
		Query query = sessionFactory.getCurrentSession().createQuery("from User WHERE adminUser.id = :adminUserId");
		query.setInteger("adminUserId", user.getId());
		return query.list();
	}

	@Override
	public void removeUser(Integer userNo) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, userNo);
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	@Override
	public User getUserById(Integer userNo) {
		return (User) sessionFactory.getCurrentSession().get(User.class, userNo);
	}

	@Override
	public User getUserByUserName(String superUserName) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User WHERE userName = :UserName");
		query.setString("UserName", superUserName);
		return (User) query.uniqueResult();
	}

	@Override
	public List<User> listUser(Integer companyId,String searchString) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.firstName like :name AND company.id = :companyId");
		query.setInteger("companyId", companyId);
		List<User> userList = query.setParameter("name", "%"+searchString + "%").list();
		return userList;
	}

	@Override
	public List<User> listUserByRole(String role) {
		User user=getUser();
		Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.authority like :authority");
	/*	query.setInteger("adminUserId", user.getId());*/
		List<User> userList = query.setParameter("authority", role).list();
		return userList;
	}
	
	@Override
	public String getLastId(String role) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("select max(u.userNumber) from User u where u.authority like :authority");
		query.setParameter("authority",role);
		String s = String.valueOf(query.list().get(0));
		return s;
	}

	@Override
	public String getLastschoolId(String role, int adminId) {
		// TODO Auto-generated method stub
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(User.class);
		ProjectionList pro = Projections.projectionList();
		pro.add(Projections.max("id"));
		cr.add(Restrictions.eq("authority",role));
		cr.add(Restrictions.eq("parentId.id",adminId));
		cr.setProjection(pro);
		Integer number = (Integer)cr.uniqueResult();
		if(number != null )
		{
		User user = (User)sessionFactory.getCurrentSession().get(User.class,number);
		
		
		return user.getUserNumber();
		}else{
			return null;
			
		}
	}
	
}
