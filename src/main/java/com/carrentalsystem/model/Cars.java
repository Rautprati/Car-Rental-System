package com.carrentalsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Cars {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	private String carBrand;
	private String carModel;
	private int carYear;
	@Column(columnDefinition="LONGBLOB")
	private byte[] carPicture;
	private String carRent;
	private String carContact;
	private String carAvailability;
	

	
		
	public String getCarAvailability() {
		return carAvailability;
	}
	public void setCarAvailability(String carAvailability) {
		this.carAvailability = carAvailability;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public int getCarYear() {
		return carYear;
	}
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	public byte[] getCarPicture() {
		return carPicture;
	}
	public void setCarPicture(byte[] carPicture) {
		this.carPicture = carPicture;
	}
	public String getCarRent() {
		return carRent;
	}
	public void setCarRent(String carRent) {
		this.carRent = carRent;
	}
	public String getCarContact() {
		return carContact;
	}
	public void setCarContact(String carContact) {
		this.carContact = carContact;
	}
	
	
	

}
