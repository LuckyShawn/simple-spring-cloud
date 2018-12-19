package com.shawn.consumerfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/18 0018
 */
@FeignClient("eureka-client") //指定调用哪个服务 eureka-client为服务名
public interface FeignService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHello(@RequestParam(value = "name")String name);
}
