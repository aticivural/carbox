package com.carbox.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name = "Photo")
public class Photo implements Serializable {

	private static final long serialVersionUID = -8258809031301955885L;
	
	@Id
	@Column(name = "photoId", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int photoId;
	
	@Column(name = "userId", nullable = false)
	private int userId;
	
	@Column(name = "advertiseId", nullable = false)
	private int advertiseId;
	
	@Lob
	@Column(name = "photo", nullable = false)
	private byte[] photo;

	public Photo(){}
	
	public Photo(int userId, int advertiseId, byte[] photo) {
		super();
		this.userId = userId;
		this.advertiseId = advertiseId;
		this.photo = photo;
	}

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAdvertiseId() {
		return advertiseId;
	}

	public void setAdvertiseId(int advertiseId) {
		this.advertiseId = advertiseId;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	

	

}
