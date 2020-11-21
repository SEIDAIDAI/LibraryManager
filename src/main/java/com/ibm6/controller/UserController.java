package com.ibm6.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.bean.Role;
import com.ibm6.bean.User;
import com.ibm6.mapper.UserMapper;
import com.ibm6.service.RoleService;
import com.ibm6.service.UserService;



@RestController
@RequestMapping()
public class UserController {
	
//	@Autowired
//	private UserMapper userMapper;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/showUser")
	public User showUser(@RequestBody User user) {
		user=userService.showUser(user.getUserId());
		System.out.println(user);
		return user;
	}
	
	@RequestMapping("/updateMyInfo")
	public User updateMyInfo(@RequestBody User user) {
		if(userService.updateById(user)==1) {
			return userService.showUser(user.getUserId());
		}
		else {
			return user;
		}
	}
	
	@RequestMapping("/testUserUpdate")
	public User testUserUpdate(@RequestBody User user) {
		return userService.showUser(user.getUserId());
	}
	
	@RequestMapping("/showUserList/{index}")
	public List<User> showUserList(@PathVariable("index") Integer index){
		return userService.findUserByPage(index * 9);
	}
	
	@RequestMapping("/findUserByExample/{index}")
	public List<User> findUserByExample(@RequestBody User user,@PathVariable("index") Integer index){
		System.out.println(index);
		return userService.findUserByExample(user,index*9);
	}
}
