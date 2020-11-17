package com.ibm6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm6.bean.Role;
import com.ibm6.bean.User;
import com.ibm6.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService service;
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(String account,String password) {
		account="10086";
		password="123456";
		Role role = service.login(account);
		if(role!=null) {
			if(password.equals(role.getUserPassword())) {
				return "1";
			}
			else {
				return "0";
			}
		}else {
			return "-1";
		}
//		System.out.println(role);
//		return "111";
	}
	
	@RequestMapping("/regist")
	@ResponseBody
	public String regist(String account,String name,String password,String email) {
		
		account="10000";
		password="123456";
		name="huang";
		email="12345";
		
		Role role=new Role();
		role.setUserAccount(account);
		role.setUserPassword(password);
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		if(service.regist(role,user)==1)
			return "1";
		
		return "0";
	}
	
	
	@RequestMapping("/findAllRole")
	@ResponseBody
	public String findAllRole() {
		List<Role> roles = service.findAllRole();
		for(Role role:roles) {
			System.out.println(role);
		}
		return "11";
	}
}
