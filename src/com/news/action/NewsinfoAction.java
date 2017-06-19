package com.news.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.news.biz.NewsinfoBiz;
import com.news.biz.TopicBiz;
import com.news.entity.Admin;
import com.news.entity.Newsinfo;
import com.news.entity.Pager;
import com.news.entity.Topic;
import com.opensymphony.xwork2.ActionSupport;





public class NewsinfoAction extends ActionSupport implements RequestAware,SessionAware {
   Newsinfo newsinfo;
   Pager pager;
    int id;
    
  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
public Newsinfo getNewsinfo() {
	return newsinfo;
}
public void setNewsinfo(Newsinfo newsinfo) {
	this.newsinfo = newsinfo;
}
public Pager getPager() {
	return pager;
}
public void setPager(Pager pager) {
	this.pager = pager;
}


  NewsinfoBiz newsinfoBiz;
  TopicBiz topicBiz;
  
 public void setNewsinfoBiz(NewsinfoBiz newsinfoBiz) {
	this.newsinfoBiz = newsinfoBiz;
}
public void setTopicBiz(TopicBiz topicBiz) {
	this.topicBiz = topicBiz;
}


Map<String,Object>session;
@Override
public void setSession(Map<String, Object> session) {
	// TODO Auto-generated method stub
	this.session=session;
}


Map<String,Object>request;
@Override
public void setRequest(Map<String, Object> request) {
	// TODO Auto-generated method stub
	this.request=request;
}
   
    public String index() throws Exception{
	  /* int curPage=1;
	   if(pager!=null){
		   curPage=pager.getCurPage();
	   }
       
	   List newsinfoList=null;
	   if(newsinfo==null){ 
		   newsinfoList=newsinfoBiz.getAllNewsinfoByPage(curPage, 10); 
		   pager=newsinfoBiz.getPagerOfAllNewsinfo(10);
	   }else{
		   newsinfoList=newsinfoBiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
		   pager=newsinfoBiz.getPagerOfNewsinfo(newsinfo, 10);   
	   }
    	pager.setCurPage(curPage);
    	request.put("newsinfoList", newsinfoList);
    	List topicList=topicBiz.getAllTopic();
    	request.put("topicList", topicList);
    	
	  return "index";*/
    	
    	int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List newsinfoList=null;
		if(newsinfo==null){
	        //如何没有指定查询条件，获取指定页码的新闻列表
			newsinfoList=newsinfoBiz.getAllNewsinfoByPage(curPage,10);
			//再获得所有新闻总数，用来初始化分页类Pager对象
			pager=newsinfoBiz.getPagerOfAllNewsinfo(10);			
		}else{
			//如果指定了查询条件，根据条件获取指定页码的新闻列表
			newsinfoList=newsinfoBiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
			//再根据条件获得所属新闻总数，用来初始化分页类Pager对象
			pager=newsinfoBiz.getPagerOfNewsinfo(newsinfo,10);			
		}
		//设置Pager对象中的待显示页页码
		pager.setCurPage(curPage);
		//将待显示的当前页新闻列表存入request范围
		request.put("newsinfoList", newsinfoList);
		//获取所有主题
		List topicList=topicBiz.getAllTopic();
		//将主题列表存入request范围
		request.put("topicList", topicList);
		return "index";
    }
    
    public String indexsidebar()throws Exception{
    	/*Newsinfo  condition=new Newsinfo();
    	Topic topic=new Topic();
    	
    	topic.setId(1);
    	condition.setTopic(topic);
    	List domesticNewsList=newsinfoBiz.getNewsinfoByConditionAndPage(condition, 1, 5);
    	
    	topic.setId(2);
    	condition.setTopic(topic);
    	List internationalNewsList=newsinfoBiz.getNewsinfoByConditionAndPage(condition, 1, 5);
    	
    	request.put("domesticNewList", domesticNewsList);
    	request.put("internationalNewsList", internationalNewsList);
    	
    	return "index_siderbar";*/ 	
    	Newsinfo conditon =new Newsinfo();
		Topic topic =new Topic();
		topic.setId(1);
		conditon.setTopic(topic);		
		List domesticNewsList=newsinfoBiz.getNewsinfoByConditionAndPage(conditon, 1,5);
		//获取5条国际新闻
		topic.setId(2);
		conditon.setTopic(topic);
		List internationalNewsList=newsinfoBiz.getNewsinfoByConditionAndPage(conditon, 1,5);
		request.put("domesticNewsList", domesticNewsList);
		request.put("internationalNewsList", internationalNewsList);
		return "index_sidebar";
		
    }
    
    public String newsread() throws Exception{
    	
    	Newsinfo newsinfo=newsinfoBiz.getNewsinfoById(id);
    	request.put("newsinfo", newsinfo);
    	return "news_read";
    }
    
    public String admin() throws Exception{
    	List newsinfoList=null;
    	int curPage=1;
    	if(pager!=null)
    		curPage=pager.getCurPage();
    	if(newsinfo==null){
    	        newsinfoList=newsinfoBiz.getAllNewsinfoByPage(curPage, 10);
    	        pager=newsinfoBiz.getPagerOfAllNewsinfo(10);
    		
    	}else{
    		
    		newsinfoList=newsinfoBiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
    		pager=newsinfoBiz.getPagerOfNewsinfo(newsinfo, 10);
    	}
    	pager.setCurPage(curPage);
    	request.put("newsinfoList", newsinfoList);
    	List topicList=topicBiz.getAllTopic();
    	request.put("topicList", topicList);
    	
    	
    	return "admin";
    }
    
    
    public String toNewsAdd() throws Exception{
    	List topicList=topicBiz.getAllTopic();
		request.put("topicList", topicList);
		return "new_add";
    }
   
     public String doNewsAdd() throws Exception{
    	  
    	 if(newsinfo!=null){
    		 Admin admin=(Admin)session.get("admin");
    		 newsinfo.setAuthor(admin.getLoginName());
    		 newsinfo.setCreateDate(new Date());
    	    newsinfoBiz.save(newsinfo);
    	 }
    	 return "admintan";
    	 
     }
     
     public String toNewsModify() throws Exception{
    	 
    	  Newsinfo   news=newsinfoBiz.getNewsinfoById(Integer.valueOf(id));
    	  newsinfo=newsinfoBiz.getNewsinfoById(id);
    	   request.put("news", news);
    	   List<Topic> topicList=topicBiz.getAllTopic();
    	   request.put("topicList", topicList);
    	   return "news_modify";
     }
     
     public String doNewsModify() throws Exception{
    	 
    	   newsinfoBiz.save(newsinfo);
    	   return "admin";
    	 
     }
     
     public String deleteNews()throws Exception{
    	 
    	 newsinfo=newsinfoBiz.getNewsinfoById(id);
    	 newsinfoBiz.delete(newsinfo);   	 
    	 return "delete";
    	 
     }
     
  

}
