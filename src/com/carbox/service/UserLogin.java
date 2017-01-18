package com.carbox.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import com.carbox.util.HibernateUtil;

@ManagedBean
@RequestScoped
public class UserLogin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String mail;
	private String password;
	
	
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
	
	
	
	public String validateMailPassword(){
		
		System.out.println(getMail() + " " + getPassword());
		
		if(getMail() != null && !getMail().isEmpty() && getPassword() != null && !getPassword().isEmpty() )
			return "index";
		else
			return "login";
		/*Session session = null;
		try {
			
			session = HibernateUtil.getsession();
			session.getTransaction().begin();
			Query query = session.getNamedQuery("isLogin");
			query.setString(0, getMail());
			query.setString(1, getPassword());
			List queryList = (List) query.list();
			
			System.out.println(queryList);
			
			if (queryList != null )
				return "index.xhtml?redirect=true";

			session.getTransaction().commit();
			
			return "login2.xhtml";
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return "login2.xhtml";*/
	}
	
}
