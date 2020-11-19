package com.ibm6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm6.bean.Announcement;
import com.ibm6.bean.User;
import com.ibm6.mapper.AnnouncementMapper;

@Service
public class AnnouncementService {
	@Autowired
	private AnnouncementMapper mapper;
	
	public int deleteById(Announcement announcement) {
		
		return mapper.deleteById(announcement);
	}
	
	public List<Announcement> selectAll() {
		
		return mapper.selectAll();
	}
	
	public Announcement getById(Announcement announcement) {
		
		return mapper.getById(announcement);
	}
	
	public int updateById(Announcement announcement) {
		
		return mapper.updateById(announcement);
	}
}
