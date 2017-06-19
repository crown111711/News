package com.news.biz.impl;

import java.util.List;

import com.news.biz.TopicBiz;
import com.news.dao.TopicDAO;

public class TopicBizImpl  implements TopicBiz{
    TopicDAO topicDAO;
    public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}
	@Override
	public List getAllTopic() {
		// TODO Auto-generated method stub
		return topicDAO.getAllTopic();
	}

}
