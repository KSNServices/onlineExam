package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.City;
import com.onlineexam.model.Country;
import com.onlineexam.model.State;

@Repository
public class GlobalMasterDAOImpl implements GlobalMasterDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCountry(Country country) {
		sessionFactory.getCurrentSession().merge(country);
		
	}

	@Override
	public List<Country> listCountry() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Country");
		List<Country> countryList = query.list(); 
		return countryList;
	}

	@Override
	public void removeCountry(Integer countryId) {
		Country country = (Country) sessionFactory.getCurrentSession().load(Country.class, countryId);
		if (null != country) {
			sessionFactory.getCurrentSession().delete(country);
		}
		
	}

	@Override
	public Country getCountryById(Integer countryId) {
		return (Country) sessionFactory.getCurrentSession().get(Country.class, countryId);
	}

	
	
	@Override
	public void saveState(State state) {
		sessionFactory.getCurrentSession().merge(state);
		
	}

	@Override
	public List<State> listState() {
		Query query = sessionFactory.getCurrentSession().createQuery("from State");
		return query.list();
	}

	@Override
	public void removeState(Integer stateId) {
		State state = (State) sessionFactory.getCurrentSession().load(State.class, stateId);
		if (null != state) {
			sessionFactory.getCurrentSession().delete(state);
		}
		
	}

	@Override
	public State getStateById(Integer stateId) {
		return (State) sessionFactory.getCurrentSession().get(State.class, stateId);
	}

	@Override
	public State getStateByCountryId(Integer countryId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from State s where s.country.id=:countryId");
		query.setInteger("countryId", countryId);
		return (State) query.uniqueResult();
	}

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
