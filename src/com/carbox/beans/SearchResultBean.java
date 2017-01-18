package com.carbox.beans;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.carbox.leftmenu.SearchMenu;
import com.carbox.model.GridFeeder;
import com.carbox.query.Queries;


@ManagedBean
@RequestScoped
public class SearchResultBean implements Serializable {

	private static final long serialVersionUID = -8937298672770502516L;
	
	@ManagedProperty( value = "#{searchMenu}")
	private SearchMenu searchMenu;
	
	public SearchMenu getSearchMenu() {
		return searchMenu;
	}

	public void setSearchMenu(SearchMenu searchMenu) {
		this.searchMenu = searchMenu;
	}
	
	private String color;
	private String gear;
	private String fuel;
	private String minPrice;
	private String maxPrice;
	
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGear() {
		return gear;
	}

	public void setGear(String gear) {
		this.gear = gear;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	
	
	private List<GridFeeder> vehicles;
	private GridFeeder selectedVehicle;
	private HashMap<Integer ,Blob> gridMap;
	
	
	@PostConstruct
	public void init() {
		String mainQuery = "select a.ADVERTISEID , a.ADVERTISINGHEADER, p.photo, a.MODEL, a.YEAR, a.KM, a.PRICE, a.COLOR, a.ADVERTISINGDATE  from Advertise a , (Select ADVERTISEID ,photo ,photoid from PHOTO  order by photoid) p,(select min(photoid) as photoid from PHOTO group by ADVERTISEID) c where a.ADVERTISEID = p.ADVERTISEID "
				+ "and p.photoid = c.photoid and a.ISCOMPLETE=1 "
				+ "and a.vehicleType= :vehicleType and a.brand= :brand and a.model= :model and a.motor= :motor and a.hardwarePackage= :hardwarePackage ";
		String queryColor;
		String queryGear;
		String queryFuel;
		String queryPrice;
		
		color = searchMenu.getColor().toString();
		gear = searchMenu.getGear().toString();
		fuel = searchMenu.getFuel().toString();
		minPrice = searchMenu.getMinPrice();
		maxPrice = searchMenu.getMaxPrice();
		
		if( color.length() >= 1 || color != "" ){
			System.out.println(color);
			queryColor = " and a.color ='"+color+"'";
			mainQuery = mainQuery+queryColor;
			color = "";
		}
		
		if(gear.length() >= 1 || gear != "" ) {
			queryGear = " and a.gear ='"+gear+"'";
			mainQuery = mainQuery+queryGear;
			gear = "";
		}
		
		if(fuel.length() >= 1  || fuel != ""){
			queryFuel = " and a.fuel ='"+fuel+"'";
			mainQuery = mainQuery+queryFuel;
			fuel = "";
		}
		
		if ( (minPrice.length() >= 1 || minPrice != "")  && (maxPrice.length() >= 1 || maxPrice != "") ) {
			
			queryPrice = " and a.Price Between '" +minPrice+ "' and '" +maxPrice+ "'";
			mainQuery = mainQuery+queryPrice;
			minPrice = "";
			maxPrice = "";
			
			
		}

		if ( (minPrice.length() >= 1 ) && (maxPrice.length() == 0 || maxPrice != "") ){
			
			queryPrice = " and a.Price > '" +minPrice+ "'";
			mainQuery = mainQuery+queryPrice;
			minPrice = "";
		}

		if ( (minPrice.length() == 0 || minPrice != "") && maxPrice.length() >= 1){
			
			queryPrice = " and a.Price < '" +maxPrice+ "'";
			mainQuery = mainQuery+queryPrice;
			maxPrice = "";
		}

		
		
		vehicles = Queries.getGridListForSearchResults(searchMenu.getVehicleType(), searchMenu.getBrand(), searchMenu.getModel(), searchMenu.getMotor(), searchMenu.getHardwarePackage(),mainQuery);
		initGridMap();

	}
	
	public List<GridFeeder> getVehicles() {
		
		return vehicles;
	}

	public void setVehicles(List<GridFeeder> vehicles) {
		
		this.vehicles = vehicles;
	}

	public GridFeeder getSelectedVehicle() {
		return selectedVehicle;
	}

	public void setSelectedVehicle(GridFeeder selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
	}
	
	public StreamedContent getImageByAdvertiseId(){
		InputStream inputStream;
		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        return new DefaultStreamedContent();
	    }else {
			try {
				String advertiseId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("activeVehicleAdvertiseId");
				inputStream = gridMap.get(Integer.valueOf(advertiseId)).getBinaryStream();
				return new DefaultStreamedContent(inputStream, "image/png");
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	    }
	}
	
	public void initGridMap(){
		gridMap = new HashMap<Integer ,Blob>();
		for(int i = 0;i<vehicles.size();i++){
			gridMap.put(vehicles.get(i).getAdvertiseId(), vehicles.get(i).getPhoto());
		}
		
	}
	
	public String goToVehicleDetail(String advertiseId){
		return "vehicleDetail?faces-redirect=true&advertiseid=" + advertiseId;
	}
}
