package com.onlineexam.model.transients;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangePassword {
	

	@NotEmpty(message = "Old Password is mandatory")
	private String oldPassword;

	@Size(min = 5, max = 8)
	@NotEmpty(message = "New Password is mandatory")
	private String newPassword;

	@NotNull
	private String verifyNewPassword;

	@AssertTrue(message = "New Password should match Verify New password.")
	private boolean isValid() {
		if (newPassword == null) {
			return verifyNewPassword == null;
		} else {
			return newPassword.equals(verifyNewPassword);
		}
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getVerifyNewPassword() {
		return verifyNewPassword;
	}

	public void setVerifyNewPassword(String verifyNewPassword) {
		this.verifyNewPassword = verifyNewPassword;
	}

}
