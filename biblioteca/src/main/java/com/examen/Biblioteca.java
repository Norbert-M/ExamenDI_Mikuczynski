package com.examen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.examen.models.Libro;
import com.examen.models.Prestamo;
import com.examen.models.Usuario;

public class Biblioteca {

    /*Atributos: List Libros[], List Prestamos[], List Usuarios[] */
    private List<Libro> libros;

    private List<Prestamo> prestamos; 

    private List<Usuario> usuarios;


    



    /*GETTERS Y SETTERS */

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public Biblioteca(List<Libro> libros, List<Prestamo> prestamos, List<Usuario> usuarios) {
        this.libros = libros;
        this.prestamos = prestamos;
        this.usuarios = usuarios;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }



    void anyadirPrestamo(Prestamo prestamo){
        prestamos.add(prestamo);
    }

    void altaUsuario(String dniUsuario){
        Usuario usuario = new Usuario(dniUsuario);
        usuarios.add(usuario);
    }

    /*MÉTODOS ALTA Y BAJA LIBRO */

    void altaLibro(int idLibro, String titulo, String isbn){
        Libro libro = new Libro(idLibro, titulo, isbn);

        //recorrer la lista de libros en un for each
        for (Libro libro2 : libros) {
            if(libro2.getIdLibro() == idLibro || libro2.getIsbn().equals(isbn)){
                throw new IllegalArgumentException("El libro ya existe");
            }
        }
        libros.add(libro);
    }

    

    void bajaLibro(int idLibro){
        for (Libro libro : libros) {
            if(libro.getIdLibro() == idLibro){
                libros.remove(libro);
                break;
            }
        }
    }



    /*MÉTODOS PRESTAR Y DEVOLVER LIBRO */

    void Prestar(int Id_libro,String Dni_Usuario){
        Libro libroEncontrado = null;
        for (Libro libro : libros) {
            if(libro.getIdLibro() == Id_libro){
                libroEncontrado = libro;
                return;
            }
        }
    
        if (libroEncontrado == null) {
            throw new IllegalArgumentException("Libro no encontrado");
        }
    
        Usuario usuarioEncontrado = null;
        for (Usuario usuario : usuarios) {
            if(usuario.getDniUsuario().equals(Dni_Usuario)){
                usuarioEncontrado = usuario;
                return;
            }
        }
    
        if (usuarioEncontrado == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
    
        Prestamo prestamo = new Prestamo(Id_libro, Dni_Usuario, new java.util.Date());
        prestamos.add(prestamo);
    }

    void devolverLibro(int idLibro, String dniUsuario){
        for (Prestamo prestamo : prestamos) {
            if(prestamo.getIdLibro() == idLibro && prestamo.getDniUsuario().equals(dniUsuario)){
                if(prestamo.getFechaDevolucion().before(new java.util.Date())){
                    for (Usuario usuario : usuarios) {
                        if(usuario.getDniUsuario().equals(dniUsuario)){
                            usuario.sancionar();
                        }
                    }
                }
                else{
                    for (Usuario usuario : usuarios) {
                        if(usuario.getDniUsuario().equals(dniUsuario)){
                            usuario.quitarSancion();
                        }
                    }
                }
                prestamos.remove(prestamo);
                break;
            }
        }
    }





    
}
