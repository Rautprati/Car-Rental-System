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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.carrentalsystem.model.Cars;
import com.carrentalsystem.model.RentedCar;
import com.carrentalsystem.model.User;
import com.carrentalsystem.repository.RentedCarRepository;
import com.carrentalsystem.serviceI.CarrentalService;
import com.carrentalsystem.serviceI.RentedCarService;
import com.carrentalsystem.serviceI.UserService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserController {

	@Autowired
	private UserService us;
	@Autowired
	private CarrentalService cs;
	
	@Autowired
	private RentedCarService rcs;
	
	@Autowired
	private RentedCarRepository rcr;


	@GetMapping("/signup")
	public String userSignUpPage() {
		return "signup";
	}

	@GetMapping("/sign")
	public String userSignUp(@ModelAttribute User user) {
		us.saveUserDetails(user);
		return "homepage";
	}

	@GetMapping("/login")
	public String userLogin(@RequestParam String username, @RequestParam Long password, Model model) {
		
		User user = us.getUserDetails(username, password);
		if (user != null) {
			if ((username.equals(user.getUsername()) && password.equals(user.getPassword())) || (username == null && password == null)) {
				List<Cars> car = cs.getAllCarsDetails();
				model.addAttribute("data", car);
				model.addAttribute("list", user);
				return "main";
			}
			else {
				model.addAttribute("message","username or password incorrect");
				return "homepage";
			}
		} else {
			model.addAttribute("message","username or password incorrect");
			return "homepage";
		}

	}
	
	@GetMapping("/rented_cars")
	public String userRentedCars(@RequestParam int id,Model model)
	{
		User user = us.getSingleUserById(id);
//		List<RentedCar> rentedcars = rcr.findAll();
		List<RentedCar> singleuserrentedcars = rcs.getSingleUserRentedCars(id);
		System.out.println(singleuserrentedcars);
		model.addAttribute("data", user);
//		model.addAttribute("list", car);
		model.addAttribute("list2", singleuserrentedcars);
		return "rentedcars";
	}
	
	@GetMapping("/User_Profile")
	public String userProfileDetails(@RequestParam int id,Model model) {
		
		User user = us.getSingleUserById(id);
		model.addAttribute("data", user);
		return "UserProfile";
	}
	
	@PostMapping("/submit_form")
	public String submituserdetails(User user, Model model) throws IOException {
		
		us.updateUserDetails(user);
		UserController uc = new UserController();
//		uc.userLogin(username, password, null);
		User userlist = us.getSingleUserById(user.getId());
		List<Cars> allcars = cs.getAllCarsDetails();
		model.addAttribute("data", allcars);
		model.addAttribute("list", userlist);
		return "main";
	}
	
	@GetMapping("/findUserimage/{id}")
	public void findUserImage(@PathVariable int id,HttpServletResponse response) throws IOException {
		byte[] profile = us.findImageByid(id);
		OutputStream out = response.getOutputStream();
		response.setContentType("profile/jpg");
		out.write(profile);
		out.flush();
		out.close();
		System.out.println("M3 method called"+ id);
	}
	
}
