package com.prueba.wolox.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prueba.wolox.app.models.domain.Album;
import com.prueba.wolox.app.models.domain.Comment;
import com.prueba.wolox.app.models.domain.Photo;
import com.prueba.wolox.app.models.domain.Post;
import com.prueba.wolox.app.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private AlbumService albumService;
	
	
	
	public Iterable<User> findAll() {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<User>> response = restTemplate.exchange("https://jsonplaceholder.typicode.com" + "/users",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
				});

		return response.getBody();

	}

	public User findByIdUser(int id) {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<User> response = restTemplate.exchange("https://jsonplaceholder.typicode.com" + "/users/" + id,
				HttpMethod.GET, null, User.class);

		return response.getBody();

	}

	public List<Album> findByIdUserOfAlbum(int id) {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Album>> response = restTemplate.exchange(
				"https://jsonplaceholder.typicode.com" + "/users/" + id + "/albums", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Album>>() {
				});

		return response.getBody();

	}

	public List<Photo> findByIdUserOfAlbumPhoto(List<Album> albums) {
		
		List<Photo> userAlbumPhotos = new ArrayList<Photo>();
		
		for (Album album : albums) {
			
			userAlbumPhotos.addAll(albumService.fotosAll(album.getId()));
		}
		
		return userAlbumPhotos;
	}
	
	public List<Post> findByIdUserPost(int userId) {
		
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Post>> response = restTemplate.exchange(
				"https://jsonplaceholder.typicode.com" + "/users/" + userId + "/posts", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Post>>() {
				});

		return response.getBody();

		
	}
	
	
	public List<Comment> findByIdUserComments(List<Post> posts) {

		
		List<Comment> userComments = new ArrayList<Comment>();
		
		for (Post post : posts) {
			
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<List<Comment>> response = restTemplate.exchange(
					"https://jsonplaceholder.typicode.com" + "/posts/" + post.getId() + "/comments", HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Comment>>() {
					});

			userComments.addAll(response.getBody());
		}
		
		return userComments;

	}
	
	

}
