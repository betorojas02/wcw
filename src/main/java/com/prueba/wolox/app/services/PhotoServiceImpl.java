package com.prueba.wolox.app.services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prueba.wolox.app.models.domain.Photo;


@Service
public class PhotoServiceImpl implements PhotoService {

	public Iterable<Photo> findAll() {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Photo>> response = restTemplate.exchange("https://jsonplaceholder.typicode.com" + "/photos",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Photo>>() {
				});

		return response.getBody();

	}
}
