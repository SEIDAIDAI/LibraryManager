package com.ibm6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ibm6.bean.Book;
import com.ibm6.bean.User;
import com.ibm6.model.BookLength;
import com.ibm6.model.BookNation;
import com.ibm6.model.BookTheme;
import com.ibm6.model.BookType;
import com.ibm6.model.BookUserList;

public interface BookMapper {
	public List<Book> selectByCondition(@Param("book")Book book,@Param("index") Integer index);
	public Book getById(Book book);
	public List<Book> selectByKeyword(@Param("book")Book book,@Param("index")Integer index);  //统一传给书名
	public List<Book> selectByPage(Integer index);  //统一传给书名
	public int updateById(Book book);
	public List<User> selectById(int index);
	public int saveNewBook(Book book);
	public int deleteById(Book book);
	public int getCount();
	public List<BookNation> selectAllNation();
	public List<BookType> selectAllType();
	public List<BookTheme> selectAllTheme(int bookType);
	public List<BookLength> selectAllLength();
	public int getBookTotalByType(Book book);
	public int getBookTotalByKeyword(Book book);
	public List<BookUserList> selectBookUserList(int bookId);
	public int getUploadAmount(Book book);
	public Book getByBook(Book book);
}
