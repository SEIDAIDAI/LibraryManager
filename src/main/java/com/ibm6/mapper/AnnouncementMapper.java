package com.ibm6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibm6.bean.Announcement;


@Mapper
public interface AnnouncementMapper {
	public int deleteById(int id);
	public List<Announcement> selectAll(int index);
	public Announcement getById(Announcement ann);
	public int updateById(Announcement announcement);
	public int announcementInsert(Announcement announcement);
}
