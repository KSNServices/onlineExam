package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.City;
import com.onlineexam.model.Country;
import com.onlineexam.model.State;

public interface GlobalMasterDAO {

	public void saveCountry(Country country);
	public List<Country> listCountry();
	public void removeCountry(Integer countryId);
	public Country getCountryById(Integer countryId);
	
	public void saveState(State state);
	public List<State> listState();
	public void removeState(Integer stateId);
	public State getStateById(Integer stateId);
	public State getStateByCountryId(Integer countryId);
	
	public void saveCity(City city);
	public List<City> listCity();
	public void removeCity(Integer cityId);
	public City getCityById(Integer cityId);
	public City getCityByStateId(Integer stateId);
	
}
