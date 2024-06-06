package com.carrentalsystem.serviceI;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.carrentalsystem.model.User;

public interface UserService {

	void saveUserDetails( User user);

	User getUserDetails(String username, Long password);

	User getUserDetailsByEmail(String emailId);

	User getSingleUserById(int id);

	void updateUserDetails(User user) throws IOException;

	byte[] findImageByid(int id);

}
