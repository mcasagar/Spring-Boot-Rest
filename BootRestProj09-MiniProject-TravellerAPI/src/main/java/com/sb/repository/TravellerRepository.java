package com.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.entity.Traveller;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Integer> {
	
}
