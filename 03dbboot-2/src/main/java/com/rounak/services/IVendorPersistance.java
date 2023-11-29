package com.rounak.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rounak.entities.Vendor;

public interface IVendorPersistance extends JpaRepository<Vendor, Long>{
	
	List <Vendor> findByCompanyName(String companyName);
	
	@Query(nativeQuery = true,
			value = "SELECT * FROM public.vendor where lower(GST_NO) like %?1% ")
	List<Vendor> lookupVendorbyGST(String GSTNo);
}
