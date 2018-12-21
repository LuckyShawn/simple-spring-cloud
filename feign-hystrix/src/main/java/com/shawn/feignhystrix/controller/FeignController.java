package com.shawn.feignhystrix.controller;

import com.shawn.feignhystrix.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/18 0018
 */
@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @GetMapping("/hello")
    public String sayHello(String name){

        return feignService.sayHello(name);
    }
}
