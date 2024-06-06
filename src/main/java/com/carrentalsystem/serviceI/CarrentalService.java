package com.carrentalsystem.serviceI;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.carrentalsystem.model.Cars;


public interface CarrentalService {

	List<Cars> getAllCarsDetails();

	List<Cars> deletSingleCar(int carId);

	Cars getSingleCar(int carId);

	void updateCarDetails(Cars car);

	void saveCarDetails(String carBrand, String carModel, int carYear, MultipartFile carPicture, String carRent,
			String carContact, String carAvailability) throws IOException;

	byte[] findImageByCarid(int carId);

	Cars getSingleCarByModel(String carModel);

	void updateCarDetail(Cars car, MultipartFile carPicture) throws IOException;

	List<Cars> getAvailableCars(String carAvailability);

	List<Cars> getUnavailableCars(String carAvailability);

//	void updateCarDetail(Cars car) throws IOException;

	


}
