package bean;

import java.io.Serializable;

public class AdminUserBeans implements Serializable {
	private int adminId;
	private String adminName;
	private String adminPassword;
	
	public AdminUserBeans() {}
	public AdminUserBeans(String adminName, String adminPassword) {
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	public AdminUserBeans(int adminId, String adminName) {
		this.adminId = adminId;
		this.adminName = adminName;
	}
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}
