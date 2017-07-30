


package com.onlineexam.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineexam.model.AcademicYear;
import com.onlineexam.model.ClassName;
import com.onlineexam.model.User;
import com.onlineexam.service.AcademicYearService;
import com.onlineexam.service.ClassNameService;
import com.onlineexam.service.UserService;

@Controller
@RequestMapping("/className")
public class ClassNameController {
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder)throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "startDate", customDateEditor);
		binder.registerCustomEditor(Date.class, "endDate", customDateEditor);
	}
	
	@Autowired
	private ClassNameService classNameService;
	
	@Autowired
	public UserService userService;
	
	@RequestMapping("/showClassName")
	public String showClassName(Map<String, Object> map,HttpSession session,HttpServletRequest request)throws Exception {

		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		map.put("className", new ClassName());
		map.put("showDiv", false);
		map.put("classNameList",classNameService.listClassName(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		
		 if(request.getParameter("message")!=null){
				map.put("message", (String)(request.getParameter("message")));
			}
			if(request.getParameter("error")!=null){
				map.put("showDiv", true);
				map.put("error", (String)(request.getParameter("error")));
			}

		return "className";
	}
	
	
	@RequestMapping(value = "/saveClassName", method = RequestMethod.POST)
	public String saveClassName(Map<String, Object> map,HttpSession session, @ModelAttribute("className") ClassName className, @Valid ClassName classNameValid,
			BindingResult result,HttpServletRequest request)throws Exception {
		
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		if (result.hasErrors()) {
			map.put("className", new ClassName());
			map.put("showDiv", false);
			map.put("classNameList",classNameService.listClassName(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
			map.put("message", "Fill all mandatory feilds.");
			return "className";
		} 
		else {
			try {				
				if(null == className.getId()){
					className.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
					className.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
					//classNameService.saveClassName(className);
					ClassName classNamePresent =	classNameService.listClassNamePresent(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString) ,className.getClassPresent());
					if(classNamePresent != null)
					{
						map.put("error", "This class is already Added");
					}
					else if(className.getClassPresent()== null || className.getClassPresent().equals("") )
					{
						map.put("error", "Please Add Class ");
					}else if(className.getClassNameValue()== null || className.getClassNameValue().equals("") )
					{
						map.put("error", "Please Add Class Name");
					}
					else
					{
						classNameService.saveClassName(className);
					}
					return "redirect:/className/showClassName";
				}
				else{
					ClassName classNamePresent =	classNameService.listClassNamePresent(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString) ,className.getClassPresent());
					if(classNamePresent != null)
					{
						map.put("error", "This class is already Added");
					}
					else if(className.getClassPresent()== null || className.getClassPresent().equals("") )
						{
							map.put("error", "Please Add Class ");
						}else if(className.getClassNameValue()== null || className.getClassNameValue().equals("") )
						{
							map.put("error", "Please Add Class Name");
						}
						else
						{
							classNameService.saveClassName(className);	
						}
					return "redirect:/className/showClassName";
				}
			}
			 catch (Exception exp) {
				map.put("dbError", exp.getMessage());
				map.put("className", new ClassName());
				map.put("showDiv", false);
				map.put("classNameList",classNameService.listClassName(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
				map.put("message", "Cannot add academic year, Already present.");
				return "className";
			}
		}		
	}
	
	
	@RequestMapping("/editClassName/{classNameId}")
	public String editPaymentPlan(Map<String, Object> map,HttpSession session, @PathVariable("classNameId") Integer classNameId)throws Exception {
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		map.put("showDiv", true);
		map.put("classNameList",classNameService.listClassName(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		map.put("className", classNameService.getClassNameById(classNameId));
		return "className";
	}
	
	
	@RequestMapping("/enableDisableClassName/{classNameId}/{enabled}")
	public String enableDisablePaymentPlan(Map<String, Object> map, HttpSession session,
			@PathVariable("classNameId") Integer classNameId, @PathVariable("enabled") boolean enabled)throws Exception {
		
		ClassName className=classNameService.getClassNameById(classNameId);
		className.setEnabled(enabled);
		if(enabled && className!=null && !(className.getId()>0)){
			classNameService.saveClassName(className);
		}else{
			classNameService.saveClassName(className);
		}
		String str = "Disabled";
		if (enabled) {
			str = "Enabled";
		}
			
		return "redirect:/className/showClassName";
	}

}
