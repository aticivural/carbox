package com.carbox.model;

import java.io.Serializable;
import java.sql.Blob;

public class GridFeeder implements Serializable {
	
	private static final long serialVersionUID = 2677031135037340562L;
	
	private int advertiseId;
	private String header;
	private Blob photo;
	
	private String model;
	private String year;
	private String km;
	private String price;
	private String date;
	private String color;
	
	public GridFeeder(){}
	
	public GridFeeder(int advertiseId, String header, Blob photo) {
		super();
		this.advertiseId = advertiseId;
		this.header = header;
		this.photo = photo;
	}
	

	public GridFeeder(int advertiseId, String header, Blob photo, String model, String year, String km, String price, String color, String date) {
		super();
		this.advertiseId = advertiseId;
		this.header = header;
		this.photo = photo;
		this.model = model;
		this.year = year;
		this.km = km;
		this.price = price;
		this.color = color;
		this.date = date;
	}

	public int getAdvertiseId() {
		return advertiseId;
	}

	public void setAdvertiseId(int advertiseId) {
		this.advertiseId = advertiseId;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
}
