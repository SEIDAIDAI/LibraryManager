package com.ibm6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ibm6.bean.Announcement;


@Mapper
public interface AnnouncementMapper {
	public int deleteById(Announcement announcement);
	public List<Announcement> selectAll();
	public Announcement getById(Announcement announcement);
	public int updateById(Announcement announcement);
}
