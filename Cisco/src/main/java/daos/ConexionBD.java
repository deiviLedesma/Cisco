/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author filor
 */
public class ConexionBD implements IConexionBD{
    private EntityManagerFactory entityManagerFactory;

    public ConexionBD() {
        try {
            this.entityManagerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        } catch (Exception e) {
            System.err.println("Error al inicializar el EntityManagerFactory: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Obtiene un EntityManager para realizar operaciones de persistencia.
     *
     * @return El EntityManager creado a partir de la EntityManagerFactory.
     * @throws IllegalStateException Si la EntityManagerFactory no está
     * inicializada.
     */
    @Override
    public EntityManager obtenerEntityManager() {
        if (entityManagerFactory == null) {
            throw new IllegalStateException("EntityManagerFactory no esta inicializado.");
        }
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void cerrarEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
