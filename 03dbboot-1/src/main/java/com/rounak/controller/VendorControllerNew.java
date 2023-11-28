package com.rounak.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rounak.entities.Vendor;

@RepositoryRestResource(collectionResourceRel = "vendor" , path = "newVendor")
public interface VendorControllerNew extends JpaRepository<Vendor, Long>{

}
