package com.hxm.service;

import com.hxm.domain.Account;

import java.util.List;

/**
 * @author zrq
 * @version 1.0
 * @discription com.hxm.service
 * @date 2018/11/28
 */
public interface IAccountService {
    List<Account> findAll();

    void saveAccount(Account account);
}
