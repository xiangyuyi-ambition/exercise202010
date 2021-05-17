package com.xyy.javase;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-13 14:51
 **/
public class ReentreLockDemo {
    public static void main(String[] args) {
        Object object = new Object();
        new Thread(() ->{
            synchronized (object){
                System.out.println("1");
                synchronized (object){
                    System.out.println("2");
                    synchronized (object){
                        System.out.println("3");
                    }
                }
            }
        }).start();
    }
}
