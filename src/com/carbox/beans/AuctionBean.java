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

import com.carbox.model.Auction;
import com.carbox.query.Queries;
import com.carbox.util.HttpSessionUtil;

@ManagedBean(name="auctionBean")
@SessionScoped
public class AuctionBean implements Serializable {

	private static final long serialVersionUID = 6877046171613720794L;
	
	@ManagedProperty(value = "#{vehicleDetailBean}")
	private VehicleDetailBean vehicleDetailBean;
	
	public VehicleDetailBean getVehicleDetailBean() {
		return vehicleDetailBean;
	}

	public void setVehicleDetailBean(VehicleDetailBean vehicleDetailBean) {
		this.vehicleDetailBean = vehicleDetailBean;
	}


	
	private String advertiseId;
	private String userId;
	private Double price=0.0;
	
	public String getAdvertiseId() {
		advertiseId = vehicleDetailBean.getAdvertiseId();
		return advertiseId;
	}

	public void setAdvertiseId(String advertiseId) {
		this.advertiseId = advertiseId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
	public void addAuction() {
		Date newAuctionDate = new Date();
		Date startingDate = Queries.getStartingDateDateByAdvertiseId(Integer.valueOf(advertiseId));
		Date finishingDate = Queries.getFinishingDateByAdvertiseId(Integer.valueOf(advertiseId));
		
		if((finishingDate.getTime()-newAuctionDate.getTime())> 0 || (startingDate.getTime()-newAuctionDate.getTime()) < 0 ){
			Double startingPrice = Queries.getStartingPriceByAdvertiseId(Integer.valueOf(advertiseId));
			if(price != null && price > startingPrice){
				Double maxPrice = Queries.getMaxPriceForAuctionByAdvertiseId(Integer.valueOf(advertiseId));
				if(maxPrice != null){
					if(price > maxPrice){
						Auction	newAuction = new Auction(Integer.parseInt(advertiseId),Integer.parseInt(userId), this.price, newAuctionDate);
						Queries.addAuction(newAuction);
					}
				}
				else{
					Auction	newAuction = new Auction(Integer.parseInt(advertiseId),Integer.parseInt(userId), this.price, newAuctionDate);
					Queries.addAuction(newAuction);
				}
				
				
				
			}
		}
		
		
		price = 0.0;
    }
	
	
	public ArrayList<Auction> dbListener(){
		ArrayList<Auction> auctionList2 = new ArrayList<Auction>();
		auctionList2 = Queries.getAllAuctionsByAdvertiseId(Integer.valueOf(advertiseId));
		return auctionList2;
	}
	

	
	
}
