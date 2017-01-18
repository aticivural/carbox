package com.carbox.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.carbox.dao.AdvertiseDAO;
import com.carbox.model.Advertise;
import com.carbox.util.HibernateUtil;

public class AdvertiseDAOImpl implements AdvertiseDAO {

	@Override
	public void addAdvertise(Advertise advertise) {
		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();

			session.save(advertise);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	

}
