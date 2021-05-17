package com.xyy.javase.circledependency;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-14 17:24
 **/
public class ServiceB {

    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA){
        this.serviceA = serviceA;
    }
}
