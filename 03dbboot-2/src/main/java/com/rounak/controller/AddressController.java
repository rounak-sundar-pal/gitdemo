package com.rounak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rounak.entities.Address;
import com.rounak.services.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	AddressService addser;
	
	@RequestMapping("/address")
	public List<Address> getAddress(){
		
		return addser.getAddress();		
	}
	
	@PostMapping("/address")
	public Address createAddress(@RequestBody Address payload) {
		
		return addser.createAddress(payload);
		
	}
	
}
