package com.ibm6.service;

import org.springframework.stereotype.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm6.bean.Book;
import com.ibm6.bean.User;
import com.ibm6.mapper.BookMapper;
import com.ibm6.mapper.ManagerMapper;
import com.ibm6.mapper.UserMapper;

@Service
public class ManagerService {
	
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private ManagerMapper mapper;
//	private manager
	public Book findBookById(Book book) {
		return bookMapper.getById(book);
	}
	
	
	public int deleteUser(Integer userId) {
		int ret=mapper.deleteUserByUserId(userId);
		mapper.updateRoleByUserId(userId);
		if (ret==1) {
			return 1;
		}
		return 0;
	}
	
	
}
