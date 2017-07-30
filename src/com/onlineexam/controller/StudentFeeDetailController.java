package com.onlineexam.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import com.onlineexam.model.Student;
import com.onlineexam.model.StudentFeeDetail;
import com.onlineexam.model.User;
import com.onlineexam.service.FeeStructureService;
import com.onlineexam.service.StudentFeeDetailService;
import com.onlineexam.service.StudentFormService;
import com.onlineexam.service.UserService;

@Controller
@RequestMapping("/feeDetail")
public class StudentFeeDetailController {

	@Autowired
	public StudentFeeDetailService studentFeeDetailService;
	
	@Autowired
	public StudentFormService studentFormService;
	
	@Autowired
	public UserService userService;

	
	@Autowired
	public FeeStructureService feeStructureService;
	

	@InitBinder
	public void bindingPreparation(WebDataBinder binder) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "dob", customDateEditor);
	}

	@RequestMapping(value = "/studentFeeInformation")
	public String studentFeeInformation(Map<String, Object> map, HttpSession session,HttpServletRequest request) throws Exception {
		map.put("studentFeeDetail", new StudentFeeDetail());
		StudentFeeDetail studentFeeDetail = new StudentFeeDetail();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		studentFeeDetail.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
		studentFeeDetail.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
		map.put("studentFeeDetail", studentFeeDetail);
		map.put("listStudentFeeDetail", studentFeeDetailService.listStudentFeeDetail(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		if(request.getParameter("message")!=null){
	        	map.put("message", (String)(request.getParameter("message")));
	    }
	    if(request.getParameter("error")!=null){
	    	map.put("showDiv", true);
	    	map.put("error", (String)(request.getParameter("error")));
	    }
		return "studentFeeDetail";
	}
	
	@RequestMapping(value = "/studentFeeErrorMessage/{id}")
	public String studentFeeErrorMessage(Map<String, Object> map, HttpSession session,@PathVariable String id,HttpServletRequest request) throws Exception {
		StudentFeeDetail studentFeeDetail = new StudentFeeDetail();
		studentFeeDetail.setSequenceStudentId(id);
	    if(request.getParameter("error")!=null){
	    	map.put("showDiv", true);
	    	map.put("studentFeeDetail", studentFeeDetail);
	    	map.put("error", (String)(request.getParameter("error")));
	    }
		return "studentFeeDetail";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/getStudentFeesData/{id}")
	public String getStudentFeesData(Map<String, Object> map, HttpSession session, @PathVariable String id,HttpServletRequest request) throws Exception {
		Student st =   studentFormService.getStudentByStudentId(id);
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		if(st == null)
		{
			map.put("showDiv", true);
			map.put("error", "Student Id doesn't exist");	
			return "redirect:/feeDetail/studentFeeErrorMessage/"+id;
			
		}
		Double totalAmount =  feeStructureService.getFeeClass(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),st.getClassName(), st.getClassSection());
	
		
		
		StudentFeeDetail studentFeeDetail = new StudentFeeDetail();
		studentFeeDetail.setStudentId(st);
		studentFeeDetail.setSequenceStudentId(st.getStudentId());
		
		studentFeeDetail.setTotalFee(totalAmount);
		studentFeeDetail.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
		studentFeeDetail.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
		StudentFeeDetail	feeDetail = studentFeeDetailService.getStudentByStudentId(id);
		DecimalFormat  format = new DecimalFormat("##########.##");
		
		//studentFeeDetail.setRemainingFee(Double.parseDouble( format.format(feeDetail.getRemainingFee())));
		map.put("showDiv", true);
		if (feeDetail != null)
		{
			if(feeDetail.getRemainingFee() != null)
			{
			feeDetail.setRemainingFee(Double.parseDouble( format.format(feeDetail.getRemainingFee())));
			}else
			{
				feeDetail.setRemainingFee(feeDetail.getRemainingFee());
			}
			map.put("studentFeeDetail", feeDetail);		
		}
		else
		{
		map.put("studentFeeDetail", studentFeeDetail);	
		}
		map.put("listStudentEditFeeDetails", studentFeeDetailService.listStudentEditFeeDetails(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), id));
		
		if(request.getParameter("message")!=null){
        	map.put("message", (String)(request.getParameter("message")));
    }
    if(request.getParameter("error")!=null){
    	map.put("error", (String)(request.getParameter("error")));
    }
		return "studentFeeDetail";
	}
	
	
	
	@RequestMapping(value = "/saveStudentFeeInformation", method = RequestMethod.POST)
	public String studentFeeInformationSave(Map<String, Object> map, HttpSession session,
			@ModelAttribute("studentFeeDetail") StudentFeeDetail studentFeeDetail, @Valid StudentFeeDetail studentFeeDetailValid, BindingResult result)
					throws Exception {
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		studentFeeDetail.setStudentId(studentFeeDetail.getStudentId());
		if (result.hasErrors()) {
			map.put("studentFeeDetail", new StudentFeeDetail());
			map.put("showDiv", false);
			map.put("listStudentFeeDetail", studentFeeDetailService.listStudentFeeDetail(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
			map.put("message", "Fill all mandatory feilds.");
			return "studentFeeDetail";
		} else {
			try {
				if (null == studentFeeDetail.getId()) {
					if(studentFeeDetail.getDuration().equals("0"))
					{
						
						map.put("error", "Please add payment fee Cycle");
						return "redirect:/feeDetail/getStudentFeesData/"+studentFeeDetail.getSequenceStudentId();
					}else if(studentFeeDetail.getTypeConcession().equals("0"))
					{
						map.put("error", "Please add Cycle of Concession");
						return "redirect:/feeDetail/getStudentFeesData/"+studentFeeDetail.getSequenceStudentId();
					}
					studentFeeDetailService.saveStudentFeeDetail(studentFeeDetail);
					map.put("message",studentFeeDetail.getSequenceStudentId()+ "StudentFeeDetail added sucessfully.");
					return "redirect:/feeDetail/studentFeeInformation";
				} else {
					if(studentFeeDetail.getDuration().equals("0"))
					{
						studentFeeDetail.setDuration(studentFeeDetail.getDuration());
						map.put("error", "Please add payment fee Cycle");
						return "redirect:/feeDetail/getStudentFeesData/"+studentFeeDetail.getSequenceStudentId();
					}else if(studentFeeDetail.getTypeConcession().equals("0"))
					{
						map.put("error", "Please add Cycle of Concession");
						return "redirect:/feeDetail/getStudentFeesData/"+studentFeeDetail.getSequenceStudentId();
					}
					studentFeeDetailService.saveStudentFeeDetail(studentFeeDetail);
					map.put("message",studentFeeDetail.getSequenceStudentId()+ "StudentFeeDetail update sucessfully.");
					return "redirect:/feeDetail/studentFeeInformation";
				}
			} catch (Exception exp) {
				exp.printStackTrace();
				map.put("dbError", exp.getMessage());
				map.put("studentFeeDetail", new StudentFeeDetail());
				map.put("showDiv", false);
				map.put("listStudentFeeDetail", studentFeeDetailService.listStudentFeeDetail(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));

				map.put("message", "Cannot add StudentFeeDetail, Already present.");
				return "studentFeeDetail";
			}
		}

	}
	
	
	
	@RequestMapping(value = "/getStudentFeeCalculation/{id}")
	public String getStudentFeeCalculation(Map<String, Object> map, HttpSession session, @PathVariable String id) throws Exception {
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
	


}