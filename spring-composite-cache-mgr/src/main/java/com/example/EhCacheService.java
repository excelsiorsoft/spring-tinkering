package com.example;

import java.util.Date;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;



@Service
public class EhCacheService {

	public static final String EHCACHE_KEY = "ehcache-key";
	public static final String EHCACHE_IDENTIFY_KEY = "ehcache-identify-key";
	
    private int executeTime = 0;

    public void clearExecuteTime() {
        executeTime = 0;
    }

    public int getExecuteTime() {
        return executeTime;
    }

    @Cacheable(EHCACHE_KEY)
    public String get() {
        executeTime++;
        return SpringCompositeCacheMgrApplicationTests.DATETIME_FORMAT.format(new Date());
    }

    @Cacheable(value = EHCACHE_IDENTIFY_KEY, key = "#identify")
    public String get(Long identify) {
        executeTime++;
        return SpringCompositeCacheMgrApplicationTests.DATETIME_FORMAT.format(new Date()) + "&identify:" + identify;
    }

    @Caching(evict = {
            @CacheEvict(EHCACHE_KEY),
            @CacheEvict(value = EHCACHE_IDENTIFY_KEY, allEntries = true)})
    public void evictAll() {
    }
}
