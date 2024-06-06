package com.carrentalsystem.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.carrentalsystem.model.User;
import com.carrentalsystem.repository.UserRepository;
import com.carrentalsystem.serviceI.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository ur;

	@Override
	public void saveUserDetails( User user) {
		ur.save(user);
		
	}

	@Override
	public User getUserDetails(String username,Long password) {
		
		return  ur.findByUsernameAndPassword(username,password);
		
	}

	@Override
	public User getUserDetailsByEmail(String emailId) {
		
		return ur.findByEmailId(emailId);
	}

	@Override
	public User getSingleUserById(int id) {
		
		return ur.findById(id).get();
	}

	@Override
	public void updateUserDetails(	User user) throws IOException {
		
	    // Retrieve existing user from database by ID
	    User existingUser = ur.findById(user.getId()).get();
	    System.out.println(existingUser.getUsername());
	    if (existingUser != null) {
	        // Update user details
//	        existingUser.setName(user.getName());
	    	System.out.println("Inside the existing user if else case");
	    	
	        existingUser.setMobileno(user.getMobileno());
	        existingUser.setAddress(user.getAddress());
	        existingUser.setPostcode(user.getPostcode());
	        existingUser.setState(user.getState());
	        existingUser.setArea(user.getArea());
	        existingUser.setEducation(user.getEducation());
	        existingUser.setCountry(user.getCountry());
//	        existingUser.setEmailId(user.getEmailId());
//	        if (profile.getSize()==0) {
//		        user.setProfile(profile.getBytes());
//		    }
	        // Save updated user
	        
	    }
	    ur.save(existingUser);
	}

	@Override
	public byte[] findImageByid(int id) {
		
		return ur.findImageById(id);
	}

	
	
}
