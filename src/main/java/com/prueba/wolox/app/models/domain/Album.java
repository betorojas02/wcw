package com.prueba.wolox.app.models.domain;

import java.io.Serializable;

public class Album implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 406153262143451724L;

	
	private int userId;
	private int id;
	
	private String title;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	
	

}
