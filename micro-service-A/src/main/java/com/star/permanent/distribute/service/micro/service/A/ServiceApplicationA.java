package com.star.permanent.distribute.service.micro.service.A;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceApplicationA {
    public static void main(String[] args){
        SpringApplication.run(ServiceApplicationA.class,args);
    }


}
