package com.niit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.JobDAO;
import com.niit.dto.Blog;
import com.niit.dto.Forum;
import com.niit.dto.Job;



public class JobTest {
private static final Object Job= null;
	
	public static AnnotationConfigApplicationContext context;
	private static JobDAO jobDAO;
	private Job job;
	
	@BeforeClass
	public static void init(){
		context =new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobDAO =(JobDAO) context.getBean("jobDAO");
	}
	
	
	//@Ignore
	@Test
	public  void addJobTest() {
		Job job = new Job();
		
		job.setJobprofile("shweta");
		job.setJobdesc("software engineer");
		job.setQualification("BE");
		job.setStatus("OL");
		job.setPostdate(new java.util.Date());
		
		
		
	
		assertEquals("Failed to add user!",true,jobDAO.addJob(job));
		
	} 
	
	@Ignore
	@Test
	public void updateJobTest(){
	
		Job job = jobDAO.getJob(1);
		job.setJobdesc("bxnbx");
		job.setPostdate(new java.util.Date());
		assertTrue("Problem in updation",jobDAO.updateJob(job));
	}
	
	@Ignore
    @Test
    public void deleteJobTest()
    {
    	Job job = (Job)jobDAO.getJob(1);
    	assertTrue("Problem in deletion",jobDAO.deleteJob(job));
    }
	
}
