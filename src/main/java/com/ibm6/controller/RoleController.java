package com.ibm6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm6.bean.Role;
import com.ibm6.bean.User;
import com.ibm6.mapper.UserMapper;
import com.ibm6.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService service;
	
	@Autowired
	private UserMapper mapper;
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(String account,String password) {
//		account="10086";
//		password="123456";
//		System.out.println(account+password);
		Role role = service.login(account);
		System.out.println(role);
		if(role!=null) {
			if(password.equals(role.getUserPassword())) {
				if(role.getActive()==1) {
					return "1";
				}else {
					return "2";
				}
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
		int userId=service.findMaxUserId();
		userId++;
		Role role=new Role();
		role.setUserAccount(account);
		role.setUserPassword(password);
		role.setUserId(userId);
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setUserId(userId);
		try {
			int re = service.regist(role,user);
			if(re==-1) {
				return "0";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "-1";
		}
//		service.regist(role, user);
		return "1";
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
