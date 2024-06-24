package com.example.RestApi.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.RestApi.models.Blogs;
import com.example.RestApi.projection.BlogsProjection;

public interface BlogsRepo extends CrudRepository<Blogs, Integer>{

}
