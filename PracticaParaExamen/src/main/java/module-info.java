module com.example.practicaparaexamen {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.practicaparaexamen to javafx.fxml;
    exports com.example.practicaparaexamen;

    opens com.example.practicaparaexamen.controllers to javafx.fxml;
    exports com.example.practicaparaexamen.controllers;

    opens com.example.practicaparaexamen.models to javafx.fxml;
    exports com.example.practicaparaexamen.models;
}