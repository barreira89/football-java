package com.stevebarreira.football.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

@QueryEntity
@Document
public class Leagues {
    

	@Id
    public String id;
    public List<String> userIds;
    public String name;
    public List<String> users;

    
    public Leagues(){};
    
    public Leagues(String id, List<String> userIds, String name, List<String> users) {
    	this.id = id;
    	this.userIds = userIds;
    	this.name = name;
    	this.users = users;
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

}
