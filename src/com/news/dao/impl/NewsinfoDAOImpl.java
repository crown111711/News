package com.news.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.news.dao.NewsinfoDAO;
import com.news.entity.Newsinfo;

public class NewsinfoDAOImpl implements NewsinfoDAO {
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
	@Override
	public List getAllNewsinfoByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
	    Session session=sessionFactory.getCurrentSession();
	    Criteria criteria=session.createCriteria(Newsinfo.class);
	    criteria.setFirstResult(pageSize*(page-1));
	    criteria.setMaxResults(pageSize);
	    criteria.addOrder(Order.desc("createDate"));
	    List list=criteria.list();
		return list;
	}

	@Override
	public Integer getCountOfAllNewsinfo() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Newsinfo.class);   
 	    // criteria.setProjection(Projections.count("id"));
 	    // result=criteria.uniqueResult();
		 List list=criteria.list();
		return list.size();
	}

	@Override
	public List getNewsinfoByConditionAndPage(Newsinfo condition, int page,int pageSize) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Newsinfo.class);
		if(condition!=null){
			  if((condition.getTopic()!=null)&&(condition.getTopic().getId()!=null)){
				      criteria.add(Restrictions.eq("topic.id", condition.getTopic().getId()));				  
			  }
			  if(condition.getTitle()!=null)
			  {
			   criteria.add(Restrictions.like("title", condition.getTitle(), MatchMode.ANYWHERE));
			  }
			  
		}
		criteria.setFirstResult(pageSize*(page-1));
		criteria.setMaxResults(pageSize);
		
		return criteria.list();
		/*Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Newsinfo.class);
		if(condition!=null){
			if((condition.getTopic()!=null) && (condition.getTopic().getId()!=null))
				c.add(Restrictions.eq("topic.id", condition.getTopic().getId()));
			if((condition.getTitle()!=null) && !("".equals(condition.getTitle())))
				c.add(Restrictions.like("title", condition.getTitle(),MatchMode.ANYWHERE));
		}
		c.setFirstResult(pageSize*(page-1));
		c.setMaxResults(pageSize);
		c.addOrder(Order.desc("createDate"));
		return c.list();*/
	}

	@Override
	public Integer getCountOfNewinfo(Newsinfo condition) {
		
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Newsinfo.class);
		if(condition!=null){
			  if((condition.getTopic()!=null)&&(condition.getTopic().getId()!=null)){
				      criteria.add(Restrictions.eq("topic.id", condition.getTopic().getId()));				  
			  }
			  if((condition.getTitle()!=null)&&!("".equals(condition.getTitle())))
			  {
			   criteria.add(Restrictions.like("title", condition.getTitle(), MatchMode.ANYWHERE));
			  }
			  
		}
		return criteria.list().size();
	}

	@Override
	public Newsinfo getNewsinfoById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Newsinfo newsinfo=(Newsinfo)session.get(Newsinfo.class, id);
		return newsinfo;
	}

	@Override
	public void save(Newsinfo newsinfo) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
	     session.saveOrUpdate(newsinfo);
		
	}
	

	@Override
	public void delete(Newsinfo newsinfo) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(newsinfo);
	}
	
	

}
