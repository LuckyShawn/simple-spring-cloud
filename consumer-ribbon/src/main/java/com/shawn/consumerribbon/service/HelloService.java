package com.shawn.consumerribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/18 0018
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    public String hello(String name){
        return restTemplate.getForObject("http://eureka-client/hello?"+name,String.class);
    }
}
