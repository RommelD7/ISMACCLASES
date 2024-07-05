package com.distribuida.principal;



import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.dao.FacturaDAO;
import com.distribuida.entities.Factura;

public class PrincipalFactura {

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		FacturaDAO FacturaDAO = context.getBean("facturaDAOImpl",FacturaDAO.class);
		ClienteDAO clienteDAO = context.getBean("clienteDAOImpl", ClienteDAO.class);
		//CRUD : CREATE, READ, UPDATE, DELETE 
		//
		
		//add
		Factura factura = new Factura(0,"FAC-0090",new Date (),60.63,15.36,76.35);
		factura.setCliente(clienteDAO.findOne(1));
		FacturaDAO.add(factura);
		
		//up
		Factura factura2 = new Factura(91,"FAC-0090",new Date(),60.632,15.362,76.352);
		factura2.setCliente(clienteDAO.findOne(1));
		//FacturaDAO.up(factura2);
		
		//del
		//FacturaDAO.del(91);
		
		
		System.out.println("**********************DEL***********************"+FacturaDAO.findOne(91));
		//finAll
		//List<Factura> Facturas = FacturaDAO.findAll();
		
		
		FacturaDAO.findAll().forEach(item -> {       System.out.println(item.toString());});
		
		context.close();
				

	}

}
