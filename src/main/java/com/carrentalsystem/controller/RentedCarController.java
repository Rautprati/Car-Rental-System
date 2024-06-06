package com.carrentalsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.carrentalsystem.model.Cars;
import com.carrentalsystem.model.RentedCar;
import com.carrentalsystem.model.User;
import com.carrentalsystem.repository.CarRentalRepository;
import com.carrentalsystem.repository.RentedCarRepository;
import com.carrentalsystem.serviceI.CarrentalService;
import com.carrentalsystem.serviceI.RentedCarService;
import com.carrentalsystem.serviceI.UserService;

@Controller
public class RentedCarController {

	
	@Autowired
	private RentedCarService rcs;
	
	@Autowired
	private RentedCarRepository rcr;
	
	@Autowired
	private CarrentalService cs;
	
	@Autowired
	private CarRentalRepository crr;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private UserController uc;
	
	@GetMapping("/rentcar")
	public String rentCar(@RequestParam int carId,@RequestParam int id, Model model) {
		

		Cars car = cs.getSingleCar(carId);
		User user = us.getSingleUserById(id);
		System.out.println(car.getCarAvailability());
		if(car.getCarAvailability().equalsIgnoreCase("unavailable")) {
			List<Cars> carde = cs.getAllCarsDetails();
			model.addAttribute("data", carde);
			uc.userLogin(user.getUsername(), user.getPassword(), model);
			return "main";

		}
		else {
			
			model.addAttribute("data", car);
			model.addAttribute("list", user);
			return "bill";
		}
		
	}
	
	
	@GetMapping("/rented")
	public String confirmRent(@RequestParam int carId, @RequestParam String carBrand,@RequestParam String carModel,@RequestParam int carRent,@RequestParam long carContact,@RequestParam int days, @RequestParam int id,Model model) {
		Cars car = cs.getSingleCar(carId);
        User user = us.getSingleUserById(id);
//		user.setCar(car);
//		us.saveUserDetails(user);
		rcs.saveRentedCarDetails(carBrand,carModel,carRent,carContact,days,user);
		car.setCarAvailability("Unavailable");
		cs.updateCarDetails(car);
		us.saveUserDetails(user);
		List<Cars> cars=cs.getAllCarsDetails();
		model.addAttribute("data", cars);
		model.addAttribute("list", user);
		return "main";
	}
	
	@GetMapping("/returnCar")
	public String returnRentedCar(@RequestParam String carModel,@RequestParam int id,Model model) {
		Cars car = cs.getSingleCarByModel(carModel);
//		System.out.println(car.getCarBrand());
		User user = us.getSingleUserById(id);
		car.setCarAvailability("Available");
		crr.save(car);
		RentedCar rentedcar = rcs.getSingleUserRentedCarByCarModel(carModel);
//		System.out.println(rentedcar.getId());
		rentedcar.setUser(null);
		rcr.deleteById(rentedcar.getId());
		
		List<Cars> allCars = cs.getAllCarsDetails();
		model.addAttribute("list", user);
		model.addAttribute("data",allCars);
		return "main"; 
	}
}
