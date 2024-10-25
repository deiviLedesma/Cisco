/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cisco;

import Entidades.unidadAcademicaEntidad;
import OtrasCosas.ConexionBD;
import java.sql.Connection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author SDavidLedesma
 */
public class Cisco {

    public static void main(String[] args) throws JRException {
        
        
        // Crear una fabrica de administradores de entidades con la configuracion "ConexionJPA"
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        
        // Crear un administrador de entidades a partir de la fabrica
        EntityManager entityManager = managerFactory.createEntityManager();
        
        // Iniciar una nueva transaccion
        entityManager.getTransaction().begin();
        
        // Crear una nueva instancia de Entidad con los datos proporcionado
        unidadAcademicaEntidad ua = new unidadAcademicaEntidad();
        ua.setNombreUnidad("nomrbe");
        // Peristir (guardar) la entidad en la base de datos
        entityManager.persist(ua);
        
        
        // Confirmar la transaccion para que los cambios se apliquen
        entityManager.getTransaction().commit();
        
        // Mostrar mensaje de exito
        System.out.println("Operacio realizada correctamente");
        
         
             String report = "C:\\Users\\SDavidLedesma\\Desktop\\Cisco-main\\src\\main\\java\\OtrasCosas\\reporteCarreras.jrxml";
             JasperReport jr;
             jr = JasperCompileManager.compileReport(report);
             JasperPrint jp= JasperFillManager.fillReport(jr, null, ConexionBD.getConnection());
             JasperViewer.viewReport(jp);
        
        
        
        
        
        
        // Cerrar el administrador de entidades y la fabrica
        entityManager.close();
        managerFactory.close();
    }
}
