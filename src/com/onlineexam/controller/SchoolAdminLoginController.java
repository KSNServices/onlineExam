
package com.onlineexam.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.onlineexam.constants.ERPConstant;
import com.onlineexam.constants.ModelConstants;
import com.onlineexam.model.User;
import com.onlineexam.service.PaymentPlanService;
import com.onlineexam.service.RoleService;
import com.onlineexam.service.UserService;
import com.onlineexam.util.FileUtils;

@Controller
@RequestMapping("/schoolUser")
public class SchoolAdminLoginController {
	@Value("${emailFrom}")
	String emailFrom;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PaymentPlanService paymentPlanService;

	@RequestMapping("/schoolAdminLogin")
	public String showManageUsers(Map<String, Object> map, HttpSession session) {
		User u = new User();
		String schoolUniqueId = null;
		int adminId = 0;
		map.put("userList", userService.listUserByRole(ModelConstants.SCHOOL_ADMIN));
		adminId = ((User) session.getAttribute("userDetails")).getId();
		schoolUniqueId = userService.getLastschoolId(ModelConstants.SCHOOL_ADMIN, adminId);
		int schoolID = 0;
		if (schoolUniqueId != null) {
			schoolID = Integer.parseInt(schoolUniqueId) + 1;
		} else {
			schoolID = 1;
		}
		u.setUserNumber(String.valueOf(schoolID));
		map.put("user", u);
		u.setAdminUser(u);
		map.put("paymentPlanList", paymentPlanService.listPaymentPlan());
		return "schoolAdminLogin";
	}

	@RequestMapping("/manageUsers/{searchString}")
	public String searchUsers(Map<String, Object> map, HttpSession session,
			@PathVariable("searchString") String searchString) {
		if (null == searchString || searchString.length() <= 0) {
			return "redirect:/schoolUser/schoolAdminLogin";
		}
		map.put("user", new User(new User()));
		map.put("paymentPlanList", paymentPlanService.listPaymentPlan());
		map.put("userList", userService.listUser(((User) session.getAttribute("userDetails")).getAdminUser().getId(),
				searchString));
		return "schoolAdminLogin";
	}

	@RequestMapping(value = "/saveSchoolAdmin", method = RequestMethod.POST)
	public String saveUser(Map<String, Object> map, HttpSession session, @ModelAttribute("user") User user,
			@Valid User userValid, BindingResult result, @RequestParam("userpic") MultipartFile userpic) {
		if (result.hasErrors()) {
			map.put("showDiv", true);
			map.put("user", user);
			map.put("roleList", roleService.listRoleFor());
			map.put("userList", userService.listUserByRole(ModelConstants.SCHOOL_ADMIN));
			map.put("paymentPlanList", paymentPlanService.listPaymentPlan());
			return "schoolAdminLogin";
		} else {
			try {
				if (null == user.getId()) {
					if (userpic != null) {
						FileUtils fileUtils = new FileUtils();
						// Validate image size
						double sizeInKB = fileUtils.getImageSize(userpic);
						if (sizeInKB > 1024) {
							map.put("showDiv", true);
							map.put("error", "Image size should not be exceeded by 1024 KB.");
							return "schoolAdminLogin";
						}

						// Validate image dimensions
						int[] imageDim = fileUtils.getDimensions(userpic);
						if (imageDim[0] > 1000 && imageDim[1] > 1000) {
							map.put("showDiv", true);
							map.put("error", "Image dimensions should be 600px and 600px.");
							return "schoolAdminLogin";
						}
						String profilePicDirectory = ERPConstant.ERP_MEDIA_DIRECTORY + File.separator
								+ ERPConstant.PROFILE_IMAGES;
						String fileAbsolutePath = fileUtils.uploadSingleFiles(userpic, profilePicDirectory);
						user.setUserImages(fileAbsolutePath);
					}
					user.setAuthority(ModelConstants.SCHOOL_ADMIN);
					user.setParentId((User) session.getAttribute("userDetails"));
					userService.saveUser(user);
					map.put("message", "Admin added sucessfully.<br/> User Name: " + user.getUserName());
					return "redirect:/schoolUser/schoolAdminLogin";
				} else {
					userService.saveUser(user);
					map.put("message", "Admin Edit sucessfully.<br/> User Name: " + user.getUserName());
					return "redirect:/schoolUser/schoolAdminLogin";

				}
			} catch (Exception exp) {
				exp.printStackTrace();
				map.put("dbError", exp.getMessage());
				map.put("userList", userService.listUserByRole(ModelConstants.SCHOOL_ADMIN));
				map.put("paymentPlanList", paymentPlanService.listPaymentPlan());
				return "schoolAdminLogin";
			}
		}

	}

