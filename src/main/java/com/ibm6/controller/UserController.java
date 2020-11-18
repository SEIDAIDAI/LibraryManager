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
	public User showUser(String userId) {		
		return userService.showUser(Integer.parseInt(userId));
	}
	
	@RequestMapping("/updateMyInfo")
	public User updateMyInfo(User user) {
		if(userService.updateById(user)==1) {
			return userService.showUser(user.getUserId());
		}
		else {
			return user;
		}
	}
	
	@RequestMapping("/showUserList")
	public List<User> showUserList(){
//		List<User> users=userService.findAll();
//		for(User user:users) {
//			System.out.println(user.getUserId());
//			if (user.getUserId()<1000) {
//				users.remove(user);
//			}
//		}
		return userService.findAll();
		
	}
	
}
