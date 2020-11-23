package com.ibm6.service;

import java.util.Date;
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
	
	//返回书总数
	public int totalBookAmount()
	{
		int re = bookMapper.getCount();
		System.out.println(re);
		return re;
	}
	
	//根据书四个条件查询
	public List<Book> bookSearchByType(Book book,Integer index) {
		List<Book> bookList = bookMapper.selectByCondition(book,index);
		
		return bookList;
	}
	
	public int bookTotalByType(Book book)
	{
		int re = bookMapper.getBookTotalByType(book);
		return re;
	}
	
	//书详情
	public Book showBookInfo(Book book) {
		Book re = bookMapper.getById(book);
		return re;
	}
	
	//关键字查询  书名和作者
	public List<Book> bookSearchByKeyword(Book book,Integer index)
	{
		List<Book> bookList = bookMapper.selectByKeyword(book,index);

		return bookList;
	}
	
	public int BookTotalByKeyword(Book book)
	{
		int re = bookMapper.getBookTotalByKeyword(book);
		return re;
	}
	
	//分页查询
	public List<Book> bookSearchByPage(Integer index)
	{
		List<Book> bookList = bookMapper.selectByPage(index);

		return bookList;
	}
	//书籍信息更新
	public int bookInfoUpdate(Book book)
	{
		int re = bookMapper.updateById(book);

		return re;
	}
	//新增书籍
	public int bookInsert(Book book)
	{
		System.out.println(book);
		int re = bookMapper.saveNewBook(book);
		return re;
	}
	//删除书籍
	public int bookDelete(Book book)
	{
		book.setStoreDate(new Date());
		book.setLeftAmount(book.getUploadAmount());
		book.setDownloadAmount(0);
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




