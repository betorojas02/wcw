package com.prueba.wolox.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prueba.wolox.app.models.domain.Album;
import com.prueba.wolox.app.models.domain.Photo;

@Service
public class AlbumServiceImpl implements AlbumService {

	public Iterable<Album> findAll() {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Album>> response = restTemplate.exchange("https://jsonplaceholder.typicode.com" + "/albums",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>() {
				});

		return response.getBody();
	}
	
	
	
	public List<Photo> fotosAll(int id) {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Photo>> response = restTemplate.exchange("https://jsonplaceholder.typicode.com" + "/albums/" + id + "/photos", 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Photo>>() {
				});

		return response.getBody();
	}


	
}
