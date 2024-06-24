package com.example.RestApi.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.example.RestApi.models.Address;
import com.example.RestApi.models.Blogs;
import com.example.RestApi.models.User;
import com.example.RestApi.projection.AddressRepo;
import com.example.RestApi.projection.BlogsProjection;
import com.example.RestApi.projection.UserProjection;
import com.example.RestApi.repos.BlogsRepo;
import com.example.RestApi.repos.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo; // UserRepository extends crudRepository which contains methods to make crud operations.

	@Autowired
	AddressRepo addressRepo;
	
	@Autowired
	BlogsRepo blogsRepo;
	
//	HashMap<Integer, User> data = new HashMap<>();
//	AtomicInteger atoInteger = new AtomicInteger();
	
	public User create( User user) 
	{
//		user.setId(atoInteger.incrementAndGet());
//		this.data.put(user.getId(), user);
		       // System.out.println(data);
//		return user;
		return this.userRepo.save(user); 
	}
	
//********************************************************************//
	
//	public Collection<User>getAll()
//	{
//		return this.data.values();
//	}

//	public Iterable<User> getAll()
//	{
//		return this.userRepo.findAll();
//	}
	
	// this to get all users without there password , and to achive that we are using userPRojection
	public Iterable<UserProjection> getAll()
	{
		return this.userRepo.findAllUserBy();
	}
	
	
//********************************************************************//
	

//	public void deleteUser(int id) 
//	{
//		data.remove(id);
//		
//	}
	
	public User deleteUser(int id) 
	{
		User user =  this.userRepo.findById(id).orElseThrow(()->{
			throw new ResponseStatusException( HttpStatus.NOT_FOUND , "User not found.");
		});
		this.userRepo.deleteById(id);
		return user;
	}
	
// *********************************** ////
	
//	public User getUserById(int id) 
//	{
//		return data.get(id);
//	}

	public User getUserByIdWithPassword(Integer id) 
	{
		return this.userRepo.findById(id).orElseThrow(()->{
			throw new ResponseStatusException( HttpStatus.NOT_FOUND , "User not found.");
		});
	}
	
	public UserProjection getUserById(Integer id) 
	{
		return  this.userRepo.findAllById(id).orElseThrow(()->{
			throw new ResponseStatusException( HttpStatus.NOT_FOUND , "User not found.");
		});
	}
	
	
	
//********************************************************************//
	
	
//	public void updateUser(int id , User user) 
//	{
//		user.setId(id); //newly added
//		data.put(id, user);
//	}
	
	public User updateUser(int id , User user) 
	{
		this.userRepo.findById(id).orElseThrow(()->{
			throw new ResponseStatusException( HttpStatus.NOT_FOUND , "User not found.");
		});
		user.setId(id);
		this.userRepo.save(user);
		return user;
	}
	
	//****************************************************************//
	
	public List<UserProjection> getByName(String name)
	{
		return this.userRepo.findByName(name);
	}
	
	public List<UserProjection> getByNameLike(String name)
	{
		return this.userRepo.findByNameContainingIgnoreCase(name);
	}
	
	//****************************************************************//
	
	public Address addAddress(Integer user_id , Address address) 
	{
		User foundUser = this.getUserByIdWithPassword(user_id);
		Address saveAddress = this.addressRepo.save(address);
		foundUser.setAddress(saveAddress);
		this.userRepo.save(foundUser);
		return saveAddress;
	}
	
	public Address getAddress( Integer id) 
	{
		User user = this.getUserByIdWithPassword(id);
		return user.getAddress();
	}
	
	public Blogs AddBlogs(Integer user_id , Blogs blogs) 
	{
		User foundUser = this.getUserByIdWithPassword(user_id);
		blogs.setUser(foundUser);
		return this.blogsRepo.save(blogs);
	}
	
	public List<Blogs> getBlogs(Integer user_id)
	{
		User user = this.getUserByIdWithPassword(user_id);
		return user.getBlogs();
	}
	
//	public List<BlogsProjection> getByTitle()
//	{
//		return this.blogsRepo.findByTitle();
//	}
	
	// own defined  // starts--
	
//	public UserProjection getTitleOnly() 
//	{
//		return this.blogsRepo.
//	}
//	
	// --ends
}
