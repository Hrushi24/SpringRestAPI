package com.example.RestApi.projection;

import org.springframework.data.repository.CrudRepository;

import com.example.RestApi.models.Address;

public interface AddressRepo extends CrudRepository<Address, Integer>{

}
