package com.capensis.spring.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PersonProxy {
    //后置通知（返回通知）
    @Before(value = "execution(* com.capensis.spring.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("Person Before.........");
    }
}
