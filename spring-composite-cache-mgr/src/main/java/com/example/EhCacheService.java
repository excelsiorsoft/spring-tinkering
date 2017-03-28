package com.example;

import static com.example.SpringCompositeCacheMgrApplicationTests.DATETIME_FORMAT;

import java.util.Date;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;



@Service
public class EhCacheService {

	public static final String EHCACHE_KEY = "ehcache-no-identifier";
	public static final String EHCACHE_IDENTIFY_KEY = "ehcache-identifier";
	
    private int timesExecuted = 0;

    public void clearTimesExecuted() {
        timesExecuted = 0;
    }

    public int getTimesExecuted() {
        return timesExecuted;
    }

    @Cacheable(EHCACHE_KEY)
    public String get() {
        timesExecuted++;
        return DATETIME_FORMAT.format(new Date());
    }

    @Cacheable(value = EHCACHE_IDENTIFY_KEY, key = "#identifier")
    public String get(Long identifier) {
        timesExecuted++;
        return DATETIME_FORMAT.format(new Date()) + "&identifier:" + identifier;
    }

    @Caching(evict = {
            @CacheEvict(EHCACHE_KEY),
            @CacheEvict(value = EHCACHE_IDENTIFY_KEY, allEntries = true)})
    public void evictAll() {
    }
}
