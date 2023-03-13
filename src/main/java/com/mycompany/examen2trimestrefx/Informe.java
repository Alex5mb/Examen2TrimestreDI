/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen2trimestrefx;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author FranciscoRomeroGuill
 */
public class Informe {

    public static void menushowReport() throws JRException, ClassNotFoundException, SQLException {

        HashMap hm = new HashMap();

        String report = "Notas.jasper";

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report, 
                hm, 
                ProductoDAOMySQL.getConnection()
        );

        JRViewer viewer = new JRViewer(jasperPrint);

        JFrame frame = new JFrame("Menu");
        frame.getContentPane().add(viewer);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);

        System.out.print("Done!");
    }

    public static void menupdfReport() throws JRException, ClassNotFoundException, SQLException {

        HashMap hm = new HashMap();


        String report = "Menu.jasper";

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report, 
                hm, 
               ProductoDAOMySQL.getConnection()
        );
        
        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Menu.pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();

        System.out.print("Done!");
    }
    
    public static void historialshowReport() throws JRException, ClassNotFoundException, SQLException {

        HashMap hm = new HashMap();

        String report = "Historial.jasper";

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report, 
                hm, 
                ProductoDAOMySQL.getConnection()
        );

        JRViewer viewer = new JRViewer(jasperPrint);

        JFrame frame = new JFrame("Historial");
        frame.getContentPane().add(viewer);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);

        System.out.print("Done!");
    }

    public static void historialpdfReport() throws JRException, ClassNotFoundException, SQLException {

        HashMap hm = new HashMap();


        String report = "Historial.jasper";

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report, 
                hm, 
               ProductoDAOMySQL.getConnection()
        );
        
        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Historial.pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();

        System.out.print("Done!");
    }
     public static void historialFshowReport(String fecha1, String fecha2) throws JRException, ClassNotFoundException, SQLException {

        HashMap hm = new HashMap();
        
         hm.put("fecha1", fecha1);
         hm.put("fecha2", fecha2);

        String report = "Historial_filtro.jasper";

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report, 
                hm, 
                ProductoDAOMySQL.getConnection()
        );
 
        JRViewer viewer = new JRViewer(jasperPrint);


        JFrame frame = new JFrame("Historial_filtro");
        frame.getContentPane().add(viewer);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);

        System.out.print("Done!");
    }

    public static void historialFpdfReport(String fecha1, String fecha2) throws JRException, ClassNotFoundException, SQLException {

        HashMap hm = new HashMap();

         hm.put("fecha1", fecha1);
         hm.put("fecha2", fecha2);

        String report = "Historial_filtro.jasper";

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report, 
                hm, 
               ProductoDAOMySQL.getConnection()
        );

        
        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Historial_F.pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();

        System.out.print("Done!");
    }
    

}
