package com.ibm6.service;

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
		mapper.deleteUserByUserId(userId);
		mapper.updateRoleByUserId(userId);
		
		return 1;
	}
	
	
}
