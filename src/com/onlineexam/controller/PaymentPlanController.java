package com.onlineexam.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineexam.constants.ModelConstants;
import com.onlineexam.model.PaymentPlan;
import com.onlineexam.service.PaymentPlanService;

@Controller
@RequestMapping("/paymentPlan")
public class PaymentPlanController {
	
	@Autowired
	private PaymentPlanService paymentPlanService;
	
	@RequestMapping("/managePaymentPlan")
	public String showManagePaymentPlan(Map<String, Object> map,HttpSession session,HttpServletRequest request)throws Exception {
		map.put("paymentPlan", new PaymentPlan());
		map.put("showDiv", false);
		map.put("paymentPlanModeList", ModelConstants.paymentPlanList);
		map.put("paymentPlanList", paymentPlanService.listPaymentPlan());
		 if(request.getParameter("message")!=null){
        	map.put("message", (String)(request.getParameter("message")));
        }
		return "managePaymentPlan";
	}
	
	
	@RequestMapping(value = "/savePaymentPlan", method = RequestMethod.POST)
	public String savePaymentPlan(Map<String, Object> map,HttpSession session, @ModelAttribute("paymentPlan") PaymentPlan paymentPlan, @Valid PaymentPlan paymentPlanValid,
			BindingResult result)throws Exception {
		if (result.hasErrors()) {
			map.put("paymentPlan", new PaymentPlan());
			map.put("showDiv", false);
			map.put("paymentPlanModeList", ModelConstants.paymentPlanList);
			map.put("paymentPlanList", paymentPlanService.listPaymentPlan());
			map.put("message", "Fill all mandatory feilds.");
			return "managePaymentPlan";
		} 
		else {
			try {				
				if(null == paymentPlan.getId()){
					paymentPlanService.savePaymentPlan(paymentPlan);
					map.put("message","Country added sucessfully.");
					return "redirect:/paymentPlan/managePaymentPlan";
				}
				else{
					paymentPlanService.savePaymentPlan(paymentPlan);
					return "redirect:/paymentPlan/managePaymentPlan";
				}
			}
			 catch (Exception exp) {
				map.put("dbError", exp.getMessage());
				map.put("paymentPlan", new PaymentPlan());
				map.put("showDiv", false);
				map.put("paymentPlanModeList", ModelConstants.paymentPlanList);
				map.put("paymentPlanList", paymentPlanService.listPaymentPlan());
				map.put("message", "Cannot add payment plan, Already present.");
				return "managePaymentPlan";
			}
		}		
	}
	
	
	@RequestMapping("/editPaymentPlan/{paymentPlanId}")
	public String editPaymentPlan(Map<String, Object> map,HttpSession session, @PathVariable("paymentPlanId") Integer paymentPlanId)throws Exception {
		map.put("showDiv", true);
		map.put("paymentPlanModeList", ModelConstants.paymentPlanList);
		map.put("paymentPlan", paymentPlanService.getPaymentPlanById(paymentPlanId));
		map.put("paymentPlanList", paymentPlanService.listPaymentPlan());
		return "managePaymentPlan";
	}
	
	@RequestMapping("/enableDisablePaymentPlan/{paymentPlanId}/{enabled}")
	public String enableDisablePaymentPlan(Map<String, Object> map, HttpSession session,
			@PathVariable("paymentPlanId") Integer paymentPlanId, @PathVariable("enabled") boolean enabled)throws Exception {
		
		PaymentPlan paymentPlan=paymentPlanService.getPaymentPlanById(paymentPlanId);
		paymentPlan.setEnabled(enabled);
		if(enabled && paymentPlan!=null && !(paymentPlan.getId()>0)){
			paymentPlanService.savePaymentPlan(paymentPlan);
		}else{
			paymentPlanService.savePaymentPlan(paymentPlan);
		}
		String str = "Disabled";
		if (enabled) {
			str = "Enabled";
		}
		map.put("message", paymentPlan.getPaymentPlanName()+ " is " + str + " Now. ");		
		return "redirect:/paymentPlan/managePaymentPlan";
	}
	

}
