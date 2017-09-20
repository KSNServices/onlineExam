

package com.onlineexam.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
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

import com.onlineexam.model.FeeStructure;
import com.onlineexam.model.StudentFeeDetail;
import com.onlineexam.model.Teacher;
import com.onlineexam.model.TeacherPaymentDetail;
import com.onlineexam.model.User;
import com.onlineexam.service.SalaryStructureService;
import com.onlineexam.service.TeacherFormService;
import com.onlineexam.service.TeacherGradeService;
import com.onlineexam.service.TeacherSalaryDetailService;
import com.onlineexam.service.UserService;

@Controller
@RequestMapping("/teacherSalary")
public class TeacherSalaryDetailController {

	@Autowired
	public TeacherSalaryDetailService teacherSalaryDetailService;
	
	@Autowired
	public TeacherFormService teacherFormService;
	
	@Autowired
	public SalaryStructureService salaryStructureService;
	
	@Autowired
	public TeacherGradeService teacherGradeService;
	
	@Autowired
	public UserService userService;


	@InitBinder
	public void bindingPreparation(WebDataBinder binder) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "dob", customDateEditor);
	}

	@RequestMapping(value = "/teacherSalaryInformation")
	public String teacherSalaryInformation(Map<String, Object> map, HttpSession session,HttpServletRequest request) throws Exception {
		map.put("teacherPaymentDetail", new TeacherPaymentDetail());
		TeacherPaymentDetail teacherPaymentDetail = new TeacherPaymentDetail();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		teacherPaymentDetail.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
		teacherPaymentDetail.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
		map.put("teacherPaymentDetail", teacherPaymentDetail);
		
		map.put("listTeacherGrade", teacherGradeService.listTeacherGrade(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		
	if(request.getParameter("message")!=null){
	        	map.put("message", (String)(request.getParameter("message")));
	    }
	    if(request.getParameter("error")!=null){
	    	map.put("showDiv", true);
	    	map.put("error", (String)(request.getParameter("error")));
	    }
		return "teacherSalaryDetail";
	}
	
	@RequestMapping(value = "/teacherFeeErrorMessage/{id}")
	public String teacherFeeErrorMessage(Map<String, Object> map, HttpSession session,@PathVariable String id,HttpServletRequest request) throws Exception {
		TeacherPaymentDetail teacherPaymentDetail = new TeacherPaymentDetail();
		teacherPaymentDetail.setSequenceTeacherId(id);
	    if(request.getParameter("error")!=null){
	    	map.put("showDiv", true);
	    	map.put("teacherPaymentDetail", teacherPaymentDetail);
	    	map.put("error", (String)(request.getParameter("error")));
	    }
		return "teacherSalaryDetail";
	}
	

	@RequestMapping(value = "/getTeacherFeesData/{id}")
	public String getTeacherFeesData(Map<String, Object> map, HttpSession session, @PathVariable String id,HttpServletRequest request) throws Exception {
		//TeacherPaymentDetail teacherDetail =   teacherSalaryDetailService.getTeacherByTeacherId(id);
		
		String[] parts = id.split("@");
		String teacherId = parts[0];
		String teacherGrade = parts[1];
		//TeacherPaymentDetail teacherPaymentDetail = new TeacherPaymentDetail();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
	
		Teacher  teacherDetail  = teacherFormService.getTeacherByTeacherId(teacherId);
		map.put("listTeacherGrade", teacherGradeService.listTeacherGrade(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		
		
		if(teacherDetail == null)
		{
			map.put("showDiv", true);
			map.put("error", "Teacher Id doesn't exist");	
			return "redirect:/teacherSalary/teacherFeeErrorMessage/"+id;
			
		}
		Double totalAmount =  salaryStructureService.sumSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),teacherGrade);
	
		
		
		TeacherPaymentDetail teacherPaymentDetail = new TeacherPaymentDetail();
		teacherPaymentDetail.setTeacherId(teacherDetail);
		teacherPaymentDetail.setSequenceTeacherId(teacherDetail.getTeacherId());
		teacherPaymentDetail.setTeacherGrade(teacherGrade);
		teacherPaymentDetail.setTotalSalary(totalAmount);
		teacherPaymentDetail.setRemainingSalary(totalAmount);
		teacherPaymentDetail.setPaidSalary(0.00);
		
		teacherPaymentDetail.setDuration("12");
		teacherPaymentDetail.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
		teacherPaymentDetail.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
		
		
		TeacherPaymentDetail feeDetail =   teacherSalaryDetailService.getTeacherByTeacherId(teacherId);
		
		
		
		map.put("listTeacherFeeDetails", teacherSalaryDetailService.listTeacherEditSalaryDetails(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),teacherId));
		
	//	StudentFeeDetail	feeDetail = studentFeeDetailService.getStudentByStudentId(id);
		DecimalFormat  format = new DecimalFormat("##########.##");
		
		//studentFeeDetail.setRemainingFee(Double.parseDouble( format.format(feeDetail.getRemainingFee())));
		map.put("showDiv", true);
		if (feeDetail != null)
		{
			if(feeDetail.getRemainingSalary() != null)
			{
			feeDetail.setRemainingSalary(Double.parseDouble( format.format(feeDetail.getRemainingSalary())));
			}else
			{
				feeDetail.setRemainingSalary(feeDetail.getRemainingSalary());
			}
			map.put("teacherPaymentDetail", feeDetail);		
		}
		else
		{
		map.put("teacherPaymentDetail", teacherPaymentDetail);	
		}
		map.put("listTeacherFeeDetails", teacherSalaryDetailService.listTeacherEditSalaryDetails(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),teacherId));
		
		if(request.getParameter("message")!=null){
        	map.put("message", (String)(request.getParameter("message")));
    }
    if(request.getParameter("error")!=null){
    	map.put("error", (String)(request.getParameter("error")));
    }
		return "teacherSalaryDetail";
	}
	
	
	
	@RequestMapping(value = "/saveTeacherSalaryInformation", method = RequestMethod.POST)
	public String saveTeacherSalaryInformation(Map<String, Object> map, HttpSession session,
			@ModelAttribute("teacherPaymentDetail") TeacherPaymentDetail teacherPaymentDetail, @Valid TeacherPaymentDetail teacherPaymentDetailValid, BindingResult result)
					throws Exception {
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		teacherPaymentDetail.setTeacherId(teacherPaymentDetail.getTeacherId());
		if (result.hasErrors()) {
			map.put("teacherPaymentDetail", teacherPaymentDetail);	
			map.put("showDiv", false);
			map.put("listTeacherGrade", teacherGradeService.listTeacherGrade(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
			map.put("message", "Fill all mandatory feilds.");
			return "teacherSalaryDetail";
		} else {
			try {
				if (null == teacherPaymentDetail.getId()) {
					if(teacherPaymentDetail.getTeacherGrade().equals("0"))
					{
						
						map.put("error", "Please enter Teacher Grade");
						return "redirect:/teacherSalary/teacherFeeErrorMessage/"+teacherPaymentDetail.getSequenceTeacherId();
					}else if(teacherPaymentDetail.getStartSession().equals("0"))
					{
						map.put("error", "Please Start Session");
						return "redirect:/teacherSalary/teacherFeeErrorMessage/"+teacherPaymentDetail.getSequenceTeacherId();
						
					}
					teacherSalaryDetailService.saveTeacherSalaryDetail(teacherPaymentDetail);
					map.put("message",teacherPaymentDetail.getSequenceTeacherId()+ "Teacher Detail added sucessfully.");
					return "redirect:/teacherSalary/teacherSalaryInformation";
				} else {
					if(teacherPaymentDetail.getTeacherGrade().equals("0"))
					{
						teacherPaymentDetail.setDuration(teacherPaymentDetail.getDuration());
						map.put("error", "Please enter Teacher Grade");
						return "redirect:/teacherSalary/teacherFeeErrorMessage/"+teacherPaymentDetail.getSequenceTeacherId();
					}else if(teacherPaymentDetail.getStartSession().equals("0"))
					{
						map.put("error", "Please Start Session fee Cycle");
						return "redirect:/teacherSalary/teacherFeeErrorMessage/"+teacherPaymentDetail.getSequenceTeacherId();
						
					}
					teacherSalaryDetailService.saveTeacherSalaryDetail(teacherPaymentDetail);
					map.put("message",teacherPaymentDetail.getSequenceTeacherId()+ "StudentFeeDetail update sucessfully.");
					return "redirect:/teacherSalary/teacherSalaryInformation";
				}
			} catch (Exception exp) {
				exp.printStackTrace();
				map.put("dbError", exp.getMessage());
				map.put("teacherPaymentDetail", new TeacherPaymentDetail());
				map.put("showDiv", false);
				map.put("listTeacherFeeDetails", teacherSalaryDetailService.listTeacherFeeDetails(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
				
				map.put("message", "Cannot add StudentFeeDetail, Already present.");
				return "teacherSalaryDetail";
			}
		}

	}
	
	
	@RequestMapping("/editSalaryComponent/{feeId}")
	public String editSalaryComponent(Map<String, Object> map,HttpSession session, @PathVariable("feeId") Integer feeId) {
		map.put("showDiv", true);
		//FeeStructure feeStructure = new FeeStructure();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		//map.put("feeStructure", teacherSalaryDetailService.);
	
		//map.put("feeStructure", feeStructure);
		//String className =feeStructureService.getFeeById(feeId).getClassName();
		//String section =feeStructureService.getFeeById(feeId).getClassSection();
		//map.put("listFeeStructure", feeStructureService.listFeeStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),className,section));
	
		return "teacherSalaryDetail";
	}
	

	
	//@RequestMapping(value = "/getStudentFeeCalculation/{id}")
	/*public String getStudentFeeCalculation(Map<String, Object> map, HttpSession session, @PathVariable String id) throws Exception {
		String[] parts = id.split("@");
		String studentId = parts[0];
		String cycleofConcession = parts[1];
		String concession = parts[2];
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		Student st =   studentFormService.getStudentByStudentId(studentId);
		StudentFeeDetail feeDetails =   studentFeeDetailService.getStudentByStudentId(studentId);
		Double totalAmount =  feeStructureService.getFeeClass(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),st.getClassName(), st.getClassSection());
		
		Double payTotalAmount = 0.00;
		
		StudentFeeDetail studentFeeDetail = new StudentFeeDetail();
		studentFeeDetail.setStudentId(st);
		studentFeeDetail.setTotalFee(totalAmount);
		studentFeeDetail.setSequenceStudentId(st.getStudentId());
		studentFeeDetail.setConcession(Double.parseDouble( concession));
		//studentFeeDetail.setReasonConcession(reasonConcession);
		studentFeeDetail.setTypeConcession(cycleofConcession);
	
		
		studentFeeDetail.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
		studentFeeDetail.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
		
		if( cycleofConcession.equals("1"))
		{
			payTotalAmount = totalAmount - Double.parseDouble(concession)*12;
		}
		else if(cycleofConcession.equals("2"))
		{
			payTotalAmount = totalAmount - Double.parseDouble(concession)*4;
		}else if(cycleofConcession.equals("3"))
		{
			payTotalAmount = totalAmount - Double.parseDouble(concession)*2;
		}else if(cycleofConcession.equals("4"))
		{
			payTotalAmount = totalAmount - Double.parseDouble(concession);
		}
	Double remainingFee = 0.00;
	Double paidFee = 0.00;
	DecimalFormat  format = new DecimalFormat("##########.###");
		if(feeDetails != null )
		{
			if(feeDetails.getRemainingFee() != null)
			{
				remainingFee = feeDetails.getRemainingFee();
		studentFeeDetail.setRemainingFee(Double.parseDouble( format.format(remainingFee)));
			}
		else {
	
				studentFeeDetail.setRemainingFee(Double.parseDouble( format.format(remainingFee)));
			}
			
			if(feeDetails.getPaidFee() != null)
			{
				paidFee = feeDetails.getPaidFee();
				studentFeeDetail.setPaidFee(paidFee);	
			}
			else{
				studentFeeDetail.setPaidFee(0.00);
			}
		}
		
		if (remainingFee + paidFee != payTotalAmount)
		{
			remainingFee = payTotalAmount - paidFee;
			studentFeeDetail.setRemainingFee(Double.parseDouble( format.format(remainingFee)));
			//feeDetails.setRemainingFee(remainingFee);
		}
		
	
		studentFeeDetail.setPaidByStudent(payTotalAmount);
		
		map.put("showDiv", true);
		if (feeDetails != null)
		{
			//feeDetails.setPaidByStudent(payTotalAmount);
			//feeDetails.setTypeConcession(cycleofConcession);
			studentFeeDetail.setId(feeDetails.getId());
			map.put("studentFeeDetail", studentFeeDetail);		
		}
		else
		{
		map.put("studentFeeDetail", studentFeeDetail);	
		}
		map.put("showDiv", true);
		//map.put("studentFeeDetail", studentFeeDetail);		
		map.put("listStudentFeeDetail", studentFeeDetailService.listStudentFeeDetail(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		return "studentFeeDetail";
	}
	*/


}