package com.hahuge.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Task {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    // 定义每过3秒执行任务
    @Scheduled(fixedRate = 3600000)
    public void task(){
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
