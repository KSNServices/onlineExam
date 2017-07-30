package com.onlineexam.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineexam.model.ApplicationForm;
import com.onlineexam.service.ApplicationFormService;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {
	
	@Autowired
	private ApplicationFormService applicationFormService;
	
	@RequestMapping("/manageApplicant")
	public String manageApplicant(Map<String, Object> map,HttpSession session,HttpServletRequest request)throws Exception {
		map.put("applicantForm", new ApplicationForm());
		map.put("showDiv", false);
		/*map.put("applicantList",applicationFormService.listApplicant());*/
		 if(request.getParameter("message")!=null){
        	map.put("message", (String)(request.getParameter("message")));
        }
		return "manageApplicant";
	}

}
