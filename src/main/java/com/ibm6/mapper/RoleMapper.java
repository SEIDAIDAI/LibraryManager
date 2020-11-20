package com.ibm6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ibm6.bean.Role;
import com.ibm6.bean.User;

@Mapper
public interface RoleMapper {
	
	public List<Role> findAllRole();
	public Role findByAccount(String account);
	public int insert(Role role);
	public int insertUser(User user);
	public int findMaxUserId();
	public int updateById(Role role);
	public Role findActiveRole(String account);
}
