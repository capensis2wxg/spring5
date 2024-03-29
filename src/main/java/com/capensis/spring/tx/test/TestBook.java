package com.capensis.spring.tx.test;

import com.capensis.spring.tx.service.UserService;
import com.capensis.spring.tx.config.TxConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class TestBook {

    // 基于注解开发
    @Test
    public void testAccount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx-bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    // 基于XML开发
    @Test
    public void testAccount1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx-bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    // 基于完全注解开发
    @Test
    public void testAccount2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    //函数式风格创建对象，交给spring进行管理
    @Test
    public void testGenericApplicationContext() {
        //1 创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //2 调用context的方法对象注册
        context.refresh();
        context.registerBean("user1",User.class, User::new);
        //3 获取在spring注册的对象
       // User user = (User)context.getBean("com.atguigu.spring5.test.User");
        User user = (User)context.getBean("user1");
        System.out.println(user);
    }

}


