package com.xyy.javase;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-13 11:31
 **/
public class StringDemo {

    public static void main(String[] args) {
        String str = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str);
        System.out.println(str.intern());
        System.out.println(str == str.intern());

        System.out.println();

        String str1 = new StringBuilder("ja").append("va").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());
    }
}
