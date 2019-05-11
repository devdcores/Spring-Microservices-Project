package com.lmi.spring.Users.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-05-06 23:03
 */
@RestController("/users")
@Slf4j
public class UsersController {

    @Autowired
    Environment environment;

    @GetMapping
    public String getName(){

        log.info("Devd");
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String port = environment.getProperty("local.server.port");
        environment.getProperty("local.server.");
        System.out.println("Users Port : "+port);
        return "User Response from address : "+localHost+":"+ port;
    }
}
