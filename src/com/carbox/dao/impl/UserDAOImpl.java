package com.carbox.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.carbox.dao.UserDAO;
import com.carbox.model.*;
import com.carbox.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public void addUser(User user) {
		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			if(session.getTransaction().isActive() == false )
				session.getTransaction().begin();

			session.save(user);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserById(int id) {

		User user = null;

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();

			user = (User) session.get(User.class, id);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return user;
	}


	@Override
	public void update(User user, int id) {

		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();

			User newUser = (User) session.get(User.class, id);
			newUser.setName(user.getName());
			newUser.setSurname(user.getSurname());
			newUser.setMail(user.getMail());
			newUser.setPassword(user.getPassword());
			session.update(newUser);

			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {

		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();

			User user = (User) session.get(User.class, id);
			session.delete(user);

			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

}
