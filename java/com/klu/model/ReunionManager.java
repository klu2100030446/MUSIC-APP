package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Reunion;
import com.klu.repository.ReunionRepository;

@Service
//until we write service annotation this class will not allow the DI(dependency injection)
public class ReunionManager {
	@Autowired
	ReunionRepository rr;
	public String registration(Reunion ru1) {
		rr.save(ru1);
		return "Registration done successfully";
		
	}
	

}
