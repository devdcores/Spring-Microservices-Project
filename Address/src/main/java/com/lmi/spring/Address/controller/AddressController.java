package com.lmi.spring.Address.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-05-06 23:07
 */
@RestController("/address")
@Slf4j
public class AddressController {

//    private static Logger log = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    Environment environment;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    UsersFeignClient usersFeignClient;

    @GetMapping
    public String getAddress(){

        log.info("Devd");
        ServiceInstance choose = loadBalancerClient.choose("users-service");

        System.out.println("host : "+choose.getHost());
        System.out.println("port : "+choose.getPort());
        System.out.println("uri : "+choose.getUri());
//        String responseFromUser =
////                restTemplate.getForObject(choose.getUri()+"/users",
//                restTemplate.getForObject("http://users-service/users",
//                String.class);
        String responseFromUser = usersFeignClient.getUser();
        String port = environment.getProperty("local.server.port");

        System.out.println("Address Port : "+port);

        String aa = "Address Port : "+port;
        return aa+"\n"+responseFromUser;
    }
}
