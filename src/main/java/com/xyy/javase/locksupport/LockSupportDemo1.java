package com.xyy.javase.locksupport;

import java.util.concurrent.TimeUnit;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-13 15:47
 * 只有调用了wait让出锁之后，线程B才能执行
 * wait与notify必须在同步代码之中，先wait，后notify
 **/
public class LockSupportDemo1 {
    public static void main(String[] args) throws Exception {
        Object object = new Object();
        new Thread(() ->{
            try{Thread.sleep(1000);}catch (Exception e){}
            synchronized (object){
                try{
                    System.out.println(Thread.currentThread().getName() + "进入");
                    Thread.sleep(3000);
                    object.wait();
                    System.out.println(Thread.currentThread().getName() + "被唤醒");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"a").start();


        new Thread(() ->{
            synchronized (object){
                try{
                    object.notify();
                    System.out.println(Thread.currentThread().getName() + "唤醒");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"b").start();

    }
}
