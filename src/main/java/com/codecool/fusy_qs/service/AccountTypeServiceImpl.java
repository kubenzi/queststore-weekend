package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.AccountType;
import com.codecool.fusy_qs.repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {
    AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeServiceImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountType> getAllAccountType() {
        return (List<AccountType>) accountTypeRepository.findAll();
    }

    @Override
    public void addAccountType(AccountType accountType) {
        accountTypeRepository.save(accountType);
    }

    @Override
    public AccountType findAccountTypeById(Long id) {
        return accountTypeRepository.findById(id).orElse(null);
    }

    @PostConstruct
    public void postConstruct(){

    }
}
