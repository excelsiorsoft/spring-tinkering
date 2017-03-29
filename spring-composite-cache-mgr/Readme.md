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
`
21:53:50.613 [main] INFO  c.e.SpringCompositeCacheMgrApplicationTests - Started SpringCompositeCacheMgrApplicationTests in 6.298 seconds (JVM running for 7.516)
21:53:51.038 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - redis cacheNames=[redis-key, redis-identify-key]

21:53:51.078 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - start test ehcache identify
21:53:51.141 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value1Before=2017-03-28T21:53:51:139&identifier:1
21:53:51.141 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value2Before=2017-03-28T21:53:51:141&identifier:2
21:53:51.446 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value1After=2017-03-28T21:53:51:139&identifier:1
21:53:51.446 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value2After=2017-03-28T21:53:51:141&identifier:2
21:53:51.446 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - timesExecuted=2
21:53:51.446 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - finish test ehcache identify

21:53:51.460 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - start test redis identify
21:53:51.491 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value1Before=2017-03-28T21:53:51:468&identify:1
21:53:51.500 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value2Before=2017-03-28T21:53:51:492&identify:2
21:53:51.863 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value1After=2017-03-28T21:53:51:468&identify:1
21:53:51.867 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - value2After=2017-03-28T21:53:51:492&identify:2
21:53:51.867 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - timesExecuted=2
21:53:51.868 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - finish test redis identify

21:53:51.883 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - start test redis
21:53:51.888 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - currentDateStringBefore=2017-03-28T21:53:51:884
21:53:52.191 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - currentDateStringAfter=2017-03-28T21:53:51:884
21:53:52.191 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - timesExecuted=1
21:53:52.191 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - finish test redis

21:53:52.208 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - ehcache cacheNames=[ehcache-no-identifier, ehcache-identifier]

21:53:52.222 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - start test ehcache
21:53:52.223 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - currentDateStringBefore=2017-03-28T21:53:52:223
21:53:52.523 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - currentDateStringAfter=2017-03-28T21:53:52:223
21:53:52.523 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - timesExecuted=1
21:53:52.523 [main] DEBUG c.e.SpringCompositeCacheMgrApplicationTests - finish test ehcache

21:53:52.626 [Thread-6] INFO  o.s.c.e.EhCacheManagerFactoryBean - Shutting down EhCache CacheManager
`