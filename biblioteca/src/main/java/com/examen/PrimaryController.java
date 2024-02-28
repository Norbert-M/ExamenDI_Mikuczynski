package com.examen;

import com.examen.models.Libro;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class PrimaryController {

    @FXML
    private Button anyadirLibroButton;

    @FXML
    private ListView<Libro> listViewLibros;

    @FXML
    private Button nuevoPrestamoButton;

}
