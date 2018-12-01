package com.zhoujin.chanpin.service.impl;

import com.zhoujin.chanpin.service.UserService;
import com.zhoujin.commons.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserService {
    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public String hello() {
        return null;
    }

    @Override
    public String timeout() {
        return "熔断超时！";
    }
}
