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
	
	@GetMapping("/selectAll")
	public List<Announcement> selectAllAnnouncement() {
		return service.selectAll();
	}
	
	@GetMapping("/getById/{id}")
	public Announcement getAnnouncementById(Announcement announcement,@PathVariable("id") Integer id){
		Announcement ann=service.getById(announcement);
		return ann;
	}
	
	@PostMapping("/updateAnnouncement")
	public int updateAnnouncementById(@RequestBody Announcement ann) {
		return service.updateById(ann);
	}
	
	@GetMapping("/deleteAnnouncement/{id}")
	public int deleteAnnouncement(Announcement announcement,@PathVariable("id") Integer id) {
		return service.deleteById(announcement);
	}
	
}
