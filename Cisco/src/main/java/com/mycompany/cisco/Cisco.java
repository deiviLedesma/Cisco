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
        CentroDeComputoDAO centro = new CentroDeComputoDAO();
        
        List<CentroDeComputoEntidad> centros = centro.listaCentrosPaginado(1, 3, "editado");
        for(CentroDeComputoEntidad entidad: centros){
            System.out.println(entidad);
        }
    }
}
