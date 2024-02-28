/**
 * La clase `Biblioteca` representa un sistema bibliotecario con funcionalidades de gestión de libros,
 * préstamos y usuarios.
 */
package com.examen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.examen.models.Libro;
import com.examen.models.Prestamo;
import com.examen.models.Usuario;

/**
 * La clase Biblioteca contiene atributos para listas de libros, préstamos y usuarios.
 */
public class Biblioteca {

    /*Atributos: List Libros[], List Prestamos[], List Usuarios[] */
    private List<Libro> libros;

    private List<Prestamo> prestamos; 

    private List<Usuario> usuarios;


    



    /*GETTERS Y SETTERS */

   // Estos son los constructores de la clase `Biblioteca` en Java.
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

    /**
     * La función `altaLibro` agrega un nuevo libro a una lista de libros después de verificar si el
     * libro ya existe según su ID o ISBN.
     * 
     * @param idLibro El parámetro `idLibro` es un número entero que representa el identificador único
     * del libro que se agrega a la biblioteca.
     * @param titulo El parámetro "titulo" en el método "altaLibro" representa el título del libro que
     * se está agregando a la lista de libros. Es una variable de tipo String que almacena el título
     * del libro.
     * @param isbn El ISBN (Número Internacional Estándar de Libros) es un identificador único de
     * libros. Es un número de 10 o 13 dígitos que ayuda a identificar una edición específica de un
     * libro.
     */
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

    

    /**
     * La función `bajaLibro` elimina un libro de una lista de libros por su ID.
     * 
     * @param idLibro El parámetro `idLibro` es un número entero que representa el identificador único
     * de un libro que debe eliminarse de una colección de libros. El método `bajaLibro` recorre en
     * iteración la lista de libros y elimina el libro con el `idLibro` coincidente.
     */
    void bajaLibro(int idLibro){
        for (Libro libro : libros) {
            if(libro.getIdLibro() == idLibro){
                libros.remove(libro);
                break;
            }
        }
    }



    /*MÉTODOS PRESTAR Y DEVOLVER LIBRO */

   /**
    * La función `Prestar` comprueba si un libro y un usuario existen en sus respectivas listas y, de
    * ser así, crea un nuevo registro de préstamo.
    * 
    * @param Id_libro El parámetro `Id_libro` representa el ID del libro que se está prestando. Se
    * utiliza para identificar el libro específico que el usuario desea tomar prestado de la
    * biblioteca.
    * @param Dni_Usuario El parámetro `User_ID` en el método `Borrow` es una Cadena que representa el
    * ID (Documento Nacional de Identidad) del usuario que quiere pedir prestado un libro.
    */
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

    /**
     * La función `devolverLibro` en Java verifica si un usuario con una ID determinada está
     * devolviendo un libro con una ID específica y luego aplica una sanción al usuario si la
     * devolución se retrasa o elimina cualquier sanción existente si la devolución se realiza. tiempo.
     * 
     * @param idLibro El parámetro `idLibro` representa el ID del libro que devuelve el usuario.
     * @param dniUsuario El parámetro `dniUsuario` en el método `devolverLibro` representa el
     * identificador único (DNI) del usuario que devuelve el libro. Se utiliza para identificar al
     * usuario asociado con el libro que se devuelve y realizar acciones como verificar si hay libros
     * vencidos y aplicar sanciones si es necesario.
     */
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
