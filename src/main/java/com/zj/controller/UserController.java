package com.zj.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zj.entity.User;
import com.zj.service.UserService;

@Controller
public class UserController {

	@Resource
	UserService userService;
	
	@RequestMapping("/shouye")
	public String shouye() {
		return "login";
	}
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/login")
	public String login(String name,String pwd) {
		System.out.println(name+","+pwd);
		User u=userService.login(name, pwd);
		if(u!=null) {
			return "index";
		}
		else {
			return "login";
		}
	}
}
