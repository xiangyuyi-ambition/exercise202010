package com.xyy.javase.aop;

import org.springframework.stereotype.Service;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-14 15:56
 **/
@Service
public class CalServiceImpl implements CalService {

    @Override
    public int div(int x, int y) {
        int result = x/y;
        System.out.println("result： " + result);
        return result;
    }
}
