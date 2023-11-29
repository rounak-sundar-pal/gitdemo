package com.rounak.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rounak.entities.Vendor;

@Component
public class VendorService {
	
	@Autowired
	IVendorPersistance vendor;
	
	public List<Vendor> readAllVendors(){
		
		return vendor.findAll();
	
	}
	
	public Vendor createVendor(Vendor vendorObj) {
		
		return vendor.save(vendorObj);
		
	}
	
	public List<Vendor> searchByCompanyName(String companyName){
		
		return vendor.findByCompanyName(companyName);
				
	}
	
	public List<Vendor> lookupVendorByGst(String GSTNO){
		
		return vendor.lookupVendorbyGST(GSTNO);
	}
	
	public Optional<Vendor> getStringVendor(Long id) {
		
		return vendor.findById(id);
	}
	
	public Vendor changeVendor(Vendor payLoad) {
		
		Optional<Vendor> myVendor = vendor.findById(payLoad.getId());
		if (!myVendor.isPresent()) {
			return new Vendor((long)0,"","","","","","",null);
		} else {
			return vendor.save(payLoad);
		}
		
	}
	
	public String deleteVendor(Long vendorId) {
		vendor.deleteById(vendorId);
		return "Deleted Successfully";
	}
	
}
