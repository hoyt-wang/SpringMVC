package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hoyt on 2017/11/2.
 */

@Controller
public class HomeController {

    //@GetMapping("/home")
    @RequestMapping("/home")
    public String home() {
        System.out.println("Hello,SpringMVC");
        return "home";
    }
}
