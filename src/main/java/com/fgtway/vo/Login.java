package com.fgtway.vo;

public class Login implements java.io.Serializable{
	private static final long serialVersionUID = -5338432983172083606L;
	private String userName;
	private String usrpwd;
	private String type;
	private String loginTime;
	private Location location;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUsrpwd() {
		return usrpwd;
	}
	public void setUsrpwd(String usrpwd) {
		this.usrpwd = usrpwd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Login() {
	}
	public Login(String userName, String usrpwd, String type) {
		this.userName = userName;
		this.usrpwd = usrpwd;
		this.type = type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}	
}
