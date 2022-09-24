package com.jsoft.service;

import com.jsoft.entity.Account;

public interface IAccountService {

    Account findAccountById(Integer id);

    Account findAccountByUsername(String username);


}
