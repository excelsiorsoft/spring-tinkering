package com.example;

import static com.example.RedisCacheService.REDIS_IDENTIFY_KEY;
import static com.example.RedisCacheService.REDIS_KEY;
import static com.example.EhCacheService.EHCACHE_IDENTIFY_KEY;
import static com.example.EhCacheService.EHCACHE_KEY;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Collection;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { CacheConfig.class })
//@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureMockMvc
public class SpringCompositeCacheMgrApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(getClass());
    
	public static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS");
    

	

    
    public static final int SLEEP_MILLIS = 300;
	
/*	@Autowired
	private WebApplicationContext webApplicationContext;
	
	
	
	protected MockMvc mockMvc;

    @Before
    public void createMockMVC() {
    	logger.debug("creating...");
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter(new GlobalFilter())
                      build();
    }*/
    
    @Before
    public void setUp() throws Exception {
        redisCacheService.evictAll();
        ehCacheService.evictAll();
    }

    @After
    public void tearDown() throws Exception {
        redisCacheService.evictAll();
        ehCacheService.evictAll();
    }

/*	@Test
	public void applicationContextShouldBeInitialized() {	
		
		Assert.assertNotNull("RedisProperties are undefined...", webApplicationContext.getBeansOfType(RedisProperties.class));
		
		Assert.assertNotNull(webApplicationContext);
		for (String beanDefinitionNames : webApplicationContext.getBeanDefinitionNames()) {
			Assert.assertNotNull(webApplicationContext.getBean(beanDefinitionNames));
		}
	}*/
	
	@Autowired
    StringRedisTemplate stringRedisTemplate;
    
	@Autowired
    RedisCacheService redisCacheService;
    
	@Autowired
    EhCacheService ehCacheService;
    
	@Autowired
    CacheManager ehCacheManager;
    
	@Autowired
    CacheManager redisCacheManager;

    @Test
    public void testEhCacheLoad() throws Exception {
    	
    	Collection<String> cacheNames = ehCacheManager.getCacheNames();
        logger.debug("ehcache cacheNames={}\n", cacheNames);
        Assert.assertThat(cacheNames, Matchers.containsInAnyOrder(EHCACHE_KEY, EHCACHE_IDENTIFY_KEY));
    }

    
    @Test
    public void testRedisCacheLoad() throws Exception {
        
    	Collection<String> cacheNames = redisCacheManager.getCacheNames();
        logger.debug("redis cacheNames={}\n", cacheNames);
        Assert.assertThat(cacheNames, Matchers.contains(REDIS_KEY, REDIS_IDENTIFY_KEY));
    }

   

    @Test
    public void testRedis() throws Exception {
        
    	logger.debug("start test redis");
        redisCacheService.clearTimesExecuted();
        
        String currentDateStringBefore = redisCacheService.get();
        logger.debug("currentDateStringBefore={}", currentDateStringBefore);
        Thread.currentThread().join(SLEEP_MILLIS);
        String currentDateStringAfter = redisCacheService.get();
        logger.debug("currentDateStringAfter={}", currentDateStringAfter);
        Assert.assertEquals(currentDateStringAfter, currentDateStringBefore);
        int timesExecuted = redisCacheService.getTimesExecuted();
        logger.debug("timesExecuted={}", timesExecuted);
        Assert.assertEquals(timesExecuted, 1);
        logger.debug("finish test redis\n");
    }

    @Test
    public void testEhcache() throws Exception {
        
    	logger.debug("start test ehcache");
        ehCacheService.clearTimesExecuted();
        String currentDateStringBefore = ehCacheService.get();
        logger.debug("currentDateStringBefore={}", currentDateStringBefore);
        Thread.currentThread().join(SLEEP_MILLIS);
        String currentDateStringAfter = ehCacheService.get();
        logger.debug("currentDateStringAfter={}", currentDateStringAfter);
        Assert.assertEquals(currentDateStringAfter, currentDateStringBefore);
        int timesExecuted = ehCacheService.getTimesExecuted();
        logger.debug("timesExecuted={}", timesExecuted);
        Assert.assertEquals(timesExecuted, 1);
        logger.debug("finish test ehcache\n");
    }

    @Test
    public void testRedisIdentify() throws Exception {
        
    	logger.debug("start test redis identify");
        redisCacheService.clearTimesExecuted();
        
        Long identify1 = 1L;
        Long identify2 = 2L;

        String value1Before = redisCacheService.get(identify1);
        logger.debug("value1Before={}", value1Before);

        String value2Before = redisCacheService.get(identify2);
        logger.debug("value2Before={}", value2Before);

        Thread.currentThread().join(SLEEP_MILLIS);

        String value1After = redisCacheService.get(identify1);
        logger.debug("value1After={}", value1After);
        Assert.assertEquals(value1Before, value1After);

        String value2After = redisCacheService.get(identify2);
        logger.debug("value2After={}", value2After);
        Assert.assertEquals(value2Before, value2After);

        int timesExecuted = redisCacheService.getTimesExecuted();
        logger.debug("timesExecuted={}", timesExecuted);
        Assert.assertEquals(timesExecuted, 2);

        logger.debug("finish test redis identify\n");
    }

    @Test
    public void testEhcacheIdentify() throws Exception {
        logger.debug("start test ehcache identify");
        ehCacheService.clearTimesExecuted();
        Long identify1 = 1L;
        Long identify2 = 2L;

        String value1Before = ehCacheService.get(identify1);
        logger.debug("value1Before={}", value1Before);

        String value2Before = ehCacheService.get(identify2);
        logger.debug("value2Before={}", value2Before);

        Thread.currentThread().join(SLEEP_MILLIS);

        String value1After = ehCacheService.get(identify1);
        logger.debug("value1After={}", value1After);
        Assert.assertEquals(value1Before, value1After);

        String value2After = ehCacheService.get(identify2);
        logger.debug("value2After={}", value2After);
        Assert.assertEquals(value2Before, value2After);

        int timesExecuted = ehCacheService.getTimesExecuted();
        logger.debug("timesExecuted={}", timesExecuted);
        Assert.assertEquals(timesExecuted, 2);

        logger.debug("finish test ehcache identify\n");
    }

}
