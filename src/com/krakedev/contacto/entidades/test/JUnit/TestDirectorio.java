package com.krakedev.contacto.entidades.test.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
    @Test
    void buscarContacto_existente_debeRetornarElContacto() {
        // Se crea un Directorio propio para este test
        Directorio directorio = new Directorio();
 
        // Se crea un Contacto usando el constructor vacío y setters
        Contacto contacto = new Contacto();
        contacto.setNombre("Juan");
        contacto.setApellido("Perez");
        contacto.setEdad(25);
        contacto.setCelular("0991234567");
        contacto.setPeso(70.5);
 
        directorio.agregarContacto(contacto);
 
        // Se busca por el número de celular que sí existe en el directorio
        Contacto encontrado = directorio.buscarContacto("0991234567");
 
        // Resultado esperado: se retorna el mismo contacto agregado
        assertEquals(contacto, encontrado);
        assertEquals("Juan", encontrado.getNombre());
    }
 
    @Test
    void buscarContacto_noExistente_debeRetornarNull() {
        // Directorio propio para este test
        Directorio directorio = new Directorio();
 
        Contacto contacto = new Contacto();
        contacto.setNombre("Maria");
        contacto.setApellido("Lopez");
        contacto.setEdad(30);
        contacto.setCelular("0987654321");
        contacto.setPeso(60.0);
 
        directorio.agregarContacto(contacto);
 
        // Se busca un número que NO está registrado en el directorio
        Contacto resultado = directorio.buscarContacto("0000000000");
 
        // Resultado esperado: null, ya que el número no existe
        assertNull(resultado);
    }
 
    // ---------------------------------------------------------
    // Pruebas para eliminarContacto(String numero)
    // ---------------------------------------------------------
 
    @Test
    void eliminarContacto_existente_debeEliminarYRetornarTrue() {
        // Directorio propio para este test
        Directorio directorio = new Directorio();
 
        Contacto contacto = new Contacto();
        contacto.setNombre("Carlos");
        contacto.setApellido("Ramirez");
        contacto.setEdad(40);
        contacto.setCelular("0991112222");
        contacto.setPeso(80.0);
 
        directorio.agregarContacto(contacto);
 
        // Se elimina el contacto usando su número de celular
        boolean eliminado = directorio.eliminarContacto("0991112222");
 
        // Resultado esperado: true (se eliminó correctamente)
        assertTrue(eliminado);
 
        // Verificación adicional: el contacto ya no debe encontrarse en el directorio
        assertNull(directorio.buscarContacto("0991112222"));
        assertEquals(0, directorio.obtenerCantidadContactos());
    }
 
    @Test
    void eliminarContacto_noExistente_debeRetornarFalse() {
        // Directorio propio para este test
        Directorio directorio = new Directorio();
 
        Contacto contacto = new Contacto();
        contacto.setNombre("Ana");
        contacto.setApellido("Torres");
        contacto.setEdad(22);
        contacto.setCelular("0993334444");
        contacto.setPeso(55.0);
 
        directorio.agregarContacto(contacto);
 
        // Se intenta eliminar un número que NO existe en el directorio
        boolean eliminado = directorio.eliminarContacto("0000000000");
 
        // Resultado esperado: false, ya que el contacto no fue encontrado
        assertFalse(eliminado);
 
        // Verificación adicional: el contacto original sigue en el directorio
        assertEquals(1, directorio.obtenerCantidadContactos());
    }
 
    // ---------------------------------------------------------
    // Pruebas para buscarContactosCoincidencia(String subcadena)
    // ---------------------------------------------------------
 
    @Test
    void buscarContactosCoincidencia_conCoincidencias_debeRetornarContactosQueEmpiezanConLaSubcadena() {
        // Directorio propio para este test
        Directorio directorio = new Directorio();
 
        Contacto c1 = new Contacto();
        c1.setNombre("Andres");
        c1.setApellido("Salazar");
        c1.setEdad(28);
        c1.setCelular("0991111111");
        c1.setPeso(72.0);
 
        Contacto c2 = new Contacto();
        c2.setNombre("Andrea");
        c2.setApellido("Vera");
        c2.setEdad(26);
        c2.setCelular("0992222222");
        c2.setPeso(58.0);
 
        Contacto c3 = new Contacto();
        c3.setNombre("Pedro");
        c3.setApellido("Gomez");
        c3.setEdad(35);
        c3.setCelular("0993333333");
        c3.setPeso(90.0);
 
        directorio.agregarContacto(c1);
        directorio.agregarContacto(c2);
        directorio.agregarContacto(c3);
 
        // Se buscan los contactos cuyo nombre empieza con "And"
        ArrayList<Contacto> resultado = directorio.buscarContactosCoincidencia("And");
 
        // Resultado esperado: 2 contactos (Andres y Andrea), Pedro no coincide
        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(c1));
        assertTrue(resultado.contains(c2));
        assertFalse(resultado.contains(c3));
    }
 
    @Test
    void buscarContactosCoincidencia_sinCoincidencias_debeRetornarListaVacia() {
        // Directorio propio para este test
        Directorio directorio = new Directorio();
 
        Contacto contacto = new Contacto();
        contacto.setNombre("Luis");
        contacto.setApellido("Mendoza");
        contacto.setEdad(33);
        contacto.setCelular("0994444444");
        contacto.setPeso(78.0);
 
        directorio.agregarContacto(contacto);
 
        // Se busca una subcadena que no coincide con ningún nombre registrado
        ArrayList<Contacto> resultado = directorio.buscarContactosCoincidencia("Xyz");
 
        // Resultado esperado: lista vacía (tamaño 0), sin lanzar errores
        assertEquals(0, resultado.size());
        assertTrue(resultado.isEmpty());
    }
 
    @Test
    void buscarContactosCoincidencia_debeRetornarCantidadCorrectaDeResultados() {
        // Directorio propio para este test
        Directorio directorio = new Directorio();
 
        Contacto c1 = new Contacto();
        c1.setNombre("Sofia");
        c1.setApellido("Reyes");
        c1.setEdad(24);
        c1.setCelular("0995555555");
        c1.setPeso(60.0);
 
        Contacto c2 = new Contacto();
        c2.setNombre("Sofia"); // mismo nombre, celular distinto
        c2.setApellido("Castro");
        c2.setEdad(29);
        c2.setCelular("0996666666");
        c2.setPeso(65.0);
 
        Contacto c3 = new Contacto();
        c3.setNombre("Soledad");
        c3.setApellido("Nunez");
        c3.setEdad(31);
        c3.setCelular("0997777777");
        c3.setPeso(70.0);
 
        directorio.agregarContacto(c1);
        directorio.agregarContacto(c2);
        directorio.agregarContacto(c3);
 
        // Se buscan los contactos cuyo nombre empieza con "So"
        ArrayList<Contacto> resultado = directorio.buscarContactosCoincidencia("So");
 
        // Resultado esperado: 3 coincidencias, ya que las 3 empiezan con "So"
        assertEquals(3, resultado.size());
    }
}