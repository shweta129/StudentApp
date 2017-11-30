package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.BlogDAO;
import com.niit.dto.Blog;

@Repository("blogDAO")
@Transactional    //all methods are run under transaction
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory SessionFactory;
	
	//@Override
	public boolean addBlog(Blog blog) {
		try {
			SessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	//@Override
	public boolean updateBlog(Blog bolg) {
try {
			
			SessionFactory.getCurrentSession().update(bolg);;
			return true;
			
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	//@Override
	public boolean deleteBlog(Blog blog) {
		try{
			SessionFactory.getCurrentSession().delete(blog);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured"+e);
			return false;
		}
	}

	//@Override
	public Blog getBlog(int blogId) {
		Session session = SessionFactory.openSession();
		Blog blog = session.get(Blog.class, blogId);
		session.close();
		return blog;
	}

	//@Override
	public List<Blog> getAllBlogs() {
		/*Session session = SessionFactory.openSession();
		List<Blog> blogList=(List<Blog>)session.createQuery("from Blog");
		session.close();
		return blogList;*/
		Session session = SessionFactory.getCurrentSession();
		Query query = session.createQuery("from Blog");
		return query.list();
	}

	//@Override
	public boolean approveBlog(Blog blog) {
		try{
			blog.setStatus("A");
			SessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}
			catch(Exception e)
			{
			System.out.println("Exception Occured:"+e);
			return false;
			}
	}

	//@Override
	public boolean rejectBlog(Blog blog) {
		try {
			blog.setStatus("N");
			SessionFactory.getCurrentSession().update(blog);
			return true;
			
			
		} catch (Exception e) {
			System.out.println("Exception Occured"+e);
			return false;
		}
	}

}
