package com.prueba.wolox.app.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.wolox.app.models.domain.Album;
import com.prueba.wolox.app.models.domain.Post;
import com.prueba.wolox.app.models.domain.User;
import com.prueba.wolox.app.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<?> userAll() {

		try {
			return ResponseEntity.ok().body(userService.findAll());
		} catch (Exception e) {

			Map<String, String> error = new HashMap<String, String>();

			error.put("message", "Error en la peticion");
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);
		}

	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> user(@PathVariable int userId) {

		try {

			return ResponseEntity.ok().body(userService.findByIdUser(userId));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("/{userId}/albums")
	public ResponseEntity<?> userOfAlbum(@PathVariable int userId) {

		try {
			User user = userService.findByIdUser(userId);
			List<Album> albums = new ArrayList<Album>();

			if (user.getClass() != null) {

				albums = userService.findByIdUserOfAlbum(userId);

			}

			return ResponseEntity.ok(albums);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("/{userId}/albums-photo")
	public ResponseEntity<?> userOfAlbumPhoto(@PathVariable int userId) {

		ResponseEntity<?> userAlbums = this.userOfAlbum(userId);

		if (userAlbums.getBody() != null) {

			List<Album> albums = (List<Album>) userAlbums.getBody();
			return ResponseEntity.ok(userService.findByIdUserOfAlbumPhoto(albums));

		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping("/{userId}/posts")
	public ResponseEntity<?> userPost(@PathVariable int userId) {

		try {
			User user = userService.findByIdUser(userId);
			List<Post> post = new ArrayList<Post>();

			if (user.getClass() != null) {

				post = userService.findByIdUserPost(userId);

			}

			return ResponseEntity.ok(post);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	@GetMapping("/{userId}/comments")
	public ResponseEntity<?> userComments(@PathVariable int userId) {

		ResponseEntity<?> userPosts = this.userPost(userId);

		if (userPosts.getBody() != null) {

			List<Post> posts = (List<Post>) userPosts.getBody();
			return ResponseEntity.ok(userService.findByIdUserComments(posts));

		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
