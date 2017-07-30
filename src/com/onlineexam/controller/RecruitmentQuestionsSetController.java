package com.onlineexam.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineexam.service.OnlineExamLevelService;
import com.onlineexam.service.OnlineExamSubjectService;
import com.onlineexam.service.RecruitmentQuestionsSetSerive;

@Controller
@RequestMapping("/recruitmentSets")
public class RecruitmentQuestionsSetController {
	
	@Autowired
	private RecruitmentQuestionsSetSerive recruitmentQuestionsSetSerive;
	
	@Autowired
	private OnlineExamLevelService onlineExamLevelService;
	
	@Autowired
	private OnlineExamSubjectService onlineExamSubjectService;	
	
	@RequestMapping("/manageExamQuestionSets")
	public String manageExamQuestionSets(Map<String, Object> map, HttpSession session,
			HttpServletRequest request) throws Exception {
		map.put("showDiv", false);
		map.put("oeSetList", recruitmentQuestionsSetSerive.listOnlineExamSets());
		map.put("levelList", onlineExamLevelService.listOnlineExamLevels());
		map.put("subjectList", onlineExamSubjectService.listOnlineExamSubjects());
		if (request.getParameter("message") != null) {
			map.put("message", (String) (request.getParameter("message")));
		}
		return "manageExamQuestionSets";
	}

}
