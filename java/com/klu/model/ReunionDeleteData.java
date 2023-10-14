package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.repository.ReunionRepository;

@Service
public class ReunionDeleteData {
	@Autowired
	ReunionRepository rr;
	public String deleteData(Long id) {
		rr.deleteById(id);
		return "Registration cancelled successfully";
		
	}

}
