module com.lsa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lsa to javafx.fxml;
    exports com.lsa;
}