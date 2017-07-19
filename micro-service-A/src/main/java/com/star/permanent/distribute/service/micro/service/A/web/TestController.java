package com.star.permanent.distribute.service.micro.service.A.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${service.config.p1}")
    private String p1;

    @Value("${server.port}")
    private Integer port;
    @RequestMapping("test")
    public Integer test(){
        return port;
    }
}
