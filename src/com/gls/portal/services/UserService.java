package com.gls.portal.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gls.portal.bean.Role;
import com.gls.portal.bean.User;

public interface UserService extends UserDetailsService {
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException;
	public User getUser(String username);
	public void saveUser(User user);
}
