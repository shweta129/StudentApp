package com.niit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.BlogDAO;
import com.niit.dto.Blog;

public class BlogTest {
	public static AnnotationConfigApplicationContext context;
	private static BlogDAO blogDAO;
	private Blog blog;
	
	@BeforeClass
	public static void init(){
		context =new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		//blogDAO = (BlogDAO) context.getBean("bogDAO");
		blogDAO =(BlogDAO) context.getBean("blogDAO");
	}
	
	
	//@Ignore
	@Test
	public  void addBlogTest() {
		Blog blog = new Blog();
		
		blog.setBlogName("advance java");
		blog.setBlogContent("It is based on simple Java Concept");
		blog.setUsername("harshu");
		blog.setStatus("A");
		blog.setLikes(4);
		blog.setCreateDate(new java.util.Date());
		//blog.setCreateDate(new Date());
	
		assertEquals("Failed to add user!",true,blogDAO.addBlog(blog));
		
	}
	@Ignore
	@Test
	public void getBlogTest(){
		
		Blog blog = blogDAO.getBlog(2);
		
		
		System.out.println("Blog Name:"+blog.getBlogName());
		System.out.println("Blog Content"+blog.getBlogContent());
	}
	@Ignore	
	@Test
	public void getAllBlogTest(){
		
	    
		List<Blog> blogList=(List<Blog>)blogDAO.getAllBlogs();
		assertNotNull("Blog List Not Found", blogList.get(0));
		for(Blog blog:blogList)
			
		{
			System.out.println("Blog ID"+blog.getBlogId()+"::"+"Blog Name:"+blog.getBlogName());
			assertTrue("Problem in Deletion", blogDAO.deleteBlog(blog));
		}
	}
	@Ignore
    @Test
    public void deleteBlogTest()
    {
    	Blog blog = (Blog)blogDAO.getBlog(2);
    	assertTrue("Problem in deletion",blogDAO.deleteBlog(blog));
    }
	
	//@Ignore
	@Test
	public void updateBlogTest(){
	
		Blog blog = (Blog)blogDAO.getBlog(1);
		blog.setBlogContent("mmm");
		blog.setBlogName("java");
		assertTrue("Problem in updation",blogDAO.updateBlog(blog));
	}
	@Ignore
	@Test
	public void approveBlogTest(){
		
		Blog blog = (Blog)blogDAO.getBlog(3);
		assertTrue("Problem in approve",blogDAO.approveBlog(blog));
	}
}
