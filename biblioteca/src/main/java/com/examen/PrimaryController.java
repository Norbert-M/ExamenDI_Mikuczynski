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

public class PrimaryController {

    @FXML
    private Button anyadirLibroButton;

    @FXML
    private ListView<Libro> listViewLibros;

    @FXML
    private Button nuevoPrestamoButton;

    private Biblioteca biblioteca;


    @FXML
    void initialize(ActionEvent event) {
        ObservableList<Libro> libros = FXCollections.observableArrayList();
        listViewLibros.setItems(libros);
    }


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
    public void cargarLibros() {
        listViewLibros.getItems().clear();
        listViewLibros.getItems().addAll(biblioteca.getLibros());
    }

}
