package com.anoop.Onetoone;

import javax.persistence.*;


@Entity
public class Student {
    @Id
	private int id;
	private String name;
	private String email;
	@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)  
	Address address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
