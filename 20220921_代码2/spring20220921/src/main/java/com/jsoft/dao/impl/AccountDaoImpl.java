package com.jsoft.dao.impl;

import com.jsoft.dao.IAccountDao;
import com.jsoft.entity.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;

//@Component
@Repository
public class AccountDaoImpl implements IAccountDao {

    @Override
    public Account findAccountById(Integer id) {
        return new Account(1,"admin","123456",new Date());
    }
}
