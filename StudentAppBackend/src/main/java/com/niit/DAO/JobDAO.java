package com.niit.DAO;

import com.niit.dto.Forum;
import com.niit.dto.Job;

public interface JobDAO {

	public boolean addJob(Job job);
	public boolean updateJob(Job job);
	public boolean deleteJob(Job job);
	public boolean showJob(Job job);
	public Job getJob(int jobId);
	
}
