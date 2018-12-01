package com.zhoujin.chanpin.service;

import com.zhoujin.chanpin.service.impl.UserServiceHystrix;
import com.zhoujin.commons.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "yonghu",fallback = UserServiceHystrix.class)
public interface UserService {

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id);

    @GetMapping("/user/hello")
    public String hello();

    @GetMapping("/user/timeout")
    public String timeout();
}
