package com.chakray.modelo;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(generator = "increment")
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "street", nullable = false)
	private String street;
	
	@Column(name = "country_code", nullable = false)
	private String country_code;
	
	
	@OneToOne
	@JoinColumn(name = "related_user", referencedColumnName = "id", nullable = false)
	@JsonIgnoreProperties({"email", "name", "password", "created_at"})
	private User relatedUser;


	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Address(int id, String name, String street, String country_code, User related_user) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.country_code = country_code;
		this.relatedUser = related_user;
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


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCountry_code() {
		return country_code;
	}


	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}


	public User getRelated_user() {
		return relatedUser;
	}


	public void setRelated_user(User related_user) {
		this.relatedUser = related_user;
	}
	
	
}
