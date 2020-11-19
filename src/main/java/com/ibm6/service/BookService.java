package com.ibm6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm6.bean.Book;
import com.ibm6.mapper.BookMapper;
import com.ibm6.model.BookLength;
import com.ibm6.model.BookNation;
import com.ibm6.model.BookTheme;
import com.ibm6.model.BookType;

@Service
public class BookService {
	@Autowired
	private BookMapper bookMapper;
	
	public int totalBookAmount()
	{
		int re = bookMapper.getCount();
		System.out.println(re);
		return re;
	}
		
	public List<Book> bookSearchByType(Book book) {
		List<Book> bookList = bookMapper.selectByCondition(book);
		
		return bookList;
	}
	
	public Book showBookInfo(Book book) {
		Book re = bookMapper.getById(book);
		return re;
	}
	
	public List<Book> bookSearchByKeyword(Book book)
	{
		List<Book> bookList = bookMapper.selectByKeyword(book);

		return bookList;
	}
	
	public List<Book> bookSearchByPage(Integer index)
	{
		List<Book> bookList = bookMapper.selectByPage(index);

		return bookList;
	}
	
	public int bookInfoUpdate(Book book)
	{
		int re = bookMapper.updateById(book);

		return re;
	}
	
	public int bookInsert(Book book)
	{
		int re = bookMapper.saveNewBook(book);
		return re;
	}
	
	public int bookDelete(Book book)
	{
		int re = bookMapper.deleteById(book);
		return re;
	}
	
	public List<BookNation> bookNations()
	{
		List<BookNation> bookList = bookMapper.selectAllNation();

		return bookList;
	}
	
	public List<BookType> bookTypes(){
		return bookMapper.selectAllType();
	}
	
	public List<BookTheme> bookThemes(int booktype){
		return bookMapper.selectAllTheme(booktype);
	}
	
	public List<BookLength> bookLengths(){
		return bookMapper.selectAllLength();
	}
}




