package com.shawn.consumerribbon.controller;

import com.shawn.consumerribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/18 0018
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(String name){
        return helloService.hello(name);
    }
}
