package com.task.tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeveloperController {

    @RequestMapping(value = {"/developerCreate"})
    public String developerCreate(){
        return "views/developer/developerCreate";
    }

}
