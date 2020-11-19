package com.ibm6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm6.bean.Borrow;
import com.ibm6.mapper.BorrowMapper;
import com.ibm6.model.BorrowDetail;

@Service
public class borrowService {

	@Autowired
	private BorrowMapper mapper;
	
	public List<Borrow> findAllBorrow() {
		return mapper.findAllBorrow();
		
	}
	
//	public List<BorrowDetail> findByBookName(Borrow borrow) {
//		List<BorrowDetail> re = mapper.findByBookName(borrow);
//		return re;
//	}
	
}
