package com.examen;

import com.examen.models.Libro;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Esta clase se denomina SecondaryController en Java.
 */
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


    



    /**
     * La función `onHandleCancelarButton` oculta la ventana actual cuando se hace clic en el botón
     * cancelar.
     */
    @FXML
    void onHandleCancelarButton() {
        /*Retornar a primary.fxml */

        cancelarButton.getScene().getWindow().hide();
        
    }

    /**
     * La función establece el controlador principal del objeto.
     * 
     * @param primaryController El método `setPrimaryController` se utiliza para configurar el
     * controlador principal para un objeto en particular. El parámetro `primaryController` es el
     * controlador que se establecerá como controlador principal para el objeto.
     */
    public void setPrimaryController(PrimaryController primaryController) {
        this.primaryController = primaryController;
    }


    /**
     * La función crea un nuevo libro con los datos ingresados y lo agrega a la lista de libros de la
     * biblioteca antes de cerrar la ventana.
     */
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
