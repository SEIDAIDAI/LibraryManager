package com.ibm6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm6.bean.Role;
import com.ibm6.bean.User;
import com.ibm6.mapper.RoleMapper;
import com.ibm6.mapper.UserMapper;

@Service
public class RoleService {
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	public List<Role> findAllRole() {
		return roleMapper.findAllRole();
		
	}
	
	public Role login(String account) {
		
		return roleMapper.findByAccount(account);
	}
	
	@Transactional
	public int regist(Role role,User user) {
		if(roleMapper.findByAccount(role.getUserAccount())==null) {
			roleMapper.insert(role);
			userMapper.insert(user);
		}else {
			return -1;
		}
		return 1;
	}
	
	public int findMaxUserId() {
		return roleMapper.findMaxUserId();
	}
}
