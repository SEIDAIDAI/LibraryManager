package com.ibm6.controller;


import java.text.DateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.bean.Book;
import com.ibm6.bean.Borrow;
import com.ibm6.bean.User;
import com.ibm6.model.BorrowDetail;
import com.ibm6.service.borrowService;

@RestController
public class BorrowController {
	@Autowired
	private borrowService service;
	
//	借阅详情
	@GetMapping("/borrowHistory/{userId}")
	public String borrowHistory(@PathVariable("userId") int userId) {
		List<Borrow> borrow = service.findAllBorrow();
		String string = "";
		for(Borrow borrow1:borrow) {
			if (borrow1.getUserId() == userId) {
				DateFormat df = DateFormat.getDateInstance();
				string = string +" 书名："+ borrow1.getBook().getBookName() +",借阅时间："+df.format(borrow1.getBorrowTime())+",应还时间："+df.format(borrow1.getRetTime())+",有效时间："+borrow1.getValidTime()+"\n";				
			}
		}		
		return string;
	}
//	输入书名模糊查询
	@GetMapping("/searchHisByBookName/{userId}/{bookName}")
	public String searchHisByBookName(@PathVariable("userId") int userId,@PathVariable("bookName") String book_name) {
		List<Borrow> borrow = service.findAllBorrow();
		String string = "";
		for(Borrow borrow1:borrow) {
			if (book_name.equals(borrow1.getBook().getBookName())&&borrow1.getUserId()==userId) {
				DateFormat df = DateFormat.getDateInstance();
				string = string +" 书名："+ borrow1.getBook().getBookName() +",借阅时间："+df.format(borrow1.getBorrowTime())+",应还时间："+df.format(borrow1.getRetTime())+",有效时间："+borrow1.getValidTime()+"\n";				
			}
		}		
		return string;
	}
	
	
}
