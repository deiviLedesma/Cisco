/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cisco;

import Entidades.CarreraEntidad;
import Entidades.UnidadAcademicaEntidad;
import daos.CarreraDAO;
import daos.ConexionBD;
import daos.UnidadAcademicaDAO;
import exceptions.PersistenciaException;
import interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author SDavidLedesma
 */
public class Cisco {

    public static void main(String[] args) throws PersistenciaException {
        IConexionBD conexion = new ConexionBD();
        
        UnidadAcademicaEntidad uae = new UnidadAcademicaEntidad("asd");
        CarreraEntidad carrera = new CarreraEntidad("isw",7);
        
        CarreraDAO carreraD = new CarreraDAO(conexion);
        UnidadAcademicaDAO unidadDAO = new UnidadAcademicaDAO(conexion);
        
        carreraD.agregarCarrera(carrera);
        unidadDAO.agregarCarrera(uae);
        
    }
}
