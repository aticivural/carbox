package com.carbox.beans;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import com.carbox.model.Advertise;
import com.carbox.model.PhotoFeeder;
import com.carbox.model.User;
import com.carbox.query.Queries;
import com.carbox.util.HttpSessionUtil;

@ManagedBean
@SessionScoped
public class VehicleDetailBean implements Serializable {

	private static final long serialVersionUID = -6683824405878770694L;

	private String advertiseId;
	private List<PhotoFeeder> photos;
	private HashMap<Integer, Blob> galleryMap;
	private boolean isAuction = false;
	Advertise advertiseView = new Advertise();
	User userView = new User();
	int userId;
	
	HttpSession httpSession = HttpSessionUtil.getSession();
	String userIdAsString;
	
	
	public String getUserIdAsString() {
		
		userIdAsString = String.valueOf(httpSession.getAttribute("userId"));
		return userIdAsString;
	}

	public void setUserIdAsString(String userIdAsString) {
		this.userIdAsString = userIdAsString;
	}

	@PostConstruct
	public void init() {

		advertiseId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advertiseid");
		photos = Queries.getAdvertisingPhotoListWithAdvertiseId(Integer.valueOf(advertiseId));
		initGalleryMap();

		advertiseView = Queries.getAdvertiseByAdvertiseId(Integer.valueOf(advertiseId));
		setUserId(advertiseView.getUserId());
		userView = Queries.getUserByUserId(userId);
		

	}

	public void initAction() {

		photos = Queries.getAdvertisingPhotoListWithAdvertiseId(Integer.valueOf(advertiseId));
		initGalleryMap();

		advertiseView = Queries.getAdvertiseByAdvertiseId(Integer.valueOf(advertiseId));
		setUserId(advertiseView.getUserId());
		userView = Queries.getUserByUserId(userId);
		
		isAuction = Queries.isAuction(Integer.valueOf(advertiseId));

	}
	
	

	public void initGalleryMap() {
		galleryMap = new HashMap<Integer, Blob>();
		for (int i = 0; i < photos.size(); i++) {
			galleryMap.put(photos.get(i).getPhotoId(), photos.get(i).getPhoto());
		}
	}

	public StreamedContent getImageByPhotoId() {
		InputStream inputStream;
		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			try {
				String photoId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("photoid");
				inputStream = galleryMap.get(Integer.valueOf(photoId)).getBinaryStream();
				return new DefaultStreamedContent(inputStream, "image/png");

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	public String getAdvertiseId() {
		return advertiseId;
	}

	public void setAdvertiseId(String advertiseId) {
		this.advertiseId = advertiseId;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<PhotoFeeder> getPhotos() {
		return photos;
	}

	public void setPhotos(List<PhotoFeeder> photos) {
		this.photos = photos;
	}

	

	public boolean getIsAuction() {
		this.isAuction = isAuction;
		return isAuction;
	}

	public void setIsAuction(boolean isAuction) {
		this.isAuction = isAuction;
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

	private String advertisingDate;
	// private String advertisingId;
	private String advertisingHeader;
	private String advertisingDetail;
	private String price;
	
	private Date startingDate;
	private Date finishingDate;
	private Double startingPrice;

	private String firstAndLastName;

	public String getFirstAndLastName() {
		firstAndLastName = userView.getName() + " " + userView.getSurname();
		return firstAndLastName;
	}

	public void setFirstAndLastName(String firstAndLastName) {
		this.firstAndLastName = firstAndLastName;
	}

	public String getFirstName() {
		firstName = userView.getName();
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		lastName = firstName = userView.getSurname();
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHomePhone() {
		homePhone = advertiseView.getHomePhone();
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		mobilePhone = homePhone = advertiseView.getMobilePhone();
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMail() {
		mail = userView.getMail();
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getVehicleType() {
		vehicleType = advertiseView.getVehicleType();
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getBrand() {
		brand = advertiseView.getBrand();
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		model = advertiseView.getModel();
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMotor() {
		motor = advertiseView.getMotor();
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getHardwarePackage() {
		hardwarePackage = advertiseView.getHardwarePackage();
		return hardwarePackage;
	}

	public void setHardwarePackage(String hardwarePackage) {
		this.hardwarePackage = hardwarePackage;
	}

	public String getYear() {
		year = advertiseView.getYear();
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getFuel() {
		fuel = advertiseView.getFuel();
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getGear() {
		gear = advertiseView.getGear();
		return gear;
	}

	public void setGear(String gear) {
		this.gear = gear;
	}

	public String getKm() {
		km = advertiseView.getKm();
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public String getColor() {
		color = advertiseView.getColor();
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAdvertisingHeader() {
		advertisingHeader = advertiseView.getAdvertisingHeader();
		return advertisingHeader;
	}

	public void setAdvertisingHeader(String advertisingHeader) {
		this.advertisingHeader = advertisingHeader;
	}

	public String getAdvertisingDetail() {
		advertisingDetail = advertiseView.getAdvertisingDetail();
		return advertisingDetail;
	}

	public void setAdvertisingDetail(String advertisingDetail) {
		this.advertisingDetail = advertisingDetail;
	}

	public String getPrice() {
		price = advertiseView.getPrice();
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAdvertisingDate() {
		advertisingDate = advertiseView.getAdvertisingDate().toString();
		return advertisingDate;
	}

	public void setAdvertisingDate(String advertisingDate) {
		this.advertisingDate = advertisingDate;
	}

	public Date getStartingDate() {
		startingDate = advertiseView.getStartingDate();
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getFinishingDate() {
		finishingDate = advertiseView.getFinishingDate();
		return finishingDate;
	}

	public void setFinishingDate(Date finishingDate) {
		this.finishingDate = finishingDate;
	}

	public Double getStartingPrice() {
		startingPrice = advertiseView.getStartingPrice();
		return startingPrice;
	}

	public void setStartingPrice(Double startingPrice) {
		this.startingPrice = startingPrice;
	}
	
	

}
