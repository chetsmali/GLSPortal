package com.gls.portal.dao;

import java.util.List;

import com.gls.portal.bean.Role;
import com.gls.portal.bean.User;

public interface UserDao {
	User loadUserByUsername(final String username);
	public List<User> getLoginCredentials();
	public User getUser(String username);
	public void saveUser(User user);
}
