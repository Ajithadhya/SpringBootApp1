package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Admin;


public interface AdminRepository extends CrudRepository<Admin, Long> {

	Admin findByUsernameAndPasswords(String username, String passwords);
 


	

}