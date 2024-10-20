/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cisco;

import Entidades.unidadAcademicaEntidad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author SDavidLedesma
 */
public class Cisco {

    public static void main(String[] args) {
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
        
        // Cerrar el administrador de entidades y la fabrica
        entityManager.close();
        managerFactory.close();
    }
}
