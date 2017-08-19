package com.star.permanent.distribute.service.micro.service.B;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.star.permanent.distribute.service.micro.service"})
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceApplicationB {
    public static void main(String[] args){
        SpringApplication.run(ServiceApplicationB.class,args);
    }
}
