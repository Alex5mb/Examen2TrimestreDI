module com.mycompany.examen2trimestrefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.examen2trimestrefx to javafx.fxml;
    exports com.mycompany.examen2trimestrefx;
    requires jasperreports;
}
