/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.AlumnoEntidad;
import Entidades.ReservaEntidad;
import Entidades.SoftwareEntidad;
import exceptions.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IReservaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author filor
 */
public class ReservaDAO implements IReservaDAO {
    private IConexionBD conexionBD;

    public ReservaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    /**
     * 
     * @param entidad
     * @throws PersistenciaException 
     */
    @Override
    public void agregarReserva(ReservaEntidad entidad) throws PersistenciaException {
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
            throw new PersistenciaException("Error al crear la reserva", e);
        } finally {
            entityManager.close();
        }
    }
    /**
     * 
     * @param id
     * @throws PersistenciaException 
     */
    @Override
    public void eliminarReserva(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            ReservaEntidad entidad = entityManager.find(ReservaEntidad.class, id);
            if (entidad != null) {
                entityManager.remove(entidad);
            }
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new PersistenciaException("Error al eliminar la reserva", e);
        } finally {
            entityManager.close();
        }
    }
    
    
}
