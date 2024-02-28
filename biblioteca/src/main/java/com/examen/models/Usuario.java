/**
 * La clase `Usuario` representa un usuario con atributos como DNI y métodos relacionados con sanción.
 */
package com.examen.models;

import java.util.Date;

public class Usuario {

    /*Atributos: Dni_Usuario, FechaAltaSanción.
• Métodos : Sancionar(), QuitarSanción() */

    String dniUsuario;
    Date   fechaAltaSancion;

    public Usuario(String dniUsuario, Date fechaAltaSancion) {
        this.dniUsuario = dniUsuario;
        this.fechaAltaSancion = fechaAltaSancion;
    }

    

    public Usuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }



    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public Date getFechaAltaSancion() {
        return fechaAltaSancion;
    }

    public void setFechaAltaSancion(Date fechaAltaSancion) {
        this.fechaAltaSancion = fechaAltaSancion;
    }

    @Override
    public String toString() {
        return "Usuario [dniUsuario=" + dniUsuario + ", fechaAltaSancion=" + fechaAltaSancion + "]";
    }

    public void sancionar(){
        System.out.println("Sancionado");
    }

    public void quitarSancion(){
        System.out.println("Sanción quitada");
    }

    
}
