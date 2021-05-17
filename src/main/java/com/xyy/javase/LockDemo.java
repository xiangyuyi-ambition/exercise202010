package com.xyy.javase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-13 15:07
 **/
public class LockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(() ->{
            try{
                lock.lock();
                System.out.println("a");
                try{
                    lock.lock();
                    System.out.println("b");
                    try{
                        lock.lock();
                        System.out.println("c");
                    }finally {
                        lock.unlock();
                    }
                }finally {
                    lock.unlock();
                }
            }finally {
                lock.unlock();
            }
        }).start();
    }
}
