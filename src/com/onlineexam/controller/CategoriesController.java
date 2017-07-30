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

import com.onlineexam.model.Categories;
import com.onlineexam.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/manageCategories")
	public String showManageCategories(Map<String, Object> map,HttpSession session,HttpServletRequest request)throws Exception {
		map.put("categories", new Categories());
		map.put("showDiv", false);
		map.put("categoriesList", categoryService.listCategory());
		 if(request.getParameter("message")!=null){
        	map.put("message", (String)(request.getParameter("message")));
        }
		return "manageCategories";
	}
	
	
	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public String saveCategory(Map<String, Object> map,HttpSession session, @ModelAttribute("categories") Categories categories, @Valid Categories categoriesValid,
			BindingResult result)throws Exception {
		if (result.hasErrors()) {
			map.put("categories", new Categories());
			map.put("showDiv", false);
			map.put("categoriesList", categoryService.listCategory());
			map.put("message", "Fill all mandatory feilds.");
			return "manageCategories";
		} 
		else {
			try {				
				if(null == categories.getId()){
					categoryService.saveCategory(categories);
					map.put("message","Category added sucessfully.");
					return "redirect:/categories/manageCategories";
				}
				else{
					categoryService.saveCategory(categories);
					return "redirect:/categories/manageCategories";
				}
			}
			 catch (Exception exp) {
				map.put("dbError", exp.getMessage());
				map.put("categories", new Categories());
				map.put("showDiv", false);
				map.put("categoriesList", categoryService.listCategory());
				map.put("message", "Cannot add category, Already present.");
				return "manageCategories";
			}
		}		
	}
	
	
	@RequestMapping("/editCategory/{categoryId}")
	public String editCategory(Map<String, Object> map,HttpSession session, @PathVariable("categoryId") Integer categoryId)throws Exception {
		map.put("showDiv", true);
		map.put("categories", categoryService.getCategoryById(categoryId));
		map.put("categoriesList", categoryService.listCategory());
		return "manageCategories";
	}
	
	@RequestMapping("/enableDisableCategory/{categoryId}/{enabled}")
	public String enableDisableCategory(Map<String, Object> map, HttpSession session,
			@PathVariable("categoryId") Integer categoryId, @PathVariable("enabled") boolean enabled)throws Exception {
		
		Categories categories=categoryService.getCategoryById(categoryId);
		categories.setEnabled(enabled);
		if(enabled && categories!=null && !(categories.getId()>0)){
			categoryService.saveCategory(categories);
		}else{
			categoryService.saveCategory(categories);
		}
		String str = "Disabled";
		if (enabled) {
			str = "Enabled";
		}
		map.put("message", categories.getCategoryName()+ " is " + str + " Now. ");		
		return "redirect:/categories/manageCategories";
	}

}
