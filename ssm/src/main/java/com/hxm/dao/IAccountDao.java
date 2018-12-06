package com.hxm.dao;

import com.hxm.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zrq
 * @version 1.0
 * @discription com.hxm.dao
 * @date 2018/11/28
 */
public interface IAccountDao {
    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account(name,money) values(#{name},#{money})")
    void saveAccount(Account account);
}
