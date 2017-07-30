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

import com.onlineexam.model.OnlineExamLevels;
import com.onlineexam.service.OnlineExamLevelService;

@Controller
@RequestMapping("/oeLevel")
public class OnlineExamLevelController {
	
	@Autowired
	private OnlineExamLevelService onlineExamLevelService;
	
	@RequestMapping("/manageExamLevel")
	public String showManageExamLevel(Map<String, Object> map,HttpSession session,HttpServletRequest request)throws Exception {
		map.put("oeLevel", new OnlineExamLevels());
		map.put("showDiv", false);
		map.put("oLevelList", onlineExamLevelService.listOnlineExamLevels());
		 if(request.getParameter("message")!=null){
        	map.put("message", (String)(request.getParameter("message")));
        }
		return "manageOnlineExamLevel";
	}
	
	@RequestMapping(value = "/saveOELevel", method = RequestMethod.POST)
	public String saveOELevel(Map<String, Object> map,HttpSession session, @ModelAttribute("oeLevel") OnlineExamLevels examLevels, @Valid OnlineExamLevels examLevelsValid,
			BindingResult result)throws Exception {
		if (result.hasErrors()) {
			map.put("oeLevel", new OnlineExamLevels());
			map.put("showDiv", false);
			map.put("oLevelList", onlineExamLevelService.listOnlineExamLevels());
			map.put("message", "Fill all mandatory feilds.");
			return "manageOnlineExamLevel";
		} 
		else {
			try {				
				if(null == examLevels.getId()){
					onlineExamLevelService.saveOnlineExamLevel(examLevels);
					map.put("message","Online Exam Level added sucessfully.");
					return "redirect:/oeLevel/manageOnlineExamLevel";
				}
				else{
					onlineExamLevelService.saveOnlineExamLevel(examLevels);
					return "redirect:/oeLevel/manageOnlineExamLevel";
				}
			}
			 catch (Exception exp) {
				map.put("dbError", exp.getMessage());
				map.put("oeLevel", new OnlineExamLevels());
				map.put("showDiv", false);
				map.put("oLevelList", onlineExamLevelService.listOnlineExamLevels());
				map.put("message", "Cannot add recruitment master, Already present.");
				return "manageOnlineExamLevel";
			}
		}		
	}
	
	
	@RequestMapping("/editExamLevel/{oeLevelId}")
	public String editExamLevel(Map<String, Object> map,HttpSession session, @PathVariable("oeLevelId") Integer oeLevelId)throws Exception {
		map.put("oeLevel",onlineExamLevelService.getOnlineExamLevelById(oeLevelId));
		map.put("showDiv", true);
		map.put("oLevelList", onlineExamLevelService.listOnlineExamLevels());
		return "manageOnlineExamLevel";
	}
	
	@RequestMapping("/enableDisableOnlineExamLevel/{oLevelId}/{enabled}")
	public String enableDisableOnlineExamLevel(Map<String, Object> map, HttpSession session,
			@PathVariable("oeLevelId") Integer oeLevelId, @PathVariable("enabled") boolean enabled)throws Exception {
		
		OnlineExamLevels examLevels=onlineExamLevelService.getOnlineExamLevelById(oeLevelId);
		examLevels.setEnabled(enabled);
		if(enabled && examLevels!=null && !(examLevels.getId()>0)){
			onlineExamLevelService.saveOnlineExamLevel(examLevels);
		}else{
			onlineExamLevelService.saveOnlineExamLevel(examLevels);
		}
		String str = "Disabled";
		if (enabled) {
			str = "Enabled";
		}
		map.put("message", examLevels.getLevelName()+ "] is " + str + " Now. ");		
		return "redirect:/oeLevel/manageOnlineExamLevel";
	}

}
