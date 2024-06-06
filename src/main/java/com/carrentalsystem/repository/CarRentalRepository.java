package com.carrentalsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carrentalsystem.model.Cars;

@Repository
public interface CarRentalRepository extends JpaRepository<Cars, Integer>{

	@Query(value = "select car_picture from cars where car_id= ?1", nativeQuery = true)
	byte[] findImageById(int carId);

	Cars findBycarModel(String carModel);

	List<Cars> findBycarAvailability(String carAvailability);

}
