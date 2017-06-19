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
	        //���û��ָ����ѯ��������ȡָ��ҳ��������б�
			newsinfoList=newsinfoBiz.getAllNewsinfoByPage(curPage,10);
			//�ٻ����������������������ʼ����ҳ��Pager����
			pager=newsinfoBiz.getPagerOfAllNewsinfo(10);			
		}else{
			//���ָ���˲�ѯ����������������ȡָ��ҳ��������б�
			newsinfoList=newsinfoBiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
			//�ٸ������������������������������ʼ����ҳ��Pager����
			pager=newsinfoBiz.getPagerOfNewsinfo(newsinfo,10);			
		}
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//������ʾ�ĵ�ǰҳ�����б����request��Χ
		request.put("newsinfoList", newsinfoList);
		//��ȡ��������
		List topicList=topicBiz.getAllTopic();
		//�������б����request��Χ
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
		//��ȡ5����������
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
