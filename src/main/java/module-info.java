module com.projectoop_ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens VietnameseHistorical;
    opens controller to javafx.fxml;
    exports controller;
}