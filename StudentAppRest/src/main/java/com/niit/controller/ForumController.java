package com.niit.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.ForumDAO;
import com.niit.dto.Blog;
import com.niit.dto.Forum;

@RestController
public class ForumController {
	
	@Autowired
	ForumDAO forumDAO;
	
	@RequestMapping(value="/insertForum")
	public ResponseEntity<String> insertForum(@RequestBody Forum forum)
	{ 
		int i=10;
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<String>("Forum Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@RequestMapping(value="/updateForum")
	public  ResponseEntity<String> updateForum(@RequestBody Forum forum)
	{
		Forum tempForum=forumDAO.getForum(forum.getForumId());
		
		
		
		tempForum.setForumName(forum.getForumName());
		tempForum.setForumContent(forum.getForumContent());
		if(forumDAO.updateForum(tempForum))
		{
			return new ResponseEntity<String>("Forum Update",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Forum updation",HttpStatus.SERVICE_UNAVAILABLE);
			
		}
		
	}

		@RequestMapping(value="/getAllForum")
		public ResponseEntity<ArrayList<Forum>> getAllForum()
		{
			ArrayList listForums = (ArrayList)forumDAO.getAllForums();
			return new ResponseEntity<ArrayList<Forum>>(listForums,HttpStatus.OK);
	     }
	
		
		@RequestMapping(value = "deleteForum")
		public ResponseEntity<String> deleteForum(@RequestBody Forum forum)
		{
			Forum tempforum=forumDAO.getForum(forum.getForumId());
			if(forumDAO.deleteForum(tempforum))
			{
				return new ResponseEntity<String>("Forum Deleted",HttpStatus.OK);
			}
			else{
				return new ResponseEntity<String>("Error in forum deletion",HttpStatus.SERVICE_UNAVAILABLE);
			}
		}

}
