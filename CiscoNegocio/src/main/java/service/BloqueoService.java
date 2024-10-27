/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Entidades.AlumnoEntidad;
import Entidades.BloqueoEntidad;
import Entidades.ComputadoraEntidad;
import Negocio.AlumnoNegocio;
import Negocio.BloqueoNegocio;
import static convertidores.BloqueoConvertidor.convertirDTOAEntidad;
import daos.BloqueoDAO;
import exceptions.NegocioException;
import exceptions.PersistenciaException;
import interfaces.IBloqueoDAO;

/**
 *
 * @author filor
 */
public class BloqueoService {

    private IBloqueoDAO bloqueoDAO;

    public BloqueoService() {
        this.bloqueoDAO = new BloqueoDAO();
    }

    /**
     * 
     * @param dto
     * @throws NegocioException 
     */
    public void agregarBloqueo(BloqueoNegocio dto) throws NegocioException {
        validarBloqueo(dto);

        try {
            BloqueoEntidad bloqueo = convertirDTOAEntidad(dto);
            bloqueoDAO.agregarBloqueo(bloqueo);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar al alumno en la capa de negocio", e);
        }
    }
    /**
     * 
     * @param id
     * @throws NegocioException 
     */
    public void eliminarBloqueo(Long id) throws NegocioException {
        try {
            
            BloqueoEntidad bloqueo = bloqueoDAO.consultarBloqueoPorID(id);
            validarBloqueoEntidad(bloqueo);
            bloqueoDAO.eliminarBloqueo(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al eliminar la carrera.", ex);
        }
    }

    /**
     * 
     * @param bloqueo
     * @throws NegocioException 
     */
    private void validarBloqueo(BloqueoNegocio bloqueo) throws NegocioException {
        if (bloqueo.getFechaDeBloqueo() == null) {
            throw new NegocioException("El bloqueo debe tener fecha");
        }
    }
    
    /**
     * 
     * @param bloqueo
     * @throws NegocioException 
     */
    private void validarBloqueoEntidad(BloqueoEntidad bloqueo) throws NegocioException {
        if (bloqueo == null) {
            throw new NegocioException("Bloqueo vacio");
        }
    }
}
