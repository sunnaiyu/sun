package com.jsoft.service.impl;

import com.jsoft.annotation.MyLog;
import com.jsoft.dao.IAccountDao;
import com.jsoft.entity.Account;
import com.jsoft.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Component
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private IAccountDao accountDao;

    @Override
    @MyLog
    public Account findAccountById(Integer id) {
        System.out.println("findAccountById方法执行中...");
//        int i = 10 / 0;
        return accountDao.findAccountById(id);
    }

    @Override
    public Account findAccountByUsername(String username) {
        System.out.println("findAccountByUsername方法执行中...");
        return accountDao.findAccountById(1);
        
    }
}
