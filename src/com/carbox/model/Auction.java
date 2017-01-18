package com.carbox.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Auction")
public class Auction implements Serializable  {

	private static final long serialVersionUID = 5202563941485520634L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auctionId", nullable = false)
	private Integer auctionId;
	
	@Column(name = "advertiseId", nullable = false)
	private Integer advertiseId;
	
	@Column(name = "userId", nullable = false)
	private Integer userId;
	
	@Column(name = "auctionPrice", nullable = false)
	private Double auctionPrice;
	
	@Column(name = "auctionDate", nullable = false)
	private Date auctionDate;
	
	
	public Auction(){}
	public Auction(Integer advertiseId, Double price, Date date){
		super();
		this.advertiseId = advertiseId;
		this.auctionPrice = price;
		this.auctionDate = date;
	}
	
	public Auction(Integer advertiseId, Integer userId, Double auctionPrice, Date auctionDate) {
		super();
		this.advertiseId = advertiseId;
		this.userId = userId;
		this.auctionPrice = auctionPrice;
		this.auctionDate = auctionDate;
	}
	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public Integer getAdvertiseId() {
		return advertiseId;
	}

	public void setAdvertiseId(Integer advertiseId) {
		this.advertiseId = advertiseId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getAuctionPrice() {
		return auctionPrice;
	}

	public void setAuctionPrice(Double auctionPrice) {
		this.auctionPrice = auctionPrice;
	}

	public Date getAuctionDate() {
		return auctionDate;
	}

	public void setAuctionDate(Date auctionDate) {
		this.auctionDate = auctionDate;
	}

	

	
}
