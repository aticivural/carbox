package com.carbox.model;

import java.io.Serializable;
import java.sql.Blob;

public class PhotoFeeder implements Serializable {
	
	private static final long serialVersionUID = 8583010245728626516L;
	
	private int photoId;
	private Blob photo;
	
	public PhotoFeeder(){
		
	}

	public PhotoFeeder(int photoId, Blob photo) {
		super();
		this.photoId = photoId;
		this.photo = photo;
	}

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	
	
}
