package com.prueba.wolox.app.services;



import java.util.List;

import com.prueba.wolox.app.models.domain.Album;
import com.prueba.wolox.app.models.domain.Photo;


public interface AlbumService {

	
	public Iterable<Album> findAll();
	
	public List<Photo> fotosAll(int id);
	
}
