package com.xyy.javase.circledependency;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-14 17:24
 **/
public class ServiceA {

    private ServiceB serviceB;

    public ServiceA(ServiceB serviceB){
        this.serviceB = serviceB;
    }

}
