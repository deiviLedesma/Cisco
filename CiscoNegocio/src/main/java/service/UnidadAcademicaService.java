/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Entidades.CarreraEntidad;
import Entidades.UnidadAcademicaEntidad;
import Negocio.CarreraNegocio;
import Negocio.UnidadAcademicaNegocio;
import static convertidores.UnidadAcademicaConvertidor.convertirDTOAEntidad;
import daos.UnidadAcademicaDAO;
import exceptions.NegocioException;
import exceptions.PersistenciaException;
import interfaces.IUnidadAcademicaDAO;

/**
 *
 * @author filor
 */
public class UnidadAcademicaService {
    private IUnidadAcademicaDAO unidadDAO;

    public UnidadAcademicaService() {
        this.unidadDAO = new UnidadAcademicaDAO();
    }

    public UnidadAcademicaService(IUnidadAcademicaDAO unidadDAO) {
        this.unidadDAO = unidadDAO;
    }
    
    /**
     * 
     * @param dto
     * @throws NegocioException 
     */
    public void agregarUnidad(UnidadAcademicaNegocio dto) throws NegocioException {

        validarUnidad(dto);

        try {
            UnidadAcademicaEntidad entidad = convertirDTOAEntidad(dto);
            unidadDAO.agregarUnidad(entidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar la unidad en la capa de negocio", e);
        }
    }
    
    /**
     * 
     * @param unidad
     * @throws NegocioException 
     */
    private void validarUnidad(UnidadAcademicaNegocio unidad) throws NegocioException {
        if (unidad.getNombreUnidad().equals("")) {
            throw new NegocioException("El nombre de la unidad no puede estar vacío");
        }
    }
}
