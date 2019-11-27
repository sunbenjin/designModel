package com.java.proxy.proxy7;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TimeProxy {

    @Before("execution(void com.java.proxy.proxy7.Tank.move())")
    public void before(){
        System.out.println("method start..."+ System.currentTimeMillis());
    }
    @After("execution(void com.java.proxy.proxy7.Tank.move())")
    public void after(){
        System.out.println("method after..."+System.currentTimeMillis());
    }

}
