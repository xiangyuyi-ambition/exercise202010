package com.xyy.javase.circledependency;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-14 17:33
 **/
public class ServiceBB {

    private ServiceAA serviceAA;

    public void setServiceAA(ServiceAA serviceAA){
        this.serviceAA = serviceAA;
        System.out.println("B 设置 A");
    }
}
