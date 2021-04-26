package com.prueba.wolox.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.wolox.app.models.domain.User;
import com.prueba.wolox.app.models.entity.Permission;
import com.prueba.wolox.app.models.repository.PermissionRepository;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;

	
	@Autowired
	private UserService userService;
	public Iterable<Permission> findAll() {

		return permissionRepository.findAll();

	}

	public Permission save(Permission permission) {
	

		return permissionRepository.save(permission);

	}
	
	public Optional<Permission> findById(Long id) {
	
		return permissionRepository.findById(id);
	}
	
	public List<Permission> findByAlbumId(int albumId) {
		
		return permissionRepository.findByAlbumId(albumId);
	}
	
	public User user(int id) {
		
		return userService.findByIdUser(id);
	}

}
