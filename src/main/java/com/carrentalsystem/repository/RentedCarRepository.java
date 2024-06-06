package com.carrentalsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carrentalsystem.model.Cars;
import com.carrentalsystem.model.RentedCar;

@Repository
public interface RentedCarRepository extends JpaRepository<RentedCar, Integer>{

//	RentedCar findByCar(RentedCar car_car_id);

	RentedCar findByCarBrand(String carBrand);

	@Query(value="select * from rented_car where user_id = ?", nativeQuery = true)
	List<RentedCar> getSingleRentedCarByUserId(int id);

	void deleteBycarModel(String carModel);

	RentedCar findBycarModel(String carModel);

	

}
