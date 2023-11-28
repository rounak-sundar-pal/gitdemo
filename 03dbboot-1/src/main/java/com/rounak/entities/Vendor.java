package com.rounak.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="VENDOR")
public class Vendor {

	@Id
	@Column(nullable = false, name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	@Column(nullable = false, name="FIRST_NAME")
	public String firstName;
	@Column(nullable = false, name="LAST_NAME")
	public String lastName;
	@Column(nullable = false, name="COMPANY_NAME")
	public String companyName;
	@Column(nullable = false, name="EMAIL")
	public String email;
	@Column(nullable = false, name="WEBSITE")
	public String website;
	@Column(nullable = false, name="STATUS")
	public String status;
	@Column(nullable = false, name="GST_NO")
	public String gstNo;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="vendor",referencedColumnName = "ID")
	private List<Address> address = new ArrayList<>();
	  
	public Vendor() {
		
	}
	
	
	public Vendor(Long id, String firstName, String lastName, String companyName, String email, String website,
			String status, String gstNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.email = email;
		this.website = website;
		this.status = status;
		this.gstNo = gstNo;
	}
	
	
	
	public List<Address> getAddress() {
		return address;
	}


	public void setAddress(List<Address> address) {
		this.address = address;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	
	
	
	
}
