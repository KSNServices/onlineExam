package com.onlineexam.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineexam.model.AdmissionFormModel;
import com.onlineexam.model.ExamSchedule;
import com.onlineexam.model.State;
import com.onlineexam.model.Student;
import com.onlineexam.service.AdmissionFormService;




@Controller
@RequestMapping("/examSchedule")
public class ExamScheduleController {
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder)throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "dob", customDateEditor);
	}
	

	
	@RequestMapping(value ="/examTimeTable")
	public String admissionForm(Map<String, Object> map,HttpSession session)throws Exception {
		map.put("examSchedule", new ExamSchedule());
		return "examSchedule";
	}
	
	

}