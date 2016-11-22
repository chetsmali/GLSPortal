package com.gls.portal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gls.portal.bean.Role;
import com.gls.portal.bean.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	

	@SuppressWarnings("unchecked")
	public User loadUserByUsername(String username) {
		System.out.println("LoginDaoImpl:: loadUserByUsername(-)");
		System.out.println("username:: "+username);
		List<User> userList=(List<User>)getCurrentSession().createQuery("select u from User as u where u.username='"+username+"'").list();
		System.out.println("userList:: "+userList.size());
		User user=null;		
		if(userList.size()>0){			
			user=userList.get(0);
			System.out.println("User:: "+userList.get(0));
		}		
		return user;
	}
	
	public List<User> getLoginCredentials(){
		System.out.println("LoginDaoImpl:: getLoginCredentials()");
		List<User> userList=(List<User>)getCurrentSession().createQuery("select u from User as u").list();
		System.out.println("userList:: "+userList);
		return userList;
	}


	@Override
	public void saveUser(User user) {
		getCurrentSession().saveOrUpdate(user);
	}


	@Override
	public User getUser(String username) {
		List<User> userList=(List<User>)getCurrentSession().createQuery("select u from User as u where u.username='"+username+"'").list();
		System.out.println("userList:: "+userList.size());
		User user=null;		
		if(userList.size()>0){			
			user=userList.get(0);
			System.out.println("User:: "+userList.get(0));
		}		
		return user;
	}
}
