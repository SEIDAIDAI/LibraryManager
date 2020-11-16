package com.ibm6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm6.bean.Role;
import com.ibm6.service.roleService;

@Controller
public class RoleController {
	@Autowired
	private roleService service;
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(String account,String password) {
		account="10086";
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
