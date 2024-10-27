/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Entidades.ComputadoraSoftwareEntidad;
import Entidades.SoftwareEntidad;
import Negocio.ComputadoraSoftwareNegocio;
import Negocio.SoftwareNegocio;
import static convertidores.ComputadoraSoftwareConvetidor.convertirDTOAEntidad;
import daos.ComputadoraSoftwareDAO;
import exceptions.NegocioException;
import exceptions.PersistenciaException;
import interfaces.IComputadoraSoftwareDAO;

/**
 *
 * @author filor
 */
public class ComputadoraSoftwareService {
    private IComputadoraSoftwareDAO compuSoftwareDAO;

    public ComputadoraSoftwareService() {
    this.compuSoftwareDAO = new ComputadoraSoftwareDAO();
    }
    
    public void agregarCompuSoftware(ComputadoraSoftwareNegocio dto) throws NegocioException {
        validarCompuSoftware(dto);

        try {
            ComputadoraSoftwareEntidad entidad = convertirDTOAEntidad(dto);
            compuSoftwareDAO.agregarComputadoraSoftware(entidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar al alumno en la capa de negocio", e);
        }
    }
    
    private void validarCompuSoftware(ComputadoraSoftwareNegocio software) throws NegocioException {
        if (software.getIdPC()==null || software.getIdSoftware()==null) {
            throw new NegocioException("Las relaciones no pueden ser null");
        }
    }
}
