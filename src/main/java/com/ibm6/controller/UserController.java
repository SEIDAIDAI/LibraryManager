package com.ibm6.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.bean.User;
import com.ibm6.mapper.UserMapper;




@RestController
@RequestMapping("dd")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@PostMapping("/save/user")
	public User CreateUser(@RequestBody User user)
	{
		System.out.println("Come in");
		userMapper.saveNewUser(user);
		System.out.println("用户插入成功");
		return user;
	}

	@RequestMapping("tt")
	public String Say()
	{
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		return "Hello";
	}
	
	@GetMapping("/query/{id}")
    public String getDepartment(@PathVariable("id") Integer id){
		
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		return "linda";
    }
	
	@RequestMapping("/delete")
	public String deleteByid() {
		System.out.println("123");
		int re = userMapper.deleteById(1);
		return "delete";
	}
	
	@RequestMapping("/findAll")
	public String findAll() {
		List<User> users = userMapper.findAll();
		for(User user : users) {
			System.out.println(user);
		}
		return "findAll";
	}
	
	@RequestMapping("/findById")
	public String findById() {
		User user = userMapper.findById(5);
		System.out.println(user);
		return "findById";
	}
	
	@RequestMapping("/updateById")
	public String updateById() {
		User user=new User();
		user.setUser_id(5);
		user.setName("huang");
		userMapper.updateById(user);
		return "update";
	}
}
