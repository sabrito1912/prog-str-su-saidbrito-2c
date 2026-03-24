package com.example.practicaparaexamen.controllers;

import com.example.practicaparaexamen.models.Contacto;
import com.example.practicaparaexamen.services.ContactoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ContactoController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> cmbParentesco;
    @FXML private ListView<Contacto> listViewContactos;
    @FXML private Label lblMensaje;

    private ContactoService service = new ContactoService();
    private ObservableList<Contacto> listaObservable = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        String[] opcionesParentesco = {"Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tio", "Tia"};
        cmbParentesco.getItems().addAll(opcionesParentesco);
        listViewContactos.setItems(listaObservable);
        listViewContactos.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtNombre.setText(newVal.getNombre());
                txtTelefono.setText(newVal.getTelefono());
                cmbParentesco.setValue(newVal.getParentesco());
            }
        });
    }
    private void actualizarListView() {
        listaObservable.setAll(service.obtenerTodos());
    }

    @FXML
    public void onAgregar() {
        try {
            service.agregarContacto(txtNombre.getText(), txtTelefono.getText(), cmbParentesco.getValue());
            actualizarListView();
            onLimpiar();
            mostrarMensaje("Contacto agregado correctamente.", "green");
        } catch (IllegalArgumentException e) {
            mostrarMensaje(e.getMessage(), "red");
        }
    }

    @FXML
    public void onBuscar() {
        String nombre = txtNombre.getText();
        if (nombre == null || nombre.isBlank()) {
            mostrarMensaje("Escribe un nombre para buscar.", "red");
            return;
        }

        Contacto encontrado = service.buscarPorNombre(nombre);

        if (encontrado != null) {
            txtNombre.setText(encontrado.getNombre());
            txtTelefono.setText(encontrado.getTelefono());
            cmbParentesco.setValue(encontrado.getParentesco());
            mostrarMensaje("Contacto encontrado.", "blue");
        } else {
            mostrarMensaje("No se encontró ningún contacto con ese nombre.", "red");
            onLimpiar();
            txtNombre.setText(nombre);
        }
    }

    @FXML
    public void onActualizar() {
        try {
            service.actualizarContacto(txtNombre.getText(), txtTelefono.getText(), cmbParentesco.getValue());
            actualizarListView();
            mostrarMensaje("Contacto actualizado correctamente.", "green");
        } catch (IllegalArgumentException e) {
            mostrarMensaje(e.getMessage(), "red");
        }
    }

    @FXML
    public void onEliminar() {
        try {

            service.eliminarContacto(txtNombre.getText());
            actualizarListView();
            onLimpiar();
            mostrarMensaje("Contacto eliminado correctamente.", "green");
        } catch (IllegalArgumentException e) {
            mostrarMensaje(e.getMessage(), "red");
        }
    }

    @FXML
    public void onLimpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        cmbParentesco.setValue(null);
        listViewContactos.getSelectionModel().clearSelection();
        lblMensaje.setText("");
    }

    private void mostrarMensaje(String texto, String color) {
        lblMensaje.setText(texto);
        lblMensaje.setStyle("-fx-text-fill: " + color + ";");
    }
}