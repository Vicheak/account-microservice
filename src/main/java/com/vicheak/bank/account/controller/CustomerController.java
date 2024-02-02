package com.vicheak.bank.account.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vicheak.bank.account.dto.CardResponseDTO;
import com.vicheak.bank.account.dto.CustomerDTO;
import com.vicheak.bank.account.dto.CustomerDetailDTO;
import com.vicheak.bank.account.dto.LoanReponseDTO;
import com.vicheak.bank.account.entity.Customer;
import com.vicheak.bank.account.mapper.CustomerMapper;
import com.vicheak.bank.account.service.CustomerService;
import com.vicheak.bank.account.service.client.CardFeignClient;
import com.vicheak.bank.account.service.client.LoanFeignClient;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
	
	private final CustomerService customerService;
	private final CustomerMapper customerMapper; 
	private final CardFeignClient cardFeignClient; 
	private final LoanFeignClient loanFeignClient; 

	@PostMapping
	public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO dto){
		Customer customer = customerMapper.toCustomer(dto); 
	    customer = customerService.save(customer);
		return ResponseEntity.ok(customer); 
	}
	
	@GetMapping
	public ResponseEntity<?> getCustomers(){
		return ResponseEntity.ok(customerService.getCustomers()); 
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable Long customerId){
		return ResponseEntity.ok(customerService.getById(customerId)); 
	}
	
	@GetMapping("/customerDetail/{customerId}")
	public ResponseEntity<CustomerDetailDTO> getCustomerDetail(@PathVariable Long customerId){
		CustomerDetailDTO dto = new CustomerDetailDTO(); 
		Customer customer = customerService.getById(customerId);
		if(customer == null) {
			throw new RuntimeException("No customer found with this id"); 
		}
		
		CustomerDTO customerDTO = customerMapper.toCustomerDTO(customer);
		
		List<LoanReponseDTO> loanInfo = loanFeignClient.getLoanInfo(customerId);
		List<CardResponseDTO> cardInfo = cardFeignClient.getCardInfo(customerId);
		
		dto.setCustomer(customerDTO); 
		dto.setLoans(loanInfo); 
		dto.setCards(cardInfo); 
		
		return ResponseEntity.ok(dto); 
	}
	
}
