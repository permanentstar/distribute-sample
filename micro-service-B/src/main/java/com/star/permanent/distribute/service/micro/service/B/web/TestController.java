package com.star.permanent.distribute.service.micro.service.B.web;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.star.permanent.distribute.service.micro.service.B.feign.FeignInterface;
import com.star.permanent.distribute.service.micro.service.common.service.Test_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RefreshScope
public class TestController {
    @Value("${service.config.p2}")
    private String p2;

    @Value("${global.config.value}")
    private String global;

    @Value("${spring.profiles.active}")
    private String profile;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private FeignInterface feignInterface;

    @Autowired
    private Test_Service test_service;

    @Value("${test.t1}")
    private String t1;
    @RequestMapping("const-test1")
    public String ct(){
        return t1;
    }

    @RequestMapping("simple-test1")
    public String st1(){
        return p2;
    }

    @RequestMapping("simple-test2")
    public String st2(){
        return profile;
    }

    @RequestMapping("simple-test3")
    public String st3(){
        return global;
    }


    @RequestMapping("discover-test1")
    public String test1(){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("micro-service-A", false);
        return instance.getHomePageUrl();
    }

    @RequestMapping("discover-test2")
    public String test2(){
        List<ServiceInstance> list = discoveryClient.getInstances("micro-service-A");
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri().toString();
        }
        return "none";
    }

    @RequestMapping("discover-test3")
    public String test3(){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("micro-service-A", false);
        String homePage = instance.getHomePageUrl();
        System.out.println(homePage);
        RestTemplate template = new RestTemplate();
        return template.getForEntity(homePage+"micro-service-A/test",String.class).getBody();
    }
    @RequestMapping("discover-feign1")
    public String feign1(){
        return feignInterface.test1();
    }

    @RequestMapping("dependence-context")
    public String depContext(){
        test_service.methodA();
        return "ok";
    }
}
