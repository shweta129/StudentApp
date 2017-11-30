package com.niit.DAOImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.JobDAO;
import com.niit.dto.Blog;
import com.niit.dto.Job;

@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO{
	
	@Autowired
	private SessionFactory SessionFactory;
	
	//@Override
	public boolean addJob(Job job) {
		
		try {
			SessionFactory.getCurrentSession().save(job);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	//@Override
	public boolean updateJob(Job job) {
    try {
			
			SessionFactory.getCurrentSession().update(job);;
			return true;
			
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	//@Override
	public boolean deleteJob(Job job) {
		try{
			SessionFactory.getCurrentSession().delete(job);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured"+e);
			return false;
		}
	}

	

	//@Override
	public Job getJob(int jobId) {
		Session session = SessionFactory.openSession();
		Job job = session.get(Job.class, jobId);
		session.close();
		return job;
	}

	public boolean showJob(Job job) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
