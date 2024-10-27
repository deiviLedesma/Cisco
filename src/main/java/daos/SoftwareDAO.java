/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.AlumnoEntidad;
import Entidades.CarreraEntidad;
import Entidades.ComputadoraSoftwareEntidad;
import Entidades.SoftwareEntidad;
import exceptions.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ISoftwareDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author filor
 */
public class SoftwareDAO implements ISoftwareDAO{
    private IConexionBD conexionBD;

    public SoftwareDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    /**
     * 
     * @param unidad
     * @throws PersistenciaException 
     */
    public void agregarSoftware(SoftwareEntidad unidad) throws PersistenciaException {
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
            throw new PersistenciaException("Error al crear el software", e);
        } finally {
            entityManager.close();
        }
    }
    /**
     * 
     * @param id
     * @throws PersistenciaException 
     */
    public void eliminarAlumno(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            SoftwareEntidad entidad = entityManager.find(SoftwareEntidad.class, id);
            if (entidad != null) {
                entityManager.remove(entidad);
            }
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new PersistenciaException("Error al eliminar al alumno", e);
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
    public SoftwareEntidad consultarSoftwarePorID(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        SoftwareEntidad entidad = null;

        try {
            entidad = entityManager.find(SoftwareEntidad.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al leer el software", e);
        } finally {
            entityManager.close();
        }

        return entidad;
    }
    
    @Override
    public List<SoftwareEntidad> listaSoftwares() throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        List<SoftwareEntidad> entidad = null;

        try {
            entidad = entityManager.createQuery("SELECT b FROM SoftwareEntidad b", SoftwareEntidad.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al leer todos los CentroComputo", e);
        } finally {
            entityManager.close();
        }

        return entidad;
    }
}
