package com.onlineexam.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.onlineexam.model.AdditionalSalaryComponent;
import com.onlineexam.model.AdmissionFormModel;
import com.onlineexam.model.FeeStructure;
import com.onlineexam.model.SalaryStructure;
import com.onlineexam.model.Student;
import com.onlineexam.model.StudentFeeDetail;
import com.onlineexam.model.Teacher;
import com.onlineexam.model.User;
import com.onlineexam.service.AdditionalSalaryComponentService;
import com.onlineexam.service.ClassNameService;
import com.onlineexam.service.ClassSectionService;
import com.onlineexam.service.FeeStructureService;
import com.onlineexam.service.SalaryStructureService;
import com.onlineexam.service.TeacherFormService;
import com.onlineexam.service.TeacherGradeService;
import com.onlineexam.service.UserService;

@Controller
@RequestMapping("/additionalSalary")
public class AdditionalSalaryComponentController {
	
	@Autowired
	public UserService userService;

	@Autowired
	public AdditionalSalaryComponentService additionalSalaryComponentService;
	

	@Autowired
	public TeacherFormService teacherFormService;
	
	@Autowired
	public TeacherGradeService teacherGradeService;
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "dob", customDateEditor);
	}

	@RequestMapping(value = "/additionalSalaryDetails")
	public String additionalSalaryStructure(Map<String, Object> map, HttpSession session,HttpServletRequest request) throws Exception {
		AdditionalSalaryComponent additionalSalaryComponent = new AdditionalSalaryComponent();
		map.put("additionalSalaryComponent", new AdditionalSalaryComponent());
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		
		additionalSalaryComponent.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
		additionalSalaryComponent.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
		map.put("additionalSalaryComponent", additionalSalaryComponent);
		//map.put("listFeeStructure", feeStructureService.listFeeStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		
		if(request.getParameter("message")!=null){
			map.put("message", (String)(request.getParameter("message")));
		}
		if(request.getParameter("error")!=null){
			map.put("showDiv", true);
			map.put("error", (String)(request.getParameter("error")));
		
		}
		
		return "additionalSalaryComponent";
	}

	@RequestMapping(value = "/saveAdditionalSalaryStructure", method = RequestMethod.POST)
	public String saveAdditionalSalaryStructure(Map<String, Object> map, HttpSession session,
			@ModelAttribute("additionalSalaryComponent") AdditionalSalaryComponent additionalSalaryComponent, @Valid AdditionalSalaryComponent additionalSalaryComponentValid, BindingResult result, @RequestParam("feeAmountValue") String feeAmountValue)
					throws Exception {
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		

		if (result.hasErrors()) {
			map.put("additionalSalaryComponent", new AdditionalSalaryComponent());
			map.put("showDiv", false);
			map.put("listAdditionalSalaryStructure", additionalSalaryComponentService.listAdditionalSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),additionalSalaryComponent.getTeacherIdValue()));
			map.put("message", "Fill all mandatory feilds.");
			return "additionalSalaryComponent";
		} else {
			try {
				if (null == additionalSalaryComponent.getId()) {
					int count = additionalSalaryComponent.getCount();
					if(additionalSalaryComponent.getTeacherIdValue().equals("0")||additionalSalaryComponent.getTeacherIdValue().equals(""))
					{
						map.put("message", "Please Add Teacher Grade");
					}
					else
					{
					String[] parts = feeAmountValue.split("#");
					if(count== 0 && !feeAmountValue.equals("")) 
					{
						String[] feeDis = feeAmountValue.split("/");
						additionalSalaryComponent.setSalaryComponent(feeDis[0]);
						additionalSalaryComponent.setAmount( Double.parseDouble( feeDis[1]));
						additionalSalaryComponent.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
						additionalSalaryComponent.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
						
						additionalSalaryComponentService.saveAdditionalSalary(additionalSalaryComponent);
					}
					for(int i=0 ;i<count; i++)
					{
						String[] feeDis = parts[i].split("/");
						additionalSalaryComponent.setSalaryComponent(feeDis[0]);
						additionalSalaryComponent.setAmount( Double.parseDouble( feeDis[1]));
						additionalSalaryComponent.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
						additionalSalaryComponent.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
						additionalSalaryComponentService.saveAdditionalSalary(additionalSalaryComponent);
					}
					
					map.put("message", "FeeStructure added sucessfully.");
					}
					return "redirect:/additionalSalary/getAdditionalTeacherFeesList/"+additionalSalaryComponent.getTeacherIdValue();
				} else {
					
					if(additionalSalaryComponent.getTeacherIdValue().equals("0")||additionalSalaryComponent.getTeacherIdValue().equals(""))
					{
						map.put("message", "Please Add Teacher Grade");
					}
					else
					{
					
					int count = additionalSalaryComponent.getCount();
					if(feeAmountValue == null|| feeAmountValue.isEmpty()){
						additionalSalaryComponent.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
						additionalSalaryComponent.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
						additionalSalaryComponentService.saveAdditionalSalary(additionalSalaryComponent);
						
					}
					else
					{
					String[] parts = feeAmountValue.split("#");
					for(int i=0 ;i<count; i++)
					{
						if(i==0 ){
							additionalSalaryComponent.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
							additionalSalaryComponent.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
							additionalSalaryComponentService.saveAdditionalSalary(additionalSalaryComponent);
						}
						else
						{
							additionalSalaryComponent.setId(null);
						String[] feeDis = parts[i].split("/");
						additionalSalaryComponent.setSalaryComponent(feeDis[0]);
						additionalSalaryComponent.setAmount( Double.parseDouble( feeDis[1]));
						additionalSalaryComponent.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
						additionalSalaryComponent.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
						additionalSalaryComponentService.saveAdditionalSalary(additionalSalaryComponent);
						}
					}
					}
					map.put("message", "Salary Structure added sucessfully.");
					}
					return "redirect:/additionalSalary/getAdditionalTeacherFeesList/"+additionalSalaryComponent.getTeacherIdValue();
				}
			} catch (Exception exp) {
				exp.printStackTrace();
				map.put("dbError", exp.getMessage());
				map.put("additionalSalaryComponent", new AdditionalSalaryComponent());
				map.put("showDiv", false);
				map.put("listAdditionalSalaryStructure", additionalSalaryComponentService.listAdditionalSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),additionalSalaryComponent.getTeacherIdValue()));
				
				map.put("message", "Cannot add Salary Strucure, Already present.");
				return "additionalSalaryComponent";
			}
		}

	}
	
