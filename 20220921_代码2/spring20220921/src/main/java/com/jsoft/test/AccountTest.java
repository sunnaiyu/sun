package com.jsoft.test;

import com.jsoft.entity.Account;
import com.jsoft.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class AccountTest {

    /*
    * 如果说要使用spring的自动装配的注解，
    * */
    @Resource
    JdbcTemplate jdbcTemplate;

    @Resource
    Account account;

    @Resource
    IAccountService accountService;

    @Test
    public void testAOP() {
        accountService.findAccountById(1);
//        accountService.findAccountByUsername("");
    }

    @Test
    public void testAccount() {
        
        /*
        * spring的bean的生命周期：
        * 1、构造器
        * 2、属性注入
        * 3、初始化方法
        * 4、目标方法
        * 5、销毁
        *
        * 懒初始化（延迟初始化）
        * 1、servlet的初始化，默认就是懒初始化，load-on-startup 1
        * 2、spring的IOC容器默认就是非懒初始化，只要spring的容器启动，所有的bean都会加载，都会初始化
        *
        *
        * */
       System.out.println(account);
    }

    @Test
    public void MVCTest() throws SQLException {
//        jdbcTemplate.execute("insert into account values(null,'admin','123456')");
//        int[] ints = jdbcTemplate.batchUpdate("insert into account values(null,'admin1','123456')",
//                "insert into account values(null,'admin2','123456')");
//        System.out.println(Arrays.toString(ints));
//        System.out.println(jdbcTemplate.getMaxRows());
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select id,username,password from account");
//        System.out.println(maps);
//        RowMapper<Account> rowMapper = new RowMapper<Account>() {
//
//            @Override
//            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Account account = new Account();
//                account.setId(rs.getInt("id"));
//                account.setUsername(rs.getString("username"));
//                account.setPassword(rs.getString("password"));
//                return account;
//            }
//        };
//
//        List<Account> list = jdbcTemplate.query("select id,username,password from account", rowMapper);
//        System.out.println(list);

        // =>   ->
        RowMapper<Account> rowMapper1 = (rs,rownum) -> {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setUsername(rs.getString("username"));
            account.setPassword(rs.getString("password"));
            return account;
        };


        Account account = jdbcTemplate.queryForObject("select id,username,password from account where id = 1", rowMapper1);
        System.out.println(account);
    }
    @Test
    public void a(){
        ArrayList<String> list = new ArrayList(); list.add("1"); list.add("2"); list.add("3"); for (int i = list.size(); i > 0; i--) { list.remove(i); }

    }


}
