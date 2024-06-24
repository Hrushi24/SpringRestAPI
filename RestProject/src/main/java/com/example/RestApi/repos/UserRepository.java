package com.example.RestApi.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.RestApi.models.User;
import com.example.RestApi.projection.BlogsProjection;
import com.example.RestApi.projection.UserProjection;



@Repository
public interface UserRepository extends CrudRepository<User , Integer>{

	Iterable<UserProjection> findAllUserBy();
	Optional<UserProjection> findAllById(Integer id);
	List<UserProjection> findByName(String name);
	List<UserProjection> findByNameContainingIgnoreCase(String name);
	
}
