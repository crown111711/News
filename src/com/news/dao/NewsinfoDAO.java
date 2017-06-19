package com.news.dao;

import java.util.List;

import com.news.entity.Newsinfo;

public interface NewsinfoDAO {
    public List getAllNewsinfoByPage(int page,int pageSize);
    public Integer getCountOfAllNewsinfo();
    public List getNewsinfoByConditionAndPage(Newsinfo condition,int page,int pageSize);
    public Integer getCountOfNewinfo(Newsinfo condition);
    public Newsinfo getNewsinfoById(int id);
    public void save(Newsinfo newsinfo);
    public void delete(Newsinfo newsinfo);
}
