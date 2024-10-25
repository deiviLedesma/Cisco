/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.CarreraEntidad;
import Entidades.CentroDeComputoEntidad;
import exceptions.PersistenciaException;
import interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author filor
 */
public class CentroDeComputoDAO {
    private IConexionBD conexionBD;

    public CentroDeComputoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    public void agregarCentro(CentroDeComputoEntidad centro) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(centro);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new PersistenciaException("Error al crear centro de computo", e);
        } finally {
            entityManager.close();
        }
    }
    
    public void eliminarCentro(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            CentroDeComputoEntidad centro = entityManager.find(CentroDeComputoEntidad.class, id);
            if (centro != null) {
                entityManager.remove(centro);
            }
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new PersistenciaException("Error al eliminar el centro de computo", e);
        } finally {
            entityManager.close();
        }
    }
}
