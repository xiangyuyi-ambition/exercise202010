package com.xyy.javase.circledependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-14 17:50
 **/
public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ServiceAA serviceAA = applicationContext.getBean("aa",ServiceAA.class);
        ServiceBB serviceBB = applicationContext.getBean("bb",ServiceBB.class);
        System.out.println(serviceAA);
        System.out.println(serviceBB);
    }
}
