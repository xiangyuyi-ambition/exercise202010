package com.xyy.javase.circledependency;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-14 17:33
 **/
public class ServiceAA {
    private ServiceBB serviceBB;

    public void setServiceBB(ServiceBB serviceBB){
        this.serviceBB = serviceBB;
        System.out.println("A 设置 B");
    }
}
