package com.star.permanent.distribute.service.micro.service.common.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Test_Service {
    @Value("${test.cc}")
    private String a;

    public void methodA(){
        System.out.println(a);
    }
}
