package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.AccountType;

import java.util.List;

public interface AccountTypeService {
    List<AccountType> getAllAccountType();
    void addAccountType(AccountType accountType);
    AccountType findAccountTypeById(Long id);
}
