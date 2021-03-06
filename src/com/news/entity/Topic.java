// default package
// Generated May 3, 2017 1:56:18 PM by Hibernate Tools 5.2.1.Final
package com.news.entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Topic generated by hbm2java
 */
public class Topic implements java.io.Serializable {

	private Integer id;
	private String name;
	private Set newsinfos = new HashSet(0);

	public Topic() {
	}

	public Topic(String name, Set newsinfos) {
		this.name = name;
		this.newsinfos = newsinfos;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getNewsinfos() {
		return this.newsinfos;
	}

	public void setNewsinfos(Set newsinfos) {
		this.newsinfos = newsinfos;
	}

}
