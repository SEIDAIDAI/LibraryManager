package com.ibm6.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ibm6.bean.Role;
import com.ibm6.bean.User;
import com.ibm6.mapper.UserMapper;
import com.ibm6.model.LoginModel;
import com.ibm6.model.LoginResult;
import com.ibm6.model.Register;
import com.ibm6.service.RoleService;



@RestController
public class RoleController {
	@Autowired
	private RoleService service;
	
	@Autowired
	private UserMapper mapper;
	
	@PostMapping("/login")
	public LoginResult login(@RequestBody LoginModel model) {
		System.out.println(model);
		Role role = service.login(model.getAccount());//查询密码出来
		LoginResult result=new LoginResult();
		result.setResultCode(-1);
		if(role!=null) {    //不为空证明有这个账号
			if(model.getPassword().equals(role.getUserPassword())) { //对比密码	
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
	
	@PostMapping("/regist")
	public String regist(@RequestBody Register model) throws ParseException {
//		System.out.println("acc"+modle.account+"pw"+password+"name"+name+"email"+email);
//		if(account==null||name==null||password==null||email==null) {
//			return "-1";
//		}

		int userId=service.findMaxUserId();
		if(userId<1000) {
			userId=1000;
		}else {
			userId++;
		}
		Role role=new Role();
		role.setUserAccount(model.getAccount());
		role.setUserPassword(model.getPassword());
		role.setUserId(userId);
		User user=new User();
		user.setName(model.getName());
		user.setEmail(model.getEmail());
		user.setUserId(userId);
		String birthdayDefault="1970-01-01";
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		user.setBirthday(df.parse(birthdayDefault));
		try {
			int re = service.regist(role,user);
			if(re==-1) {
				return "0";
			}
		} catch (Exception e) {
			return "-1";
		}
		service.regist(role, user);
		return "1"; 
	}
	
	
	
	
	@RequestMapping("/findAllRole")
	public String findAllRole() {
		List<Role> roles = service.findAllRole();
		for(Role role:roles) {
			System.out.println(role);
		}
		return "11";
	}
}
