package com.ibm6.mapper;

import com.ibm6.bean.Book;

public interface BookMapper {
	public int findByCondition(Book book);
}
