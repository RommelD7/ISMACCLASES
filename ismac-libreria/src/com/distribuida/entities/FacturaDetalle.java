package com.distribuida.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="factura_detalle")
public class FacturaDetalle {
    // Atributos 
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_factura_detalle")
	private int idFacturaDetalle;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="subtotal")
	private double subTotal;
	
	//Implementación de los foreyn key 
	@JoinColumn(name="id_factura")
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Factura factura;
	
	@JoinColumn(name="id_libro")
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Libro libro;
	//private int idFactura;
	//private int idLibro;
	
	public FacturaDetalle() {}
	//Contructor
	public FacturaDetalle(int idFacturaDetalle, int cantidad, double subTotal) {
	
		this.idFacturaDetalle = idFacturaDetalle;
		this.cantidad = cantidad;
		this.subTotal = subTotal;
		//this.idFactura = idFactura;
		//this.idLibro = idLibro;
	}

	public int getIdFacturaDetalle() {
		return idFacturaDetalle;
	}

	public void setIdFacturaDetalle(int idFacturaDetalle) {
		this.idFacturaDetalle = idFacturaDetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}


	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	//CONTRUCTOR

	@Override
	public String toString() {
		return "FacturaDetalle [idFacturaDetalle=" + idFacturaDetalle + ", cantidad=" + cantidad + ", subTotal="
				+ subTotal + ", factura=" + factura + ", libro=" + libro + "]";
	}

	
	

}