package com.krakedev.contacto.entidades;

import java.util.ArrayList;

public class Directorio {
	
	ArrayList<Contacto> contactos;
	
	public Directorio() {
		contactos = new ArrayList<Contacto>();
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}
	
	public void agregarContacto(Contacto contacto) {
		contactos.add(contacto);
	}
	public int obtenerCantidadContactos() {
		int cantidad;
		cantidad = contactos.size();
		return cantidad;
	}
	public Contacto obtenerContacto(int posicion) {
		return contactos.get(posicion);
	}
}