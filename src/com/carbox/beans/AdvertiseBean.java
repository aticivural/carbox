package com.carbox.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.primefaces.model.UploadedFile;

import com.carbox.dao.PhotoDAO;
import com.carbox.dao.impl.PhotoDAOImpl;
import com.carbox.model.Advertise;
import com.carbox.model.Photo;
import com.carbox.model.User;
import com.carbox.query.Queries;
import com.carbox.util.HibernateUtil;
import com.carbox.util.HttpSessionUtil;


@ManagedBean
@SessionScoped
public class AdvertiseBean implements Serializable{

	private static final long serialVersionUID = 256392618419539106L;
	
	@ManagedProperty(value = "#{loginControlBean}")
	private LoginControlBean loginControlBean;

	public LoginControlBean getLoginControlBean() {
		return loginControlBean;
	}

	public void setLoginControlBean(LoginControlBean loginControlBean) {
		this.loginControlBean = loginControlBean;
	}
	
	
	int userId;
	
	public String controlLoggedIn() {
		boolean check = loginControlBean.isLoggedIn();

		if (check == true){
			userId = loginControlBean.getUserID();
			return "/advertise.xhtml?faces-redirect=true";
		}
			
		else
			return "/login.xhtml?faces-redirect=true";
	}

	
	Advertise advertise = new Advertise();
	int advertiseId;

	public String firstStepOfAdvertisingNormal() {

		Advertise newAdvertise = new Advertise();
		newAdvertise.setUserId(userId);
		newAdvertise.setVehicleType(vehicleType);
		newAdvertise.setBrand(brand);
		newAdvertise.setModel(model);
		newAdvertise.setMotor(motor);
		newAdvertise.setHardwarePackage(hardwarePackage);
		newAdvertise.setHomePhone(homePhone);
		newAdvertise.setMobilePhone(mobilePhone);
		newAdvertise.setYear(year);
		newAdvertise.setFuel(fuel);
		newAdvertise.setGear(gear);
		newAdvertise.setKm(km);
		newAdvertise.setColor(color);
		newAdvertise.setAdvertisingHeader(advertisingHeader);
		newAdvertise.setAdvertisingDetail(advertisingDetail);
		newAdvertise.setPrice(price);
		newAdvertise.setAdvertisingDate(new Date());

		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();

			session.save(newAdvertise);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
		
		
		
		if (loginControlBean.isLoggedIn() != false && loginControlBean.getUserID() != null) {
			userId = loginControlBean.getUserID();
			Session session2 = null;
			SessionFactory sessionFactory2 = null;

			try {
				sessionFactory2 = HibernateUtil.getSessionFactory();
				session2 = sessionFactory2.getCurrentSession();
				session2.getTransaction().begin();

				Query query2 = session2.createQuery("from Advertise  where userId = :userId order by advertiseId desc ");
				query2.setInteger("userId", userId);
				List<Advertise> advertiseList = query2.list();
				advertise = (Advertise) advertiseList.get(0);
				advertiseId = advertise.getAdvertiseId();
				//System.out.println(advertiseId);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session2.flush();
				session2.getTransaction().commit();

			}
		}
		


		return "advertisephotos.xhtml?faces-redirect=true";
	}
	
	public String firstStepOfAdvertisingAuction() {

		Advertise newAdvertise = new Advertise();
		newAdvertise.setUserId(userId);
		newAdvertise.setVehicleType(vehicleType);
		newAdvertise.setBrand(brand);
		newAdvertise.setModel(model);
		newAdvertise.setMotor(motor);
		newAdvertise.setHardwarePackage(hardwarePackage);
		newAdvertise.setHomePhone(homePhone);
		newAdvertise.setMobilePhone(mobilePhone);
		newAdvertise.setYear(year);
		newAdvertise.setFuel(fuel);
		newAdvertise.setGear(gear);
		newAdvertise.setKm(km);
		newAdvertise.setColor(color);
		newAdvertise.setAdvertisingHeader(advertisingHeader);
		newAdvertise.setAdvertisingDetail(advertisingDetail);
		newAdvertise.setAdvertisingDate(new Date());
		
		newAdvertise.setStartingDate(startingDate);
		newAdvertise.setFinishingDate(finishingDate);
		newAdvertise.setStartingPrice(startingPrice);
		

		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();

			session.save(newAdvertise);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.getTransaction().commit();
		}
		
		
		
