package com.shawn.serverhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/19 0019
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "helloError")
    public String hello(String name){
        return restTemplate.getForObject("http://eureka-client/hello?name="+name,String.class);
    }

    public String helloError(String name){
        return "hello!"+name+",An Error Has Occurred";
    }

}
