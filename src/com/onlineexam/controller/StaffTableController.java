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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineexam.constants.ModelConstants;
import com.onlineexam.model.AdmissionFormModel;
import com.onlineexam.model.StaffTable;
import com.onlineexam.model.State;
import com.onlineexam.model.User;
import com.onlineexam.service.AdmissionFormService;
import com.onlineexam.service.StaffTableService;




@Controller
@RequestMapping("/staff")
public class StaffTableController {
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder)throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "dob", customDateEditor);
	}
	

	@Autowired
	public StaffTableService staffTableService;
	
	@RequestMapping(value ="/staffForm")
	public String admissionForm(Map<String, Object> map,HttpSession session)throws Exception {
		map.put("staffTable", new StaffTable());
		map.put("staffTableList", staffTableService.listStaffTable());
		return "staffForm";
	}
	
	@RequestMapping(value ="/saveStaffForm", method = RequestMethod.POST)
	public String staffFormSave(Map<String, Object> map,HttpSession session, @ModelAttribute("staffTable") StaffTable staffTable, @Valid StaffTable staffTableValid,
			BindingResult result)throws Exception {
		if (result.hasErrors()) {
			map.put("staffTable", new StaffTable());
			map.put("showDiv", false);
			map.put("staffTableList", staffTableService.listStaffTable());

			map.put("message", "Fill all mandatory feilds.");
			return "staffForm";
		} 
		else {
			try {				
				if(null == staffTable.getId()){
					staffTableService.saveStaffTable(staffTable);
					map.put("message","Registration added sucessfully.");
					return "redirect:/staff/staffForm";
				}
				else{
					staffTableService.saveStaffTable(staffTable);
					return "redirect:/staff/staffForm";
				}
			}
			 catch (Exception exp) {
				 exp.printStackTrace();
				map.put("dbError", exp.getMessage());
				map.put("state", new State());
				map.put("showDiv", false);
				map.put("staffTableList", staffTableService.listStaffTable());
				map.put("admissionFormModel", new AdmissionFormModel());
				map.put("message", "Cannot add Registartion, Already present.");
				return "staffForm";
			}
		}		
		
	}
	

	


}
