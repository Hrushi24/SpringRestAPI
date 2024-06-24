package com.example.RestApi.controller;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.RestApi.models.Address;
import com.example.RestApi.models.Blogs;
import com.example.RestApi.models.User;
import com.example.RestApi.projection.UserProjection;
import com.example.RestApi.services.UserService;
import com.example.RestApi.wrapperClass.WrapperUser;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController

@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userServices;
	
	@Autowired
	WrapperUser wrapperUser;
	
	@GetMapping("")
	public ResponseEntity getAllUsers() 
	{
		wrapperUser.setMsg("Get all the users.");
		wrapperUser.setData(this.userServices.getAll());
		
		return new ResponseEntity<>(wrapperUser,HttpStatus.CREATED);
	}
	
	
	@PostMapping("")
	public ResponseEntity createUser(@RequestBody @Valid User user) 
	{
		wrapperUser.setMsg("User Created succesfully");
		wrapperUser.setData(this.userServices.create(user));
		
		return new ResponseEntity<>(wrapperUser ,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getUserId(@PathVariable int id) 
	{
		UserProjection user = (UserProjection) this.userServices.getUserById(id);
		
		String msgForId = "User of id :"+id+". "; //modification of own
		wrapperUser.setMsg(msgForId);
//		wrapperUser.setData( this.userServices.getUserById(id));
		wrapperUser.setData( user);
		return new ResponseEntity<>(wrapperUser, HttpStatus.OK);
		
	}
//	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteUser(@PathVariable int id) 
	{
//		User user = this.userServices.getUserById(id);
//		if(user==null) 
//		{
//			//return new ResponseEntity<>("User not found, unable to delete", HttpStatus.NOT_FOUND);
//			throw new ResponseStatusException( HttpStatus.NOT_FOUND , "User not found, unable to delete");
//		}
		
		String msgDeleteUser ="User of id " + id+ " is deleted.";
		wrapperUser.setMsg(msgDeleteUser);
		
//		wrapperUser.setData(user); // which user is deleted is set inside data
		wrapperUser.setData(this.userServices.deleteUser(id)); // we updated deleteUSer(id) method , now it returns user .

//		this.userServices.deleteUser(id); // this will delete data
		return new ResponseEntity<>( wrapperUser, HttpStatus.OK);
	}
//	
	@PutMapping("/{id}")
	public ResponseEntity updateUser(@PathVariable int id, @RequestBody User user) {
		
//		User user1 = this.userServices.getUserById(id);
//		if(user1==null) 
//		{
//			//return new ResponseEntity<>("User not found, unable to update", HttpStatus.NOT_FOUND);
//			throw new ResponseStatusException( HttpStatus.NOT_FOUND , "User not found, unable to update");
//		}
		
		wrapperUser.setMsg("User of id "+ id+" is updated");
		wrapperUser.setData(this.userServices.updateUser(id, user));
//		this.userServices.updateUser(id, user);
		
		return new ResponseEntity<>(wrapperUser, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{id}/address")
    public ResponseEntity addAddress(@PathVariable int id, @RequestBody Address address) {
		
		wrapperUser.setMsg("Address added successfully.");
		wrapperUser.setData(this.userServices.addAddress(id, address));
		return new ResponseEntity<>(wrapperUser, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/address")
   public ResponseEntity retriveAddress(@PathVariable int id) {
		
		wrapperUser.setMsg("Address with id" + id);
		wrapperUser.setData(this.userServices.getAddress(id));
		return new ResponseEntity<>(wrapperUser, HttpStatus.OK);
	}
	
	
	@PostMapping("/{id}/blogs")
	  public ResponseEntity addBlogs(@PathVariable int id , @RequestBody Blogs blogs) {
			
			wrapperUser.setMsg("Blog added successfully.");
			wrapperUser.setData(this.userServices.AddBlogs(id, blogs));
			return new ResponseEntity<>(wrapperUser, HttpStatus.OK);
		}
	
	@GetMapping("/{id}/blogs")
	  public ResponseEntity getBlogs(@PathVariable int id) {
			
			wrapperUser.setMsg("User blog with id "+id);
			wrapperUser.setData(this.userServices.getBlogs(id));
			return new ResponseEntity<>(wrapperUser, HttpStatus.OK);
		}
	

	
}