	@RequestMapping("/deleteUser/{userNo}")
	public String deleteUser(Map<String, Object> map, HttpSession session, @PathVariable("userNo") Integer userNo) {
		User user = userService.getUserById(userNo);
		if (!user.getUserName().equals("admin")) {
			userService.removeUser(userNo);
			return "redirect:/schoolUser/schoolAdminLogin";
		} else {
			map.put("dbError", "You cannot delete .");
			map.put("user", new User());
			map.put("userList", userService.listUser());
			return "schoolAdminLogin";
		}
	}

	@RequestMapping("/enableDisableAdmin/{userNo}/{enabled}")
	public String enableDisableUser(Map<String, Object> map, HttpSession session,
			@PathVariable("userNo") Integer userNo, @PathVariable("enabled") boolean enabled) {
		User user = userService.getUserById(userNo);
		user.setEnabled(enabled);
		userService.saveUser(user);
		String str = "Disabled";
		if (enabled) {
			str = "Enabled";
		}
		map.put("message", "Admin: " + user.getUserName() + " is " + str + " Now. ");
		map.put("user", new User());
		map.put("userList", userService.listUserByRole(ModelConstants.SCHOOL_ADMIN));
		return "schoolAdminLogin";

	}

	@RequestMapping("/editUser/{userId}")
	public String editUser(Map<String, Object> map, HttpSession session, @PathVariable("userId") Integer userId) {
		map.put("showDiv", true);
		map.put("user", userService.getUserById(userId));
		map.put("userList", userService.listUserByRole(ModelConstants.SCHOOL_ADMIN));
		map.put("paymentPlanList", paymentPlanService.listPaymentPlan());
		return "schoolAdminLogin";
	}

	@RequestMapping("/retrievePassword/{userName}")
	public String retrievePassword(Map<String, Object> map, HttpSession session,
			@PathVariable("userName") String userName) {
		User user = userService.getUserByUsername(userName);
		String message;
		if (user != null) {
			map.put("userDetails", user);

			// send mail here

			message = "Password sent to " + user.getEmailAddress();
		} else {
			message = "Invalid Username. Please try again";
		}
		map.put("message", message);
		map.put("user", new User());
		map.put("userList", userService.listUser());
		return "forgotPassword";
	}

	@RequestMapping("/resetPassword/{userId}")
	public String resetPassword(Map<String, Object> map, @PathVariable("userId") Integer userId) {
		User user = userService.getUserById(userId);
		String message;
		if (user != null) {
			try {
				userService.resetPassword(user);
				message = "Password sent to " + user.getEmailAddress();
			} catch (Exception exp) {
				message = "Error while Reset. Please try again latter";
				map.put("dbError", exp.getMessage());
				map.put("message", message);
				map.put("user", new User());
				map.put("roleList", roleService.listRoleFor());
				map.put("userList", userService.listUser());
				return "schoolAdminLogin";
			}
		} else {
			message = "Invalid Username. Please try again";
		}
		map.put("message", message);
		map.put("user", new User());
		map.put("userList", userService.listUser());
		return "schoolAdminLogin";
	}

	@RequestMapping("/profile")
	public String profile(Map<String, Object> map, HttpSession session, HttpServletRequest request) throws Exception {
		Integer userId = ((User) session.getAttribute("userDetails")).getId();
		User user = userService.getUserById(userId);
		map.put("userdetails", user);
		if (request.getParameter("message") != null) {
			map.put("message", (String) request.getParameter("message"));
		}
		if (request.getParameter("error") != null) {
			map.put("error", (String) request.getParameter("error"));
		}
		return "profile";
	}

	@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
	public String saveProfile(Map<String, Object> map, HttpSession session, @ModelAttribute("userdetails") User user,
			@Valid User userValid, BindingResult result, HttpServletRequest request) throws Exception {
		if (result.hasErrors()) {
			map.put("message", "Fill all fields.");
		} else {
			try {
				// String image = request.getParameter("image");
				userService.saveUser(user);
				session.setAttribute("userDetails", user);
				if (!(SecurityContextHolder.getContext().getAuthentication().getName()).equals(user.getUserName())) {
					map.put("message", "Profile updated. Please login with new user name: " + user.getUserName());
					return "redirect:/login";
				}
				map.put("message", "Profile updated");
				return "redirect:/schoolUser/profile";
			} catch (Exception exp) {
				map.put("message", exp.getMessage());
				return "profilePage";
			}
		}
		return "profile";
	}

