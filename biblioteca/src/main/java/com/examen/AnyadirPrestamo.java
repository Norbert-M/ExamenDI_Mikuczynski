package com.examen;

import java.util.Date;

import com.examen.models.Prestamo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AnyadirPrestamo {

    @FXML
    private Button cancelarButton;

    @FXML
    private TextField dniUsuarioText;

    @FXML
    private Button guardarButton;

    @FXML
    private TextField idLibroText;

    private Biblioteca biblioteca;

    @FXML
    void onHandleCancelarButton() {
        /*Retornar a primary.fxml */

        cancelarButton.getScene().getWindow().hide();
        
    }


    @FXML
    void onHandleGuardarButton() {

        /*Crear un nuevo prestamo con los datos introducidos y añadirlo a la lista de prestamos de la biblioteca */

        int idLibro = Integer.parseInt(idLibroText.getText());
        String dniUsuario = dniUsuarioText.getText();

        biblioteca.Prestar(idLibro, dniUsuario);

        cancelarButton.getScene().getWindow().hide();
        
        
    }

}
