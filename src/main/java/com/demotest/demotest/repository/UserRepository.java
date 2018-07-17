package com.demotest.demotest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demotest.demotest.modal.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	
	List<Users> findByName(String username); 
	
	@Query("SELECT u FROM Users u WHERE u.dob = "
			+ "(SELECT min(dob) FROM Users)")
	List<Users> findByAge();

}
