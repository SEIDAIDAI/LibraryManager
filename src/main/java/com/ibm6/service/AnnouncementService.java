package com.ibm6.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibm6.bean.Announcement;
import com.ibm6.bean.User;
import com.ibm6.mapper.AnnouncementMapper;

@Service
public class AnnouncementService {
	@Autowired
	private AnnouncementMapper mapper;
	
	public int deleteById(int id) {
		
		return mapper.deleteById(id);
	}
	
	public List<Announcement> selectAll(int index) {
		
		return mapper.selectAll(index);
	}
	
	public Announcement getById(Announcement ann) {
		
		return mapper.getById(ann);
	}
	
	public int updateById(Announcement announcement) {
		
		return mapper.updateById(announcement);
	}
	
	public int announcementInsert(Announcement announcement) {
		Date date=new Date();
		System.out.println(date);
		announcement.setPublishDate(date);
//		Calendar time = Calendar.getInstance();
//		time.set(Calendar.YEAR, 1997);
//		announcement.setExpireDate(time.getTime());
		return mapper.announcementInsert(announcement);
	}
	
	public Announcement showNewAnnouncement() {
		return mapper.showNewAnnouncement();
	}
}
