package com.example.demolistviewfile.controllers;

import com.example.demolistviewfile.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.List;
import java.io.IOException;

public class AppController {

    @FXML
    private Label lbMsg;

    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtAge;

    private ObservableList<String> data = FXCollections.observableArrayList();
    PersonService service = new PersonService();

    @FXML
    public void initialize(){
        listView.setItems(data);
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs,oldValue,newValue) ->{
                    if (newValue != null) {
                        String[] parts = newValue.split("-");
                        if (parts.length >= 3) {
                            txtName.setText(parts[0].trim());
                            txtEmail.setText(parts[1].trim());
                            txtAge.setText(parts[2].trim());
                        }
                    }
                }
        );
        loadFromFile();
    }

    @FXML
    public void onReaload(){
        loadFromFile();
    }

    @FXML
    public void onAddPerson(){
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String age = txtAge.getText();

            service.addPerson(name, email, age);

            lbMsg.setText("Usuario creado correctamente!");
            lbMsg.setStyle("-fx-text-fill: green");

            txtName.clear();
            txtEmail.clear();
            txtAge.clear();

            loadFromFile();

        } catch (IOException e) {
            lbMsg.setText("Error de archivo "+ e.getMessage());
            lbMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException e) {
            lbMsg.setText(e.getMessage());
            lbMsg.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void onUpdate(){
        try {
            int index = listView.getSelectionModel().getSelectedIndex();

            if(index < 0) {
                lbMsg.setText("Por favor, selecciona un registro de la lista");
                lbMsg.setStyle("-fx-text-fill: red");
                return;
            }

            String name = txtName.getText();
            String email = txtEmail.getText();
            String age = txtAge.getText();

            service.updatePerson(index, name, email, age);

            loadFromFile();

            txtName.clear();
            txtEmail.clear();
            txtAge.clear();

            lbMsg.setText("Se actualizó el registro correctamente");
            lbMsg.setStyle("-fx-text-fill: green");

        } catch (IOException e) {
            lbMsg.setText("Hubo un error con el archivo");
            lbMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException e){
            lbMsg.setText("Hubo un error con los datos: " + e.getMessage());
            lbMsg.setStyle("-fx-text-fill: red");
        }
    }
    @FXML
    public void onDelete() {
        int index = listView.getSelectionModel().getSelectedIndex();
        if(index < 0) {
            lbMsg.setText("Por favor, selecciona un registro para eliminar");
            lbMsg.setStyle("-fx-text-fill: red");
            return;
        }
        try {
            service.delete(index);
            loadFromFile();
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();
            lbMsg.setText("Registro eliminado correctamente");
            lbMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lbMsg.setText("Hubo un error con el archivo");
            lbMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException e){
            lbMsg.setText("Hubo un error con los datos: " + e.getMessage());
            lbMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile(){
        try {
            List<String> items = service.loadForListView();
            data.setAll(items);
            lbMsg.setText("Datos cargados correctamente");
            lbMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lbMsg.setText("Error al cargar: " + e.getMessage());
            lbMsg.setStyle("-fx-text-fill: red");
        }
    }
}