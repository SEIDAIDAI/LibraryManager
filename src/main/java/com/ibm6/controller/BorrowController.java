package com.ibm6.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.text.DateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.bean.Book;
import com.ibm6.bean.Borrow;
import com.ibm6.bean.User;
import com.ibm6.model.BorrowByPage;
import com.ibm6.model.BorrowDetail;
import com.ibm6.model.BorrowList;
import com.ibm6.model.UserBorrowLikeSearch;
import com.ibm6.service.borrowService;

@RestController
public class BorrowController {
	@Autowired
	private borrowService service;
	
//	借阅详情
	@GetMapping("/borrowInfo/{id}")
	public BorrowDetail borrowHistory(@PathVariable("id") int id) {
		BorrowDetail borrow = service.getBorrowInfo(id);		
		return borrow;
	}
	
	//通过userId返回书列表信息
	@GetMapping("/borrowList/{userId}")
	public List<BorrowList> borrowBookInfo(@PathVariable("userId") int userId) {
		List<BorrowList> borrow = service.getBorrowList(userId);	
		return borrow;
	}
	

//	输入书名和用户名查询
	//在上面查询的结果上  加上书名进行过滤
	@PostMapping("/borrowUserLikeSearch")
	public BorrowDetail searchHisByLikeSearch(@RequestBody UserBorrowLikeSearch userBorrowLikeSearch) {
		BorrowDetail borrowDetail=service.borrowUserLikeSearch(userBorrowLikeSearch);
		return borrowDetail;
	}
	

	@GetMapping("/borrowCount/{userId}")
	public int BorrowCount(@PathVariable("userId") int userId)
	{
		int re = service.getBorrowTotal(userId);
		return re;
	}
	
	@PostMapping("/borrowPage")
	public List<Book> BorrowPage(@RequestBody BorrowByPage borrowByPage)
	{
		List<Book> re = service.getBorrowByPage(borrowByPage);
		return re;
	}
}
