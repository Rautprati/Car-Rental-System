package com.carrentalsystem.serviceI;

import java.util.List;

import com.carrentalsystem.model.Cars;
import com.carrentalsystem.model.RentedCar;
import com.carrentalsystem.model.User;

public interface RentedCarService {

	void saveRentedCarDetails(String carBrand,String carModel,int carRent,long carContact, int days, User user);

	RentedCar getCarDetails(RentedCar car_car_id);

	List<RentedCar> getSingleUserRentedCars(int id);

	void deleteSingleCar(String carModel);

	RentedCar getSingleUserRentedCarByCarModel(String carModel);

}
