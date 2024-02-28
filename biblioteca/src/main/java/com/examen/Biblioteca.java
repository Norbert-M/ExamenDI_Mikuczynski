package com.examen;

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

    /*MÉTODOS ALTA Y BAJA LIBRO */

    void altaLibro(int idLibro, String titulo, String isbn){
        Libro libro = new Libro(idLibro, titulo, isbn);
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

        for (Libro libro : libros) {
            if(libro.getIdLibro() == Id_libro){
                for (Usuario usuario : usuarios) {
                    if(usuario.getDniUsuario().equals(Dni_Usuario)){
                        Prestamo prestamo = new Prestamo(Id_libro, Dni_Usuario, new java.util.Date());
                        prestamos.add(prestamo);
                    }
                }
            }
        }
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
