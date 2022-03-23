package com.adminbeans;

public class AdminLogin {
	private String adminName;
	private String adminPass;

	@Override
	public String toString() {
		return "AdminLogin [adminName=" + adminName + ", adminPass=" + adminPass + "]";
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

}
