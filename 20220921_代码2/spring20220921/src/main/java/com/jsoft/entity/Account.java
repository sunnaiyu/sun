package com.jsoft.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@ToString
public class Account {

    private Integer id;
    private String username;
    private String password;
    private Date birthday;

    public Account() {
        System.out.println("-----构造-----");
    }
    public void setId(Integer id) {
        System.out.println("-----注入-----");
        this.id = id;
    }


    public void init() {
        System.out.println("-----初始化-----");
    }

    public void destroy() {
        System.out.println("-----销毁-----");
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
