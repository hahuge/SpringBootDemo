package com.hahuge.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebTest {
    @RequestMapping("getstring")
    public String getString(){
        return "1234";
    }
}
