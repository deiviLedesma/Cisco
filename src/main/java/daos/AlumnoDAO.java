/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.AlumnoEntidad;
import Entidades.CentroDeComputoEntidad;
import Entidades.UnidadAcademicaEntidad;
import exceptions.PersistenciaException;
import interfaces.IAlumnoDAO;
import interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author filor
 */
public class AlumnoDAO implements IAlumnoDAO{
    private IConexionBD conexionBD;

    public AlumnoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    /**
     * 
     * @param alumno
     * @throws PersistenciaException 
     */
    @Override
    public void agregarAlumno(AlumnoEntidad alumno) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(alumno);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new PersistenciaException("Error al crear al alumno", e);
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
    public void eliminarAlumno(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            AlumnoEntidad entidad = entityManager.find(AlumnoEntidad.class, id);
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
    @Override
    public AlumnoEntidad consultarAlumnoPorID(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        AlumnoEntidad entidad = null;

        try {
            entidad = entityManager.find(AlumnoEntidad.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al leer el alumno", e);
        } finally {
            entityManager.close();
        }

        return entidad;
    }
}
