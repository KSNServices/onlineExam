package com.onlineexam.controller;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;

import com.onlineexam.constants.ERPConstant;
import com.onlineexam.model.AdmissionFormModel;
import com.onlineexam.model.Student;
import com.onlineexam.model.Teacher;
import com.onlineexam.model.User;
import com.onlineexam.service.TeacherFormService;
import com.onlineexam.service.UserService;
import com.onlineexam.util.FileUtils;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	public TeacherFormService teacherFormService;
	
	@Autowired
	public UserService userService;

	@InitBinder
	public void bindingPreparation(WebDataBinder binder) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "dob", customDateEditor);
	}

	@RequestMapping(value = "/teacherDetail")
	public String teacherDetail(Map<String, Object> map, HttpSession session) throws Exception {
		Teacher teacher = new Teacher();
		
		String newTeacherId = null;
		String studentId = null;
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		String lastTeacherId = teacherFormService.getLastTeacherId(Integer.parseInt(adminIdString),
				Integer.parseInt(schoolIdString));
		String adminId = "00000".substring(adminIdString.length()) + adminIdString;
		String schoolId = "00000".substring(schoolIdString.length()) + schoolIdString;

		if (lastTeacherId == null) {
			newTeacherId = adminId + "-" + schoolId + "-" + "001";
		} else if (lastTeacherId.length() > 10) {
			String string = lastTeacherId;
			String[] parts = string.split("-");
			String admin = parts[0];
			String school = parts[1];
			String student = parts[2];

			String studentIdString = String.valueOf(Integer.parseInt(student) + 1);
			studentId = "000".substring(studentIdString.length()) + studentIdString;
			newTeacherId = adminId + "-" + schoolId + "-" + studentId;
		} else {
			String teacherIdString = String.valueOf(Integer.parseInt(lastTeacherId) + 1);
			studentId = "000".substring(teacherIdString.length()) + teacherIdString;
			newTeacherId = adminId + "-" + schoolId + "-" + studentId;

		}

		teacher.setTeacherId(newTeacherId);
		teacher.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
		teacher.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
		map.put("teacher", teacher);
		
		map.put("listTeacher", teacherFormService.listTeacher(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		return "teacherForm";
	}

	@RequestMapping(value = "/saveTeacherDetail", method = RequestMethod.POST)
	public String teacherDetailSave(Map<String, Object> map, HttpSession session,
			@ModelAttribute("teacher") Teacher teacher, @Valid Teacher teacherValid, BindingResult result,@RequestParam("userpic") MultipartFile userpic)
					throws Exception {
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		if (result.hasErrors()) {
			map.put("teacher", new Teacher());
			map.put("showDiv", false);
			map.put("listTeacher", teacherFormService.listTeacher(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
			map.put("message", "Fill all mandatory feilds.");
			return "teacherForm";
		} else {
			try {
				if (null == teacher.getId()) {
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
								+ ERPConstant.TEACHER_IMAGES;
						String fileAbsolutePath = fileUtils.uploadSingleFiles(userpic, profilePicDirectory);
						teacher.setTeacherImage(fileAbsolutePath);
					}
					teacherFormService.saveTeacher(teacher);
					map.put("message", "Teacher added sucessfully.");
					return "redirect:/teacher/teacherDetail";
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
								+ ERPConstant.TEACHER_IMAGES;
						String fileAbsolutePath = fileUtils.uploadSingleFiles(userpic, profilePicDirectory);
						teacher.setTeacherImage(fileAbsolutePath);
					}
					
					teacherFormService.saveTeacher(teacher);
					map.put("message", "Teacher added sucessfully.");
					return "redirect:/teacher/teacherDetail";
				}
			} catch (Exception exp) {
				exp.printStackTrace();
				map.put("dbError", exp.getMessage());
				map.put("teacher", new Teacher());
				map.put("showDiv", false);
				map.put("listTeacher", teacherFormService.listTeacher(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));

				map.put("message", "Cannot add Teacher, Already present.");
				return "teacherForm";
			}
		}

	}
	
	
	

	@RequestMapping("/readTeacherDisplayImage/{id}")
	public void readUserDisplayImage(Map<String, Object> map, HttpSession session, @PathVariable("id") Integer id,
			HttpServletResponse response) throws Exception {
		Teacher teacher = teacherFormService.getteacherById(id);
		String imgDir = ERPConstant.ERP_MEDIA_DIRECTORY + File.separator + ERPConstant.TEACHER_IMAGES;
		String noImgThumb = imgDir + File.separator + ERPConstant.NO_PROFILE_PIC_THUMBNAIL_IMAGE;
		String profilePic = noImgThumb;
		if (teacher.getTeacherImage() != null) {
			profilePic = teacher.getTeacherImage();
			profilePic = imgDir + File.separator + profilePic;
		}
		new FileUtils().readImage(profilePic, noImgThumb, response);
		return;
	}

	
	@RequestMapping("/editTeacher/{teacherId}")
	public String editUser(Map<String, Object> map,HttpSession session, @PathVariable("teacherId") Integer teacherId) {
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		
		map.put("showDiv", true);
		map.put("teacher", teacherFormService.getteacherById(teacherId));
		map.put("listTeacher", teacherFormService.listTeacher(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		
		return "teacherForm";
	}
	

	@RequestMapping("/enableDisableTeacher/{userNo}/{enabled}")
	public String enableDisableUser(Map<String, Object> map,HttpSession session, @PathVariable("userNo") Integer userNo, @PathVariable("enabled") boolean enabled) {
		Teacher teacher = teacherFormService.getteacherById(userNo);
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		map.put("teacher", new Teacher());
		map.put("listTeacher", teacherFormService.listTeacher(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		teacher.setEnabled(enabled);
		teacherFormService.saveTeacher(teacher);
		String str= "Disabled";
		if(enabled){
			str= "Enabled";
		}
		map.put("message", "Admin: "+teacher.getTeacherName()+" is "+str+" Now. ");
		return "teacherForm";

	}


}