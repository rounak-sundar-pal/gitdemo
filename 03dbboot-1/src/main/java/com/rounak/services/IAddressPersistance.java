package com.rounak.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rounak.entities.Address;

public interface IAddressPersistance extends JpaRepository<Address, Long>{
	
	
	
}
