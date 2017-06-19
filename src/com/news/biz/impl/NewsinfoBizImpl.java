package com.news.biz.impl;

import java.util.List;

import com.news.biz.NewsinfoBiz;
import com.news.dao.NewsinfoDAO;
import com.news.entity.Newsinfo;
import com.news.entity.Pager;

public class NewsinfoBizImpl implements NewsinfoBiz{
    NewsinfoDAO newsinfoDAO;
    public void setNewsinfoDAO(NewsinfoDAO newsinfoDAO) {
		this.newsinfoDAO = newsinfoDAO;
	}
	@Override
	public List getAllNewsinfoByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return newsinfoDAO.getAllNewsinfoByPage(page, pageSize);
		
	}

	@Override
	public Pager getPagerOfAllNewsinfo(int pageSize) {
		// TODO Auto-generated method stub
		int count=newsinfoDAO.getCountOfAllNewsinfo();
		Pager pager=new Pager();
		pager.setRowCount(count);
		pager.setPerPageRows(pageSize);
		return pager;
	}

	@Override
	public List getNewsinfoByConditionAndPage(Newsinfo condition, int page, int pageSize) {
		// TODO Auto-generated method stub
		return newsinfoDAO.getNewsinfoByConditionAndPage(condition, page, pageSize);
		
	}

	@Override
	public Pager getPagerOfNewsinfo(Newsinfo condition, int pageSize) {
		// TODO Auto-generated method stub
		int count=newsinfoDAO.getCountOfNewinfo(condition);
		Pager pager=new Pager();
		pager.setRowCount(count);
		pager.setPerPageRows(pageSize);
		return pager;
	}
	@Override
	public Newsinfo getNewsinfoById(int id) {
		// TODO Auto-generated method stub
		return newsinfoDAO.getNewsinfoById(id);
	}
	@Override
	public void save(Newsinfo newsinfo) {
		// TODO Auto-generated method stub	
	   newsinfoDAO.save(newsinfo);
	}
	@Override
	public void delete(Newsinfo newsinfo) {
		// TODO Auto-generated method stub
		newsinfoDAO.delete(newsinfo);
	}

}
