package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.JobDAO;

@RestController
public class JobController {

	@Autowired
	JobDAO jobDAO;
	
}
