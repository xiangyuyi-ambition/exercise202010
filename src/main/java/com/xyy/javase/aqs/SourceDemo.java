package com.xyy.javase.aqs;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-14 10:31
 **/
public class SourceDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        //lock.lock();
        new HashMap<>().put("a","c");
    }
}
