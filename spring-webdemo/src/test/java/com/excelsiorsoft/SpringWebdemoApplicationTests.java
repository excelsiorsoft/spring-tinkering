package com.excelsiorsoft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.excelsiorsoft.webdemo.SpringWebdemoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringWebdemoApplication.class)
@WebAppConfiguration
public class SpringWebdemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
