/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidores;

import Entidades.CentroDeComputoEntidad;
import Entidades.ComputadoraEntidad;
import Entidades.ComputadoraSoftwareEntidad;
import Entidades.ReservaEntidad;
import Negocio.CentroComputoNegocio;
import Negocio.ComputadoraNegocio;
import daos.CentroDeComputoDAO;
import daos.UnidadAcademicaDAO;
import exceptions.PersistenciaException;
import interfaces.ICentroDeComputoDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author filor
 */
public class ComputadoraConvertidor {
    private static ICentroDeComputoDAO centroDAO;
    
    /**
     * 
     * @param dto
     * @return
     * @throws PersistenciaException 
     */
    public static ComputadoraEntidad convertirDTOAEntidad(ComputadoraNegocio dto) throws PersistenciaException {
        centroDAO = new CentroDeComputoDAO();
        
        ComputadoraEntidad pc = new ComputadoraEntidad();

        asignarAtributosSimplesDTOaEntidad(pc, dto);
        
        pc.setCentroComputadora(centroDAO.consultarCentroPorID(dto.getIdCentro()));
        
        List<ReservaEntidad> reservas = convertirReservasIds(dto.getIdsReservas());
        pc.setReservaCompu(reservas);
        
        List<ComputadoraSoftwareEntidad> softwares = convertirSoftwaresIds(dto.getIdsSoftwares());
        pc.setComputadora(softwares);
        
        return pc;
    }
    /**
     * 
     * @param entidad
     * @param dto 
     */
    private static void asignarAtributosSimplesDTOaEntidad(ComputadoraEntidad entidad, ComputadoraNegocio dto) {
        entidad.setId(dto.getIdCompu());
        entidad.setEstatus(dto.getEstatus());
        entidad.setNombreAlumno(dto.getAlumno());
        entidad.setIP(dto.getIp());
        entidad.setNumeroMaquina(dto.getNumeroMaquina());
    }
    
    /**
     * 
     * @param ids
     * @return
     * @throws PersistenciaException 
     */
    private static List<ReservaEntidad> convertirReservasIds(List<Long> ids) throws PersistenciaException {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList(); // Devuelve una lista vacía si la lista de IDs es nula o vacía
        }

        List<ReservaEntidad> reservas = new ArrayList<>();
        for (Long pagoId : ids) {
            ReservaEntidad entidad = new ReservaEntidad();
            entidad.setId(pagoId);
            
            reservas.add(entidad);
        }
        return reservas;
    }
    
    /**
     * 
     * @param ids
     * @return
     * @throws PersistenciaException 
     */
    private static List<ComputadoraSoftwareEntidad> convertirSoftwaresIds(List<Long> ids) throws PersistenciaException {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList(); // Devuelve una lista vacía si la lista de IDs es nula o vacía
        }

        List<ComputadoraSoftwareEntidad> softwares = new ArrayList<>();
        for (Long pagoId : ids) {
            ComputadoraSoftwareEntidad entidad = new ComputadoraSoftwareEntidad();
            entidad.setId(pagoId);
            
            softwares.add(entidad);
        }
        return softwares;
    }
}
