/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.examen2trimestrefx;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;

/**
 * FXML Controller class
 *
 * @author AlejandroMarínBermúd
 */
public class PrimaryController implements Initializable {

    @FXML
    private TextField nombre_input;
    @FXML
    private Spinner<Integer> eie_input;
    @FXML
    private Spinner<Integer> psp_input;
    @FXML
    private Spinner<Integer> pmdm_input;
    @FXML
    private Spinner<Integer> di_input;
    @FXML
    private Spinner<Integer> sge_input;
    @FXML
    private Spinner<Integer> ad_input;
    @FXML
    private TextField apellido_input;
    @FXML
    private Spinner<Integer> hlc_input;
    @FXML
    private TableColumn<String, String> nombre_column;
    @FXML
    private TableColumn<String, String> apellido_column;
    @FXML
    private TableColumn<Integer, Integer> ad_column;
    @FXML
    private TableColumn<Integer, Integer> sge_column;
    @FXML
    private TableColumn<Integer, Integer> di_column;
    @FXML
    private TableColumn<Integer, Integer> pmdm_column;
    @FXML
    private TableColumn<Integer, Integer> psp_column;
    @FXML
    private TableColumn<Integer, Integer> eie_column;
    @FXML
    private TableColumn<Integer, Integer> hlc_column;
    @FXML
    private Button nuevo_alumno;
    @FXML
    private Button descargar_notas;
    @FXML
    private Button salir;
    @FXML
    private TableView<Alumno> lista_alumno;
    @FXML
    private Label mensaje;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
         ObservableList<String> alumnoLista = FXCollections.observableArrayList();
   
         ad_input.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0));
         sge_input.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0));
         di_input.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0));
         pmdm_input.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0));
         psp_input.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0));
         eie_input.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0));
         hlc_input.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0));
         
        nombre_column.setCellValueFactory(new PropertyValueFactory("nombre"));
        apellido_column.setCellValueFactory(new PropertyValueFactory("apellido"));
        ad_column.setCellValueFactory(new PropertyValueFactory("ad"));
        sge_column.setCellValueFactory(new PropertyValueFactory("sge"));
        di_column.setCellValueFactory(new PropertyValueFactory("di"));
        pmdm_column.setCellValueFactory(new PropertyValueFactory("pmdm"));
        psp_column.setCellValueFactory(new PropertyValueFactory("psp"));
        eie_column.setCellValueFactory(new PropertyValueFactory("eie"));
        hlc_column.setCellValueFactory(new PropertyValueFactory("hlc"));
        
        
        
        
       lista_alumno.setOnMouseClicked(event ->{
           Alumno alumnoSeleccionado = lista_alumno.getSelectionModel().getSelectedItem();
           
           if(alumnoSeleccionado != null){
               
               Stage modalStage = new Stage();
               
               modalStage.setTitle("Alumno");
               modalStage.setResizable(false);
               modalStage.initModality(Modality.APPLICATION_MODAL);
               
               
               Pane modalPane = new Pane();
               modalPane.setStyle("-fx-background-color: white;");
               
               
               int nota_media = 0;
               
               if(alumnoSeleccionado.getAd() >= 5 && alumnoSeleccionado.getDi() >= 5 && alumnoSeleccionado.getEie() >= 5 && alumnoSeleccionado.getHlc() >= 5
                       && alumnoSeleccionado.getPmdm() >= 5 && alumnoSeleccionado.getPsp() >= 5 && alumnoSeleccionado.getSge() >= 5 ){
               
               nota_media = (alumnoSeleccionado.getAd() + alumnoSeleccionado.getDi()
                       + alumnoSeleccionado.getEie() + alumnoSeleccionado.getHlc() + alumnoSeleccionado.getPmdm() +
                       alumnoSeleccionado.getPsp() + alumnoSeleccionado.getSge())/7;
               }
               
               ArrayList suspensos = new ArrayList();
               
               if(alumnoSeleccionado.getAd() < 5){
                   suspensos.add("AD");
               }
                if(alumnoSeleccionado.getDi() < 5){
                   suspensos.add("DI");
               }
                 if(alumnoSeleccionado.getEie() < 5){
                   suspensos.add("EIE");
               }
                  if(alumnoSeleccionado.getHlc() < 5){
                   suspensos.add("HLC");
               }
                   if(alumnoSeleccionado.getPmdm() < 5){
                   suspensos.add("PMDM");
               }
                    if(alumnoSeleccionado.getPsp() < 5){
                   suspensos.add("PSP");
               }
                     if(alumnoSeleccionado.getSge() < 5){
                   suspensos.add("SGE");
               }
                     
               Label labelNombre = new Label(alumnoSeleccionado.getNombre() + " " + alumnoSeleccionado.getApellido());
               labelNombre.setLayoutY(20);
               Label labelNotamedia = new Label("la nota media es: " + nota_media);
               labelNotamedia.setLayoutY(40);
               Label labelSuspensas = new Label("Asignaturas suspensas: " + suspensos);
               labelSuspensas.setLayoutY(60);
               modalPane.getChildren().addAll(labelNombre, labelNotamedia, labelSuspensas);          
               Scene modalScene = new Scene(modalPane,500,500);
               modalStage.setScene(modalScene);
               
               modalStage.showAndWait();
               
           }
       });
        
    }    

    @FXML
    private void onClcik(ActionEvent event) {   
        
        if(nombre_input.getText() == ""){
            mensaje.setText("el nombre esta Vacio");
        }
        if(apellido_input.getText() == ""){
            mensaje.setText("el apellido esta Vacio");
        }
        else{
             mensaje.setText("");
             
            Alumno alumno = new Alumno();
            
            alumno.setNombre(nombre_input.getText());
            alumno.setApellido(apellido_input.getText());
            alumno.setAd(ad_input.getValue());
            alumno.setSge(sge_input.getValue());
            alumno.setDi(di_input.getValue());
            alumno.setPmdm(pmdm_input.getValue());
            alumno.setPsp(psp_input.getValue());
            alumno.setEie(eie_input.getValue());
            alumno.setHlc(hlc_input.getValue());
            
            ObservableList<Alumno> alumnoLista = FXCollections.observableArrayList();
            
            alumnoLista.addAll(lista_alumno.getItems());
            alumnoLista.add(alumno);
            
            lista_alumno.setItems(alumnoLista);
        }
       
    }

    @FXML
    private void onClcikNotas(ActionEvent event) {
        
        try{
            informe.notasShowReport();
            informe.notasPDFReport();
        } catch (JRException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void onClcikSalir(ActionEvent event) {
        
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
}
