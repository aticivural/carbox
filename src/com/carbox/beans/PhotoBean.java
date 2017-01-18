package com.carbox.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.carbox.dao.PhotoDAO;
import com.carbox.dao.impl.PhotoDAOImpl;
import com.carbox.model.Advertise;
import com.carbox.model.Photo;
import com.carbox.model.User;
import com.carbox.util.HibernateUtil;

@ManagedBean
@SessionScoped
public class PhotoBean {

	@ManagedProperty(value = "#{advertiseBean}")
	private AdvertiseBean advertiseBean;

	public AdvertiseBean getAdvertiseBean() {
		return advertiseBean;
	}

	public void setAdvertiseBean(AdvertiseBean advertiseBean) {
		this.advertiseBean = advertiseBean;
	}

	int userId = advertiseBean.userId;
	int advertiseId;
	Advertise advertise = new Advertise();

	{
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();

			Query query = session.createQuery("select a.userId from Advertise a where a.userId = :userId ");
			query.setInteger("userId", userId);
			List<Advertise> advertiseList = query.list();
			advertise = (Advertise) advertiseList.get(0);
			advertiseId = advertise.getAdvertiseId();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
		System.out.println(advertiseId);

	}

	public Photo photo;
	private ArrayList<Photo> photoList = new ArrayList<Photo>();

	PhotoDAO photoDAOImpl = new PhotoDAOImpl();

	UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void addPhoto() {
		if (file != null) {
			photo = new Photo(userId, 160, file.getContents());
			photoList.add(photo);
			System.out.println("success");
		}
	}

	public void uploadPhotos() {
		try {
			if (file != null && !photoList.isEmpty()) {

				for (Photo photo : photoList) {
					photoDAOImpl.addPhoto(photo);
				}

				/*
				 * photoDAOImpl.addPhoto(photo); // photoList.add(photo);
				 * 
				 * System.out.println(file.getFileName()); System.out.println(
				 * "Inserting Successfully!");
				 * 
				 * FacesMessage msg = new FacesMessage("Succesful",
				 * file.getFileName() + " is uploaded.");
				 * FacesContext.getCurrentInstance().addMessage(null, msg);
				 */

			}

		} catch (Exception e1) {
			System.out.println("Exception-File Upload." + e1.getMessage());
		}
	}

}
