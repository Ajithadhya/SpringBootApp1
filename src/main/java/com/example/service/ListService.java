package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Admin;
import com.example.model.ExchangeValue;
import com.example.model.User;
import com.example.repository.AdminRepository;
import com.example.repository.ExchangeValueRepository;
import com.example.repository.UserRepository;

@Service
@Transactional
public class ListService {

   @Autowired
   private ExchangeValueRepository repository;
   @Autowired
   private UserRepository repo;
   @Autowired
   private AdminRepository repo1;
    
   public List<ExchangeValue> listAll() {
       return (List<ExchangeValue>) repository.findAll();
   }
    
   public void save(ExchangeValue exchangevalue) {
       repository.save(exchangevalue);
   }
  
   public List<ExchangeValue> showAllRequest(String keyword){
	   if(keyword !=null) {
		   return repository.findAll(keyword);
	   }
	   
	   return repository.findAll();
   }
   public List<ExchangeValue> showAllFilter(String keyword){
	   if(keyword !=null) {
		   return repository.findAll(keyword);
	   }
	   
	   return repository.findAll();
   }
   public void deleterequest(long id) {
	   repository.deleteById((long) id);
   }
   //User Repository Function
   public void save1(User user) {
       repo.save(user);
   }

   public User findByUsernameAndPassword(String username, String password) {
		return repo.findByUsernameAndPassword(username, password);
	}
   public Admin findByUsernameAndPasswords(String username, String password) {
		return repo1.findByUsernameAndPasswords(username, password);
	}
 
	}
//   public List<ExchangeValue> showAllRequest(){
//		List<ExchangeValue> exchangevalues = new ArrayList<ExchangeValue>();
//		for(ExchangeValue exchangevalue : repository.findAll()) {
//			exchangevalues.add(exchangevalue);
//		}
//		
//		return exchangevalues;
//	}
   

