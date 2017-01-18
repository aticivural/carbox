package com.carbox.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Advertises")
public class Advertises implements Serializable {

	private static final long serialVersionUID = -2647208379686941773L;

	@Id
	@Column(name = "advertiseId", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer advertiseId;

	@Column(name = "vehicleType", nullable = false)
	private String vehicleType;

	@Column(name = "brand", nullable = false)
	private String brand;

	@Column(name = "model", nullable = false)
	private String model;

	@Column(name = "motor", nullable = false)
	private String motor;

	@Column(name = "hardwarePackage", nullable = false)
	private String hardwarePackage;

	@Column(name = "userId", nullable = false)
	private int userId;
	
	@Column(name = "isComplete", length=1)
	private int isComplete;

	@Column(name = "homePhone")
	private String homePhone;
	
	@Column(name = "mobilePhone", nullable = false)
	private String mobilePhone;
	
	@Column(name = "year", nullable = false)
	private String year;
	
	@Column(name = "fuel", nullable = false)
	private String fuel;
	
	@Column(name = "gear", nullable = false)
	private String gear;
	
	@Column(name = "km", nullable = false)
	private String km;
	
	@Column(name = "color", nullable = false)
	private String color;
	
	@Column(name = "advertisingHeader", nullable = false)
	private String advertisingHeader;
	
	@Column(name = "advertisingDetail")
	private String advertisingDetail;
	
	@Column(name = "price", nullable = false)
	private String price;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "advertisingDate", nullable = false, updatable=false)
	private Date advertisingDate;
	
	
	
	
	@Column(name = "startingDate", nullable = false)
	private Date startingDate;
	
	@Column(name = "finishingDate", nullable = false)
	private Date finishingDate;
	
	@Column(name = "startingPrice", nullable = false)
	private int startingPrice;
	
	


	public Advertises() {
	}

	public Advertises(int userId, String vehicleType, String brand, String model, String motor, String hardwarePackage,
					String homePhone, String mobilePhone, String year, String fuel, String gear, String km, String color,
					String advertisingHeader, String advertisingDetail, String price ) {
		super();
		this.userId = userId;
		this.vehicleType = vehicleType;
		this.brand = brand;
		this.model = model;
		this.motor = motor;
		this.hardwarePackage = hardwarePackage;
		
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.year = year;
		this.fuel = fuel;
		this.gear = gear;
		this.km = km;
		this.color = color;
		this.advertisingHeader = advertisingHeader;
		this.advertisingDetail = advertisingDetail;
		this.price = price;
		this.advertisingDate = new Date();
	}

	public int getAdvertiseId() {
		return advertiseId;
	}

	public void setAdvertiseId(int advertiseId) {
		this.advertiseId = advertiseId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Date getAdvertisingDate() {
		return advertisingDate;
	}

	public void setAdvertisingDate(Date advertisingDate) {
		this.advertisingDate = advertisingDate;
	}
	
	
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

	public int getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(int startingPrice) {
		this.startingPrice = startingPrice;
	}
	
	

}
