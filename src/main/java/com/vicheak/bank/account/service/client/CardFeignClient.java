package com.vicheak.bank.account.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.vicheak.bank.account.dto.CardResponseDTO;

@FeignClient(name = "card")
public interface CardFeignClient {

	@GetMapping("/api/cards/{customerId}")
	List<CardResponseDTO> getCardInfo(
			@RequestHeader("vicheakbank-correlation-id") String correlationId, 
			@PathVariable Long customerId);
	
}
