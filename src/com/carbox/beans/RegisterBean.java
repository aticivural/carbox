package com.carbox.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.carbox.model.User;
import com.carbox.service.impl.UserServiceImpl;

@ManagedBean
@RequestScoped
public class RegisterBean implements Serializable {

	private static final long serialVersionUID = -6178169263504054300L;
	
	@ManagedProperty(value = "#{loginControlBean}")
	private LoginControlBean loginControlBean;

	public LoginControlBean getLoginControlBean() {
		return loginControlBean;
	}

	public void setLoginControlBean(LoginControlBean loginControlBean) {
		this.loginControlBean = loginControlBean;
	}
	
	private String firstname;
	private String lastname;
	private String mail;
	private String password;

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String doRegister() {
		User newUser = new User(firstname, lastname, mail, password);
		UserServiceImpl userService = new UserServiceImpl();
		userService.addUser(newUser);
		return loginControlBean.doLoginViaRegister(mail, password);
		//return "/index.xhtml?faces-redirect=true";

	}

}
