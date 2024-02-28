package com.examen;

import com.examen.models.Libro;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SecondaryController {

    @FXML
    private Button cancelarButton;

    @FXML
    private Button guardarButton;

    @FXML
    private TextField idLibroText;

    @FXML
    private TextField isbnText;

    @FXML
    private TextField tituloText;

    private Biblioteca biblioteca;

    private PrimaryController primaryController;


    



    @FXML
    void onHandleCancelarButton() {
        /*Retornar a primary.fxml */

        cancelarButton.getScene().getWindow().hide();
        
    }

    public void setPrimaryController(PrimaryController primaryController) {
        this.primaryController = primaryController;
    }


    @FXML
    void onHandleGuardarButton() {

        /*Crear un nuevo libro con los datos introducidos y añadirlo a la lista de libros de la biblioteca */

        int idLibro = Integer.parseInt(idLibroText.getText());
        String isbn = isbnText.getText();
        String titulo = tituloText.getText();

        biblioteca.altaLibro(idLibro, titulo, isbn);

        cancelarButton.getScene().getWindow().hide();
        
        
    }

}
