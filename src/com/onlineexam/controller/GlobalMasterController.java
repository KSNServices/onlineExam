package com.onlineexam.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineexam.model.City;
import com.onlineexam.model.Country;
import com.onlineexam.model.State;
import com.onlineexam.service.GlobalMasterService;



@Controller
@RequestMapping("/global")
public class GlobalMasterController extends BaseController{
	
	@Autowired
	public GlobalMasterService globalMasterService;

	/**
	 * Methods for country
	 */	
	
	@RequestMapping("/manageCountry")
	public String showManageCountry(Map<String, Object> map,HttpSession session,HttpServletRequest request)throws Exception {
		map.put("country", new Country());
		
		map.put("showDiv", false);
		map.put("countryList", globalMasterService.listCountry());
		 if(request.getParameter("message")!=null){
        	map.put("message", (String)(request.getParameter("message")));
        }
		return "manageCountry";
	}
	
	
	@RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	public String saveCountry(Map<String, Object> map,HttpSession session, @ModelAttribute("country") Country country, @Valid Country cityStateCountryValid,
			BindingResult result)throws Exception {
		if (result.hasErrors()) {
			map.put("country", new Country());
			map.put("showDiv", false);
			map.put("countryList", globalMasterService.listCountry());
			map.put("message", "Fill all mandatory fields.");
			return "manageCountry";
		} 
		else {
			try {				
				if(null == country.getId()){
					globalMasterService.saveCountry(country);
					map.put("message","Country added successfully.");
					return "redirect:/global/manageCountry";
				}
				else{
					globalMasterService.saveCountry(country);
					return "redirect:/global/manageCountry";
				}
			}
			 catch (Exception exp) {
				map.put("dbError", exp.getMessage());
				map.put("country", new Country());
				map.put("showDiv", false);
				map.put("countryList", globalMasterService.listCountry());
				map.put("message", "Cannot add country, Already present.");
				return "manageCountry";
			}
		}		
	}
	
	
	@RequestMapping("/editCountry/{countryId}")
	public String editCountry(Map<String, Object> map,HttpSession session, @PathVariable("countryId") Integer countryId)throws Exception {
		map.put("showDiv", true);
		map.put("country",globalMasterService.getCountryById(countryId));
		map.put("showDiv", true);
		map.put("countryList", globalMasterService.listCountry());
		return "manageCountry";
	}
	
	@RequestMapping("/enableDisableCountry/{countryId}/{enabled}")
	public String enableDisableCountry(Map<String, Object> map, HttpSession session,
			@PathVariable("countryId") Integer countryId, @PathVariable("enabled") boolean enabled)throws Exception {
		
		Country country=globalMasterService.getCountryById(countryId);
		country.setEnabled(enabled);
		if(enabled && country!=null && !(country.getId()>0)){
			globalMasterService.saveCountry(country);
		}else{
			globalMasterService.saveCountry(country);
		}
		String str = "Disabled";
		if (enabled) {
			str = "Enabled";
		}
		map.put("message", "Country [" + country.getCountryName()+ "] is " + str + " Now. ");		
		return "redirect:/global/manageCountry";
	}
	
	/**
	 * Methods for state
	 */	
	
	@RequestMapping("/manageState")
	public String showManageState(Map<String, Object> map,HttpSession session,HttpServletRequest request)throws Exception {
		map.put("state", new State());
		map.put("showDiv", false);
		map.put("countryList", globalMasterService.listCountry());
		map.put("stateList", globalMasterService.listState());
		 if(request.getParameter("message")!=null){
        	map.put("message", (String)(request.getParameter("message")));
        }
		return "manageState";
	}
	
	@RequestMapping(value = "/saveState", method = RequestMethod.POST)
	public String saveState(Map<String, Object> map,HttpSession session, @ModelAttribute("state") State state, @Valid State stateValid,
			BindingResult result)throws Exception {
		if (result.hasErrors()) {
			map.put("state", new State());
			map.put("showDiv", false);
			map.put("countryList", globalMasterService.listCountry());
			map.put("stateList", globalMasterService.listState());
			map.put("message", "Fill all mandatory feilds.");
			return "manageState";
		} 
		else {
			try {				
				if(null == state.getId()){
					globalMasterService.saveState(state);
					map.put("message","State added sucessfully.");
					return "redirect:/global/manageState";
				}
				else{
					globalMasterService.saveState(state);
					return "redirect:/global/manageState";
				}
			}
			 catch (Exception exp) {
				map.put("dbError", exp.getMessage());
				map.put("state", new State());
				map.put("showDiv", false);
				map.put("countryList", globalMasterService.listCountry());
				map.put("stateList", globalMasterService.listState());
				map.put("message", "Cannot add State, Already present.");
				return "manageState";
			}
		}		
	}
	
	
	@RequestMapping("/editState/{stateId}")
	public String editState(Map<String, Object> map,HttpSession session, @PathVariable("stateId") Integer stateId)throws Exception {
		map.put("showDiv", true);
		map.put("state",globalMasterService.getStateById(stateId));
		map.put("showDiv", true);
		map.put("countryList", globalMasterService.listCountry());
		map.put("stateList", globalMasterService.listState());
		return "manageState";
	}
	
