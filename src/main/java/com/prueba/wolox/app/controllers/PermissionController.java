package com.prueba.wolox.app.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.wolox.app.models.domain.User;
import com.prueba.wolox.app.models.entity.Permission;
import com.prueba.wolox.app.services.PermissionService;

@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@GetMapping()
	public ResponseEntity<?> getPermissionAll() {

		return ResponseEntity.ok(permissionService.findAll());

	}

	@PostMapping()
	public ResponseEntity<?> save(@RequestBody Permission permission) {
		try {

			return ResponseEntity.status(HttpStatus.CREATED).body(permissionService.save(permission));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} // TODO: handle exception

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updatePermission(@RequestBody Permission permission, @PathVariable Long id) {
		Optional<Permission> o = permissionService.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Permission permissionDb = o.get();
		permissionDb.setAlbumId(permission.getAlbumId());
		permissionDb.setUserId(permission.getUserId());
		permissionDb.setEscritura(permission.isEscritura());
		permissionDb.setLectura(permission.isLectura());

		return ResponseEntity.status(HttpStatus.CREATED).body(permissionService.save(permissionDb));

	}

	@SuppressWarnings("unlikely-arg-type")
	@GetMapping("album/{id}")
	public ResponseEntity<?> getUserPermissionAlbum(@PathVariable int id) {

		List<Permission> listPermission = permissionService.findByAlbumId(id);
		List<User> listaUser = new ArrayList<User>();
		if (listPermission.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		for (Permission permission : listPermission) {

			System.out.println(permissionService.user(permission.getUserId()).getId());

			listaUser.add(permissionService.user(permission.getUserId()));
		}

		List<User> listNueva = new ArrayList<User>();

		for (int i = 0; i < listaUser.size(); i++) {

			if (!listNueva.isEmpty()) {
				for (int j = 0; j < listNueva.size(); j++) {

					if (listNueva.get(j).getId() != listaUser.get(i).getId()) {
						listNueva.add(listaUser.get(i));
					}
				}
			} else {
				listNueva.add(listaUser.get(i));
			}

		}

		return ResponseEntity.ok().body(listNueva);

	}

}
