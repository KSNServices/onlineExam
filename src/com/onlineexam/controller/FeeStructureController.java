package com.onlineexam.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
import com.onlineexam.model.Student;
import com.onlineexam.model.StudentFeeDetail;
import com.onlineexam.model.Teacher;
import com.onlineexam.model.User;
import com.onlineexam.service.ClassNameService;
import com.onlineexam.service.ClassSectionService;
import com.onlineexam.service.FeeStructureService;
import com.onlineexam.service.UserService;

@Controller
@RequestMapping("/fee")
public class FeeStructureController {
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public ClassNameService classNameService;
	
	@Autowired
	public ClassSectionService classSectionService;

	@Autowired
	public FeeStructureService feeStructureService;

	@InitBinder
	public void bindingPreparation(WebDataBinder binder) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "dob", customDateEditor);
	}

	@RequestMapping(value = "/feeStructure")
	public String FeeStructure(Map<String, Object> map, HttpSession session) throws Exception {
		FeeStructure feestr = new FeeStructure();
		map.put("feeStructure", new FeeStructure());
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		
		feestr.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
		feestr.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
		map.put("classNameList",classNameService.listClassName(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		map.put("feeStructure", feestr);
		//map.put("listFeeStructure", feeStructureService.listFeeStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		return "feeStructure";
	}

	@RequestMapping(value = "/saveFeeStructure", method = RequestMethod.POST)
	public String feeStructureSave(Map<String, Object> map, HttpSession session,
			@ModelAttribute("feeStructure") FeeStructure feeStructure, @Valid FeeStructure feeStructureValid, BindingResult result, @RequestParam("feeAmountValue") String feeAmountValue)
					throws Exception {
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		String classValue =  feeStructure.getClassName();
		String section = feeStructure.getClassSection();
		String id = classValue+"@"+section;

		if (result.hasErrors()) {
			map.put("feeStructure", new FeeStructure());
			map.put("showDiv", false);
			map.put("listFeeStructure", feeStructureService.listFeeStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),classValue,section));
			map.put("message", "Fill all mandatory feilds.");
			return "feeStructure";
		} else {
			try {
				if (null == feeStructure.getId()) {
					int count = feeStructure.getCount();
					String[] parts = feeAmountValue.split("#");
					for(int i=0 ;i<count; i++)
					{
						String[] feeDis = parts[i].split("/");
						feeStructure.setFeeComponent(feeDis[0]);
						feeStructure.setAmount( Double.parseDouble( feeDis[1]));
						feeStructure.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
						feeStructure.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
					feeStructureService.saveFeeStructure(feeStructure);
					}
					map.put("message", "FeeStructure added sucessfully.");
					return "redirect:/fee/getStudentFeesList/"+id;
				} else {
					int count = feeStructure.getCount();
					if(feeAmountValue == null|| feeAmountValue.isEmpty()){
						feeStructure.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
						feeStructure.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
					feeStructureService.saveFeeStructure(feeStructure);
						
					}
					else
					{
					String[] parts = feeAmountValue.split("#");
					for(int i=0 ;i<count; i++)
					{
						if(i==0 ){
							feeStructure.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
							feeStructure.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
						feeStructureService.saveFeeStructure(feeStructure);
						}
						else
						{
							feeStructure.setId(null);
						String[] feeDis = parts[i].split("/");
						feeStructure.setFeeComponent(feeDis[0]);
						feeStructure.setAmount( Double.parseDouble( feeDis[1]));
						feeStructure.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
						feeStructure.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
					feeStructureService.saveFeeStructure(feeStructure);
						}
					}
					}
					map.put("message", "Fee Structure added sucessfully.");
					return "redirect:/fee/getStudentFeesList/"+id;
				}
			} catch (Exception exp) {
				exp.printStackTrace();
				map.put("dbError", exp.getMessage());
				map.put("feeStructure", new FeeStructure());
				map.put("showDiv", false);
				map.put("listFeeStructure", feeStructureService.listFeeStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),classValue,section));

				map.put("message", "Cannot add Fee Strucure, Already present.");
				return "feeStructure";
			}
		}

	}
	
	@RequestMapping("/getclassSectionList/{id}")
	public String getclassSectionList(Map<String, Object> map, HttpSession session, @PathVariable("id") String id,
			HttpServletResponse response) throws Exception {
		FeeStructure feestr = new FeeStructure();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		feestr.setClassName(id);
		map.put("showDiv", true);
		map.put("feeStructure", feestr);	
		map.put("classNameList",classNameService.listClassName(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		map.put("classSectionList",classSectionService.listClassSection((Integer.parseInt(adminIdString)), Integer.parseInt(schoolIdString), id));
		return "feeStructure";
	}
	

	@RequestMapping(value = "/getStudentFeesList/{id}")
	public String getStudentFeesData(Map<String, Object> map, HttpSession session, @PathVariable String id) throws Exception {
		//Student st =   studentFormService.getStudentByStudentId(id);
		FeeStructure feestr = new FeeStructure();
		String[] parts = id.split("@");
		String className = parts[0];
		String section = parts[1];
		//Double totalAmount =  feeStructureService.getFeeClass(st.getClassName(), st.getClassSection());
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		map.put("classNameList",classNameService.listClassName(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		map.put("classSectionList",classSectionService.listClassSection((Integer.parseInt(adminIdString)), Integer.parseInt(schoolIdString), className));
	
		
		feestr.setClassName(className);
		feestr.setClassSection(section);
	
		map.put("showDiv", true);
		map.put("feeStructure", feestr);		
		map.put("listFeeStructure", feeStructureService.listFeeStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), className,section));
		return "feeStructure";
	}
	
	
	
	
	
	
	
	@RequestMapping("/editFeeComponent/{feeId}")
	public String editUser(Map<String, Object> map,HttpSession session, @PathVariable("feeId") Integer feeId) {
		map.put("showDiv", true);
		//FeeStructure feeStructure = new FeeStructure();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		map.put("feeStructure", feeStructureService.getFeeById(feeId));
	
		//map.put("feeStructure", feeStructure);
		String className =feeStructureService.getFeeById(feeId).getClassName();
		String section =feeStructureService.getFeeById(feeId).getClassSection();
		map.put("listFeeStructure", feeStructureService.listFeeStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),className,section));
	
		return "feeStructure";
	}
	
	@RequestMapping("/deleteFeeComponent/{feeId}")
	public String deleteUser(Map<String, Object> map,HttpSession session, @PathVariable("feeId") Integer feeId) {
		map.put("showDiv", true);
		//FeeStructure feeStructure = new FeeStructure();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		String className =feeStructureService.getFeeById(feeId).getClassName();
		String section =feeStructureService.getFeeById(feeId).getClassSection();
		FeeStructure feeStructure= feeStructureService.getFeeById(feeId);
		 feeStructureService.removeFeeStructure(feeStructure);
		 String id = className+"@"+section;
		//map.put("feeStructure", feeStructure);
		
		map.put("listFeeStructure", feeStructureService.listFeeStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),className,section));
	
		return "redirect:/fee/getStudentFeesList/"+id;
	}
	
	@RequestMapping("/enableDisableFee/{userNo}/{enabled}")
	public String enableDisableUser(Map<String, Object> map,HttpSession session, @PathVariable("userNo") Integer userNo, @PathVariable("enabled") boolean enabled) {
		FeeStructure feeStructure= feeStructureService.getFeeById(userNo);
		
		
		
		
		
		
		
		map.put("feeStructure", new FeeStructure());
		
		feeStructure.setEnabled(enabled);
		feeStructureService.saveFeeStructure(feeStructure);
		String str= "Disabled";
		if(enabled){
			str= "Enabled";
		}
		map.put("message", "Admin: "+feeStructure.getClassName()+" is "+str+" Now. ");
	

		return "feeStructure";

	}
}
	