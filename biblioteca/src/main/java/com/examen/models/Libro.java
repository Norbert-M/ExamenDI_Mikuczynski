package com.examen.models;

import java.util.Date;

public class Libro {
    /*Enumerado Temática: Novela, Ensayo, Científico, Revista, Infantil */
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

    public Libro(int idLibro, String titulo, String isbn, String autor, Tematica tematica, Date fechaEdicion) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.tematica = tematica;
        this.fechaEdicion = fechaEdicion;
    }

    

    public Libro(int idLibro, String titulo, String isbn) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
    }



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

    @Override
    public String toString() {
        return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", isbn=" + isbn + ", autor=" + autor
                + ", tematica=" + tematica + ", fechaEdicion=" + fechaEdicion + "]";
    }

    


    
}
