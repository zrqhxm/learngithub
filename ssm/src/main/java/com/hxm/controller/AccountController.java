package com.hxm.controller;

import com.hxm.domain.Account;
import com.hxm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author zrq
 * @version 1.0
 * @discription com.hxm.controller
 * @date 2018/11/28
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(){
        List<Account> list = accountService.findAll();
        for (Account account : list){
            System.out.println(account);
        }
        System.out.println("springmvc 配置成功！");
        return "list";
    }

    @RequestMapping("/save") //返回值类型为void时，springmvc自动会转发到/WEB-INF/pages/account/save.jsp页面   没有该页面就报错
    public void save(){
        Account account = new Account();
        account.setName("小兰");
        account.setMoney(100d);
        accountService.saveAccount(account);
    }
}
