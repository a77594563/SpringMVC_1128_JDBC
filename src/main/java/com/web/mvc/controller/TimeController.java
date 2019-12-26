package com.web.mvc.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TimeController {
    
    @RequestMapping("/time")
    @ResponseBody
    private String getTime(){
        return new Date().toString();
    }
}
