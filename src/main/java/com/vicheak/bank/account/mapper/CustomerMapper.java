package com.vicheak.bank.account.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.vicheak.bank.account.dto.CustomerDTO;
import com.vicheak.bank.account.entity.Customer;

@Component
public class CustomerMapper {
	
	public Customer toCustomer(CustomerDTO dto) {
		Customer customer = new Customer();
		customer.setName(dto.getName()); 
		customer.setEmail(dto.getEmail());
		customer.setMobileNumber(dto.getMobileNumber());
		customer.setCreateDate(LocalDate.parse(dto.getCreateDate()));
		return customer; 
	}
	
	public CustomerDTO toCustomerDTO(Customer entity) {
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomerId(entity.getCustomerId().toString());
		dto.setName(entity.getName()); 
		dto.setEmail(entity.getEmail());
		dto.setMobileNumber(entity.getMobileNumber());
		dto.setCreateDate(entity.getCreateDate() != null ? entity.getCreateDate().toString() : "");
		return dto; 
	}

}
