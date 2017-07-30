
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

import com.onlineexam.model.AdmissionFormModel;
import com.onlineexam.model.FeeStructure;
import com.onlineexam.model.SalaryStructure;
import com.onlineexam.model.Student;
import com.onlineexam.model.StudentFeeDetail;
import com.onlineexam.model.Teacher;
import com.onlineexam.model.User;
import com.onlineexam.service.ClassNameService;
import com.onlineexam.service.ClassSectionService;
import com.onlineexam.service.FeeStructureService;
import com.onlineexam.service.SalaryStructureService;
import com.onlineexam.service.TeacherGradeService;
import com.onlineexam.service.UserService;

@Controller
@RequestMapping("/salary")
public class SalaryStructureController {
	
	@Autowired
	public UserService userService;

	@Autowired
	public SalaryStructureService salaryStructureService;

	@Autowired
	public TeacherGradeService teacherGradeService;
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "dob", customDateEditor);
	}

	@RequestMapping(value = "/salaryStructure")
	public String FeeStructure(Map<String, Object> map, HttpSession session,HttpServletRequest request) throws Exception {
		SalaryStructure salaryStructure = new SalaryStructure();
		map.put("salaryStructure", new SalaryStructure());
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		
		salaryStructure.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
		salaryStructure.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
		map.put("listTeacherGradePresent",teacherGradeService.listTeacherGrade(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		map.put("salaryStructure", salaryStructure);
		//map.put("listFeeStructure", feeStructureService.listFeeStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		
		if(request.getParameter("message")!=null){
			map.put("message", (String)(request.getParameter("message")));
		}
		if(request.getParameter("error")!=null){
			map.put("showDiv", true);
			map.put("error", (String)(request.getParameter("error")));
		
		}
		
		return "salaryStructure";
	}

	@RequestMapping(value = "/saveSalaryStructure", method = RequestMethod.POST)
	public String feeStructureSave(Map<String, Object> map, HttpSession session,
			@ModelAttribute("salaryStructure") SalaryStructure salaryStructure, @Valid SalaryStructure salaryStructureValid, BindingResult result, @RequestParam("feeAmountValue") String feeAmountValue)
					throws Exception {
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		

		if (result.hasErrors()) {
			map.put("salaryStructure", new SalaryStructure());
			map.put("showDiv", false);
			map.put("listSalaryStructure", salaryStructureService.listSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),salaryStructure.getTeacherGrade()));
			map.put("message", "Fill all mandatory feilds.");
			return "feeStructure";
		} else {
			try {
				if (null == salaryStructure.getId()) {
					int count = salaryStructure.getCount();
					if(salaryStructure.getTeacherGrade().equals("0"))
					{
						map.put("message", "Please Add Teacher Grade");
					}
					else
					{
					String[] parts = feeAmountValue.split("#");
					for(int i=0 ;i<count; i++)
					{
						String[] feeDis = parts[i].split("/");
						salaryStructure.setSalaryComponent(feeDis[0]);
						salaryStructure.setAmount( Double.parseDouble( feeDis[1]));
						salaryStructure.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
						salaryStructure.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
						salaryStructureService.saveSalary(salaryStructure);
					}
					
					map.put("message", "FeeStructure added sucessfully.");
					}
					return "redirect:/salary/getTeacherFeesList/"+salaryStructure.getTeacherGrade();
				} else {
					
					if(salaryStructure.getTeacherGrade().equals("0"))
					{
						map.put("message", "Please Add Teacher Grade");
					}
					else
					{
					
					int count = salaryStructure.getCount();
					if(feeAmountValue == null|| feeAmountValue.isEmpty()){
						salaryStructure.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
						salaryStructure.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
						salaryStructureService.saveSalary(salaryStructure);
						
					}
					else
					{
					String[] parts = feeAmountValue.split("#");
					for(int i=0 ;i<count; i++)
					{
						if(i==0 ){
							salaryStructure.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
							salaryStructure.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
							salaryStructureService.saveSalary(salaryStructure);
						}
						else
						{
							salaryStructure.setId(null);
						String[] feeDis = parts[i].split("/");
						salaryStructure.setSalaryComponent(feeDis[0]);
						salaryStructure.setAmount( Double.parseDouble( feeDis[1]));
						salaryStructure.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
						salaryStructure.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
						salaryStructureService.saveSalary(salaryStructure);
						}
					}
					}
					map.put("message", "Salary Structure added sucessfully.");
					}
					return "redirect:/salary/getTeacherFeesList/"+salaryStructure.getTeacherGrade();
				}
			} catch (Exception exp) {
				exp.printStackTrace();
				map.put("dbError", exp.getMessage());
				map.put("salaryStructure", new SalaryStructure());
				map.put("showDiv", false);
				map.put("listSalaryStructure", salaryStructureService.listSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),salaryStructure.getTeacherGrade()));
				
				map.put("message", "Cannot add Salary Strucure, Already present.");
				return "feeStructure";
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

	@RequestMapping(value = "/getTeacherFeesList/{id}")
	public String getTeacherFeesList(Map<String, Object> map, HttpSession session, @PathVariable String id,HttpServletRequest request ) throws Exception {
		//Student st =   studentFormService.getStudentByStudentId(id);
		SalaryStructure salaryStructure = new SalaryStructure();
		
		//Double totalAmount =  feeStructureService.getFeeClass(st.getClassName(), st.getClassSection());
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		map.put("listTeacherGradePresent",teacherGradeService.listTeacherGrade(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		salaryStructure.setTeacherGrade(id);
	
		map.put("showDiv", true);
		map.put("salaryStructure", salaryStructure);		
		map.put("listSalaryStructure", salaryStructureService.listSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),id));
		if(request.getParameter("message")!=null){
			map.put("message", (String)(request.getParameter("message")));
		}
		if(request.getParameter("error")!=null){
			map.put("showDiv", true);
			map.put("error", (String)(request.getParameter("error")));
		
		}
		
		return "salaryStructure";
	}
	
	
	
	
	
	
	
	@RequestMapping("/editSalaryComponent/{feeId}")
	public String editSalaryComponent(Map<String, Object> map,HttpSession session, @PathVariable("feeId") Integer feeId) {
		map.put("showDiv", true);
		//FeeStructure feeStructure = new FeeStructure();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		map.put("salaryStructure", salaryStructureService.getSalaryById(feeId));
		map.put("listTeacherGradePresent",teacherGradeService.listTeacherGrade(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		
		//map.put("feeStructure", feeStructure);
		String teacherGrade =salaryStructureService.getSalaryById(feeId).getTeacherGrade();
		map.put("listSalaryStructure", salaryStructureService.listSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),teacherGrade));
	
		
		return "salaryStructure";
	}
	
	@RequestMapping("/deleteFeeComponent/{feeId}")
	public String deleteUser(Map<String, Object> map,HttpSession session, @PathVariable("feeId") Integer feeId) {
		map.put("showDiv", true);
		//FeeStructure feeStructure = new FeeStructure();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		String teacherGrade =salaryStructureService.getSalaryById(feeId).getTeacherGrade();
		salaryStructureService.removeSalary(salaryStructureService.getSalaryById(feeId));
	
		
		map.put("listSalaryStructure", salaryStructureService.listSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),teacherGrade));
		
		return "redirect:/salary/getTeacherFeesList/"+teacherGrade;
	}
	
	@RequestMapping("/enableDisableSalary/{userNo}/{enabled}")
	public String enableDisableSalary(Map<String, Object> map,HttpSession session, @PathVariable("userNo") Integer userNo, @PathVariable("enabled") boolean enabled) {
		SalaryStructure salaryStructure= salaryStructureService.getSalaryById(userNo);
		
		
		
		map.put("salaryStructure", new SalaryStructure());
		
		salaryStructure.setEnabled(enabled);
		salaryStructureService.saveSalary(salaryStructure);
		String str= "Disabled";
		if(enabled){
			str= "Enabled";
		}
		map.put("message", "Admin: "+salaryStructure.getTeacherGrade()+" is "+str+" Now. ");
	

		return "salaryStructure";

	}
}
	