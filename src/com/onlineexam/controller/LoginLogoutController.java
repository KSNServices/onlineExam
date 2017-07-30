/**
 * 
 */
package com.onlineexam.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlineexam.constants.ModelConstants;
import com.onlineexam.model.User;
import com.onlineexam.model.transients.ChangePassword;
import com.onlineexam.service.StudentFormService;
import com.onlineexam.service.UserService;

/**
 * Handles and retrieves the login or denied page depending on the URI template
 */
@Controller
public class LoginLogoutController extends BaseController {

	@Resource(name = "sessionRegistry")
	private SessionRegistryImpl sessionRegistry;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentFormService studentFormService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(@RequestParam(value = "error", required = false) boolean error,
			@RequestParam(value = "message", required = false) String message, ModelMap model) {
		model.put("message", message);
		if (error == true) {
			model.put("loginError", "You have entered an invalid username or password!");
		} else {
			model.put("loginError", "");
		}
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String showLoginAfterLogout(ModelMap model) {
		model.addAttribute("loginError", "logout");
		return "login";
	}
	
	

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String getDeniedPage() {

		return "accessDenied";
	}

	@RequestMapping(value = "/session-expired", method = RequestMethod.GET)
	public String getLoginPageAfterSessionExpire(ModelMap model) {
		model.put("loginError", "Session expire ..");
		return "login";
	}

	@RequestMapping(value = "/showHomePanel", method = RequestMethod.GET)
	public String showUserPannel(Map<String, Object> map, HttpSession session) {
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			User user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
			session.setAttribute("userDetails", user);
			if (user.getAuthority().equals(ModelConstants.SUPER_ADMIN)) {
				return "redirect:/getAllSuperAdminData/"+user.getId();				
			} else if (user.getAuthority().equals(ModelConstants.ADMIN)) {
				return "homeAdmin";
			} else if (user.getAuthority().equals(ModelConstants.SCHOOL_ADMIN)) {
				return "redirect:/getSchoolData/"+user.getId();
			} else if (user.getAuthority().equals(ModelConstants.PARENT)) {
				return "homeParent";
			} else if (user.getAuthority().equals(ModelConstants.STUDENT)) {
				return "homeStudent";
			}else if (user.getAuthority().equals(ModelConstants.TEACHER)) {
				return "homeTeacher";
			}
		} else {
			return "unAuthorizedUser";
		}
		return "";
	}

	/**
	 * 
	 * @param map
	 * @param session
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getAllSuperAdminData/{userId}")
	public String getAllSuperAdminData(Map<String, Object> map, HttpSession session,
			@PathVariable("userId") Integer userId) {
		if(userId!=null){
			User user = userService.getUserById(userId);
			//map.put("totalStudent",(studentFormService.listStudent()!=null?studentFormService.listStudent().size():""));
			
		}
		return "homeSuperAdmin";
	}
	
	
	@RequestMapping(value = "/getSchoolData/{userId}")
	public String getSchoolData(Map<String, Object> map, HttpSession session,
			@PathVariable("userId") Integer userId) {
		if(userId!=null){
			User user = userService.getUserById(userId);
			
			String adminIdString = String.valueOf(((User) session.getAttribute("userDetails")).getParentId().getId());
			String schoolIdString = ((User) session.getAttribute("userDetails")).getUserNumber();
			map.put("totalStudent",(studentFormService.listStudent(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString))!=null?studentFormService.listStudent(Integer.parseInt(adminIdString), Integer.parseInt(schoolIdString)).size():""));
			
		}
		return "homeSchoolAdmin";
	}
	
	@RequestMapping("/showChangePassword")
	public String showChangePassword(Map<String, Object> map,HttpServletRequest request) {
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			map.put("changePassword", new ChangePassword());
			if (request.getParameter("message") != null) {
				map.put("message", (String) (request.getParameter("message")));
			}
			if (request.getParameter("error") != null) {
				map.put("error", (String) (request.getParameter("error")));
			}
			return "changePassword";
		} else {
			return "unAuthorizedUser";
		}
	}

	@RequestMapping("/saveChangePassword")
	public String changePassword(Map<String, Object> map,
			@ModelAttribute("changePassword") ChangePassword changePassword, @Valid ChangePassword changePasswordValid,
			BindingResult result) {
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if (result.hasErrors()) {
				map.put("changePassword", changePassword);
				return "changePassword";
			} else {
				User user = userService
						.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
				if (passwordEncoder.matches(changePassword.getOldPassword(), user.getPassword())) {
					String pass = changePassword.getNewPassword();
					user.setPassword(passwordEncoder.encode(pass));
					try {
						userService.saveUser(user);
						map.put("message", "Password Changed Successfully.");
						map.put("changePassword", new ChangePassword());
						return "changePassword";
					} catch (ConstraintViolationException exp) {
						map.put("dbError", exp.getMessage());
						map.put("changePassword", changePassword);
						return "changePassword";
					}
				} else {
					result.reject("oldPassword", "Invalid Old Password.");
					map.put("changePassword", changePassword);
					return "changePassword";
				}
			}
		} else {
			return "redirect:/showChangePassword";
		}
	}
	
	@RequestMapping(value = "/locked", method = RequestMethod.GET)
	public String showLocked(Map<String, Object> map,HttpServletRequest request) {
		User user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		map.put("userDetails", user);
		return "lockedPage";
	}
	
}