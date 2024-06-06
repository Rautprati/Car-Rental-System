package com.carrentalsystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.model.Cars;
import com.carrentalsystem.model.RentedCar;
import com.carrentalsystem.model.User;
import com.carrentalsystem.repository.RentedCarRepository;
import com.carrentalsystem.serviceI.RentedCarService;

@Service
public class RentedCarServiceImpl implements RentedCarService{

	@Autowired
	private RentedCarRepository rcr;

	@Override
	public void saveRentedCarDetails(String carBrand,String carModel,int carRent,long carContact,int days, User user) {
		RentedCar rentedcar = new RentedCar();
		rentedcar.setCarBrand(carBrand);
		rentedcar.setCarModel(carModel);
		rentedcar.setCarRent(carRent*days);
		rentedcar.setCarContact(carContact);
		rentedcar.setDays(days);
//		rentedcar.setCar(car);
		rentedcar.setUser(user);
//		rentedcar.getUser().add(user);
		rcr.save(rentedcar);
		
		
	}

	@Override
	public RentedCar getCarDetails(RentedCar car_car_id) {
		
		return null;
//		return rcr.findByCar(car_car_id);
	}

	@Override
	public List<RentedCar> getSingleUserRentedCars(int id) {
		
		return rcr.getSingleRentedCarByUserId(id);
	}

	@Override
	public void deleteSingleCar(String carModel) {
		
		rcr.deleteBycarModel(carModel);
		
	}

	@Override
	public RentedCar getSingleUserRentedCarByCarModel(String carModel) {
		return rcr.findBycarModel(carModel);
	}
}
