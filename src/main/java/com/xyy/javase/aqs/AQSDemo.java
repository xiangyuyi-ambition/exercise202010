package com.xyy.javase.aqs;

import com.xyy.javase.ReentreLockMethodDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-14 11:55
 **/
public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock reentreLock = new ReentrantLock();
        new Thread(() ->{
            reentreLock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + "Come in");
                TimeUnit.MINUTES.sleep(20);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                reentreLock.unlock();
            }

        },"A").start();

        new Thread(() ->{
            reentreLock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + "Come in");
                TimeUnit.MINUTES.sleep(20);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                reentreLock.unlock();
            }

        },"B").start();
    }
}
