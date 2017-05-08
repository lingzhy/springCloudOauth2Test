package com.lzy.firstpsringgradle.controller;

 
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzy.firstpsringgradle.annotation.authrAnnotation;
import com.lzy.firstpsringgradle.entity.User;
import com.lzy.firstpsringgradle.service.UsersService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
    private UsersService userService;

    @RequestMapping(value = "/show")
    @ResponseBody
    @authrAnnotation(role="role1",identity="identity1")
    public String show(@RequestParam(value = "name") String name) {
    	System.out.println("name::::::::::::::"+name);
        User user = userService.findUserByName(name);
        if (null != user)
        {
        	//List<User> users = new ArrayList();
        	//users.add(user); 
        	userService.methodFilterTest(user.getName()); 
            return user.getId() + " & " + user.getName() + " & " + user.getPassword();
        }
        else return "null";
    }
   
    
    @RequestMapping(value = "/update")
    @ResponseBody
    public int update(@RequestParam(value = "id") String id) {
    	 
        return userService.updateUserById(id);
    }
    
    
    
    
}