	@RequestMapping("/enableDisableState/{stateId}/{enabled}")
	public String enableDisableState(Map<String, Object> map, HttpSession session,
			@PathVariable("stateId") Integer stateId, @PathVariable("enabled") boolean enabled)throws Exception {
		
		State state=globalMasterService.getStateById(stateId);
		state.setEnabled(enabled);
		if(enabled && state!=null && !(state.getId()>0)){
			globalMasterService.saveState(state);
		}else{
			globalMasterService.saveState(state);
		}
		String str = "Disabled";
		if (enabled) {
			str = "Enabled";
		}
		map.put("message", "State [" + state.getStateName()+ "] is " + str + " Now. ");		
		return "redirect:/global/manageState";
	}
	
	
	/**
	 * Methods for city
	 */
	
	@RequestMapping("/manageCity")
	public String showManageCity(Map<String, Object> map,HttpSession session,HttpServletRequest request)throws Exception {
	
		map.put("city", new City());
		map.put("showDiv", false);
		map.put("cityList", globalMasterService.listCity());
		map.put("stateList", globalMasterService.listState());
		map.put("countryList", globalMasterService.listCountry());
		
		
		 if(request.getParameter("message")!=null){
        	map.put("message", (String)(request.getParameter("message")));
        }
		return "manageCity";
	}
	
	@RequestMapping(value = "/saveCity", method = RequestMethod.POST)
	public String saveCity(Map<String, Object> map,HttpSession session, @ModelAttribute("city") City city, @Valid City cityValid,
			BindingResult result)throws Exception {
		if (result.hasErrors()) {
			map.put("city", new City());
			map.put("showDiv", true);
			map.put("cityList", globalMasterService.listCity());
			map.put("stateList", globalMasterService.listState());
			map.put("countryList", globalMasterService.listCountry());
			map.put("message", "Fill all mandatory feilds.");
			return "manageCity";
		} 
		else {
			try {				
				if(null == city.getId()){
					globalMasterService.saveCity(city);
					map.put("message","City added sucessfully.");
					return "redirect:/global/manageCity";
				}
				else{
					globalMasterService.saveCity(city);
					return "redirect:/global/manageCity";
				}
			}
			 catch (Exception exp) {
				map.put("dbError", exp.getMessage());
				map.put("city", new City());
				map.put("showDiv", false);
				map.put("cityList", globalMasterService.listCity());
				map.put("stateList", globalMasterService.listState());
				map.put("countryList", globalMasterService.listCountry());
				map.put("message", "Cannot add City, Already present.");
				return "manageCity";
			}
		}		
	}
	
	
	@RequestMapping("/editCity/{cityId}")
	public String editCity(Map<String, Object> map,HttpSession session, @PathVariable("cityId") Integer cityId)throws Exception {
		map.put("showDiv", true);
		map.put("city",globalMasterService.getCityById(cityId));
		map.put("showDiv", true);
		map.put("cityList", globalMasterService.listCity());
		map.put("stateList", globalMasterService.listState());
		map.put("countryList", globalMasterService.listCountry());
		return "manageCity";
	}
	
	@RequestMapping("/enableDisableCity/{stateId}/{enabled}")
	public String enableDisableCity(Map<String, Object> map, HttpSession session,
			@PathVariable("cityId") Integer cityId, @PathVariable("enabled") boolean enabled)throws Exception {
		
		City city=globalMasterService.getCityById(cityId);
		city.setEnabled(enabled);
		if(enabled && city!=null && !(city.getId()>0)){
			globalMasterService.saveCity(city);
		}else{
			globalMasterService.saveCity(city);
		}
		String str = "Disabled";
		if (enabled) {
			str = "Enabled";
		}
		map.put("message", "City [" + city.getCityName()+ "] is " + str + " Now. ");		
		return "redirect:/global/manageCity";
	}
}
