/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Entidades.BloqueoEntidad;
import Entidades.SoftwareEntidad;
import Negocio.BloqueoNegocio;
import Negocio.SoftwareNegocio;
import static convertidores.SoftwareConvertidor.convertirDTOAEntidad;
import daos.SoftwareDAO;
import exceptions.NegocioException;
import exceptions.PersistenciaException;
import interfaces.ISoftwareDAO;

/**
 *
 * @author filor
 */
public class SoftwareService {
    private ISoftwareDAO softwareDAO;

    public SoftwareService() {
    this.softwareDAO = new SoftwareDAO();
    }
    
    /**
     * 
     * @param dto
     * @throws NegocioException 
     */
    public void agregarSoftware(SoftwareNegocio dto) throws NegocioException {
        validarSoftware(dto);

        try {
            SoftwareEntidad software = convertirDTOAEntidad(dto);
            softwareDAO.agregarSoftware(software);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar al alumno en la capa de negocio", e);
        }
    }
    
    /**
     * 
     * @param software
     * @throws NegocioException 
     */
    private void validarSoftware(SoftwareNegocio software) throws NegocioException {
        if (software.getNombre().equals("")) {
            throw new NegocioException("El software debe tener nombre");
        }
    }
}
