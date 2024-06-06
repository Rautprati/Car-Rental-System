package com.carrentalsystem.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class RentedCar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String carBrand;
	private String carModel;
	private int carRent;
	private long carContact;
	private int days;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

//	@ManyToOne(cascade = CascadeType.ALL)
//	private Cars car;
	
	
//	public Cars getCar() {
//		return car;
//	}
//
//	public void setCar(Cars car) {
//		this.car = car;
//	}
	
	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getCarRent() {
		return carRent;
	}

	public void setCarRent(int carRent) {
		this.carRent = carRent;
	}

	public long getCarContact() {
		return carContact;
	}

	public void setCarContact(long carContact) {
		this.carContact = carContact;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
