package com.hcl.railways.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.railways.demo.model.DAOUser;


@Repository
public interface UserRepo extends CrudRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);
	
}