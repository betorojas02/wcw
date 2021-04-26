package com.prueba.wolox.app.services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prueba.wolox.app.models.domain.Comment;
import com.prueba.wolox.app.models.domain.User;

@Service
public class CommentServiceImpl implements CommentService {

	public Iterable<Comment> findAll() {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Comment>> response = restTemplate.exchange(
				"https://jsonplaceholder.typicode.com" + "/comments", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Comment>>() {
				});

		return response.getBody();

	}

	public Iterable<Comment> commentFilterName(String name) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Comment>> response = restTemplate.exchange(
				"https://jsonplaceholder.typicode.com" + "/comments?name=" + name, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Comment>>() {
				});

		return response.getBody();
	}
}
