package com.ibm6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm6.bean.User;
import com.ibm6.mapper.UserMapper;
import com.ibm6.model.UserAndAccount;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public int updateById(User user) {
		
		return userMapper.updateByIdSelective(user);
	}
	
	public int totalUserCount()
	{
		int re = userMapper.getTotalUserCount();
		return re;
	}
	public User showUser(int userId) {
		return userMapper.findById(userId);
	}
	
	
	public List<User> findAll(){
		return userMapper.findAll();
	}
	
	public List<User> findUserByPage(Integer index){
		return userMapper.findUserByPage(index);
	}
	
	public int userByExampleCount(User user)
	{
		return userMapper.findUserCountByExample(user);
	}
	
	public List<UserAndAccount> findUserByExample(User user,Integer index) {
		return userMapper.findUserByExample(user,index);
	}
}
