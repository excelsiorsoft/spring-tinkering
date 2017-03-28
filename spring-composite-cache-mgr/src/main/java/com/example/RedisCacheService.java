package com.example;

import static com.example.SpringCompositeCacheMgrApplicationTests.DATETIME_FORMAT;



import java.util.Date;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

	
	public static final String REDIS_KEY = "redis-key";
	public static final String REDIS_IDENTIFY_KEY = "redis-identify-key";
	
	
    private int timesExecuted = 0;

    public void clearTimesExecuted() {
        timesExecuted = 0;
    }

    public int getTimesExecuted() {
        return timesExecuted;
    }

    @Cacheable(REDIS_KEY)
    public String get() {
        timesExecuted++;
        return DATETIME_FORMAT.format(new Date());
    }

    @Cacheable(value = REDIS_IDENTIFY_KEY, key = "#identify")
    public String get(Long identify) {
        timesExecuted++;
        return DATETIME_FORMAT.format(new Date()) + "&identify:" + identify;
    }

    @Caching(evict = {
            @CacheEvict(REDIS_KEY),
            @CacheEvict(value = REDIS_IDENTIFY_KEY, allEntries = true)})
    public void evictAll() {
    }
}
