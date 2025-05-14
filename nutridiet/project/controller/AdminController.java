package com.nutridiet.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nutridiet.project.model.Admin;
import com.nutridiet.project.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController
{
	@Autowired
	private AdminService adminService;
	@GetMapping("adminlogin")
    public ModelAndView adminlogin()
    {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("admin_login");
      return mv;
    }
	
	
	 @PostMapping("checkadminlogin")
	    // @ResponseBody
	     public ModelAndView checkadminlogin(HttpServletRequest request)
	     {
	      ModelAndView mv = new ModelAndView();
	      
	       String auname = request.getParameter("auname");
	       String apwd = request.getParameter("apwd");
	       
	       Admin admin = adminService.checkadminlogin(auname, apwd);
	       
	       if(admin!=null)
	       {
	        // return "Admin Login Success";
	        mv.setViewName("admin_home");
	       }
	       else
	       {
	         //return "Admin Login Fail";
	        mv.setViewName("adminloginfail");
	        mv.addObject("message", "Login Failed");
	       }
	       return mv;
	     }
	 
	 @GetMapping("adminhome")
	    public ModelAndView adminhome()
	    {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("admin_home");
	      return mv;
	    }
	 
	 @GetMapping("adminloginfail")
	    public ModelAndView adminloginfail()
	    {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("adminloginfail");
	      return mv;
	    }
}
