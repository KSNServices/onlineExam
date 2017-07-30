package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.City;

public interface CityDAO {

	public void saveCity(City city);
	public List<City> listCity();
	public void removeCity(Integer cityId);
	public City getCityById(Integer cityId);
	public City getCityByStateId(Integer stateId);
	
}
