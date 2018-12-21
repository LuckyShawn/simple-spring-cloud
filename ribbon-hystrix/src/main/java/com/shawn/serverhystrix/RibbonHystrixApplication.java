package com.shawn.serverhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix //开启断路器功能
@EnableEurekaClient
public class RibbonHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonHystrixApplication.class, args);
    }

}

