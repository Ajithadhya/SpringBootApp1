package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.model.ExchangeValue;;



public interface ExchangeValueRepository extends CrudRepository<ExchangeValue, Long> {


public List<ExchangeValue> findAll();
    @Query("SELECT p FROM ExchangeValue p WHERE p.airport LIKE %?1%")
	public List<ExchangeValue> findAll(String keyword);
	
  }

