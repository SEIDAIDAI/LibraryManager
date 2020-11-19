package com.ibm6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.service.AnnouncementService;

@RestController
public class AnnouncementController {

	@Autowired
	private AnnouncementService service;
	
	@GetMapping("/manageAnnouncement")
	public void manageAnnouncement() {
		
	}
}
