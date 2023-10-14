 package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Reunion;
import com.klu.repository.ReunionRepository;

@Service
public class ReunionUpdate {
	@Autowired
	ReunionRepository rr;
	public String updatepaymentStatus(Long id,int amount) {
		Reunion temp = rr.findById(id).get();
		temp.setAmount(temp.getAmount()+amount);
		if(temp.getAmount()>=2000) {
			temp.setStatus("fully paid");
		}
		else if(temp.getAmount()==0){
			temp.setStatus("Not paid");
			
		}
		else {
			temp.setStatus("Partially paid");
		}
		rr.save(temp);
		return "Updation done successfully";
	}

}
