package com.distribuida.principal;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.distribuida.dao.CategoriaDAO;
import com.distribuida.dao.LibroDAO;
import com.distribuida.entities.Libro;
import com.distribuida.dao.AutorDAO;


public class PrincipalLibro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		LibroDAO libroDAO = context.getBean("libroDAOImpl",LibroDAO.class);
		CategoriaDAO categoriaDAO = context.getBean("categoriaDAOImpl",CategoriaDAO.class);
		AutorDAO autorDAO = context.getBean("autorDAOImpl",AutorDAO.class);
		
		
		//CRUD : CREATE, READ, UPDATE, DELETE 
		//
		
		//add
		Libro libro = new Libro(0,"Piensa","manning",346,"tercera","Español",new Date(2003-02-25),"Motivación","Dura","987-76274849",40,"gris","virtual",20.56);
		libro.setCategoria(categoriaDAO.findOne(5));
		libro.setAutor(autorDAO.findOne(11));
		libroDAO.add(libro);
		
		//up
		Libro libro2 = new Libro(40,"Piensa2","manning2",3462,"tercera2","Español2",new Date(2003-02-252),"Motivación2","Dura2","987-762748492",402,"gris2","virtual2",20.562);
		//libro2.setCategoria(categoriaDAO.findOne(6));
		//bro2.setAutor(autorDAO.findOne(10));
		//libroDAO.up(libro2);
		
		//del
		//libroDAO.del(207);
		
		//findOne
		System.out.println("**********************DEL***********************"+libroDAO.findOne(91));
		//finAll
		//List<Libro> Libro = LibroDAO.findAll();
		
		
		libroDAO.findAll().forEach(item -> {System.out.println(item.toString());});
		
		context.close();
				

	}

}
