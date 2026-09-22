package com.krakedev.contacto.entidades.test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestRecuperarNumero {

	public static void main(String[] args) {
		Directorio dir = new Directorio();
		Contacto c1 = new Contacto();
		c1.setNombre("Maria");
		c1.setCelular("0912345678");
		Contacto c2 = new Contacto();
		c2.setNombre("Juan");
		c2.setCelular("4912343673");
		Contacto c3 = new Contacto();
		c3.setNombre("Carlos");
		c3.setCelular("9922342673");
		dir.agregarContacto(c1);
		dir.agregarContacto(c2);
		dir.agregarContacto(c3);
		String numeroRecuperado = dir.recuperarNumero(2);
		System.out.println("Numero de celular: "+numeroRecuperado);
	}

}
