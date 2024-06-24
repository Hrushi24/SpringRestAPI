package com.example.RestApi.projection;

import java.util.List;

import com.example.RestApi.models.Address;
import com.example.RestApi.models.Blogs;

public interface UserProjection {

	
	
	public int getId();
	public String getName();
	public String getEmail();
	public String getCity();
	public Address getAddress();
//	public List<Blogs> getBlogs();
	
	public List<BlogsProjection> getBlogs();

	
}
