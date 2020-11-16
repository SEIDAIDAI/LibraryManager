package com.ibm6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm6.bean.Role;
import com.ibm6.mapper.RoleMapper;

@Service
public class roleService {
	@Autowired
	private RoleMapper mapper;
	
	public List<Role> findAllRole() {
		return mapper.findAllRole();
		
	}
	
	public Role login(String account) {
		
		return mapper.findByAccount(account);
	}
}
