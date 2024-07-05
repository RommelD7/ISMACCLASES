package com.distribuida.principal;




import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.FacturaDAO;
import com.distribuida.dao.FacturaDetalleDAO;
import com.distribuida.dao.LibroDAO;
import com.distribuida.entities.FacturaDetalle;

public class PrincipalFacturaDetalle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		FacturaDetalleDAO facturaDetalleDAO = context.getBean("facturaDetalleDAOImpl",FacturaDetalleDAO.class);
		FacturaDAO facturaDAO = context.getBean("facturaDAOImpl",FacturaDAO.class);
		LibroDAO libroDAO = context.getBean("libroDAOImpl",LibroDAO.class);
		
		//CRUD : CREATE, READ, UPDATE, DELETE 
		//
		
		//add
		FacturaDetalle facturadetalle = new FacturaDetalle(0,10,60.63);
		facturadetalle.setFactura(facturaDAO.findOne(1));
		facturadetalle.setLibro(libroDAO.findOne(2));
		facturaDetalleDAO.add(facturadetalle);
		
		//up
		FacturaDetalle facturadetalle2 = new FacturaDetalle(86,102,60.632);
		//facturadetalle2.setFactura(facturaDAO.findOne(2));
		//facturadetalle2.setLibro(libroDAO.findOne(8));
		//facturaDetalleDAO.up(facturadetalle2);
		
		//del
		//facturaDetalleDAO.del(207);
		
		//findOne
		System.out.println("**********************DEL***********************"+facturaDetalleDAO.findOne(91));
		//finAll
		//List<FacturaDetalle> FacturaDetalles = FacturaDetalleDAO.findAll();
		
		
		facturaDetalleDAO.findAll().forEach(item -> {System.out.println(item.toString());});
		
		context.close();
				

	}

}
