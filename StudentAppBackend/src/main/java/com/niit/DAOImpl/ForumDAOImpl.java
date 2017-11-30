package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.ForumDAO;
import com.niit.dto.Blog;
import com.niit.dto.Forum;

@Repository("forumDAO")
@Transactional    //all methods are run under transaction
public class ForumDAOImpl implements ForumDAO{

	@Autowired
	private SessionFactory SessionFactory;

	public boolean addForum(Forum forum) {
		try {
			SessionFactory.getCurrentSession().save(forum);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateForum(Forum forum) {
try {
			
			SessionFactory.getCurrentSession().update(forum);;
			return true;
			
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	public boolean deleteForum(Forum forum) {
		try{
			SessionFactory.getCurrentSession().delete(forum);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured"+e);
			return false;
		}
	}
	public Forum getForum(int forumId) {
		Session session = SessionFactory.openSession();
		Forum forum = session.get(Forum.class, forumId);
		session.close();
		return forum;
	}

	public List<Forum> getAllForums() {
		Session session = SessionFactory.getCurrentSession();
		Query query = session.createQuery("from Forum");
		return query.list();
	}
		
	public boolean approveForum(Forum forum) {
		try{
			forum.setStatus("A");
			SessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
			catch(Exception e)
			{
			System.out.println("Exception Occured:"+e);
			return false;
			}
	}

	public boolean rejectForum(Forum forum) {
		try {
			forum.setStatus("N");
			SessionFactory.getCurrentSession().update(forum);
			return true;
			
			
		} catch (Exception e) {
			System.out.println("Exception Occured"+e);
			return false;
		}
	}

	
}
