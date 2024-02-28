package com.examen.models;

import java.util.Date;

/**
 * La clase `Prestamo` representa un préstamo con atributos como idLibro, dniUsuario y fechaDevolucion.
*
 */
public class Prestamo {
    int idLibro;
    String dniUsuario;
    Date fechaDevolucion;

    public Prestamo(int idLibro, String dniUsuario, Date fechaDevolucion) {
        this.idLibro = idLibro;
        this.dniUsuario = dniUsuario;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * El método `toString` en Java devuelve una representación en cadena de un objeto `Prestamo`
     * incluyendo sus atributos `idLibro`, `dniUsuario` y `fechaDevolucion`.
     * 
     * @return El método `toString` devuelve una representación de cadena de un objeto "Prestamo",
     * incluyendo la identificación del libro (`idLibro`), el número de identificación del usuario
     * (`dniUsuario`) y la fecha de regreso (`fechaDevolucion`).
     */
    @Override
    public String toString() {
        return "Prestamo [idLibro=" + idLibro + ", dniUsuario=" + dniUsuario + ", fechaDevolucion=" + fechaDevolucion
                + "]";
    }

    
}
