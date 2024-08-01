package com.distribuida.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.distribuida.entities.Autor;


public interface AutorDAO {
	//Crud Basico
	@Autowired
		public List<Autor> findAll();
		
		public Autor findOne(int id);
		
		public void add(Autor autor);
		
		public void up(Autor autor);
		
		public void del(int id);
		
		// CRUD avanzados 


}
