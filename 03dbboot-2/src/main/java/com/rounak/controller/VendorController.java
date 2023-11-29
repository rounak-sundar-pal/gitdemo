package com.rounak.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rounak.entities.Vendor;
import com.rounak.services.VendorService;

@RestController
public class VendorController {
	
	@Autowired
	VendorService vendorService;
	
//	http://localhost:8080/vendor
	@RequestMapping("/vendor")
	public List<Vendor> getVendors(){
		
		System.out.println("This is get Entity");
		return vendorService.readAllVendors();
		
	}
	
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myPostBody) {
		System.out.println("This is Post Entity");
		return vendorService.createVendor(myPostBody);
	}
	
	@RequestMapping("vendor/search")
	public List<Vendor> searchByCompany(@RequestParam String company){
		
		return vendorService.searchByCompanyName(company);
	}
	
	@RequestMapping("vendor/lookup/{gstNo}")
	public List<Vendor> searchVendorByGST(@PathVariable("gstNo") String GST){
		
		return vendorService.lookupVendorByGst(GST);
	}
	
	@RequestMapping("vendor/{vendorCode}")
	public Optional<Vendor> getVendorById(@PathVariable("vendorCode") Long code) {
		
		return vendorService.getStringVendor(code);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="vendor")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		
		return vendorService.changeVendor(vendor);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="vendor/{vendorCode}")
	public String deleteVendor(@PathVariable("vendorCode") Long Id) {
		
		return vendorService.deleteVendor(Id);
	}
}
