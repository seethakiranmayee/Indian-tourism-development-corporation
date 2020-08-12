package com.dxc.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer
{
	
	private String firstname;
	private String lastname;
	private String pass;
	private String confirmpass;
	private String mail;
	private String gender;
	
	@Id
	private String mobile;
	
	public Customer()
	{
		
	}

	public Customer(String firstname, String lastname, String pass, String confirmpass, String mail, String gender,
			String mobile) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.pass = pass;
		this.confirmpass = confirmpass;
		this.mail = mail;
		this.gender = gender;
		this.mobile = mobile;
	}
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getConfirmpass() {
		return confirmpass;
	}

	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Customer [firstname=" + firstname + ", lastname=" + lastname + ", pass=" + pass + ", confirmpass="
				+ confirmpass + ", mail=" + mail + ", gender=" + gender + ", mobile=" + mobile + "]";
	}
	
	
	
}
