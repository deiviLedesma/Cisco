/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.AlumnoEntidad;
import Entidades.ComputadoraSoftwareEntidad;
import Entidades.UnidadAcademicaEntidad;
import exceptions.PersistenciaException;
import interfaces.IComputadoraSoftwareDAO;
import interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author filor
 */
public class ComputadoraSoftwareDAO implements IComputadoraSoftwareDAO{
    private IConexionBD conexionBD;

    public ComputadoraSoftwareDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    /**
     * 
     * @param entidad
     * @throws PersistenciaException 
     */
    @Override
    public void agregarComputadoraSoftware(ComputadoraSoftwareEntidad entidad) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(entidad);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new PersistenciaException("Error al agregar la pc/software", e);
        } finally {
            entityManager.close();
        }
    }
    
    
}
