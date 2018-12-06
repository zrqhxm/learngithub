package com.hxm.test;

import com.hxm.dao.IAccountDao;
import com.hxm.domain.Account;
import com.hxm.service.IAccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zrq
 * @version 1.0
 * @discription com.hxm.test
 * @date 2018/11/28
 */
public class AccountTest {
    @Test
    public void run1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        accountService.findAll();
    }

    @Test
    public void mybatisTest() throws Exception {
        Account account = new Account();
        account.setName("小红");
        account.setMoney(1234d);
        // 读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sessionFactory.openSession();
        IAccountDao accountDao = session.getMapper(IAccountDao.class);
        accountDao.saveAccount(account);
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void mybatisTest2() throws Exception {

        // 读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建者模式创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlSession
        SqlSession session = sessionFactory.openSession();
        // 获得代理对象
        IAccountDao accountDao = session.getMapper(IAccountDao.class);
        List<Account> list = accountDao.findAll();
        for (Account account : list){
            System.out.println(account);
        }
        session.close();
        in.close();
    }
}
