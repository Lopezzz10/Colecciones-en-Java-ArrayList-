package com.krakedev.contacto.entidades;

import java.util.ArrayList;

public class Directorio {
	
	ArrayList<Contacto> contactos;

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}
	
	public void agregarContacto(Contacto contacto) {
		contactos.add(contacto);
	}
}
