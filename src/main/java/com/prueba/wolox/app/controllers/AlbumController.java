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
import com.prueba.wolox.app.models.domain.User;
import com.prueba.wolox.app.services.AlbumService;
import com.prueba.wolox.app.services.UserService;

@RequestMapping("/albums")
@RestController
public class AlbumController {

	@Autowired
	private AlbumService albumService;
//	@Autowired
//	private UserService userService;

//	private AlbumService albumService;
//	private UserService userService;
//
//	public AlbumController(AlbumService albumService, UserService userService) {
//
//		this.albumService = albumService;
//		this.userService = userService;
//	}

	@GetMapping
	public ResponseEntity<?> albumAll() {

		try {
			return ResponseEntity.ok().body(albumService.findAll());
		} catch (Exception e) {

			Map<String, String> error = new HashMap<String, String>();

			error.put("message", "Error en la peticion");
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);
		}

	}



}
