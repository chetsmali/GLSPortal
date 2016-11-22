package com.gls.portal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gls.portal.bean.AdminUsersDetail;
import com.gls.portal.bean.Role;
import com.gls.portal.bean.User;
import com.gls.portal.dao.UserDao;
import com.gls.portal.services.UserService;

@Controller
public class CommonController {
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/loginProcess")
    public String defaultAfterLogin(HttpServletRequest request) {
		System.out.println("CommonController:: defaultAfterLogin()");
		String redirectUrl = "";
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		request.getSession().setAttribute("username", userDetails.getUsername());
		System.out.println(request.getSession().getAttribute("username"));
		
        if (request.isUserInRole("ROLE_ADMIN")) {
            redirectUrl="redirect:/admin";
        }else if (request.isUserInRole("ROLE_USER")) {        
        	redirectUrl= "redirect:/user";
        }
        return redirectUrl;
    }
	
	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "denied";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		System.out.println("CommonController:: logout()");
		return "logout";
	}
	
	@RequestMapping(value = "/test", produces = "application/json")
	public @ResponseBody List<User> listAllUsers(HttpServletRequest request) {
		System.out.println("CommonController:: test()");
		return userDao.getLoginCredentials();
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String getProfile(HttpServletRequest request) {
		System.out.println("CommonController:: getProfile()");
		return "profile";
	}
	
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST, produces = "application/json")
	/*public @ResponseBody Integer hello(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {*/
	public @ResponseBody Integer updateUserProfile(@RequestBody User user/*, @RequestParam("file") MultipartFile file*/) {
		System.out.println("CommonController:: updateUserProfile()");
		int result = 0;
		//String username = (String) request.getSession().getAttribute("username");
		System.out.println("User:: "+user.toJSONString());
		
		if(user != null){
			userService.saveUser(user);
			result = 1;
		}
		return result;
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public @ResponseBody String getUserDetail(HttpServletRequest request) throws JsonProcessingException {
		System.out.println("CommonController:: getUserDetail()");
		String username = (String) request.getSession().getAttribute("username");
		System.out.println("username:: "+username);
		
		User user = userService.getUser(username);
		AdminUsersDetail adminUsersDetail = user.getAdminUsersDetails();
		System.out.println("User:: "+user.toJSONString());
		
		ObjectMapper mapper = new ObjectMapper();
        
        String json = mapper.writeValueAsString(user);
        System.out.println(json);
		
		return json;
	}
	
	@ModelAttribute
	public void getModel(Model model){
		model.addAttribute("headerName", "GLSPortal");
	}

}
