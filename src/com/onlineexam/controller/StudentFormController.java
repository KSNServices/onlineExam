package com.onlineexam.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.onlineexam.constants.ERPConstant;
import com.onlineexam.model.AdmissionFormModel;
import com.onlineexam.model.ClassSection;
import com.onlineexam.model.Student;
import com.onlineexam.model.User;
import com.onlineexam.service.AdmissionFormService;
import com.onlineexam.service.ClassNameService;
import com.onlineexam.service.ClassSectionService;
import com.onlineexam.service.StudentFormService;
import com.onlineexam.service.UserService;
import com.onlineexam.util.FileUtils;

@Controller
@RequestMapping("/studentForm")
public class StudentFormController {

	@Autowired
	public StudentFormService studentFormService;

	@Autowired
	public UserService userService;
	
	@Autowired
	public ClassNameService classNameService;
	
	@Autowired
	public ClassSectionService classSectionService;

	@Autowired
	public AdmissionFormService admissionFormService;

	@InitBinder
	public void bindingPreparation(WebDataBinder binder) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "dob", customDateEditor);
	}

	@RequestMapping(value = "/studentDetail")
	public String studentDetail(Map<String, Object> map, HttpSession session) throws Exception {
		Student str = new Student();
		map.put("student", new Student());

		String newStudentId = null;
		String studentId = null;
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		String laststudentId = studentFormService.getLaststudentId(Integer.parseInt(adminIdString),
				Integer.parseInt(schoolIdString));
		String adminId = "00000".substring(adminIdString.length()) + adminIdString;
		String schoolId = "00000".substring(schoolIdString.length()) + schoolIdString;

		if (laststudentId == null) {
			newStudentId = adminId + "-" + schoolId + "-" + "00001";
		} else if (laststudentId.length() > 10) {
			String string = laststudentId;
			String[] parts = string.split("-");
			String admin = parts[0];
			String school = parts[1];
			String student = parts[2];

			String studentIdString = String.valueOf(Integer.parseInt(student) + 1);
			studentId = "00000".substring(studentIdString.length()) + studentIdString;
			newStudentId = adminId + "-" + schoolId + "-" + studentId;
		} else {
			String studentIdString = String.valueOf(Integer.parseInt(laststudentId) + 1);
			studentId = "00000".substring(studentIdString.length()) + studentIdString;
			newStudentId = adminId + "-" + schoolId + "-" + studentId;

		}

		str.setStudentId(newStudentId);
		str.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
		str.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
		map.put("classNameList",classNameService.listClassName(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		map.put("classSectionList",classSectionService.listClassSectionTotal((Integer.parseInt(adminIdString)), Integer.parseInt(schoolIdString)));
		map.put("student", str);
		map.put("listStudent",
				studentFormService.listStudent(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));

		return "studentForm";
	}

	@RequestMapping(value = "/saveStudentDetail", method = RequestMethod.POST)
	public String studentDetailSave(Map<String, Object> map, HttpSession session,
			@ModelAttribute("student") Student student, @Valid Student studentValid, BindingResult result,
			@RequestParam("userpic") MultipartFile userpic, @RequestParam("admissionID") Integer admissionId)
					throws Exception {

		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();

		if (result.hasErrors()) {
			map.put("student", new Student());
			map.put("showDiv", false);
			map.put("listStudent",
					studentFormService.listStudent(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));

			map.put("message", "Fill all mandatory feilds.");
			return "studentForm";
		} else {
			try {
				if (null == student.getId()) {
					if (userpic != null && userpic.getSize() > 0) {
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
							return "redirect:/studentForm/studentDetail";
						}
						String profilePicDirectory = ERPConstant.ERP_MEDIA_DIRECTORY + File.separator
								+ ERPConstant.STUDENT_IMAGES;
						String fileAbsolutePath = fileUtils.uploadSingleFiles(userpic, profilePicDirectory);
						student.setStudentImage(fileAbsolutePath);
					}
					studentFormService.saveStudentForm(student);

					AdmissionFormModel admissionFormModel = admissionFormService.getregistrationById(admissionId);
					admissionFormModel.setIsConfirm(true);
					admissionFormService.saveRegistration(admissionFormModel);

					map.put("studentId", student.getStudentId());
					// studentID = student.getStudentId();
					map.put("message", "Student added sucessfully.");
					return "redirect:/feeDetail/getStudentFeesData/" + student.getStudentId();
				} else {
					if (userpic != null && userpic.getSize() > 0) {
						FileUtils fileUtils = new FileUtils();
						// Validate image size
						double sizeInKB = fileUtils.getImageSize(userpic);
						if (sizeInKB > 1024) {
							map.put("showDiv", true);
							map.put("error", "Image size should not be exceeded by 1024 KB.");
							return "studentForm";
						}
						// Validate image dimensions
						int[] imageDim = fileUtils.getDimensions(userpic);
						if (imageDim[0] > 1000 && imageDim[1] > 1000) {
							map.put("showDiv", true);
							map.put("error", "Image dimensions should be 600px and 600px.");
							return "studentForm";
						}
						String profilePicDirectory = ERPConstant.ERP_MEDIA_DIRECTORY + File.separator
								+ ERPConstant.STUDENT_IMAGES;
						String fileAbsolutePath = fileUtils.uploadSingleFiles(userpic, profilePicDirectory);
						student.setStudentImage(fileAbsolutePath);
					}
					studentFormService.saveStudentForm(student);
					map.put("studentId", student.getId());
					map.put("message", "Student added sucessfully.");
					return "redirect:/feeDetail/getStudentFeesData/" + student.getId();
				}
			} catch (Exception exp) {
				exp.printStackTrace();
				map.put("dbError", exp.getMessage());
				map.put("showDiv", false);
				map.put("listStudent", studentFormService.listStudent(Integer.parseInt(adminIdString),
						Integer.parseInt(schoolIdString)));
				map.put("student", new Student());
				map.put("message", "Cannot add Student, Already present.");
				return "studentForm";
			}
		}
	}

	@RequestMapping("/editStudent/{studentId}")
	public String editUser(Map<String, Object> map, HttpSession session, @PathVariable("studentId") Integer studentId) {

		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();

		map.put("showDiv", true);
		map.put("student", studentFormService.getStudentById(studentId));
		map.put("listStudent",
				studentFormService.listStudent(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		return "studentForm";
	}

	@RequestMapping("/enableDisableStudent/{StudentNo}/{enabled}")
	public String enableDisableUser(Map<String, Object> map, HttpSession session,
			@PathVariable("StudentNo") Integer StudentNo, @PathVariable("enabled") boolean enabled) {

		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();

		Student student = studentFormService.getStudentById(StudentNo);
		map.put("student", new Student());
		map.put("listStudent",
				studentFormService.listStudent(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		student.setEnabled(enabled);
		studentFormService.saveStudentForm(student);
		String str = "Disabled";
		if (enabled) {
			str = "Enabled";
		}
		map.put("message", "Admin: " + student.getFirstName() + " is " + str + " Now. ");

		return "studentForm";

	}

	@RequestMapping("/readStudentDisplayImage/{id}")
	public void readUserDisplayImage(Map<String, Object> map, HttpSession session, @PathVariable("id") Integer id,
			HttpServletResponse response) throws Exception {
		Student st = studentFormService.getStudentById(id);
		String imgDir = ERPConstant.ERP_MEDIA_DIRECTORY + File.separator + ERPConstant.STUDENT_IMAGES;
		String noImgThumb = imgDir + File.separator + ERPConstant.NO_PROFILE_PIC_THUMBNAIL_IMAGE;
		String profilePic = noImgThumb;
		if (st.getStudentImage() != null) {
			profilePic = st.getStudentImage();
			profilePic = imgDir + File.separator + profilePic;
		}
		new FileUtils().readImage(profilePic, noImgThumb, response);
		return;
	}
	
	//@RequestMapping("/getclassSectionList/{id}")
	//@Produces("application/json")
	@GET
	@Path("/getclassSectionList/{id}")
	@Produces("application/json")
	@RequestMapping(value="/getclassSectionList/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody
	public @ResponseBody List<ClassSection> getclassSectionList( HttpSession session, @PathVariable("id") String id,
			HttpServletResponse response) throws Exception {
	    
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
				
		//map.put("classSectionList",classSectionService.listClassSection((Integer.parseInt(adminIdString)), Integer.parseInt(schoolIdString), id));
		return classSectionService.listClassSection((Integer.parseInt(adminIdString)), Integer.parseInt(schoolIdString), id);
		
	}

	

	@RequestMapping(value = "/newStudentDetail/{registrationId}")
	public String newStudentDetail(Map<String, Object> map, HttpSession session,
			@PathVariable("registrationId") Integer registrationId) {
		Student str = new Student();
		// AdmissionFormModel admissionFormModel = new AdmissionFormModel();
		map.put("showDiv", true);
		String newStudentId = null;
		String studentId = null;
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		String laststudentId = studentFormService.getLaststudentId(Integer.parseInt(adminIdString),
				Integer.parseInt(schoolIdString));
		String adminId = "00000".substring(adminIdString.length()) + adminIdString;
		String schoolId = "00000".substring(schoolIdString.length()) + schoolIdString;

		if (laststudentId == null) {
			newStudentId = adminId + "-" + schoolId + "-" + "00001";
		} else if (laststudentId.length() > 10) {
			String string = laststudentId;
			String[] parts = string.split("-");
			String admin = parts[0];
			String school = parts[1];
			String student = parts[2];

			String studentIdString = String.valueOf(Integer.parseInt(student) + 1);
			studentId = "00000".substring(studentIdString.length()) + studentIdString;
			newStudentId = adminId + "-" + schoolId + "-" + studentId;
		} else {
			String studentIdString = String.valueOf(Integer.parseInt(laststudentId) + 1);
			studentId = "00000".substring(studentIdString.length()) + studentIdString;
			newStudentId = adminId + "-" + schoolId + "-" + studentId;

		}

		// map.put("admissionFormModel",
		// admissionFormService.getregistrationById(registrationId));
		AdmissionFormModel admissionFormModel = admissionFormService.getregistrationById(registrationId);
		str.setFirstName(admissionFormModel.getFirstName());
		str.setMiddleName(admissionFormModel.getMiddleName());
		str.setLastName(admissionFormModel.getLastName());
		str.setMobileNumber(admissionFormModel.getMobileNumber());
		str.setEmailId(admissionFormModel.getEmailId());
		str.setPhoneNumber(admissionFormModel.getPhoneNumber());
		str.setAadharNumber(admissionFormModel.getAadharNumber());
		str.setGender(admissionFormModel.getGender());
		//str.setStudentImage(admissionFormModel.getAdmissionStudentImage());
		str.setFatherName(admissionFormModel.getFatherName());
		str.setFatherOccupation(admissionFormModel.getFatherOccupation());
		str.setMotherName(admissionFormModel.getMotherName());
		str.setMotherOccupation(admissionFormModel.getMotherOccupation());
		str.setDob(admissionFormModel.getDob());
		str.setClassName(admissionFormModel.getClassName());
		str.setReligion(admissionFormModel.getReligion());
		str.setAddress(admissionFormModel.getAddress());
		str.setBloodGroup(admissionFormModel.getBloodGroup());
		str.setPreviousClassPercentage(admissionFormModel.getPreviousclassPercentage());
		str.setAdminId(admissionFormModel.getAdminId());
		str.setSchoolId(admissionFormModel.getSchoolId());
		str.setStudentImage(admissionFormModel.getAdmissionStudentImage());
		str.setStudentId(newStudentId);
		/*
		 * str.setAdminId(userService.getUserById(Integer.parseInt(adminIdString
		 * ))); str.setSchoolId(userService.getUserById(Integer.parseInt(
		 * schoolIdString)));
		 */
		map.put("student", str);
		map.put("listStudent",
				studentFormService.listStudent(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		map.put("admissionID", admissionFormModel.getId());
		return "studentForm";
	}

}
