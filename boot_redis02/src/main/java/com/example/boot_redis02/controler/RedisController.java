package com.example.boot_redis02.controler;

import com.example.boot_redis02.util.RedisUtils;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
            //Boolean aBoolean = stringRedisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, value,10,TimeUnit.SECONDS);
            //stringRedisTemplate.expire(REDIS_LOCK, 10, TimeUnit.SECONDS);
//            if (!aBoolean) {
//                return "抢锁失败";
//            }
            //get key
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
//            while (true){
//                stringRedisTemplate.watch(REDIS_LOCK);
//                if(value.equalsIgnoreCase(stringRedisTemplate.opsForValue().get(REDIS_LOCK))){
//                    stringRedisTemplate.setEnableTransactionSupport(true);
//                    stringRedisTemplate.multi();
//                    stringRedisTemplate.delete(REDIS_LOCK);
//                    List<Object> exec = stringRedisTemplate.exec();
//                    if(exec == null){
//                        continue;
//                    }
//                }
//                stringRedisTemplate.unwatch();
//                break;
//            }


            /**
            Jedis jedis = RedisUtils.getJedis();
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] "
                    + "then "
                    + "    return redis.call('del', KEYS[1]) "
                    + "else "
                    + "    return 0 "
                    + "end";
            try {
                Object eval = jedis.eval(script, Collections.singletonList(REDIS_LOCK), Collections.singletonList(value));
                if("1".equals(eval.toString())){
                    System.out.println("del redis lock ok");
                }else{
                    System.out.println("del redis lock fail");
                }
            }catch (Exception e){

            }
            if(jedis != null){
                jedis.close();
            }
             */
            if(lock.isLocked() && lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }
}
