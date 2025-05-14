package com.nutridiet.project.service;

import com.nutridiet.project.model.Admin;

public interface AdminService
{
	public Admin checkadminlogin(String email,String pwd);
}
