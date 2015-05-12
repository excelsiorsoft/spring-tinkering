package com.excelsiorsoft.webdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebdemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringWebdemoApplication.class, args);
        SpringApplication app = new SpringApplication(SpringWebdemoApplication.class); 
        app.setShowBanner(false); 
        app.run(args); 
    }
}
