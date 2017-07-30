package com.onlineexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineexam.service.InstituteService;

@Controller
@RequestMapping("/institute")
public class InstituteController {

	@Autowired
	private InstituteService instituteService;
	
	
	
	
}
