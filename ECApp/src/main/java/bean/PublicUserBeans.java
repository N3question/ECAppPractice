package bean;

public class PublicUserBeans {
	private int userId;
	private String userName;
	private String password;
	private String postalCode;
	private String address;
	
	public PublicUserBeans() {}
	public PublicUserBeans(int userId, String userName, String password, String postalCode, String address) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.postalCode = postalCode;
		this.address = address;
	}
	
	public PublicUserBeans(String userName, String password, String postalCode, String address) {
		this.userName = userName;
		this.password = password;
		this.postalCode = postalCode;
		this.address = address;
	}
	
	public PublicUserBeans(String userName, String password) {
		setUserName(userName);
		setPassword(password);
	}
	
	public PublicUserBeans(int userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		if (userName.length() > 0) {
			this.userName = userName;
		} else {
			this.userName = null;
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if (password.length() >= 7) {
			this.password = password;
		} else {
			this.password = null;
		}
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
