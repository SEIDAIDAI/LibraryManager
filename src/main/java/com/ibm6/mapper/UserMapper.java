package com.ibm6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ibm6.bean.User;


@Mapper
public interface UserMapper {
	public void insert(User user);
	public int deleteById(int id);
	public int getTotalUserCount();
	public List<User> findAll ();
	public User findById(int id);
	public int updateById(User user);
	public int updateByIdSelective(User user);
	public List<User> findUserByPage(Integer index);
	public int findUserCountByExample(User user);
	public List<User> findUserByExample(@Param("user")User user,@Param("index")Integer index);
}