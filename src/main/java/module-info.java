module com.mycompany.examen2trimestrefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires mysql.connector.java;
    requires javafx.swing;
    requires jasperreports;

    opens com.mycompany.examen2trimestrefx to javafx.fxml;
    exports com.mycompany.examen2trimestrefx;
}
