package com.star.permanent.distribute.service.micro.service.B.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "micro-service-A")
public interface FeignInterface {
    @RequestMapping(method = RequestMethod.GET,value = "test")
    String test1();
}
