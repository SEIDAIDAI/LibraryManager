package com.ibm6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ibm6.bean.Book;
import com.ibm6.bean.Borrow;
import com.ibm6.model.BorrowDetail;


@Mapper
public interface BorrowMapper {

	public List<Borrow> findAllBorrow();
//	public List<BorrowDetail> findByBookName(Borrow borrow);
}
