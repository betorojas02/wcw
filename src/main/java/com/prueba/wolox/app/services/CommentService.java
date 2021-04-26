package com.prueba.wolox.app.services;


import com.prueba.wolox.app.models.domain.Comment;


public interface CommentService {

	
	public Iterable<Comment> findAll();
	
	public Iterable<Comment> commentFilterName(String name);
}
