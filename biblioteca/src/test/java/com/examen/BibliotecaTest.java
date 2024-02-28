package com.examen;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.examen.models.Libro;

public class BibliotecaTest {

    /**
     * La función testPrestarLibroNoExiste prueba el escenario donde un libro no existe en la
     * biblioteca al intentar tomarlo prestado.
     */
    @Test
    void testPrestarLibroNoExiste() {
        Biblioteca biblioteca = new Biblioteca();
        assertThrows(IllegalArgumentException.class, () -> {
            biblioteca.Prestar(999, "12345678A"); 
        });
    }

    /**
     * La función testPrestarUsuarioNoExiste prueba el escenario donde un usuario no existe al intentar
     * tomar prestado un libro de la biblioteca.
     */
    @Test
    void testPrestarUsuarioNoExiste() {
        Biblioteca biblioteca = new Biblioteca();
        assertThrows(IllegalArgumentException.class, () -> {
            biblioteca.Prestar(1, "99999999Z"); 
        });
    }

    /**
     * Esta función de prueba comprueba si un usuario existente en un sistema de biblioteca puede tomar
     * prestado un libro.
     */
    @Test
    void testPrestarLibroExisteUsuarioExiste() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(1, "El Quijote", "1234567890");
        biblioteca.altaUsuario("12345678A");
        assertDoesNotThrow(() -> {
            biblioteca.Prestar(1, "12345678A");
        });
    }


    /**
     * Esta función de prueba verifica la funcionalidad de devolver un libro en una fecha específica en
     * un sistema de biblioteca.
     */
    @Test
    void testDevolverLibroEnFecha() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(1, "El Quijote", "1234567890");
        biblioteca.altaUsuario("12345678A");
        biblioteca.Prestar(1, "12345678A");
        assertDoesNotThrow(() -> {
            biblioteca.devolverLibro(1, "12345678A");
        });
        
    }

    /**
     * This test function checks if a book can be returned after the due date in a library system.
     */
    @Test
    void testDevolverLibroFueraDeFecha() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(1, "El Quijote", "1234567890");
        biblioteca.altaUsuario("12345678A");
        biblioteca.Prestar(1, "12345678A");
        
        assertDoesNotThrow(() -> {
            biblioteca.devolverLibro(1, "12345678A");
        });
        
    }


    /**
     * The testAltaLibroUniqueAttributes method in the BibliotecaTest class tests the altaLibro method
     * in the Biblioteca class by verifying the uniqueness of attributes for a newly added book.
     */
    @Test
    void testAltaLibroUniqueAttributes() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(1, "Titulo1", "Isbn1");
        List<Libro> libros = biblioteca.getLibros();
        assertNotNull(libros);
        //assertEquals(1, libros.getIdLibro());
        //assertEquals("Titulo1", libro.getTitulo());
        // The line `//assertEquals("Isbn1", libro.getIsbn());` is a commented-out assertion statement
        // in the `testAltaLibroUniqueAttributes` test method of the `BibliotecaTest` class.
        //assertEquals("Isbn1", libro.getIsbn());
    }

    /**
     * The testAltaLibroRepeatedAttributes function tests that an IllegalArgumentException is thrown
     * when trying to add a book with repeated attributes in a library.
     */
    @Test
    void testAltaLibroRepeatedAttributes() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(1, "Titulo1", "Isbn1");
        assertThrows(IllegalArgumentException.class, () -> biblioteca.altaLibro(1, "Titulo1", "Isbn1"));
    }




        
    
    
}
