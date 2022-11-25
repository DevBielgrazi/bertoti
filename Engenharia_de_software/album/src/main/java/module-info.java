module fwc.album {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens fwc.album to javafx.fxml;
    exports fwc.album;
}