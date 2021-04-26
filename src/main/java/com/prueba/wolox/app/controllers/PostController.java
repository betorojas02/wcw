package com.prueba.wolox.app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.wolox.app.services.PostService;


@RestController
@RequestMapping("/posts")
public class PostController {

	

	@Autowired
	private PostService postService;

	@GetMapping
	public ResponseEntity<?> userAll() {

		try {
			return ResponseEntity.ok().body(postService.findAll());
		} catch (Exception e) {

			Map<String, String> error = new HashMap<String, String>();

			error.put("message", "Error en la peticion");
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);
		}

	}

}