		if (loginControlBean.isLoggedIn() != false && loginControlBean.getUserID() != null) {
			userId = loginControlBean.getUserID();
			Session session2 = null;
			SessionFactory sessionFactory2 = null;

			try {
				sessionFactory2 = HibernateUtil.getSessionFactory();
				session2 = sessionFactory2.getCurrentSession();
				session2.getTransaction().begin();

				Query query2 = session2.createQuery("from Advertise  where userId = :userId order by advertiseId desc ");
				query2.setInteger("userId", userId);
				List<Advertise> advertiseList = query2.list();
				advertise = (Advertise) advertiseList.get(0);
				advertiseId = advertise.getAdvertiseId();
				//System.out.println(advertiseId);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session2.flush();
				session2.getTransaction().commit();

			}
		}
		


		return "advertisephotos.xhtml?faces-redirect=true";
	}
	
	
	
	
	

	private String firstName;
	private String lastName;
	private String homePhone;
	private String mobilePhone;
	private String mail;

	private String vehicleType;
	private String brand;
	private String model;
	private String motor;
	private String hardwarePackage;
	private String year;
	private String fuel;
	private String gear;
	private String km;
	private String color;

	private String advertisingHeader;
	private String advertisingDetail;
	private String price;

	HttpSession httpSession = HttpSessionUtil.getSession();
	public String getFirstName() {
		//firstName = user.getName();
		firstName = (String) httpSession.getAttribute("firstname");
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		//lastName = user.getSurname();
		lastName = (String) httpSession.getAttribute("surname");
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMail() {
		//mail = user.getMail();
		mail = (String) httpSession.getAttribute("mail");
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getHardwarePackage() {
		return hardwarePackage;
	}

	public void setHardwarePackage(String hardwarePackage) {
		this.hardwarePackage = hardwarePackage;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getGear() {
		return gear;
	}

	public void setGear(String gear) {
		this.gear = gear;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAdvertisingHeader() {
		return advertisingHeader;
	}

	public void setAdvertisingHeader(String advertisingHeader) {
		this.advertisingHeader = advertisingHeader;
	}

	public String getAdvertisingDetail() {
		return advertisingDetail;
	}

	public void setAdvertisingDetail(String advertisingDetail) {
		this.advertisingDetail = advertisingDetail;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	private ArrayList<Photo> photoList = new ArrayList<Photo>();

	public ArrayList<Photo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(ArrayList<Photo> photoList) {
		this.photoList = photoList;
	}

	PhotoDAO photoDAOImpl = new PhotoDAOImpl();

	UploadedFile file1;
	UploadedFile file2;
	UploadedFile file3;
	UploadedFile file4;
	UploadedFile file5;
	UploadedFile file6;
	UploadedFile file7;
	UploadedFile file8;
	UploadedFile file9;
	UploadedFile file10;

	public UploadedFile getFile1() {
		return file1;
	}

	public void setFile1(UploadedFile file1) {
		this.file1 = file1;
	}

	public UploadedFile getFile2() {
		return file2;
	}

	public void setFile2(UploadedFile file2) {
		this.file2 = file2;
	}

	public UploadedFile getFile3() {
		return file3;
	}

	public void setFile3(UploadedFile file3) {
		this.file3 = file3;
	}

	public UploadedFile getFile4() {
		return file4;
	}

	public void setFile4(UploadedFile file4) {
		this.file4 = file4;
	}

	public UploadedFile getFile5() {
		return file5;
	}

	public void setFile5(UploadedFile file5) {
		this.file5 = file5;
	}

	public UploadedFile getFile6() {
		return file6;
	}

	public void setFile6(UploadedFile file6) {
		this.file6 = file6;
	}

	public UploadedFile getFile7() {
		return file7;
	}

	public void setFile7(UploadedFile file7) {
		this.file7 = file7;
	}

	public UploadedFile getFile8() {
		return file8;
	}

	public void setFile8(UploadedFile file8) {
		this.file8 = file8;
	}

	public UploadedFile getFile9() {
		return file9;
	}

	public void setFile9(UploadedFile file9) {
		this.file9 = file9;
	}

	public UploadedFile getFile10() {
		return file10;
	}

	public void setFile10(UploadedFile file10) {
		this.file10 = file10;
	}
	
	
	public Photo photo1,photo2,photo3,photo4,photo5,photo6,photo7,photo8,photo9,photo10;
	
	public void addPhoto() {
		if (file1 != null) {
			photo1 = new Photo(userId, advertiseId, file1.getContents());
			photoList.add(photo1);
			//photoMessage = "your photos were added successfully";
		}

		if (file2 != null) {
			photo2 = new Photo(userId, advertiseId, file2.getContents());
			photoList.add(photo2);
			//photoMessage = "your photos were added successfully";
		}
		
		if (file3 != null) {
			photo3 = new Photo(userId, advertiseId, file3.getContents());
			photoList.add(photo3);
			//photoMessage = "your photos were added successfully";
		}

		if (file4 != null) {
			photo4 = new Photo(userId, advertiseId, file4.getContents());
			photoList.add(photo4);
			//photoMessage = "your photos were added successfully";
		}
		
		if (file5 != null) {
			photo5 = new Photo(userId, advertiseId, file5.getContents());
			photoList.add(photo5);
			//photoMessage = "your photos were added successfully";
		}

		if (file6 != null) {
			photo6 = new Photo(userId, advertiseId, file6.getContents());
			photoList.add(photo6);
			//photoMessage = "your photos were added successfully";
		}
		
		if (file7 != null) {
			photo7 = new Photo(userId, advertiseId, file7.getContents());
			photoList.add(photo7);
			//photoMessage = "your photos were added successfully";
		}

		if (file8 != null) {
			photo8 = new Photo(userId, advertiseId, file8.getContents());
			photoList.add(photo8);
			//photoMessage = "your photos were added successfully";
		}
		
		if (file9 != null) {
			photo9 = new Photo(userId, advertiseId, file9.getContents());
			photoList.add(photo9);
			//photoMessage = "your photos were added successfully";
		}

		if (file10 != null) {
			photo10 = new Photo(userId, advertiseId, file10.getContents());
			photoList.add(photo10);
			//photoMessage = "your photos were added successfully";
		}
	}
	
	

	public void uploadPhotos() {
		try {
			if (!photoList.isEmpty()) {

				for (Photo photo : photoList) {
					photoDAOImpl.addPhoto(photo);
				}
			}
			
			Queries.setIsComplete(userId, advertiseId);
			System.out.println("uploading Successfully!");

		} catch (Exception e1) {
			System.out.println("Exception-File Upload." + e1.getMessage());
		}
		photoList.clear();
	}
	
	

	private String photoMessage;

	public String getPhotoMessage() {
		return photoMessage;
	}

	public void setPhotoMessage(String photoMessage) {
		this.photoMessage = photoMessage;
	}
	
	
	
	
	
	
	
	private Date startingDate;
	private Date finishingDate;
	private Double startingPrice;
	private Double auctionPrice;

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getFinishingDate() {
		return finishingDate;
	}

	public void setFinishingDate(Date finishingDate) {
		this.finishingDate = finishingDate;
	}

	public Double getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(Double startingPrice) {
		this.startingPrice = startingPrice;
	}

	public Double getAuctionPrice() {
		return auctionPrice;
	}

	public void setAuctionPrice(Double auctionPrice) {
		this.auctionPrice = auctionPrice;
	}


	

}
