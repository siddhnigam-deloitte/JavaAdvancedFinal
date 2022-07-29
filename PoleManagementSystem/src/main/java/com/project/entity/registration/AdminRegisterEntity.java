package com.project.entity.registration;

public class AdminRegisterEntity {
	private String Auname, password, email, phone;

	public String getAuname() {
		return Auname;
	}

	public void setAuname(String auname) {
		Auname = auname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AdminRegisterEntity() {
		super();
	}

	public AdminRegisterEntity(String auname, String password, String email, String phone) {
		super();
		Auname = auname;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
