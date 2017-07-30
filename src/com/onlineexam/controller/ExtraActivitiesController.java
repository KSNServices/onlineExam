package com.onlineexam.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


import javax.servlet.http.HttpSession;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import org.springframework.web.bind.annotation.RequestMapping;
import com.onlineexam.model.ExtraActivities;





@Controller
@RequestMapping("/extraActivities")
public class ExtraActivitiesController {
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder)throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "dob", customDateEditor);
	}
	

	
	@RequestMapping(value ="/extraActi")
	public String admissionForm(Map<String, Object> map,HttpSession session)throws Exception {
		map.put("extraActivities", new ExtraActivities());
		return "extraActivities";
	}
	
	

}