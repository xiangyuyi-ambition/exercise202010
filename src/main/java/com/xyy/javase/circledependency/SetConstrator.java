package com.xyy.javase.circledependency;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-14 17:28
 **/
public class SetConstrator {
    public static void main(String[] args) {
        ServiceAA serviceAA = new ServiceAA();
        ServiceBB serviceBB = new ServiceBB();
        serviceAA.setServiceBB(serviceBB);
        serviceBB.setServiceAA(serviceAA);
    }
}
