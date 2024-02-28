package com.examen.models;

import java.util.Date;

/**
 * La clase "Libro" probablemente representa un libro en un programa Java.
 */
public class Libro {
    /*Enumerado Temática: Novela, Ensayo, Científico, Revista, Infantil */
    // La `public enum Tematica` en la clase `Libro` define un tipo de enumeración llamado `Tematica`.
    // Esta enumeración representa diferentes categorías o temáticas que puede tener un libro. En este
    // caso, la enumeración `Temática` tiene cinco valores posibles: `NOVELA`, `ENSAYO`, `CIENTIFICO`,
    // `REVISTA` e `INFANTIL`, que corresponden a diferentes tipos de libros como Novela, Ensayo,
    // Científico, Revista y libro infantil.
    public enum Tematica {
        NOVELA, ENSAYO, CIENTIFICO, REVISTA, INFANTIL
    }

    /*Atributos: Id_Libro (Obligatorio/Único), Titulo (O), Isbn (Obligatorio/Único), Autor,
Temática, Fecha edición. */
    int idLibro;
    String titulo;
    String isbn;
    String autor;
    Tematica tematica;
    Date fechaEdicion;

    // El constructor `public Libro(int idLibro, String titulo, String isbn, String autor, Tematica
    // tematica, Date fechaEdicion)` en la clase `Libro` está inicializando una nueva instancia del
    // objeto `Libro` con los parámetros proporcionados.
    public Libro(int idLibro, String titulo, String isbn, String autor, Tematica tematica, Date fechaEdicion) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.tematica = tematica;
        this.fechaEdicion = fechaEdicion;
    }

    

    // El constructor `public Libro(int idLibro, String titulo, String isbn)` es un constructor
    // parametrizado en la clase `Libro` que inicializa una nueva instancia del objeto `Libro` con los
    // `idLibro`, `titulo` y ` proporcionados. valores isbn`. Este constructor le permite crear un
    // objeto `Libro` con solo estos tres atributos especificados, y los otros atributos como `autor`,
    // `tematica` y `fechaEdicion` se establecerán en valores predeterminados o permanecerán sin
    // inicializar hasta que se establezcan explícitamente.
    public Libro(int idLibro, String titulo, String isbn) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
    }



    // Estos son métodos getter y setter en Java.
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    public Date getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    /**
     * El método toString en Java anula la implementación predeterminada para devolver una
     * representación de cadena formateada de un objeto Libro.
     * 
     * @return El método `toString` está siendo anulado para devolver una representación de cadena de
     * un objeto `Libro`, incluidos sus atributos `idLibro`, `titulo`, `isbn`, `autor`, `tematica` y
     * `fechaEdicion`.
     */
    @Override
    public String toString() {
        return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", isbn=" + isbn + ", autor=" + autor
                + ", tematica=" + tematica + ", fechaEdicion=" + fechaEdicion + "]";
    }

    


    
}
