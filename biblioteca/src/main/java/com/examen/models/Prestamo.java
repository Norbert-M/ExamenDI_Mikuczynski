package com.examen.models;

import java.util.Date;

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

    @Override
    public String toString() {
        return "Prestamo [idLibro=" + idLibro + ", dniUsuario=" + dniUsuario + ", fechaDevolucion=" + fechaDevolucion
                + "]";
    }

    
}
