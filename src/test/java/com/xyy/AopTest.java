package com.xyy;

import com.xyy.javase.aop.CalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-14 16:37
 **/
@SpringBootTest
public class AopTest {

    @Autowired
    private CalService calService;

    @Test
    public void  test4(){
        System.out.println("Spring 版本 " + SpringVersion.getVersion() + "  springboot版本" + SpringBootVersion.getVersion());
        System.out.println();
        calService.div(4,0);
    }

    @Test
    public void  test5(){
        System.out.println("Spring 版本 " + SpringVersion.getVersion() + "  springboot版本" + SpringBootVersion.getVersion());
        System.out.println();
        calService.div(4,0);
    }

}
