package com.carbox.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import com.carbox.model.User;
import com.carbox.query.LoginQuery;
import com.carbox.query.Queries;
import com.carbox.util.HttpSessionUtil;

@ManagedBean
@SessionScoped
public class LoginControlBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean loggedIn = false;
	private Integer userID;
	private String inputMail;
	private String inputPassword;
	
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}


	public String getInputMail() {
		return inputMail;
	}

	public void setInputMail(String inputMail) {
		this.inputMail = inputMail;
	}

	public String getInputPassword() {
		return inputPassword;
	}

	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	User user = new User();
	HttpSession httpSession;
	
	public String doLogin() {

		user = Queries.queryUser(inputMail, inputPassword);

		if (user != null){
			httpSession = HttpSessionUtil.getSession();
			httpSession.setAttribute("userId", user.getUserId());
			httpSession.setAttribute("mail", user.getMail());
			httpSession.setAttribute("firstname", user.getName());
			httpSession.setAttribute("surname", user.getSurname());
			userID = user.getUserId();
			loggedIn = true;
			return "/index.xhtml?faces-redirect=true";
		}

		else
			return "/login.xhtml";
	}

	
	public String doLogout(){
		loggedIn = false;
		//HttpSession session = HttpSessionUtil.getSession();
		httpSession.invalidate();
		return "/index.xhtml?faces-redirect=true";
		
	}
	
	
	
	public String doLoginViaRegister(String mail, String pass) {

		user = Queries.queryUser(mail, pass);

		if (user != null){
			httpSession = HttpSessionUtil.getSession();
			httpSession.setAttribute("userId", user.getUserId());
			httpSession.setAttribute("mail", user.getMail());
			httpSession.setAttribute("firstname", user.getName());
			httpSession.setAttribute("surname", user.getSurname());
			userID = user.getUserId();
			loggedIn = true;
			return "/index.xhtml?faces-redirect=true";
		}

		else
			return "/login.xhtml";
	}


    


}
