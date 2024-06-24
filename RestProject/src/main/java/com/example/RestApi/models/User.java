package com.example.RestApi.models;



import java.util.List;

import com.example.RestApi.projection.BlogsProjection;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity 
@Data //this annotation is replacement for all the getter setters and constructor
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Size(min=3 , max=20 ,message = " Name should be between 3 to 20 charechteres.")
	private String name;
	private String city;
	
	@NotEmpty
	@Email
	@NotNull(message = "Email should not be null")
	private String email;
	private String password;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToMany(mappedBy = "user")
	private List<Blogs> blogs;
	
	
//	public User() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public User(int id, String name, String city, String email, String password) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.city = city;
//		this.email = email;
//		this.password = password;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + ", password=" + password
//				+ "]";
//	}
	


}
