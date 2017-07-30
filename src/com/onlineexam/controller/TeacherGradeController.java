




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
import com.onlineexam.model.FeeStructure;
import com.onlineexam.model.TeacherGrade;
import com.onlineexam.model.User;
import com.onlineexam.service.AcademicYearService;
import com.onlineexam.service.ClassNameService;
import com.onlineexam.service.TeacherGradeService;
import com.onlineexam.service.UserService;

@Controller
@RequestMapping("/teacherGrade")
public class TeacherGradeController {
	
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public TeacherGradeService teacherGradeService;
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder)throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "startDate", customDateEditor);
		binder.registerCustomEditor(Date.class, "endDate", customDateEditor);
	}
	

	

	
	@RequestMapping("/showTeacherGrade")
	public String showClassName(Map<String, Object> map,HttpSession session,HttpServletRequest request)throws Exception {

		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		map.put("teacherGrade", new TeacherGrade());
		map.put("showDiv", false);
		map.put("teacherGradeList",teacherGradeService.listTeacherGrade(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		
		 if(request.getParameter("message")!=null){
				map.put("message", (String)(request.getParameter("message")));
			}
			if(request.getParameter("error")!=null){
				map.put("showDiv", true);
				map.put("error", (String)(request.getParameter("error")));
			}

		return "teacherGrade";
	}
	
	
	@RequestMapping(value = "/saveTeacherGrade", method = RequestMethod.POST)
	public String saveTeacherGrade(Map<String, Object> map,HttpSession session, @ModelAttribute("teacherGrade") TeacherGrade teacherGrade, @Valid TeacherGrade classNameValid,
			BindingResult result,HttpServletRequest request)throws Exception {
		
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		if (result.hasErrors()) {
			map.put("teacherGrade", new TeacherGrade());
			map.put("showDiv", false);
			map.put("teacherGradeList",teacherGradeService.listTeacherGrade(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
			map.put("message", "Fill all mandatory feilds.");
			return "teacherGrade";
		} 
		else {
			try {				
				if(null == teacherGrade.getId()){
					teacherGrade.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
					teacherGrade.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
					//classNameService.saveClassName(className);
					TeacherGrade teacherGradeValue = teacherGradeService.listTeacherGradePresent(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString) ,teacherGrade.getTeacherGradeValue());
					
					if(teacherGradeValue != null)
					{
						map.put("error", "This class is already Added");
					}
					else if(teacherGrade.getTeacherGradeValue()== null || teacherGrade.getTeacherGradeValue().equals("") )
					{
						map.put("error", "Please Add Teacher Grade ");
					}else if(teacherGrade.getGradePay()== null || teacherGrade.getGradePay().equals(0.00) )
					{
						map.put("error", "Please Add Grade pay");
					}
					else
					{
						teacherGradeService.saveTeacherGrade(teacherGrade);
					}
					return "redirect:/teacherGrade/showTeacherGrade";
				}
				else{
					TeacherGrade teacherGradeValue = teacherGradeService.listTeacherGradePresent(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString) ,teacherGrade.getTeacherGradeValue());
					 if(teacherGrade.getTeacherGradeValue()== null || teacherGrade.getTeacherGradeValue().equals("") )
					{
						map.put("error", "Please Add Teacher Grade ");
					}else if(teacherGrade.getGradePay()== null || teacherGrade.getGradePay().equals(0.00) )
					{
						map.put("error", "Please Add Grade pay");
					}
					else
					{
						teacherGradeService.saveTeacherGrade(teacherGrade);
					}
					return "redirect:/teacherGrade/showTeacherGrade";
				
				}
			}
			 catch (Exception exp) {
				map.put("dbError", exp.getMessage());
				map.put("teacherGrade", new TeacherGrade());
				map.put("showDiv", false);
				map.put("teacherGradeList",teacherGradeService.listTeacherGrade(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
				map.put("message", "Cannot add Teacher Grade, Already present.");
				return "teacherGrade";
			}
		}		
	}
	
	
	@RequestMapping("/editTeacherGrade/{teacherGradeId}")
	public String editTeacherGrade(Map<String, Object> map,HttpSession session, @PathVariable("teacherGradeId") Integer teacherGradeId)throws Exception {
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		map.put("showDiv", true);
		map.put("teacherGradeList",teacherGradeService.listTeacherGrade(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		map.put("teacherGrade", teacherGradeService.getTeacherGradeById(teacherGradeId));
		return "teacherGrade";
	}
	
	
	@RequestMapping("/enableDisableTeacherGrade/{teacherGradeId}/{enabled}")
	public String enableDisableTeacherGrade(Map<String, Object> map, HttpSession session,
			@PathVariable("teacherGradeId") Integer teacherGradeId, @PathVariable("enabled") boolean enabled)throws Exception {
		
		TeacherGrade teacherGrade=teacherGradeService.getTeacherGradeById(teacherGradeId);
		teacherGrade.setEnabled(enabled);
		if(enabled && teacherGrade!=null && !(teacherGrade.getId()>0)){
			teacherGradeService.saveTeacherGrade(teacherGrade);
		}else{
			teacherGradeService.saveTeacherGrade(teacherGrade);
		}
		String str = "Disabled";
		if (enabled) {
			str = "Enabled";
		}
			
		return "redirect:/teacherGrade/showTeacherGrade";
	}
	
	
	@RequestMapping("/deleteTeacherGrade/{teacherGradeId}")
	public String deleteUser(Map<String, Object> map,HttpSession session, @PathVariable("teacherGradeId") Integer teacherGradeId) {
		map.put("showDiv", true);
		//FeeStructure feeStructure = new FeeStructure();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		TeacherGrade teacherGrade=teacherGradeService.getTeacherGradeById(teacherGradeId);
		teacherGradeService.removeTeacherGrade(teacherGrade);
		map.put("teacherGradeList",teacherGradeService.listTeacherGrade(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		
		
		
		return "redirect:/teacherGrade/showTeacherGrade";
	}

}
