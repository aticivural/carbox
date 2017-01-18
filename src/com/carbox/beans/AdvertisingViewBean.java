package com.carbox.beans;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.carbox.model.GridFeeder;
import com.carbox.query.Queries;

@ManagedBean
@RequestScoped
public class AdvertisingViewBean implements Serializable {

	private static final long serialVersionUID = -544834737134003976L;

	private List<GridFeeder> vehicles;
	private GridFeeder selectedVehicle;
	private HashMap<Integer ,Blob> gridMap;
	
	@PostConstruct
	public void init() {

		vehicles = Queries.getGridList();
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
