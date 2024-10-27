/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Entidades.CarreraEntidad;
import Entidades.ComputadoraEntidad;
import Entidades.UnidadAcademicaEntidad;
import Negocio.CarreraNegocio;
import Negocio.ComputadoraNegocio;
import Negocio.UnidadAcademicaNegocio;
import static convertidores.CarreraConvertidor.convertirDTOAEntidad;
import static convertidores.ComputadoraConvertidor.convertirDTOAEntidad;
import daos.ComputadoraDAO;
import exceptions.NegocioException;
import exceptions.PersistenciaException;
import interfaces.IComputadoraDAO;

/**
 *
 * @author filor
 */
public class ComputadoraService {

    private IComputadoraDAO pcDAO;
    
    public ComputadoraService() {
        this.pcDAO = new ComputadoraDAO();
    }

    /**
     *
     * @param dto
     * @throws NegocioException
     */
    public void agregarPC(ComputadoraNegocio dto) throws NegocioException {
        
        validarPC(dto);
        
        try {
            ComputadoraEntidad entidad = convertirDTOAEntidad(dto);
            pcDAO.agregarComputadora(entidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar la unidad en la capa de negocio", e);
        }
    }

    /**
     *
     * @param dto
     * @throws NegocioException
     */
    public void editarPC(ComputadoraNegocio dto) throws NegocioException {
        try {
            validarPC(dto);
            ComputadoraEntidad entidad = convertirDTOAEntidad(dto);
            pcDAO.editarComputadora(entidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al editar la carrera", e);
        }
    }
    
    public void eliminarPC(Long id) throws NegocioException {
        try {
            ComputadoraEntidad entidad = pcDAO.consultarPCPorID(id);
            validarPCEntidad(entidad);
            pcDAO.eliminarComputadora(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al eliminar la carrera.", ex);
        }
    }

    /**
     *
     * @param pc
     * @throws NegocioException
     */
    private void validarPC(ComputadoraNegocio pc) throws NegocioException {
        if (pc.getIp().equals("")) {
            throw new NegocioException("La IP no puede estar vacia");
        }
        if (pc.getEstatus().equals("")) {
            throw new NegocioException("El estatus no puede estar vacio");
        }
    }

    /**
     *
     * @param pc
     * @throws NegocioException
     */
    private void validarPCEntidad(ComputadoraEntidad pc) throws NegocioException {
        if (pc == null) {
            throw new NegocioException("Entidad vacia");
        }
    }
}
