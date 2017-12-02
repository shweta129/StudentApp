package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.DAO.UserDAO;
import com.niit.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory SessionFactory;

	public void registerUser(User user) {
		Session session = SessionFactory.getCurrentSession();
		session.save(user);
		
	}

	public List<User> getAllUsers() {
		Session session = SessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		return query.list();
	}

	public void deleteUser(String username) {
		Session session =SessionFactory.getCurrentSession();
		User user = session.get(User.class, username);
		session.delete(user);
		
	}

	public User getUser(String username) {
		Session session =SessionFactory.getCurrentSession();
		User user = (User)session.get(User.class, username);
		return user;
	}

	public void updateUser(User user) {
		Session session = SessionFactory.getCurrentSession();
		session.update(user);
		
	}
	
	
	

	/*public boolean addUser(UserDetail user) {
		try{
			
			SessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:::"+e);
			return false;
		}
	}

	public boolean updateOnlineStatus(String status, UserDetail user) {
		try{
			user.setIsOnline(status);
			SessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:::"+e);
			return false;
		}
	}

	public UserDetail getUser(String username) {
		Session session= SessionFactory.openSession();
		UserDetail user=(UserDetail)session.get(UserDetail.class,username);
		session.close();
		return user;
	}

	public UserDetail getByEmail(String email) {

		return(UserDetail)SessionFactory
				.getCurrentSession().get(UserDetail.class, email) ;
	}

	public boolean delete(String email) {
		try {
			
			SessionFactory.getCurrentSession().delete(getByEmail(email));
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}*/

}
