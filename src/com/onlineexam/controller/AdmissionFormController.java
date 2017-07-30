package com.onlineexam.controller;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;

import com.onlineexam.constants.ERPConstant;
import com.onlineexam.constants.ModelConstants;
import com.onlineexam.model.AdmissionFormModel;
import com.onlineexam.model.State;
import com.onlineexam.model.Student;
import com.onlineexam.model.User;
import com.onlineexam.service.AdmissionFormService;
import com.onlineexam.service.ClassNameService;
import com.onlineexam.service.UserService;
import com.onlineexam.util.FileUtils;




@Controller
@RequestMapping("/student")
public class AdmissionFormController {

	@InitBinder
	public void bindingPreparation(WebDataBinder binder)throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "dob", customDateEditor);
	}


	@Autowired
	public AdmissionFormService admissionFormService;

	@Autowired
	public ClassNameService classNameService;

	@Autowired
	public UserService userService;

	@RequestMapping(value ="/admissionForm")
	public String admissionForm(Map<String, Object> map,HttpSession session, HttpServletRequest request)throws Exception {
		map.put("admissionFormModel", new AdmissionFormModel());

		AdmissionFormModel adm = new AdmissionFormModel();

		String newStudentId = null;
		String studentId = null;

		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		String laststudentId = admissionFormService.getLaststudentId(Integer.parseInt(adminIdString),
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

		adm.setRegistrationNo(newStudentId);
		adm.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
		adm.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
		map.put("admissionFormModel", adm);
		map.put("classNameList",classNameService.listClassName(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));

		map.put("registrationList", admissionFormService.listRegistration(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		if(request.getParameter("message")!=null){
			map.put("message", (String)(request.getParameter("message")));
		}
		if(request.getParameter("error")!=null){
			map.put("showDiv", true);
			map.put("error", (String)(request.getParameter("error")));
		}

		return "admissionForm";
	}

	@RequestMapping(value ="/saveAdmissionForm", method = RequestMethod.POST)
	public String admissionFormSave(Map<String, Object> map,HttpSession session, @ModelAttribute("admissionFormModel") AdmissionFormModel admissionFormModel, @Valid AdmissionFormModel admissionFormModelValid,
			BindingResult result,@RequestParam("userpic") MultipartFile userpic) throws Exception {

		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();

		if(!(admissionFormModel.getRegistrationNo().equals("")|| admissionFormModel.getRegistrationNo() == null) )
		{
			AdmissionFormModel  admissionForm = admissionFormService.getRegistrationByRegistrationId(admissionFormModel.getRegistrationNo());
			if(admissionForm != null)
			{
				admissionFormModel.setId(admissionForm.getId());
				map.put("admissionFormModel", admissionForm);
			}
		}


		if (result.hasErrors()) {
			map.put("admissionFormModel", new AdmissionFormModel());
			map.put("showDiv", false);
			map.put("registrationList", admissionFormService.listRegistration(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));

			map.put("message", "Fill all mandatory feilds.");
			return "admissionForm";
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
							return "redirect:/studentForm/studentDetail";
						}
						String profilePicDirectory = ERPConstant.ERP_MEDIA_DIRECTORY + File.separator
								+ ERPConstant.ADMISSION_STUDENT_IMAGES;
						String fileAbsolutePath = fileUtils.uploadSingleFiles(userpic, profilePicDirectory);
						admissionFormModel.setAdmissionStudentImage(fileAbsolutePath);
					}

					if(admissionFormModel.getDob() == null || admissionFormModel.getDob().equals("") ||  admissionFormModel.getDob().equals("00/00/0000") )
					{
						map.put("error", "Please enter DOB");
					}else if(admissionFormModel.getGender().equals("0"))
					{
						map.put("error", "Please select Gender"); 
					}else if(admissionFormModel.getClassName().equals("0"))
					{
						map.put("error", "Please select Class"); 
					}
					else
					{

						admissionFormService.saveRegistration(admissionFormModel);
						map.put("message","Registration added sucessfully.");

					}


					return "redirect:/student/admissionForm";
				}
				else{

					if (userpic != null &&  userpic.getSize()>0){
						FileUtils fileUtils = new FileUtils();
						// Validate image size
						double sizeInKB = fileUtils.getImageSize(userpic);
						if (sizeInKB > 1024) {
							map.put("showDiv", true);
							map.put("error", "Image size should not be exceeded by 1024 KB.");
							return "/student/admissionForm";
						}
						// Validate image dimensions
						int[] imageDim = fileUtils.getDimensions(userpic);
						if (imageDim[0] > 1000 && imageDim[1] > 1000) {
							map.put("showDiv", true);
							map.put("error", "Image dimensions should be 600px and 600px.");
							return "/student/admissionForm";
						}
						String profilePicDirectory = ERPConstant.ERP_MEDIA_DIRECTORY + File.separator
								+ ERPConstant.ADMISSION_STUDENT_IMAGES;
						String fileAbsolutePath = fileUtils.uploadSingleFiles(userpic, profilePicDirectory);
						admissionFormModel.setAdmissionStudentImage(fileAbsolutePath);
					}
					if(admissionFormModel.getDob() == null || admissionFormModel.getDob().equals("") ||  admissionFormModel.getDob().equals("00/00/0000") )
					{
						map.put("error", "Please enter DOB");
					}else if(admissionFormModel.getGender().equals("0"))
					{
						map.put("error", "Please select Gender"); 
					}else if(admissionFormModel.getClassName().equals("0"))
					{
						map.put("error", "Please select Class"); 
					}
					else
					{

						admissionFormService.saveRegistration(admissionFormModel);
					}
					return "redirect:/student/admissionForm";
				}
			}
			catch (Exception exp) {
				exp.printStackTrace();
				map.put("dbError", exp.getMessage());

				map.put("showDiv", false);
				map.put("registrationList", admissionFormService.listRegistration(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
				map.put("admissionFormModel", new AdmissionFormModel());
				map.put("message", "Cannot add Registartion, Already present.");
				return "admissionForm";
			}
		}		

	}
	@RequestMapping("/editRegistration/{registrationId}")
	public String editUser(Map<String, Object> map,HttpSession session, @PathVariable("registrationId") Integer registrationId) {

		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();


		map.put("showDiv", true);
		map.put("admissionFormModel", admissionFormService.getregistrationById(registrationId));
		map.put("registrationList", admissionFormService.listRegistration(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		map.put("classNameList",classNameService.listClassName(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		return "admissionForm";
	}

	@RequestMapping("/confirmStudent/{registrationId}")
	public String confirmStudent(Map<String, Object> map,HttpSession session, @PathVariable("registrationId") Integer registrationId) {
		map.put("showDiv", true);


		return  "redirect:/studentForm/newStudentDetail/"+registrationId;
	}


	@RequestMapping("/enableDisableRegistration/{userNo}/{enabled}")
	public String enableDisableUser(Map<String, Object> map,HttpSession session, @PathVariable("userNo") Integer userNo, @PathVariable("enabled") boolean enabled) {
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();


		AdmissionFormModel admissionFormModel = admissionFormService.getregistrationById(userNo);
		map.put("admissionFormModel", new AdmissionFormModel());
		map.put("registrationList", admissionFormService.listRegistration(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		admissionFormModel.setEnabled(enabled);
		admissionFormService.saveRegistration(admissionFormModel);
		String str= "Disabled";
		if(enabled){
			str= "Enabled";
		}
		map.put("message", "Admin: "+admissionFormModel.getName()+" is "+str+" Now. ");


		return "admissionForm";

	}

	@RequestMapping("/readAdmissionStudentDisplayImage/{id}")
	public void readUserDisplayImage(Map<String, Object> map, HttpSession session, @PathVariable("id") Integer id,
			HttpServletResponse response) throws Exception {
		AdmissionFormModel st = admissionFormService.getregistrationById(id);
		String imgDir = ERPConstant.ERP_MEDIA_DIRECTORY + File.separator + ERPConstant.ADMISSION_STUDENT_IMAGES;
		String noImgThumb = imgDir + File.separator + ERPConstant.NO_PROFILE_PIC_THUMBNAIL_IMAGE;
		String profilePic = noImgThumb;
		if (st.getAdmissionStudentImage() != null) {
			profilePic = st.getAdmissionStudentImage();
			profilePic = imgDir + File.separator + profilePic;
		}
		new FileUtils().readImage(profilePic, noImgThumb, response);
		return;
	}



}
