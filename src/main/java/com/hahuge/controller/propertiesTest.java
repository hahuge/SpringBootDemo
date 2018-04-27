package com.hahuge.controller;

import com.hahuge.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class propertiesTest {

    @Resource
    private User user;

    @RequestMapping("getuser")
    public User getString(){
        User bean = new User();
        BeanUtils.copyProperties(user,bean);
        return bean;
    }
}
