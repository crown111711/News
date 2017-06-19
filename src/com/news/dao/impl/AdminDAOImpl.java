package com.news.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;


import com.news.dao.AdminDAO;
import com.news.entity.Admin;

public class AdminDAOImpl implements AdminDAO{
    SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List search(Admin condition) {
		// TODO Auto-generated method stub
         Session session=sessionFactory.getCurrentSession();
         Criteria criteria=session.createCriteria(Admin.class);
         Example example=Example.create(condition);
         criteria.add(example);
		 return criteria.list();
	}

}
