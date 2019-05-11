package com.lmi.spring.Address.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-05-10 01:45
 */
@FeignClient("users-service")
public interface UsersFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String getUser();
}
