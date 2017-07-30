


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
import com.onlineexam.model.ClassSection;
import com.onlineexam.model.FeeStructure;
import com.onlineexam.model.User;
import com.onlineexam.service.AcademicYearService;
import com.onlineexam.service.ClassNameService;
import com.onlineexam.service.ClassSectionService;
import com.onlineexam.service.UserService;

@Controller
@RequestMapping("/classSectionValue")
public class ClassSectionController {
	
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
	private ClassSectionService classSectionService;
	
	@Autowired
	public UserService userService;
	
	@RequestMapping("/showClassSection")
	public String showClassName(Map<String, Object> map,HttpSession session,HttpServletRequest request)throws Exception {

		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		map.put("classSection", new ClassSection());
		map.put("showDiv", false);
		map.put("classNameList",classNameService.listClassName(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		if(request.getParameter("message")!=null){
        	map.put("message", (String)(request.getParameter("message")));
        }
		if(request.getParameter("error")!=null){
			map.put("showDiv", true);
			map.put("error", (String)(request.getParameter("error")));
		}
		return "classSection";
	}
	
	
	@RequestMapping(value = "/saveClassSection", method = RequestMethod.POST)
	public String saveAcademicYear(Map<String, Object> map,HttpSession session, @ModelAttribute("classSection") ClassSection classSection, @Valid ClassSection classSectionValid,
			BindingResult result)throws Exception {
		
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		String  section = classSection.getClassPresent();
		if (result.hasErrors()) {
			map.put("classSection", new ClassSection());
			map.put("showDiv", false);
			map.put("listClassSection",classSectionService.listClassSection(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),section));
			map.put("message", "Fill all mandatory feilds.");
			return "classSection";
		} 
		else {
			try {				
				if(null == classSection.getId()){
					classSection.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
					classSection.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
					ClassSection classSectionValue =  classSectionService.ClassSectionList(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), classSection.getClassPresent(), classSection.getClassSectionValue());
					if(classSectionValue != null)
					{
						
						map.put("error", "This class Section is already Added");
					}
					else if(classSection.getClassPresent().equals("0"))
					{
						map.put("error", "Please select Class");
					}else if(classSection.getClassSectionValue()== null || classSection.getClassSectionValue().equals("") )
					{
						map.put("error", "Please select Class Section");
					}
					else
					{
					classSectionService.saveClassSection(classSection);
					}
					
					return "redirect:/classSectionValue/getClassSectionsList/"+section;
				}
				else{
					if(classSection.getClassPresent().equals("0") )
					{
						map.put("error", "*Please select Class*");
					}else if(classSection.getClassSectionValue()== null || classSection.getClassSectionValue().equals("") )
					{
						map.put("error", "Please select Class Section");
					}
					else
					{
					classSectionService.saveClassSection(classSection);	
					}
					return "redirect:/classSectionValue/getClassSectionsList/"+section;
				}
			}
			 catch (Exception exp) {
				map.put("dbError", exp.getMessage());
				map.put("className", new ClassName());
				map.put("showDiv", false);
				map.put("classNameList",classNameService.listClassName(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
				map.put("message", "Cannot add academic year, Already present.");
				return "classSection";
			}
		}		
	}
	
	
	@RequestMapping("/editClassSection/{classSectionId}")
	public String editPaymentPlan(Map<String, Object> map,HttpSession session, @PathVariable("classSectionId") Integer classSectionId)throws Exception {
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		map.put("showDiv", true);
	 String className =	classSectionService.getClassSectionById(classSectionId).getClassPresent();
		map.put("classNameList",classNameService.listClassName(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		map.put("listClassSection", classSectionService.listClassSection(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), className));
		map.put("classSection", classSectionService.getClassSectionById(classSectionId));
		return "classSection";
	}
	
	
	
	
	@RequestMapping(value = "/getClassSectionsList/{className}")
	public String getClassSectionsList(Map<String, Object> map, HttpSession session, @PathVariable String className,HttpServletRequest request) throws Exception {
		//Student st =   studentFormService.getStudentByStudentId(id);
		ClassSection classSection = new ClassSection();
		
		//Double totalAmount =  feeStructureService.getFeeClass(st.getClassName(), st.getClassSection());
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		
		
		classSection.setClassPresent(className);
		if(request.getParameter("error")!=null){
			map.put("showDiv", true);
			map.put("error", (String)(request.getParameter("error")));
		}
	
		map.put("showDiv", true);
		map.put("classSection", classSection);		
		map.put("classNameList",classNameService.listClassName(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		map.put("listClassSection", classSectionService.listClassSection(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), className));
		return "classSection";
	}
	
	
}
