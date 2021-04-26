package com.prueba.wolox.app.services;


import com.prueba.wolox.app.models.domain.Post;


public interface PostService {

	
	public Iterable<Post> findAll();
}
