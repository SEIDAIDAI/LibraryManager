package com.ibm6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ibm6.bean.Role;
import com.ibm6.bean.User;
import com.ibm6.mapper.UserMapper;
import com.ibm6.model.LoginResult;
import com.ibm6.service.RoleService;



@RestController
public class RoleController {
	@Autowired
	private RoleService service;
	
	@Autowired
	private UserMapper mapper;
	
	@RequestMapping("/login")
	public LoginResult login(String account,String password) {
		Role role = service.login(account);//查询密码出来
		LoginResult result=new LoginResult();
		result.setResultCode(-1);
		if(role!=null) {    //不为空证明有这个账号
			if(password.equals(role.getUserPassword())) { //对比密码	
				result.setResultCode(1);
				result.setUserId(role.getUserId());
				if (role.getAdmin()==1) {
					result.setAdmin(1);
				}
				return result;
			}
			else {
				return result; //密码错误返回-1
			}
		}else {
			return result; //账号错误返回-1
		}
	}
	
	@RequestMapping("/regist")
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
			return "-1";
		}
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
