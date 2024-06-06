package com.carrentalsystem.serviceImpl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.carrentalsystem.model.Cars;
import com.carrentalsystem.repository.CarRentalRepository;
import com.carrentalsystem.serviceI.CarrentalService;

@Service
public class CarRentalServiceImpl implements CarrentalService{
	
	@Autowired
	private CarRentalRepository crr;

	@Override
	public void saveCarDetails(String carBrand, String carModel, int carYear, MultipartFile carPicture, String carRent,
			String carContact, String carAvailability) throws IOException {
		
		Cars car = new Cars();
		car.setCarBrand(carBrand);
		car.setCarModel(carModel);
		car.setCarYear(carYear);
		if(carPicture.getSize()!=0) {
		car.setCarPicture(carPicture.getBytes());
		}
		car.setCarRent(carRent);
		car.setCarContact(carContact);
		car.setCarAvailability(carAvailability);
		
		crr.save(car);
	}

	@Override
	public List<Cars> getAllCarsDetails() {
		
		return crr.findAll();
	}

	@Override
	public List<Cars> deletSingleCar(int carId) {
		
		crr.deleteById(carId);
		
		return crr.findAll();		
	}

	@Override
	public Cars getSingleCar(int carId) {
		
		return crr.findById(carId).get();
	}

	@Override
	public void updateCarDetails(Cars car) {

	 crr.save(car);
	}

	@Override
	public byte[] findImageByCarid(int carId) {
		 return crr.findImageById(carId);
		
	}

	@Override
	public Cars getSingleCarByModel(String carModel) {
		
		return crr.findBycarModel(carModel);
	}

//	@Override
//	public void updateCarDetail(Cars car) throws IOException {
//		
//	      Cars car = new Cars();
//	if(car.getCarPicture().length==0) {
//		car.setCarPicture(crr.findImageById(car.getCarId()));
//		}
//		else {
//			car.setCarPicture(car.getCarPicture().getBytes());
//		}
//		
//		car = crr.save(car);
//		
//	}

	@Override
	public void updateCarDetail(Cars car, MultipartFile carPicture) throws IOException {
		
		if (carPicture != null && !carPicture.isEmpty()) {
			car.setCarPicture(carPicture.getBytes());
			
		}
		else {
			car.setCarPicture(crr.findImageById(car.getCarId()));
		}
		crr.save(car);
		
	}

	@Override
	public List<Cars> getAvailableCars(String carAvailability) {
		System.out.println("Inside car rental service getavailablecars");
		System.out.println(carAvailability);
		if(carAvailability.equalsIgnoreCase("Available")) {	
			System.out.println("inside if");
			System.out.println(carAvailability);
			return  crr.findBycarAvailability(carAvailability); 
		}
		else {
			return null;
		}
		
		
		 
	}

	@Override
	public List<Cars> getUnavailableCars(String carAvailability) {
		
		System.out.println("Inside car rental service getunavailablecars");
		System.out.println(carAvailability);
		if(carAvailability.equalsIgnoreCase("Unavailable")) {	
			System.out.println("inside if");
			System.out.println(carAvailability);
			return  crr.findBycarAvailability(carAvailability); 
		}
		else {
			return null;
		}
	}



	


}
