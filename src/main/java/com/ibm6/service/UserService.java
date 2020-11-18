package com.ibm6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm6.bean.User;
import com.ibm6.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public int updateById(User user) {
		
		return userMapper.updateByIdSelective(user);
	}
	
	
	public User showUser(int userId) {
		return userMapper.findById(userId);
	}
}
