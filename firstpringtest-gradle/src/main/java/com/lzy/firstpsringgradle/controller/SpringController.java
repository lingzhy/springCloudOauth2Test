package com.lzy.firstpsringgradle.controller;



import org.springframework.boot.*;

import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

//表明这是一个 Controll
@Controller

//RestController是一种Rest风格的Controller，可以直接返回对象而不返回视图，返回的对象可以使JSON，XML等
//@RestController

//使用自动配置，主动添加并解析bean，配置文件等信息
@EnableAutoConfiguration
@RequestMapping("/home")
public class SpringController {

    //设置访问的url
    @RequestMapping("/user")
    //表示返回JSON格式的结果，如果前面使用的是@RestController可以不用写
    @ResponseBody
    String home() {
        return "Hello World!!!!!";//返回结果为字符串
    }

    
}