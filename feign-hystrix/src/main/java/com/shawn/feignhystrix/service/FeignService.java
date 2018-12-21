package com.shawn.feignhystrix.service;


import com.shawn.feignhystrix.hystrix.FeignServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//fallback的指定类，发生熔断执行的类
@FeignClient(value = "eureka-client",fallback = FeignServiceHystrix.class)
public interface FeignService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHello(@RequestParam(value = "name")String name);
}
