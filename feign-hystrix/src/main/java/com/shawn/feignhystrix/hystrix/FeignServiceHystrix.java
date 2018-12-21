package com.shawn.feignhystrix.hystrix;

import com.shawn.feignhystrix.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/19 0019
 */
@Component
public class FeignServiceHystrix implements FeignService {
    @Override
    public String sayHello(String name) {
        return "Sorry!"+name+",An Error Has Occurred!";
    }
}
