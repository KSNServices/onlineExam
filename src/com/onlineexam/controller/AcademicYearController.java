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
import com.onlineexam.model.User;
import com.onlineexam.service.AcademicYearService;

@Controller
@RequestMapping("/academicYear")
public class AcademicYearController {
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder)throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "startDate", customDateEditor);
		binder.registerCustomEditor(Date.class, "endDate", customDateEditor);
	}
	
	@Autowired
	private AcademicYearService academicYearService;
	
	@RequestMapping("/manageAcademicYear")
	public String showManageAcademicYear(Map<String, Object> map,HttpSession session,HttpServletRequest request)throws Exception {
		map.put("academicYear", new AcademicYear());
		map.put("showDiv", false);
		map.put("academicYearList",academicYearService.listAcademicYear());
		 if(request.getParameter("message")!=null){
        	map.put("message", (String)(request.getParameter("message")));
        }
		return "manageAcademicYear";
	}
	
	
	@RequestMapping(value = "/saveAcademicYear", method = RequestMethod.POST)
	public String saveAcademicYear(Map<String, Object> map,HttpSession session, @ModelAttribute("academicYear") AcademicYear academicYear, @Valid AcademicYear academicYearValid,
			BindingResult result)throws Exception {
		if (result.hasErrors()) {
			map.put("academicYear", new AcademicYear());
			map.put("showDiv", false);
			map.put("academicYearList",academicYearService.listAcademicYear());
			map.put("message", "Fill all mandatory feilds.");
			return "manageAcademicYear";
		} 
		else {
			try {				
				if(null == academicYear.getId()){
					academicYear.setModifiedBy((User)session.getAttribute("userDetails"));
					academicYearService.saveAcademicYear(academicYear);
					map.put("message","Country added sucessfully.");
					return "redirect:/academicYear/manageAcademicYear";
				}
				else{
					academicYear.setModifiedBy((User)session.getAttribute("userDetails"));
					academicYearService.saveAcademicYear(academicYear);					
					return "redirect:/academicYear/manageAcademicYear";
				}
			}
			 catch (Exception exp) {
				map.put("dbError", exp.getMessage());
				map.put("academicYear", new AcademicYear());
				map.put("showDiv", false);
				map.put("academicYearList",academicYearService.listAcademicYear());
				map.put("message", "Cannot add academic year, Already present.");
				return "manageAcademicYear";
			}
		}		
	}
	
	
	@RequestMapping("/editPaymentPlan/{academicYearId}")
	public String editPaymentPlan(Map<String, Object> map,HttpSession session, @PathVariable("academicYearId") Integer academicYearId)throws Exception {
		map.put("showDiv", true);
		map.put("academicYearList",academicYearService.listAcademicYear());
		map.put("academicYear", academicYearService.getAcademicYearById(academicYearId));
		return "manageAcademicYear";
	}
	
	
	@RequestMapping("/enableDisablePaymentPlan/{paymentPlanId}/{enabled}")
	public String enableDisablePaymentPlan(Map<String, Object> map, HttpSession session,
			@PathVariable("academicYearId") Integer academicYearId, @PathVariable("enabled") boolean enabled)throws Exception {
		
		AcademicYear academicYear=academicYearService.getAcademicYearById(academicYearId);
		academicYear.setEnabled(enabled);
		if(enabled && academicYear!=null && !(academicYear.getId()>0)){
			academicYearService.saveAcademicYear(academicYear);
		}else{
			academicYearService.saveAcademicYear(academicYear);
		}
		String str = "Disabled";
		if (enabled) {
			str = "Enabled";
		}
		map.put("message", academicYear.getYearCode()+ " is " + str + " Now. ");		
		return "redirect:/academicYear/manageAcademicYear";
	}

}
