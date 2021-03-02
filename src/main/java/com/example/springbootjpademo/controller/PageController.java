package com.example.springbootjpademo.controller;

import com.example.springbootjpademo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangning
 * @create 2021-01-08 11:11
 */
@Controller
public class PageController {

	@RequestMapping("/doIndexUI")
	@ResponseBody
	public User doIndexUI() {
		User user = new User();
		user.setId(1);
		user.setUsername("ceshi");
		user.setPhone("15364895263");
		return user;
	}
}
