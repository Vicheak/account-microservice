package com.vicheak.bank.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.vicheak.bank.account.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	

}
