package com.ibm6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm6.bean.Role;
import com.ibm6.bean.User;
import com.ibm6.mapper.RoleMapper;

@Service
public class RoleService {
	@Autowired
	private RoleMapper mapper;
	
	public List<Role> findAllRole() {
		return mapper.findAllRole();
		
	}
	
	public Role login(String account) {
		
		return mapper.findByAccount(account);
	}
	
	public int regist(Role role,User user) {
		
		if(mapper.findByAccount(role.getUserAccount())==null)
			if(mapper.insert(role)==1)
				return mapper.insertUser(user);
		return 0;
	}
}
