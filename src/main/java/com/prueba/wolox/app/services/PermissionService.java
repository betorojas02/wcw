package com.prueba.wolox.app.services;

import java.util.List;
import java.util.Optional;

import com.prueba.wolox.app.models.domain.User;
import com.prueba.wolox.app.models.entity.Permission;

public interface PermissionService {

	public Iterable<Permission> findAll();
	
	public Permission save(Permission permission);
	
	public Optional<Permission> findById(Long id);
	
	public List<Permission> findByAlbumId(int albumId);
	
	public User user(int id);
	
	

}
