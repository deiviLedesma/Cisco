/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.AlumnoEntidad;
import Entidades.BloqueoEntidad;
import Entidades.ComputadoraEntidad;
import Entidades.UnidadAcademicaEntidad;
import exceptions.PersistenciaException;
import interfaces.IBloqueoDAO;
import interfaces.IConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author filor
 */
public class BloqueoDAO implements IBloqueoDAO{
    private IConexionBD conexionBD;

    public BloqueoDAO() {
        this.conexionBD = new ConexionBD();
    }
    /**
     * 
     * @param entidad
     * @throws PersistenciaException 
     */
    @Override
    public void agregarBloqueo(BloqueoEntidad entidad) throws PersistenciaException {
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
            throw new PersistenciaException("Error al crear el bloqueo", e);
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
    public void eliminarBloqueo(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            BloqueoEntidad entidad = entityManager.find(BloqueoEntidad.class, id);
            if (entidad != null) {
                entityManager.remove(entidad);
            }
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new PersistenciaException("Error al eliminar el bloqueo", e);
        } finally {
            entityManager.close();
        }
    }
    
    /**
     * 
     * @param id
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public BloqueoEntidad consultarBloqueoPorID(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        BloqueoEntidad entidad = null;

        try {
            entidad = entityManager.find(BloqueoEntidad.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al leer la computadora", e);
        } finally {
            entityManager.close();
        }

        return entidad;
    }
    
    @Override
    public List<BloqueoEntidad> listaBloqueos() throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        List<BloqueoEntidad> entidad = null;

        try {
            entidad = entityManager.createQuery("SELECT b FROM BloqueoEntidad b", BloqueoEntidad.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al leer todos los CentroComputo", e);
        } finally {
            entityManager.close();
        }

        return entidad;
    }
}
