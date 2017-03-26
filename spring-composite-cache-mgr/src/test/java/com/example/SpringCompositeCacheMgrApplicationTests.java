package com.example;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@WebAppConfiguration
/*@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc*/
public class SpringCompositeCacheMgrApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(getClass());
    public static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS");
    public static final String REDIS_KEY = "redis-key";
    public static final String EHCACHE_KEY = "ehcache-key";
    public static final String REDIS_IDENTIFY_KEY = "redis-identify-key";
    public static final String EHCACHE_IDENTIFY_KEY = "ehcache-identify-key";
    public static final int SLEEP_MILLIS = 300;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	
	
	protected MockMvc mockMvc;

    @Before
    public void createMockMVC() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)./*addFilter(new GlobalFilter())*/
                      build();
    }

	@Test
	public void applicationContextShouldBeInitialized() {/*
		Assert.assertNotNull(webApplicationContext);
		for (String beanDefinitionNames : webApplicationContext.getBeanDefinitionNames()) {
			Assert.assertNotNull(webApplicationContext.getBean(beanDefinitionNames));
		}
	*/}

}
