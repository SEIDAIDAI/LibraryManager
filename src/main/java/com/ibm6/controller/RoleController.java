package com.ibm6.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.bean.Role;
import com.ibm6.bean.User;
import com.ibm6.model.LoginModel;
import com.ibm6.model.LoginResult;
import com.ibm6.model.Register;
import com.ibm6.service.RoleService;
import com.ibm6.service.UserService;



@RestController
public class RoleController {
	@Autowired
	private RoleService service;
	
	@Autowired 
	private UserService userservice;
	
	
	//登陆功能
	//输入登陆数据，包括账号 account，密码 password
	//返回信息 LoginResult 
	//内容包括resultcode 为1时登陆成功； -1时是账号或密码错误
	//name 用户姓名
	//admin 为1时是管理员，为其他就是普通用户
	//userId 用户id
	@PostMapping("/login")
	public LoginResult login(@RequestBody LoginModel model) {
		System.out.println(model);
		Role role = service.login(model.getAccount());//查询密码出来
		LoginResult result=new LoginResult();
		result.setResultCode(-1);
		if(role!=null&&role.getActive()!=0) {    //不为空证明有这个账号
			if(model.getPassword().equals(role.getUserPassword())) { //对比密码	
				result.setResultCode(1);
				result.setUserId(role.getUserId());
				if (role.getAdmin()==1) {
					result.setAdmin(1);
				}
				result.setName(userservice.findById(role.getUserId()).getName());
				return result;
			}
			else {
				return result; //密码错误返回-1
			}
		}else {
			return result; //账号错误返回-1
		}
	}
	
	
	//注册
	//传入数据 包括账号 account，密码 password，邮箱email，姓名name
	//返回0时是用户已存在
	//返回1时是注册成功
	//返回-1是注册失败，不知道原因
	@RequestMapping("/regist")
	public String regist(@RequestBody Register model) throws ParseException {
//		System.out.println(model);
		if (service.findActiveRole(model.getAccount())==1) {
			return "0";
		}
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
	
	@RequestMapping("/updatePassword")
	public int updatePassword(@RequestBody Role role) {
		System.out.println(role);
		return service.updateById(role);
	}
	
	
}
