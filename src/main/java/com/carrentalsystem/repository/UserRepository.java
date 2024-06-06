package com.carrentalsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carrentalsystem.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{

	User findByUsernameAndPassword(String username, Long password);

	User findByEmailId(String emailId);

	@Query(value = "select profile from user where id= ?1", nativeQuery = true)
	byte[] findImageById(int id);

	
}
