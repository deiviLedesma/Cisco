/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cisco;

import Entidades.CarreraEntidad;
import Entidades.CentroDeComputoEntidad;
import Entidades.UnidadAcademicaEntidad;
import daos.CarreraDAO;
import daos.CentroDeComputoDAO;
import daos.ConexionBD;
import daos.UnidadAcademicaDAO;
import exceptions.PersistenciaException;
import interfaces.IConexionBD;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
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
        UnidadAcademicaEntidad unidad = new UnidadAcademicaEntidad("unidad");
        UnidadAcademicaDAO unidadDAO = new UnidadAcademicaDAO(conexion);
        CentroDeComputoDAO centroDAO = new CentroDeComputoDAO(conexion);
        CentroDeComputoEntidad centro1 = new CentroDeComputoEntidad("centro1", "pepes", Time.valueOf("5:03:00"), Time.valueOf("8:00:00"));
        List<CentroDeComputoEntidad> centros = new ArrayList<>();
        centros.add(centro1);
        unidadDAO.consultarUnidadPorID(1L).setCentroUnidad(centros);
        
        centro1.setCentroUnidad(unidadDAO.consultarUnidadPorID(1L));
        
        centroDAO.agregarCentro(centro1);
    }
}
