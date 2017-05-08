package com.lzy.firstpsringgradle.controller;

 
 

import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
 

@Controller
@EnableAutoConfiguration
@RequestMapping("/user1")
public class UserController2 {
	 

    @RequestMapping("/show1")
    @ResponseBody
    public String show(@RequestParam(value = "name") String name) {
    	 return " user1 show1";
    }
}
