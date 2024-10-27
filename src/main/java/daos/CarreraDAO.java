/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.AlumnoEntidad;
import Entidades.CarreraEntidad;
import Entidades.CentroDeComputoEntidad;
import Entidades.ComputadoraEntidad;
import exceptions.PersistenciaException;
import interfaces.ICarreraDAO;
import interfaces.IConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author filor
 */
public class CarreraDAO implements ICarreraDAO {
    private IConexionBD conexionBD;

    public CarreraDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public CarreraDAO() {
        this.conexionBD = new ConexionBD();
    }
    /**
     * 
     * @param carrera
     * @throws PersistenciaException 
     */
    @Override
     public void agregarCarrera(CarreraEntidad carrera) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(carrera);
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
     /**
      * 
      * @param id
      * @return
      * @throws PersistenciaException 
      */
    @Override
     public CarreraEntidad consultarCarreraPorID(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        CarreraEntidad entidad = null;

        try {
            entidad = entityManager.find(CarreraEntidad.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al leer la carrera", e);
        } finally {
            entityManager.close();
        }

        return entidad;
    }
     /**
      * 
      * @param entidad
      * @throws PersistenciaException 
      */
    @Override
     public void editarCarrera(CarreraEntidad entidad) throws PersistenciaException {
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
     
    @Override
     public void eliminarCarrera(Long id) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            CarreraEntidad entidad = entityManager.find(CarreraEntidad.class, id);
            if (entidad != null) {
                entityManager.remove(entidad);
            }
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw new PersistenciaException("Error al eliminar la carrera", e);
        } finally {
            entityManager.close();
        }
    }
     
     @Override
    public List<CarreraEntidad> listaCarreras() throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        List<CarreraEntidad> entidad = null;

        try {
            entidad = entityManager.createQuery("SELECT b FROM CarreraEntidad b", CarreraEntidad.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al leer todos los CentroComputo", e);
        } finally {
            entityManager.close();
        }

        return entidad;
    }
    
    @Override
    public List<CarreraEntidad> listaCarreras(int pagina, int limite) throws PersistenciaException {
        EntityManager entityManager = conexionBD.obtenerEntityManager();
        List<CarreraEntidad> entidad = null;

        try {
            entidad = entityManager.createQuery("SELECT b FROM CarreraEntidad b", CarreraEntidad.class)
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
}
