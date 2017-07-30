package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.UserDAO;
import com.onlineexam.model.User;
import com.onlineexam.util.EmailUtil;
import com.onlineexam.util.ERPHelper;

@Service
public class UserServiceImpl implements UserService {
	@Value("${emailFrom}")
	String emailFrom;

	@Value("${tempPassType}")
    String tempPassType;
    
	@Value("${tempPassLength}")
    Integer tempPassLength;
    
    @Autowired
    private UserDAO userDAO;
    
    /*@Autowired
    private MailService mailService;*/
    
    /*@Autowired
    private EmailSettingService emailSettingService;*/
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Transactional
    @Override
    public void saveUser(User user) {
    	String tempPass=null;
    	if(user.getId()==null){
    		tempPass=ERPHelper.generateTemporaryPassward(tempPassLength,tempPassType);
    		
    		user.setPassword(passwordEncoder.encode(tempPass));
    		user.setEnabled(true);
    		userDAO.saveUser(user);
    		notifyUserByMail(user, tempPass);
    	}else{
    		userDAO.saveUser(user);
    	}
    }

    @Transactional
    @Override
    public List<User> listUser() {
        return userDAO.listUser();
    }

    @Transactional
    @Override
    public void removeUser(Integer userNo) {
        userDAO.removeUser(userNo);
    }

    @Transactional
    @Override
    public User getUserById(Integer userNo) {
        return userDAO.getUserById(userNo);
    }

    @Transactional
    @Override
    public User getUserByUsername(String userName) {
        return userDAO.getUserByUserName(userName);
    }

	@Override
	public void notifyUserByMail(User user, String tempPass) {
		/*EmailSetting emailSetting = emailSettingService.getEmailSettingByCompany(user.getCompany().getId());
		MailSenderService mailSender=new MailSenderService(emailSetting);
	*/	String emailMessage = "<table width='100%' border='0' align='center' cellpadding='0' cellspacing='0' "
	            + "style='font-family: Verdana, Arial, Helvetica, sans-serif; "
	            + "font-size: 12pt; color:#5a5a5a;'><tr><td align='left'>"
	            + "<p>Dear " + user.getFirstName() + ",</p></td></tr><tr>"
	            + "<td align='left'>" 
	            + "<p>Thank you for using  this site.<br /></p><br/><br/><p>"
	            + "<p>User Name :: "+user.getUserName()+"<br /></p><br/><br/><p>"
	            + "<p>Password :: "+tempPass+"<br /></p><br/><br/><p>"
	            + "<p>Thank you for using  this site.<br /></p><br/><br/><p>"
	            + "Regards,<br />Risk Free<br /></p><p><br />"
	            + "<br />THIS IS AN AUTOMATED MESSAGE; PLEASE DO NOT REPLY. </p></td></tr></table>";
		String emailSubject = "Risk Free account has been created.";
		//mailService.sendMail(emailFrom, user.getEmailAddress(), emailSubject, emailMessage);
		EmailUtil emailUtil=new EmailUtil();
		emailUtil.sendEmail(user.getEmailAddress(),emailSubject,emailMessage);
	}
	@Transactional
	@Override
	public List<User> listUser(Integer companyId,String searchString) {
		return userDAO.listUser(companyId,searchString);
	}
	@Transactional
	@Override
	public List<User> listUserByRole(String role) {
		return userDAO.listUserByRole(role);
	}
	
	
	@Transactional
	@Override
	public void resetPassword(User user) {
		String tempPass=ERPHelper.generateTemporaryPassward(tempPassLength,tempPassType);
		user.setPassword(passwordEncoder.encode(tempPass));
		userDAO.saveUser(user);
		notifyUserByMail(user, tempPass);
	}
	
	@Transactional
	@Override
	public String getLastId(String role) {
		return userDAO.getLastId(role);
	}

	@Override
	@Transactional
	public String getLastschoolId(String role, int adminId) {
		return userDAO.getLastschoolId(role,adminId);
	}
}
