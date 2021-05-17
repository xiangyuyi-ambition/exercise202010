package com.xyy.javase.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-13 16:20
 * 可以先唤醒，后阻塞
 **/
public class LockSupportDemo {
    public static void main(String[] args) throws Exception {
        Thread a = new Thread(() ->{
            try{
                System.out.println(Thread.currentThread().getName() + "进入");
                LockSupport.park();
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + "被唤醒");
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        a.start();

        Thread.sleep(3000);

        new Thread(() ->{
            try{
                System.out.println(Thread.currentThread().getName() + "进入");
                LockSupport.unpark(a);
                LockSupport.unpark(a);
                System.out.println(Thread.currentThread().getName() + "尝试进行唤醒");
            }catch (Exception e){
                e.printStackTrace();
            }
        },"b").start();



    }
}
