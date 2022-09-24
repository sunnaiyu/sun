package com.jsoft.controller;

import com.jsoft.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller // 把当前类放入IOC容器
public class AccountController {

    @Autowired
    private IAccountService accountService;

    public void showUser(Integer id) {
        System.out.println(accountService.findAccountById(id));
    }

}
