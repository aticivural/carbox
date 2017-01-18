package com.carbox.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Vehicle implements Serializable {

	private static final long serialVersionUID = -2331210608156284780L;
	
	private String userId;
	private String user_name;
	private String user_surname;
	private String user_mail;
	
	private String advertiseId;
	private Date advertisingDate;
	private String advertisingDetail;
	private String advertisingHeader;
	private String brand;
	private String color;
	private String fuel;
	private String gear;
	private String hardwarePackage;
	private String homePhone;
	private String mobilePhone;
	private String km;
	private String model;
	private String motor;
	private String price;
	private String vehicleType;
	private String year;
	
	private String photoId;
	private List<Photo> photos;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_surname() {
		return user_surname;
	}
	public void setUser_surname(String user_surname) {
		this.user_surname = user_surname;
	}
	public String getAdvertiseId() {
		return advertiseId;
	}
	public void setAdvertiseId(String advertiseId) {
		this.advertiseId = advertiseId;
	}
	public Date getAdvertisingDate() {
		return advertisingDate;
	}
	public void setAdvertisingDate(Date advertisingDate) {
		this.advertisingDate = advertisingDate;
	}
	public String getAdvertisingDetail() {
		return advertisingDetail;
	}
	public void setAdvertisingDetail(String advertisingDetail) {
		this.advertisingDetail = advertisingDetail;
	}
	public String getAdvertisingHeader() {
		return advertisingHeader;
	}
	public void setAdvertisingHeader(String advertisingHeader) {
		this.advertisingHeader = advertisingHeader;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
	public String getHardwarePackage() {
		return hardwarePackage;
	}
	public void setHardwarePackage(String hardwarePackage) {
		this.hardwarePackage = hardwarePackage;
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
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPhotoId() {
		return photoId;
	}
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	
	
	
	

}
