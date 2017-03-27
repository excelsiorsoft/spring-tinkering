# Genesis

This project is inspired by the video [https://www.youtube.com/watch?v=3NLS7147UQo](https://www.youtube.com/watch?v=3NLS7147UQo "Caching with Spring: Advanced Topics and Best Practices") and is designed to showcase the set up and operation of Spring's ***`CompositeCacheManager`*** incorporating, in this particular case, EHCache & Redis constituent cache managers.

# Requirements

In order to run the samples contained in this repository one needs to have a single Redis instance running.  Redis distribution could be obtained from [http://redis.io/download](http://redis.io/download) or [https://github.com/MSOpenTech/redis](https://github.com/MSOpenTech/redis) (for Windows).

# Standing Up a Redis Server

Once Redis is unpacked, launch it with the default settings:

    redis-server

You should see a screen similar to this:


![Redis server running](https://github.com/excelsiorsoft/spring-tinkering/blob/master/spring-composite-cache-mgr/doc/Redis.JPG)

