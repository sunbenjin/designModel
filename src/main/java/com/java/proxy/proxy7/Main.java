package com.java.proxy.proxy7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app_auto.xml");
        Tank tank = (Tank)applicationContext.getBean("tank");
        tank.move();
    }
}
