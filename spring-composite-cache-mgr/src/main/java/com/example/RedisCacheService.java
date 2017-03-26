package com.example;

import static com.example.SpringCompositeCacheMgrApplicationTests.DATETIME_FORMAT;
import static com.example.SpringCompositeCacheMgrApplicationTests.REDIS_IDENTIFY_KEY;
import static com.example.SpringCompositeCacheMgrApplicationTests.REDIS_KEY;

import java.util.Date;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    private int executeTime = 0;

    public void clearExecuteTime() {
        executeTime = 0;
    }

    public int getExecuteTime() {
        return executeTime;
    }

    @Cacheable(REDIS_KEY)
    public String get() {
        executeTime++;
        return DATETIME_FORMAT.format(new Date());
    }

    @Cacheable(value = REDIS_IDENTIFY_KEY, key = "#identify")
    public String get(Long identify) {
        executeTime++;
        return DATETIME_FORMAT.format(new Date()) + "&identify:" + identify;
    }

    @Caching(evict = {
            @CacheEvict(REDIS_KEY),
            @CacheEvict(value = REDIS_IDENTIFY_KEY, allEntries = true)})
    public void evictAll() {
    }
}
