package com.ibm6.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ibm6.bean.Book;

@Mapper
public interface ManagerMapper {
	public Book findBookById(Integer bookId);
}
