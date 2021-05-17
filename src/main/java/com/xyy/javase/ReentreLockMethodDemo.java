package com.xyy.javase;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-13 14:51
 **/
public class ReentreLockMethodDemo {
    public static void main(String[] args) {
        new ReentreLockMethodDemo().a();

    }

    public synchronized  void a(){
        System.out.println("a");
        b();
    }

    public synchronized  void b(){
        System.out.println("b");
        c();
    }

    public synchronized  void c(){
        System.out.println("c");
    }
}
