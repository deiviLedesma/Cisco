/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.CarreraEntidad;
import Entidades.CentroDeComputoEntidad;
import exceptions.PersistenciaException;
import interfaces.ICentroDeComputoDAO;
import interfaces.IConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author filor
 */
public class CentroDeComputoDAO implements ICentroDeComputoDAO{
    private IConexionBD conexionBD;

    public CentroDeComputoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    /**
     * 
     * @param centro
     * @throws PersistenciaException 
     */
    @Override
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
    /**
     * 
     * @param id
     * @throws PersistenciaException 
     */
    @Override
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
    /**
     * 
     * @param entidad
     * @throws PersistenciaException 
     */
    @Override
    public void editarCentro(CentroDeComputoEntidad entidad) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.merge(entidad);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new PersistenciaException("Error al actualizar beneficiario", e);
        } finally {
            entityManager.close();
        }
    }
    
    /**
     * 
     * @param pagina
     * @param limite
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public List<CentroDeComputoEntidad> listaCentrosPaginado(int pagina, int limite) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        List<CentroDeComputoEntidad> entidad = null;

        try {
            entidad = entityManager.createQuery("SELECT b FROM CentroDeComputoEntidad b", CentroDeComputoEntidad.class)
                    .setFirstResult((pagina - 1) * limite)
                    .setMaxResults(limite)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al leer todos los CentroComputo", e);
        } finally {
            entityManager.close();
        }

        return entidad;
    }
    /**
     * 
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public List<CentroDeComputoEntidad> listaCentros() throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        List<CentroDeComputoEntidad> entidad = null;

        try {
            entidad = entityManager.createQuery("SELECT b FROM CentroDeComputoEntidad b", CentroDeComputoEntidad.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al leer todos los CentroComputo", e);
        } finally {
            entityManager.close();
        }

        return entidad;
    }
}
