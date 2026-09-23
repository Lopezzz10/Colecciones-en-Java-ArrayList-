package com.krakedev.contacto.entidades.test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestSinBreak {

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
		Contacto c4 = new Contacto();
		c4.setNombre("Pablo");
		c4.setCelular("1111111111");
		dir.agregarContacto(c1);
		dir.agregarContacto(c2);
		dir.agregarContacto(c3);
		dir.agregarContacto(c4);
		Contacto contactoEncontrado = dir.buscarContacto("4912343673");
		System.out.println("Nombre:  "+contactoEncontrado.getNombre());
	}

}
