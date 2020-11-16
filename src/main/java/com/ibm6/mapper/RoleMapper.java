package com.ibm6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ibm6.bean.Role;

@Mapper
public interface RoleMapper {
	
	public List<Role> findAllRole();
	public Role findByAccount(String account);
	
}
