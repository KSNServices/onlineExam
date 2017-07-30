package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlineexam.model.City;

public class CityDAOImpl  implements CityDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCity(City city) {
		sessionFactory.getCurrentSession().merge(city);
		
	}

	@Override
	public List<City> listCity() {
		Query query = sessionFactory.getCurrentSession().createQuery("from City");
		return query.list();
	}

	@Override
	public void removeCity(Integer cityId) {
		City city = (City) sessionFactory.getCurrentSession().load(City.class, cityId);
		if (null != city) {
			sessionFactory.getCurrentSession().delete(city);
		}
		
	}

	@Override
	public City getCityById(Integer cityId) {
		return (City) sessionFactory.getCurrentSession().get(City.class, cityId);
	}

	@Override
	public City getCityByStateId(Integer stateId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from City c where c.state.id=:stateId");
		query.setInteger("stateId", stateId);
		return (City) query.uniqueResult();
	}

}
