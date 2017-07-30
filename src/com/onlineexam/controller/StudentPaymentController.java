

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
@RequestMapping("/paymentDetail")
public class StudentPaymentController {

	@Autowired
	public StudentFeeDetailService studentFeeDetailService;

	@Autowired
	public StudentFormService studentFormService;

	@Autowired
	public FeeStructureService feeStructureService;


	@Autowired
	public UserService userService;


	@InitBinder
	public void bindingPreparation(WebDataBinder binder) throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, "dob", customDateEditor);
	}

	@RequestMapping(value = "/studentPaymentInformation")
	public String studentPaymentInformation(Map<String, Object> map, HttpSession session ,HttpServletRequest request) throws Exception {

		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		map.put("studentFeeDetail", new StudentFeeDetail());
		map.put("listStudentFeeDetail", studentFeeDetailService.listStudentFeeDetail(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		if(request.getParameter("message")!=null){
			map.put("message", (String)(request.getParameter("message")));
		}
		if(request.getParameter("error")!=null){
			map.put("showDiv", true);
			map.put("error", (String)(request.getParameter("error")));
		}


		return "studentPayment";
	}


	@RequestMapping(value = "/getStudentFeesData/{id}")
	public String getStudentFeesData(Map<String, Object> map, HttpSession session, @PathVariable String id,HttpServletRequest request) throws Exception {
		//Student st =   studentFormService.getStudentByStudentId(id);
		StudentFeeDetail feeDetails =   studentFeeDetailService.getStudentByStudentId(id);
		StudentFeeDetail feeDetailValue =   studentFeeDetailService.getStudentByStudentId(id);
		if(feeDetails == null)
		{
			map.put("showDiv", true);
			map.put("error", "Student Id doesn't exist");	
			return "redirect:/paymentDetail/studentPaymentInformation";

		}
		//Double totalAmount =  feeStructureService.getFeeClass(st.getClassName(), st.getClassSection());
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();


		//	StudentFeeDetail studentFeeDetail = new StudentFeeDetail();
		//studentFeeDetail.setStudentId(st);
		//studentFeeDetail.setTotalFee(totalAmount);
		//studentFeeDetail.setSequenceStudentId(st.getStudentId());
		//studentFeeDetail.setPaidByStudent(feeDetails.getPaidByStudent());
		//studentFeeDetail.setDuration(feeDetails.getDuration());
		//studentFeeDetail.setTotalFee(totalAmount);
		//studentFeeDetail.setAdminId(userService.getUserById(Integer.parseInt(adminIdString)));
		//studentFeeDetail.setSchoolId(userService.getUserById(Integer.parseInt(schoolIdString)));
		DecimalFormat  format = new DecimalFormat("##########.###");
		Double totalamountPaidByStudent = Double.parseDouble( format.format( feeDetails.getPaidByStudent()));
		Double remainingAmount =Double.parseDouble( format.format(  feeDetails.getRemainingFee()));
		String intallment =  feeDetails.getDuration() ;


		//StudentFeeDetail feeDetails =   studentFeeDetailService.getStudentByStudentId(id);
		if(feeDetails != null)
		{
			Integer startSession =0;
			if(feeDetails.getStartSession() != null && !feeDetails.getStartSession().equals(""))
			{
			startSession = Integer.parseInt( 	feeDetails.getStartSession());
			}
			String mon1 = "january";
			String mon2 = "february";
			String mon3 = "march";
			String mon4 = "April";
			String mon5 = "may";
			String mon6 = "june";
			String mon7 = "july";
			String mon8 = "August";
			String mon9 = "September";
			String mon10 = "October";
			String mon11 = "November";
			String mon12 = "december";


			if (startSession == 1) {

				mon1 = "january";
				mon2 = "february";
				mon3 = "march";
				mon4 = "April";
				mon5 = "may";
				mon6 = "june";
				mon7 = "july";
				mon8 = "August";
				mon9 = "September";
				mon10 = "October";
				mon11 = "November";
				mon12 = "december";
			} else if (startSession == 2) {
				mon12 = "january";
				mon1 = "february";
				mon2 = "march";
				mon3 = "April";
				mon4 = "may";
				mon5 = "june";
				mon6 = "july";
				mon7 = "August";
				mon8 = "September";
				mon9 = "October";
				mon10 = "November";
				mon11 = "december";
			} else if (startSession == 3) {
				mon11 = "january";
				mon12 = "february";
				mon1 = "march";
				mon2 = "April";
				mon3 = "may";
				mon4 = "june";
				mon5 = "july";
				mon6 = "August";
				mon7 = "September";
				mon8 = "October";
				mon9 = "November";
				mon10 = "december";
			} else if (startSession == 4) {
				mon10 = "january";
				mon11 = "february";
				mon12 = "march";
				mon1 = "April";
				mon2 = "may";
				mon3 = "june";
				mon4 = "july";
				mon5 = "August";
				mon6 = "September";
				mon7 = "October";
				mon8 = "November";
				mon9 = "december";
			} else if (startSession == 5) {
				mon9 = "january";
				mon10 = "february";
				mon11 = "march";
				mon12 = "April";
				mon1 = "may";
				mon2 = "june";
				mon3 = "july";
				mon4 = "August";
				mon5 = "September";
				mon6 = "October";
				mon7 = "November";
				mon8 = "december";
			} else if (startSession == 6) {
				mon8 = "january";
				mon9 = "february";
				mon10 = "march";
				mon11 = "April";
				mon12 = "may";
				mon1 = "june";
				mon2 = "july";
				mon3 = "August";
				mon4 = "September";
				mon5 = "October";
				mon6 = "November";
				mon7 = "december";
			} else if (startSession == 7) {
				mon7 = "january";
				mon8 = "february";
				mon9 = "march";
				mon10 = "April";
				mon11 = "may";
				mon12 = "june";
				mon1 = "july";
				mon2 = "August";
				mon3 = "September";
				mon4 = "October";
				mon5 = "November";
				mon6 = "december";
			} else if (startSession == 8) {
				mon6 = "january";
				mon7 = "february";
				mon8 = "march";
				mon9 = "April";
				mon10 = "may";
				mon11 = "june";
				mon12 = "july";
				mon1 = "August";
				mon2 = "September";
				mon3 = "October";
				mon4 = "November";
				mon5 = "december";
			} else if (startSession == 9) {
				mon5 = "january";
				mon6 = "february";
				mon7 = "march";
				mon8 = "April";
				mon9 = "may";
				mon10 = "june";
				mon11 = "july";
				mon12 = "August";
				mon1 = "September";
				mon2 = "October";
				mon3 = "November";
				mon4 = "december";
			} else if (startSession == 10) {
				mon4 = "january";
				mon5 = "february";
				mon6 = "march";
				mon7 = "April";
				mon8 = "may";
				mon9 = "june";
				mon10 = "july";
				mon11 = "August";
				mon12 = "September";
				mon1 = "October";
				mon2 = "November";
				mon3 = "december";
			} else if (startSession == 11) {
				mon3 = "january";
				mon4 = "february";
				mon5 = "march";
				mon6 = "April";
				mon7 = "may";
				mon8 = "june";
				mon9 = "july";
				mon10 = "August";
				mon11 = "September";
				mon12 = "October";
				mon1 = "November";
				mon2 = "december";
			} else if (startSession == 12) {
				mon2 = "january";
				mon3 = "february";
				mon4 = "march";
				mon5 = "April";
				mon6 = "may";
				mon7 = "june";
				mon8 = "july";
				mon9 = "August";
				mon10 = "September";
				mon11 = "October";
				mon12 = "November";
				mon1 = "december";
			}














			if(intallment.equals("4"))
			{
				//Double intallAmount = Double.parseDouble( format.format( totalamountPaidByStudent/4));
				if(remainingAmount.equals(totalamountPaidByStudent))
				{
					feeDetails.setInstallmentNumber(1);
					feeDetails.setInstallmentMonth( mon1 + "-" + mon3);
				}
				else if(feeDetailValue.getInstallmentNumber()==1)
				{
					feeDetails.setInstallmentNumber(2);
					feeDetails.setInstallmentMonth( mon4 + "-" + mon6);
				}
				else if(feeDetailValue.getInstallmentNumber()==2)
				{
					feeDetails.setInstallmentMonth( mon7 + "-" + mon9);
					feeDetails.setInstallmentNumber(3);
				}
				else if(feeDetailValue.getInstallmentNumber()==3)
				{
					feeDetails.setInstallmentMonth( mon10 + "-" + mon12);
					feeDetails.setInstallmentNumber(4);
					feeDetails.setRemainingFee(0.00);
				}
			}
			else 	if(intallment.equals("12"))
			{
				//Double intallAmount = Double.parseDouble( format.format( totalamountPaidByStudent/12));
				if(remainingAmount.equals(totalamountPaidByStudent))
				{
					feeDetails.setInstallmentMonth( mon1);
					feeDetails.setInstallmentNumber(1);
				}
				else if(feeDetailValue.getInstallmentNumber()==1)
				{feeDetails.setInstallmentMonth( mon2);
				feeDetails.setInstallmentNumber(2);
				}
				else if(feeDetailValue.getInstallmentNumber()==2)
				{ 
					feeDetails.setInstallmentMonth( mon3);
					feeDetails.setInstallmentNumber(3);
				}
				else if(feeDetailValue.getInstallmentNumber()==3)
				{
					feeDetails.setInstallmentMonth( mon4);
					feeDetails.setInstallmentNumber(4);
				}
				else if(feeDetailValue.getInstallmentNumber()==4)
				{
					feeDetails.setInstallmentMonth( mon5);
					feeDetails.setInstallmentNumber(5);
				}
				else if(feeDetailValue.getInstallmentNumber()==5)
				{
					feeDetails.setInstallmentMonth( mon6);
					feeDetails.setInstallmentNumber(6);
				}
				else if(feeDetailValue.getInstallmentNumber()==6)
				{
					feeDetails.setInstallmentMonth( mon7);
					feeDetails.setInstallmentNumber(7);
				}
				else if(feeDetailValue.getInstallmentNumber()==7)
				{
					feeDetails.setInstallmentMonth( mon8);
					feeDetails.setInstallmentNumber(8);
				}
				else if(feeDetailValue.getInstallmentNumber()==8)
				{
					feeDetails.setInstallmentMonth( mon9);
					feeDetails.setInstallmentNumber(9);
				}
				else if(feeDetailValue.getInstallmentNumber()==9)
				{
					feeDetails.setInstallmentMonth( mon10);
					feeDetails.setInstallmentNumber(10);
				}else if(feeDetailValue.getInstallmentNumber()==10)
				{
					feeDetails.setInstallmentMonth( mon11);
					feeDetails.setInstallmentNumber(11);
				}
				else if(feeDetailValue.getInstallmentNumber()==11)
				{
					feeDetails.setInstallmentMonth( mon12);
					feeDetails.setInstallmentNumber(12);
					feeDetails.setRemainingFee(0.00);
				}

			}
			else if(intallment.equals("2"))
			{
				//Double intallAmount =  Double.parseDouble( format.format( totalamountPaidByStudent/2));
				if(remainingAmount.equals(totalamountPaidByStudent))
				{
					feeDetails.setInstallmentMonth( mon1 + "-" + mon6);
					feeDetails.setInstallmentNumber(1);
				}
				else if(feeDetailValue.getInstallmentNumber()==1)
				{
					feeDetails.setInstallmentMonth( mon7 + "-" + mon12);
					feeDetails.setInstallmentNumber(2);
					feeDetails.setRemainingFee(0.00);
				}

			}
			else if(intallment.equals("1"))
			{
				//Double intallAmount = totalamountPaidByStudent;
				if(remainingAmount.equals(totalamountPaidByStudent))
				{
					feeDetails.setInstallmentMonth( mon1 + "-" + mon12);
					feeDetails.setInstallmentNumber(1);
					feeDetails.setRemainingFee(0.00);
				}


			}
		}
		if(request.getParameter("message")!=null){
			map.put("message", (String)(request.getParameter("message")));
		}
		if(request.getParameter("error")!=null){
			map.put("error", (String)(request.getParameter("error")));
		}



		map.put("showDiv", true);
		map.put("studentFeeDetail", feeDetails);		
		map.put("listStudentEditFeeDetails", studentFeeDetailService.listStudentEditFeeDetails(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), id));
		return "studentPayment";
	}


	
	@RequestMapping(value = "/getStudentFeesList/{id}")
	public String getStudentFeesList(Map<String, Object> map, HttpSession session, @PathVariable String id,HttpServletRequest request) throws Exception {
		StudentFeeDetail feeDetails =   studentFeeDetailService.getStudentByStudentId(id);
		//StudentFeeDetail feeDetailValue =   studentFeeDetailService.getStudentByStudentId(id);
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		map.put("showDiv", false);
		map.put("studentFeeDetail", feeDetails);	
		map.put("listStudentEditFeeDetail", studentFeeDetailService.listStudentEditFeeDetails(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString), id));
		return "studentPayment";

	}
	

	@RequestMapping(value = "/saveStudentPaymentInformation", method = RequestMethod.POST)
	public String studentFeeInformationSave(Map<String, Object> map, HttpSession session,
			@ModelAttribute("studentFeeDetail") StudentFeeDetail studentFeeDetail, @Valid StudentFeeDetail studentFeeDetailValid, BindingResult result)
					throws Exception {
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		StudentFeeDetail feeDetails =   studentFeeDetailService.getStudentByStudentId(studentFeeDetail.getSequenceStudentId());
		//String idValue = studentFeeDetail.getSequenceStudentId()+"@"+ studentFeeDetail.getTypeConcession()+"@"+studentFeeDetail.getConcession();
		if (result.hasErrors()) {
			map.put("studentFeeDetail", new StudentFeeDetail());
			map.put("showDiv", false);
			map.put("listStudentFeeDetail", studentFeeDetailService.listStudentFeeDetail(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
			map.put("message", "Fill all mandatory feilds.");
			return "paymentDetail";
		} else {
			try {
				if (null == studentFeeDetail.getId()) {
					studentFeeDetailService.saveStudentFeeDetail(studentFeeDetail);
					map.put("message", "StudentFeeDetail added sucessfully.");
					return "redirect:/paymentDetail/getStudentFeesList/"+studentFeeDetail.getSequenceStudentId();
				} else {
					if(studentFeeDetail.getInstallmentNumber() ==1)
					{					studentFeeDetailService.saveStudentFeeDetail(studentFeeDetail);
					map.put("message",studentFeeDetail.getSequenceStudentId()+"  Intallment - "+ studentFeeDetail.getInstallmentNumber()+"  StudentFeeDetail added sucessfully.");
					return "redirect:/paymentDetail/getStudentFeesList/"+studentFeeDetail.getSequenceStudentId();
					}
					else if(feeDetails.getRemainingFee()==0){
						map.put("error", "Fees completed");
						return "redirect:/paymentDetail/getStudentFeesData/"+studentFeeDetail.getSequenceStudentId();	
					}
					else if(studentFeeDetail.getStartSession().equals(feeDetails.getStartSession())&& studentFeeDetail.getInstallmentNumber() !=1)
					{

						studentFeeDetailService.saveStudentFeeDetail(studentFeeDetail);
						map.put("message",studentFeeDetail.getSequenceStudentId()+"Intallment"+ studentFeeDetail.getInstallmentNumber()+"StudentFeeDetail added sucessfully.");
						return "redirect:/paymentDetail/getStudentFeesList/"+studentFeeDetail.getSequenceStudentId();
					}
					else{
						map.put("error", "Start Session can't change because it is already started");
						return "redirect:/paymentDetail/getStudentFeesData/"+studentFeeDetail.getSequenceStudentId();	
					}
				}
			} catch (Exception exp) {
				exp.printStackTrace();
				map.put("dbError", exp.getMessage());
				map.put("studentFeeDetail", new StudentFeeDetail());
				map.put("showDiv", false);
				map.put("listStudentFeeDetail", studentFeeDetailService.listStudentFeeDetail(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));

				map.put("message", "Cannot add StudentFeeDetail, Already present.");
				return "studentPayment";
			}
		}

	}



	@RequestMapping(value = "/getStudentFeeCalculation/{id}")
	public String getStudentFeeCalculation(Map<String, Object> map, HttpSession session, @PathVariable String id) throws Exception {
		String[] parts = id.split("@");
		String studentId = parts[0];
		String cycleofConcession = parts[1];
		String concession = parts[2];

		Student st =   studentFormService.getStudentByStudentId(studentId);
		String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
		String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
		Double totalAmount =  feeStructureService.getFeeClass(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString),st.getClassName(), st.getClassSection());
	
		Double payTotalAmount = 0.00;

		StudentFeeDetail studentFeeDetail = new StudentFeeDetail();
		studentFeeDetail.setStudentId(st);
		studentFeeDetail.setTotalFee(totalAmount);
		studentFeeDetail.setConcession(Double.parseDouble( concession));
		
		studentFeeDetail.setTypeConcession(cycleofConcession);

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

		studentFeeDetail.setPaidByStudent(payTotalAmount);

		map.put("showDiv", true);
		map.put("studentFeeDetail", studentFeeDetail);		
		map.put("listStudentFeeDetail", studentFeeDetailService.listStudentFeeDetail(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)));
		return "studentPayment";
	}




}