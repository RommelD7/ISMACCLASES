package com.distribuida.principal;




import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;

public class PrincipalAutor2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Patron IoC Inversion de Control 
		
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	AutorDAO autorDAO = context.getBean("autorDAOImpl2",AutorDAO.class);
	
	//CRUD : CREATE, READ, UPDATE, DELETE 
	//
	
	//add
	Autor autor = new Autor(0,"Juan", "Taipe","Ecuador","av. por ahi....","097623456","jtaipe@correo.com");
	autorDAO.add(autor);
	
	//up
	Autor autor2 = new Autor(54,"Juan2", "Taipe2","Colombia","av. por ahi....2","0976234562","jtaipe2@correo.com");
	//autorDAO.up(autor2);
	
	//del
	//autorDAO.del(55);
	//System.out.println("**********************DEL***********************"+autorDAO.findOne(1));
	try{ System.out.println("**********************DEL***********************"+autorDAO.findOne(1));} catch(Exception e) {e.printStackTrace();};
	//finAll
	//List<Autor> autors = AutorDAO.findAll();
	
	autorDAO.findAll().forEach(item -> {System.out.println(item.toString());});
	
	context.close();
			

	}

}
