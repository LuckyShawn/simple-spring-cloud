package com.shawn.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/18 0018
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    String port;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",defaultValue = "shawn") String name){
        return "Hello!!"+name+",I am from:"+port;
    }
}
