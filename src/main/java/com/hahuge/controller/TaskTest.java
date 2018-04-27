package com.hahuge.controller;

import com.hahuge.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskTest {

    @Autowired
    private Task task;

    @RequestMapping("gettask")
    public String getTask(){
        return "";
    }
}
