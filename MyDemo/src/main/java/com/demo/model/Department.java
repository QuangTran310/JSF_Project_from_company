package com.demo.model;

public class Department {

	private Integer id;

	private String owner;

	private String phoneNumber;

	private String city;

	private String address;

	private String other;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Department() {
	};

	public Department(String owner, String phonNumber, String city, String address, String other) {
		this.owner = owner;
		this.phoneNumber = phonNumber;
		this.city = city;
		this.address = address;
		this.other = other;
	}
}