	@RequestMapping("/notification")
	public String userNotification(Map<String, Object> map, HttpSession session, HttpServletRequest request)
			throws Exception {
		Integer userId = ((User) session.getAttribute("userDetails")).getId();
		User user = userService.getUserById(userId);
		map.put("userdetails", user);
		if (request.getParameter("message") != null) {
			map.put("message", (String) request.getParameter("message"));
		}
		if (request.getParameter("error") != null) {
			map.put("error", (String) request.getParameter("error"));
		}
		return "notificationPage";
	}

	@RequestMapping("/readUserImage")
	public String readUserImage(Map<String, Object> map, HttpSession session, HttpServletResponse httpServletResponse)
			throws Exception {
		User user = userService.getUserById(((User) session.getAttribute("userDetails")).getId());
		String imgDir = ERPConstant.ERP_MEDIA_DIRECTORY + File.separator + ERPConstant.PROFILE_IMAGES;
		String noImgThumb = imgDir + File.separator + ERPConstant.NO_PROFILE_PIC_THUMBNAIL_IMAGE;
		String profilePic = noImgThumb;
		if (user.getUserImages() != null) {
			profilePic = user.getUserImages();
			profilePic = imgDir + File.separator + profilePic;
		}
		new FileUtils().readImage(profilePic, noImgThumb, httpServletResponse);
		map.put("user", user);
		return "redirect:/schoolUser/profilePage";
	}

	@RequestMapping("/uploadProfilePicture")
	public String uploadManageCompanyLogo(Map<String, Object> map, @RequestParam("image") MultipartFile image,
			HttpSession session) throws Exception {
		String fileName = null;
		FileUtils fileUtils = new FileUtils();
		try {
			if (!image.isEmpty()) {
				/**
				 * Check whether the company already have Logo OR not
				 */
				User user = (User) session.getAttribute("userDetails");
				if (user != null && user.getUserImages() != null) {
					/**
					 * Delete already existing user's image
					 */
					File file = new File(user.getUserImages());
					file.delete();
					user.setUserImages(null);
					userService.saveUser(user);
				}

				// Validate image size
				double sizeInKB = fileUtils.getImageSize(image);
				if (sizeInKB > 250) {
					map.put("error", "Image size should not be exceeded by 250 KB.");
					// return "redirect:/user/uploadimage";
				}

				// Validate image dimensions
				int[] imageDim = fileUtils.getDimensions(image);
				if (imageDim[0] > 600 && imageDim[1] > 600) {
					map.put("error", "Image dimensions should be 200px and 50px.");
					// return "redirect:/user/uploadimage";
				}
				String logoDirectory = ERPConstant.ERP_MEDIA_DIRECTORY + File.separator + ERPConstant.PROFILE_IMAGES;
				String fileAbsolutePath = fileUtils.uploadSingleFiles(image, logoDirectory);

				System.out.println("Server File Location=" + fileAbsolutePath);
				map.put("message", "File uploaded successfully.");
				// Update file path to database

				user.setUserImages(fileAbsolutePath);
				userService.saveUser(user);
				map.put("message", "Profile picture uploaded successfully.");
			} else {
				map.put("error", "Please select file for upload.");
			}
		} catch (Exception ex) {
			System.out.println("You failed to upload " + fileName + " => " + ex.getMessage());
			ex.printStackTrace();
		}
		return "profile";
	}

	@RequestMapping("/readUserDisplayImage/{userId}")
	public void readUserDisplayImage(Map<String, Object> map, HttpSession session,
			@PathVariable("userId") Integer userId, HttpServletResponse response) throws Exception {
		User user = userService.getUserById(userId);

		String imgDir = ERPConstant.ERP_MEDIA_DIRECTORY + File.separator + ERPConstant.PROFILE_IMAGES;
		String noImgThumb = imgDir + File.separator + ERPConstant.NO_PROFILE_PIC_THUMBNAIL_IMAGE;
		String profilePic = noImgThumb;
		if (user.getUserImages() != null) {
			profilePic = user.getUserImages();
			profilePic = imgDir + File.separator + profilePic;
		}
		new FileUtils().readImage(profilePic, noImgThumb, response);
		map.put("user", user);
		return;
	}

}
