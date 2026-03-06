package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.io.IOException;
import java.util.List;

public class AppController {
    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;

    @FXML
    private final ObservableList<String> data = FXCollections.observableArrayList();

    private PersonServices service = new PersonServices();

    @FXML
    public void initialize(){ //Se ejecuta al inicio en cuanto se cargue el controller
        //Inicializar ListView
        listView.setItems(data);
        loadFromFile();
    }

    private void loadFromFile(){
        try{
            List<String> items = service.loadDataForList();
            data.setAll(items);
            lblMsg.setText("Datos cargados Exitosamente ");
            lblMsg.setStyle("-fx-text-fill: green");
        }catch (IOException e){
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
}
