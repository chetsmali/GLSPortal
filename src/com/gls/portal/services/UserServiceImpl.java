package com.gls.portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gls.portal.bean.AdminUsersDetail;
import com.gls.portal.bean.Role;
import com.gls.portal.bean.User;
import com.gls.portal.dao.UserDao;

@Service("userDetailsService")  
@Transactional
//@Configuration
//@ComponentScan("com.gls.portal.dao")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(final String userName)
			throws UsernameNotFoundException {
		System.out.println("Start UserserviceImpl:: loadUserByUsername(-)");
		
		User user = userDao.loadUserByUsername(userName);
		user.setAuthorities(user.getRoles());
		
		if(user!=null){
			System.out.println("End UserserviceImpl:: loadUserByUsername(-)");
			return user; 
		}else{			
			throw new UsernameNotFoundException("User Not found!");
		}		
	}
	public void saveUser(User user){
		userDao.saveUser(user);
	}
	public User getUser(String username){
		return userDao.getUser(username);
	}
}
