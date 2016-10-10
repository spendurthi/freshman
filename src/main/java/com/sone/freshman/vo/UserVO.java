package com.sone.freshman.vo;

public class UserVO {
	private long id;
	private String userName;
	private String password;	
	private String email;
	private String address;
	public UserVO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public UserVO(long id, String userName, String address, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.address = address;
		this.email = email;
	}

	public UserVO(){}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		UserVO other = (UserVO) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
