package com.carbox.leftmenu;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.carbox.model.GridFeeder;
import com.carbox.query.Queries;

@ManagedBean
@SessionScoped
public class SearchMenu implements Serializable {

	private static final long serialVersionUID = 5692257012094643481L;

	private String vehicleType;
	private String brand;
	private String model;
	private String motor;
	private String hardwarePackage;
	
	private String color;
	private String gear;
	private String fuel;
	private String minPrice;
	private String maxPrice;

	

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





	private Map<String, String> vehicleTypes = new HashMap<String, String>();
	private Map<String, String> brands = new HashMap<String, String>();
	private Map<String, String> models = new HashMap<String, String>();
	private Map<String, String> motors = new HashMap<String, String>();
	private Map<String, String> hardwarePackages = new HashMap<String, String>();
	

	List<String> resultVehicleType;
	List<String> resultBrand;
	List<String> resultModel;
	List<String> resultMotor;
	List<String> resultHardwarePackage;
	
	
	/*private String[] selectedFuel;
	private List<String> fuel;
	
	private String[] selectedGear;
	private List<String> gear;
	
	private String[] selectedColor;
	private List<String> color;
	

	public String[] getSelectedFuel() {
		return selectedFuel;
	}

	public void setSelectedFuel(String[] selectedFuel) {
		this.selectedFuel = selectedFuel;
	}

	public List<String> getFuel() {
		return fuel;
	}
	
	
	
	public String[] getSelectedGear() {
		return selectedGear;
	}

	public void setSelectedGear(String[] selectedGear) {
		this.selectedGear = selectedGear;
	}

	public List<String> getGear() {
		return gear;
	}

	
	
	public String[] getSelectedColor() {
		return selectedColor;
	}

	public void setSelectedColor(String[] selectedColor) {
		this.selectedColor = selectedColor;
	}

	public List<String> getColor() {
		return color;
	}*/


	@PostConstruct
	public void init() {
		vehicleTypes.put("Car", "Car");
		vehicleTypes.put("Jeep", "Jeep");
		
		/*fuel = new ArrayList<String>();
		fuel.add("Diesel");
		fuel.add("Gasoline");
		fuel.add("Benzine-LPG");
		
		gear = new ArrayList<String>();
		gear.add("Straight Gear");
		gear.add("Semi Automatic Gear");
		gear.add("Automatic Gear");
		
		color = new ArrayList<String>();
		color.add("White");
		color.add("Black");
		color.add("Gray");
		color.add("Brown");
		color.add("Dark Blue");
		color.add("Smoke-Colored");*/
		
	}

	public Map<String, String> getVehicleTypes() {
		return vehicleTypes;
	}

	public void setVehicleTypes(Map<String, String> vehicleTypes) {
		this.vehicleTypes = vehicleTypes;
	}

	public Map<String, String> getBrands() {
		return brands;
	}

	public void setBrands(Map<String, String> brands) {
		this.brands = brands;
	}

	public Map<String, String> getModels() {
		return models;
	}

	public void setModels(Map<String, String> models) {
		this.models = models;
	}

	public Map<String, String> getMotors() {
		return motors;
	}

	public void setMotors(Map<String, String> motors) {
		this.motors = motors;
	}

	public Map<String, String> getHardwarePackages() {
		return hardwarePackages;
	}

	public void setHardwarePackages(Map<String, String> hardwarePackages) {
		this.hardwarePackages = hardwarePackages;
	}

	public void onVehicleChange() {
		brands = new HashMap<String, String>();
		if (vehicleType != null && !vehicleType.equals("")) {
			resultVehicleType = Queries.getBrands(vehicleType);
		}

		if (resultVehicleType != null) {
			for (String str : resultVehicleType) {
				brands.put(str, str);
			}
		}
	}

	public void onBrandChange() {
		models = new HashMap<String, String>();
		if (brand != null && !brand.equals(""))
			resultBrand = Queries.getModels(vehicleType, brand);

		if (resultBrand != null) {
			for (String str : resultBrand) {
				models.put(str, str);
			}
		}
	}

	public void onModelChange() {
		motors = new HashMap<String, String>();
		if (model != null && !model.equals(""))
			resultModel = Queries.getMotors(vehicleType, brand, model);

		if (resultModel != null) {
			for (String str : resultModel) {
				motors.put(str, str);
			}
		}

	}

	public void onMotorChange() {
		hardwarePackages = new HashMap<String, String>();
		if (motor != null && !motor.equals(""))
			resultMotor = Queries.getHardwarePackage(vehicleType, brand, model, motor);

		if (resultMotor != null) {
			for (String str : resultMotor) {
				hardwarePackages.put(str, str);
			}
		}
	}

	public void onHardwarePackageChange() {
		// hardwarePackages = new HashMap<String, String>();
		if (hardwarePackage != null && !hardwarePackage.equals(""))
			System.out.println(vehicleType + "\n" + brand + "\n" + model + "\n" + motor + "\n" + hardwarePackage);

	}
	
	
	public String searchResults(){
		return "searchresults?faces-redirect=true";
	}
	
	
	
	
}
