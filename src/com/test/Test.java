package com.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.news.biz.NewsinfoBiz;
import com.news.entity.Newsinfo;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
     NewsinfoBiz biz=(NewsinfoBiz)context.getBean("newsinfoBiz");
     List list=biz.getAllNewsinfoByPage(1, 10);
     Iterator i=list.iterator();
     while(i.hasNext()){
    	 Newsinfo newsinfo=(Newsinfo)i.next();
    	 System.out.println(newsinfo.getTitle());
    	 
     }
     
	}
   
	
}
