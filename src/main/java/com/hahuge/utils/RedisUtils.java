package com.hahuge.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

//    @Resource
//    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    //设置值
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    //设置给定key的超时时间
    public void expire(String key, long timeout) {
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    //设置key值，并设置超时时间
    public void set(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    //获取一个值
    public String get(String key) {
        return (String)redisTemplate.opsForValue().get(key);
    }

    //获取给定key的剩余生存时间
    public long ttl(String key) {
        return redisTemplate.getExpire(key);
    }

    //删除一个key
    public void del(String key) {
        redisTemplate.delete(key);
    }


}
