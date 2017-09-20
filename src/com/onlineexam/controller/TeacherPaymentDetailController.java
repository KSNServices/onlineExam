

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

import com.onlineexam.model.StudentFeeDetail;
import com.onlineexam.model.Teacher;
import com.onlineexam.model.TeacherPaymentDetail;
import com.onlineexam.model.User;
import com.onlineexam.service.AdditionalSalaryComponentService;
import com.onlineexam.service.SalaryStructureService;
import com.onlineexam.service.TeacherFormService;
import com.onlineexam.service.TeacherSalaryDetailService;
import com.onlineexam.service.UserService;

@Controller
@RequestMapping("/teacherPayment")
public class TeacherPaymentDetailController {

	@Autowired
	public TeacherSalaryDetailService teacherSalaryDetailService;
	
	@Autowired
	public TeacherFormService teacherFormService;
	
	@Autowired
	public SalaryStructureService salaryStructureService;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public AdditionalSalaryComponentService additionalSalaryComponentService;

	@InitBinder
	public void bindingPreparation(WebDataBinder binder) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "dob", customDateEditor);
	}

	@RequestMapping(value = "/teacherPayementInformation")
	public String teacherSalaryInformation(Map<String, Object> map, HttpSession session,HttpServletRequest request) throws Exception {
		map.put("teacherPaymentDetail", new TeacherPaymentDetail());
		TeacherPaymentDetail teacherPaymentDetail = new TeacherPaymentDetail();
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		teacherPaymentDetail.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
		teacherPaymentDetail.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
		map.put("teacherPaymentDetail", teacherPaymentDetail);
		map.put("listTeacherFeeDetails", teacherSalaryDetailService.listTeacherFeeDetails(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		if(request.getParameter("message")!=null){
	        	map.put("message", (String)(request.getParameter("message")));
	    }
	    if(request.getParameter("error")!=null){
	    	map.put("showDiv", true);
	    	map.put("error", (String)(request.getParameter("error")));
	    }
		return "teacherPaymentDetail";
	}
	
	@RequestMapping(value = "/teacherFeeErrorMessage/{id}")
	public String teacherFeeErrorMessage(Map<String, Object> map, HttpSession session,@PathVariable String id,HttpServletRequest request) throws Exception {
		TeacherPaymentDetail teacherPaymentDetail = new TeacherPaymentDetail();
		teacherPaymentDetail.setSequenceTeacherId(id);;;
	    if(request.getParameter("error")!=null){
	    	map.put("showDiv", true);
	    	map.put("teacherPaymentDetail", teacherPaymentDetail);
	    	map.put("error", (String)(request.getParameter("error")));
	    }
		return "teacherPaymentDetail";
	}
	

	
	
	@RequestMapping(value = "/saveTeacherPaymentInformation", method = RequestMethod.POST)
	public String saveTeacherSalaryInformation(Map<String, Object> map, HttpSession session,
			@ModelAttribute("teacherPaymentDetail") TeacherPaymentDetail teacherPaymentDetail, @Valid TeacherPaymentDetail teacherPaymentDetailValid, BindingResult result)
					throws Exception {
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
		teacherPaymentDetail.setTeacherId(teacherPaymentDetail.getTeacherId());
		if (result.hasErrors()) {
			map.put("teacherPaymentDetail", new TeacherPaymentDetail());
			map.put("showDiv", false);
			map.put("listTeacherFeeDetails", teacherSalaryDetailService.listTeacherFeeDetails(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
			map.put("message", "Fill all mandatory feilds.");
			return "teacherPaymentDetail";
		} else {
			try {
				if (null == teacherPaymentDetail.getId()) {
					if(teacherPaymentDetail.getDuration().equals("0"))
					{
						
						map.put("error", "Please add payment fee Cycle");
						return "redirect:/teacherPayment/teacherFeeErrorMessage/"+teacherPaymentDetail.getSequenceTeacherId();
					}
					teacherSalaryDetailService.saveTeacherSalaryDetail(teacherPaymentDetail);
					map.put("message",teacherPaymentDetail.getSequenceTeacherId()+ "StudentFeeDetail added sucessfully.");
					return "redirect:/teacherPayment/teacherPaymentDetail";
				} else {
					if(teacherPaymentDetail.getDuration().equals("0"))
					{
						teacherPaymentDetail.setDuration(teacherPaymentDetail.getDuration());
						map.put("error", "Please add payment fee Cycle");
						return "redirect:/teacherPayment/teacherFeeErrorMessage/"+teacherPaymentDetail.getSequenceTeacherId();
					}
					teacherSalaryDetailService.saveTeacherSalaryDetail(teacherPaymentDetail);
					map.put("message",teacherPaymentDetail.getSequenceTeacherId()+ "Teacher Payment update sucessfully.");
					return "redirect:/teacherPayment/teacherPayementInformation";
				}
			} catch (Exception exp) {
				exp.printStackTrace();
				map.put("dbError", exp.getMessage());
				map.put("teacherPaymentDetail", new TeacherPaymentDetail());
				map.put("showDiv", false);
				map.put("listTeacherFeeDetails", teacherSalaryDetailService.listTeacherFeeDetails(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
				
				map.put("message", "Cannot add StudentFeeDetail, Already present.");
				return "teacherPaymentDetail";
			}
		}

	}
	
	@RequestMapping(value = "/getTeacherPaymentValue/{id}")
	public String getTeacherPaymentValue(Map<String, Object> map, HttpSession session, @PathVariable String id,HttpServletRequest request) throws Exception {
		//TeacherPaymentDetail teacherDetail =   teacherSalaryDetailService.getTeacherByTeacherId(id);
	
		String teacherId = id;
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		
	
		TeacherPaymentDetail feeDetail =   teacherSalaryDetailService.getTeacherByTeacherId(teacherId);
		
		if(feeDetail == null)
		{
			map.put("showDiv", true);
			map.put("error", "Please enter Teacher Salary Details");	
			return "redirect:/teacherPayment/teacherFeeErrorMessage/"+id;
			
		}
		Integer startSession =0;
		if(feeDetail.getStartSession() != null && !feeDetail.getStartSession().equals(""))
		{
		startSession = Integer.parseInt( 	feeDetail.getStartSession());
		}
		String mon1 = "January";
		String mon2 = "February";
		String mon3 = "March";
		String mon4 = "April";
		String mon5 = "May";
		String mon6 = "June";
		String mon7 = "July";
		String mon8 = "August";
		String mon9 = "September";
		String mon10 = "October";
		String mon11 = "November";
		String mon12 = "December";


		if (startSession == 1) {

			mon1 = "January";
			mon2 = "February";
			mon3 = "March";
			mon4 = "April";
			mon5 = "May";
			mon6 = "June";
			mon7 = "July";
			mon8 = "August";
			mon9 = "September";
			mon10 = "October";
			mon11 = "November";
			mon12 = "December";
		} else if (startSession == 2) {
			mon12 = "January";
			mon1 = "February";
			mon2 = "March";
			mon3 = "April";
			mon4 = "May";
			mon5 = "June";
			mon6 = "July";
			mon7 = "August";
			mon8 = "September";
			mon9 = "October";
			mon10 = "November";
			mon11 = "December";
		} else if (startSession == 3) {
			mon11 = "January";
			mon12 = "February";
			mon1 = "March";
			mon2 = "April";
			mon3 = "May";
			mon4 = "June";
			mon5 = "July";
			mon6 = "August";
			mon7 = "September";
			mon8 = "October";
			mon9 = "November";
			mon10 = "December";
		} else if (startSession == 4) {
			mon10 = "January";
			mon11 = "February";
			mon12 = "March";
			mon1 = "April";
			mon2 = "May";
			mon3 = "June";
			mon4 = "July";
			mon5 = "August";
			mon6 = "September";
			mon7 = "October";
			mon8 = "November";
			mon9 = "December";
		} else if (startSession == 5) {
			mon9 = "January";
			mon10 = "February";
			mon11 = "March";
			mon12 = "April";
			mon1 = "May";
			mon2 = "June";
			mon3 = "July";
			mon4 = "August";
			mon5 = "September";
			mon6 = "October";
			mon7 = "November";
			mon8 = "December";
		} else if (startSession == 6) {
			mon8 = "January";
			mon9 = "February";
			mon10 = "March";
			mon11 = "April";
			mon12 = "May";
			mon1 = "June";
			mon2 = "July";
			mon3 = "August";
			mon4 = "September";
			mon5 = "October";
			mon6 = "November";
			mon7 = "December";
		} else if (startSession == 7) {
			mon7 = "January";
			mon8 = "February";
			mon9 = "March";
			mon10 = "April";
			mon11 = "May";
			mon12 = "June";
			mon1 = "July";
			mon2 = "August";
			mon3 = "September";
			mon4 = "October";
			mon5 = "November";
			mon6 = "December";
		} else if (startSession == 8) {
			mon6 = "January";
			mon7 = "February";
			mon8 = "March";
			mon9 = "April";
			mon10 = "May";
			mon11 = "June";
			mon12 = "July";
			mon1 = "August";
			mon2 = "September";
			mon3 = "October";
			mon4 = "November";
			mon5 = "December";
		} else if (startSession == 9) {
			mon5 = "January";
			mon6 = "February";
			mon7 = "March";
			mon8 = "April";
			mon9 = "May";
			mon10 = "June";
			mon11 = "July";
			mon12 = "August";
			mon1 = "September";
			mon2 = "October";
			mon3 = "November";
			mon4 = "December";
		} else if (startSession == 10) {
			mon4 = "January";
			mon5 = "February";
			mon6 = "March";
			mon7 = "April";
			mon8 = "May";
			mon9 = "June";
			mon10 = "July";
			mon11 = "August";
			mon12 = "September";
			mon1 = "October";
			mon2 = "November";
			mon3 = "December";
		} else if (startSession == 11) {
			mon3 = "January";
			mon4 = "February";
			mon5 = "March";
			mon6 = "April";
			mon7 = "May";
			mon8 = "June";
			mon9 = "July";
			mon10 = "August";
			mon11 = "September";
			mon12 = "October";
			mon1 = "November";
			mon2 = "December";
		} else if (startSession == 12) {
			mon2 = "January";
			mon3 = "February";
			mon4 = "March";
			mon5 = "April";
			mon6 = "May";
			mon7 = "June";
			mon8 = "July";
			mon9 = "August";
			mon10 = "September";
			mon11 = "October";
			mon12 = "November";
			mon1 = "December";
		}

		String intallment =  feeDetail.getDuration() ;
		DecimalFormat  format = new DecimalFormat("##########.##");
		
		Double amountSalary = salaryStructureService.sumSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), feeDetail.getTeacherGrade());
		
		Double amountSalaryMonth =Double.parseDouble( format.format( amountSalary/12));
		
		if(intallment.equals("12"))
		{
			//Double intallAmount = Double.parseDouble( format.format( totalamountPaidByStudent/12));
			if(feeDetail.getRemainingSalary().equals(feeDetail.getTotalSalary()))
			{
				feeDetail.setInstallmentMonth( mon1);
				feeDetail.setInstallmentNumber(1);
				Double totalSalary =0.00;
				Double additionalSalary = additionalSalaryComponentService.sumAdditionalMonthSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), feeDetail.getSequenceTeacherId(), mon1);
				if (additionalSalary != null)
					totalSalary = amountSalaryMonth + additionalSalary;
				else
				{
					totalSalary = amountSalaryMonth;
					additionalSalary =0.00;
				}
				feeDetail.setAdditionalAmount(additionalSalary);
				feeDetail.setTotalAmountMonth(totalSalary);
				feeDetail.setRemainingSalary(amountSalary-amountSalaryMonth);
				feeDetail.setPaidSalary(amountSalaryMonth);
				
			}
			else if(feeDetail.getInstallmentNumber()==1)
			{
				feeDetail.setInstallmentMonth( mon2);
				feeDetail.setInstallmentNumber(2);
				Double totalSalary =0.00;
				Double additionalSalary = additionalSalaryComponentService.sumAdditionalMonthSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), feeDetail.getSequenceTeacherId(), mon2);
				if (additionalSalary != null)
					totalSalary = amountSalaryMonth + additionalSalary;
				else
				{
					totalSalary = amountSalaryMonth;
					additionalSalary =0.00;
				}
				feeDetail.setAdditionalAmount(additionalSalary);
				feeDetail.setTotalAmountMonth(totalSalary);
				feeDetail.setRemainingSalary(amountSalary-2*amountSalaryMonth);
				feeDetail.setPaidSalary(2*amountSalaryMonth);
			}
			else if(feeDetail.getInstallmentNumber()==2)
			{ 
				feeDetail.setInstallmentMonth( mon3);
				feeDetail.setInstallmentNumber(3);
				Double totalSalary =0.00;
				Double additionalSalary = additionalSalaryComponentService.sumAdditionalMonthSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), feeDetail.getSequenceTeacherId(), mon3);
				if (additionalSalary != null)
					totalSalary = amountSalaryMonth + additionalSalary;
				else
				{
					totalSalary = amountSalaryMonth;
					additionalSalary =0.00;
				}
				feeDetail.setAdditionalAmount(additionalSalary);
				feeDetail.setTotalAmountMonth(totalSalary);
				feeDetail.setRemainingSalary(amountSalary-3*amountSalaryMonth);
				feeDetail.setPaidSalary(3*amountSalaryMonth);
			}
			else if(feeDetail.getInstallmentNumber()==3)
			{
				feeDetail.setInstallmentMonth( mon4);
				feeDetail.setInstallmentNumber(4);
				Double totalSalary =0.00;
				Double additionalSalary = additionalSalaryComponentService.sumAdditionalMonthSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), feeDetail.getSequenceTeacherId(), mon4);
				if (additionalSalary != null)
					totalSalary = amountSalaryMonth + additionalSalary;
				else
				{
					totalSalary = amountSalaryMonth;
					additionalSalary =0.00;
				}
				feeDetail.setAdditionalAmount(additionalSalary);
				feeDetail.setTotalAmountMonth(totalSalary);
				feeDetail.setRemainingSalary(amountSalary-4*amountSalaryMonth);
				feeDetail.setPaidSalary(4*amountSalaryMonth);
			}
			else if(feeDetail.getInstallmentNumber()==4)
			{
				feeDetail.setInstallmentMonth( mon5);
				feeDetail.setInstallmentNumber(5);
				Double totalSalary =0.00;
				Double additionalSalary = additionalSalaryComponentService.sumAdditionalMonthSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), feeDetail.getSequenceTeacherId(), mon5);
				if (additionalSalary != null)
					totalSalary = amountSalaryMonth + additionalSalary;
				else
				{
					totalSalary = amountSalaryMonth;
					additionalSalary =0.00;
				}
				feeDetail.setAdditionalAmount(additionalSalary);
				feeDetail.setTotalAmountMonth(totalSalary);
				feeDetail.setRemainingSalary(amountSalary-5*amountSalaryMonth);
				feeDetail.setPaidSalary(5*amountSalaryMonth);
				
			}
			else if(feeDetail.getInstallmentNumber()==5)
			{
				feeDetail.setInstallmentMonth( mon6);
				feeDetail.setInstallmentNumber(6);
				Double totalSalary =0.00;
				Double additionalSalary = additionalSalaryComponentService.sumAdditionalMonthSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), feeDetail.getSequenceTeacherId(), mon6);
				if (additionalSalary != null)
					totalSalary = amountSalaryMonth + additionalSalary;
				else
				{
					totalSalary = amountSalaryMonth;
					additionalSalary =0.00;
				}
				feeDetail.setAdditionalAmount(additionalSalary);
				feeDetail.setTotalAmountMonth(totalSalary);
				feeDetail.setRemainingSalary(amountSalary-6*amountSalaryMonth);
				feeDetail.setPaidSalary(6*amountSalaryMonth);
			}
			else if(feeDetail.getInstallmentNumber()==6)
			{
				feeDetail.setInstallmentMonth( mon7);
				feeDetail.setInstallmentNumber(7);
				Double totalSalary =0.00;
				Double additionalSalary = additionalSalaryComponentService.sumAdditionalMonthSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), feeDetail.getSequenceTeacherId(), mon7);
				if (additionalSalary != null)
					totalSalary = amountSalaryMonth + additionalSalary;
				else
				{
					totalSalary = amountSalaryMonth;
					additionalSalary =0.00;
				}
				feeDetail.setAdditionalAmount(additionalSalary);
				feeDetail.setTotalAmountMonth(totalSalary);
				feeDetail.setRemainingSalary(amountSalary-7*amountSalaryMonth);
				feeDetail.setPaidSalary(7*amountSalaryMonth);
			}
			else if(feeDetail.getInstallmentNumber()==7)
			{
				feeDetail.setInstallmentMonth( mon8);
				feeDetail.setInstallmentNumber(8);
				Double totalSalary =0.00;
				Double additionalSalary = additionalSalaryComponentService.sumAdditionalMonthSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), feeDetail.getSequenceTeacherId(), mon8);
				if (additionalSalary != null)
					totalSalary = amountSalaryMonth + additionalSalary;
				else
				{
					totalSalary = amountSalaryMonth;
					additionalSalary =0.00;
				}
				feeDetail.setAdditionalAmount(additionalSalary);
				feeDetail.setTotalAmountMonth(totalSalary);
				feeDetail.setRemainingSalary(amountSalary-8*amountSalaryMonth);
				feeDetail.setPaidSalary(8*amountSalaryMonth);
			}
			else if(feeDetail.getInstallmentNumber()==8)
			{
				feeDetail.setInstallmentMonth( mon9);
				feeDetail.setInstallmentNumber(9);
				Double totalSalary =0.00;
				Double additionalSalary = additionalSalaryComponentService.sumAdditionalMonthSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), feeDetail.getSequenceTeacherId(), mon9);
				if (additionalSalary != null)
					totalSalary = amountSalaryMonth + additionalSalary;
				else
				{
					totalSalary = amountSalaryMonth;
					additionalSalary =0.00;
				}
				feeDetail.setAdditionalAmount(additionalSalary);
				feeDetail.setTotalAmountMonth(totalSalary);
				feeDetail.setRemainingSalary(amountSalary-9*amountSalaryMonth);
				feeDetail.setPaidSalary((9*amountSalaryMonth));
			}
			else if(feeDetail.getInstallmentNumber()==9)
			{
				feeDetail.setInstallmentMonth( mon10);
				feeDetail.setInstallmentNumber(10);
				Double totalSalary =0.00;
				Double additionalSalary = additionalSalaryComponentService.sumAdditionalMonthSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), feeDetail.getSequenceTeacherId(), mon10);
				if (additionalSalary != null)
					totalSalary = amountSalaryMonth + additionalSalary;
				else
				{
					totalSalary = amountSalaryMonth;
					additionalSalary =0.00;
				}
				feeDetail.setAdditionalAmount(additionalSalary);
				feeDetail.setTotalAmountMonth(totalSalary);
				feeDetail.setRemainingSalary(amountSalary-10*amountSalaryMonth);
				feeDetail.setPaidSalary(10*amountSalaryMonth);
			}
			else if(feeDetail.getInstallmentNumber()==10)
			{
				feeDetail.setInstallmentMonth( mon11);
				feeDetail.setInstallmentNumber(11);
				Double totalSalary =0.00;
				Double additionalSalary = additionalSalaryComponentService.sumAdditionalMonthSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), feeDetail.getSequenceTeacherId(), mon11);
				if (additionalSalary != null)
					totalSalary = amountSalaryMonth + additionalSalary;
				else
				{
					totalSalary = amountSalaryMonth;
					additionalSalary =0.00;
				}
				feeDetail.setAdditionalAmount(additionalSalary);
				feeDetail.setTotalAmountMonth(totalSalary);
				feeDetail.setRemainingSalary(amountSalary-11*amountSalaryMonth);
				feeDetail.setPaidSalary(11*amountSalaryMonth);
			}
			else if(feeDetail.getInstallmentNumber()==11)
			{
				feeDetail.setInstallmentMonth( mon12);
				feeDetail.setInstallmentNumber(12);
				feeDetail.setRemainingSalary(0.00);
				Double totalSalary =0.00;
				Double additionalSalary = additionalSalaryComponentService.sumAdditionalMonthSalaryStructure(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), feeDetail.getSequenceTeacherId(), mon12);
				if (additionalSalary != null)
					totalSalary = amountSalaryMonth + additionalSalary;
				else
				{
					totalSalary = amountSalaryMonth;
					additionalSalary =0.00;
				}
				feeDetail.setAdditionalAmount(additionalSalary);
				feeDetail.setTotalAmountMonth(totalSalary);
				feeDetail.setRemainingSalary(amountSalary-12*amountSalaryMonth);
				feeDetail.setPaidSalary(12*amountSalaryMonth);
			}

		}
		
		
		
		map.put("teacherPaymentDetail", feeDetail);
		

		map.put("showDiv", true);
	
		map.put("listTeacherFeeDetails", teacherSalaryDetailService.listTeacherEditSalaryDetails(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),teacherId));
		
	if(request.getParameter("message")!=null){
      map.put("message", (String)(request.getParameter("message")));
    }
    if(request.getParameter("error")!=null){
    	map.put("error", (String)(request.getParameter("error")));
    }
		return "teacherPaymentDetail";
	}
	
	



}