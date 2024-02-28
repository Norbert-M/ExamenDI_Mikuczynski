package com.examen;

import com.examen.models.Libro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * Esta clase se denomina PrimaryController y probablemente sirve como controlador principal para una
 * aplicación Java.
 */
public class PrimaryController {

    @FXML
    private Button anyadirLibroButton;

    @FXML
    private ListView<Libro> listViewLibros;

    @FXML
    private Button nuevoPrestamoButton;

    private Biblioteca biblioteca;


    /**
     * La función `initialize` configura una lista observable vacía de objetos `Libro` y la asigna a un
     * componente ListView.
     * 
     * @param event El parámetro `event` en el método `initialize` es un objeto `ActionEvent`.
     * Representa el evento que desencadenó la inicialización del controlador, como cuando se carga el
     * archivo FXML y se crea una instancia del controlador.
     */
    @FXML
    void initialize(ActionEvent event) {
        ObservableList<Libro> libros = FXCollections.observableArrayList();
        listViewLibros.setItems(libros);
    }


    /**
     * Esta función de Java abre una nueva etapa con un archivo FXML secundario y configura un
     * controlador para la comunicación entre los controladores primario y secundario.
     * 
     * @param event El parámetro `event` en el método `onHandleAnyadirLibroButton` de su controlador
     * JavaFX representa el evento de acción que ocurrió, como un clic en un botón, que desencadenó el
     * método a ejecutar. Puede utilizar este parámetro para acceder a información sobre el evento que
     * ocurrió, como el
     */
    @FXML
    void onHandleAnyadirLibroButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.load();
            SecondaryController secondaryController = fxmlLoader.getController();
            secondaryController.setPrimaryController(this);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    
    }

    //Cargar los libros en el ListView
    /**
     * La función "cargarLibros" borra los elementos de un ListView y le agrega todos los libros de una
     * biblioteca.
     */
    public void cargarLibros() {
        listViewLibros.getItems().clear();
        listViewLibros.getItems().addAll(biblioteca.getLibros());
    }

}
