package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.entity.Reunion;
@Repository
public interface ReunionRepository extends JpaRepository<Reunion, Long>{
	

}
