package com.hahuge.controller;

import com.hahuge.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class FreeMarkerTest {

    @Autowired
    private User user;
    @RequestMapping("getftl")
    public String getFtl(ModelMap map){
        map.put("user",user);
        return "freemarker/test";
    }
}
