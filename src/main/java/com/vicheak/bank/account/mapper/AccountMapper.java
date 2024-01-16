package com.vicheak.bank.account.mapper;

import org.springframework.stereotype.Component;

import com.vicheak.bank.account.dto.AccountDTO;
import com.vicheak.bank.account.entity.Account;

@Component
public class AccountMapper {
	
	public Account toAccount(AccountDTO dto) {
		Account account = new Account(); 
		account.setAccountNumber(dto.getAccountNumber());
		account.setAccountType(dto.getAccountType());
		account.setBranchAddress(dto.getBranchAddress());
		account.setCreateDate(dto.getCreateDate());
		//account.setCustomerId(dto.getCustomerId());
		return account; 
	}

}
