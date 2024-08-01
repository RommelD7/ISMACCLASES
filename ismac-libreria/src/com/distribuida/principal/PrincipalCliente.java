package com.distribuida.principal;




import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.entities.Cliente;

public class PrincipalCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Patron IoC Inversion de Control 
		
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	ClienteDAO ClienteDAO = context.getBean("clienteDAOImpl",ClienteDAO.class);
	
	//CRUD : CREATE, READ, UPDATE, DELETE 
	//
	
	//add
	Cliente Cliente = new Cliente(0,"1753653490","Juan", "Taipe","av. por ahi....","097623456","jtaipe@correo.com");
	//ClienteDAO.add(Cliente);
	
	//up
	Cliente Cliente2 = new Cliente(40,"17536534902","Juan2", "Taipe2","av. por ahi....2","0976234562","jtaipe2@correo.com");
	//ClienteDAO.up(Cliente2);
	
	//del
	ClienteDAO.del(40);
	System.out.println("**********************DEL***********************"+ClienteDAO.findOne(1));
	//finAll
	//List<Cliente> Clientes = ClienteDAO.findAll();
	
	
	ClienteDAO.findAll().forEach(item -> {System.out.println(item.toString());});
	
	context.close();
			

	}

}
	