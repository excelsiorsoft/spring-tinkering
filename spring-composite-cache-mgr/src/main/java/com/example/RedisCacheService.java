package com.example;

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

    @Cacheable(SpringCompositeCacheMgrApplicationTests.REDIS_KEY)
    public String get() {
        executeTime++;
        return SpringCompositeCacheMgrApplicationTests.DATETIME_FORMAT.format(new Date());
    }

    @Cacheable(value = SpringCompositeCacheMgrApplicationTests.REDIS_IDENTIFY_KEY, key = "#identify")
    public String get(Long identify) {
        executeTime++;
        return SpringCompositeCacheMgrApplicationTests.DATETIME_FORMAT.format(new Date()) + "&identify:" + identify;
    }

    @Caching(evict = {
            @CacheEvict(SpringCompositeCacheMgrApplicationTests.REDIS_KEY),
            @CacheEvict(value = SpringCompositeCacheMgrApplicationTests.REDIS_IDENTIFY_KEY, allEntries = true)})
    public void evictAll() {
    }
}
