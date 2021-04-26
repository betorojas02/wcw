package com.prueba.wolox.app.services;

import java.util.List;
import java.util.Optional;

import com.prueba.wolox.app.models.domain.Album;
import com.prueba.wolox.app.models.domain.Comment;
import com.prueba.wolox.app.models.domain.Photo;
import com.prueba.wolox.app.models.domain.Post;
import com.prueba.wolox.app.models.domain.User;

public interface UserService {

	
	
	public Iterable<User> findAll();
	public User findByIdUser(int id);
	
	public List<Album> findByIdUserOfAlbum(int id);
	
	public List<Photo> findByIdUserOfAlbumPhoto(List<Album> albums);
	
	
	public List<Post> findByIdUserPost(int userId);
	
	public List<Comment> findByIdUserComments(List<Post> posts);
}
