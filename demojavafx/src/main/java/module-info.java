module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    // Esto da permiso a JavaFX para usar tus controladores
    opens controllers to javafx.fxml;
    exports controllers;
}