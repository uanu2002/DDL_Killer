module com.example.dlk {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dlk to javafx.fxml;
    exports com.example.dlk;
}