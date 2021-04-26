package com.prueba.wolox.app.services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prueba.wolox.app.models.domain.Post;


@Service
public class PostServiceImpl implements PostService {

	public Iterable<Post> findAll() {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Post>> response = restTemplate.exchange("https://jsonplaceholder.typicode.com" + "/posts",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {
				});

		return response.getBody();

	}
}
