package com.prueba.wolox.app.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="permission")
public class Permission {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	

	private int userId;
	
	private int albumId;
	
	
	private boolean lectura;
	
	private boolean escritura;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public boolean isLectura() {
		return lectura;
	}

	public void setLectura(boolean lectura) {
		this.lectura = lectura;
	}

	public boolean isEscritura() {
		return escritura;
	}

	public void setEscritura(boolean escritura) {
		this.escritura = escritura;
	}
	
	
	

}
