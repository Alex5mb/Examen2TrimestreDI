/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen2trimestrefx;

import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
 * @author AlejandroMarínBermúd
 */
public class informe {
    
     private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/examen2";

   private static Connection conexion;

    static {
        try {
            conexion= DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     public static Connection getConnection() {
        return conexion;
    }
    
    public static void notasShowReport() throws JRException{
        
        HashMap hm = new HashMap();
        
         String report = "Examen.jasper";
         JasperPrint jasperPrint = JasperFillManager.fillReport(
                report, 
                hm, 
                informe.getConnection()
         );
         
          JRViewer viewer = new JRViewer(jasperPrint);
         
          JFrame frame = new JFrame("Notas");
        frame.getContentPane().add(viewer);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);

        System.out.print("Done!");
        
    }
    
    public static void notasPDFReport() throws JRException{
        
        HashMap hm = new HashMap();
        String report = "Examen.jasper";
         JasperPrint jasperPrint = JasperFillManager.fillReport(
                report, 
                hm, 
                informe.getConnection()
         );
          JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Notas.pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();

        System.out.print("Done!");
         
    }
}
