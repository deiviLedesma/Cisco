/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.SoftwareEntidad;
import Entidades.UnidadAcademicaEntidad;
import exceptions.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IUnidadAcademicaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author filor
 */
public class UnidadAcademicaDAO implements IUnidadAcademicaDAO{
    private IConexionBD conexionBD;

    public UnidadAcademicaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public UnidadAcademicaDAO() {
        this.conexionBD = new ConexionBD();
    }
    
    /**
     * 
     * @param unidad
     * @throws PersistenciaException 
     */
    @Override
    public void agregarUnidad(UnidadAcademicaEntidad unidad) throws PersistenciaException {
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
            throw new PersistenciaException("Error al crear la unidad", e);
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
    public UnidadAcademicaEntidad consultarUnidadPorID(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        UnidadAcademicaEntidad unidad = null;

        try {
            unidad = entityManager.find(UnidadAcademicaEntidad.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error la entidad", e);
        } finally {
            entityManager.close();
        }

        return unidad;
    }
    
    @Override
    public List<UnidadAcademicaEntidad> listaUnidades() throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        List<UnidadAcademicaEntidad> entidad = null;

        try {
            entidad = entityManager.createQuery("SELECT b FROM UnidadAcademicaEntidad b", UnidadAcademicaEntidad.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al leer todos los CentroComputo", e);
        } finally {
            entityManager.close();
        }

        return entidad;
    }
}
