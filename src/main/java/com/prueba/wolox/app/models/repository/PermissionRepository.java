package com.prueba.wolox.app.models.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prueba.wolox.app.models.entity.Permission;

public interface PermissionRepository extends CrudRepository<Permission, Long> {
	
	List<Permission> findByAlbumId(int albumId);
}