/*	@RequestMapping("/getclassSectionList/{id}")
	public String getclassSectionList(Map<String, Object> map, HttpSession session, @PathVariable("id") String id,
			HttpServletResponse response) throws Exception {
		SalaryStructure salaryStructure = new SalaryStructure();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		salaryStructure.setTeacherGrade(id);
		map.put("showDiv", true);
		map.put("salaryStructure", salaryStructure);	
		map.put("listSalaryStructure", salaryStructureService.listSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),salaryStructure.getTeacherGrade()));
		return "salaryStructure";
	}
	*/

	@RequestMapping(value = "/getAdditionalTeacherFeesList/{id}")
	public String getAdditionalTeacherFeesList(Map<String, Object> map, HttpSession session, @PathVariable String id,HttpServletRequest request ) throws Exception {
		AdditionalSalaryComponent additionalSalaryComponent = new AdditionalSalaryComponent();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		if(teacherFormService.getTeacherByTeacherId(id)!=null)
		{
		additionalSalaryComponent.setTeacherIdValue(id);
		additionalSalaryComponent.setTeacherName(teacherFormService.getTeacherByTeacherId(id).getTeacherName());
	
		map.put("showDiv", true);
		map.put("additionalSalaryComponent", additionalSalaryComponent);		
		map.put("listAdditionalSalaryStructure", additionalSalaryComponentService.listAdditionalSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),additionalSalaryComponent.getTeacherIdValue()));
		}
		if(request.getParameter("message")!=null){
			map.put("message", (String)(request.getParameter("message")));
		}
		if(request.getParameter("error")!=null){
			map.put("showDiv", true);
			map.put("error", (String)(request.getParameter("error")));
		
		}
		
		return "additionalSalaryComponent";
	}
	
	
	

	
	
	
	
	@RequestMapping("/editSalaryComponent/{feeId}")
	public String editSalaryComponent(Map<String, Object> map,HttpSession session, @PathVariable("feeId") Integer feeId) {
		map.put("showDiv", true);
		//FeeStructure feeStructure = new FeeStructure();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		map.put("additionalSalaryComponent", additionalSalaryComponentService.getAdditionalSalaryById(feeId));
	
		//map.put("feeStructure", feeStructure);
		String teacherId =additionalSalaryComponentService.getAdditionalSalaryById(feeId).getTeacherIdValue();
		map.put("listSalaryStructure", additionalSalaryComponentService.listAdditionalSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),teacherId));
	
		
		return "additionalSalaryComponent";
	}
	
	@RequestMapping("/deleteFeeComponent/{feeId}")
	public String deleteUser(Map<String, Object> map,HttpSession session, @PathVariable("feeId") Integer feeId) {
		map.put("showDiv", true);
		//FeeStructure feeStructure = new FeeStructure();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		String teacherId =additionalSalaryComponentService.getAdditionalSalaryById(feeId).getTeacherIdValue();
		additionalSalaryComponentService.removeAdditionalSalary(additionalSalaryComponentService.getAdditionalSalaryById(feeId));
	
		
		map.put("listSalaryStructure", additionalSalaryComponentService.listAdditionalSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),teacherId));
		
		return "redirect:/additionalSalary/getAdditionalTeacherFeesList/"+teacherId;
	}
	
	@RequestMapping("/enableDisableSalary/{userNo}/{enabled}")
	public String enableDisableSalary(Map<String, Object> map,HttpSession session, @PathVariable("userNo") Integer userNo, @PathVariable("enabled") boolean enabled) {
		AdditionalSalaryComponent additionalSalaryComponent= additionalSalaryComponentService.getAdditionalSalaryById(userNo);
		
		
		
		map.put("additionalSalaryComponent", new AdditionalSalaryComponent());
		
		additionalSalaryComponent.setEnabled(enabled);
		additionalSalaryComponentService.saveAdditionalSalary(additionalSalaryComponent);
		String str= "Disabled";
		if(enabled){
			str= "Enabled";
		}
		map.put("message", "Admin: "+additionalSalaryComponent.getTeacherIdValue()+" is "+str+" Now. ");
	

		return "additionalSalaryComponent";

	}
}
	