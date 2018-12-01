package com.zhoujin.chanpin.service.impl;

import com.zhoujin.chanpin.service.UserServiceApi;
import com.zhoujin.commons.entity.User;
import com.zhoujin.commons.wrapperutil.WrapMapper;
import com.zhoujin.commons.wrapperutil.Wrapper;
import org.springframework.stereotype.Component;

@Component
public class UserServiceApiHystrix implements UserServiceApi {
    @Override
    public Wrapper<User> getUser(Long id) {
        return WrapMapper.error("熔断");
    }

    @Override
    public String hello() {
        return null;
    }

    @Override
    public Wrapper<String> timeout() {
        return WrapMapper.error("熔断超时！");
    }
}
