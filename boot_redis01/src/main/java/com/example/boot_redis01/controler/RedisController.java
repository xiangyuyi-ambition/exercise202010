package com.example.boot_redis01.controler;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: exercise
 * @description
 * @author: xiangyuyi
 * @create: 2021-05-16 11:21
 **/
@RestController
public class RedisController {

    public static final String REDIS_LOCK = "redis_lock";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${server.port}")
    private String serverPost;

    @Autowired
    private Redisson redisson;

    @GetMapping("/buy/goods")
    public String buyGoods() throws Exception{
        String value = UUID.randomUUID().toString() + Thread.currentThread().getName();
        RLock lock = redisson.getLock(REDIS_LOCK);
        lock.lock();
        try {
            String result = stringRedisTemplate.opsForValue().get("goods");
            int goodNumber = result == null ? 0 : Integer.valueOf(result);
            if (goodNumber > 0) {
                goodNumber--;
                stringRedisTemplate.opsForValue().set("goods", String.valueOf(goodNumber));
                System.out.println("成功买到商品，库存剩余：" + goodNumber + " server.port:" + serverPost);
                return "成功买到商品，库存剩余：" + goodNumber + "server.port:" + serverPost;
            }
            System.out.println("已售完" + "server.port:" + serverPost);
            return "已售完" + "server.port:" + serverPost;
        }finally {
            if(lock.isLocked() && lock.isHeldByCurrentThread()){
                    lock.unlock();
            }
        }
    }
}
