package com.menu.util;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by fmy on 2017/7/11.
 */
public class RedisCache implements Cache {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCache.class);

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    private RedisTemplate redisTemplate;

    private static final long EXPIRE_TIME_IN_MINUTES = 30;// redis过期时间

    private final String id; //cache instance id

    public RedisCache(String id) {
        if(id == null){
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        RedisTemplate redisTemplate = getRedisTemplate();
        ValueOperations opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key,value,EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES);
        LOGGER.debug("Put query result to redis");

    }

    private RedisTemplate getRedisTemplate() {
        if(redisTemplate == null){
            redisTemplate = ApplicationContextHolder.getBean("redisTemplate");
        }
        return redisTemplate;
    }

    @Override
    public Object getObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        ValueOperations opsForVal = redisTemplate.opsForValue();
        LOGGER.debug("Get cached query result from redis");
        return opsForVal.get(key);
    }

    @Override
    public Object removeObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.delete(key);
        LOGGER.debug("Remove cached query result from redis");
        return null;
    }

    @Override
    public void clear() {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.execute((RedisCallback) connection -> {
           connection.flushDb();
           return null;
        });
        LOGGER.debug("Clear all the cached query result from redis");
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
