/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.examen2trimestrefx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author AlejandroMarínBermúd
 */
public class PrimaryController implements Initializable {

    @FXML
    private TextField nombre_input;
    @FXML
    private TextField eie_input;
    @FXML
    private TextField psp_input;
    @FXML
    private TextField pmdm_input;
    @FXML
    private TextField di_input;
    @FXML
    private TextField sge_input;
    @FXML
    private TextField ad_input;
    @FXML
    private TextField apellido_input;
    @FXML
    private TextField hlc_input;
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
   
        nombre_column.setCellValueFactory(new PropertyValueFactory("nombre"));
        apellido_column.setCellValueFactory(new PropertyValueFactory("apellido"));
        ad_column.setCellValueFactory(new PropertyValueFactory("ad"));
        sge_column.setCellValueFactory(new PropertyValueFactory("sge"));
        di_column.setCellValueFactory(new PropertyValueFactory("di"));
        pmdm_column.setCellValueFactory(new PropertyValueFactory("pmdm"));
        psp_column.setCellValueFactory(new PropertyValueFactory("psp"));
        eie_column.setCellValueFactory(new PropertyValueFactory("eie"));
        hlc_column.setCellValueFactory(new PropertyValueFactory("hlc"));
        
    }    

    @FXML
    private void onClcik(ActionEvent event) {
        
        if(nombre_input.getText() == ""){
            mensaje.setText("el nombre esta Vacio");
        }
        if(apellido_input.getText() == ""){
            mensaje.setText("el apellido esta Vacio");
        }
        if(ad_input.getText() == "" && Integer.parseInt(ad_input.getText()) > 0 && Integer.parseInt(ad_input.getText()) < 10){
            mensaje.setText("la nota de ad es nula");
        }
        if(sge_input.getText() == "" && Integer.parseInt(sge_input.getText()) > 0 && Integer.parseInt(sge_input.getText()) < 10){
            mensaje.setText("la nota de sge es nula");
        }
        if(di_input.getText() == "" && Integer.parseInt(di_input.getText()) > 0 && Integer.parseInt(di_input.getText()) < 10){
            mensaje.setText("la nota de di es nula");
        }
        if(pmdm_input.getText() == "" && Integer.parseInt(pmdm_input.getText()) > 0 && Integer.parseInt(pmdm_input.getText()) < 10){
            mensaje.setText("la nota de pmdm es nula");
        }
        if(psp_input.getText() == "" && Integer.parseInt(psp_input.getText()) > 0 && Integer.parseInt(psp_input.getText()) < 10) {
            mensaje.setText("la nota de psp es nula");
        }
        if(eie_input.getText() == "" && Integer.parseInt(eie_input.getText()) > 0 && Integer.parseInt(eie_input.getText()) < 10){
            mensaje.setText("la nota de eie es nula");
        }
        if(hlc_input.getText() == "" && Integer.parseInt(hlc_input.getText()) > 0 && Integer.parseInt(hlc_input.getText()) < 10){
            mensaje.setText("la nota de hlc es nula");
        }
        else{
             mensaje.setText("");
             
            Alumno alumno = new Alumno();
            
            alumno.setNombre(nombre_input.getText());
            alumno.setApellido(apellido_input.getText());
            alumno.setAd(Integer.parseInt(ad_input.getText()));
            alumno.setSge(Integer.parseInt(sge_input.getText()));
            alumno.setDi(Integer.parseInt(di_input.getText()));
            alumno.setPmdm(Integer.parseInt(pmdm_input.getText()));
            alumno.setPsp(Integer.parseInt(psp_input.getText()));
            alumno.setEie(Integer.parseInt(eie_input.getText()));
            alumno.setHlc(Integer.parseInt(hlc_input.getText()));
            
            ObservableList<Alumno> alumnoLista = FXCollections.observableArrayList();
            
            alumnoLista.addAll(lista_alumno.getItems());
            alumnoLista.add(alumno);
            
            lista_alumno.setItems(alumnoLista);
        }
       
    }
    
}
