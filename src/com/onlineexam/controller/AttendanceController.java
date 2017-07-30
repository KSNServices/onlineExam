package com.onlineexam.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.onlineexam.constants.ERPConstant;
import com.onlineexam.model.AdmissionFormModel;
import com.onlineexam.model.Attendance;
import com.onlineexam.model.FeeStructure;
import com.onlineexam.model.Student;
import com.onlineexam.model.User;
import com.onlineexam.service.AdmissionFormService;
import com.onlineexam.service.AttendanceService;
import com.onlineexam.service.StudentFormService;
import com.onlineexam.service.UserService;
import com.onlineexam.util.FileUtils;

@Controller
@RequestMapping("/attendanceStudent")
public class AttendanceController {
	
	@Autowired
	public AttendanceService attendanceService;
	
	@Autowired
	public StudentFormService studentFormService;
	@Autowired
	public UserService userService;
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder)throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "dob", customDateEditor);
	}
	
	
	
	@RequestMapping(value ="/attendance")
	public String attendance(Map<String, Object> map,HttpSession session)throws Exception {
		Attendance attendance = new Attendance();
		map.put("attendance", new Attendance());
		//attendance.setClassName(className);
		//attendance.setClassSection(section);
		
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		attendance.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
		attendance.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));

		return "attendance";
	}
	
	@RequestMapping(value ="/saveAttendanceForm", method = RequestMethod.POST)
	public String saveAttendanceForm(Map<String, Object> map,HttpSession session, @ModelAttribute("admissionFormModel") AdmissionFormModel admissionFormModel, @Valid AdmissionFormModel admissionFormModelValid,
			BindingResult result,@RequestParam("userpic") MultipartFile userpic) throws Exception {
		if (result.hasErrors()) {
			map.put("admissionFormModel", new AdmissionFormModel());
			map.put("showDiv", false);
			//map.put("registrationList", admissionFormService.listRegistration());
			
			map.put("message", "Fill all mandatory feilds.");
			return "attendance";
		} 
		else {
			try {				
				if(null == admissionFormModel.getId()){
					if (userpic != null &&  userpic.getSize()>0) {
						FileUtils fileUtils = new FileUtils();
						// Validate image size
						double sizeInKB = fileUtils.getImageSize(userpic);
						if (sizeInKB > 1024) {
							map.put("showDiv", true);
							map.put("error", "Image size should not be exceeded by 1024 KB.");
							return "redirect:/studentForm/studentDetail";
						}
						// Validate image dimensions
						int[] imageDim = fileUtils.getDimensions(userpic);
						if (imageDim[0] > 1000 && imageDim[1] > 1000) {
							map.put("showDiv", true);
							map.put("error", "Image dimensions should be 600px and 600px.");
							return "redirect:/attendanceStudent/attendance";
						}
						String profilePicDirectory = ERPConstant.ERP_MEDIA_DIRECTORY + File.separator
								+ ERPConstant.ADMISSION_STUDENT_IMAGES;
						String fileAbsolutePath = fileUtils.uploadSingleFiles(userpic, profilePicDirectory);
						admissionFormModel.setAdmissionStudentImage(fileAbsolutePath);
					}
					
					
					
					//admissionFormService.saveRegistration(admissionFormModel);
					map.put("message","Registration added sucessfully.");
					return "redirect:/attendanceStudent/attendance";
				}
				else{
					
					if (userpic != null &&  userpic.getSize()>0){
						FileUtils fileUtils = new FileUtils();
						// Validate image size
						double sizeInKB = fileUtils.getImageSize(userpic);
						if (sizeInKB > 1024) {
							map.put("showDiv", true);
							map.put("error", "Image size should not be exceeded by 1024 KB.");
							return "/attendanceStudent/attendance";
						}
						// Validate image dimensions
						int[] imageDim = fileUtils.getDimensions(userpic);
						if (imageDim[0] > 1000 && imageDim[1] > 1000) {
							map.put("showDiv", true);
							map.put("error", "Image dimensions should be 600px and 600px.");
							return "/attendance/attendanceForm";
						}
						String profilePicDirectory = ERPConstant.ERP_MEDIA_DIRECTORY + File.separator
								+ ERPConstant.ADMISSION_STUDENT_IMAGES;
						String fileAbsolutePath = fileUtils.uploadSingleFiles(userpic, profilePicDirectory);
						admissionFormModel.setAdmissionStudentImage(fileAbsolutePath);
					}
					
					
					//admissionFormService.saveRegistration(admissionFormModel);
					return "redirect:/attendance/attendanceForm";
				}
			}
			 catch (Exception exp) {
				 exp.printStackTrace();
				map.put("dbError", exp.getMessage());
			
				map.put("showDiv", false);
				//map.put("registrationList", admissionFormService.listRegistration());
				map.put("admissionFormModel", new AdmissionFormModel());
				map.put("message", "Cannot add Registartion, Already present.");
				return "attendanceForm";
			}
		}		
		
	}
	
	

	@RequestMapping(value = "/getStudentAttendanceList/{id}")
	public String getStudentAttendanceData(Map<String, Object> map, HttpSession session, @PathVariable String id) throws Exception {
		Attendance attendance = new Attendance();
		map.put("attendance", new Attendance());
		String[] parts = id.split("@");
		String className = parts[0];
		String section = parts[1];
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		
		
		attendance.setClassName(className);
		attendance.setClassSection(section);
		
	
		map.put("showDiv", true);
		//map.put("student", new Student());		
		map.put("listClassStudent", studentFormService.listClassStudent(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), className,section));
		return "attendance";
	}
	

}
