package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.GlobalMasterDAO;
import com.onlineexam.model.City;
import com.onlineexam.model.Country;
import com.onlineexam.model.State;

@Service
public class GlobalMasterServiceImpl implements GlobalMasterService{

	@Autowired
	private GlobalMasterDAO globalMasterDAO;
	
	
	@Override
	@Transactional
	public void saveCountry(Country country) {
		globalMasterDAO.saveCountry(country);
		
	}

	@Override
	@Transactional
	public List<Country> listCountry() {		
		return globalMasterDAO.listCountry();
	}

	@Override
	@Transactional
	public void removeCountry(Integer countryId) {
		globalMasterDAO.removeCountry(countryId);
		
	}

	@Override
	@Transactional
	public Country getCountryById(Integer countryId) {
		
		return globalMasterDAO.getCountryById(countryId);
	}

	@Override
	@Transactional
	public void saveState(State state) {
		globalMasterDAO.saveState(state);
		
	}

	@Override
	@Transactional
	public List<State> listState() {
		
		return globalMasterDAO.listState();
	}

	@Override
	@Transactional
	public void removeState(Integer stateId) {
		globalMasterDAO.removeState(stateId);
		
	}

	@Override
	@Transactional
	public State getStateById(Integer stateId) {
		
		return globalMasterDAO.getStateById(stateId);
	}

	@Override
	@Transactional
	public State getStateByCountryId(Integer countryId) {
		
		return globalMasterDAO.getStateByCountryId(countryId);
	}

	@Override
	@Transactional
	public void saveCity(City city) {
		
		globalMasterDAO.saveCity(city);
	}

	@Override
	@Transactional
	public List<City> listCity() {
		
		return globalMasterDAO.listCity();
	}

	@Override
	@Transactional
	public void removeCity(Integer cityId) {
		
		globalMasterDAO.removeCity(cityId);
	}

	@Override
	@Transactional
	public City getCityById(Integer cityId) {
		
		return globalMasterDAO.getCityById(cityId);
	}

	@Override
	@Transactional
	public City getCityByStateId(Integer stateId) {
		
		return globalMasterDAO.getCityByStateId(stateId);
	}

}
