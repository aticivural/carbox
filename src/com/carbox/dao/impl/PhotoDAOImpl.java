package com.carbox.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.carbox.dao.PhotoDAO;
import com.carbox.model.Photo;
import com.carbox.util.HibernateUtil;

public class PhotoDAOImpl implements PhotoDAO {

	@Override
	public void addPhoto(Photo photo) {
		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();

			session.save(photo);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	}

