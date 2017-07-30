package com.onlineexam.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineexam.model.OnlineExamLevels;
import com.onlineexam.service.OnlineExamLevelService;
import com.onlineexam.service.RecruitmentQuestionsService;

@Controller
@RequestMapping("/rq")
public class RecruitmentQuestionsController {

	@Autowired
	private RecruitmentQuestionsService recruitmentQuestionsService;
	
	@Autowired
	private OnlineExamLevelService onlineExamLevelService;

	@RequestMapping("/manageRecruitmentQuestions")
	public String showManageRecruitmentQuestions(Map<String, Object> map, HttpSession session,
			HttpServletRequest request) throws Exception {
		map.put("showDiv", false);
		map.put("oeLevelList", onlineExamLevelService.listOnlineExamLevels());
		
		map.put("rqList", recruitmentQuestionsService.listRecruitmentQuestions());
		if (request.getParameter("message") != null) {
			map.put("message", (String) (request.getParameter("message")));
		}
		return "manageRecruitmentQuestions";
	}

}
