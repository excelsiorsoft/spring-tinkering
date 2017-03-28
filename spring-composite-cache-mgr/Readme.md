# Genesis

This project is inspired by the video [https://www.youtube.com/watch?v=3NLS7147UQo](https://www.youtube.com/watch?v=3NLS7147UQo "Caching with Spring: Advanced Topics and Best Practices") and is designed to showcase the set up and operation of Spring's ***`CompositeCacheManager`*** incorporating, in this particular case, EHCache & Redis constituent cache managers.  

Additionally, it showcases: 

- @ConfigurationProperties mechanism as described in [http://stackoverflow.com/questions/32058814/spring-boot-custom-variables-in-application-properties](http://stackoverflow.com/questions/32058814/spring-boot-custom-variables-in-application-properties)

# Requirements

In order to run the samples contained in this repository one needs to have a single Redis instance running.  Redis distribution could be obtained from [http://redis.io/download](http://redis.io/download) or [https://github.com/MSOpenTech/redis](https://github.com/MSOpenTech/redis) (for Windows).

# Standing Up a Redis Server

Once Redis is unpacked, launch it with the default settings:

    redis-server

You should see a screen similar to this:


![Redis server running](https://github.com/excelsiorsoft/spring-tinkering/blob/master/spring-composite-cache-mgr/doc/Redis.JPG)

# To Run

Running ***`SpringCompositeCacheMgrApplicationTests.java`*** as JUnit test will result in the following:

    08:46:38.516 [main] INFO  c.e.SpringCompositeCacheMgrApplicationTests - Started SpringCompositeCacheMgrApplicationTests in 13.433 seconds (JVM running for 16.376)
    08:46:40.629 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - cacheNames=[redis-key, redis-identify-key]
    08:46:41.015 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - start test ehcache identify
    08:46:41.116 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value1Before=2017-03-28T08:46:41:084&identify:1
    08:46:41.118 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value2Before=2017-03-28T08:46:41:118&identify:2
    08:46:41.421 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value1After=2017-03-28T08:46:41:084&identify:1
    08:46:41.421 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value2After=2017-03-28T08:46:41:118&identify:2
    08:46:41.421 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - executeTime=2
    08:46:41.421 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - finish test ehcache identify
    08:46:41.441 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - start test redis identify
    08:46:41.499 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value1Before=2017-03-28T08:46:41:450&identify:1
    08:46:41.501 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value2Before=2017-03-28T08:46:41:500&identify:2
    08:46:42.318 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value1After=2017-03-28T08:46:41:450&identify:1
    08:46:42.410 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value2After=2017-03-28T08:46:41:500&identify:2
    08:46:42.410 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - executeTime=2
    08:46:42.410 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - finish test redis identify
    08:46:42.427 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - start test redis
    08:46:42.429 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - currentDateStringBefore=2017-03-28T08:46:42:428
    08:46:42.746 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - currentDateStringAfter=2017-03-28T08:46:42:428
    08:46:42.746 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - executeTime=1
    08:46:42.746 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - finish test redis
    08:46:42.765 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - cacheNames=[ehcache-identify-key, ehcache-key]
    08:46:42.920 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - start test ehcache
    08:46:42.921 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - currentDateStringBefore=2017-03-28T08:46:42:921
    08:46:43.227 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - currentDateStringAfter=2017-03-28T08:46:42:921
    08:46:43.227 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - executeTime=1
    08:46:43.227 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - finish test ehcache
    08:46:43.801 [Thread-7] INFO  o.s.c.e.EhCacheManagerFactoryBean - Shutting down EhCache CacheManager
    

