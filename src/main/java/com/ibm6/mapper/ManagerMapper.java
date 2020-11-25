package com.ibm6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ibm6.bean.Book;
import com.ibm6.bean.User;
import com.ibm6.model.UserAndAccount;

@Mapper
public interface ManagerMapper {
	public Book findBookById(Integer bookId);
	
	public int deleteUserByUserId(Integer userId);
	
	public int updateRoleByUserId(Integer userId);
	
	public List<User> findAll();
	
	public List<UserAndAccount> findUserByPage(Integer index);
}
