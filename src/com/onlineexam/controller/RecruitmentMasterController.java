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

import com.onlineexam.model.RecruitmentMaster;
import com.onlineexam.service.AcademicYearService;
import com.onlineexam.service.RecruitmentMasterService;

@Controller
@RequestMapping("/rm")
public class RecruitmentMasterController {
	
	@Autowired
	private RecruitmentMasterService recruitmentMasterService;
	
	@Autowired
	private AcademicYearService academicYearService;
	
	
	@RequestMapping("/manageRecruitment")
	public String showManageRecruitment(Map<String, Object> map,HttpSession session,HttpServletRequest request)throws Exception {
		map.put("recruitmentMaster", new RecruitmentMaster());
		map.put("showDiv", false);
		map.put("rmList", recruitmentMasterService.listRecruitmentMaster());
		map.put("academicYearList", academicYearService.listAcademicYear());
		 if(request.getParameter("message")!=null){
        	map.put("message", (String)(request.getParameter("message")));
        }
		return "manageRecruitmentMaster";
	}
	
	@RequestMapping(value = "/saveRM", method = RequestMethod.POST)
	public String saveRM(Map<String, Object> map,HttpSession session, @ModelAttribute("recruitmentMaster") RecruitmentMaster recruitmentMaster, @Valid RecruitmentMaster recruitmentMasterValid,
			BindingResult result)throws Exception {
		if (result.hasErrors()) {
			map.put("recruitmentMaster", new RecruitmentMaster());
			map.put("showDiv", false);
			map.put("rmList", recruitmentMasterService.listRecruitmentMaster());
			map.put("academicYearList", academicYearService.listAcademicYear());
			map.put("message", "Fill all mandatory feilds.");
			return "manageRecruitmentMaster";
		} 
		else {
			try {				
				if(null == recruitmentMaster.getId()){
					recruitmentMasterService.saveRecruitmentMaster(recruitmentMaster);
					map.put("message","Recruitment Master added sucessfully.");
					return "redirect:/rm/manageRecruitmentMaster";
				}
				else{
					recruitmentMasterService.saveRecruitmentMaster(recruitmentMaster);
					return "redirect:/rm/manageRecruitmentMaster";
				}
			}
			 catch (Exception exp) {
				map.put("dbError", exp.getMessage());
				map.put("recruitmentMaster", new RecruitmentMaster());
				map.put("showDiv", false);
				map.put("rmList", recruitmentMasterService.listRecruitmentMaster());
				map.put("academicYearList", academicYearService.listAcademicYear());
				map.put("message", "Cannot add recruitment master, Already present.");
				return "manageRecruitmentMaster";
			}
		}		
	}
	
	
	@RequestMapping("/editRM/{rmId}")
	public String editState(Map<String, Object> map,HttpSession session, @PathVariable("rmId") Integer rmId)throws Exception {
		map.put("recruitmentMaster",recruitmentMasterService.getRecruitmentMasterById(rmId));
		map.put("showDiv", true);
		map.put("rmList", recruitmentMasterService.listRecruitmentMaster());
		map.put("academicYearList", academicYearService.listAcademicYear());
		return "manageRecruitmentMaster";
	}
	
	@RequestMapping("/enableDisableRM/{stateId}/{enabled}")
	public String enableDisableRM(Map<String, Object> map, HttpSession session,
			@PathVariable("rmId") Integer rmId, @PathVariable("enabled") boolean enabled)throws Exception {
		
		RecruitmentMaster recruitmentMaster=recruitmentMasterService.getRecruitmentMasterById(rmId);
		recruitmentMaster.setEnabled(enabled);
		if(enabled && recruitmentMaster!=null && !(recruitmentMaster.getId()>0)){
			recruitmentMasterService.saveRecruitmentMaster(recruitmentMaster);
		}else{
			recruitmentMasterService.saveRecruitmentMaster(recruitmentMaster);
		}
		String str = "Disabled";
		if (enabled) {
			str = "Enabled";
		}
		map.put("message", recruitmentMaster.getName()+ "] is " + str + " Now. ");		
		return "redirect:/rm/manageRecruitmentMaster";
	}

}
