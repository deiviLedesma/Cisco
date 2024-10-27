/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.AlumnoEntidad;
import Entidades.CentroDeComputoEntidad;
import Entidades.ComputadoraEntidad;
import Entidades.UnidadAcademicaEntidad;
import exceptions.PersistenciaException;
import interfaces.IComputadoraDAO;
import interfaces.IConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author filor
 */
public class ComputadoraDAO implements IComputadoraDAO{
    private IConexionBD conexionBD;

    public ComputadoraDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    public ComputadoraDAO() {
        this.conexionBD = new ConexionBD();
    }
    /**
     * 
     * @param entidad
     * @throws PersistenciaException 
     */
    @Override
    public void agregarComputadora(ComputadoraEntidad entidad) throws PersistenciaException {
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
            throw new PersistenciaException("Error al crear la computadora", e);
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
    public void editarComputadora(ComputadoraEntidad entidad) throws PersistenciaException {
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
     * @param id
     * @throws PersistenciaException 
     */
    @Override
    public void eliminarComputadora(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            ComputadoraEntidad entidad = entityManager.find(ComputadoraEntidad.class, id);
            if (entidad != null) {
                entityManager.remove(entidad);
            }
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new PersistenciaException("Error al eliminar la computadora", e);
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
    public ComputadoraEntidad consultarPCPorID(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        ComputadoraEntidad entidad = null;

        try {
            entidad = entityManager.find(ComputadoraEntidad.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al leer la computadora", e);
        } finally {
            entityManager.close();
        }

        return entidad;
    }
    
    @Override
    public List<ComputadoraEntidad> listaCompu() throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        List<ComputadoraEntidad> entidad = null;

        try {
            entidad = entityManager.createQuery("SELECT b FROM ComputadoraEntidad b", ComputadoraEntidad.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al leer las computadoras", e);
        } finally {
            entityManager.close();
        }

        return entidad;
    }
}
