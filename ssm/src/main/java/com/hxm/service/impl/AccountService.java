package com.hxm.service.impl;

import com.hxm.dao.IAccountDao;
import com.hxm.domain.Account;
import com.hxm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zrq
 * @version 1.0
 * @discription com.hxm.service.impl
 * @date 2018/11/28
 */
@Service("accountService")
public class AccountService implements IAccountService{

    @Autowired
    private IAccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("业务层：findAll");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
       // int i = 10/0;
    }
}
