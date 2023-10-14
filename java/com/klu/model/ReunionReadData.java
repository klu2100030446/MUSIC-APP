package com.klu.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.klu.entity.Reunion;
import com.klu.repository.ReunionRepository;

@Service
public class ReunionReadData {
	@Autowired
	ReunionRepository rr;
	public List<String> readData() {
		List<String> list = new ArrayList<String>();
		for(Reunion ru:rr.findAll()) {
			list.add(convertToJson(ru));
		}
		return list;
	}
	public String convertToJson(Object obj) {
		GsonBuilder gb=new GsonBuilder();
		Gson g = gb.create();
		return g.toJson(obj);
		
	}

}
