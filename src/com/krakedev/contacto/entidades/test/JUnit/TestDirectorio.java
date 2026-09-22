package com.krakedev.contacto.entidades.test.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

import org.junit.jupiter.api.DisplayName;

public class TestDirectorio {

    private Directorio directorio;

    @BeforeEach
    void setUp() {
        // Se crea un Directorio limpio antes de cada test
        directorio = new Directorio();
    }

    @Test
    @DisplayName("Agregar un contacto nuevo debe retornar true y aumentar el tamaño de la lista")
    void testAgregarContactoNuevo_debeRetornarTrue() {
        // Qué se prueba: agregar un contacto cuyo número NO existe en el directorio
        // Resultado esperado: el método retorna true y el contacto queda registrado

        Contacto contacto = new Contacto();
        contacto.setNombre("Juan Perez");
        contacto.setCelular("0991234567");

        boolean resultado = directorio.agregarContacto(contacto);

        assertTrue(resultado, "Debe retornar true al agregar un contacto con número nuevo");
        assertEquals(1, directorio.obtenerCantidadContactos(), "El directorio debe contener 1 contacto tras agregarlo");
    }

    @Test
    @DisplayName("Agregar un contacto con número duplicado debe retornar false y no agregarlo")
    void testAgregarContactoDuplicado_debeRetornarFalse() {
        // Qué se prueba: agregar dos contactos con el mismo número de celular
        // Resultado esperado: el primero se agrega (true), el segundo es rechazado (false)

        Contacto contacto1 = new Contacto();
        contacto1.setNombre("Juan Perez");
        contacto1.setCelular("0991234567");

        Contacto contacto2 = new Contacto();
        contacto2.setNombre("Pedro Gomez"); // nombre distinto, mismo número
        contacto2.setCelular("0991234567");

        boolean resultado1 = directorio.agregarContacto(contacto1);
        boolean resultado2 = directorio.agregarContacto(contacto2);

        assertTrue(resultado1, "El primer contacto con número nuevo debe agregarse correctamente");
        assertFalse(resultado2, "El segundo contacto con número duplicado no debe agregarse");
    }

    @Test
    @DisplayName("El tamaño de la lista no debe aumentar al intentar agregar un duplicado")
    void testTamanoLista_noDebeAumentarConDuplicado() {
        // Qué se prueba: que el tamaño del directorio permanezca en 1
        // después de intentar agregar un contacto con número repetido
        // Resultado esperado: obtenerCantidadContactos() sigue retornando 1

        Contacto contacto1 = new Contacto();
        contacto1.setNombre("Maria Lopez");
        contacto1.setCelular("0987654321");

        Contacto contacto2 = new Contacto();
        contacto2.setNombre("Maria L.");
        contacto2.setCelular("0987654321"); // mismo número que contacto1

        directorio.agregarContacto(contacto1);
        directorio.agregarContacto(contacto2);

        assertEquals(1, directorio.obtenerCantidadContactos(),
                "El tamaño de la lista no debe aumentar al intentar agregar un número duplicado");
    }

    @Test
    @DisplayName("Agregar varios contactos con números distintos debe aumentar el tamaño correctamente")
    void testAgregarVariosContactosDistintos_debeAumentarTamano() {
        // Qué se prueba: agregar múltiples contactos con números diferentes
        // Resultado esperado: el tamaño del directorio refleja la cantidad total agregada

        Contacto contacto1 = new Contacto();
        contacto1.setNombre("Ana Torres");
        contacto1.setCelular("0911111111");

        Contacto contacto2 = new Contacto();
        contacto2.setNombre("Luis Ramirez");
        contacto2.setCelular("0922222222");

        directorio.agregarContacto(contacto1);
        directorio.agregarContacto(contacto2);

        assertEquals(2, directorio.obtenerCantidadContactos(),
                "El directorio debe contener 2 contactos al agregar 2 números distintos");
    }
}