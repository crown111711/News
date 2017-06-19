package com.news.action;


import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.news.biz.AdminBiz;
import com.news.entity.Admin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements SessionAware {
     private String loginName;
     private String loginPwd;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	
	AdminBiz adminBiz;
	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}
	
	Map<String,Object>session;
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String validateLogin()throws Exception{
		   Admin condition=new Admin();
		   condition.setLoginName(loginName);
		   condition.setLoginPwd(loginPwd);
		   List list=adminBiz.login(condition);
		   if(list.size()>0)
		   session.put("admin",list.get(0));
		   return "index";
		  
		
		
	}

	   public String logout() throws Exception{
	    	 session.remove("admin");
	    	 return "logout";
	     }
}
