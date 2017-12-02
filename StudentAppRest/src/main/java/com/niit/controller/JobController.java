package com.niit.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.JobDAO;
import com.niit.dto.Blog;
import com.niit.dto.Forum;
import com.niit.dto.Job;

@RestController
public class JobController {

	@Autowired
	JobDAO jobDAO;
	
	
	@RequestMapping(value ="/insertJob")
	public ResponseEntity<String> insertJob(@RequestBody Job Job)
	{
		
		
		if(jobDAO.addJob(Job))
		{
			return new ResponseEntity<String>("Job Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	
	@RequestMapping(value="/updateJob")
	public  ResponseEntity<String> updateJob(@RequestBody Job job)
	{
		
		Job tempJob=jobDAO.getJob(job.getJobId());
		
		
		tempJob.setJobdesc(job.getJobdesc()); 
		tempJob.setJobprofile(job.getJobprofile()); 
		if(jobDAO.updateJob(tempJob))
		{
			return new ResponseEntity<String>("Job Update",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Job updation",HttpStatus.SERVICE_UNAVAILABLE);
			
		}
		
	}
	
	
	
	@RequestMapping(value = "/deleteJob")
	public ResponseEntity<String> deleteJob(@RequestBody Job job)
	{
		Job tempjob=jobDAO.getJob(job.getJobId());
		if(jobDAO.deleteJob(tempjob))
		{
			return new ResponseEntity<String>("Job Deleted",HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("Error in job deletion",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	
	
	
}
