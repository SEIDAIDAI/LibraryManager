package com.ibm6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.bean.Announcement;
import com.ibm6.bean.Borrow;
import com.ibm6.service.AnnouncementService;

@RestController
public class AnnouncementController {

	@Autowired
	private AnnouncementService service;
	
	//功能： 分页查询公告
	//输入参数: index 页号
	//输出参数: List<Announcement>
	@GetMapping("/selectPage/{index}")
	public List<Announcement> selectAllAnnouncement(@PathVariable("index") int index) {
		return service.selectAll(index*5);
	}
	
	//功能：  按公告表的ID查询单条公告
	//输入参数:  id
	//输出参数: Announcement
	@PostMapping("/getById")
	public Announcement getAnnouncementById(@RequestBody Announcement ann){
	
		return service.getById(ann);
	}
	
//	@GetMapping("/getById/{id}")
//	public Announcement getAnnouncementById(@PathVariable("id") Integer id){
//		Announcement ann=service.getById(id);
//		return ann;
//	}
	
	//功能：  更新公告表中的信息
	//输入参数: Announcement
	//输出参数: int
	@PostMapping("/updateAnnouncement")
	public int updateAnnouncementById(@RequestBody Announcement ann) {
		return service.updateById(ann);
	}
	
	//功能：  按公告表的ID删除公告信息
	//输入参数: id
	//输出参数: int
	@GetMapping("/deleteAnnouncement/{id}")
	public int deleteAnnouncement(@PathVariable("id") Integer id) {
		return service.deleteById(id);
	}
	
	//功能：  增加一条公告
	//输入参数: Announcement
	//输出参数: int
	@PostMapping("/addAnnouncement")
	public int addAnnouncement(@RequestBody Announcement ann) {
		int re=service.announcementInsert(ann);
		return re;
	}
	
	
	@GetMapping("showAnnouncement")
	public String showAnnouncement() {
		return service.showNewAnnouncement();
	}
}
