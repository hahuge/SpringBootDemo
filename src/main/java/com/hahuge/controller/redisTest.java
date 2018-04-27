package com.hahuge.controller;

import com.hahuge.model.User;
import com.hahuge.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class redisTest {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("getredis")
    public String getRedis(ModelMap map){
        redisUtils.set("name","湖南");
        User user = new User();
        user.setName(redisUtils.get("name"));
        map.put("user",user);
        return "freemarker/test";
    }
}
