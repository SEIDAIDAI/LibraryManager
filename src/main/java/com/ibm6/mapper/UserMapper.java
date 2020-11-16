package com.ibm6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ibm6.bean.User;


@Mapper
public interface UserMapper {
	public void saveNewUser(User user);
	public int deleteById(int id);
	public List<User> findAll ();
	public User findById(int id);
	public int updateById(User user);
}