package com.news.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.news.dao.TopicDAO;
import com.news.entity.Topic;

public class TopicDAOImpl implements TopicDAO{
     SessionFactory sessionFactory;
     public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List getAllTopic() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria =session.createCriteria(Topic.class);		
		return criteria.list();
	}

}
