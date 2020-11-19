package com.ibm6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm6.mapper.AnnouncementMapper;

@Service
public class AnnouncementService {
	@Autowired
	private AnnouncementMapper mapper;

}
