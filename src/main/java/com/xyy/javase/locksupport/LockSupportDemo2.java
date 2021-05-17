package com.xyy.javase.locksupport;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-13 16:06
 * await需要配合lock 与 unlock
 * 先await，后signal
 **/
public class LockSupportDemo2 {
    public static void main(String[] args) {
        Lock lock =new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() ->{
            try{Thread.sleep(100);}catch (Exception e){}
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + "进入");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "被唤醒");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"a").start();

        new Thread(() ->{
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + "进入");
                condition.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"b").start();
    }
}
