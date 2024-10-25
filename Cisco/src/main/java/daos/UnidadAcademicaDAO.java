/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.UnidadAcademicaEntidad;
import exceptions.PersistenciaException;
import interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author filor
 */
public class UnidadAcademicaDAO {
    private IConexionBD conexionBD;

    public UnidadAcademicaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    public void agregarCarrera(UnidadAcademicaEntidad unidad) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(unidad);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new PersistenciaException("Error al crear abono", e);
        } finally {
            entityManager.close();
        }
    }
}
