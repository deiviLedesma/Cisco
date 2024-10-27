/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import Entidades.ComputadoraEntidad;
import Entidades.ComputadoraSoftwareEntidad;
import Entidades.SoftwareEntidad;
import Negocio.ComputadoraSoftwareNegocio;
import Negocio.SoftwareNegocio;
import daos.ComputadoraDAO;
import daos.SoftwareDAO;
import exceptions.PersistenciaException;
import interfaces.IComputadoraDAO;
import interfaces.ISoftwareDAO;
import java.util.List;

/**
 *
 * @author filor
 */
public class ComputadoraSoftwareConvetidor {
    private static IComputadoraDAO pcDAO;
    private static ISoftwareDAO softwareDAO;
    
    /**
     * 
     * @param dto
     * @return
     * @throws PersistenciaException 
     */
    public static ComputadoraSoftwareEntidad convertirDTOAEntidad(ComputadoraSoftwareNegocio dto) throws PersistenciaException {
        pcDAO = new ComputadoraDAO();
        softwareDAO = new SoftwareDAO();
        ComputadoraSoftwareEntidad entidad = new ComputadoraSoftwareEntidad();
        
        entidad.setId(dto.getIdPCsoftware());
        
        entidad.setComputadora(pcDAO.consultarPCPorID(dto.getIdPC()));
        entidad.setSoftware(softwareDAO.consultarSoftwarePorID(dto.getIdSoftware()));
        
        return entidad;
    }
}
