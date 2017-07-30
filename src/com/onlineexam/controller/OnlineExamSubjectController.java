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

import com.onlineexam.model.OnlineExamSubjects;
import com.onlineexam.service.OnlineExamLevelService;
import com.onlineexam.service.OnlineExamSubjectService;

@Controller
@RequestMapping("/oeSubject")
public class OnlineExamSubjectController {

	@Autowired
	private OnlineExamSubjectService onlineExamSubjectService;
	
	@Autowired
	private OnlineExamLevelService onlineExamLevelService;
	
	@RequestMapping("/manageExamSubject")
	public String showManageExamSubject(Map<String, Object> map,HttpSession session,HttpServletRequest request)throws Exception {
		map.put("oeSubjects", new OnlineExamSubjects());
		map.put("showDiv", false);
		map.put("oeSubjectList", onlineExamSubjectService.listOnlineExamSubjects());
		map.put("oeLevelsList", onlineExamLevelService.listOnlineExamLevels());
		 if(request.getParameter("message")!=null){
        	map.put("message", (String)(request.getParameter("message")));
        }
		return "manageOnlineExamSubjects";
	}
	
	@RequestMapping(value = "/saveOESubject", method = RequestMethod.POST)
	public String saveOESubject(Map<String, Object> map,HttpSession session, @ModelAttribute("oeSubject") OnlineExamSubjects oeSubject, @Valid OnlineExamSubjects oeSubjectValid,
			BindingResult result)throws Exception {
		if (result.hasErrors()) {
			map.put("oeSubjects", new OnlineExamSubjects());
			map.put("showDiv", false);
			map.put("oeSubjectList", onlineExamSubjectService.listOnlineExamSubjects());
			map.put("oeLevelsList", onlineExamLevelService.listOnlineExamLevels());
			map.put("message", "Fill all mandatory feilds.");
			return "manageOnlineExamSubjects";
		} 
		else {
			try {				
				if(null == oeSubject.getId()){
					onlineExamSubjectService.saveOnlineExamSubject(oeSubject);
					map.put("message","Online Exam Level added sucessfully.");
					return "redirect:/oeSubject/manageExamSubject";
				}
				else{
					onlineExamSubjectService.saveOnlineExamSubject(oeSubject);
					map.put("message","Online Exam Level updated sucessfully.");
					return "redirect:/oeSubject/manageExamSubject";
				}
			}
			 catch (Exception exp) {
				map.put("dbError", exp.getMessage());
				map.put("oeSubjects", new OnlineExamSubjects());
				map.put("showDiv", false);
				map.put("oeSubjectList", onlineExamSubjectService.listOnlineExamSubjects());
				map.put("oeLevelsList", onlineExamLevelService.listOnlineExamLevels());
				map.put("message", "Cannot add recruitment subject, Already present.");
				return "manageOnlineExamSubjects";
			}
		}		
	}
	
	
	@RequestMapping("/editExamSubject/{oeSbjectId}")
	public String editExamLevel(Map<String, Object> map,HttpSession session, @PathVariable("oeSbjectId") Integer oeSbjectId)throws Exception {
		map.put("oeSubjects",onlineExamSubjectService.getOnlineExamSubjectById(oeSbjectId));
		map.put("showDiv", true);
		map.put("oeSubjectList", onlineExamSubjectService.listOnlineExamSubjects());
		map.put("oeLevelsList", onlineExamLevelService.listOnlineExamLevels());
		return "manageOnlineExamSubjects";
	}
	
	@RequestMapping("/enableDisableOnlineExamSubject/{oeSbjectId}/{enabled}")
	public String enableDisableOnlineExamSubject(Map<String, Object> map, HttpSession session,
			@PathVariable("oeSbjectId") Integer oeSbjectId, @PathVariable("enabled") boolean enabled)throws Exception {
		
		OnlineExamSubjects onlineExamSubjects=onlineExamSubjectService.getOnlineExamSubjectById(oeSbjectId);
		onlineExamSubjects.setEnabled(enabled);
		if(enabled && onlineExamSubjects!=null && !(onlineExamSubjects.getId()>0)){
			onlineExamSubjectService.saveOnlineExamSubject(onlineExamSubjects);
		}else{
			onlineExamSubjectService.saveOnlineExamSubject(onlineExamSubjects);
		}
		String str = "Disabled";
		if (enabled) {
			str = "Enabled";
		}
		map.put("message", onlineExamSubjects.getSubjectName()+ "] is " + str + " Now. ");		
		return "redirect:/oeSubject/manageExamSubject";
	}
	
}
