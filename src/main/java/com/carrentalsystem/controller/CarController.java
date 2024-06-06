package com.carrentalsystem.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.carrentalsystem.model.Cars;
import com.carrentalsystem.model.User;
import com.carrentalsystem.serviceI.CarrentalService;
import com.carrentalsystem.serviceI.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;

@Controller
public class CarController {
	
	@Autowired
	private CarrentalService crs;
	
	@Autowired
	private UserService us;
	
	@GetMapping("/")
	public String preHomePage() {
		return "homepage";
	}
	
	@GetMapping("/admin")
	public String adminlogin(Model m) {
		List<Cars> cars = crs.getAllCarsDetails();
		m.addAttribute("data", cars);
		return "adminscreen";
	}
	
	@GetMapping("/enroll")
	public String carRegistrationForm() {
		return "registerCar";
	}
	
	@PostMapping("/submit_car")
	public String submitCar(@RequestParam String carBrand,@RequestParam String carModel,@RequestParam int carYear,MultipartFile carPicture,@RequestParam String carRent,@RequestParam String carContact,@RequestParam String carAvailability, Model m) throws IOException {
		crs.saveCarDetails(carBrand,carModel,carYear,carPicture,carRent,carContact,carAvailability);
		List<Cars> cars = crs.getAllCarsDetails();
		m.addAttribute("data", cars);
		return "adminscreen";
	}
	
	@GetMapping("/remove")
	public String deleteCarDetails(@RequestParam int carId,Model m) {
		List<Cars> cars = crs.deletSingleCar(carId);
		m.addAttribute("data", cars);
		return "adminscreen";
	}
	
	@GetMapping("/edit")
	public String editCarDetails(@RequestParam int carId,Model m) {
		Cars car = crs.getSingleCar(carId);
		m.addAttribute("data", car);
		return "editcar";
	}
	
	@PostMapping("/update_car")
	public String updateCarsDetails(@ModelAttribute Cars car,MultipartFile carPicture, Model m) throws IOException {
		crs.updateCarDetail(car,carPicture);
		List<Cars> ca = crs.getAllCarsDetails();
		m.addAttribute("data", ca);
		return "adminscreen";
	}
	
	@GetMapping("/findimage/{carId}")
	public void findImage(@PathVariable int carId,HttpServletResponse response) throws IOException {
		byte[] image = crs.findImageByCarid(carId);
		OutputStream out = response.getOutputStream();
		response.setContentType("image/jpg");
		out.write(image);
		out.flush();
		out.close();
		System.out.println("M3 method called"+ carId);
	}
	
	@GetMapping("/available_cars")
	public String availableCarsDetails(@RequestParam int id,Model model) {
		User user = us.getSingleUserById(id);
		List<Cars> cars = crs.getAllCarsDetails();
		for(Cars car : cars) {
			System.out.println("inside for loop");
			System.out.println(car.getCarAvailability());
		List<Cars> availablecars = crs.getAvailableCars(car.getCarAvailability());
		model.addAttribute("data", availablecars);
		}
		model.addAttribute("list", user);
		return "available";
	}
	
	@GetMapping("/unavailable_cars")
	public String UnavilableCarsDetails(@RequestParam int id,Model model) {
		User user = us.getSingleUserById(id);
		List<Cars> cars = crs.getAllCarsDetails();
		for(Cars car : cars) {
			System.out.println("inside for loop unavai");
			System.out.println(car.getCarAvailability());
		List<Cars> unavailablecars = crs.getUnavailableCars(car.getCarAvailability());
		
		model.addAttribute("data", unavailablecars);
		}
		model.addAttribute("list", user);
		return "unavailable";
	}

}
