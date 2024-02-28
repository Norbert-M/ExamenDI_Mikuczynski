package com.examen;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.examen.models.Libro;

public class BibliotecaTest {

    @Test
    void testPrestarLibroNoExiste() {
        Biblioteca biblioteca = new Biblioteca();
        assertThrows(IllegalArgumentException.class, () -> {
            biblioteca.Prestar(999, "12345678A"); 
        });
    }

    @Test
    void testPrestarUsuarioNoExiste() {
        Biblioteca biblioteca = new Biblioteca();
        assertThrows(IllegalArgumentException.class, () -> {
            biblioteca.Prestar(1, "99999999Z"); 
        });
    }

    @Test
    void testPrestarLibroExisteUsuarioExiste() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(1, "El Quijote", "1234567890");
        biblioteca.altaUsuario("12345678A");
        assertDoesNotThrow(() -> {
            biblioteca.Prestar(1, "12345678A");
        });
    }


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


    @Test
    void testAltaLibroUniqueAttributes() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(1, "Titulo1", "Isbn1");
        List<Libro> libros = biblioteca.getLibros();
        assertNotNull(libros);
        assertEquals(1, libros.getIdLibro());
        assertEquals("Titulo1", libro.getTitulo());
        assertEquals("Isbn1", libro.getIsbn());
    }

    @Test
    void testAltaLibroRepeatedAttributes() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(1, "Titulo1", "Isbn1");
        assertThrows(IllegalArgumentException.class, () -> biblioteca.altaLibro(1, "Titulo1", "Isbn1"));
    }




        
    
    
}
