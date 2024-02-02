package com.vicheak.bank.account.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vicheak.bank.account.dto.LoanReponseDTO;

@FeignClient(name = "loan")
public interface LoanFeignClient {

	@GetMapping("/api/loans/{customerId}")
	List<LoanReponseDTO> getLoanInfo(@PathVariable Long customerId);
	
}
