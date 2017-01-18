package com.carbox.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.carbox.model.User;
import com.carbox.util.HibernateUtil;

public class LoginQuery {

	public static boolean queryLogin(String mail, String password){
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			
			//Query query = session.createSQLQuery("select * from users_carbox where user_mail = '"+mail+"' and user_password= '"+password+"'");
			Query query = session.createSQLQuery("from user where mail = '"+mail+"' and password= '"+password+"'");
			List<User> userList = query.list();
			
			if(!userList.isEmpty())
				return true;
			else 
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.flush();
			session.getTransaction().commit();
		}
		
		return false;
	}
}
