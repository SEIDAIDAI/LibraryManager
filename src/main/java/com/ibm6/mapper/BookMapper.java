package com.ibm6.mapper;

import java.util.List;

import com.ibm6.bean.Book;
import com.ibm6.bean.User;

public interface BookMapper {
	public List<Book> findByCondition(Book book);
	public Book findById(Book book);
	public List<Book> findByKeyword(Book book);  //统一传给书名
	public List<Book> findByPage(Integer index);  //统一传给书名
	public int updateById(Book book);
	public List<User> selectById(int index);
}
